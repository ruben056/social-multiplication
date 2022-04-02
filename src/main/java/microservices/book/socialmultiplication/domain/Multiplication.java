package microservices.book.socialmultiplication.domain;

public record Multiplication(int factorA, int factorB) {

    public int getResult(){
        return factorA * factorB;
    }
}
