package co.incubyte;

import java.util.Arrays;

public class Add {
    public int add(String numbers){
        if(numbers.isEmpty()) {
            return 0;
        }else{
            String[] nums = numbers.split(",|\n");
            return Arrays.stream(nums)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
    }
}
