package pl.network.address;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import pl.tool.ParserTool;

@EqualsAndHashCode
public class Address {
  private BinaryAddress binaryAddress;
  private DecimalAddress decimalAddress;

  @Builder
  public Address (BinaryAddress binaryAddress, DecimalAddress decimalAddress) {
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
