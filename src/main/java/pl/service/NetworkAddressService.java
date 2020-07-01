package pl.service;

import org.springframework.stereotype.Service;
import pl.network.network_address.BinaryAddress;
import pl.network.network_address.DecimalAddress;
import pl.network.network_address.NetworkAddress;
import pl.network.Type;
import pl.exception.IncorrectAddressTypeException;
import pl.network.network_mask.BinaryNetworkMask;
import pl.network.network_mask.NetworkMask;
import pl.tool.ParserTool;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class NetworkAddressService {
  NetworkAddress getNetworkAddress (String address, Type addressType, NetworkMask networkMask) {
    switch (addressType) {
      case DECIMAL:
        return NetworkAddress.builder().decimalAddress(calculateNetworkAddress(new DecimalAddress(address), networkMask)).build();
      case BINARY:
        return NetworkAddress.builder().binaryAddress(calculateNetworkAddress(new BinaryAddress(address), networkMask)).build();
      default:
        throw new IncorrectAddressTypeException();
    }
  }

  private DecimalAddress calculateNetworkAddress (DecimalAddress decimalAddress, NetworkMask networkMask) {
    return ParserTool.toDecimalAddress(calculateNetworkAddress(ParserTool.toBinaryAddress(decimalAddress), networkMask));
  }

  private BinaryAddress calculateNetworkAddress (BinaryAddress binaryAddress, NetworkMask networkMask) {
    final BinaryAddress filledBinaryAddress = ParserTool.fill(binaryAddress);
    final BinaryNetworkMask filledBinaryNetworkMask = ParserTool.fill(networkMask.getBinaryNetworkMask());
    return new BinaryAddress(Stream.iterate(0, i -> i + 1).limit(filledBinaryAddress.getAddress().length())
      .map(i -> (filledBinaryNetworkMask.getAddress().charAt(i) == '.' ?
        '.' :
        filledBinaryNetworkMask.getAddress().charAt(i) == '1' ?
          filledBinaryAddress.getAddress().charAt(i) : '0')).map(i -> i + "").collect(Collectors.joining()));
  }
}
