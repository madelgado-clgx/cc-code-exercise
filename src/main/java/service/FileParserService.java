package service;

import factory.DelimiterFactory;
import model.Delimiter;
import model.InputFile;
import org.json.JSONArray;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FileParserService {

    /**
     * Parse the contents of the input file into string of JSON array
     * @param inputFileString
     * @return String of JSON arrays.
     */
    public String parse(String inputFileString)
    {
        InputFile inputFile;
        String parsedOutput = "";

        try
        {
            inputFile = new InputFile(inputFileString);
        }
        catch(IndexOutOfBoundsException e)
        {
            System.out.println(e);
            return "There was a problem with the provided input file.";
        }

        try
        {
            inputFile.setLines(Files.readAllLines(Paths.get(inputFile.getFilePath())));
        }
        catch(IOException e)
        {
            System.out.println(e);
            return "There was an error reading the provided input file.";
        }

        try
        {
            Delimiter delimiter = DelimiterFactory.getDelimiter(inputFile.getFileExtension());
            parsedOutput = buildParsedOutputWithDelimiter(inputFile.getLines(), delimiter);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return "There was an error parsing the input file";
        }

        return parsedOutput;
    }

    /**
     * Parse lines from input file with given delimiter and return formatted in JSON arrays separated by new lines
     * @param lines
     * @param delimiter
     * @return JSON Arrays formatted strings separated by new lines.
     */
    private String buildParsedOutputWithDelimiter(List<String> lines, Delimiter delimiter)
    {
        StringBuilder sb = new StringBuilder();
        int j = 1;
        for(String line : lines)
        {
            JSONArray jsonArray = new JSONArray();
            String[] parsedLine = delimiter.parseTokens(line);

            for (int i = 0; i < parsedLine.length; i++) {
                jsonArray.put(parsedLine[i]);
            }

            sb.append(jsonArray);

            if(j++ < lines.size())
            {
                sb.append(System.lineSeparator());
            }

        }

        return sb.toString();
    }
}
