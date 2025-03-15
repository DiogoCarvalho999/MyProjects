package io.codeforall.bootcamp.prop;

import io.codeforall.bootcamp.field.FieldPosition;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Snake extends Prop{
    private Picture snakeIcon;
    public Snake(FieldPosition fieldPosition) {
        super(fieldPosition);
        this.snakeIcon = new Picture(fieldPosition.getX(), fieldPosition.getY(), "resources/Objects/snake50x50.png");
    }

    @Override
    public void initProp() {
        this.snakeIcon.draw();
    }

    @Override
    public FieldPosition getFieldPosition() {
        return super.getFieldPosition();
    }
}
