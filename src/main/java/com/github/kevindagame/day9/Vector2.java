package com.github.kevindagame.day9;

import java.util.Objects;

public class Vector2 implements Cloneable {
    private int x, y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void set(Vector2 vector) {
        this.x = vector.getX();
        this.y = vector.getY();
    }

    public Vector2 add(Vector2 vector) {
        x += vector.getX();
        y += vector.getY();
        return this;
    }

    public Vector2 subtract(Vector2 vector) {
        x -= vector.getX();
        y -= vector.getY();
        return this;
    }

    @Override
    public Vector2 clone() {
        try {
            Vector2 clone = (Vector2) super.clone();
            clone.setX(getX());
            clone.setY(getY());
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Vector2{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector2 vector2 = (Vector2) o;
        return x == vector2.x && y == vector2.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
