package pl.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.address.AddressDto;
import pl.address.Network;
import pl.address.NetworkAddress;
import pl.address.NetworkMask;

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
