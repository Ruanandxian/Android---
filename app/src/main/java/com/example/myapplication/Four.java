package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.github.florent37.materialtextfield.MaterialTextField;
import com.github.johnpersano.supertoasts.library.Style;
import com.github.johnpersano.supertoasts.library.SuperActivityToast;
import com.github.johnpersano.supertoasts.library.utils.PaletteUtils;
import com.nightonke.jellytogglebutton.JellyToggleButton;
import com.nightonke.jellytogglebutton.State;

import blcs.lwb.utils.greendao.DaoMaster;
import blcs.lwb.utils.greendao.DaoSession;
import blcs.lwb.utils.greendao.entertainmentDao;
import blcs.lwb.utils.greendao.informationDao;
import blcs.lwb.utils.greendao.lifeDao;
import blcs.lwb.utils.greendao.shoppingDao;

public class Four extends AppCompatActivity implements View.OnClickListener {
    Button button = null;
    TextView t1, t2, t3, t4, t5 = null;
    JellyToggleButton tog1,tog2,tog3,tog4=null;
    EditText et1,et2=null;
    ImageView add_commit;
    String Name,Url=null;
    boolean tag=true;
    boolean LockMenu = false;
    private static DaoSession daoSession;
    private static shoppingDao sdao1;
    private static entertainmentDao sdao2;
    private static informationDao sdao3;
    private static lifeDao sdao4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);
        initGreenDao();
        //获取GreenDao数据库操作对象
        DaoSession daoSession = Four.getDaoSession();
        //获取指定的操作对象
        sdao1 = daoSession.getShoppingDao();
        sdao2 = daoSession.getEntertainmentDao();
        sdao3 = daoSession.getInformationDao();
        sdao4 = daoSession.getLifeDao();
        data_init dl=new data_init();
        button = (Button) findViewById(R.id.button1);
        t1 = (TextView) findViewById(R.id.tV1);
        t2 = (TextView) findViewById(R.id.tV2);
        t3 = (TextView) findViewById(R.id.tV3);
        t4 = (TextView) findViewById(R.id.tV4);
        t5 = (TextView) findViewById(R.id.tV5);
        tog1=(JellyToggleButton)findViewById(R.id.tog1);
        tog2=(JellyToggleButton)findViewById(R.id.tog2);
        tog3=(JellyToggleButton)findViewById(R.id.tog3);
        tog4=(JellyToggleButton)findViewById(R.id.tog4);
        et1=(EditText)findViewById(R.id.et1);
        et2=(EditText)findViewById(R.id.et2);
        add_commit=(ImageView) findViewById(R.id.add_commit);

        et2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }
            //et2改变后执行
            @Override
            public void afterTextChanged(Editable editable) {
                add_commit.setVisibility(View.VISIBLE);
            }
        });


        add_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Name=et1.getText().toString();
                Url=et2.getText().toString();
                if(Name.equals("")||Url.equals("")){
                    SuperActivityToast.create(Four.this, new Style(), Style.TYPE_STANDARD)
                            .setButtonText("UNDO")
                            .setButtonIconResource(R.drawable.buildings)
                            .setProgressBarColor(Color.WHITE)
                            .setText("请填写Name or Url——Name不可重复")
                            .setDuration(Style.DURATION_LONG)
                            .setFrame(Style.FRAME_LOLLIPOP)
                            .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE_GREY))
                            .setAnimations(Style.ANIMATIONS_POP).show();
                }else{
                    tog1.setVisibility(View.VISIBLE);
                    tog2.setVisibility(View.VISIBLE);
                    tog3.setVisibility(View.VISIBLE);
                    tog4.setVisibility(View.VISIBLE);
                    if(tag){
                        SuperActivityToast.create(Four.this, new Style(), Style.TYPE_STANDARD)
                                .setButtonText("UNDO")
                                .setButtonIconResource(R.drawable.buildings)
                                .setProgressBarColor(Color.WHITE)
                                .setText("点击选择具体item")
                                .setDuration(Style.DURATION_LONG)
                                .setFrame(Style.FRAME_LOLLIPOP)
                                .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_BLUE_GREY))
                                .setAnimations(Style.ANIMATIONS_POP).show();
                        tag=false;
                    }
                }

            }
        });
        tog1.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
            @Override
            public void onStateChange(float process, State state, JellyToggleButton jtb) {
                // process - 当前动画进度，在[0, 1]之间
                // state   - JTB的当前状态，其值为State.LEFT，State.LEFT_TO_RIGHT，State.RIGHT和State.RIGHT_TO_LEFT其中之一
                // jtb     - JTB自身
                if (state.equals(State.LEFT)) {

                }
                if (state.equals(State.RIGHT)) {
                    SuperActivityToast.create(Four.this, new Style(), Style.TYPE_STANDARD)
                            .setButtonText("UNDO")
                            .setButtonIconResource(R.drawable.buildings)
                            .setProgressBarColor(Color.WHITE)
                            .setText("购物海淘添加成功")
                            .setDuration(Style.DURATION_LONG)
                            .setFrame(Style.FRAME_LOLLIPOP)
                            .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_GREEN))
                            .setAnimations(Style.ANIMATIONS_POP).show();
                    insert1(Name,Url,"xiaobiaoqing","","");
                    tog1.setVisibility(View.INVISIBLE);
                    tog2.setVisibility(View.INVISIBLE);
                    tog3.setVisibility(View.INVISIBLE);
                    tog4.setVisibility(View.INVISIBLE);
                    tog1.setCheckedImmediately(false);
                    tog2.setCheckedImmediately(false);
                    tog3.setCheckedImmediately(false);
                    tog4.setCheckedImmediately(false);

                    et1.setText("");
                    et2.setText("");
                    add_commit.setVisibility(View.INVISIBLE);
                }

            }
        });

        tog2.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
            @Override
            public void onStateChange(float process, State state, JellyToggleButton jtb) {
                // process - 当前动画进度，在[0, 1]之间
                // state   - JTB的当前状态，其值为State.LEFT，State.LEFT_TO_RIGHT，State.RIGHT和State.RIGHT_TO_LEFT其中之一
                // jtb     - JTB自身
                if (state.equals(State.LEFT)) {

                }
                if (state.equals(State.RIGHT)) {
                    SuperActivityToast.create(Four.this, new Style(), Style.TYPE_STANDARD)
                            .setButtonText("UNDO")
                            .setButtonIconResource(R.drawable.buildings)
                            .setProgressBarColor(Color.WHITE)
                            .setText("娱乐休闲添加成功")
                            .setDuration(Style.DURATION_LONG)
                            .setFrame(Style.FRAME_LOLLIPOP)
                            .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_GREEN))
                            .setAnimations(Style.ANIMATIONS_POP).show();
                    insert2(Name,Url,"xiaobiaoqing","","");
                    tog1.setVisibility(View.INVISIBLE);
                    tog2.setVisibility(View.INVISIBLE);
                    tog3.setVisibility(View.INVISIBLE);
                    tog4.setVisibility(View.INVISIBLE);
                    tog1.setCheckedImmediately(false);
                    tog2.setCheckedImmediately(false);
                    tog3.setCheckedImmediately(false);
                    tog4.setCheckedImmediately(false);
                    et1.setText("");
                    et2.setText("");
                    add_commit.setVisibility(View.INVISIBLE);

                }

            }
        });
        tog3.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
            @Override
            public void onStateChange(float process, State state, JellyToggleButton jtb) {
                // process - 当前动画进度，在[0, 1]之间
                // state   - JTB的当前状态，其值为State.LEFT，State.LEFT_TO_RIGHT，State.RIGHT和State.RIGHT_TO_LEFT其中之一
                // jtb     - JTB自身
                if (state.equals(State.LEFT)) {

                }
                if (state.equals(State.RIGHT)) {
                    SuperActivityToast.create(Four.this, new Style(), Style.TYPE_STANDARD)
                            .setButtonText("UNDO")
                            .setButtonIconResource(R.drawable.buildings)
                            .setProgressBarColor(Color.WHITE)
                            .setText("资讯信息添加成功")
                            .setDuration(Style.DURATION_LONG)
                            .setFrame(Style.FRAME_LOLLIPOP)
                            .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_GREEN))
                            .setAnimations(Style.ANIMATIONS_POP).show();
                    insert3(Name,Url,"xiaobiaoqing","","");
                    tog1.setVisibility(View.INVISIBLE);
                    tog2.setVisibility(View.INVISIBLE);
                    tog3.setVisibility(View.INVISIBLE);
                    tog4.setVisibility(View.INVISIBLE);
                    tog1.setCheckedImmediately(false);
                    tog2.setCheckedImmediately(false);
                    tog3.setCheckedImmediately(false);
                    tog4.setCheckedImmediately(false);
                    et1.setText("");
                    et2.setText("");
                    add_commit.setVisibility(View.INVISIBLE);

                }

            }
        });
        tog4.setOnStateChangeListener(new JellyToggleButton.OnStateChangeListener() {
            @Override
            public void onStateChange(float process, State state, JellyToggleButton jtb) {
                // process - 当前动画进度，在[0, 1]之间
                // state   - JTB的当前状态，其值为State.LEFT，State.LEFT_TO_RIGHT，State.RIGHT和State.RIGHT_TO_LEFT其中之一
                // jtb     - JTB自身
                if (state.equals(State.LEFT)) {

                }
                if (state.equals(State.RIGHT)) {
                    SuperActivityToast.create(Four.this, new Style(), Style.TYPE_STANDARD)
                            .setButtonText("UNDO")
                            .setButtonIconResource(R.drawable.buildings)
                            .setProgressBarColor(Color.WHITE)
                            .setText("生活周边添加成功")
                            .setDuration(Style.DURATION_LONG)
                            .setFrame(Style.FRAME_LOLLIPOP)
                            .setColor(PaletteUtils.getSolidColor(PaletteUtils.MATERIAL_GREEN))
                            .setAnimations(Style.ANIMATIONS_POP).show();
                    insert4(Name,Url,"xiaobiaoqing","","");
                    tog1.setVisibility(View.INVISIBLE);
                    tog2.setVisibility(View.INVISIBLE);
                    tog3.setVisibility(View.INVISIBLE);
                    tog4.setVisibility(View.INVISIBLE);
                    tog1.setCheckedImmediately(false);
                    tog2.setCheckedImmediately(false);
                    tog3.setCheckedImmediately(false);
                    tog4.setCheckedImmediately(false);
                    et1.setText("");
                    et2.setText("");
                    add_commit.setVisibility(View.INVISIBLE);


                }

            }
        });


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


