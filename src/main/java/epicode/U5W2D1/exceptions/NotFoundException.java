package epicode.U5W2D1.exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException() {super("The item you're searching for has not been found");}
}
