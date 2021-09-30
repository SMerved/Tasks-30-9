import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main
{
    static Scanner scan;
    private static String[] text;

    public static void main(String[] args) throws FileNotFoundException
    {
        File file = new File("data.txt");
        scan = new Scanner(file);

        String inputFromFile = "";

        while (scan.hasNextLine())                                // checks if theres more lines in the file
        {
            inputFromFile += scan.nextLine();                     // adds each line to the inputFromFile string.
        }

        text = inputFromFile.split(" ");                    // Creates and array of strings, where each element is a single word from the file.
        System.out.println(text.length);

        // printWordsStartingWith("Ø");

        //printWordsOfLength(3);



        //test dine metoder ved at kalde dem her:
        // printLongestWord();
        // printWordsWithLessThanTwoVowels() ;
        //printFirstHalfOfEachWord();
        printMostFrequentLetter();
        printLeastFrequentLetter();
    }
    private static void printLeastFrequentLetter(){
        String letters="abcdefghijklmnopqrstuvwxyzæøå";
        int[] frequency=new int[29];
        int min=1000 ;
        char leastFrequentLetter='0' ;
        for(String s : text){
            s.toLowerCase();
            for(int i=0 ; i<s.length() ; i++){
                if(letters.indexOf(s.charAt(i))!=-1) {
                    frequency[letters.indexOf(s.charAt(i))]++ ;
                }
            }

        }
        for(int i=0 ; i<frequency.length ; i++){
            if(frequency[i]<min){
                min=frequency[i] ;
                leastFrequentLetter=letters.charAt(i) ;

            }
        }

        System.out.println(min);
        System.out.println(leastFrequentLetter);
    }
    private static void printMostFrequentLetter(){
        //String[] letters={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","æ","ø","å"} ;
        String letters="abcdefghijklmnopqrstuvwxyzæøå";
        int[] frequency=new int[29];
        int max=0 ;
        char mostFrequentLetter='0' ;
        for(String s : text){
            for(int i=0 ; i<s.length() ; i++){
                if(letters.indexOf(s.charAt(i))!=-1) {
                    frequency[letters.indexOf(s.charAt(i))]++ ;
                }
            }
        }
        for(int i=0 ; i<frequency.length ; i++){
            if(frequency[i]>max){
                max=frequency[i] ;
                mostFrequentLetter=letters.charAt(i) ;
            }
        }
        System.out.println(mostFrequentLetter);
        System.out.println(max);

    }
    private static void printFirstHalfOfEachWord(){
        for(String s : text) {
            System.out.println(s.substring(0,s.length()/2));
        }
    }
    private static void printWordsWithLessThanTwoVowels(){
        boolean wordIsValid=true ;
        int count=0 ;
        for(String s : text) {
            s.toLowerCase();
            wordIsValid=true ;
            for(int i=0 ; i<s.length() ; i++){

                if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='y'||s.charAt(i)=='æ'||s.charAt(i)=='ø'||s.charAt(i)=='å') {
                    count++ ;
                }
                if(s.charAt(i)=='0'||s.charAt(i)=='1'||s.charAt(i)=='2'||s.charAt(i)=='3'||s.charAt(i)=='4'||s.charAt(i)=='5'||s.charAt(i)=='6'||s.charAt(i)=='7'||s.charAt(i)=='8'||s.charAt(i)=='9'){
                    wordIsValid=false ;
                }
            }
            if(count<2 && wordIsValid==true) {
                System.out.println(s);
            }
            count=0 ;
        }
    }
    private static void printLongestWord(){
        String longestWord="" ;
        int counter ;
        for (String s : text) {

            counter = s.length();

            if (counter > longestWord.length()) {
                longestWord = s;

            }

        }
        System.out.println(longestWord);

    }

    private static void printWordsOfLength(int l)
    {
        boolean wordisvalid = true;

        for (String s : text)
        {
            if (s.length() == l)
            {
                if (s.contains(",") || s.contains("."))
                {
                    wordisvalid = false;
                }

                if (wordisvalid)
                {
                    System.out.println(s);
                }
            }
        }
    }

    private static void printWordsStartingWith(String pattern)
    {
        for (String s : text) // for each word in text
        {
            if (s.startsWith(pattern) || s.startsWith(pattern.toLowerCase()))
            {
                System.out.println(s);
            }
        }
    }

    //skriv dine metoder herunder:


}
