package com.github.kevindagame.day7;

public class FileNode extends Node{
    private final int size;

    public FileNode(DirNode parent, String name, int size) {
        super(parent, name);
        this.size = size;
    }

    int getSize() {
        return size;
    }
}
