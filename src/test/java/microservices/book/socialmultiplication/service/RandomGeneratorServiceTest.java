package microservices.book.socialmultiplication.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


class RandomGeneratorServiceTest {

    private final RandomGeneratorService randomGeneratorService = new RandomGeneratorServiceImpl();

    @Test
    public void generateRandomFactorIsBetweenLimits(){
        List<Integer> generatedNumbers = IntStream.range(0, 1000)
                .map(i -> randomGeneratorService.generateRandomFactorBetween11and99())
                .boxed()
                .collect(Collectors.toList());
        List<Integer> allowedNumbers = IntStream.range(11, 100).boxed().collect(Collectors.toList());

        Assertions.assertThat(generatedNumbers).isSubsetOf(allowedNumbers);
    }
}