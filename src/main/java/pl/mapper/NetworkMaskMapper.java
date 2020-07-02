package pl.mapper;

import pl.dto.NetworkMaskDto;
import pl.network.mask.NetworkMask;

public class NetworkMaskMapper {
  public static NetworkMaskDto toDto (NetworkMask networkMask) {
    return NetworkMaskDto.builder()
      .numberOfOnes(networkMask.getNumberOfOnesNetworkMask().getAddress())
      .binary(networkMask.getBinaryNetworkMask().getAddress())
      .decimal(networkMask.getDecimalNetworkMask().getAddress())
      .build();
  }
}
