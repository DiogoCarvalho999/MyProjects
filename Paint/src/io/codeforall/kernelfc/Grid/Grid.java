package io.codeforall.kernelfc.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Grid implements KeyboardHandler {
    private static final int CELL_SIZE = 30;  // Tamanho de cada célula
    private static final int COLS = 20;       // Número de colunas
    private static final int ROWS = 20;       // Número de linhas
    private static final int PADDING = 10;    // Margem da grid
    private static final String SAVE_FILE = "src/io/codeforall/kernelfc/DrawingFiles/drawing.txt"; // Ficheiro para salvar o desenho
    private Keyboard keyboard;
    private int cursorRow;
    private int cursorCol;
    private Rectangle cursor;
    private List<Rectangle> paintedCells;

    public Grid() {
        drawGrid(); // Desenha a grid ao inicializar
        this.keyboard = new Keyboard(this);
        this.cursorCol = PADDING;
        this.cursorRow = PADDING;
        this.paintedCells = new ArrayList<>();
        createKeyboardEvents();
        cursorPosition();
    }

    void drawGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Rectangle cell = new Rectangle(getX(col), getY(row), CELL_SIZE, CELL_SIZE);
                cell.setColor(Color.GRAY);
                cell.draw();  // Apenas desenha as bordas
            }
        }
    }

    public void cursorPosition() {
        if (cursor != null) {
            cursor.delete();
        }
        cursor = new Rectangle(cursorCol, cursorRow, CELL_SIZE, CELL_SIZE);
        cursor.setColor(Color.GREEN);
        cursor.fill();
    }

    // Calcula a coordenada X com base na coluna
    public static int getX(int col) {
        return PADDING + col * CELL_SIZE;
    }

    // Calcula a coordenada Y com base na linha
    public static int getY(int row) {
        return PADDING + row * CELL_SIZE;
    }

    public void createKeyboardEvents() {
        int[] keys = {KeyboardEvent.KEY_RIGHT, KeyboardEvent.KEY_LEFT, KeyboardEvent.KEY_UP, KeyboardEvent.KEY_DOWN,
                KeyboardEvent.KEY_SPACE, KeyboardEvent.KEY_C, KeyboardEvent.KEY_S, KeyboardEvent.KEY_L};
        for (int key : keys) {
            KeyboardEvent keyboardEvent = new KeyboardEvent();
            keyboardEvent.setKey(key);
            keyboardEvent.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
            keyboard.addEventListener(keyboardEvent);
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (cursorCol > PADDING) cursorCol -= CELL_SIZE;
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (cursorCol < getX(COLS - 1)) cursorCol += CELL_SIZE;
                break;
            case KeyboardEvent.KEY_UP:
                if (cursorRow > PADDING) cursorRow -= CELL_SIZE;
                break;
            case KeyboardEvent.KEY_DOWN:
                if (cursorRow < getY(ROWS - 1)) cursorRow += CELL_SIZE;
                break;
            case KeyboardEvent.KEY_SPACE:
                togglePaintCell();
                break;
            case KeyboardEvent.KEY_C:
                clearAllPaintedCells();
                break;
            case KeyboardEvent.KEY_S:
                saveDrawing();
                break;
            case KeyboardEvent.KEY_L:
                loadDrawing();
                break;
        }
        cursorPosition(); // Redesenha o cursor para garantir que ele fique sobre as células pintadas
    }

    private void togglePaintCell() {
        Iterator<Rectangle> iterator = paintedCells.iterator();
        while (iterator.hasNext()) {
            Rectangle cell = iterator.next();
            if (cell.getX() == cursorCol && cell.getY() == cursorRow) {
                cell.delete(); // Remove a célula pintada
                iterator.remove();
                return;
            }
        }
        // Se não encontrou uma célula pintada, pinta uma nova
        Rectangle paintCell = new Rectangle(cursorCol, cursorRow, CELL_SIZE, CELL_SIZE);
        paintCell.fill();
        paintedCells.add(paintCell);
    }

    private void clearAllPaintedCells() {
        for (Rectangle cell : paintedCells) {
            cell.delete(); // Remove visualmente cada célula pintada
        }
        paintedCells.clear(); // Limpa a lista de células pintadas
    }

    private void saveDrawing() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(SAVE_FILE))) {
            for (Rectangle cell : paintedCells) {
                writer.write(cell.getX() + "," + cell.getY());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    private void loadDrawing() {
        clearAllPaintedCells();
        try (BufferedReader reader = new BufferedReader(new FileReader(SAVE_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                Rectangle paintCell = new Rectangle(x, y, CELL_SIZE, CELL_SIZE);
                paintCell.fill();
                paintedCells.add(paintCell);
            }
        } catch (IOException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}

