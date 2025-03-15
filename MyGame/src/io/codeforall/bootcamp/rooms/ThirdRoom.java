package io.codeforall.bootcamp.rooms;

import io.codeforall.bootcamp.charactes.Player;
import io.codeforall.bootcamp.field.Field;
import io.codeforall.bootcamp.field.FieldPosition;
import io.codeforall.bootcamp.prop.Chest;
import io.codeforall.bootcamp.prop.Chicken;
import io.codeforall.bootcamp.prop.Door;
import io.codeforall.bootcamp.prop.Prop;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class ThirdRoom extends Room implements KeyboardHandler {

    private Field field;
    private Door door;
    private Keyboard keyboard;
    private Player player;
    private Chicken[] chickensArray;

    public ThirdRoom(int padding, Field field, Player player) {
        super(padding);
        this.field = field;
        this.player = player;
        this.door = new Door(new FieldPosition(field, 38, 1));
        keyboard = new Keyboard(this);
        chickensArray = new Chicken[15];
        createKeyboardEvents();
    }



    @Override
    public void initRoomProps() {
        this.chickensArray[0] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[1] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[2] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[3] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[4] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[5] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[6] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[7] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[8] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[9] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[10] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[11] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[12] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[13] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        this.chickensArray[14] = new Chicken(new FieldPosition(field, ((int) (Math.random()*75)), ((int) (Math.random()*75))));
        for (Chicken chicken : chickensArray){
            chicken.initProp();
        }
        this.door.initProp();

    }
    @Override
    public void initRoom() {
        getBackground().draw();
        initRoomProps();
    }
    public boolean verifyIntersection(Prop prop) {
        if (prop != null) {
            if (this.player.getFieldPosition().getX() + 25 > prop.getFieldPosition().getX() &&
                    this.player.getFieldPosition().getX() + 25 < prop.getFieldPosition().getX() + 50 &&
                    this.player.getFieldPosition().getY() + 42 > prop.getFieldPosition().getY() &&
                    this.player.getFieldPosition().getY() + 42 < prop.getFieldPosition().getY() + 50) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public Picture getBackground() {
        return super.getBackground();
    }

    public void createKeyboardEvents(){

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
