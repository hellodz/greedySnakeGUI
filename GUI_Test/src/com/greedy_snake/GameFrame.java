package com.greedy_snake;
import javax.swing.*;
public class GameFrame extends JFrame {
    public void init(){
        //1 设置标题
        this.setTitle("贪吃蛇");
        //2 设置宽高 6 35是通过insets得到的
        this.setSize(Datas.GameWidth+3+3,Datas.GameHeight+32+3);
        //3 设置窗口居中
        this.setLocationRelativeTo(null);
        //4 设置点击窗口的×关闭
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //5 设置游戏窗口大小不可拉伸
        this.setResizable(false);
        //6 设置可见
        this.setVisible(true);
    }
}
