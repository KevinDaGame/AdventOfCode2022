package com.github.kevindagame.day4;

import com.github.kevindagame.common.FileReader;
import com.github.kevindagame.day3.Group;
import com.github.kevindagame.day3.Line;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var lines = FileReader.readFile("day4.txt");
        var pairs = new ArrayList<Pair>();
        lines.forEach(l -> pairs.add(new Pair(l)));
        System.out.println(pairs.stream().mapToInt(Pair::oneContainsTheOther).sum());
        System.out.println(pairs.stream().mapToInt(Pair::hasOverlap).sum());
    }
}