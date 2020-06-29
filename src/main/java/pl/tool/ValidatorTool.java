package pl.tool;

public class ValidatorTool {

  static public boolean validBinaryAddress (String obj) {
    String[] addressTab = obj.split("\\.");
//    Needed need pattern x.x.x.x
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

  static public boolean validDecimalAddress (String obj) {
    String[] addressTab = obj.split("\\.");
//    Needed need pattern x.x.x.x
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

  static public boolean validBinaryMask (String obj) {
    if(!validBinaryAddress(obj))
      return false;
    return Tool.fillBinaryAddress(obj).replace(".", "").matches("[1]+[0]+");
  }

  static public boolean validDecimalMask (String obj) {
    if(!validDecimalAddress(obj))
      return false;
    return Tool.fillBinaryAddress(Tool.toBinaryAddress(obj)).replace(".", "").matches("[1]+[0]+");

  }

  public static boolean validNumberOfOnesMask (long obj) {
    return obj > 0 && obj < 32;
  }
}
