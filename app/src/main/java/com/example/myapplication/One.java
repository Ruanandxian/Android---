package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.flyco.tablayout.SlidingTabLayout;
import com.yalantis.phoenix.PullToRefreshView;

import java.util.ArrayList;



public class One extends AppCompatActivity implements View.OnClickListener {
    Button button = null;
    TextView t1, t2, t3, t4, t5 = null;
    boolean LockMenu = false;
    private ViewPager mViewPager;
    private SlidingTabLayout slidingTabLayout;
    private ArrayList<Fragment> mFragments;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);
        button = (Button) findViewById(R.id.button1);
        t1 = (TextView) findViewById(R.id.tV1);
        t2 = (TextView) findViewById(R.id.tV2);
        t3 = (TextView) findViewById(R.id.tV3);
        t4 = (TextView) findViewById(R.id.tV4);
        t5 = (TextView) findViewById(R.id.tV5);

        slidingTabLayout = findViewById(R.id.tl_1);
        mViewPager = findViewById(R.id.vp_main);

        mFragments = new ArrayList<>();
        mFragments.add(new First());
        mFragments.add(new Second());
        mFragments.add(new Thrid());
        mFragments.add(new Finally());
        slidingTabLayout.setViewPager(mViewPager, new String[]{"购物海淘", "娱乐休闲", "资讯信息","生活周边"}, this, mFragments);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it();
            }
        });


    }

    public void it(){
        if (!LockMenu) {
            LockMenu = true;
            openAnim(t1, 0, 5, 300);
            openAnim(t2, 1, 5, 300);
            openAnim(t3, 2, 5, 300);
            openAnim(t4, 3, 5, 300);
            openAnim(t5, 4, 5, 300);
        } else {
            LockMenu = false;
            closeAnim(t1, 0, 5, 300);
            closeAnim(t2, 1, 5, 300);
            closeAnim(t3, 2, 5, 300);
            closeAnim(t4, 3, 5, 300);
            closeAnim(t5, 4, 5, 300);
        }
    }

    //打开菜单
    public void openAnim(View view, int index, int num, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double angle = Math.toRadians(180) / (num - 1) * index;
        int translationX = -(int) (radius * Math.cos(angle));
        int translationY = -(int) (radius * Math.sin(angle));

        ObjectAnimator one = ObjectAnimator.ofFloat(view, "translationX", 0, translationX);
        ObjectAnimator two = ObjectAnimator.ofFloat(view, "translationY", 0, translationY);
        ObjectAnimator three = ObjectAnimator.ofFloat(view, "rotation", 0, 360);
        ObjectAnimator four = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
        ObjectAnimator five = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
        ObjectAnimator six = ObjectAnimator.ofFloat(view, "alpha", 0f, 1);
        AnimatorSet set = new AnimatorSet();
        set.playTogether(one, two, three, four, five, six);
        set.setDuration(2000);
        //回弹效果
        set.setInterpolator(new BounceInterpolator());
        set.start();
    }

    //关闭菜单
    public void closeAnim(View view, int index, int num, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double angle = Math.toRadians(180) / (num - 1) * index;
        Log.e("angle", angle + "");
        int translationX = -(int) (radius * Math.cos(angle));
        int translationY = -(int) (radius * Math.sin(angle));

        ObjectAnimator one = ObjectAnimator.ofFloat(view, "translationX", translationX, 0);
        ObjectAnimator two = ObjectAnimator.ofFloat(view, "translationY", translationY, 0);
        ObjectAnimator three = ObjectAnimator.ofFloat(view, "rotation", 0, 360);
        ObjectAnimator four = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
        ObjectAnimator five = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f);
        ObjectAnimator six = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);

        AnimatorSet set = new AnimatorSet();
        set.playTogether(one, two, three, four, five, six);
        set.setDuration(2000);
        //回弹效果
        set.setInterpolator(new BounceInterpolator());
        set.start();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tV1:
                Intent intent1=new Intent(One.this,MainActivity.class);
                startActivity(intent1);
                it();
                this.finish();
                break;
            case R.id.tV2:
                Intent intent2=new Intent(One.this,Two.class);
                startActivity(intent2);
                it();
                this.finish();
                break;
            case R.id.tV3:
                Intent intent3=new Intent(One.this,Three.class);
                startActivity(intent3);
                it();
                this.finish();
                break;
            case R.id.tV4:
                Intent intent4=new Intent(One.this,Four.class);
                startActivity(intent4);
                it();
                this.finish();
                break;
            case R.id.tV5:
                Intent intent5=new Intent(One.this,Five.class);
                startActivity(intent5);
                it();
                break;
        }
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);

        // activity切换动画
        // 参数一：新Activity进入的动画(最右侧进来)
        // 参数二：旧Activity退出的动画(最左侧出去)
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
    }
}



