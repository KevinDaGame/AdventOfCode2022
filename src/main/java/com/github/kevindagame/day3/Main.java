package com.github.kevindagame.day3;

import com.github.kevindagame.common.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var lines = FileReader.readFile("day3.txt");
        var linesObj = new ArrayList<Line>();
        lines.forEach(e -> linesObj.add(new Line(e)));
        System.out.println(linesObj.stream().mapToInt(Line::getValueOfRecurringItem).sum());

        //Split linesObj in array of 3 lines each
        var groups = new ArrayList<Group>();
        for(int i = 0; i < linesObj.size(); i += 3) {
            groups.add(new Group(new Line[]{linesObj.get(i), linesObj.get(i + 1), linesObj.get(i + 2)}));
        }
        System.out.println(groups.stream().mapToInt(Group::getSharedItemValue).sum());
    }
}