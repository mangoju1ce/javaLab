package hust.cs.javacourse.search.index.impl;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import hust.cs.javacourse.search.index.AbstractTerm;

public class Term extends AbstractTerm{
    protected String content; 
    /**
     * 缺省构造函数
     */
    public Term(){

    }

    public Term(String word){
        this.content = word;
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

    /**
     * 从流输出term
     * @param out:输出流
     */
    public void writeObject(ObjectOutputStream out){
        try{
            out.writeObject(this.content);
        }catch(IOException e){
            System.out.println("IO error occured.failed to write term" + e.getMessage());

        }
    }
    /**
     * 从流读入term
     * @param in：输入流
     */
    public void readObject(ObjectInputStream in)
    {
        try{
            this.content = (String)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

    }
    public static void main(String args[]){
        Term a = new Term("a"), b = new Term("b"), c;
        System.out.println(a.toString());
        if(!a.equals(b)){
            System.out.println("a is not equal to b");
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("term.ser"))) {
            oos.writeObject(b);
            System.out.println("对象已保存");
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (ObjectInputStream oos = new ObjectInputStream(new FileInputStream("term.ser"))) {
            c = (Term)oos.readObject();
            System.out.println("对象已读取");
            System.out.println(c.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
