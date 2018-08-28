
## Co-People

仿天眼查关系图，自定义view，随机颜色，随机大小,随机长度，欢迎star

# 预览图

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
    ····

