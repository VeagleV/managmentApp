package modules.Hashing;

import org.mindrot.jbcrypt.BCrypt;

import java.security.CryptoPrimitive;

public interface PasswordHashing {

    String salt = BCrypt.gensalt();

    static String hashPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }

    ;

    static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }

}
