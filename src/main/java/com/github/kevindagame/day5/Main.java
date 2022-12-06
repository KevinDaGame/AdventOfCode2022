package com.github.kevindagame.day5;

import com.github.kevindagame.common.FileReader;
import com.github.kevindagame.day4.Pair;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {
    static List<Stack> stacks = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var lines = FileReader.readFile("day5.txt");
        var stack = lines.subList(0, 8);
        var instructions = lines.subList(9, lines.size());
        for (int i = 1; i <= 9; i++) {
            var s = new Stack();
            stacks.add(s);
        }
        // build the stacks
        for (int i = stack.size() - 1; i >=0; i--) {
            var s = stack.get(i);
            var index = 0;
            for (int j = 1; j < s.length(); j += 4) {
                if (s.charAt(j) != ' ') {
                    stacks.get(index).push(s.charAt(j));
                }
                index++;
            }
        }

        //follow instructions

        //part 1
//        var amountMatcher = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
//        for(var instruction: instructions) {
//            var matches = amountMatcher.matcher(instruction);
//            if (matches.matches()) {
//                var amount = Integer.parseInt(matches.group(1));
//                var from = Integer.parseInt(matches.group(2));
//                var to = Integer.parseInt(matches.group(3));
//                for (int i = 0; i < amount; i++) {
//                    stacks.get(to -1).push(stacks.get(from -1).pop());
//                }
//            }
//        }
        //part 2
        var amountMatcher = Pattern.compile("move (\\d+) from (\\d+) to (\\d+)");
        for(var instruction: instructions) {
            var matches = amountMatcher.matcher(instruction);
            if (matches.matches()) {
                var amount = Integer.parseInt(matches.group(1));
                var from = Integer.parseInt(matches.group(2));
                var to = Integer.parseInt(matches.group(3));
                stacks.get(to -1).pushAll(stacks.get(from -1).popMultiple(amount));
            }
        }

        //get top characters of stacks
        var result = new StringBuilder();
        for (var s: stacks) {
            result.append(s.peek());
        }
        System.out.println(result);
    }
}