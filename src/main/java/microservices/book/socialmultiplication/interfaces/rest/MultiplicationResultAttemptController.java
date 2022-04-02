package microservices.book.socialmultiplication.interfaces.rest;

import microservices.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservices.book.socialmultiplication.service.MultiplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/results")
public class MultiplicationResultAttemptController {

    private final MultiplicationService multiplicationService;

    public MultiplicationResultAttemptController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @PostMapping()
    ResponseEntity<ResultResponse> postResult(@RequestBody MultiplicationResultAttempt attempt) {
        boolean correct = multiplicationService.checkAttempt(attempt);
        return ResponseEntity.ok(new ResultResponse(correct));


    }

    record ResultResponse(boolean correct) {
    }
}
