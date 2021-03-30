package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class LottoNumber implements Comparable<LottoNumber>{

  private static final int START_NUMBER = 1;
  private static final int END_NUMBER = 45;
  private static final Map<Integer, LottoNumber> LOTTO_NUMBERS_RANGE = new HashMap<>();
  private static final Random RANDOM = new Random();
  private final int number;

  static {
    for (int i = START_NUMBER; i <= END_NUMBER; i++) {
      LOTTO_NUMBERS_RANGE.put(i, new LottoNumber(i));
    }
  }

  private LottoNumber(int number) {
    if (number < START_NUMBER || number > END_NUMBER) {
      throw new IllegalArgumentException("out of bound.");
    }
    this.number = number;
  }

  public static LottoNumber generateManual(int number) {
    LottoNumber lottoNumber = LOTTO_NUMBERS_RANGE.get(number);
    if (lottoNumber == null) {
      throw new IllegalArgumentException("out of bound.");
    }
    return lottoNumber;
  }

  public static LottoNumber generateAuto() {
    int number = RANDOM.nextInt(45) + 1;
    return LOTTO_NUMBERS_RANGE.get(number);
  }

  public int getNumber() {
    return number;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public int compareTo(LottoNumber lottoNumber) {
    if (lottoNumber.number > number) {
      return -1;
    }
    return 1;
  }

}
