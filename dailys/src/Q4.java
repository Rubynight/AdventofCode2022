import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {
    public static int solveP1() {
        List<String> entry = read();
        int total = 0;

        for (int i = 0; i < entry.size(); i++) {
            String[] comma = entry.get(i).split(",");
            String[] left = comma[0].split("-");

            String[] right = comma[1].split("-");

            if (helper(convert(left[0]), convert(left[1]),convert(right[0]), convert(right[1]))) {
                total+=1;
                continue;
            }
            if (helper(convert(right[0]), convert(right[1]),convert(left[0]), convert(left[1]))) {
                total+=1;
            }
        }
        return total;
    }

    public static int convert(String value) {
        return Integer.parseInt(value);
    }
    public static boolean helper(int LLower, int LUpper, int RLower, int RUpper) {
        if (RLower <= LLower && RUpper >= LUpper) {
            return true;
        }
        return false;
    }

    public static boolean helperP2(int LLower, int LUpper, int RLower, int RUpper) {
        if (RLower > LUpper || RUpper < LLower) {
            return false;
        }
        return true;
    }

    public static int solveP2() {
        List<String> entry = read();
        int total = 0;

        for (int i = 0; i < entry.size(); i++) {
            String[] comma = entry.get(i).split(",");
            String[] left = comma[0].split("-");

            String[] right = comma[1].split("-");

            if (helperP2(convert(left[0]), convert(left[1]),convert(right[0]), convert(right[1]))) {
                total+=1;
            }

        }
        return total;
    }

    public static List<String> read() {
        //ArrayList<String[]> enterinfo = new ArrayList<String[]>();
        String filepath = "C:\\School\\java\\AdventofCode2022\\dailys\\Input\\Q4";
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
                //System.out.println(sc.nextLine());      //returns the line that was skipped
            }
            sc.close();     //closes the scanner
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entered;
    }
}
