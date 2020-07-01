package pl.resource;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.network.AddressDto;
import pl.network.SubnetDto;
import pl.resolver.DivideNetworkResolver;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class ResolverResource {
  private DivideNetworkResolver divideNetworkResolver;

  @GetMapping("/divideNetwork")
  public ResponseEntity<SubnetDto> divideNetwork (@RequestBody @Valid AddressDto addressDto,
                                                  @RequestParam
                                                  @Min(value = 1, message = "{error.number_of_subnet.too_small}")
                                                  @Max(value = 1073741823, message = "{error.number_of_subnet.too_big}")
                                                    int numberOfSubnet,
                                                  @RequestParam(defaultValue = "true") Boolean withDetails) {
    return ResponseEntity.ok(divideNetworkResolver.resolve(addressDto, numberOfSubnet, withDetails));
  }
}


