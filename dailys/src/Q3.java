import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//todo: used additional space for Q1, can optimize
public class Q3 {
    public static List<String> first = new ArrayList<>();
    public static List<String> second = new ArrayList<>();
    public static int solveP1() {
        read();
        int total = 0;

        for (int i = 0; i < first.size(); i++) {
            int[] left = new int[53];
            int[] right = new int[53];
            for (int j = 0; j < first.get(i).length(); j++) {
                int val_left = helper(first.get(i).charAt(j));


                int val_right = helper(second.get(i).charAt(j));

                if (left[val_right] == 0) {
                    right[val_right]++;
                } else {
                    total += val_right;
                    break;
                }
                if (right[val_left] == 0) {
                    left[val_left]++;
                } else {
                    total += val_left;
                    break;
                }
            }
        }
        return total;
    }

    public static int helper(char entry) {
        if (Character.isUpperCase(entry)) {
            return entry - 'A' + 27;
        } else {
            return entry - 'a' + 1;
        }
    }

    public static int solveP2() {
        List<String> entry = read();
        int total = 0;
        for (int i = 0; i < entry.size(); i+=3) {
            String line1 = entry.get(i);
            String line2 = entry.get(i+1);
            String line3 = entry.get(i+2);
            for (int j = 0; j < line1.length(); j++) {

                if (line2.contains(line1.substring(j, j + 1)) && line3.contains(line1.substring(j, j + 1))) {
                    total += helper(line1.charAt(j));
                    break;
                }
            }
        }
        return total;
    }

    public static List<String> read() {
        //ArrayList<String[]> enterinfo = new ArrayList<String[]>();
        String filepath = "C:\\School\\java\\AdventofCode2022\\dailys\\Input\\Q3";
        List<String> entered = new ArrayList<>();
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
                entered.add(input);
                first.add(input.substring(0, input.length()/2));
                second.add(input.substring(input.length()/2));
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
