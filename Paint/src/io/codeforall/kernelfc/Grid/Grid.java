package io.codeforall.kernelfc.Grid;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Grid implements KeyboardHandler{
    private static final int CELL_SIZE = 30;  // Tamanho de cada célula
    private static final int COLS = 20;       // Número de colunas
    private static final int ROWS = 20;       // Número de linhas
    private static final int PADDING = 10;    // Margem da grid
    private Keyboard keyboard;
    private boolean isPainted;
    private int cursorRow;
    private int cursorCol;
    private Rectangle cursor;
    private Rectangle cell;
    private static Rectangle paintCell;
    private Rectangle[] paintedCells;
    private int paintedCellNum;

    public Grid() {
        drawGrid();// Desenha a grid ao inicializar
        this.keyboard = new Keyboard(this);
        this.cursorCol = PADDING;
        this.cursorRow = PADDING;
        this.isPainted = false;
        createKeyboardEvents();
        cursorPosition();
    }

    void drawGrid() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                this.cell = new Rectangle(getX(col), getY(row), CELL_SIZE, CELL_SIZE);
                cell.setColor(Color.GRAY);
                cell.draw();  // Apenas desenha as bordas
            }
        }
    }

    public void cursorPosition() {
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

    public int getCursorRow() {
        return cursorRow;
    }

    public int getCursorCol() {
        return cursorCol;
    }

    public void setCursorRow(int cursorRow) {
        this.cursorRow = cursor.getY();
    }

    public void setCursorCol(int cursorCol) {
        this.cursorCol = cursor.getX();
    }

    public void createKeyboardEvents() {

        KeyboardEvent keyboardEventRight = new KeyboardEvent();
        keyboardEventRight.setKey(KeyboardEvent.KEY_RIGHT);
        keyboardEventRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventRight);

        KeyboardEvent keyboardEventLeft = new KeyboardEvent();
        keyboardEventLeft.setKey(KeyboardEvent.KEY_LEFT);
        keyboardEventLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventLeft);

        KeyboardEvent keyboardEventUp = new KeyboardEvent();
        keyboardEventUp.setKey(KeyboardEvent.KEY_UP);
        keyboardEventUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventUp);

        KeyboardEvent keyboardEventDown = new KeyboardEvent();
        keyboardEventDown.setKey(KeyboardEvent.KEY_DOWN);
        keyboardEventDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventDown);

        KeyboardEvent keyboardEventSPACE = new KeyboardEvent();
        keyboardEventSPACE.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSPACE.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSPACE);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int distanceToMove = CELL_SIZE;
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (cursor.getX() <= PADDING) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -CELL_SIZE;
                }
                this.cursor.translate(distanceToMove, 0);
                this.setCursorCol(cursorCol);
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (cursor.getX() >= CELL_SIZE * COLS - COLS) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = CELL_SIZE;
                }
                this.cursor.translate(distanceToMove, 0);
                this.setCursorCol(cursorCol);
                break;
            case KeyboardEvent.KEY_UP:
                if (cursor.getY() <= CELL_SIZE) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -CELL_SIZE;
                }
                this.cursor.translate(0, distanceToMove);
                this.setCursorRow(cursorRow);
                break;
            case KeyboardEvent.KEY_DOWN:
                if (cursor.getY() >= CELL_SIZE * ROWS - ROWS) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = CELL_SIZE;
                }
                this.cursor.translate(0, distanceToMove);
                this.setCursorRow(cursorRow);
                break;
            case KeyboardEvent.KEY_SPACE:
                //while ( keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {}
                //paintedCells = new Rectangle[ROWS*COLS];
                /*paintedCells[paintedCellNum] = new Rectangle(cursorCol, cursorRow, CELL_SIZE, CELL_SIZE);
                paintedCells[paintedCellNum].fill();*/
                paintCell = new Rectangle(cursorCol, cursorRow, CELL_SIZE, CELL_SIZE);
                paintCell.fill();
                cursor.delete();
                cursorPosition();
                //this.paintedCellNum ++;
                if (paintCell.isFilled()) {
                    paintCell = new Rectangle(cursorCol, cursorRow, CELL_SIZE, CELL_SIZE);
                    paintCell.setColor(Color.GRAY);
                    paintCell.draw();
                }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
