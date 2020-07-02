package pl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.dto.AddressDtoInput;
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

  public Network createNetwork (AddressDtoInput addressDtoInput) {
    NetworkMask networkMask = networkMaskService.getNetworkMask(addressDtoInput.getMask(), addressDtoInput.getMaskType());
    Address address = networkAddressService.getNetworkAddress(addressDtoInput.getAddress(), addressDtoInput.getAddressType(), networkMask);
    return Network.builder()
      .networkAddress(address)
      .networkMask(networkMask)
      .build();
  }

  public AbstractMap.SimpleEntry<Network, Address> createNetworkAndRemainAddress (AddressDtoInput addressDtoInput) {
    NetworkMask networkMask = networkMaskService.getNetworkMask(addressDtoInput.getMask(), addressDtoInput.getMaskType());
    Address networkAddress = networkAddressService.getNetworkAddress(addressDtoInput.getAddress(), addressDtoInput.getAddressType(), networkMask);
    Address hostAddress = addressService.getAddress(addressDtoInput.getAddress(), addressDtoInput.getAddressType(), networkMask);
    return new AbstractMap.SimpleEntry<>(Network.builder()
      .networkAddress(networkAddress)
      .networkMask(networkMask)
      .build(), hostAddress);
  }
}
