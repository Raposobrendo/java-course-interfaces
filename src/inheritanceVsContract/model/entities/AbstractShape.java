package inheritanceVsContract.model.entities;

import inheritanceVsContract.model.enums.Color;

public abstract class AbstractShape implements Shape {

    public Color color;

    public AbstractShape(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
