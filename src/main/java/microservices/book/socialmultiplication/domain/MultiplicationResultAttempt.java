package microservices.book.socialmultiplication.domain;

import lombok.*;


public record MultiplicationResultAttempt(User user,
                                          Multiplication multiplication,
                                          int resultAttempt) {

}
