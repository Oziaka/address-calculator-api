package pl.tool;

public class Tool {
  //  Min number of subnet in network should greater or equals to 2^x
  public static int minNumberOfSubnet (int numberOfSubnet) {
    int minNumberOfSubnet = 1;
    while (minNumberOfSubnet < numberOfSubnet) minNumberOfSubnet *= 2;
    return minNumberOfSubnet;
  }

  public static byte numberOfFieldsForSubnet (long minNumberOfSubnet) {
    byte power = 0;
    while (Math.pow(2, power) != minNumberOfSubnet) power++;
    return power;
  }
}
