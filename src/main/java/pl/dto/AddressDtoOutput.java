package pl.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AddressDtoOutput {
  private String binary;
  private String decimal;

  @Builder
  public AddressDtoOutput (String binary, String decimal) {
    this.binary = binary;
    this.decimal = decimal;
  }
}
