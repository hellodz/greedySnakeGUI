package com.greedy_snake;

import javax.swing.*;
import java.net.URL;
import java.util.ArrayList;


public class Datas {
    //上下左右方向
    public static final int UP=0;
    public static final int DOWN=1;
    public static final int LEFT=2;
    public static final int RIGHT=3;
    //需要设置成BlockLen的倍数 不然小蛇的移动会出现问题
    //游戏窗口宽度
    public static int GameWidth = 1000;
    //游戏窗口高度
    public static int GameHeight = 800;
    //游戏边界 黑框和边界的距离
    public static int GameInterval = 0;
    //小蛇每次移动的长度
    public static int BlockLen = 25;

    //游戏开始标志 true 开始 false 暂停
    public static boolean isStart = false;
    //游戏结束标志 true 游戏结束 false 游戏开始
    public static boolean isFail = false;
    //游戏得分
    public static int score = 0;

    public static  ArrayList<ImageIcon> getHeadImageIcon(){
        ArrayList<URL> headURLs = new ArrayList<>();
        //上下左右
        //路径易错，Datas和statics同级目录
        headURLs.add(Datas.class.getResource("statics/up.png"));
        headURLs.add(Datas.class.getResource("statics/down.png"));
        headURLs.add(Datas.class.getResource("statics/left.png"));
        headURLs.add(Datas.class.getResource("statics/right.png"));
        ArrayList<ImageIcon> headImages = new ArrayList<>();

        headImages.add(new ImageIcon(headURLs.get(0)));
        headImages.add(new ImageIcon(headURLs.get(1)));
        headImages.add(new ImageIcon(headURLs.get(2)));
        headImages.add(new ImageIcon(headURLs.get(3)));
        return headImages;
    }
    public static  ImageIcon getBodyImageIcon(){
        URL bodyURL= Datas.class.getResource("statics/body.png");
        ImageIcon body = new ImageIcon(bodyURL);
        return body;
    }
    public static  ImageIcon getFoodImageIcon(){
        URL foodURL= Datas.class.getResource("statics/food.png");
        ImageIcon food = new ImageIcon(foodURL);
        return food;
    }
}
