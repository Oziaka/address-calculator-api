package pl.tool;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pl.test.TestingTool.randomBinaryAddress;

class ValidatorToolTest {
  @Test
  void shouldNotPassWhenBinaryMaskIsNotCorrect () {
    Assertions.assertFalse(ValidatorTool.validBinaryMask("11111111.0.0.1"));
  }

  @Test
  void shouldPassWhenBinaryMaskIsCorrect () {
    String mask = "10000000.00000000.00000000.00000000";
    for (int i = 1; i < 32; i++) {
      Assertions.assertTrue(ValidatorTool.validBinaryMask(mask));
      mask = mask.replaceFirst("0", "1");
    }
  }

  @Test
  void shouldPassWhenBinaryAddressIsCorrect () {
    Assertions.assertTrue(ValidatorTool.validBinaryAddress(randomBinaryAddress()));
  }

  @Test
  void shouldPassWhenDecimalAdderssIsCorrect () {
    String mask = "10000000.00000000.00000000.00000000";
    for (int i = 1; i < 32; i++) {
      Assertions.assertTrue(ValidatorTool.validDecimalMask(Tool.toDecimalAddress((mask))));
      mask = mask.replaceFirst("0", "1");
    }
  }
}
