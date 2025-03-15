package io.codeforall.bootcamp.main;

import io.codeforall.bootcamp.field.FieldPosition;
import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.charactes.Player;
import io.codeforall.bootcamp.field.Grid;
import io.codeforall.bootcamp.rooms.*;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Game implements KeyboardHandler {
    private final Field field;
    private Player player;
    private Room[] rooms;
    private Room currentRoom;
    private Picture[] backgrounds;
    private boolean finishGame;
    private Keyboard keyboard;
    private boolean pressKeySpace;


    public Game() {
        this.field = new Field(80, 80);
        this.keyboard = new Keyboard(this);
        this.player = new Player(new FieldPosition(this.field, 40, 66));
        this.rooms = new Room[5];
        this.currentRoom = null;
        this.backgrounds = new Picture[3];
        this.finishGame = false;
        this.pressKeySpace = false;
        createKeyboardEvents();
        initBasicBackgrounds();
        initRooms();
    }

    public void initBasicBackgrounds() {
        backgrounds[0] = new Picture(field.getPADDING(), field.getPADDING(), "resources/Backgrounds/saveTheChickens.png");
        backgrounds[1] = new Picture(field.getPADDING(), field.getPADDING());
        backgrounds[2] = new Picture(field.getPADDING(), field.getPADDING());
    }

    public void initRooms() {
        rooms[0] = new FirstRoom(field.getPADDING(), this.field, this.player);
        rooms[1] = new SecondRoom(field.getPADDING(), this.field, this.player);
        rooms[2] = new ThirdRoom(field.getPADDING(), this.field, this.player);
        rooms[3] = new TransitionRoom(field.getPADDING(), this.field, this.player);
    }

    public void initGame() {

        while (!this.pressKeySpace) {
            this.backgrounds[0].draw();
        }
        this.backgrounds[0].delete();
        while (!finishGame && !this.player.isWantRestart()) {
            updateRoom();
        }
        if (finishGame) {

        }
        if (this.player.isWantRestart()) {
            this.pressKeySpace = false;
        }
    }

    public void updateRoom() {
        if (this.player.isFinishChallenge() || currentRoom == null) {
            if (currentRoom == null) {
                this.currentRoom = rooms[0];
                field.initField(currentRoom);
                this.player.initPlayer();
                return;
            }
            else if (currentRoom == rooms[0]) {
                this.player.setFinishChallenge(false);
                this.currentRoom = rooms[1];
                field.initField(currentRoom);
                updatePlayer(40, 66);
                return;
            }
           /* else if (currentRoom == rooms[1]) {
                this.player.setFinishChallenge(false);
                this.currentRoom = rooms[2];
                field.initField(currentRoom);
                updatePlayer(40, 66);
                return;
            }*/
        }
    }

    public void updatePlayer(int col, int row) {
        this.player.setFieldPosition(new FieldPosition(this.field, 40, 66));
        this.player.getPlayerIcon().delete();
        this.player.setPlayerIcon(new Picture(player.getFieldPosition().getX(), player.getFieldPosition().getY(),
                "resources/Player/kernelfront50x85.png"));
        this.player.initPlayer();
    }

    public void createKeyboardEvents() {
        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        if (keyboardEvent.getKey() == KeyboardEvent.KEY_SPACE) {
            this.pressKeySpace = true;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
    }
}
