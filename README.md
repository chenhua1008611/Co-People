
## Co-People

仿天眼查关系图，自定义view，随机颜色，随机大小,随机长度，欢迎star

## 预览图

设计图
![avatar](https://github.com/chenhua1008611/Co-People/blob/master/CoPeople/images/1234.png)

## 绘制思路
这里使用了中学解析几何知识   XPoint = OPointX = OPointX*cosθ； YPoint = OPointY = OPointY*sinθ；
<pre class=”brush: java; gutter: true;”>                canvas.drawText(lists.get(i).getName(), XPoint + (float) Math.cos(pere * i + 5) * radius[i % radius.length] - 30, YPoint + (float) Math.sin(pere * i + 5) * radius[i % radius.length] + 35, paint);
</pre>

## 用法
 ```
 1、XML布局（PS要根据自己的包名） <com.gkzy.relation.CirclePeopleView
    android:id="@+id/layout_cricle_people"
    android:layout_width="match_parent"
    android:layout_height="280dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintLeft_toLeftOf="parent"
    app:layout_constraintRight_toRightOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
   
        
 2.  peopleView = findViewById(R.id.layout_cricle_people);

 3. 添加数据，刷新UI peopleView.SetFieldInfo(lists);
    peopleView.invalidate();
    
    
 4.添加了view的点击事件，通过手势判断。原理：
 每个圆的Cx,Cy,r都能获取到，然后通过已知数据计算RectF的
  left,  top,  right,  bottom
   /**
     * Create a new rectangle with the specified coordinates. Note: no range
     * checking is performed, so the caller must ensure that left <= right and
     * top <= bottom.
     *
     * @param left   The X coordinate of the left side of the rectangle
     * @param top    The Y coordinate of the top of the rectangle
     * @param right  The X coordinate of the right side of the rectangle
     * @param bottom The Y coordinate of the bottom of the rectangle
     */
    public RectF(float left, float top, float right, float bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }
    
    得到RectF后判断contains(x,y)来获得点击的位置
    
    
## 后续功能
添加手势控制（手势控制放大缩小）
## 目前还存在的问题
文字中心对齐圆心；
数据量大的情况下会有重叠现象；
