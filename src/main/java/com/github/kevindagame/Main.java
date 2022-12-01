package com.github.kevindagame;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Integer> instances = new ArrayList<>();
    public static void main(String[] args) {
        try {
            URL resource = Main.class.getClassLoader().getResource("day1.txt");
            assert resource != null;
            File myObj = new File(resource.toURI());
            Scanner myReader = new Scanner(myObj);
            var count = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(data.length() == 0) {
                    instances.add(count);
                    count = 0;
                }
                else{
                    count += Integer.valueOf(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        System.out.println(instances.stream().max(Integer::compare));
        System.out.println(getMax());
    }

    private static int getMax() {
        List<Integer> max = new ArrayList<>();
        var copy = new ArrayList<>(instances);
        while(max.size() < 3) {
            var m = 0;
            for (int i :
                    copy) {
                if(i > m) m = i;
            }
            max.add(m);
            copy.remove(copy.indexOf(m));
        }
        var total = 0;
        for (var i :
                max) {
            total += i;
        }
        return total;
    }
}