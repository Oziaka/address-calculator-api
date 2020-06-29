package pl.resource;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pl.address.AddressDto;
import pl.address.Network;
import pl.resolver.DivideNetworkResolver;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
@AllArgsConstructor
@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
public class ResolverResource {
  private DivideNetworkResolver divideNetworkResolver;

  @GetMapping("/divideNetwork")
  public ResponseEntity<List<Network>> divideNetwork (@RequestBody @Valid AddressDto addressDto,
                                                      @RequestParam
                                                      @Min(value = 1, message = "{error.numberOfSubnet.tooSmall}")
                                                      @Max(value = 1073741823, message = "{error.numberOfSubnet.tooBig}")
                                                        long numberOfSubnet) {
    return ResponseEntity.ok(divideNetworkResolver.resolve(addressDto, numberOfSubnet));
  }
}


