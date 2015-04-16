package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Created by Eike on 16.04.2015.
 */
public class Analyzer {

    private ArrayList<String[]> sList = new ArrayList<String[]>();

    public Analyzer(String filename) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filename));
        lines.forEach(s -> sList.add(s.split(";")));
    }

    public ArrayList<String[]> getsList() {
        return sList;
    }

}
