package pl.resolver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.address.AddressDto;
import pl.address.Network;
import pl.service.NetworkService;
import pl.tool.Tool;

import java.util.List;

@AllArgsConstructor
@Component
public class DivideNetworkResolver {

  private NetworkService networkService;

  public List<Network> resolve (AddressDto addressDto, long numberOfSubnet) {
    Network network = networkService.createNetwork(addressDto);
    numberOfSubnet = Tool.minNumberOfSubnet(numberOfSubnet);
    return network.getSubnet();
  }


}
