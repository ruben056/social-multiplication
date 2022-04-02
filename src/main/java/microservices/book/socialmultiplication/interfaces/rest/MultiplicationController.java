package microservices.book.socialmultiplication.interfaces.rest;

import microservices.book.socialmultiplication.domain.Multiplication;
import microservices.book.socialmultiplication.service.MultiplicationService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

    private final MultiplicationService multiplicationService;

    public MultiplicationController(MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }


    @GetMapping(value = "/random", produces = MediaType.APPLICATION_JSON_VALUE)
    Multiplication getRandomMultiplication() {
        return multiplicationService.createRandomMultiplication();
    }


}
