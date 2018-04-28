
public class Version1 {
	
	public static void main(String[] args) {
		
		System.out.println("This demo shows the TwitAnalyzer Version 1.");
		System.out.println("Input @usernam and the program will output ToneAnalytics results.");
		
		String tweets = GetTweets.getTweets("messiahcollege");
		
		String[][] toneResults = ToneAnalytics.toneAnalytics(tweets);
		
		ToneAnalytics.printTone(toneResults);
		
	}
}
