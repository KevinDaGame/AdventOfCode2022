package com.github.kevindagame.day7;

import java.util.ArrayList;
import java.util.List;

public abstract class Node {
    private DirNode parent;
    private String name;

    public Node(DirNode parent, String name) {
        this.parent = parent;
        this.name = name;

    }

    public Node getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }

}
