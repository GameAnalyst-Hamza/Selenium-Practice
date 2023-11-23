package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtils {

  public static Properties getProps(String fileName) {
    Properties myProps = new Properties();
    try {
      File propFile = new File(
        "C:\\Users\\devha\\OneDrive\\Desktop\\Selenium\\myTestProject\\src\\test\\resources\\" +
        fileName +
        ".properties"
      );
      if (propFile.exists()) {
        myProps.load(new FileInputStream(propFile));
      } else {
        System.out.println("File not Found - " + fileName);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return myProps;
  }
}
