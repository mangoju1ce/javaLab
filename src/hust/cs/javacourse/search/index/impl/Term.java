package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractTerm;

public class Term extends AbstractTerm{
    protected String content; 
    /**
     * 缺省构造函数
     */
    public Term(){

    }
    /**
     * 判断二个Term内容是否相同
     * @param obj ：要比较的另外一个Term
     * @return 如果内容相等返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj){
        if(obj == this) return true;
        if(obj == null || this.getClass() != obj.getClass()) return false;
        Term target = (Term)obj;
        return target.content.equals(this.content);
    }
    /** 
     * 返回Term中的字符串
     * @return 字符串
     */
    public String toString(){
        return "Term{content ="+ this.content.toString() + "}";
    }
    /** 
     * 返回Term内容
     * @return Term内容字符串 
     */
    public String getContent(){
        return content;
    }
    /**
     * 设置Term内容 
     */
    public void setContent(String input){
        this.content = input;
    }
    /**
     * 字典序比较
     * @param o: 待比较的对象 
     * @return : 返回字典序差值  
     */
    @Override
    public int compareTo(AbstractTerm o){
        Term other = (Term)o;
        return this.content.compareTo(other.content);
    }
}
