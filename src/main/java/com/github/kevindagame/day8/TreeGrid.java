package com.github.kevindagame.day8;

import java.util.ArrayList;
import java.util.List;

public class TreeGrid {
    private List<List<Tree>> grid;

    public TreeGrid(List<String> lines) {
        this.grid = new ArrayList<>();
        for (var line : lines) {
            var gridLine = new ArrayList<Tree>();
            var treeChars = line.toCharArray();
            for (var treeChar : treeChars) {
                gridLine.add(new Tree(Character.getNumericValue(treeChar)));
            }
            grid.add(gridLine);
        }
    }

    public List<Tree> getVisibleTrees() {
        var visible = new ArrayList<Tree>();

        for (int i = 0; i < grid.size(); i++) {
            var line = grid.get(i);
            for (int j = 0; j < line.size(); j++) {
                if (checkTree(i, j)) {
                    visible.add(grid.get(i).get(j));
                }
            }
        }
        return visible;
    }

    public List<Integer> getScenicScores() {
        List<Integer> scores = new ArrayList<>();
        for (int i = 0; i < grid.size(); i++) {
            var line = grid.get(i);
            for (int j = 0; j < line.size(); j++) {
                scores.add(getScenicScore(i, j));
            }
        }
        return scores;
    }

    private int getScenicScore(int i, int j) {
        var tree = grid.get(i).get(j);
        var height = tree.height();

        var spaceAbove = 0;
        var spaceBelow = 0;
        var spaceLeft = 0;
        var spaceRight = 0;

        for (int di = i - 1; di >= 0; di--) {
            spaceAbove++;
            if (grid.get(di).get(j).height() >= height) {
                break;
            }
        }
        for (int di = i + 1; di < grid.size(); di++) {
            spaceBelow++;
            if (grid.get(di).get(j).height() >= height) {
                break;
            }
        }
        for (int dj = j - 1; dj >= 0; dj--) {
            spaceLeft++;
            if (grid.get(i).get(dj).height() >= height) {
                break;
            }
        }
        for (int dj = j + 1; dj < grid.get(i).size(); dj++) {
            spaceRight++;
            if (grid.get(i).get(dj).height() >= height) {
                break;
            }
        }
        return spaceAbove * spaceBelow * spaceLeft * spaceRight;

    }

    private boolean checkTree(int i, int j) {
        var tree = grid.get(i).get(j);
        var height = tree.height();
        var success = true;
        //check above
        for (int di = i - 1; di >= 0; di--) {
            if (grid.get(di).get(j).height() >= height) {
                success = false;
                break;
            }

        }

        if (checkAbove(i, j, height)) return true;
        if (checkBelow(i, j, height)) return true;
        if (checkLeft(i, j, height)) return true;
        return checkRight(i, j, height);
    }

    private boolean checkAbove(int i, int j, int height) {
        for (int di = i - 1; di >= 0; di--) {
            if (grid.get(di).get(j).height() >= height) {
                return false;
            }
        }
        return true;
    }

    private boolean checkRight(int i, int j, int height) {
        for (int dj = j + 1; dj < grid.size(); dj++) {
            if (grid.get(i).get(dj).height() >= height) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLeft(int i, int j, int height) {
        for (int dj = j - 1; dj >= 0; dj--) {
            if (grid.get(i).get(dj).height() >= height) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBelow(int i, int j, int height) {
        for (int di = i + 1; di < grid.size(); di++) {
            if (grid.get(di).get(j).height() >= height) {
                return false;
            }
        }
        return true;
    }
}
