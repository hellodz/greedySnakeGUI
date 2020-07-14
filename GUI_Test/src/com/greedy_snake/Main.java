package com.greedy_snake;
public class Main {
    public static void main(String[] args) {
        //创建一个窗口
        GameFrame gameFrame = new GameFrame();//25+25*30+25 25+25*30+25
        //添加面板
        gameFrame.add(new GamePanel());
        //面板初始化
        gameFrame.init();
    }
}
