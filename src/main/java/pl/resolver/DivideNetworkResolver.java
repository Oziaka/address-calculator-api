package pl.resolver;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import pl.dto.AddressDtoInput;
import pl.dto.SubnetDto;
import pl.exception.DoNotHaveEnoughFieldsToForSubnet;
import pl.mapper.NetworkMaskMapper;
import pl.mapper.SubnetAddressesDtoMapper;
import pl.network.Network;
import pl.network.mask.NetworkMask;
import pl.network.mask.NumberOfOnesNetworkMask;
import pl.service.NetworkService;
import pl.service.SubnetFactoryService;
import pl.tool.Tool;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Controller
@Validated

public class DivideNetworkResolver {

  private NetworkService networkService;
  private SubnetFactoryService subnetFactoryService;

  public SubnetDto resolve (AddressDtoInput addressDtoInput, int numberOfSubnet, boolean withSubnet) {
    byte numberOfFieldsForSubnet = Tool.numberOfFieldsForSubnet(Tool.minNumberOfSubnet(numberOfSubnet));
    Network network = networkService.createNetwork(addressDtoInput);
    whetherTheNetworkWillFitSoManySubnet(network, numberOfFieldsForSubnet);
    SubnetDto.SubnetDtoBuilder subnetDtoBuilder = SubnetDto.builder()
      .networkMask(NetworkMaskMapper.toDto(NetworkMask.builder().numberOfOnesNetworkMask(new NumberOfOnesNetworkMask((byte) (numberOfFieldsForSubnet + network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress()))).build()))
      .numberOfSubnet((long) (Math.pow(2, numberOfFieldsForSubnet)))
      .numberOfHostsPerSubnet((long) (Math.pow(2, 32 - (byte) (numberOfFieldsForSubnet + network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress()))));
    if(withSubnet) {
      List<Network> subnet = subnetFactoryService.createSubnet(network, numberOfFieldsForSubnet);
      return subnetDtoBuilder
        .subnetAddresses(subnet.stream().map(SubnetAddressesDtoMapper::toDto).collect(Collectors.toList()))
        .build();
    } else {
      return subnetDtoBuilder.build();
    }
  }

  private void whetherTheNetworkWillFitSoManySubnet (Network network, byte numberOfFieldsForSubnet) {
    if(numberOfFieldsForSubnet + network.getNetworkMask().getNumberOfOnesNetworkMask().getAddress() > 31)
      throw new DoNotHaveEnoughFieldsToForSubnet();
  }
}
