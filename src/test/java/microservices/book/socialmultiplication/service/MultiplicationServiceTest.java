package microservices.book.socialmultiplication.service;

import microservices.book.socialmultiplication.domain.Multiplication;
import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class MultiplicationServiceTest {

    @Mock
    private RandomGeneratorService randomGeneratorService;
    @InjectMocks
    private MultiplicationServiceImpl multiplicationService;

    @Test
    public void createRandomMultiplicationTest() {
        given(randomGeneratorService.generateRandomFactorBetween11and99()).willReturn(50, 30);

        Multiplication actual = multiplicationService.createRandomMultiplication();

        assertThat(actual.factorA()).isEqualTo(50);
        assertThat(actual.factorB()).isEqualTo(30);
        assertThat(actual.getResult()).isEqualTo(1500);
    }

    @Test
    public void checkCorrectAttemptTest() {

        Multiplication multiplication = new Multiplication(50,60);
        User user = new User("john_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000);

        boolean attemptResult = multiplicationService.checkAttempt(attempt);

        assertThat(attemptResult).isTrue();
    }

    @Test
    public void checkWrongAttemptTest() {

        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("john_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3010);

        boolean attemptResult = multiplicationService.checkAttempt(attempt);

        assertThat(attemptResult).isFalse();
    }
}