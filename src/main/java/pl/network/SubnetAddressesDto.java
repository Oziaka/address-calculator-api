package pl.network;

import lombok.Builder;
import lombok.Getter;
import pl.network.network_address.NetworkAddress;

@Getter
public class SubnetAddressesDto {
  private NetworkAddress networkAddress;
  private NetworkAddress broadcastAddress;
  private NetworkAddress firstHostAddress;
  private NetworkAddress lastHostAddress;

  @Builder
  public SubnetAddressesDto (NetworkAddress networkAddress, NetworkAddress broadcastAddress, NetworkAddress firstHostAddress, NetworkAddress lastHostAddress) {
    this.networkAddress = networkAddress;
    this.broadcastAddress = broadcastAddress;
    this.firstHostAddress = firstHostAddress;
    this.lastHostAddress = lastHostAddress;
  }
}
