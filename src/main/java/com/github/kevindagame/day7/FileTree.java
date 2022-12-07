package com.github.kevindagame.day7;

import java.util.List;

public class FileTree {
    private DirNode root;

    public FileTree(DirNode root) {
        this.root = root;
    }

    public DirNode getRoot() {
        return root;
    }

    public void setRoot(DirNode root) {
        this.root = root;
    }

    public List<DirNode> getDirNodes() {
        return root.getChildDirNodes();
    }
}
