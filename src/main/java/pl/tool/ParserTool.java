package pl.tool;

import pl.network.address.BinaryAddress;
import pl.network.address.DecimalAddress;
import pl.network.mask.BinaryNetworkMask;
import pl.network.mask.DecimalNetworkMask;
import pl.network.mask.NumberOfOnesNetworkMask;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParserTool {

  private static String fillBinaryAddress (String binaryAddress) {
    String[] binaryAddressTab = binaryAddress.split("\\.");
    StringBuilder fillBinaryAddress = new StringBuilder();
    for (int i = 0; i < binaryAddressTab.length; i++) {
      fillBinaryAddress.append(fillBinaryPiece(binaryAddressTab[i]));
      if(i < 3) fillBinaryAddress.append(".");
    }
    return fillBinaryAddress.toString();
  }

  public static BinaryAddress fill (BinaryAddress binaryAddress) {
    return new BinaryAddress(fillBinaryAddress(binaryAddress.getAddress()));

  }

  public static BinaryNetworkMask fill (BinaryNetworkMask binaryNetworkMask) {
    return new BinaryNetworkMask(fillBinaryAddress(binaryNetworkMask.getAddress()));
  }

  private static String fillBinaryPiece (String toFill) {
    StringBuilder text = new StringBuilder(toFill);
    while (text.length() < 8)
      text.insert(0, '0');
    return text.toString();
  }

  public static BinaryAddress toBinaryAddress (DecimalAddress decimalAddress) {
    return new BinaryAddress(toBinary(decimalAddress.getAddress()));
  }

  public static BinaryNetworkMask toBinaryNetworkMask (DecimalNetworkMask decimalAddress) {
    return new BinaryNetworkMask(toBinary(decimalAddress.getAddress()));
  }

  public static DecimalNetworkMask toDecimalNetworkMask (BinaryNetworkMask binaryNetworkMask) {
    return new DecimalNetworkMask(toDecimal(binaryNetworkMask.getAddress()));
  }

  public static DecimalAddress toDecimalAddress (BinaryAddress binaryAddress) {
    return new DecimalAddress(toDecimal(binaryAddress.getAddress()));
  }

  public static DecimalNetworkMask toDecimalNetworkMask (NumberOfOnesNetworkMask numberOfOnesNetworkMask) {
    return new DecimalNetworkMask(toDecimal(toBinary(numberOfOnesNetworkMask.getAddress())));
  }

  public static BinaryNetworkMask toBinaryNetworkMask (NumberOfOnesNetworkMask numberOfOnesNetworkMask) {
    return new BinaryNetworkMask(toBinary(numberOfOnesNetworkMask.getAddress()));
  }

  public static NumberOfOnesNetworkMask toNumberOfOnesNetworkMask (BinaryNetworkMask binaryNetworkMask) {
    return new NumberOfOnesNetworkMask(toNumberOfOnes(binaryNetworkMask.getAddress()));
  }

  public static NumberOfOnesNetworkMask toNumberOfOnesNetworkMask (DecimalNetworkMask decimalNetworkMask) {
    return new NumberOfOnesNetworkMask(toNumberOfOnes(toBinary(decimalNetworkMask.getAddress())));
  }

  private static String toBinary (String decimal) {
    return Stream.of(decimal.split("\\.")).map(k -> Integer.toString(Integer.parseInt(k), 2) + "").collect(Collectors.joining("."));
  }

  private static String toDecimal (String binary) {
    return Stream.of(binary.split("\\.")).map(k -> Integer.parseInt(k, 2) + "").collect(Collectors.joining("."));
  }

  private static byte toNumberOfOnes (String binary) {
    return (byte) Arrays.stream(binary.split("")).filter(l -> !l.equals(".") && !l.equals("0")).count();
  }

  private static String toBinary (byte numberOfOnes) {
    StringBuilder binaryMaskAddress = new StringBuilder();
    for (int i = 0; i < 32; i++) {
      if(i < numberOfOnes)
        binaryMaskAddress.append("1");
      else
        binaryMaskAddress.append("0");
      if(i % 8 == 7 && i != 31)
        binaryMaskAddress.append(".");
    }
    return binaryMaskAddress.toString();
  }
}
