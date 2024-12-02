package org.devpush.com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static List<String> readInput(boolean test, int day, boolean partb) throws IOException {
        String testDir = "";
        if (test) {
            testDir = (partb) ? "test_b" : "test_a";
        } else {
            testDir = (partb) ? "input_b" : "input_a";
        }
        BufferedReader br = new BufferedReader(new FileReader(testDir + "/day" + day + ".txt"));
        String line;
        List<String> list = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        return list;
    }
}
