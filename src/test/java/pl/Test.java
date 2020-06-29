package pl;

public class Test {
  public static long testTime (Runnable runnable) {
    long start = System.currentTimeMillis();
    runnable.run();
    return System.currentTimeMillis() - start;
  }
}
