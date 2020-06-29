package pl.address;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.validator.address.Address;
import pl.validator.address.AddressType;
import pl.validator.network_mask.NetworkMask;

@Getter
@Setter
@Address(message = "{error.address}")
@NetworkMask(message = "{error.network_mask}")
@NoArgsConstructor
public class AddressDto {

  private String address;
  private String mask;

  @AddressType(message = "{error.address_type")
  private Type addressType;
  private Type maskType;

  @Builder
  public AddressDto (String address, String mask, Type addressType, Type maskType) {
    this.address = address;
    this.mask = mask;
    this.addressType = addressType;
    this.maskType = maskType;
  }
}
