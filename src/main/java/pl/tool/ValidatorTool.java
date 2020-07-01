package pl.tool;

import pl.network.address.DecimalAddress;
import pl.network.mask.BinaryNetworkMask;

public class ValidatorTool {

  public static boolean validBinaryAddress (String obj) {
    String[] addressTab = obj.split("\\.");
    if(addressTab.length != 4) return false;
    for (String binaryValuePieceOfAddress : addressTab) {
      try {
        int decimalValuePieceOfAddress = Integer.parseInt(binaryValuePieceOfAddress, 2);
        if(decimalValuePieceOfAddress < 0 || decimalValuePieceOfAddress > 255) {
          return false;
        }
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }

  public static boolean validDecimalAddress (String obj) {
    String[] addressTab = obj.split("\\.");
    if(addressTab.length != 4) return false;
    for (String binaryValuePieceOfAddress : addressTab) {
      try {
        int decimalValuePieceOfAddress = Integer.parseInt(binaryValuePieceOfAddress);
        if(decimalValuePieceOfAddress < 0 || decimalValuePieceOfAddress > 255) {
          return false;
        }
      } catch (NumberFormatException e) {
        return false;
      }
    }
    return true;
  }

  public static boolean validBinaryMask (String obj) {
    if(!validBinaryAddress(obj))
      return false;
    return ParserTool.fill(new BinaryNetworkMask(obj)).getAddress().replace(".", "").matches("[1]+[0]+");
  }

  public static boolean validDecimalMask (String obj) {
    if(!validDecimalAddress(obj))
      return false;
    return ParserTool.fill(ParserTool.toBinaryAddress(new DecimalAddress(obj))).getAddress().replace(".", "").matches("[1]+[0]+");

  }

  public static boolean validNumberOfOnesMask (long obj) {
    return obj > 0 && obj < 32;
  }
}
