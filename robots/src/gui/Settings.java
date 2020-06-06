package gui;

import java.awt.*;
import java.io.Serializable;

public class Settings implements Serializable {

    private String title;
    private boolean iconified;
    private boolean maximized;
    private Dimension dimension;
    private Point location;

    public Settings(String title, Dimension dimension, Point location, boolean iconified, boolean maximized) {
        this.title = title;
        this.iconified = iconified;
        this.maximized = maximized;
        this.dimension = dimension;
        this.location = location;
    }

    public boolean isIconified() {
        return iconified;
    }

    public void setIconified(boolean iconified) {
        this.iconified = iconified;
    }

    public boolean isMaximized() {
        return maximized;
    }

    public void setMaximized(boolean maximized) {
        this.maximized = maximized;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }
}
