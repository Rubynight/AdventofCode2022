import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2 {
    public static List<String> opponent = new ArrayList<>();
    public static List<String> player = new ArrayList<>();

    public static int solveP1() {
        read();
        int total = 0;
        for (int i = 0; i < opponent.size(); i++) {
            if (player.get(i).equals("X")) {
                total += 1;
                if (opponent.get(i).equals("A")) {
                    total += 3;
                }
                if (opponent.get(i).equals("B")) {
                    total += 0;
                }
                if (opponent.get(i).equals("C")) {
                    total += 6;
                }
            }
            if (player.get(i).equals("Y")) {
                total += 2;
                if (opponent.get(i).equals("A")) {
                    total += 6;
                }
                if (opponent.get(i).equals("B")) {
                    total += 3;
                }
                if (opponent.get(i).equals("C")) {
                    total += 0;
                }
            }
            if (player.get(i).equals("Z")) {
                total += 3;
                if (opponent.get(i).equals("A")) {
                    total += 0;
                }
                if (opponent.get(i).equals("B")) {
                    total += 6;
                }
                if (opponent.get(i).equals("C")) {
                    total += 3;
                }
            }
        }
        return total;
    }

    public static int solveP2() {
        int total = 0;
        for (int i = 0; i < opponent.size(); i++) {
            if (player.get(i).equals("X")) {
                total += 0;
                if (opponent.get(i).equals("A")) {
                    total += 3;
                }
                if (opponent.get(i).equals("B")) {
                    total += 1;
                }
                if (opponent.get(i).equals("C")) {
                    total += 2;
                }
            }
            if (player.get(i).equals("Y")) {
                total += 3;
                if (opponent.get(i).equals("A")) {
                    total += 1;
                }
                if (opponent.get(i).equals("B")) {
                    total += 2;
                }
                if (opponent.get(i).equals("C")) {
                    total += 3;
                }
            }
            if (player.get(i).equals("Z")) {
                total += 6;
                if (opponent.get(i).equals("A")) {
                    total += 2;
                }
                if (opponent.get(i).equals("B")) {
                    total += 3;
                }
                if (opponent.get(i).equals("C")) {
                    total += 1;
                }
            }
        }
        return total;
    }

    public static void read() {
        //ArrayList<String[]> enterinfo = new ArrayList<String[]>();
        String filepath = "C:\\School\\java\\AdventofCode2022\\dailys\\Input\\Q2";
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
                String input[] = sc.nextLine().split(" ");
                opponent.add(input[0]);
                player.add(input[1]);
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
        return;
    }
}
