package pl.resolver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dto.AddressDto;
import pl.dto.NetworkAndBroadcastAddress;
import pl.mapper.NetworkAndBroadcastAddressDtoMapper;
import pl.network.Network;
import pl.service.NetworkService;

@Controller
@AllArgsConstructor
public class CalculateNetworkAndBroadcastAddressResolver {
  private NetworkService networkService;


  public NetworkAndBroadcastAddress resolve (AddressDto addressDto) {
    Network network = networkService.createNetwork(addressDto);
    return NetworkAndBroadcastAddressDtoMapper.toDto(network);
  }
}
