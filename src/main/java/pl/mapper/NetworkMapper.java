package pl.mapper;

import pl.dto.NetworkDto;
import pl.network.Network;

public class NetworkMapper {
  public static NetworkDto toDto (Network network) {
    return NetworkDto.builder()
      .networkAddress(AddressMapper.toDto2(network.getNetworkAddress()))
      .networkMask(NetworkMaskMapper.toDto(network.getNetworkMask()))
      .broadcastAddress(AddressMapper.toDto2(network.getBroadcastAddress()))
      .build();
  }
}
