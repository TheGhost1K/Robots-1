package gui;

import javax.swing.*;
import java.beans.PropertyVetoException;

public abstract class SaveFrame extends JInternalFrame implements ISave {

    public SaveFrame(String title, boolean resizable, boolean closable,
                     boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
    }

    public Settings getSettings() {
        return new Settings(getTitle(), getSize(), getLocation(), isIcon(), isMaximum());
    }

    public void load(Settings settings) {
        try {
            setIcon(settings.isIconified());
            setMaximum(settings.isMaximized());
        } catch (PropertyVetoException e) {
            System.out.println(e.getMessage());
        }
        setLocation(settings.getLocation());
        setSize(settings.getDimension());
    }
}
