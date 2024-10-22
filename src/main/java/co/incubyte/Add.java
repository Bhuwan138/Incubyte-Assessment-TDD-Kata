package co.incubyte;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Add {
    public int add(String text){
        if(text.isEmpty()) {
            return 0;
        }else{
            String[] tokens = tokenize(text);
            return parseAndSumTones(tokens);
        }
    }

    private int parseAndSumTones(String[] tokens) {
        return Arrays.stream(tokens)
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public String[] tokenize(String text){
        if(usesCustomDelimeterSyntax(text)){
            return splitUsingCustomDelimeterSyntax(text);
        }else{
            return splitUsingCommaAndNewLine(text);
        }
    }

    private boolean usesCustomDelimeterSyntax(String text) {
        return text.startsWith("//");
    }

    private String[] splitUsingCommaAndNewLine(String text) {
        return text.split(",|\n");
    }

    private String[] splitUsingCustomDelimeterSyntax(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)")
                .matcher(text);
        matcher.matches();
        String customDelimiter = matcher.group(1);
        String numbers = matcher.group(2);
        return numbers.split(customDelimiter);
    }
}
