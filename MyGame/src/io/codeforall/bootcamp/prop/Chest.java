package io.codeforall.bootcamp.prop;

import io.codeforall.bootcamp.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Chest extends Prop implements Openable {
    private Picture chestIcon;
    private boolean isOpen;
    private boolean hasTheKey;

    public Chest(FieldPosition fieldPosition, boolean hasTheKey) {
        super(fieldPosition);
        this.chestIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/Objects/chestttt50x50.png");
        this.isOpen = false;
        this.hasTheKey = hasTheKey;
    }

    @Override
    public void initProp() {
        this.chestIcon.draw();
    }

    @Override
    public void open(boolean open) {
        if (this.hasTheKey) {
            isOpen = open;
            chestIcon = new Picture(getFieldPosition().getX(), getFieldPosition().getY(), "resources/Objects/chestwithkey.png");
            this.chestIcon.draw();
            return;
        }
        isOpen = open;
        chestIcon = new Picture(getFieldPosition().getX(), getFieldPosition().getY(), "resources/Objects/openchest50x50.png");
        this.chestIcon.draw();
    }

    public void getKey() {
        if (this.hasTheKey && this.isOpen) {
            chestIcon = new Picture(getFieldPosition().getX(), getFieldPosition().getY(), "resources/Objects/openchest50x50.png");
            this.chestIcon.draw();
            return;
        }
    }

    public boolean isOpen() {
        return isOpen;
    }

    public boolean isHasTheKey() {
        return hasTheKey;
    }

    public void setHasTheKey(boolean hasTheKey) {
        this.hasTheKey = hasTheKey;
    }
}
