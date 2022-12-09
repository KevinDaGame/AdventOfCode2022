package com.github.kevindagame.day9;

import com.github.kevindagame.common.FileReader;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {


    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        var lines = FileReader.readFile("day9.txt");
        var moves = new ArrayList<Move>();
        lines.forEach(line -> moves.add(new Move(line)));


        var rope = new LinkedList<Vector2>();
        rope.add(new Vector2(0, 0));
        rope.add(new Vector2(0, 0));
        System.out.println(simulate(moves, rope));

        rope.clear();
        for (int i = 0; i < 10; i++) {
            rope.add(new Vector2(0, 0));
        }
        System.out.println(simulate(moves, rope));
    }

    private static int simulate(ArrayList<Move> moves, LinkedList<Vector2> rope) {
        Map<Vector2, Boolean> visited = new HashMap<>();
        for (var move : moves) {
            for (int i = 0; i < move.amount; i++) {
                rope.getFirst().add(move.direction.getVector());
                Vector2 savedOld = null;
                for (int j = 1; j < rope.size(); j++) {
                    var old = rope.get(j).clone();
                    rope.get(j).set(getRopeVector(move, j, rope, savedOld));
                    savedOld = old;
                }
                visited.put(rope.getLast().clone(), true);
            }
        }
        return visited.size();
    }

    static Vector2 getRopeVector(Move move, int index, LinkedList<Vector2> rope, Vector2 old) {
        var cur = rope.get(index);
        var prev = rope.get(index - 1);
        if (shouldMove(cur, prev)) {
            if (index == 1) {
                return prev.clone().add(move.direction.getOpposite().getVector());
            }
            return old.clone();
        }
        return cur;
    }

    static boolean shouldMove(Vector2 cur, Vector2 prev) {
        return Math.abs(prev.getX() - cur.getX()) > 1 || Math.abs(prev.getY() - cur.getY()) > 1;
    }
}