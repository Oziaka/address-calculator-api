package pl.service;

import org.springframework.stereotype.Service;
import pl.exception.UndefinedTypeException;
import pl.network.Type;
import pl.network.mask.BinaryNetworkMask;
import pl.network.mask.DecimalNetworkMask;
import pl.network.mask.NetworkMask;
import pl.network.mask.NumberOfOnesNetworkMask;

@Service
public class NetworkMaskService {
  NetworkMask getNetworkMask (String mask, Type maskType) {
    switch (maskType) {
      case BINARY:
        return NetworkMask.builder().binaryNetworkMask(new BinaryNetworkMask(mask)).build();
      case DECIMAL:
        return NetworkMask.builder().decimalNetworkMask(new DecimalNetworkMask(mask)).build();
      case NUMBER_OF_ONES:
        return NetworkMask.builder().numberOfOnesNetworkMask(new NumberOfOnesNetworkMask(Byte.parseByte(mask))).
          build();
      default:
        throw new UndefinedTypeException();
    }
  }
}
