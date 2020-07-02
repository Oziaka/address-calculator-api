package pl.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class SubnetDto {
  private NetworkMaskDto networkMask;
  private List<SubnetAddresses> subnetAddresses;
  private Long numberOfSubnet;
  private Long numberOfHostsPerSubnet;

  @Builder
  public SubnetDto (NetworkMaskDto networkMask, List<SubnetAddresses> subnetAddresses, Long numberOfSubnet, Long numberOfHostsPerSubnet) {
    this.networkMask = networkMask;
    this.subnetAddresses = subnetAddresses;
    this.numberOfSubnet = numberOfSubnet;
    this.numberOfHostsPerSubnet = numberOfHostsPerSubnet;
  }
}
