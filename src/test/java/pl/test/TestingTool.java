package pl.test;

import java.util.Random;

public class TestingTool {
  public static String randomBinaryAddress () {
    StringBuilder binaryAddress = new StringBuilder();
    Random random = new Random();
    for (int i = 0; i < 4; i++) {
      binaryAddress.append(Integer.toString(random.nextInt(256) - 1, 2));
      if(i != 3)
        binaryAddress.append(".");
    }
    return binaryAddress.toString();
  }
}
