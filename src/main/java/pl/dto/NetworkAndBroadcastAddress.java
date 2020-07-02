package pl.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NetworkAndBroadcastAddress {
  private AddressDtoOutput networkAddress;
  private AddressDtoOutput broadcastAddress;

  @Builder
  public NetworkAndBroadcastAddress (AddressDtoOutput networkAddress, AddressDtoOutput broadcastAddress) {
    this.networkAddress = networkAddress;
    this.broadcastAddress = broadcastAddress;
  }
}
