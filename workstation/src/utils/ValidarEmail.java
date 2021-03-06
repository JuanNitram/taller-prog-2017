package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidarEmail {
    private Pattern pattern;
    private Matcher matcher;

    private static final String EMAIL_PATTERN = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public ValidarEmail() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }
    
    public boolean Validar(final String hex) {

        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}
