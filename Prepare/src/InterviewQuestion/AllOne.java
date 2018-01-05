package InterviewQuestion;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AllOne {
    private class Bucket {
        int count;
        Set<String> keySet;
        Bucket next;
        Bucket prev;
        public Bucket(int cnt) {
            this.count = cnt;
        }
    }
    // maintain a doubly linked list of Buckets
    private Bucket head;
    private Bucket tail;
    // for accessing a specific Bucket among the Bucket list in O(1) time
    private Map<Integer, Bucket> countBucketMap;
    // keep track of count of keys
    private Map<String, Integer> keyCountMap;

    private AllOne() {
        head = new Bucket(Integer.MIN_VALUE);
        tail = new Bucket(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
        countBucketMap = new HashMap<>();
        keyCountMap = new HashMap<>();
    }

    public void inc(String key) {
        if(keyCountMap.containsKey(key)) {
            changeKey(key, 1);
        } else {
            keyCountMap.put(key, 1);
            if(head.next.count != 1)
                addBucketAfter(new Bucket(1), head);
            head.next.keySet.add(key);
            countBucketMap.put(1, head.next);
        }
    }

    public void dec(String key) {
        if(keyCountMap.containsKey(key)) {
            int count = keyCountMap.get(key);
            if(count == 1){
                keyCountMap.remove(key);
                removeKeyFromBucket(countBucketMap.get(count), key);
            } else {
                changeKey(key, -1);
            }
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : (String) tail.prev.keySet.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keySet.iterator().next();
    }

    private void changeKey(String key, int offset) {
        int  count = keyCountMap.get(key);
        keyCountMap.put(key, count + offset);
        Bucket curBucket = countBucketMap.get(count);
        Bucket newBucket;
        if(countBucketMap.containsKey(count + offset)) {
            newBucket = countBucketMap.get(count + offset);
        } else {
            newBucket = new Bucket(count + offset);
            countBucketMap.put(count + offset, newBucket);
            addBucketAfter(newBucket, offset == 1 ? curBucket : curBucket.prev);
        }
        newBucket.keySet.add(key);
        removeKeyFromBucket(curBucket, key);
    }

    private void removeKeyFromBucket(Bucket bucket, String key) {
        bucket.keySet.remove(key);
        if(bucket.keySet.size() == 0){
            removeBucketFromList(bucket);
            countBucketMap.remove(bucket.count);
        }
    }

    private void removeBucketFromList(Bucket bucket) {
        bucket.prev.next = bucket.next;
        bucket.next.prev = bucket.prev;
        bucket.next = null;
        bucket.prev = null;
    }

    private void addBucketAfter(Bucket newBucket, Bucket preBucket) {
        newBucket.prev = preBucket;
        newBucket.next = preBucket.next;
        preBucket.next.prev = newBucket;
        preBucket.next = newBucket;
    }
}
