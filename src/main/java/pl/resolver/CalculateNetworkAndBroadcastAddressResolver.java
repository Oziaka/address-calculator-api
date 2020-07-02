package pl.resolver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dto.AddressDtoInput;
import pl.dto.NetworkAndBroadcastAddress;
import pl.mapper.NetworkAndBroadcastAddressDtoMapper;
import pl.network.Network;
import pl.service.NetworkService;

@Controller
@AllArgsConstructor
public class CalculateNetworkAndBroadcastAddressResolver {
  private NetworkService networkService;


  public NetworkAndBroadcastAddress resolve (AddressDtoInput addressDtoInput) {
    Network network = networkService.createNetwork(addressDtoInput);
    return NetworkAndBroadcastAddressDtoMapper.toDto(network);
  }
}
