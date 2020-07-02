package pl.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Getter
public class NetworkAndHosts {
  private NetworkDto network;
  private List<AddressDtoOutput> addresses;

  @Builder
  public NetworkAndHosts (NetworkDto network, List<AddressDtoOutput> addresses) {
    this.network = network;
    this.addresses = addresses;
  }
}
