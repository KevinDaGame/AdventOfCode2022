package com.github.kevindagame.day8;

import com.github.kevindagame.common.FileReader;
import com.github.kevindagame.day7.DirNode;
import com.github.kevindagame.day7.FileNode;
import com.github.kevindagame.day7.FileTree;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var lines = FileReader.readFile("day8.txt");
        TreeGrid treeGrid = new TreeGrid(lines);
        var visible = treeGrid.getVisibleTrees();
        System.out.println(visible.size());
        var scores = treeGrid.getScenicScores();
        System.out.println(scores.stream().max(Integer::compare).get());
    }
}