package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FileParserServiceTest {

    @Test
    @DisplayName("Given an input file with the extension of \"tab\" and multiple lines of tab-delimited tokens, when the " +
            "file is parsed with the FileParserService, then assert that the FileParserService returns a string of " +
            "formatted JSON arrays separated by new lines that match expected results.")
    public void parse_tabDelimitedTokens_assertParsedStringEqualsExpectedString()
    {
        String expectedResult = "[\"This\",\"is\",\"a\",\"test\"]\r\n" +
                "[\"red\",\"green\",\"blue\"]";
        FileParserService fileParserService = new FileParserService();
        String parsed = fileParserService.parse("src/test/resources/valid-test.tab");

        Assertions.assertEquals(expectedResult, parsed);
    }

    @Test
    @DisplayName("Given an input file with the extension of \"tab\" and multiple lines of comma-delimited tokens, when " +
            "the file is parsed with theFileParserService, then assert that the FileParserService returns a " +
            "string that does not match expected results")
    public void parse_tabDelimitedTokens_assertParsedStringDoesNotEqualExpectedString()
    {
        String expectedResult = "[\"This\",\"is\",\"a\",\"test\"]\r\n" +
                "[\"red\",\"green\",\"blue\"]";

        FileParserService fileParserService = new FileParserService();
        String parsed = fileParserService.parse("src/test/resources/invalid-test.tab");

        Assertions.assertNotEquals(expectedResult, parsed);
    }

    @Test
    @DisplayName("Given an input file with the extension of \"comma\" and multiple lines of comma-delimited tokens, when the " +
            "file is parsed with the FileParserService, then assert that the FileParserService returns a string of " +
            "formatted JSON arrays separated by new lines that match expected results.")
    public void parse_commaDelimitedTokens_assertParsedStringEqualsExpectedString()
    {
        String expectedResult = "[\"This\",\"is\",\"a\",\"test\"]\r\n" +
                "[\"red\",\"green\",\"blue\"]";
        FileParserService fileParserService = new FileParserService();
        String parsed = fileParserService.parse("src/test/resources/valid-test.comma");

        Assertions.assertEquals(expectedResult, parsed);
    }

    @Test
    @DisplayName("Given an input file with the extension of \"comma\" and multiple lines of tab-delimited tokens, when " +
            "the file is parsed with theFileParserService, then assert that the FileParserService returns a " +
            "string that does not match expected results")
    public void parse_commaDelimitedTokens_assertParsedStringDoesNotEqualExpectedString()
    {
        String expectedResult = "[\"This\",\"is\",\"a\",\"test\"]\r\n" +
                "[\"red\",\"green\",\"blue\"]";

        FileParserService fileParserService = new FileParserService();
        String parsed = fileParserService.parse("src/test/resources/invalid-test.comma");

        Assertions.assertNotEquals(expectedResult, parsed);
    }

    @Test
    @DisplayName("Given a blank input file path, when the file is parsed with theFileParserService, " +
            "then assert that the FileParserService returns the message 'There was a problem with the provided input file.'")
    public void parse_blankInputFilePath_assertParsedStringDoesNotEqualExpectedString()
    {
        FileParserService fileParserService = new FileParserService();
        String parsed = fileParserService.parse("");

        Assertions.assertEquals("There was a problem with the provided input file.", parsed);
    }
}
