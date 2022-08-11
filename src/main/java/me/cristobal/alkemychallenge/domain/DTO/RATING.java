package me.cristobal.alkemychallenge.domain.DTO;

public enum RATING {
  ONE(1),
  TWO(2),
  THREE(3),
  FOUR(4),
  FIVE(5);

  private int numValue;

  RATING(int numValue) {
    this.numValue = numValue;
  }

  public int getNumValue() {
    return numValue;
  }

}
