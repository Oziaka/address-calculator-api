package pl.mapper;

import pl.dto.NetworkAndHosts;
import pl.network.Network;
import pl.network.address.Address;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class NetworkAndAddressDtoMapper {
  public static NetworkAndHosts toDto (Map.Entry<Network, List<Address>> map) {
    return NetworkAndHosts.builder()
      .network(NetworkMapper.toDto(map.getKey()))
      .addresses(map.getValue().stream().map(AddressMapper::toDto2).collect(Collectors.toList()))
      .build();
  }
}
