package pl.dto;

import lombok.Builder;
import lombok.Getter;
import pl.network.mask.NetworkMask;

import java.util.List;

@Getter
public class SubnetDto {
  private NetworkMask networkMask;
  private List<SubnetAddresses> subnetAddresses;
  private Long numberOfSubnet;
  private Long numberOfHosts;

  @Builder
  public SubnetDto (NetworkMask networkMask, List<SubnetAddresses> subnetAddresses, Long numberOfSubnet, Long numberOfHostsPerSubnet) {
    this.networkMask = networkMask;
    this.subnetAddresses = subnetAddresses;
    this.numberOfSubnet = numberOfSubnet;
    this.numberOfHosts = numberOfHostsPerSubnet;
  }

}
