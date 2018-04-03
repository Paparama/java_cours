package HW6.config.config;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class BaseHanlder {
    HashMap<String, String> config = new HashMap<>();

    protected String[] getConfigsFromFile(File file, String symbol)throws IOException {
        FileReader reader = new FileReader(file.getPath());
        StringBuilder result = new StringBuilder();
        int c;
        while ((c = reader.read()) != -1) {
            result.append((char) c);
        }
        return result.toString().split(symbol);
    }

    protected void setConfig(File file, String symbol) throws IOException {
        String[] result = getConfigsFromFile(file, symbol);
        String[] keyValue = null;
        for (int i = 0; i < result.length; i ++) {
            keyValue = result[i].split(":");
            config.put(keyValue[0], keyValue[1]);
        }

    }

    protected HashMap<String, String> getConfig() {
        return this.config;
    }
}
