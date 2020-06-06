package gui;

import javax.swing.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Save extends JFrame implements ISave {
    protected Settings settings;

    public Save() {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowIconified(WindowEvent e) {
                settings.setIconified(true);
                System.out.println("Iconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                settings.setIconified(false);
                if (settings.isMaximized())
                    setExtendedState(MAXIMIZED_BOTH);
                System.out.println("Deiconified");
            }
        });

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                settings.setDimension(e.getComponent().getSize());
                if (getExtendedState() == JFrame.MAXIMIZED_BOTH)
                    settings.setMaximized(true);
                else
                    settings.setMaximized(false);
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                settings.setLocation(e.getComponent().getLocation());
            }
        });
    }

    @Override
    public void load(Settings settings) {
        if (settings.isIconified())
            setExtendedState(ICONIFIED);
        else if (settings.isMaximized())
            setExtendedState(MAXIMIZED_BOTH);
        setSize(settings.getDimension());
        setLocation(settings.getLocation());
        this.settings = settings;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }
}
