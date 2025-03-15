package io.codeforall.bootcamp.prop;

import io.codeforall.bootcamp.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Chicken extends Prop{

    private Picture chickenIcon;
    private boolean isCaught;

    public Chicken(FieldPosition fieldPosition) {
        super(fieldPosition);
        this.chickenIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/Objects/chicken.png");
    }

    public boolean isCaught(){
        return false;
    }

    @Override
    public void initProp() {
        this.chickenIcon.draw();
    }
}
