package pl.network;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import pl.network.network_address.BinaryAddress;
import pl.network.network_address.NetworkAddress;
import pl.network.network_mask.NetworkMask;
import pl.tool.Tool;

@Getter
@Setter
public class Network {
  public static final Integer MAX_NUMBER_OF_SUBNET = 1073741822;
  private NetworkAddress networkAddress;
  private NetworkMask networkMask;
  private NetworkAddress broadcastAddress;

  @Builder
  public Network (NetworkAddress networkAddress, NetworkMask networkMask, NetworkAddress broadcastAddress) {
    this.networkAddress = networkAddress;
    this.networkMask = networkMask;
    this.broadcastAddress = broadcastAddress;
  }

  @Override
  public String toString () {
    return this.networkAddress.getDecimalAddress().getAddress() + " " + this.networkMask.getDecimalNetworkMask().getAddress();
  }

  public NetworkAddress getBroadcastAddress () {
    if(broadcastAddress == null)
      broadcastAddress = Tool.generateBroadcastAddress(networkAddress, networkMask);
    return broadcastAddress;
  }

  public NetworkAddress getFirstHostAddress () {
    String binaryNetworkAddressString = getNetworkAddress().getBinaryAddress().getAddress();
    return NetworkAddress.builder().binaryAddress(new BinaryAddress(binaryNetworkAddressString.substring(0, binaryNetworkAddressString.length() - 2) + "1")).build();
  }

  public NetworkAddress getLastHostAddress () {
    String binaryBroadcastAddressString = getBroadcastAddress().getBinaryAddress().getAddress();
    return NetworkAddress.builder().binaryAddress(new BinaryAddress(binaryBroadcastAddressString.substring(0, binaryBroadcastAddressString.length() - 2) + "0")).build();
  }
}


