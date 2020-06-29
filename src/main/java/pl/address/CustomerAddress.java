package pl.address;

import pl.validator.address.BinaryAddress;
import pl.validator.address.DecimalAddress;

public class CustomerAddress extends Address {
  public CustomerAddress (@DecimalAddress(message = "{no.valid.decimal.network.address}") String decimalNetworkAddress, @BinaryAddress(message = "{no.valid.binary.network.address}") String binaryCustomerAddress) {
    super();
    super.setBinaryAddress(binaryCustomerAddress);
    super.setDecimalAddress(decimalNetworkAddress);
  }
}
