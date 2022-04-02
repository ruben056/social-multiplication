package microservices.book.socialmultiplication.domain;

import lombok.Value;

@Value()
public class Multiplication {

    private int factorA;
    private int factorB;
    private int result;

    public static Multiplication create(int factorA, int factorB) {
        return new Multiplication(factorA, factorB, factorA * factorB);
    }


}
