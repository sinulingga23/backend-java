package org.sinulingga.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
    public static Properties getPropertiesProject(String name) throws IOException {
        InputStream input = Config.class.getResourceAsStream(name);
        if (input == null) {
            throw new IOException("File Not Found");
        }

        Properties properties = new Properties();
        properties.load(input);
        return properties;
    }

}
