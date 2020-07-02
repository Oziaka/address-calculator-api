package pl.mapper;

import pl.dto.NetworkAndBroadcastAddress;
import pl.network.Network;

public class NetworkAndBroadcastAddressDtoMapper {
  public static NetworkAndBroadcastAddress toDto (Network network) {
    return NetworkAndBroadcastAddress.builder()
      .address(AddressMapper.toDto2(network.getNetworkAddress()))
      .broadcastAddress(AddressMapper.toDto2(network.getBroadcastAddress()))
      .build();
  }
}
