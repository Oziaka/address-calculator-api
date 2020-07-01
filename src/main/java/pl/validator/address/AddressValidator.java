package pl.validator.address;

import pl.dto.AddressDto;
import pl.exception.IncorrectAddressTypeException;
import pl.network.Type;
import pl.tool.ValidatorTool;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressValidator implements ConstraintValidator<Address, AddressDto> {
  public void initialize (Address constraint) {
  }

  public boolean isValid (AddressDto addressDto, ConstraintValidatorContext context) {
    return validAddress(addressDto.getAddress(), addressDto.getAddressType());
  }


  private boolean validAddress (String address, Type addressType) {
    switch (addressType) {
      case BINARY:
        if(ValidatorTool.validBinaryAddress(address))
          return true;
        break;
      case DECIMAL:
        if(ValidatorTool.validDecimalAddress(address))
          return true;
        break;
//AddressType validator should check this case
      case NUMBER_OF_ONES:
        return true;
      default:
        throw new IncorrectAddressTypeException();
    }
    return false;
  }
}
