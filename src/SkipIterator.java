
/**have 2 queues, implement a skip iterator.
 * pop() gives queue1, then
 queue2, then queue1, queue2*/

import java.io.IOException;
import java.util.*;
import java.lang.*;



public class SkipIterator<T> implements Iterator<T> {
    Iterator<T> iter1;
    Iterator<T> iter2;
    boolean nextIsQ1=true;

    public SkipIterator(Iterator<T> iter1, Iterator<T> iter2){
        this.iter1 = iter1;
        this.iter2 = iter2;
    }

    public boolean hasNext(){
        if(iter1.hasNext() || iter2.hasNext()) return true;
        return false;
    }

    public T next(){
        if(nextIsQ1&&iter1.hasNext()){
            nextIsQ1=false;
            return iter1.next();
        }else{
            if(iter2.hasNext()){
                nextIsQ1=true;
                return iter2.next();
            }else{
                throw new NoSuchElementException();
            }
        }
    }

    public void remove(){
        if((nextIsQ1&&iter1.hasNext())){
            iter1.remove();
            nextIsQ1=false;
        }else{
            iter2.remove();
            nextIsQ1=true;
        }
    }


}
