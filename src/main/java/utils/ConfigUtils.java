package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {

  public static Properties getProps(String fileName) {
    Properties myProps = new Properties();
    try {
      File propFile = new File(fileName + ".properties");
      if (propFile.exists()) {
        myProps.load(new FileInputStream(propFile));
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return myProps;
  }
}
