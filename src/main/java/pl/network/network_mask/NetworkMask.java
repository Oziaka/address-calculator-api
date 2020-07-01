package pl.network.network_mask;

import lombok.Builder;
import lombok.Setter;
import pl.exception.CannotFindAnyNetworkMaskException;
import pl.tool.ParserTool;

@Setter
public class NetworkMask {

  private NumberOfOnesNetworkMask numberOfOnesNetworkMask;
  private BinaryNetworkMask binaryNetworkMask;
  private DecimalNetworkMask decimalNetworkMask;

  @Builder
  public NetworkMask (NumberOfOnesNetworkMask numberOfOnesNetworkMask, BinaryNetworkMask binaryNetworkMask, DecimalNetworkMask decimalNetworkMask) {
    this.numberOfOnesNetworkMask = numberOfOnesNetworkMask;
    this.binaryNetworkMask = binaryNetworkMask;
    this.decimalNetworkMask = decimalNetworkMask;
  }

  public NumberOfOnesNetworkMask getNumberOfOnesNetworkMask () {
    if(numberOfOnesNetworkMask == null) {
      if(binaryNetworkMask != null)
        this.numberOfOnesNetworkMask = ParserTool.toNumberOfOnesNetworkMask(binaryNetworkMask);
      else if(decimalNetworkMask != null)
        this.numberOfOnesNetworkMask = ParserTool.toNumberOfOnesNetworkMask(decimalNetworkMask);
      else throw new CannotFindAnyNetworkMaskException();
    }
    return numberOfOnesNetworkMask;
  }

  public BinaryNetworkMask getBinaryNetworkMask () {
    if(binaryNetworkMask == null) {
      if(decimalNetworkMask != null)
        this.binaryNetworkMask = ParserTool.toBinaryNetworkMask(decimalNetworkMask);
      else if(numberOfOnesNetworkMask != null)
        this.binaryNetworkMask = ParserTool.toBinaryNetworkMask(numberOfOnesNetworkMask);
      else throw new CannotFindAnyNetworkMaskException();
    }
    return binaryNetworkMask;
  }

  public DecimalNetworkMask getDecimalNetworkMask () {
    if(decimalNetworkMask == null) {
      if(binaryNetworkMask != null)
        this.decimalNetworkMask = ParserTool.toDecimalNetworkMask(binaryNetworkMask);
      else if(numberOfOnesNetworkMask != null)
        this.decimalNetworkMask = ParserTool.toDecimalNetworkMask(numberOfOnesNetworkMask);
      else throw new CannotFindAnyNetworkMaskException();
    }
    return decimalNetworkMask;
  }
}

