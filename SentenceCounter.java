import java.util.Scanner;
import javax.swing.JPanel;
import java.util.StringTokenizer;

public class SentenceCounter 
{
	private String sentence;
	private int numberOfWords;
	private int numberOfVowels;
	private double average;
	
	//A constructor for creating a new SentenceCounter
	public SentenceCounter(String sentence)
	{
		sentence = this.sentence;
		numberOfWords = 0;
		numberOfVowels = 0;
		average = 0;
	} 
	
	//Count the words per sentence using Char and for loop from Array
	public void countWords(String sentence)
	{
		numberOfWords = 0;
		
		char character[]= new char[sentence.length()];
		
        for(int i = 0; i < sentence.length(); i++)
        {
            character[i] = sentence.charAt(i);
            
            if(((i > 0) && (character[i] != ' ') && (character[i - 1] == ' ')) || ((character[0] != ' ') && (i == 0)))
            	numberOfWords++;
        }
        //Print out the message of the number of words per sentence
	    System.out.println("Count of words: " + numberOfWords);
	}
	
	//Count the vowels per sentence using the Char and from Array, also for loop
	public void countVowels(String sentence)
	{
		//Store the vowels of a,e,i,o,u and their capital letters into array
		char[] vowel = new char[]{'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
		
	    int[] numberOfVowelsArray = new int[10];
	    
	    for (int i = 0; i < sentence.length(); i++) 
	    {
	        char character = sentence.charAt(i);

	        if(character == 'a')
	            numberOfVowelsArray[0]++;
	            
	        else if(character == 'e')
	            numberOfVowelsArray[1]++;
	            
	        else if(character == 'i')
	            numberOfVowelsArray[2]++;
	            
	        else if(character == 'o')
	            numberOfVowelsArray[3]++;
	            
	        else if(character == 'u')
	            numberOfVowelsArray[4]++;
	            
	        else if(character == 'A')
	            numberOfVowelsArray[5]++;
	            
	        else if(character == 'E')
	            numberOfVowelsArray[6]++;
	            
	        else if(character == 'I')
	            numberOfVowelsArray[7]++;
	            
	        else if(character == 'O')
	            numberOfVowelsArray[8]++;
	            
	        else if(character == 'U')
	            numberOfVowelsArray[9]++;
	    }

	    numberOfVowels = 0;

	    for (int i = 0; i < numberOfVowelsArray.length; i++) 
	    {
		    //Print out the message of the number of vowels per sentence
	    	System.out.println("Count of vowels: " + vowel[i] + " = " + numberOfVowelsArray[i]);

            numberOfVowels += numberOfVowelsArray[i];
	    }
	}
	
	//Compute the average of the vowels from per sentence using if statement and for loop from Array with switch statement
	public void averageVowels(String sentence)
	{       
        //Calculate the average of vowels
        average =  (double)getNumberOfVowels()/(double)getNumberOfWords();
        
        //Print out the message of the average of vowels per sentence
        System.out.println("The average of Vowels is: " + average);
	}
	
	//Get the number of the word when the user enter a sentence
	public int getNumberOfWords()
	{
		return this.numberOfWords;
	}
	
	//Get the number of the vowels when the user enter a sentence
	public int getNumberOfVowels() 
	{
		return this.numberOfVowels;
	}
	
	//Get the average of the vowels
	public double getAverage()
	{
		return this.average;
	}
	
	//Get the sentence
	public String toString()
	{
		return this.sentence;
	}

	//The driver method that demonstrates the answers of the counting vowels, words and average of vowels.
	public static void main(String[] args)
	{
	    Scanner scan = new Scanner(System.in);
	    String sentence = scan.nextLine();
		
	    //Create a new SentenceCounter to demostrate the methods
		SentenceCounter sentCount = new SentenceCounter(sentence);
		
		//Demostrate the methods for GUI
		sentCount.countVowels(sentence);
		sentCount.countWords(sentence);
		sentCount.averageVowels(sentence);
	}
}
