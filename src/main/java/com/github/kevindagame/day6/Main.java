package com.github.kevindagame.day6;

import com.github.kevindagame.common.FileReader;
import com.github.kevindagame.day5.Stack;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var line = FileReader.readFile("day6.txt").get(0).toCharArray();
        Buffer buffer = new Buffer(4);
        for(int i = 0; i < line.length; i++) {
            buffer.add(line[i]);
            if(buffer.allUnique()) {
                System.out.println("Part 1: " + (i + 1));
                break;
            }
        }
        buffer = new Buffer(14);
        for(int i = 0; i < line.length; i++) {
            buffer.add(line[i]);
            if(buffer.allUnique()) {
                System.out.println("Part 2: " + (i + 1));
                break;
            }
        }
        System.out.println("None found");
    }
}