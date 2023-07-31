package lt.jonas.accounting.exeptions;

public class ConsumerNotFoundExeption extends RuntimeException {
    public ConsumerNotFoundExeption() {
        super ("No consumers found for the given search criteria.");
    }
}
