package FinalProject_Template;

import java.util.ArrayList;

public class MyOwnTester {
	
	public static void main(String[] args) {
	MyHashTable<Integer,String> T = new MyHashTable<Integer,String>(10);

	
	T.put(1,"10");
	T.put(2, "20");
	T.put(3, "30");
	T.put(4, "50");
	T.put(5, "60");
	

	
	System.out.println(T.keys());
	System.out.println(T.values());
	System.out.println(T.slowSort(T));
	System.out.println(T.fastSort(T));

	
	

	
	
//	 private static ArrayList<Tweet> initTweetList() {
//	        ArrayList<Tweet> tweets = new ArrayList<Tweet>();
//	        Tweet tweet1 = new Tweet("1","2010-03-04 jhgjhgb"," I can be made into one twitter superstar.");
//	        Tweet tweet2 = new Tweet("6","2010-03-03 666"," They reached a compromise just on time");
//	        Tweet tweet3 = new Tweet("1","2010-03-07 kjkj2pij","I can be MADE into a need.");
//	        tweets.add(tweet1);
//	        tweets.add(tweet2);
//	        tweets.add(tweet3);
//	        
//	        return tweets;
//	 }
//	 
//	 public static void main(String[] args) {
//	
//		ArrayList<String> stopWords = new ArrayList<String>();  
//		ArrayList<Tweet> tweets = initTweetList();
//        Twitter t = new Twitter(tweets, stopWords);
//        
//        System.out.println(t.latestAuthorTweetsTable.get("1"));
//        System.out.println(t.tweetsByDate.get("2010-03-08"));
//
//		
		
//		authorTweetsTable.put(tweet1.getAuthor(), new ArrayList<Tweet>());
//		authorTweetsTable.get(tweet1.getAuthor()).add(tweet1);

		
		//System.out.println(authorTweetsTable.values());
		
		
//		String date= new String("2010-03-04 15:34:46");
//		String y= date.substring(0,10);
//		System.out.println(y);
//		System.out.println(t.tweetsByDate((date.substring(0,10))));
;		
		//System.out.println(tweetsByDate.values());
	     //twit.addTweet(a);
	    // System.out.println(t.latestTweetByAuthor("ahmad"));
	    // System.out.println(authorTweetsTabeT.get("one"));
	     //System.out.println(newT.get("Newone"));
	     //String author = ahmad.getAuthor();
	     //System.out.println(author);
	    // System.out.println(authorTweetsTable.get(tweet1.getAuthor()).get(0).getDateAndTime());
	     //System.out.println(tweet1.getDateAndTime().equals(authorTweetsTable.get(tweet2.getDateAndTime()).get(0).getDateAndTime()));
		
		
		
		
		
		
		
		//T.put("two", new ArrayList<String>());
//		T.put("three", 65);
//		T.put("four", 100);
//		T.put("five", 200);
		//T.get("one").add(ahmad);
		//T.get("one").add("");
//		T.get("two").add("ello");
		//System.out.println(MyHashTable.mergesort(T));
//		
//		ArrayList<HashPair<Integer,Integer>> list= new ArrayList<HashPair<Integer,Integer>>();
//		for(HashPair pair: T) {
//			list.add(pair);
//			//System.out.println("("+pair.getKey()+", "+pair.getValue()+")");
//		}
//		ArrayList<HashPair<Integer,Integer>> decend=MyHashTable.mergesort(list);
//		
//		for(HashPair pair: decend) {
//			//list.add(pair);
//			System.out.println("("+pair.getKey()+", "+pair.getValue()+")");
//		}
//		
		//ArrayList<String> sortedResults = new ArrayList<>();
//		System.out.println(MyHashTable.fastSort(T));
//		System.out.println(MyHashTable.slowSort(T));
		//for(HashPair pair: sortedResults) {
			//list.add(pair);
			//System.out.println("("+pair.getKey()+", "+pair.getValue()+")");
		//}
		
//		ArrayList<HashPair<Integer,Integer>> newL= new ArrayList<HashPair<Integer,Integer>>();
//		System.out.println(list.remove(0).getKey());
//		
		
		
		
//		int mid= list.size()/2;
//		
//		ArrayList<HashPair<Integer,Integer>> list1=  new ArrayList<HashPair<Integer,Integer>>();
//		for(int i=0; i < (mid); i++) {
//			list1.add(list.get(i));
//			System.out.println("("+list.get(i).getKey()+", "+list.get(i).getValue()+")");
//		}
//		ArrayList<HashPair<Integer,Integer>> list2=  new ArrayList<HashPair<Integer,Integer>>();
//		for(int i=mid; i < list.size(); i++) {
//			list1.add(list.get(i));
//			System.out.println("("+list.get(i).getKey()+", "+list.get(i).getValue()+")");
//		}
		
		//System.out.println(list1);
		//System.out.println(list2);
	//	T.put(14, "fou");
		//	T.put(5, "five");
		//	T.put(6, "six");
		//	T.put(7, "seven");
		//	T.put(8, "eight");
		//	System.out.println(T.getBuckets());
		//	//System.out.println(T.getBuckets().size());
		//	System.out.println(T.size());
		//	
		//	System.out.println(T.get(1));
		//	
		//	T.remove(1);
		//	T.remove(2);
		//	T.remove(3);
		//	T.remove(4);
		//	T.remove(5);
		//	T.remove(6);
		//	T.remove(7);
		//	
		//
		//	System.out.println("After remobving ");
		//	System.out.println(T.size());
		//	
		//	System.out.println(T.get(1));
		//	System.out.println(T.get(2));
		//	System.out.println(T.get(3));
		//	System.out.println(T.get(4));
		//	System.out.println(T.get(5));
		//	System.out.println(T.get(6));
		//	System.out.println(T.get(7));
		//	System.out.println(T.get(8));
		//	
		//	System.out.println(T.getBuckets());
		//System.out.println(MyHashTable.slowSort(T));
		//System.out.println(T.keys());
		//System.out.println(T.values());
		//System.out.println(T.values().subList(0, 1));
		//System.out.println(T.values().size());
		//System.out.println(MyHashTable.mergesort(null);
		//****************************************************************************

		//ITERATOR CHECK!!
//
//		MyHashIterator Iter= T.iterator();
//
//		//while(Iter.hasNext()) {
//
//			System.out.println(Iter.next().getValue());
//	
//			System.out.println(Iter.next().getValue());
//			
//			System.out.println(Iter.next().getValue());
//			
//			System.out.println(Iter.next().getValue());
//			//System.out.println(Iter.hasNext());
//			System.out.println(Iter.next().getValue());
//			HashPair<Integer,String> nums= Iter.next();
//			System.out.print(nums.getKey()+ "    " + nums.getValue() +"\n");

		//}		
//*********************************************************************************************\\
	
    


//System.out.println(MyHashTable.slowSort(T));

	}
}


