package com.greedy_snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 游戏面板类
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    Timer timer = new Timer(100, this);
    //创建小蛇
    GreedySnake snake = new GreedySnake();
    //创建食物
    Food food = new Food();

    public GamePanel(){
        //获得焦点
        //如果没有获得焦点，我们是点击不了这个窗口的
        this.setFocusable(true);
        //添加监听
        this.addKeyListener(this);
        //随机改变食物的位置
        food.change();
        init();
    }
    //游戏初始化
    public void init(){
        //小蛇
        snake.init();
        //食物
        food.change();
        //分数
        Datas.score=0;
        //提示
        Datas.isStart=false;
        Datas.isFail=false;
        //开始定时器
        timer.start();
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //设置背景颜色是白色
        this.setBackground(Color.white);
        //画黑框
        g.fillRect(Datas.GameInterval,Datas.GameInterval,Datas.GameWidth-2*Datas.GameInterval,Datas.GameHeight-2*Datas.GameInterval);
        //画小蛇头
        snake.getHead().paintIcon(this,g,snake.getSnakeX()[0],snake.getSnakeY()[0]);
        //画小蛇身
        for(int i=1;i<snake.getLen();i++){
            snake.getBody().paintIcon(this,g,snake.getSnakeX()[i],snake.getSnakeY()[i]);
        }
        //画食物
        food.getImage().paintIcon(this,g,food.getX(),food.getY());
        //暂停结束提示
        if(Datas.isStart==false){
            g.setColor(Color.white);
            g.setFont(new Font("宋体",Font.BOLD,40));
            g.drawString("画面静止，空格施法",300,400);
        }
        //游戏结束提示
        if(Datas.isFail==true){
            g.setColor(Color.red);
            g.setFont(new Font("宋体",Font.BOLD,40));
            g.drawString("游戏结束!分数："+Datas.score,300,500);
        }
    }

    //事件监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(Datas.isStart&&!Datas.isFail){
            //吃食物
            if(snake.getSnakeX()[0]==food.getX()&&snake.getSnakeY()[0]==food.getY()){
                snake.setLen(snake.getLen()+1);
                food.change();
                Datas.score++;
            }
            //处理蛇身
            for(int i=snake.getLen()-1;i>0;i--){
                snake.setSnakeX(i,snake.getSnakeX()[i-1]);
                snake.setSnakeY(i,snake.getSnakeY()[i-1]);
            }
            //处理蛇头
            if(snake.getDirection()==Datas.UP){
                snake.setSnakeY(0,snake.getSnakeY()[0]-Datas.BlockLen);
                if(snake.getSnakeY()[0]<Datas.GameInterval){
                    snake.setSnakeY(0, Datas.GameHeight-Datas.GameInterval);
                }
            }else if(snake.getDirection()==Datas.DOWN){
                snake.setSnakeY(0,snake.getSnakeY()[0]+Datas.BlockLen);
                if(snake.getSnakeY()[0]>=Datas.GameHeight-Datas.GameInterval){
                    snake.setSnakeY(0, Datas.GameInterval);
                }
            }else if(snake.getDirection()==Datas.LEFT){
                snake.setSnakeX(0,snake.getSnakeX()[0]-Datas.BlockLen);
                if(snake.getSnakeX()[0]<Datas.GameInterval){
                    snake.setSnakeX(0,Datas.GameWidth-Datas.GameInterval);
                }
            }else if(snake.getDirection()==Datas.RIGHT){
                snake.setSnakeX(0,snake.getSnakeX()[0]+Datas.BlockLen);
                if(snake.getSnakeX()[0]>=Datas.GameWidth-Datas.GameInterval){
                    snake.setSnakeX(0, Datas.GameInterval);
                }
            }
            //状态自己 头脑和身体重合
            for(int i=snake.getLen()-1;i>0;i--){
                if(snake.getSnakeX()[0]==snake.getSnakeX()[i]&&snake.getSnakeY()[0]==snake.getSnakeY()[i]){
                    Datas.isFail=true;
                    timer.stop();
                }
            }
            repaint();
        }
    }
    @Override
    public void keyPressed(KeyEvent e) {
        //获得键值
        int keyCode = e.getKeyCode();
        if(keyCode == KeyEvent.VK_SPACE){
            if(!Datas.isFail){
                Datas.isStart=!Datas.isStart;
            }else{
                //重新开始开始
                init();
            }
        }
        if(keyCode == KeyEvent.VK_UP){
            snake.setDirection(Datas.UP);
            snake.setHead(Datas.UP);
        }else if(keyCode == KeyEvent.VK_DOWN){
            snake.setDirection(Datas.DOWN);
            snake.setHead(Datas.DOWN);
        }else if(keyCode == KeyEvent.VK_LEFT){
            snake.setDirection(Datas.LEFT);
            snake.setHead(Datas.LEFT);
        }else if(keyCode == KeyEvent.VK_RIGHT){
            snake.setDirection(Datas.RIGHT);
            snake.setHead(Datas.RIGHT);
        }
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
