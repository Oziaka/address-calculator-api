package pl.service;

import org.springframework.stereotype.Service;
import pl.network.AbstractAddress;
import pl.network.Network;
import pl.network.address.Address;
import pl.network.address.BinaryAddress;
import pl.network.mask.NetworkMask;
import pl.network.mask.NumberOfOnesNetworkMask;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubnetFactoryService {
  public List<Network> createSubnet (Network network, byte numberOfFieldsForSubnet) {
    int numberOfSubnet = (int) Math.pow(2, numberOfFieldsForSubnet);
    List<Network> subnet = new ArrayList<>();
    for (int i = 0; i < numberOfSubnet; i++)
      subnet.add(generateSubnet(network, i, numberOfFieldsForSubnet));
    return subnet;
  }

  private Network generateSubnet (Network network, int i, byte numberOfFieldsForSubnet) {
    Address subnetAddress = generateSubnetNetworkAddress(network, i, numberOfFieldsForSubnet);
    NetworkMask subnetNetworkMask = generateSubnetNetworkMask(network, numberOfFieldsForSubnet);
    return Network.builder()
      .networkAddress(subnetAddress)
      .networkMask(subnetNetworkMask)
      .build();
  }

  private Address generateSubnetNetworkAddress (Network network, int i, byte numberOfFieldsForSubnet) {
    StringBuilder binaryNetworkAddressString = new StringBuilder(AbstractAddress.MAX_ADDRESS_LENGTH);
    binaryNetworkAddressString.append(network.getNetworkAddress().getBinaryAddress().getAddress().replace(".", "").substring(0, network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress()));
    StringBuilder num = new StringBuilder(Integer.toString(i, 2));
    while (num.length() < numberOfFieldsForSubnet) num.insert(0, "0");
    binaryNetworkAddressString.append(num);
    while (binaryNetworkAddressString.length() < AbstractAddress.MAX_ADDRESS_WITH_OUT_DOTS_LENGTH)
      binaryNetworkAddressString.append("0");
    for (int j = 8; j < 32; j += 9)
      binaryNetworkAddressString.insert(j, '.');
    return Address.builder().binaryAddress(new BinaryAddress(binaryNetworkAddressString.toString())).build();
  }

  private NetworkMask generateSubnetNetworkMask (Network network, byte numberOfFieldsForSubnet) {
    return NetworkMask.builder().numberOfOnesNetworkMask(new NumberOfOnesNetworkMask((byte) (network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress() + numberOfFieldsForSubnet))).build();
  }
}
