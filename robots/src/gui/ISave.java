package gui;

public interface ISave {
    void load(Settings settings);

    Settings getSettings();

    String getTitle();
}
