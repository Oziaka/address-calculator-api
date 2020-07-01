package pl.dto;

import lombok.Builder;
import lombok.Getter;
import pl.network.Network;
import pl.network.address.Address;

import java.util.List;


@Getter
public class NetworkAndHosts {
  private Network network;
  private List<Address> hosts;

  @Builder
  public NetworkAndHosts (Network network, List<Address> hosts) {
    this.network = network;
    this.hosts = hosts;
  }
}
