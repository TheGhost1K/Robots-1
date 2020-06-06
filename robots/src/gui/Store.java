package gui;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Store {
    private static File file = new File(System.getProperty("user.home") + "/Settings.txt");
    private static List<ISave> save = new ArrayList<>();

    public static void saveSettings() {
        try (ObjectOutputStream stream = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(file)))) {
            HashMap<String, Settings> componentsSettings = new HashMap<>();
            for (ISave s : save)
                componentsSettings.put(s.getTitle(), s.getSettings());
            stream.writeObject(componentsSettings);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loadSettings() {
        if (file.exists()) {
            try (ObjectInputStream stream = new ObjectInputStream(
                    new BufferedInputStream(new FileInputStream(file)))) {
                HashMap<String, Settings> componentsSettings =
                        (HashMap<String, Settings>) stream.readObject();
                for (ISave save : save)
                    save.load(componentsSettings.get(save.getTitle()));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void addComponentInStore(ISave component) {
        save.add(component);
    }
}
