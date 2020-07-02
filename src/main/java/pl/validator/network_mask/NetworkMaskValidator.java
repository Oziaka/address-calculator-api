package pl.validator.network_mask;

import pl.dto.AddressDtoInput;
import pl.exception.IncorrectNetworkMaskTypeExcpetion;
import pl.network.Type;
import pl.tool.ValidatorTool;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NetworkMaskValidator implements ConstraintValidator<NetworkMask, AddressDtoInput> {
  public void initialize (NetworkMask constraint) {
  }

  public boolean isValid (AddressDtoInput addressDtoInput, ConstraintValidatorContext context) {
    return validMask(addressDtoInput.getMask(), addressDtoInput.getMaskType());
  }

  private boolean validMask (String mask, Type maskType) {
    switch (maskType) {
      case BINARY:
        if(ValidatorTool.validBinaryMask(mask))
          return true;
        break;
      case DECIMAL:
        if(ValidatorTool.validDecimalMask(mask))
          return true;
        break;
      case NUMBER_OF_ONES:
        if(ValidatorTool.validNumberOfOnesMask(Integer.parseInt(mask)))
          return true;
        break;
      default:
        throw new IncorrectNetworkMaskTypeExcpetion();
    }
    return false;
  }
}
