package HW6.config.config;

import java.io.File;
import java.util.Arrays;

abstract class BaseConfigReader {

    protected BaseHanlder getInstance(File file) {
        String type = "";
        int i = file.getName().lastIndexOf('.');
        if (i > 0) {
            type = file.getName().substring(i + 1);
        }
        switch (type) {
            case "json": {
                return new JsonHandler();
            }
            case "xml": {
                return new XmlHandler();
            }
            case "txt": {
                return new TxtHandler();
            }
            default: {
                return new BaseHanlder();
            }
        }
    }
}
