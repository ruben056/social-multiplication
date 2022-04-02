package microservices.book.socialmultiplication.domain;

import lombok.Value;

@Value
public class MultiplicationResultAttempt {
    User user;
    Multiplication multiplication;
    int resultAttempt;
}
