package pl.network;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public abstract class AbstractAddress <T> {
  public static final int MAX_ADDRESS_LENGTH = 35;
  public static final int MAX_ADDRESS_WITH_OUT_DOTS_LENGTH = 32;

  private T address;

  public AbstractAddress (T address) {
    this.address = address;
  }
}
