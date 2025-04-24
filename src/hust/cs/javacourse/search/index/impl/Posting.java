package hust.cs.javacourse.search.index.impl;

import hust.cs.javacourse.search.index.AbstractPosting;

import java.util.ArrayList; 
import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
    /*
     * 返回包含单词的文档id
     * @return : doc id
     */
    public int getDocId(){
        return this.docId;
    }
    /**
     * 设置包含单词的文档id
     * @param docId：包含单词的文档id
     */
    public void setDocId(int docId){
        this.docId = docId;
    }
    /**
     * 返回单词在文档里出现的次数
     * @return ：出现次数
     */
    public int getFreq(){
        return this.freq;
    }
    /**
     * 设置单词在文档里出现的次数
     * @param freq:单词在文档里出现的次数
     */
    public void setFreq(int freq){
        this.freq = freq;
    }

    /**
     * 返回单词在文档里出现的位置列表
     * @return ：位置列表
     */
    public List<Integer> getPositions(){
        return positions;
    }
    /**
     * 设置单词在文档里出现的位置列表
     * @param positions：单词在文档里出现的位置列表
     */
    public void setPositions(List<Integer> positions){
        this.positions = positions;
    }
    /**
     * 比较二个Posting对象的大小（根据docId）
     * @param o： 另一个Posting对象
     * @return ：二个Posting对象的docId的差值
     */
    @Override
    public int compareTo(AbstractPosting o){
        return this.docId - ((Posting)o).docId;
    }
    /**
     * 对内部positions从小到大排序
     */
    public void sort(){
        Collections.sort(this.positions);
    }
    
    /**
     * 文件序列化写
     * @param out: 输出流
     */
    public void writeObject(ObjectOutputStream out){
        try {
            out.writeObject(this.docId);
            out.writeObject(this.freq);
            out.writeObject(this.positions);
        } catch (IOException e) {
            System.out.println("IO error occured.failed to write posting" + e.getMessage());
        }
    }
    /**
     * 从二进制文件读
     * @param in ：输入流对象
     */
    public void readObject(ObjectInputStream in){
        try{
            this.docId = (int)in.readObject();
            this.freq = (int)in.readObject();
            this.positions= (ArrayList<Integer>)in.readObject();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }







}
