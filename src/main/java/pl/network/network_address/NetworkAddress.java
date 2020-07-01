package pl.network.network_address;

import lombok.Builder;
import pl.tool.ParserTool;

public class NetworkAddress {
  private BinaryAddress binaryAddress;
  private DecimalAddress decimalAddress;

  @Builder
  public NetworkAddress (BinaryAddress binaryAddress, DecimalAddress decimalAddress) {
    this.binaryAddress = binaryAddress;
    this.decimalAddress = decimalAddress;
  }

  public BinaryAddress getBinaryAddress () {
    if(binaryAddress == null)
      binaryAddress = ParserTool.toBinaryAddress(decimalAddress);
    return binaryAddress;
  }

  public DecimalAddress getDecimalAddress () {
    if(decimalAddress == null)
      decimalAddress = ParserTool.toDecimalAddress(binaryAddress);
    return decimalAddress;

  }
}
