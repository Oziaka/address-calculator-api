package pl.dto;

import lombok.Builder;
import lombok.Getter;

;

@Getter
public class SubnetAddresses {
  private AddressDtoOutput networkAddress;
  private AddressDtoOutput broadcastAddress;
  private AddressDtoOutput firstHostAddress;
  private AddressDtoOutput lastHostAddress;

  @Builder
  public SubnetAddresses (AddressDtoOutput networkAddress, AddressDtoOutput broadcastAddress, AddressDtoOutput firstHostAddress, AddressDtoOutput lastHostAddress) {
    this.networkAddress = networkAddress;
    this.broadcastAddress = broadcastAddress;
    this.firstHostAddress = firstHostAddress;
    this.lastHostAddress = lastHostAddress;
  }
}
