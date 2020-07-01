package pl.dto;

import lombok.Builder;
import lombok.Getter;
import pl.network.address.Address;

@Getter
public class NetworkAndBroadcastAddress {
  private Address address;
  private Address broadcastAddress;

  @Builder
  public NetworkAndBroadcastAddress (Address address, Address broadcastAddress) {
    this.address = address;
    this.broadcastAddress = broadcastAddress;
  }
}
