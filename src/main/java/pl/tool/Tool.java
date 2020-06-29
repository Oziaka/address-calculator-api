package pl.tool;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tool {

  private static String fill (String obj, byte length) {
    StringBuilder text = new StringBuilder(obj);
    while (text.length() < length)
      text.insert(0, '0');
    return text.toString();
  }

  //  Min number of subnet in network should greater or equals to 2^x
  public static long minNumberOfSubnet (long numberOfSubnet) {
    int minNumberOfSubnet = 1;
    while (minNumberOfSubnet <= numberOfSubnet) minNumberOfSubnet *= 2;
    return minNumberOfSubnet;
  }

  public static byte numberOfFieldsForSubnet (long minNumberOfSubnet) {
    byte power = 0;
    while (Math.pow(2, power) != minNumberOfSubnet) power++;
    return power;
  }

  public static String fillBinaryAddress (String binaryAddress) {
    String[] binaryAddressTab = binaryAddress.split("\\.");
    StringBuilder fillBinaryAddress = new StringBuilder();
    for (int i = 0; i < binaryAddressTab.length; i++) {
      fillBinaryAddress.append(Tool.fill(binaryAddressTab[i], (byte) 8));
      if(i < 3) fillBinaryAddress.append(".");
    }
    return fillBinaryAddress.toString();
  }

  public static String toBinaryAddress (String decimalAddress) {
    return Stream.of(decimalAddress.split("\\.")).map(k -> Integer.toString(Integer.parseInt(k), 2)).collect(Collectors.joining("."));
  }

  public static String toDecimalAddress (String binaryAddress) {
    return Stream.of(binaryAddress.split("\\.")).map(k -> Integer.parseInt(k, 2) + "").collect(Collectors.joining("."));
  }

  public static String toBinaryAddress (long numberOfOnesMask) {
    StringBuilder binaryMaskAddress = new StringBuilder();
    for (int i = 0; i < 32; i++) {
      if(i < numberOfOnesMask)
        binaryMaskAddress.append("1");
      else
        binaryMaskAddress.append("0");
      if(i % 8 == 7 && i != 31)
        binaryMaskAddress.append(".");
    }
    return binaryMaskAddress.toString();
  }
}
