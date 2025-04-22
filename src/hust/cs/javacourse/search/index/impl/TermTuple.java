package hust.cs.javacourse.search.index.impl;

public class TermTuple {
    /**
     * 单词
     */
    public Term term;
    /** 
     * 出现次数为1
     */
    public final int freq = 1;
    /**
     * 单词出现的位置
     */
    public int curPos ;

    /**
     * 判断tuple是否相同
     * @param obj:另一个tuple 
     */
    @Override 
    public boolean equals(Object obj){
        if(obj == this){return true;}
        if(obj == null || obj.getClass() != this.getClass()){return false;}
        TermTuple other = (TermTuple)obj;
        return this.term.equals(other.term) && this.freq==other.freq && this.curPos==other.curPos;
    }
    /**
     * 获得tuple字符串表示
     */
    @Override
    public String toString(){
        return "TermTuple{term " + this.term.toString() + "\nfreq " + this.freq + " curPos "+ this.curPos + "}";

    }
    

    
}
