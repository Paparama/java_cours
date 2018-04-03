package HW6.config.config;

import java.io.File;
import java.io.IOException;

public class XmlHandler extends BaseHanlder{
    @Override
    protected String[] getConfigsFromFile(File file, String symbol)throws IOException {
        return super.getConfigsFromFile(file, "\n");
    }
}
