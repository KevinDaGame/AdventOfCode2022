package com.github.kevindagame.day6;

import java.util.ArrayList;
import java.util.List;

public class Buffer {
    private List<Character> buffer = new ArrayList<>();
    private int size;

    public Buffer(int size) {
        this.size = size;
    }

    public void add(char c) {
        buffer.add(c);
        if(buffer.size() > size) {
            buffer.remove(0);
        }
    }

    public boolean allUnique() {
        if(buffer.size() < size) return false;
        for(int i = 0; i < buffer.size(); i++) {
            for(int j = i + 1; j < buffer.size(); j++) {
                if(buffer.get(i) == buffer.get(j)) {
                    return false;
                }
            }
        }
        return true;
    }


}
