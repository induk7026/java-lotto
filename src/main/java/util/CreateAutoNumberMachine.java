package util;

import domain.LottoNumber;
import domain.LottoNumbers;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CreateAutoNumberMachine {

    private static final int SIZE = 6;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private static final List<Integer> LOTTO_NUMBERS = IntStream.range(MIN_NUMBER, MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());

    public static LottoNumbers createNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> numbers = LOTTO_NUMBERS
            .stream()
            .limit(SIZE)
            .collect(Collectors.toList());
        Collections.sort(numbers);
        return new LottoNumbers(
            numbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    public static LottoNumbers createNumbers(List<Integer> list) {
        return new LottoNumbers(
            list.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }
}
