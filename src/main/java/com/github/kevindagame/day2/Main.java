package com.github.kevindagame.day2;

import com.github.kevindagame.common.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> instances = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var lines = FileReader.readFile("day2.txt");
        var moves = new ArrayList<Move>();
        lines.forEach(e -> moves.add(new Move(OtherMove.valueOf(e.substring(0, 1)), MyMove.valueOf(e.substring(2)) )));
        moves.forEach(e -> System.out.println(e.toString()));
        System.out.println(getTotal(moves));
        System.out.println(getTotal2(moves));
    }


    public static int getTotal(List<Move> moves) {
        return moves.stream().mapToInt(Move::getPoints).sum();
    }

    public static int getTotal2(List<Move> moves) {
        return moves.stream().mapToInt(Move::getPoints2).sum();
    }
}