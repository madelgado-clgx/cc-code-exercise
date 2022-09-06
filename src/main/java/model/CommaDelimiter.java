package model;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CommaDelimiter implements Delimiter{

    /**
     * Parse tokens from the string using the comma delimiter
     * @param line
     * @return String array of parsed tokens
     */
    @Override
    public String[] parseTokens(String line) {
        StringTokenizer stringTokenizer = new StringTokenizer(line, FileExtension.comma.label);
        List<String> tokens = new ArrayList<>();
        while(stringTokenizer.hasMoreTokens())
        {
            tokens.add(stringTokenizer.nextToken().trim());
        }
        return tokens.toArray(new String[0]);
    }
}
