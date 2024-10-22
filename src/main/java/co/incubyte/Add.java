package co.incubyte;

import java.util.Arrays;

public class Add {
    public int add(String numbers){
        if(numbers.isEmpty()) {
            return 0;
        }
        else if(numbers.contains(",")){
            String[] nums = numbers.split(",");
            return Arrays.stream(nums)
                    .mapToInt(Integer::parseInt)
                    .sum();
        }else{
            return Integer.parseInt(numbers);
        }
    }
}
