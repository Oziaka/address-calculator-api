package pl.address;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Network {
  public static final Integer MAX_NUMBER_OF_SUBNET = 1073741822;
  private NetworkAddress networkAddress;
  private NetworkMask networkMask;
  private List<NetworkAddress> customerAddresses;
  private NetworkAddress broadcastAddress;
  private List<Network> subnet;

  public Network () {
  }

  @Builder
  public Network (NetworkAddress networkAddress, NetworkMask networkMask, List<NetworkAddress> customerAddresses, NetworkAddress broadcastAddress, List<Network> subnet) {
    this.networkAddress = networkAddress;
    this.networkMask = networkMask;
    this.customerAddresses = customerAddresses;
    this.broadcastAddress = broadcastAddress;
    this.subnet = subnet;
  }
}
