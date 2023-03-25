package view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum RegistrationMenuCommands {
    REGISTER_MEMBER("register\\s+(?<username>[^ ]+)\\s+(?<password>[^ ]+)"),
    PASSWORD_VALID("(?<password>[A-Za-z0-9_]+)"),
    REGISTER_ADMIN("register\\s+admin\\s+(?<username>[^ ]+)\\s+(?<password>[^ ]+)\\s+as\\s+(?<role>.+)"),
    LOGIN("login\\s+(?<username>[a-zA-Z0-9_]+)\\s+(?<password>[a-zA-Z0-9_]+)");
    public String regex;

    RegistrationMenuCommands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, RegistrationMenuCommands mainRegex) {
        Matcher matcher = Pattern.compile(mainRegex.regex).matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }

}