//    数据库
public void insert1(String name,String Url,String Icon,String Item_content,String Item_url){
    shopping sm= new shopping();
    sm.setName(name);
    sm.setUrl(Url);
    sm.setIcon(Icon);
    sm.setItem_content(Item_content);
    sm.setItem_url(Item_url);
    sdao1.insert(sm);
}
    public void insert2(String name,String Url,String Icon,String Item_content,String Item_url){
        entertainment sm= new entertainment();
        sm.setName(name);
        sm.setUrl(Url);
        sm.setIcon(Icon);
        sm.setItem_content(Item_content);
        sm.setItem_url(Item_url);
        sdao2.insert(sm);
    }
    public void insert3(String name,String Url,String Icon,String Item_content,String Item_url){
        information sm= new information();
        sm.setName(name);
        sm.setUrl(Url);
        sm.setIcon(Icon);
        sm.setItem_content(Item_content);
        sm.setItem_url(Item_url);
        sdao3.insert(sm);
    }
    public void insert4(String name,String Url,String Icon,String Item_content,String Item_url){
        life sm= new life();
        sm.setName(name);
        sm.setUrl(Url);
        sm.setIcon(Icon);
        sm.setItem_content(Item_content);
        sm.setItem_url(Item_url);
        sdao4.insert(sm);
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(Four.this, "Smile.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSession() {
        return daoSession;
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
                Intent intent1=new Intent(Four.this,One.class);
                startActivity(intent1);
                it();
                this.finish();
                break;
            case R.id.tV2:
                Intent intent2=new Intent(Four.this,Two.class);
                startActivity(intent2);
                it();
                this.finish();
                break;
            case R.id.tV3:
                Intent intent3=new Intent(Four.this,Three.class);
                startActivity(intent3);
                it();
                this.finish();
                break;
            case R.id.tV4:
                Intent intent4=new Intent(Four.this,MainActivity.class);
                startActivity(intent4);
                it();
                this.finish();
                break;
            case R.id.tV5:
                Intent intent5=new Intent(Four.this,Five.class);
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



