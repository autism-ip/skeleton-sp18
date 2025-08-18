import java.util.ArrayDeque;

public class Palindrome {
    public Deque<Character> wordtoDeque(String word){
        Deque<Character> deq = new ArrayDeque<Character>();
        for(String w:words){
            deq.addLast(word);
        }
        return deq; 
    }
    public boolean isPalindroom(String word){
        Deque<Character> w[] = new ArrayDeque<Character>();
        w = wordtoDeque(word);
        record = 0;
        for(int i = 0;i<(w.length)/2;i++){
            if(w[i] == w[size-1-i]){
                record +=1;
            }
        }
        if(record = w.length/2 || record == w.length/2-0.5){
            return true;
        }
        return false;
    }
}