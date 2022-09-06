package model;

import java.util.List;

public class InputFile {

    private String filePath;
    private String filename;
    private String fileExtension;

    private List<String> lines;

    public InputFile(String filePath)
    {
        this.filePath = filePath;
        this.filename = parseFilename(filePath);
        this.fileExtension = parseFileExtension(filePath);
    }

    private String parseFilename(String inputFileName)
    {
       return inputFileName.substring(0, inputFileName.indexOf(".") - 1);
    }

    private String parseFileExtension(String inputFileName)
    {
        return inputFileName.substring(inputFileName.indexOf(".") + 1);
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    @Override
    public String toString() {
        return "InputFile{" +
                "filePath='" + filePath + '\'' +
                ", filename='" + filename + '\'' +
                ", fileExtension='" + fileExtension + '\'' +
                ", lines=" + lines +
                '}';
    }
}
