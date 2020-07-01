package pl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.network.AddressDto;
import pl.network.Network;
import pl.network.network_address.NetworkAddress;
import pl.network.network_mask.NetworkMask;

@Service
@AllArgsConstructor
public class NetworkService {

  private NetworkMaskService networkMaskService;
  private NetworkAddressService networkAddressService;

  public Network createNetwork (AddressDto addressDto) {
    NetworkMask networkMask = networkMaskService.getNetworkMask(addressDto.getMask(), addressDto.getMaskType());
    NetworkAddress networkAddress = networkAddressService.getNetworkAddress(addressDto.getAddress(), addressDto.getAddressType(), networkMask);
    return Network.builder()
      .networkAddress(networkAddress)
      .networkMask(networkMask)
      .build();
  }
}
