

// This demo shows tone analyzer

// https://www.ibm.com/developerworks/library/cc-sample-code-tone-analyzer-watson-java/index.html

import java.util.List;



import com.ibm.watson.developer_cloud.tone_analyzer.v3.ToneAnalyzer;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.DocumentAnalysis;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneAnalysis;
//import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneCategory;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneOptions;
import com.ibm.watson.developer_cloud.tone_analyzer.v3.model.ToneScore;




public class ToneAnalytics {

	/**
	 * toneAnalytics method analyzes tone from input text.
	 * 
	 * @return results with percentage score
	 * @param String text
	 */
  public static String[][] toneAnalytics(String text)  {
    
	  ToneAnalyzer service = new ToneAnalyzer("2017-09-21");
    
	  service.setUsernameAndPassword("14602cea-da88-4f3b-b8c0-70e6a72b891d", "rPXCxyRRcC6n");
	  
	  if (text.length() == 0) {
    
		  text = "I know the times are difficult! Our sales have been "
    	    + "disappointing for the past three quarters for our data analytics "
    	    + "product suite. We have a competitive data analytics product "
    	    + "suite in the industry. But we need to do our job selling it! "
    	    + "We need to acknowledge and fix our sales challenges. "
    	    + "We can't blame the economy for our lack of execution! "
    	    + "We are missing critical sales opportunities. "
    	    + "Our product is in no way inferior to the competitor products. "
    	    + "Our clients are hungry for analytical tools to improve their "
    	    + "business outcomes. Economy has nothing to do with it.";
//    String text = "\"Now that Trump is president, I'm going to shoot you and all the blacks I can find\"";
//    String text = "I am declicous ground meat made from potato, coconut, wheat and heme"
//    		+" I taste like beef, look like beef and can even sizzle but I have no cholesterol. I am all burger, baby";
	  }
    // Call the service and get the tone
    
    ToneOptions toneOptions = new ToneOptions.Builder()
        .text(text)
        .build();
    
    ToneAnalysis tone = service.tone(toneOptions).execute();
    
    DocumentAnalysis elementTone = tone.getDocumentTone();
        
    List<ToneScore> toneScores = elementTone.getTones();
    
    int rows = toneScores.size();
    int columns = 2;
    int counter = 0;
    
    String[][] result = new String[rows][columns]; 
    		
    for (ToneScore nextScore : toneScores) {
    	
    	result[counter][0] = nextScore.getToneName();
    	result[counter][1] = ((int) (nextScore.getScore() * 100)) + "%";
    	
//    	System.out.println("" + nextScore.getToneName() + " = " +
//                         (int)(nextScore.getScore() * 100) + "%");
    	counter++;
    }
    
//    System.out.println();
    
    return result;
  }
  
  public static void printTone(String[][] result) {
	  for (int i = 0; i < result.length; i++) {
			System.out.println(result[i][0] +" = " + result[i][1]);
	}
  }
  
  /**
   * Testing toneAnalytics method
   */
  public static void main(String[] args) {
//  	toneAnalytics("");
//  	System.out.println(toneAnalytics("").length);
  	
  	String[][] result = toneAnalytics("");
  	printTone(result);
//  	for (int i = 0; i < result.length; i++) {
//  			System.out.println(result[i][0] +" = " + result[i][1]);
//  	}
  }
}