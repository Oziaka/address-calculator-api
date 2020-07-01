package pl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dto.AddressDto;
import pl.network.Network;
import pl.network.address.Address;
import pl.network.mask.NetworkMask;

import java.util.AbstractMap;

@Service
@AllArgsConstructor
public class NetworkService {

  private NetworkMaskService networkMaskService;
  private NetworkAddressService networkAddressService;
  private AddressService addressService;

  public Network createNetwork (AddressDto addressDto) {
    NetworkMask networkMask = networkMaskService.getNetworkMask(addressDto.getMask(), addressDto.getMaskType());
    Address address = networkAddressService.getNetworkAddress(addressDto.getAddress(), addressDto.getAddressType(), networkMask);
    return Network.builder()
      .networkAddress(address)
      .networkMask(networkMask)
      .build();
  }

  public AbstractMap.SimpleEntry<Network, Address> createNetworkAndRemainAddress (AddressDto addressDto) {
    NetworkMask networkMask = networkMaskService.getNetworkMask(addressDto.getMask(), addressDto.getMaskType());
    Address networkAddress = networkAddressService.getNetworkAddress(addressDto.getAddress(), addressDto.getAddressType(), networkMask);
    Address hostAddress = addressService.getAddress(addressDto.getAddress(), addressDto.getAddressType(), networkMask);
    return new AbstractMap.SimpleEntry<>(Network.builder()
      .networkAddress(networkAddress)
      .networkMask(networkMask)
      .build(), hostAddress);
  }
}
