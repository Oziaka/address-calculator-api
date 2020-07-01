package pl.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.network.Type;
import pl.validator.address.Address;
import pl.validator.address.AddressType;
import pl.validator.network_mask.NetworkMask;

@Getter
@Address
@NetworkMask
@NoArgsConstructor
public class AddressDto {

  private String address;
  private String mask;

  @AddressType
  private Type addressType;
  private Type maskType;

  @Builder
  public AddressDto (String address, String mask, @AddressType Type addressType, Type maskType) {
    this.address = address;
    this.mask = mask;
    this.addressType = addressType;
    this.maskType = maskType;
  }
}
