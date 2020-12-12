package FinalProject_Template;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class MyHashTable<K,V> implements Iterable<HashPair<K,V>>{
    // num of entries to the table
    private int numEntries;
    // num of buckets 
    private int numBuckets;
    // load factor needed to check for rehashing 
    private static final double MAX_LOAD_FACTOR = 0.75;
    // ArrayList of buckets. Each bucket is a LinkedList of HashPair
    private ArrayList<LinkedList<HashPair<K,V>>> buckets; 
    
    // constructor
    public MyHashTable(int initialCapacity) {
        // ADD YOUR CODE BELOW THIS
    	this.numBuckets= initialCapacity;
    	this.numEntries= 0;
    	this.buckets= new ArrayList<LinkedList<HashPair<K,V>>>(initialCapacity);
    	for (int i=0; i< initialCapacity; i++) {
    		buckets.add(i , new LinkedList<HashPair<K,V>>());
    	}
    	
        //ADD YOUR CODE ABOVE THIS
    }
    
    public int size() {
        return this.numEntries;
    }
    
    public boolean isEmpty() {
        return this.numEntries == 0;
    }
    
    public int numBuckets() {
        return this.numBuckets;
    }
    
    /**
     * Returns the buckets variable. Useful for testing  purposes.
     */
    public ArrayList<LinkedList< HashPair<K,V> > > getBuckets(){
        return this.buckets;
    }
    
    /**
     * Given a key, return the bucket position for the key. 
     */
    public int hashFunction(K key) {
        int hashValue = Math.abs(key.hashCode())%this.numBuckets;
        return hashValue;
    }
    
    /**
     * Takes a key and a value as input and adds the corresponding HashPair
     * to this HashTable. Expected average run time  O(1)
     */
    public V put(K key, V value) {
    	//  ADD YOUR CODE BELOW HERE
    	V old= null;
    	//int linkListIndex=0;
    	
    	
    	int index = this.hashFunction(key);
    	LinkedList<HashPair<K,V>> entryList = this.buckets.get(index);

    	//checking if there is any duplicate keys
    	for(HashPair<K,V> pair: entryList) {
    		if(pair.getKey().equals(key)) {
    			old= pair.getValue();
    			pair.setValue(value);
    			//linkListIndex++;
    			return old;
    		}	
    		
    		
    	}
    	HashPair<K,V> newpair = new HashPair<K,V>(key,value);
    	
    	entryList.add(newpair);
		this.numEntries++;
		
//		
//		
//		System.out.println("numEntries	"+ this.numEntries+"	"+this.size());
//		System.out.println("numBuckets	"+ this.numBuckets+"	"+this.numBuckets());
//		System.out.println((double)(this.numEntries) /this.numBuckets);
//		
		

    	if((double) (this.numEntries) /this.numBuckets > MAX_LOAD_FACTOR) {
    		//System.out.println((double)(this.numEntries+1) /this.numBuckets);
//    		System.out.println("***************************DOINGrehash*******************************");
    		this.rehash();
//    		System.out.println("***************************AFTER rehash*******************************");
//    		System.out.println("numEntries	"+ this.numEntries+"	"+this.size());
//    		System.out.println("numBuckets	"+ this.numBuckets+"	"+this.numBuckets());
//    		System.out.println((double)(this.numEntries) /this.numBuckets);

    		//this.numEntries++;

    	}
    
    	return old;

    }
    
    
    /**
     * Get the value corresponding to key. Expected average runtime O(1)
     */
    
    public V get(K key) {
        //ADD YOUR CODE BELOW HERE
    	int index= this.hashFunction(key);
    	int linkListIndex=0;
    	LinkedList<HashPair<K,V>> entryList = this.buckets.get(index);
    	V val= null;
    	for(HashPair<K,V> pair: entryList) {
			if(pair.getKey().equals(key)) {
				val= pair.getValue();
				return val;
			}
			linkListIndex++;
		}
    	return val;
    	
        //ADD YOUR CODE ABOVE HERE
    }
    
    /**
     * Remove the HashPair corresponding to key . Expected average runtime O(1) 
     */
    public V remove(K key) {
        //ADD YOUR CODE BELOW HERE
    	int index= this.hashFunction(key);
    	
    	LinkedList<HashPair<K,V>> entryList = this.buckets.get(index);
    	V val= null;
    	for(HashPair<K,V> pair: entryList) {
			if(pair.getKey().equals(key)) {
				val=pair.getValue();
				entryList.remove(pair);
				this.numEntries--;	
				return val;
			}	
		}
    	return val;
    	
        //ADD YOUR CODE ABOVE HERE
    }
    
    
    /** 
     * Method to double the size of the hashtable if load factor increases
     * beyond MAX_LOAD_FACTOR.
     * Made public for ease of testing.
     * Expected average runtime is O(m), where m is the number of buckets
     */
    public void rehash() {
    	//ADD YOUR CODE BELOW HERE
    	int newSize=this.numBuckets*2;
    	this.numBuckets= newSize;
    	
    	ArrayList<LinkedList<HashPair<K,V>>> oldbuckets= this.buckets;
    	ArrayList<LinkedList<HashPair<K,V>>> newbuckets= new ArrayList<LinkedList<HashPair<K,V>>>(newSize);
    	
    	for (int i=0; i< newSize; i++) {
    		newbuckets.add(i , new LinkedList<HashPair<K,V>>());
    	}
    	//adding all the pairs from the oldbuckets array to the newbucket array
    	for(LinkedList<HashPair<K,V>> List: oldbuckets) {
    		for(HashPair<K,V> pair: List) {
    			int index= this.hashFunction(pair.getKey());
    			newbuckets.get(index).add(pair);

    		}
    	}
    	this.buckets= newbuckets;
    	//System.out.println(this.buckets.size()+"	BKAHJGJUG		"+ this.numBuckets()+"		"+ this.numBuckets);
    	

    	//ADD YOUR CODE ABOVE HERE
    }
    
    
    /**
     * Return a list of all the keys present in this hashtable.
     * Expected average runtime is O(m), where m is the number of buckets
     */
    
    public ArrayList<K> keys() {
        //ADD YOUR CODE BELOW HERE
    	 ArrayList<K>   keyList= new ArrayList<K>();
    	 
    	 //for(LinkedList<HashPair<K,V>> List: buckets) {
    		 for(HashPair<K,V> pair: this) {
    			 keyList.add(pair.getKey());
    		 } 
    	 //}
    	return keyList;
    }
    
    /**
     * Returns an ArrayList of unique values present in this hashtable.
     * Expected average runtime is O(m) where m is the number of buckets
     */
    public ArrayList<V> values() {
    	//ADD CODE BELOW HERE
    	ArrayList<V> uniqueValList= new ArrayList<V>();
    	
    	ArrayList<LinkedList<V>> valuesLinkedList= new ArrayList<LinkedList<V>>(this.numEntries);
    	for(int i=0; i<numEntries; i++) {
    		valuesLinkedList.add(new LinkedList<V>());
    	}
    	
    	 	
    	//for(LinkedList<HashPair<K,V>> List: buckets) {
    		for(HashPair<K,V> pair: this) {
    			V val= pair.getValue();
    			//if(val==null) continue;
    			int valIndex= Math.abs(val.hashCode())%this.numEntries;
    			LinkedList<V> newValList = valuesLinkedList.get(valIndex);
    			//System.out.println("newValList before adding: "+ newValList);
    			if(!newValList.contains(val)) {
    				newValList.add(val);
    				//System.out.println("newValList after adding: "+ newValList);
    			}
    			//valList.add(pair.getValue());
    		} 
    		for(LinkedList<V> vList: valuesLinkedList) {
    			for(V val: vList) {
    				uniqueValList.add(val);
    			}
    		}
    	//}
    	return uniqueValList;
        //ADD CODE ABOVE HERE
    }
    
    
	/**
	 * This method takes as input an object of type MyHashTable with values that 
	 * are Comparable. It returns an ArrayList containing all the keys from the map, 
	 * ordered in descending order based on the values they mapped to. 
	 * 
	 * The time complexity for this method is O(n^2), where n is the number 
	 * of pairs in the map. 
	 */
    public static <K, V extends Comparable<V>> ArrayList<K> slowSort (MyHashTable<K, V> results) {
        ArrayList<K> sortedResults = new ArrayList<>();
        for (HashPair<K, V> entry : results) {
			V element = entry.getValue();
			K toAdd = entry.getKey();
			int i = sortedResults.size() - 1;
			V toCompare = null;
        	while (i >= 0) {
        		toCompare = results.get(sortedResults.get(i));
        		if (element.compareTo(toCompare) <= 0 )
        			break;
        		i--;
        	}
        	sortedResults.add(i+1, toAdd);
        }
        return sortedResults;
    }
    
    
	/**
	 * This method takes as input an object of type MyHashTable with values that 
	 * are Comparable. It returns an ArrayList containing all the keys from the map, 
	 * ordered in descending order based on the values they mapped to.
	 * 
	 * The time complexity for this method is O(n*log(n)), where n is the number 
	 * of pairs in the map. 
	 * 
	 */
    
    private static <K, V extends Comparable<V>>ArrayList<HashPair<K,V>> merge(ArrayList<HashPair<K,V>> list1, ArrayList<HashPair<K,V>> list2){
    	ArrayList<HashPair<K,V>> list= new ArrayList<HashPair<K,V>>();
    	
    	while (!list1.isEmpty() && !list2.isEmpty()) {
    		V element= list1.get(0).getValue();
    		V toCompare = list2.get(0).getValue();
    		
    		if(element.compareTo(toCompare) > 0){
    			list.add(list1.remove(0));
    		}
    		else {
    			list.add(list2.remove(0));
    		}	
    	} 	
    	while(!list1.isEmpty()) {
    		list.add(list1.remove(0));
    	}
    	while(!list2.isEmpty()) {
    		list.add(list2.remove(0));
    	}
		return list;
    }
    
    private static <K, V extends Comparable<V>>ArrayList<HashPair<K,V>> mergesort(ArrayList<HashPair<K,V>> list){
    	if(list.size()==1) {
    		return  list;
    	}
    	else {
    		int mid= (list.size())/2;
    		ArrayList<HashPair<K,V>> list1=  new ArrayList<HashPair<K,V>>();
    		for(int i=0; i < (mid); i++) {
    			list1.add(list.get(i));
    		}
    		ArrayList<HashPair<K,V>> list2=  new ArrayList<HashPair<K,V>>();
    		for(int i=mid; i < list.size(); i++) {
    			list2.add(list.get(i));
    		}
    		list1= mergesort(list1);
    		list2= mergesort(list2);
    		return (ArrayList<HashPair<K, V>>) merge(list1, list2);
    	}
    }
    	
    
    
    public static <K, V extends Comparable<V>> ArrayList<K> fastSort(MyHashTable<K, V> results) {
        //ADD CODE BELOW HERE
    	ArrayList<K> sortedKeys = new ArrayList<>();
    	if(results.isEmpty()) {
    		return sortedKeys;
    	}
    	ArrayList<HashPair<K,V>> sortedPairs= new ArrayList<HashPair<K,V>>();
    	
    	for(HashPair<K,V> pair: results) {
    		sortedPairs.add(pair);
    	}
    	sortedPairs= mergesort(sortedPairs);
    	
    	for(HashPair<K,V> pair: sortedPairs) {
    		sortedKeys.add(pair.getKey());
    		//System.out.println(pair.getKey());
    	}
    	
    	return sortedKeys;
		
        //ADD CODE ABOVE HERE
    }

    
    
    
    @Override
    public MyHashIterator iterator() {
        return new MyHashIterator();
    }   
    
    private class MyHashIterator implements Iterator<HashPair<K,V>> {
        //ADD YOUR CODE BELOW HERE
    	private int listSize;
		private int curIndex;
		ArrayList<HashPair<K,V>> hashPairs;
        //ADD YOUR CODE ABOVE HERE
    	
    	/**
    	 * Expected average runtime is O(m) where m is the number of buckets
    	 */
        private MyHashIterator() {
            //ADD YOUR CODE BELOW HERE
        	curIndex=0;
        	hashPairs= new ArrayList<HashPair<K,V>>();
        	for(LinkedList<HashPair<K,V>> List: buckets) {
        		for(HashPair<K,V> pair: List) {
        			hashPairs.add(pair);
        		} 
        	}
        	listSize= hashPairs.size();
            //ADD YOUR CODE ABOVE HERE
        }
        @Override
        /**
         * Expected average runtime is O(1)
         */
        public boolean hasNext() {
            //ADD YOUR CODE BELOW HERE
        	return (curIndex<listSize);	
            //ADD YOUR CODE ABOVE HERE
        }
        @Override
        /**
         * Expected average runtime is O(1)
         */
        public HashPair<K,V> next() {
            //ADD YOUR CODE BELOW HERE
        	if(curIndex<listSize) {
        		return hashPairs.get(curIndex++);
        	}
        	throw new NoSuchElementException ("Can not find this element ");
        	
        	
            //ADD YOUR CODE ABOVE HERE
        }
        
    }
}
