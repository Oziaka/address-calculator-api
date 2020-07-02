package pl.resolver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dto.AddressDtoInput;
import pl.dto.NetworkAndHosts;
import pl.mapper.NetworkAndAddressDtoMapper;
import pl.network.Network;
import pl.network.address.Address;
import pl.service.NetworkService;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class DivideAddressOnNetworkAddressResolver {
  private NetworkService networkService;

  public List<NetworkAndHosts> resolve (List<AddressDtoInput> addressesDto) {
    List<AbstractMap.SimpleEntry<Network, Address>> collect = addressesDto.stream()
      .map(networkService::createNetworkAndRemainAddress).collect(Collectors.toList());
    return collect.stream().
      collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
      .entrySet().stream().map(NetworkAndAddressDtoMapper::toDto)
      .collect(Collectors.toList());
  }
}
