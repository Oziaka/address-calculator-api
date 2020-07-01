package pl.network;

import lombok.Builder;
import lombok.Getter;
import pl.network.network_mask.NetworkMask;

import java.util.List;

@Getter
public class SubnetDto {
  private NetworkMask networkMask;
  private List<SubnetAddressesDto> subnetAddressesDto;
  private Long numberOfSubnet;
  private Long numberOfHosts;

  @Builder
  public SubnetDto (NetworkMask networkMask, List<SubnetAddressesDto> subnetAddressesDto, Long numberOfSubnet, Long numberOfHostsPerSubnet) {
    this.networkMask = networkMask;
    this.subnetAddressesDto = subnetAddressesDto;
    this.numberOfSubnet = numberOfSubnet;
    this.numberOfHosts = numberOfHostsPerSubnet;
  }

}
