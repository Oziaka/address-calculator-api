package pl.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NetworkDto {
  private AddressDtoOutput networkAddress;
  private NetworkMaskDto networkMask;
  private AddressDtoOutput broadcastAddress;

  @Builder
  public NetworkDto (AddressDtoOutput networkAddress, NetworkMaskDto networkMask, AddressDtoOutput broadcastAddress) {
    this.networkAddress = networkAddress;
    this.networkMask = networkMask;
    this.broadcastAddress = broadcastAddress;
  }
}
