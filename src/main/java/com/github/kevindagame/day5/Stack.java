package com.github.kevindagame.day5;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Character> stack = new ArrayList<>();

    public void push(Character character) {
        stack.add(character);
    }

    public void pushAll(List<Character> characters) {
        stack.addAll(characters);
    }

    public Character pop() {
        return stack.remove(stack.size() - 1);
    }

    public List<Character> popMultiple(int amount) {
        var result = new ArrayList<Character>();
        for (int i = 0; i < amount; i++) {
            result.add(pop());
        }
        //reverse the list
        for (int i = 0; i < result.size() / 2; i++) {
            var temp = result.get(i);
            result.set(i, result.get(result.size() - 1 - i));
            result.set(result.size() - 1 - i, temp);
        }
        return result;
    }

    public Character peek() {
        return stack.get(stack.size() - 1);
    }
}
