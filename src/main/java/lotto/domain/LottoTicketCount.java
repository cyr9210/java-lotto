package lotto.domain;

public class LottoTicketCount {

  private int total;
  private int manualCount;
  private int autoCount;

  public LottoTicketCount(int total) {
    this.total = total;
  }

  public void assignManual(int manualTicketCount) {
    this.manualCount = manualTicketCount;
    this.autoCount = total - manualTicketCount;
  }

  public int getManualCount() {
    return manualCount;
  }

  public int getAutoCount() {
    return autoCount;
  }
}
