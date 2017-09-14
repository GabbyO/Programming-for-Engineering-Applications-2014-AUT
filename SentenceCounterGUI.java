import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.TextField;
import java.util.StringTokenizer;
import java.awt.Component;

public class SentenceCounterGUI extends JPanel
{
	private JLabel label;
    private JButton countWordsButton;
    private JButton countVowelsButton;
    private JButton averageVowelsButton;
    private SentenceCounter sentenceCounter;
    private String sentence;
    private TextField textfield;
    private JLabel labelWord;
    private JLabel labelAverage;
    private JLabel labelVowel;
    
    //A constructor for creating a new SentenceCounterGUI
    public SentenceCounterGUI()
    {
	    //Create a new Text for the user to enter a sentence
	    textfield = new TextField(35);
	    
	    //Create a label to show the message
	    label = new JLabel("Enter a sentence");
	    
	    //Create a new SentenceCounter to use for the answers that user want
        sentenceCounter = new SentenceCounter(sentence);
        
        //Create a new ButtonListener to show the buttons
        ButtonListener listener = new ButtonListener();
        
        //Create a label to show the message
        labelWord = new JLabel("Count the Words: ");
        
        //Create a new ButtonListener with a message
        countWordsButton = new JButton("Count Words");
        
        //Add the addActionListener to ensure that the button to be able to work
        countWordsButton.addActionListener(listener);
        
        //Create a label to show the message
        labelVowel = new JLabel("Count the Vowels: ");
        
        //Create a new ButtonListener with a message
        countVowelsButton = new JButton("Count Vowels");
        
        //Add the addActionListener to ensure that the button to be able to work
        countVowelsButton.addActionListener(listener);
        
        //Create a label to show the message
        labelAverage = new JLabel("The average vowels: ");
        
        //Create a new ButtonListener with a message
        averageVowelsButton = new JButton("Average vowels");
        
        //Add the addActionListener to ensure that the button to be able to work
        averageVowelsButton.addActionListener(listener);
        
        
        //Add the labels, textfield and buttons to the panel 
        add(label);
        add(textfield);
        
        add(labelWord);
        add(countWordsButton);
        
        add(labelVowel);
        add(countVowelsButton);
        
        add(labelAverage);
		add(averageVowelsButton);
    }
    
    //The driver method that demonstrates a Frame
	public static void main(String[] args)
    {
        SentenceCounterGUI panel = new SentenceCounterGUI();
        JFrame frame = new JFrame("Sentence Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(panel);
        frame.setLocation(new Point(650, 400));
        frame.pack();
        frame.setSize(300, 200); 
        frame.setVisible(true);
    }

	private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {  
            Object source = e.getSource();
            if(source == countWordsButton)
            {   
            	//Get the sentence and count the words per sentence
            	sentenceCounter.countWords(textfield.getText());
            	
            	//The new Window will popped out with the answer
                JOptionPane.showMessageDialog(null,"Words counted: " + sentenceCounter.getNumberOfWords(), "Words", JOptionPane.INFORMATION_MESSAGE);     
            }  
            
            if(source == countVowelsButton)
            {   
	            //Get the sentence and count the vowels per sentence
            	sentenceCounter.countVowels(textfield.getText());
            	
            	//The new Window will popped out with the answer
            	JOptionPane.showMessageDialog(null,"Vowels counted: " + sentenceCounter.getNumberOfVowels(), "Vowels", JOptionPane.INFORMATION_MESSAGE);
            }      
            
            if(source == averageVowelsButton)
            {   
	            //Get the sentence and calculate the average of vowels per sentence
            	sentenceCounter.averageVowels(textfield.getText());
            	
            	//The new Window will popped out with the answer
            	JOptionPane.showMessageDialog(null,"Average of Vowels: " + sentenceCounter.getAverage(), "Average of Vowels", JOptionPane.INFORMATION_MESSAGE);
            }   
      }
   }
}
