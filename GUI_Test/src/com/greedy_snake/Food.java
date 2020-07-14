package com.greedy_snake;

import javax.swing.*;
import java.util.Random;

public class Food {
    private int x;
    private int y;
    private ImageIcon image;
    public Food(){
        this.image=Datas.getFoodImageIcon();
    }

    public void change(){
        Random random = new Random();
        this.x= Datas.GameInterval+ Datas.BlockLen*random.nextInt((Datas.GameWidth-2*Datas.GameInterval)/Datas.BlockLen);
        this.y= Datas.GameInterval+ Datas.BlockLen*random.nextInt((Datas.GameHeight-2*Datas.GameInterval)/Datas.BlockLen);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public ImageIcon getImage() {
        return image;
    }
}
