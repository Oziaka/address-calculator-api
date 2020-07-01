package pl.mapper;

import pl.network.Network;
import pl.network.SubnetAddressesDto;

public class SubnetAddressesDtoMapper {
  public static SubnetAddressesDto toDto (Network network) {
    return SubnetAddressesDto
      .builder()
      .networkAddress(network.getNetworkAddress())
      .firstHostAddress(network.getFirstHostAddress())
      .lastHostAddress(network.getLastHostAddress())
      .broadcastAddress(network.getBroadcastAddress())
      .build();
  }
}
