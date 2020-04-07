import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

interface  Task{
    int Question( int type_);
}

class Task_class implements Task {

    @Override
    public int Question(int type_) {

        if (type_ == 1) {
            Scanner in = new Scanner(System.in);
            System.out.println("Array Type:" + "\n" + "1.Int" + "\n" + "2.String");
            int num = in.nextInt();
            return num;

        }
        if (type_ == 2) {

            Scanner in = new Scanner(System.in);
            System.out.println("Select a handler:" + "\n" + "1. The first handler returns the sum, the average value, the minimum and maximum element"
                    + "\n" + "2. The second handler removes even or odd elements from the list, depending on the setting" + "\n" + "3. Apply both handlers");
            int num = in.nextInt();
            return num;
        }
        if (type_ == 3) {

            Scanner in = new Scanner(System.in);
            System.out.println("Delete: " + "\n" + "1.Even" + "\n" + "2.Odd");
            int num = in.nextInt();
            in.close();
            return num;

        }
        if (type_ == 4) {

            Scanner in = new Scanner(System.in);
            System.out.println("Select a handler:" + "\n" + "1. The first handler - returns the glued string"
                    + "\n" + "2. The second handler counts the number of words in each line, the total number of words and characters across all lines of the list" + "\n" + "3. Apply both handlers");
            int num = in.nextInt();
            in.close();
            return num;
        } else {
            return 0;
        }
    }
}

class Worker extends Task_class{
    public static ArrayList<Integer> listInt;
    public static String[][] listStr;

    Worker(ArrayList<Integer> listInt, String[][] listStr) throws IOException, InterruptedException {
        this.listInt = listInt;
        this.listStr = listStr;
    }

    public static void work() throws IOException, InterruptedException{

        //Create to hands ( int and string) to help with task
        Handler int_hand = new Handler();
        Handler str_hand = new Handler();

        App task = new App();
        int  q = 0;
        int type = 0;
        String Type = " ";
        q = task.Question(1);
        switch (q) {
            case 1:
                listInt = Generator.Gen(type);
                q = task.Question(2);
                if (q == 1) {
                    int_hand.getIntResultFirst(listInt);
                    break;
                }
                if (q == 2) {
                    q = task.Question(3);
                    if (q == 1 || q == 2) {
                        int_hand.getIntResultSecond(listInt, q);
                        break;
                    } else {
                        System.out.println("Input Error!");
                        System.exit(0);
                    }
                }
                if (q == 3) {
                    q = task.Question(3);
                    if (q == 1 || q == 2) {
                        int_hand.getIntResultFirst(listInt);
                        System.out.println();
                        int_hand.getIntResultSecond(listInt, q);
                        break;
                    } else {
                        System.out.println("Input Error!");
                        System.exit(0);
                    }
                } else {
                    System.out.println("Input Error!");
                    System.exit(0);
                }

            case 2:
                listStr = Generator.Gen(Type);
                q = task.Question(4);
                if (q == 1) {
                    str_hand.getStrResultFirst(listStr);
                    break;
                }
                if (q == 2) {
                    str_hand.getStrResultSecond(listStr);
                    break;
                }
                if (q == 3) {
                    str_hand.getStrResultFirst(listStr);
                    System.out.println();
                    str_hand.getStrResultSecond(listStr);
                    break;
                } else {
                    System.out.println("Input Error!");
                    System.exit(0);
                }

            default:
                System.out.println("Input Error!");
                break;

        }
    }
}