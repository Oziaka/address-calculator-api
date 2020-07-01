package pl.service;

import org.springframework.stereotype.Service;
import pl.network.Type;
import pl.exception.UndefinedTypeException;
import pl.network.network_mask.BinaryNetworkMask;
import pl.network.network_mask.DecimalNetworkMask;
import pl.network.network_mask.NetworkMask;
import pl.network.network_mask.NumberOfOnesNetworkMask;

@Service
public class NetworkMaskService {
  public NetworkMask getNetworkMask (String mask, Type maskType) {
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
