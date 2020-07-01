package pl.service;

import org.springframework.stereotype.Service;
import pl.exception.IncorrectAddressTypeException;
import pl.network.Type;
import pl.network.address.Address;
import pl.network.address.BinaryAddress;
import pl.network.address.DecimalAddress;
import pl.network.mask.NetworkMask;

@Service
public class AddressService {

  Address getAddress (String address, Type addressType, NetworkMask networkMask) {
    switch (addressType) {
      case DECIMAL:
        return Address.builder().decimalAddress(new DecimalAddress(address)).build();
      case BINARY:
        return Address.builder().binaryAddress(new BinaryAddress(address)).build();
      default:
        throw new IncorrectAddressTypeException();
    }
  }
}
