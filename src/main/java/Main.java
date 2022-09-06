import service.FileParserService;

public class Main {
    public static void main(String[] args) {

        if(args == null || args[0].trim().isEmpty())
        {
            throw new ArrayIndexOutOfBoundsException("You must specify a valid input file.");
        }
        else
        {
            FileParserService fileParserService = new FileParserService();
            String parsedStrings = fileParserService.parse(args[0]);
            System.out.println(parsedStrings);
        }
    }
}