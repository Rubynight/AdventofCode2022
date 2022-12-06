import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1 {
    public static int solveP1() {
        List<Integer> calories = read();
        int max = 0;
        for (Integer input : calories) {
            if (input > max) {
                max = input;
            }
        }
        return max;
    }

    public static int solveP2() {
        List<Integer> calories = read();
        int first = Integer.max(Integer.max(calories.get(0), calories.get(1)), calories.get(2));
        int second = 0;
        int third = Integer.min(Integer.min(calories.get(0), calories.get(1)), calories.get(2));
        for (int i = 0; i < 3; i++) {
            if (calories.get(i) != first && calories.get(i) != third) {
                second = calories.get(i);
            }
        }

        for (int i = 3; i < calories.size(); i++) {
            if (calories.get(i) > third) {
                if (calories.get(i) >= second) {
                    if (calories.get(i) >= first) {
                        third = second;
                        second = first;
                        first = calories.get(i);
                    } else {
                        third = second;
                        second = calories.get(i);
                    }
                } else {
                    third = calories.get(i);
                }
            }

        }
        return first+second+third;
    }

    public static List<Integer> read() {
        //ArrayList<String[]> enterinfo = new ArrayList<String[]>();
        String filepath = "C:\\School\\java\\AdventofCode2022\\dailys\\Input\\Q1";
        List<Integer> entered = new ArrayList<>();
        try {
            //the file to be opened for reading
            //Testing if push works
            FileInputStream fis = new FileInputStream(filepath);
            Scanner sc = new Scanner(fis);    //file to be scanned
            int total = 0;

            //returns true if there is another line to read
            while (sc.hasNextLine()) {
                //String s[] = sc.nextLine().split(" ");
                //enterinfo.add(s);
                String input = sc.nextLine();
                if (input.equals("")) {
                    entered.add(total);
                    total = 0;
                } else {
                    total += Integer.parseInt(input);
                }
                //System.out.println(sc.nextLine());      //returns the line that was skipped
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }

        //String s[] = enterinfo.get(0);
        //int a = Integer.parseInt(s[0]);
//        Integer[] test = new Integer[entered.size()];
//        test = entered.toArray(test);
//        int[] return_val = test
        return entered;
    }
}
