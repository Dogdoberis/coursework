package lt.jonas.accounting.exeptions;

import org.springframework.http.HttpStatus;

public class ConsumerNotFoundExeption extends RuntimeException {
    public ConsumerNotFoundExeption() {
        super ("No consumers found for the given search criteria.");
    }
}
