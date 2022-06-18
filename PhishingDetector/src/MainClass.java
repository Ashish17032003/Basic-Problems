// All the phishy words with their scores in the file WordScores and the text file (PhishyFile) is what it scans

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainClass
{
    public static void main(String[] args)
    {
        Map<String, Integer> scores = new HashMap<>();

        try(BufferedReader br = new BufferedReader( new FileReader("WordScores")))
        {
            String line = null;
            while (( line = br.readLine()) != null)
            {
                String[] splits = line.split(",");
                scores.put( splits[0].toLowerCase(), Integer.parseInt(splits[1]) );
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int runningTotal = 0;

        try(BufferedReader br = new BufferedReader( new FileReader("PhishyFile")))
        {
            String line = null;
            while (( line = br.readLine()) != null)
            {
                String[] splits = line.split(" ");
                for (String word : splits )
                {
                    word = word.toLowerCase();
                    if(scores.containsKey(word))
                    {
                        runningTotal += scores.get(word);
                    }
                }
            }
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The total phishing score for the file is " + runningTotal);
    }
}