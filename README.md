> 将前面学到的GUI基础知识完成实战，完成一个简单的贪吃蛇项目

# 项目功能

- 用键盘上下左右实现贪吃蛇的自动移动

- 贪吃蛇吃到食物后，长度加一，分数加一

- 贪吃蛇吃到自己的身体，则游戏结束

- 按空格键实现游戏的暂停和继续

# 效果截图

![image-20200714132700398](https://img2020.cnblogs.com/blog/1235676/202007/1235676-20200714225551568-1388652132.png)

# 逻辑分析

- 需要Main.class中有public static void main(String[] args)来启动游戏

- 需要写一个GameFrame extends JFrame界面 

  - 注意：游戏的界面的大小，JFrame 显示大小与设置的不同。==需要严格规定窗口的大小，因为小蛇的移动是固定一个格子的大小==（比如：25）
  - 设置游戏的==窗口不可拉伸==

- 定义一个贪吃蛇对象类，将小蛇划分成蛇头和蛇身两个部分，此外，小蛇的方向需要对应不同的蛇头图片

- 定义一个食物对象类，食物每次被吃到后，需要随机再次出现位置

- 定义一个数据类，专门来存放一些数据，比如说图片信息，窗口宽高

- 游戏面板，重中之重。需要继承一个JPanel类，二个接口ActionListener（事件监听）, KeyListener（键盘监听）

  - 在初始化函数中，需要获得焦点，添加键盘监听，开启定时器
  - 在画笔中需要画黑框，贪吃蛇，食物，提示
  - 在键盘监听中，空格键处理暂停和继续，方向键处理蛇头和方向

  - 在事件监听中需要对得分进行判断，蛇头和蛇身移动处理，蛇头穿过边界的处理，游戏结束判断处理
  - repaint 重画页面

# 代码分析

注释很详细

# 踩坑

## JFrame的窗口大小

**窗口宽度= 输入宽度+窗口左边框+窗口右边框**

**窗口高度= 输入高度+窗口上边框+窗口下边框**

 ```//需要加上窗口左边框+窗口右边框和窗口上边框+窗口下边框
jframe.setSize(Datas.GameWidth+3+3,Datas.GameHeight+32+3);
 ```

需要加上窗口左边框+窗口右边框和窗口上边框+窗口下边框，但是每一个项目的边框大小都是不一样的。所以需要先去测试边框大小

```
package com.greedy_snake;
import java.awt.*;
public class Main {
    public static void main(String[] args) {
        //创建一个窗口
        GameFrame gameFrame = new GameFrame();
        Dimension di = gameFrame.getContentPane().getSize();
        System.out.println("内容面板宽度"+di.width);//宽
        System.out.println("内容面板的高度"+di.height);//高
    }
}
```

```
package com.greedy_snake;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    public GameFrame(){
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
        /*7 得到窗口的边界区域
        需要放在setVisible下面输出的4个结果才不是0*/
        Insets insets = getInsets();
        System.out.println("窗口边框上"+insets.top);//上
        System.out.println("窗口边框下"+insets.bottom);//下
        System.out.println("窗口边框左"+insets.left);//左
        System.out.println("窗口边框右"+insets.right);//右
    }
}
```

![image-20200714141303883](https://img2020.cnblogs.com/blog/1235676/202007/1235676-20200714225551883-1336238940.png)

==得到窗口的边界区域，需要放在setVisible下面输出的4个结果才不是0，不能在setSize中直接Datas.GameWidth+insets.left+insets.right==



## ImageDemo.class.getResource路径问题

两个例子给你就很理解了

![image-20200714143007036](https://img2020.cnblogs.com/blog/1235676/202007/1235676-20200714225552482-1765428121.png)

![image-20200714143416285](https://img2020.cnblogs.com/blog/1235676/202007/1235676-20200714225552751-1722643551.png)
