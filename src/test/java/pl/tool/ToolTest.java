package pl.tool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ToolTest {

  @Test
  void shouldReturnBinaryMask () {
    long numberOfOnesMask = 10;
    Assertions.assertEquals("11111111.11000000.00000000.00000000", Tool.toBinaryAddress(numberOfOnesMask));
  }
}
