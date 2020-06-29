package pl.service;

import org.springframework.stereotype.Service;
import pl.address.NetworkMask;
import pl.address.Type;
import pl.exception.UndefinedTypeException;

@Service
public class NetworkMaskService {
  public NetworkMask getNetworkMask (String mask, Type maskType) {
    switch (maskType) {
      case BINARY:
        return NetworkMask.builder().binaryMask(mask).build();
      case DECIMAL:
        return NetworkMask.builder().decimalMask(mask).build();
      case NUMBER_OF_ONES:
        return NetworkMask.builder().maskInNumberOfOnes(Byte.parseByte(mask)).build();
      default:
        throw new UndefinedTypeException();
    }
  }
}
