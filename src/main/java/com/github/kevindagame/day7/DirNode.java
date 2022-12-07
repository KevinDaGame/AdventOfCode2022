package com.github.kevindagame.day7;

import java.util.ArrayList;
import java.util.List;

public class DirNode extends Node {
    private List<Node> children;
    private int size;

    public DirNode(DirNode parent, String name) {
        super(parent, name);
        this.children = new ArrayList<>();
    }


    public List<Node> getChildren() {
        return children;
    }

    public Node getChild(String name) {
        for (var child : children) {
            if (child.getName().equals(name)) {
                return child;
            }
        }
        return null;
    }

    public void addChild(Node child) {
        children.add(child);
    }

    public List<DirNode> getChildDirNodes() {
        //recursively get all dir nodes
        List<DirNode> dirNodes = new ArrayList<>();
        for (var child : children) {
            if (child instanceof DirNode) {
                dirNodes.add((DirNode) child);
                dirNodes.addAll(((DirNode) child).getChildDirNodes());
            }
        }
        return dirNodes;
    }

    public int getSize() {
       return size;
    }

    public int calcSize() {
        //recursively get size
        int size = 0;
        for (var child : children) {
            if (child instanceof DirNode) {
                size += ((DirNode) child).calcSize();
            } else {
                size += ((FileNode) child).getSize();
            }
        }
        this.size = size;
        return size;
    }
}
