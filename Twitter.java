package FinalProject_Template;
import java.util.ArrayList;


public class Twitter {
	
	//ADD YOUR CODE BELOW HERE
	ArrayList<String> stopWords; 
	MyHashTable<String, ArrayList<Tweet>> tweetsByDate;
	MyHashTable<String, ArrayList<Tweet>> allTweets;
	MyHashTable<String, Integer> trendingWords;
	MyHashTable<String, Tweet> latestAuthorTweetsTable;
	ArrayList<Tweet> tweets;
	
		
	//ADD CODE ABOVE HERE 
	
	// O(n+m) where n is the number of tweets, and m the number of stopWords
	public Twitter(ArrayList<Tweet> tweets, ArrayList<String> stopWords) {
		//ADD YOUR CODE BELOW HERE
		tweetsByDate=new MyHashTable<String,ArrayList<Tweet>>(tweets.size());
		latestAuthorTweetsTable= new MyHashTable<String,Tweet>(tweets.size());
		allTweets= new MyHashTable<String,ArrayList<Tweet>>(tweets.size());
		trendingWords= new MyHashTable<String, Integer>(tweets.size());
		this.tweets= new ArrayList<Tweet>();
		this.stopWords= new ArrayList<String>(stopWords.size());
		for(int i=0; i<stopWords.size(); i++) {
			String word= stopWords.get(i).toLowerCase();
			this.stopWords.add(word);
		}
		for(Tweet t: tweets) {
			addTweet(t);
		}
	}
    /**
     * Add Tweet t to this Twitter
     * O(1)
     */
	public void addTweet(Tweet t) {
		//ADD CODE BELOW HERE
		
		latestAuthorTweetsTable.put(t.getAuthor(), t);
		addByDate(t);
		addByAuthor(t);
		this.tweets.add(t);
		//System.out.println(allTweets.values());
		//ADD CODE ABOVE HERE 
	}
    /**
     * Search this Twitter for the latest Tweet of a given author.
     * If there are no tweets from the given author, then the 
     * method returns null. 
     * O(1)  
     */
    public Tweet latestTweetByAuthor(String author) {
        //ADD CODE BELOW HERE
    	return latestAuthorTweetsTable.get(author);
        //ADD CODE ABOVE HERE 
    }
    
    /**
     * 
     * @param t
     */
    private void addByAuthor(Tweet t) {
  		
			
  		if(allTweets.size()==0) {
  	//		System.out.println("here");
  			allTweets.put(t.getAuthor(),new ArrayList<Tweet>());
  			allTweets.get(t.getAuthor()).add(t);
  	//		System.out.println(tweetsByDate.values());
  		}
  		else {
  			//if the author does not exist already in the authorsTweets HashTable
  			if(allTweets.get(t.getAuthor())==null){
  		//		System.out.println("different date");
  				allTweets.put(t.getAuthor(),new ArrayList<Tweet>());
  				allTweets.get(t.getAuthor()).add(t);
  		//		System.out.println(tweetsByDate.values());

  			}
  			// if the key already exist
  			else {
  			//	System.out.println("SAme date but size is not 1");
  				allTweets.get(t.getAuthor()).add(t);
  			//	System.out.println(tweetsByDate.values());
  			}
  		}


  	}
  //O(1)
  	private void addByDate(Tweet t) {
  		
  			
  		if(tweetsByDate.size()==0) {
  	//		System.out.println("here");
  			tweetsByDate.put(t.getDateAndTime().substring(0,10),new ArrayList<Tweet>());
  			tweetsByDate.get(t.getDateAndTime().substring(0,10)).add(t);
  	//		System.out.println(tweetsByDate.values());
  		}
  		else {
  			//if the key does not exist already in the tweetsByDate HashTable
  			if(tweetsByDate.get(t.getDateAndTime().substring(0,10))==null){
  		//		System.out.println("different date");
  				tweetsByDate.put(t.getDateAndTime().substring(0,10),new ArrayList<Tweet>());
  				tweetsByDate.get(t.getDateAndTime().substring(0,10)).add(t);
  		//		System.out.println(tweetsByDate.values());

  			}
  			// if the key already exist
  			else {
  			//	System.out.println("SAme date but size is not 1");
  				tweetsByDate.get(t.getDateAndTime().substring(0,10)).add(t);
  			//	System.out.println(tweetsByDate.values());
  			}
  		}


  	}


    /**
     * Search this Twitter for Tweets by `date' and return an 
     * ArrayList of all such Tweets. If there are no tweets on 
     * the given date, then the method returns null.
     * O(1)
     */
    public ArrayList<Tweet> tweetsByDate(String date) {
        //ADD CODE BELOW HERE
    	return tweetsByDate.get(date);
        //ADD CODE ABOVE HERE
    }
    
	/**
	 * Returns an ArrayList of words (that are not stop words!) that
	 * appear in the tweets. The words should be ordered from most 
	 * frequent to least frequent by counting in how many tweet messages
	 * the words appear. Note that if a word appears more than once
	 * in the same tweet, it should be counted only once. 
	 */
    public ArrayList<String> trendingTopics() {
    	//ADD CODE BELOW HERE

    	for(Tweet t: tweets) {
    		ArrayList<String> wordsList= new ArrayList<String>();
    		ArrayList<String> wordsAlreadyCounted= new ArrayList<String>();
    		wordsList= getWords(t.getMessage().toLowerCase());
    		for(String word: wordsList) {
    			
    			boolean isStopWord= false;
    			
    			if(stopWords != null) {
    				
    				if(stopWords.contains(word)) {
    					isStopWord= true;
    				}
    				
    				boolean isSameWord=false;
    				if(wordsAlreadyCounted.contains(word)) {
    					isSameWord=true;
    				}
    				
    				if(isStopWord==false && isSameWord==false) {
    					if(trendingWords.get(word)!=null) { 
    						int count= trendingWords.get(word);
    						trendingWords.put(word, count+1);
    						wordsAlreadyCounted.add(word);
    					}
    					else {
    						trendingWords.put(word, 1);
    					}
    				}
    			}
    		}
    	}
    	return MyHashTable.fastSort(trendingWords);

    	//ADD CODE ABOVE HERE    	
    }
    
    
    
    /**
     * An helper method you can use to obtain an ArrayList of words from a 
     * String, separating them based on apostrophes and space characters. 
     * All character that are not letters from the English alphabet are ignored. 
     */
    private static ArrayList<String> getWords(String msg) {
    	msg = msg.replace('\'', ' ');
    	String[] words = msg.split(" ");
    	ArrayList<String> wordsList = new ArrayList<String>(words.length);
    	for (int i=0; i<words.length; i++) {
    		String w = "";
    		for (int j=0; j< words[i].length(); j++) {
    			char c = words[i].charAt(j);
    			if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))
    				w += c;
    			
    		}
    		wordsList.add(w);
    	}
    	return wordsList;
    }

    

}
