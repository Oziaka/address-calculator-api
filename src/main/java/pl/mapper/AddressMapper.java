package pl.mapper;

import pl.dto.AddressDtoOutput;
import pl.network.address.Address;

public class AddressMapper {
  public static AddressDtoOutput toDto2 (Address networkAddress) {
    return AddressDtoOutput.builder()
      .binary(networkAddress.getBinaryAddress().getAddress())
      .decimal(networkAddress.getDecimalAddress().getAddress())
      .build();
  }
}
