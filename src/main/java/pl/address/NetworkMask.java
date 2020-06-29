package pl.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.validator.network_mask.BinaryNetworkMask;
import pl.validator.network_mask.DecimalNetworkMask;
import pl.validator.network_mask.NumberOfOnesNetworkMask;

@Getter
@Setter
public class NetworkMask extends Address {
  private byte maskInNumberOfOnes;

  @Builder
  public NetworkMask (@NumberOfOnesNetworkMask(message = "{incorrect.number_of_ones.mask") byte maskInNumberOfOnes, @DecimalNetworkMask(message = "{incorrect.decimal.mask}") String decimalMask, @BinaryNetworkMask(message = "{incorrect.binary.mask}") String binaryMask) {
    this.maskInNumberOfOnes = maskInNumberOfOnes;
    super.setDecimalAddress(decimalMask);
    super.setBinaryAddress(binaryMask);
  }
}
