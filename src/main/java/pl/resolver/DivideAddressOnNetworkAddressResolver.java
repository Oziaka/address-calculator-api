package pl.resolver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import pl.dto.AddressDto;
import pl.dto.NetworkAndHosts;
import pl.mapper.NetworkAndHostsDtoMapper;
import pl.service.NetworkService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class DivideAddressOnNetworkAddressResolver {
  private NetworkService networkService;

  public List<NetworkAndHosts> resolve (List<AddressDto> addressesDto) {
    return addressesDto.stream()
      .map(networkService::createNetworkAndRemainAddress)
      .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
      .entrySet().stream().map(NetworkAndHostsDtoMapper::toDto)
      .collect(Collectors.toList());
  }
}
