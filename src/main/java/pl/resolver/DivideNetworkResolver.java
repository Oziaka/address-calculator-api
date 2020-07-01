package pl.resolver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.exception.DoNotHaveEnoughFieldsToForSubnet;
import pl.mapper.SubnetAddressesDtoMapper;
import pl.network.AddressDto;
import pl.network.Network;
import pl.network.SubnetDto;
import pl.network.network_mask.NetworkMask;
import pl.network.network_mask.NumberOfOnesNetworkMask;
import pl.service.NetworkService;
import pl.service.SubnetFactoryService;
import pl.tool.Tool;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class DivideNetworkResolver {

  private NetworkService networkService;
  private SubnetFactoryService subnetFactoryService;

  public SubnetDto resolve (AddressDto addressDto, int numberOfSubnet, Boolean withDetails) {
    byte numberOfFieldsForSubnet = Tool.numberOfFieldsForSubnet(Tool.minNumberOfSubnet(numberOfSubnet));
    Network network = networkService.createNetwork(addressDto);
    if(withDetails) {
      whetherTheNetworkWillFitSoManySubnet(network, numberOfFieldsForSubnet);
      List<Network> subnet = subnetFactoryService.createSubnet(network, numberOfFieldsForSubnet);
      return SubnetDto.builder()
        .networkMask(subnet.get(0).getNetworkMask())
        .subnetAddressesDto(subnet.stream().map(SubnetAddressesDtoMapper::toDto).collect(Collectors.toList()))
        .numberOfSubnet((long) (Math.pow(2, numberOfFieldsForSubnet)))
        .numberOfHostsPerSubnet((long) (Math.pow(2, 32 - subnet.get(0).getNetworkMask().getNumberOfOnesNetworkMask().getAddress())))
        .build();
    } else {
      return SubnetDto.builder()
        .networkMask(NetworkMask
          .builder().numberOfOnesNetworkMask(new NumberOfOnesNetworkMask((byte) (numberOfFieldsForSubnet + network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress()))).build())
        .numberOfSubnet((long) (Math.pow(2, numberOfFieldsForSubnet)))
        .numberOfHostsPerSubnet((long) (Math.pow(2, 32 - (byte) (numberOfFieldsForSubnet + network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress()))))
        .build();
    }
  }

  private boolean whetherTheNetworkWillFitSoManySubnet (Network network, byte numberOfFieldsForSubnet) {
    if(numberOfFieldsForSubnet + network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress() < 31)
      return true;
    throw new DoNotHaveEnoughFieldsToForSubnet();
  }


}
