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

import androidx.appcompat.app.AppCompatActivity;

import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;

public class Five extends AppCompatActivity{
    Button button = null;
    TextView t1, t2, t3, t4, t5 = null;
    boolean LockMenu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View aboutPage = new AboutPage(this)
                .isRTL(false)
                .setImage(R.mipmap.ice)//图片
                .setDescription("smile")//介绍
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("Connect with us")
                .addEmail("elmehdi.sakout@gmail.com")
                .addWebsite("http://medyo.github.io/")
                .addFacebook("the.medy")
                .addTwitter("medyo80")
                .addYoutube("UCdPQtdWIsg7_pi4mrRu46vA")
                .addPlayStore("com.ideashower.readitlater.pro")
                .addGitHub("medyo")
                .addInstagram("medyo80")
                .create();
        setContentView(aboutPage);

//        setContentView(R.layout.five);
//        button = (Button) findViewById(R.id.button1);
//        t1 = (TextView) findViewById(R.id.tV1);
//        t2 = (TextView) findViewById(R.id.tV2);
//        t3 = (TextView) findViewById(R.id.tV3);
//        t4 = (TextView) findViewById(R.id.tV4);
//        t5 = (TextView) findViewById(R.id.tV5);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!LockMenu) {
//                    LockMenu = true;
//                    openAnim(t1, 0, 5, 300);
//                    openAnim(t2, 1, 5, 300);
//                    openAnim(t3, 2, 5, 300);
//                    openAnim(t4, 3, 5, 300);
//                    openAnim(t5, 4, 5, 300);
//                } else {
//                    LockMenu = false;
//                    closeAnim(t1, 0, 5, 300);
//                    closeAnim(t2, 1, 5, 300);
//                    closeAnim(t3, 2, 5, 300);
//                    closeAnim(t4, 3, 5, 300);
//                    closeAnim(t5, 4, 5, 300);
//                }
//            }
//        });
//
//
//    }
//
//    //打开菜单
//    public void openAnim(View view, int index, int num, int radius) {
//        if (view.getVisibility() != View.VISIBLE) {
//            view.setVisibility(View.VISIBLE);
//        }
//        double angle = Math.toRadians(180) / (num - 1) * index;
//        int translationX = -(int) (radius * Math.cos(angle));
//        int translationY = -(int) (radius * Math.sin(angle));
//
//        ObjectAnimator one = ObjectAnimator.ofFloat(view, "translationX", 0, translationX);
//        ObjectAnimator two = ObjectAnimator.ofFloat(view, "translationY", 0, translationY);
//        ObjectAnimator three = ObjectAnimator.ofFloat(view, "rotation", 0, 360);
//        ObjectAnimator four = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
//        ObjectAnimator five = ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f);
//        ObjectAnimator six = ObjectAnimator.ofFloat(view, "alpha", 0f, 1);
//        AnimatorSet set = new AnimatorSet();
//        set.playTogether(one, two, three, four, five, six);
//        set.setDuration(2000);
//        //回弹效果
//        set.setInterpolator(new BounceInterpolator());
//        set.start();
//    }
//
//    //关闭菜单
//    public void closeAnim(View view, int index, int num, int radius) {
//        if (view.getVisibility() != View.VISIBLE) {
//            view.setVisibility(View.VISIBLE);
//        }
//        double angle = Math.toRadians(180) / (num - 1) * index;
//        Log.e("angle", angle + "");
//        int translationX = -(int) (radius * Math.cos(angle));
//        int translationY = -(int) (radius * Math.sin(angle));
//
//        ObjectAnimator one = ObjectAnimator.ofFloat(view, "translationX", translationX, 0);
//        ObjectAnimator two = ObjectAnimator.ofFloat(view, "translationY", translationY, 0);
//        ObjectAnimator three = ObjectAnimator.ofFloat(view, "rotation", 0, 360);
//        ObjectAnimator four = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
//        ObjectAnimator five = ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f);
//        ObjectAnimator six = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f);
//
//        AnimatorSet set = new AnimatorSet();
//        set.playTogether(one, two, three, four, five, six);
//        set.setDuration(2000);
//        //回弹效果
//        set.setInterpolator(new BounceInterpolator());
//        set.start();
//    }
//
//
//    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.tV1:
//                Intent intent1=new Intent(Five.this,One.class);
//                startActivity(intent1);
//                this.finish();
//                break;
//            case R.id.tV2:
//                Intent intent2=new Intent(Five.this,Two.class);
//                startActivity(intent2);
//                this.finish();
//                break;
//            case R.id.tV3:
//                Intent intent3=new Intent(Five.this,Three.class);
//                startActivity(intent3);
//                this.finish();
//                break;
//            case R.id.tV4:
//                Intent intent4=new Intent(Five.this,Four.class);
//                startActivity(intent4);
//                this.finish();
//                break;
//            case R.id.tV5:
//                Intent intent5=new Intent(Five.this,MainActivity.class);
//                startActivity(intent5);
//                this.finish();
//                break;
//        }
//    }
//
//    @Override
//    public void startActivity(Intent intent) {
//        super.startActivity(intent);
//
//        // activity切换动画
//        // 参数一：新Activity进入的动画(最右侧进来)
//        // 参数二：旧Activity退出的动画(最左侧出去)
//        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
//    }

}}



