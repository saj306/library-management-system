package view.enums.commands;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum MemberMenuCommands {

    BORROW_BOOK("borrow\\s+book\\s+(?<title>[^ ]+)"),
    BORROW_MAGAZINE("borrow\\s+magazine\\s+(?<title>[^ ]+)"),
    RETURN_BOOK("return\\s+book\\s+(?<title>[^ ]+)"),
    RETURN_MAGAZINE("return\\s+magazine\\s+(?<title>[^ ]+)"),
    BUY_PUBLICATION("buy\\s+publication\\s+(?<title>[^ ]+)\\s+(?<number>[^ ]+)"),
    INCREASE_BALANCE("increase\\s+balance\\s+(?<number>[^ ]+)"),
    SHOW_USER_BORROW_BOOKS("show user borrow books"),
    SHOW_USER_BORROW_MAGAZINES("show user borrow magazines"),
    SHOW_USER_BOUGHT_PUBLICATIONS("show user bought publications"),
    SHOW_ALL_PUBLICATIONS("show all publications");
    public String regex;

    MemberMenuCommands(String regex) {
        this.regex = regex;
    }

    public static Matcher getMatcher(String input, MemberMenuCommands mainRegex) {
        Matcher matcher = Pattern.compile(mainRegex.regex).matcher(input);
        if (matcher.matches())
            return matcher;
        return null;
    }
}
