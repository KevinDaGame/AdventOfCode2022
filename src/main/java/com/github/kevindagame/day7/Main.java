package com.github.kevindagame.day7;

import com.github.kevindagame.common.FileReader;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

public class Main {

    static FileTree tree;
    static DirNode pos;

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var instructions = FileReader.readFile("day7.txt");
        tree = new FileTree(new DirNode(null, "root"));
        pos = tree.getRoot();
        for (var line : instructions) {
            if (line.startsWith("$ ")) {
                line = line.substring(2);

                var parts = line.split(" ");
                switch (parts[0]) {
                    case "cd" -> {
                        if (parts[1].equals("..")) {
                            pos = (DirNode) pos.getParent();
                        } else if (parts[1].equals("/")) {

                        } else {
                            pos = (DirNode) pos.getChild(parts[1]);
                        }
                    }
                }
            } else {
                var parts = line.split(" ");
                if (parts[0].equals("dir")) {
                    pos.addChild(new DirNode(pos, parts[1]));
                } else {
                    pos.addChild(new FileNode(pos, parts[1], Integer.parseInt(parts[0])));

                }
            }
        }
        var nodes = tree.getDirNodes();
        tree.getRoot().calcSize();
        var sumLowerThan1000000 = 0;
        for (var node : nodes) {
            var size = node.getSize();
            if (size <= 100000) {
                sumLowerThan1000000 += size;
            }
        }
        System.out.println(sumLowerThan1000000);

        //part two
        //total disk size is 70000000
        //free space required is 30000000
        //find the smallest node that can be removed to make space for the update
        var freeSpace = 70000000 - tree.getRoot().getSize();
        var neededSpace = 30000000 - freeSpace;
        DirNode selectedNode = null;
        for(var node : nodes) {
            if(node.getSize() >= neededSpace) {
                if(selectedNode == null) {
                    selectedNode = node;
                } else {
                    if(node.getSize() < selectedNode.getSize()) {
                        selectedNode = node;
                    }
                }
            }
        }
        System.out.println(selectedNode.getName() + " " + selectedNode.getSize());
    }
}