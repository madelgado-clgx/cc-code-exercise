package model;

public enum FileExtension {
    tab("\t"),
    comma(",");

    public final String label;
    FileExtension(String label) {
        this.label = label;
    }
}
