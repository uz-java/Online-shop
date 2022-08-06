package olcha.uz.onlineShop.exceptions;


public class UnAuthorizedException extends RuntimeException {
    public UnAuthorizedException(String message) {
        super(message);
    }
}
