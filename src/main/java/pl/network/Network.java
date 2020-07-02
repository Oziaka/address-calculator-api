package pl.network;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import pl.network.address.Address;
import pl.network.address.BinaryAddress;
import pl.network.mask.NetworkMask;

@Getter
@EqualsAndHashCode
public class Network {
  private Address networkAddress;
  private NetworkMask networkMask;
  private Address broadcastAddress;

  @Builder
  public Network (Address networkAddress, NetworkMask networkMask, Address broadcastAddress) {
    this.networkAddress = networkAddress;
    this.networkMask = networkMask;
    this.broadcastAddress = broadcastAddress;
  }

  private static Address generateBroadcastAddress (Address address, NetworkMask networkMask) {
    StringBuilder binaryBroadcastAddressString = new StringBuilder(address.getBinaryAddress().getAddress().replaceAll("\\.", "").substring(0, networkMask.getNumberOfOnesNetworkMask().getAddress()));
    while (binaryBroadcastAddressString.length() < AbstractAddress.MAX_ADDRESS_WITH_OUT_DOTS_LENGTH)
      binaryBroadcastAddressString.append("1");
    for (int j = 8; j < 32; j += 9)
      binaryBroadcastAddressString.insert(j, '.');
    return Address.builder().binaryAddress(new BinaryAddress(binaryBroadcastAddressString.toString())).build();
  }

  public Address getBroadcastAddress () {
    if(broadcastAddress == null)
      broadcastAddress = generateBroadcastAddress(networkAddress, networkMask);
    return broadcastAddress;
  }

  public Address getFirstHostAddress () {
    String binaryNetworkAddressString = getNetworkAddress().getBinaryAddress().getAddress();
    return Address.builder().binaryAddress(new BinaryAddress(binaryNetworkAddressString.substring(0, binaryNetworkAddressString.length() - 1) + "1")).build();
  }

  public Address getLastHostAddress () {
    String binaryBroadcastAddressString = getBroadcastAddress().getBinaryAddress().getAddress();
    return Address.builder().binaryAddress(new BinaryAddress(binaryBroadcastAddressString.substring(0, binaryBroadcastAddressString.length() - 1) + "0")).build();
  }
}


