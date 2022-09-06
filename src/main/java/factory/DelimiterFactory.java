package factory;

import model.CommaDelimiter;
import model.Delimiter;
import model.FileExtension;
import model.TabDelimiter;

public class DelimiterFactory {

    public static Delimiter getDelimiter(String fileExtension)
    {
        if(fileExtension == null)
        {
            return null;
        }
        else if(fileExtension.equals(FileExtension.tab.name()))
        {
            return new TabDelimiter();
        }
        else if(fileExtension.equals(FileExtension.comma.name()))
        {
            return new CommaDelimiter();
        }

        return null;
    }
}
