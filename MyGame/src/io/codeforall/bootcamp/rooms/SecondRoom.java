package io.codeforall.bootcamp.rooms;

import io.codeforall.bootcamp.charactes.Player;
import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.FieldPosition;
import io.codeforall.bootcamp.field.Grid;
import io.codeforall.bootcamp.prop.Door;
import io.codeforall.bootcamp.prop.Prop;
import io.codeforall.bootcamp.prop.Snake;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SecondRoom extends Room implements KeyboardHandler {

    private Field field;
    private Snake[] snakesArray;
    private Door door;
    private Keyboard keyboard;
    private Player player;

    public SecondRoom(int padding, Field field, Player player) {
        super(padding);
        this.field = field;
        this.player = player;
        snakesArray = new Snake[5];
        this.door = new Door(new FieldPosition(field, 38, 1));
        this.keyboard = new Keyboard(this);
        //createKeyboardEvents();
    }

    @Override
    public void initRoom() {
        getBackground().draw();
        initRoomProps();
    }

    @Override
    public void initRoomProps() {
        this.door.initProp();
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
    public boolean verifyIntersection(Prop prop) {
        if (this.player.getFieldPosition().getX() + 25 > prop.getFieldPosition().getX() &&
                this.player.getFieldPosition().getX() + 25 < prop.getFieldPosition().getX() + 50 &&
                this.player.getFieldPosition().getY() + 42 > prop.getFieldPosition().getY() &&
                this.player.getFieldPosition().getY() + 42 < prop.getFieldPosition().getY() + 50) {
            return true;
        }
        return false;
    }
}
