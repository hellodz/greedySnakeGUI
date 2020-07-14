package com.greedy_snake;

import javax.swing.*;

import java.util.ArrayList;

public class GreedySnake {
    private int len;
    private int[] snakeX ;
    private int[] snakeY ;
    private ArrayList<ImageIcon> headList ;
    private ImageIcon head ;
    private ImageIcon body ;
    private int direction;
    public GreedySnake(){
        this.snakeX = new int[Datas.GameWidth/Datas.BlockLen*Datas.GameHeight/Datas.BlockLen+5];
        this.snakeY = new int[Datas.GameWidth/Datas.BlockLen*Datas.GameHeight/Datas.BlockLen+5];
        this.body = Datas.getBodyImageIcon();
        this.headList = Datas.getHeadImageIcon();
        init();
    }
    public void init(){
        this.direction=Datas.RIGHT;
        this.head=this.headList.get(this.direction);
        this.len=3;
        this.snakeX[0]=Datas.GameInterval+3*Datas.BlockLen;this.snakeY[0]=Datas.GameInterval+3*Datas.BlockLen;
        this.snakeX[1]=Datas.GameInterval+2*Datas.BlockLen;this.snakeY[1]=Datas.GameInterval+3*Datas.BlockLen;
        this.snakeX[2]=Datas.GameInterval+Datas.BlockLen;this.snakeY[2]=Datas.GameInterval+3*Datas.BlockLen;
    }
    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int[] getSnakeX() {
        return snakeX;
    }

    public void setSnakeX(int key,int value) {
        this.snakeX[key] = value;
    }

    public int[] getSnakeY() {
        return snakeY;
    }

    public void setSnakeY(int key,int value) {
        this.snakeY[key] = value;
    }

    public ImageIcon getHead() {
        return head;
    }

    public void setHead(int direction) {

        this.head = this.headList.get(direction);
    }

    public ImageIcon getBody() {
        return body;
    }

    public void setBody(ImageIcon body) {
        this.body = body;
    }
}
