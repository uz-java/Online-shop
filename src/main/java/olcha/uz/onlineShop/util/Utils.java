package olcha.uz.onlineShop.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

public class  Utils {

    public static boolean isParsable(String timeAsString) {
        try {
            LocalDateTime.parse(timeAsString);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static LocalDateTime toLocalDateTime(String timeAsString) {
        try {
            return LocalDateTime.parse(timeAsString);
        } catch (DateTimeParseException e) {
            return null;
        }
    }

    public static String encode(String rawPassword) {
        return BCrypt.hashpw(rawPassword, BCrypt.gensalt(12));
    }

    public static boolean matchPassword(String rawPassword, String encodedPassword) {
        return BCrypt.checkpw(rawPassword, encodedPassword);
    }

}
