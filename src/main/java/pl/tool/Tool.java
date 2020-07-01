package pl.tool;

import pl.network.Address;
import pl.network.network_address.BinaryAddress;
import pl.network.network_address.NetworkAddress;
import pl.network.network_mask.NetworkMask;

public class Tool {
  //  Min number of subnet in network should greater or equals to 2^x
  public static int minNumberOfSubnet (int numberOfSubnet) {
    int minNumberOfSubnet = 1;
    while (minNumberOfSubnet <= numberOfSubnet) minNumberOfSubnet *= 2;
    return minNumberOfSubnet;
  }

  public static byte numberOfFieldsForSubnet (long minNumberOfSubnet) {
    byte power = 0;
    while (Math.pow(2, power) != minNumberOfSubnet) power++;
    return power;
  }

  public static NetworkAddress generateBroadcastAddress (NetworkAddress networkAddress, NetworkMask networkMask) {
    StringBuilder binaryBroadcastAddressString = new StringBuilder(networkAddress.getBinaryAddress().getAddress().replaceAll("\\.", "").substring(0, networkMask.getNumberOfOnesNetworkMask().getAddress()));
    while (binaryBroadcastAddressString.length() < Address.MAX_ADDRESS_WITH_OUT_DOTS_LENGTH)
      binaryBroadcastAddressString.append("1");
    for (int j = 8; j < 32; j += 9)
      binaryBroadcastAddressString.insert(j, '.');
    return NetworkAddress.builder().binaryAddress(new BinaryAddress(binaryBroadcastAddressString.toString())).build();
  }
}
