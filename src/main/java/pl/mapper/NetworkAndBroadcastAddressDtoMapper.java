package pl.mapper;

import pl.dto.NetworkAndBroadcastAddress;
import pl.network.Network;

public class NetworkAndBroadcastAddressDtoMapper {
  public static NetworkAndBroadcastAddress toDto (Network network) {
    return NetworkAndBroadcastAddress.builder()
      .address(network.getNetworkAddress())
      .broadcastAddress(network.getBroadcastAddress())
      .build();
  }
}
