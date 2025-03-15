package io.codeforall.bootcamp.charactes;

import io.codeforall.bootcamp.field.FieldPosition;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Player extends Character implements KeyboardHandler {
    private Picture playerIcon;
    // 50 X 85
    private FieldPosition fieldPosition;
    private boolean finishChallenge;
    private boolean hasKey;
    private Keyboard keyboard;
    private boolean isAlive;
    private boolean wantRestart;

    public Player(FieldPosition fieldPosition) {
        this.playerIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/Player/kernelfront50x85.png");
        this.fieldPosition = fieldPosition;
        this.isAlive = true;
        this.wantRestart = false;
        this.finishChallenge = false;
        this.hasKey = false;
        this.keyboard = new Keyboard(this);
        createKeyboardEvents();
    }

    public void initPlayer() {
        this.playerIcon.draw();
    }

    public boolean isWantRestart() {
        return wantRestart;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void killPlayer() {
        this.playerIcon.delete();
        this.playerIcon = new Picture(this.fieldPosition.getX(), this.fieldPosition.getY(),
                "resources/Player/fallen.png");
        this.playerIcon.draw();
        this.isAlive = false;
    }

    public void movementAppearance(KeyboardEvent keyboardEvent, int distanceToMove, int steps) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                break;
            case KeyboardEvent.KEY_RIGHT:
                break;
            case KeyboardEvent.KEY_UP:
                break;
            case KeyboardEvent.KEY_DOWN:
                break;
        }

    }

    public FieldPosition getFieldPosition() {
        return fieldPosition;
    }

    public void setFieldPosition(FieldPosition fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public boolean isFinishChallenge() {
        return finishChallenge;
    }

    public void setFinishChallenge(boolean finishChallenge) {
        this.finishChallenge = finishChallenge;
    }

    public Picture getPlayerIcon() {
        return playerIcon;
    }

    public void setPlayerIcon(Picture playerIcon) {
        this.playerIcon = playerIcon;
    }

    public boolean isHasKey() {
        return hasKey;
    }

    public void setHasKey(boolean hasKey) {
        this.hasKey = hasKey;
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

        KeyboardEvent keyboardEventSpace = new KeyboardEvent();
        keyboardEventSpace.setKey(KeyboardEvent.KEY_SPACE);
        keyboardEventSpace.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(keyboardEventSpace);
    }

    //Falta adicionar as imagens do player virado para a esquerda, direita e cima
    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                this.playerIcon.delete();
                this.playerIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "imagem boneco para baixo");
                this.playerIcon.draw();
                break;
            case KeyboardEvent.KEY_RIGHT:
                this.playerIcon.delete();
                this.playerIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "imagem boneco para a esquerda");
                this.playerIcon.draw();
                break;
            case KeyboardEvent.KEY_UP:
                this.playerIcon.delete();
                this.playerIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "imagem boneco para cima");
                this.playerIcon.draw();
                break;
            case KeyboardEvent.KEY_DOWN:
                this.playerIcon.delete();
                this.playerIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/kernelfront50x85.png");
                this.playerIcon.draw();
                break;
            case KeyboardEvent.KEY_SPACE:
                if (this.isAlive = false) {
                    this.wantRestart = true;
                }
        }
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int distanceToMove;
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                if (fieldPosition.getX() <= 60) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -10;
                }
                this.playerIcon.translate(distanceToMove, 0);
                this.fieldPosition.setX(this.playerIcon.getX());
                break;
            case KeyboardEvent.KEY_RIGHT:
                if (fieldPosition.getX() >= 710) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = 10;
                }
                this.playerIcon.translate(distanceToMove, 0);
                this.fieldPosition.setX(this.playerIcon.getX());
                break;
            case KeyboardEvent.KEY_UP:
                if (fieldPosition.getY() == 10) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = -10;
                }
                this.playerIcon.translate(0, distanceToMove);
                this.fieldPosition.setY(this.playerIcon.getY());
                break;
            case KeyboardEvent.KEY_DOWN:
                if (fieldPosition.getY() >= 670) {
                    distanceToMove = 0;
                } else {
                    distanceToMove = 10;
                }
                this.playerIcon.translate(0, distanceToMove);
                this.fieldPosition.setY(this.playerIcon.getY());
                break;
        }
    }
}
