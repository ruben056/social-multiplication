package microservices.book.socialmultiplication.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Value;

@Value()
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Multiplication {

    int factorA;
    int factorB;
    int result;

    public static Multiplication create(int factorA, int factorB) {
        return new Multiplication(factorA, factorB, factorA * factorB);
    }


}
