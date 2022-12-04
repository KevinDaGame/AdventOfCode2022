package com.github.kevindagame.common;

import com.github.kevindagame.day2.Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    public static List<String> readFile(String file) throws URISyntaxException, FileNotFoundException {
        List<String> lines = new ArrayList<>();
        URL resource = Main.class.getClassLoader().getResource(file);
        assert resource != null;
        File myObj = new File(resource.toURI());
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            lines.add(data);
        }
        return lines;
    }
}
