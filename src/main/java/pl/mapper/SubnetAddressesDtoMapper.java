package pl.mapper;

import pl.dto.SubnetAddresses;
import pl.network.Network;

public class SubnetAddressesDtoMapper {
  public static SubnetAddresses toDto (Network network) {
    return SubnetAddresses
      .builder()
      .networkAddress(AddressMapper.toDto2(network.getNetworkAddress()))
      .firstHostAddress(AddressMapper.toDto2(network.getFirstHostAddress()))
      .lastHostAddress(AddressMapper.toDto2(network.getLastHostAddress()))
      .broadcastAddress(AddressMapper.toDto2(network.getBroadcastAddress()))
      .build();
  }
}
