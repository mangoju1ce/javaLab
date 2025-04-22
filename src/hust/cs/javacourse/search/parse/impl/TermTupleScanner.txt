package hust.cs.javacourse.search.parse.impl;

import hust.cs.javacourse.search.parse.AbstractTermTupleScanner;

import java.io.BufferedReader;
import java.io.IOException;
/**
 * AbstractTermTupleScanner 的具体子类， 利用java.io.BufferedReader流式读取TermTuple
 */
public class TermTupleScanner extends AbstractTermTupleScanner{
    /**
     * 输入流
     */
    public BufferedReader input = null;
    /**
     * 缺省构造函数
     */
    public TermTupleScanner(){

    }
    /**
     * 构造函数
     * @param input:输入流对象
     */
    public TermTupleScanner(BufferedReader input){
        this.input = input;
    }

    /** 
     * close方法，关闭input流
     */
    public void close(){
        try {
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
    }

    public TermTuple next(){
        
    }


}

