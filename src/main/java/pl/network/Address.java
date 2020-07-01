package pl.network;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class Address <T> {
  public static final int MAX_ADDRESS_LENGTH = 35;
  public static final int MAX_ADDRESS_WITH_OUT_DOTS_LENGTH = 32;

  private T address;

  public Address (T address) {
    this.address = address;
  }
}
