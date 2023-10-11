import java.util.Scanner;
public class LabRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //variables
        int points = 0;
        int words = 0;
        String previousWord = "";
        //first word
        System.out.print("Enter first word: ");
        words ++;
        String firstWord = scan.nextLine();
        System.out.print("Enter next word: ");
        words ++;
        String currentWord = scan.nextLine();
        if ((firstWord.compareTo(currentWord) < 0)) {
            points += 2;
            System.out.println("+2 points: current word alphabetically after; SCORE: " + points);
        }
        if ((firstWord.compareTo(currentWord) > 0)) {
            points -= 5;
            System.out.println("-5 points: current word alphabetically before; SCORE: " + points);
        }
        if ((firstWord.compareTo(currentWord) == 0)) {
            points -= 10;
            System.out.println("-10 points: current word and previous word are the same; SCORE: " + points);
        }
        if ((firstWord.substring((firstWord.length() - 2), firstWord.length())).equals(currentWord.substring(0, 2))) {
            points += 5;
            System.out.println("+5 points: last 2 letters of previous match first 2 letters of current; SCORE: " + points);
        }
        previousWord = currentWord;




        //loop
        while (points < 50) {
            System.out.print("Enter next word: ");
            words ++;
            currentWord = scan.nextLine();
            if ((currentWord.compareTo(previousWord) > 0)){
                points += 2;
                System.out.println("+2 points: current word alphabetically after; SCORE: " + points);
            }
            if ((currentWord.compareTo(previousWord) < 0)) {
                points -= 5;
                System.out.println("-5 points: current word alphabetically before; SCORE: " + points);
            }
            if ((currentWord.compareTo(previousWord) == 0)) {
                points -= 10;
                System.out.println("-10 points: current word and previous word are the same; SCORE: " + points);
            }
            if ((previousWord.substring((previousWord.length() - 2), previousWord.length())).equals((currentWord.substring(0, 2)))) {
                points += 5;
                System.out.println("+5 points: last 2 letters of previous match first 2 letters of current; SCORE: " + points);
            }
            if (currentWord.indexOf(previousWord.substring(0, 1)) != -1) {
                points += 3;
                System.out.println("+3 points: first letter of previous word found in current word; SCORE: " + points);
            }
            previousWord = currentWord;
        }
        System.out.println("You win! It took you " + words + " words! Try again for a lower score count :)");

    }
}