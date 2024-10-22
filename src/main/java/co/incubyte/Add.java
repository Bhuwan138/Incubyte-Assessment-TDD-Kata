package co.incubyte;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.join;

public class Add {
    public int add(String text){
        String[] tokens = tokenize(text);
        List<Integer> numbers = parseToIntegerList(tokens);
        filterNegativeNumbers(numbers);
        return sumNumbers(numbers);
    }

    private void filterNegativeNumbers(List<Integer> numbers) {
        String negativeNumbersInCommaSeperatedString = numbers.stream()
                .filter(n -> n < 0)
                .map(String::valueOf)
                .collect(Collectors.joining(","));
        if(!negativeNumbersInCommaSeperatedString.isBlank()){
            throw new IllegalArgumentException("negatives not allowed: " + negativeNumbersInCommaSeperatedString);
        }
    }

    private int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, Integer::sum);
    }

    private List<Integer> parseToIntegerList(String[] tokens) {
        return Arrays.stream(tokens)
                .map(Integer::parseInt)
                .filter(n -> n <= 1000)
                .collect(Collectors.toList());
    }

    public String[] tokenize(String text){
        if(text.isEmpty()) {
            return new String[0];
        }else if(usesCustomDelimeterSyntax(text)){
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
        return numbers.split(Pattern.quote(customDelimiter));
    }
}
