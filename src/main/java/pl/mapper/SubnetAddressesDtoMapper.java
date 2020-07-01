package pl.mapper;

import pl.dto.SubnetAddresses;
import pl.network.Network;

public class SubnetAddressesDtoMapper {
  public static SubnetAddresses toDto (Network network) {
    return SubnetAddresses
      .builder()
      .address(network.getNetworkAddress())
      .firstHostAddress(network.getFirstHostAddress())
      .lastHostAddress(network.getLastHostAddress())
      .broadcastAddress(network.getBroadcastAddress())
      .build();
  }
}
