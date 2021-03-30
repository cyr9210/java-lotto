package lotto;

import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicketCount;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoMain {

  public static final LottoMachine lottoMachine = new LottoMachine();

  public static void main(String[] args) {
    Money money = new Money(InputView.inputMoney());
    LottoTicketCount lottoCount = InputView.getLottoCount(money);

    Lottos lottos = buyManual(lottoCount.getManualCount());
    lottos.addAll(lottoMachine.buyAuto(lottoCount.getAutoCount()));
    ResultView.printLottosCount(lottoCount);
    ResultView.printLottos(lottos);

    List<Integer> winnerNumber = InputView.inputWinnerNumber();
    int bonusNumber = InputView.inputBonusNumber();
    lottos.checkResult(winnerNumber, bonusNumber);
    ResultView.printResult(lottos);
    ResultView.printIncomePercent(lottos.calculateIncomePercent());
  }

  private static Lottos buyManual(int manualTicketCount) {
    InputView.printInputManualLotto();
    Lottos lottos = new Lottos();
    for (int i = 0; i < manualTicketCount; i++) {
      List<Integer> numbers = InputView.inputManualLottoNumbers();
      lottos.add(lottoMachine.generateManual(numbers));
    }
    return lottos;
  }


}
