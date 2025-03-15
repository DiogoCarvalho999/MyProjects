package io.codeforall.bootcamp.prop;

import io.codeforall.bootcamp.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Door extends Prop implements Openable {

    private Picture doorIcon;
    private boolean isOpen;
    public Door(FieldPosition fieldPosition) {
        super(fieldPosition);
        isOpen = false;
        doorIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/Objects/theDoor_resized.png");
    }

    public boolean isOpen() {
        return isOpen;
    }

    @Override
    public void initProp() {
        this.doorIcon.draw();
    }

    @Override
    public void open(boolean open) {
        isOpen = open;
        doorIcon.delete();
        doorIcon = new Picture(getFieldPosition().getX(), getFieldPosition().getY(), "resources/Objects/theDoorOpen_resized.png");
        this.doorIcon.draw();
    }
}
