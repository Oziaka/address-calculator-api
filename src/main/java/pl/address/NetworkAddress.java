package pl.address;

import pl.validator.address.BinaryAddress;
import pl.validator.address.DecimalAddress;

public class NetworkAddress extends Address {
  public NetworkAddress (@DecimalAddress(message = "{no.valid.decimal.address}") String decimalNetworkAddress, @BinaryAddress(message = "{no.valid.binary.address}") String binaryNetworkAddress) {
    super();
    super.setBinaryAddress(binaryNetworkAddress);
    super.setDecimalAddress(decimalNetworkAddress);
  }
}
