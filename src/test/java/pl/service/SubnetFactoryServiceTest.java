package pl.service;

import org.junit.jupiter.api.Test;
import pl.network.network_address.DecimalAddress;
import pl.network.Network;
import pl.network.network_address.NetworkAddress;
import pl.network.network_mask.DecimalNetworkMask;
import pl.network.network_mask.NetworkMask;

class SubnetFactoryServiceTest {

  @Test
  void createSubnet () {
    NetworkAddress networkAddress = NetworkAddress.builder().decimalAddress(new DecimalAddress("192.168.0.0")).build();
    NetworkMask networkMask = NetworkMask.builder().decimalNetworkMask(new DecimalNetworkMask("255.255.0.0")).build();
    SubnetFactoryService subnetFactoryService = new SubnetFactoryService();
    Network network = Network.builder().networkAddress(networkAddress).networkMask(networkMask).build();
  }
}
