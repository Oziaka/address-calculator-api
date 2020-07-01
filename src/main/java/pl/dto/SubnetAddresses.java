package pl.dto;

import lombok.Builder;
import lombok.Getter;
import pl.network.address.Address;

@Getter
public class SubnetAddresses {
  private Address address;
  private Address broadcastAddress;
  private Address firstHostAddress;
  private Address lastHostAddress;

  @Builder
  public SubnetAddresses (Address address, Address broadcastAddress, Address firstHostAddress, Address lastHostAddress) {
    this.address = address;
    this.broadcastAddress = broadcastAddress;
    this.firstHostAddress = firstHostAddress;
    this.lastHostAddress = lastHostAddress;
  }
}
