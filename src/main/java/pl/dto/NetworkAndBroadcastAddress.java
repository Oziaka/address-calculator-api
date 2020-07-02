package pl.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NetworkAndBroadcastAddress {
  private AddressDtoOutput address;
  private AddressDtoOutput broadcastAddress;

  @Builder
  public NetworkAndBroadcastAddress (AddressDtoOutput address, AddressDtoOutput broadcastAddress) {
    this.address = address;
    this.broadcastAddress = broadcastAddress;
  }
}
