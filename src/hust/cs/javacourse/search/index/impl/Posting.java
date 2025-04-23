package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractPosting;
import java.util.ArrayList; 
import java.util.List;

public class Posting extends AbstractPosting{

    /**
     * 缺省构造函数
     */
    public Posting(){

    }

    /**
     * 构造函数
     * @param docId
     * @param freq  
     * @param positions
     */
    public Posting(int docId, int freq, List<Integer> positions){
        super(docId, freq, positions);
    }

    /**
     * 判断两个posting内容是否相同  
     * @param obj: 另一个posting  
     * @return: 内容相同返回true，内容不同或不可比较返回false  
     */
    public boolean equals(Object obj){
        if(obj == null || obj.getClass() != this.getClass()){
            return false;
        }
        else{
            Posting target = (Posting)obj;
            return this.docId == target.docId && this.freq == target.freq && this.positions.equals(target.positions); 
        }
    }

    /** 
     * 返回Posting的字符串表示  
     * @return 字符串  
     */
    @Override
    public String toString(){
        return String.format("Posting{docId = %d, freq = %d positions = %s}", this.docId, this.freq, this.positions.toString());
    }
}
