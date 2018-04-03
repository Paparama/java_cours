package HW6.config.config;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ConfigReader extends BaseConfigReader{
    public static void main(String[] args) throws IOException {
        ConfigReader cr = new ConfigReader();
        File file = new File("./config.txt");
        BaseHanlder hanlder = cr.getInstance(file);
        hanlder.setConfig(file, ".");
        cr.getResult(hanlder);

    }

    protected void getResult(BaseHanlder handler) {
        for (HashMap.Entry<String, String> result: handler.getConfig().entrySet()) {
            System.out.println(result.getKey() + ": " + result.getValue());
        }
    }
}
