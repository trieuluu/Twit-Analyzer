

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.List;


public class GetTweets {
    
	/**
	 * getTweets method pulls tweets from @<username> timeline
	 * 
	 * @return String tweets
	 * @param String <username>
	 */
    public static String getTweets(String username) {
        
        Twitter twitter = new TwitterFactory().getInstance();
        
        
        try {
        	
            List<Status> statuses;

            //            String user;
//            if (args.length == 1) {
////                user = args[0];
//            	user = "messiahcollege";
//                statuses = twitter.getUserTimeline(user);
//            } else {
//                user = twitter.verifyCredentials().getScreenName();
//                statuses = twitter.getUserTimeline();
//            }
            
            statuses = twitter.getUserTimeline(username);
            
            System.out.println("Showing @" + username + "'s user timeline.");
            
            String tweets = "";

            for (Status status : statuses) {
            	
            	String each = status.getText();
            	
            	tweets += each;
            	
//                System.out.println("@" + status.getUser().getScreenName() + " - " + each);
            }
            
            return tweets;
            
        	} catch (TwitterException te) {
            
        		te.printStackTrace();
        		System.out.println("Failed to get timeline: " + te.getMessage());
//        		System.exit(-1);
        		return te.getMessage();
        }
    }
    
    /**
     * Testing getTweets method
     */
    public static void main(String[] args) {
    	getTweets("realDonaldTRump");
    	System.out.println(getTweets("realDonaldTRump").length());
    }
}


