package view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum AdminMenuCommands {

    ADD_REFERENCE_BOOK("add\\s+rb\\s+(?<title>[^ ]+)\\s+(?<author>[^ ]+)\\s+(?<price>[^ ]+)\\s+(?<numberOfPages>[^ ]+)\\s+(?<number>[^ ]+)"),
    ADD_BORROWABLE_BOOK("add\\s+bb\\s+(?<title>[^ ]+)\\s+(?<author>[^ ]+)\\s+(?<price>[^ ]+)\\s+(?<numberOfPages>[^ ]+)\\s+(?<number>[^ ]+)"),
    ADD_SPECIALIZED_MAGAZINE("add\\s+sm\\s+(?<title>[^ ]+)\\s+(?<publisher>[^ ]+)\\s+(?<price>[^ ]+)\\s+(?<numberOfPages>[^ ]+)\\s+(?<number>[^ ]+)"),
    ADD_GENERAL_MAGAZINE("add\\s+gm\\s+(?<title>[^ ]+)\\s+(?<publisher>[^ ]+)\\s+(?<price>[^ ]+)\\s+(?<numberOfPages>[^ ]+)\\s+(?<number>[^ ]+)");
    public String regex;

    AdminMenuCommands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, AdminMenuCommands mainRegex) {
        Matcher matcher = Pattern.compile(mainRegex.regex).matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }
}
