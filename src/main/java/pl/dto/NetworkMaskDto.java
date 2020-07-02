package pl.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class NetworkMaskDto {
  private String binary;
  private String decimal;
  private byte numberOfOnes;

  @Builder
  public NetworkMaskDto (String binary, String decimal, byte numberOfOnes) {
    this.binary = binary;
    this.decimal = decimal;
    this.numberOfOnes = numberOfOnes;
  }
}
