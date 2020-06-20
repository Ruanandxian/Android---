package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import android.widget.Toast;
import com.eminayar.panter.DialogType;
import com.eminayar.panter.PanterDialog;
import com.eminayar.panter.interfaces.OnTextInputConfirmListener;
import com.thefinestartist.finestwebview.FinestWebView;
import com.yalantis.phoenix.PullToRefreshView;
import androidx.core.content.ContextCompat;
import java.lang.reflect.Field;
import java.util.Random;
import blcs.lwb.utils.greendao.DaoMaster;
import blcs.lwb.utils.greendao.DaoSession;
import blcs.lwb.utils.greendao.testDao;


//模拟器运行用本地图片加载会卡顿，所以采用网络加载图片方法
// 真机流畅，所以打包出来的apk用的本地加载图片方法
//真机网络加载图片会加载不出来
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button = null;
    TextView t1, t2, t3, t4, t5 = null;
    TextView ti;
    boolean LockMenu = false;
    private ExpandingList mExpandingList;
    boolean tag = true;
    private static DaoSession daoSession;
    private static testDao sdao;
    private String name;
    private String url;
    private String icon;
    private String item_content;
    private String item_url;
    private PullToRefreshView mPullToRefreshView;
    final int [] colors = new int[]{R.color.color_1,R.color.color_2,R.color.color_3,R.color.color_4,R.color.color_5,R.color.color_6,R.color.color_7,R.color.color_8,R.color.color_9,R.color.color_10,R.color.color_11,R.color.color_12,R.color.color_13,R.color.color_14,R.color.color_15,R.color.color_16,R.color.color_17,R.color.color_18,R.color.color_19,R.color.color_20,R.color.color_21,R.color.color_22,R.color.color_23,R.color.color_24,R.color.color_25,R.color.color_26,R.color.color_27,R.color.color_28,R.color.color_29,R.color.color_30,R.color.color_31,R.color.color_31,R.color.color_32,R.color.color_33,R.color.color_34,R.color.color_34,R.color.color_36,R.color.color_37,R.color.color_38,R.color.color_39,R.color.color_40,R.color.color_41,R.color.color_42,R.color.color_43,R.color.color_44,R.color.color_45,R.color.color_46,R.color.color_47,R.color.color_48,R.color.color_49,R.color.color_50,R.color.color_51,R.color.color_52,R.color.color_53,R.color.color_54,R.color.color_55,R.color.color_56,R.color.color_57,R.color.color_58,R.color.color_59,R.color.color_60,R.color.color_61,R.color.color_62,R.color.color_63,R.color.color_64,R.color.color_65,R.color.color_66,R.color.color_67,R.color.color_68,R.color.color_69,R.color.color_70,R.color.color_71,R.color.color_72,R.color.color_73,R.color.color_74,R.color.color_75,R.color.color_76,R.color.color_77,R.color.color_78,R.color.color_79,R.color.color_80,R.color.color_81,R.color.color_82,R.color.color_83,R.color.color_84,R.color.color_85,R.color.color_86,R.color.color_87,R.color.color_88,R.color.color_89,R.color.color_90,R.color.color_91,R.color.color_92,R.color.color_93,R.color.color_94,R.color.color_95,R.color.color_96,R.color.color_97,R.color.color_98,R.color.color_99,R.color.color_100,R.color.color_101,R.color.color_102,R.color.color_103,R.color.color_104,R.color.color_105,R.color.color_106,R.color.color_107,R.color.color_108,R.color.color_109,R.color.color_110,R.color.color_111,R.color.color_112,R.color.color_113,R.color.color_114,R.color.color_115,R.color.color_116,R.color.color_117,R.color.color_118,R.color.color_119,R.color.color_120,R.color.color_121,R.color.color_122,R.color.color_123,R.color.color_124,R.color.color_125,R.color.color_126,R.color.color_127,R.color.color_128,R.color.color_129,R.color.color_130,R.color.color_131,R.color.color_132,R.color.color_133,R.color.color_134,R.color.color_135,R.color.color_136,R.color.color_137,R.color.color_138,R.color.color_140,R.color.color_141,R.color.color_142};
    final int [] icons=new int[]{R.mipmap.i1,R.mipmap.i2,R.mipmap.i3,R.mipmap.i4,R.mipmap.i5,R.mipmap.i6,R.mipmap.i7,R.mipmap.i8,R.mipmap.i9,R.mipmap.i10,R.mipmap.i11,R.mipmap.i12,R.mipmap.i13,R.mipmap.i14,R.mipmap.i15,R.mipmap.i16,R.mipmap.i17,R.mipmap.i18,R.mipmap.i19,R.mipmap.i20,R.mipmap.i21,R.mipmap.i22,R.mipmap.i23,R.mipmap.i24,R.mipmap.i25,R.mipmap.i26,R.mipmap.i27,R.mipmap.i28,R.mipmap.i29,R.mipmap.i30,R.mipmap.i31,};
    final int [] pic=new int[]{R.drawable.p0,R.drawable.p1,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,R.drawable.p11,R.drawable.p12,R.drawable.p13,R.drawable.p14,R.drawable.p15,R.drawable.p16,R.drawable.p17,R.drawable.p18,R.drawable.p19,R.drawable.p20};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button1);
        t1 = (TextView) findViewById(R.id.tV1);
        t2 = (TextView) findViewById(R.id.tV2);
        t3 = (TextView) findViewById(R.id.tV3);
        t4 = (TextView) findViewById(R.id.tV4);
        t5 = (TextView) findViewById(R.id.tV5);
        Random random = new Random();
        ImageView myim=(ImageView)findViewById(R.id.myimage);
//        网络加载图片方法
        Glide.with(this).load("http://47.101.144.65/image/0.jpg").into(myim);
//        本地加载图片方法
//        myim.setImageResource(R.drawable.p0);

        //        下拉刷新
        mPullToRefreshView = (PullToRefreshView) findViewById(R.id.pull_to_refresh);
        mPullToRefreshView.setOnRefreshListener(new PullToRefreshView.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myim.setVisibility(View.GONE);
                        mPullToRefreshView.setRefreshing(false);
                        int i=random.nextInt(20);
//                        网络加载速度较慢，故直接将文件放在了本地，影响不大
//                        网络获取图片方法
                        String b=""+i;
                        String a="http://47.101.144.65/image/"+b+".jpg";
                        Glide.with(MainActivity.this).load(a).into(myim);
//                        本地获取的方式
//                        myim.setImageResource(pic[i]);
                        myim.setVisibility(View.VISIBLE);

                    }
                },1500);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                it();
            }
        });
        mExpandingList = findViewById(R.id.expanding_list_main);
        initGreenDao();
        //获取GreenDao数据库操作对象
        DaoSession daoSession = MainActivity.getDaoSession();
        //获取指定的操作对象
        sdao = daoSession.getTestDao();
        try {
            datebase();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        createItems();



    }
//1.菜单相关
//    封装具体方法
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
//2.数据库相关
    public void datebase() throws NoSuchFieldException, IllegalAccessException {
//        判断是否第一次执行
        SharedPreferences sharedPreferences=this.getSharedPreferences("share",MODE_PRIVATE);
        boolean isFirstRun=sharedPreferences.getBoolean("isFirstRun", true);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        if(isFirstRun){
//            Toast.makeText(MainActivity.this, "第一次运行", Toast.LENGTH_SHORT).show();
            editor.putBoolean("isFirstRun", false);
            editor.commit();
            data_init ds = new data_init();
            ds.init();
            init();
        }else{
//            Toast.makeText(MainActivity.this, "不是第一次运行", Toast.LENGTH_SHORT).show();
            init();
        }
//        首次插入数据
//        insert("京东","https://www.jd.com/","jingdong","OPPO Reno4 Pro|Apple iPhone 11","https://item.jd.com/100007357987.html|https://item.jd.com/100008348542.html");
//        insert("淘宝","https://www.taobao.com/","taobao","Switch","https://detail.tmall.com/item.htm?spm=a230r.1.14.1.39ff7830q4UNqd&id=615922280920&cm_id=140105335569ed55e27b&abbucket=15&sku_properties=5919063:57445706;122216431:27772");
//        初始化


    }



//    public void insert(String name,String Url,String Icon,String Item_content,String Item_url){
//        test sm=new test();
//        sm.setName(name);
//        sm.setUrl(Url);
//        sm.setIcon(Icon);
//        sm.setItem_content(Item_content);
//        sm.setItem_url(Item_url);
//        sdao.insert(sm);
//    }

    public void delete(String content){
        test sm=sdao.queryBuilder().where(testDao.Properties.Name.eq(content)).unique();
        daoSession.delete(sm);
    }

    public void update(String name,String item_content,String item_url){
        test sm=sdao.queryBuilder().where(testDao.Properties.Name.eq(name)).unique();
        sm.setItem_content(item_content);
        sm.setItem_url(item_url);
        daoSession.update(sm);
    }

    public void item_add(String name, String item,String url){
        test sm=sdao.queryBuilder().where(testDao.Properties.Name.eq(name)).unique();
//        item.content
        item_content=sm.getItem_content();
        String[] a = item_content.split("\\|");
        List<String> list1= Arrays.asList(a);
        List<String> arrList = new ArrayList<String>(list1);
        arrList.add(item);
        String str= TextUtils.join("|", arrList);
//        item.url
        item_url=sm.getItem_url();
        String[] b = item_url.split("\\|");
        List<String> list2= Arrays.asList(b);
        List<String> arrList2 = new ArrayList<String>(list2);
        arrList2.add(url);
        String str2=TextUtils.join("|", arrList2);
        update(name,str,str2);

    }


    public void item_remove(String name, String item,String url){
        test sm=sdao.queryBuilder().where(testDao.Properties.Name.eq(name)).unique();
//        item.content
        item_content=sm.getItem_content();
        String[] a = item_content.split("\\|");
        List<String> list1= Arrays.asList(a);
        List<String> arrList = new ArrayList<String>(list1);
        arrList.remove(item);
        String str= TextUtils.join("|", arrList);
//        Toast.makeText(MainActivity.this, str, Toast.LENGTH_SHORT).show();
//        item.url
        item_url=sm.getItem_url();
        String[] b = item_url.split("\\|");
        List<String> list2= Arrays.asList(b);
        List<String> arrList2 = new ArrayList<String>(list2);
        arrList2.remove(url);
        String str2=TextUtils.join("|", arrList2);
//        Toast.makeText(MainActivity.this, str2, Toast.LENGTH_SHORT).show();
        update(name,str,str2);

    }


    public void init() throws NoSuchFieldException, IllegalAccessException {
        List<test> list=sdao.queryBuilder().list();
        for(int i=0;i<list.size();i++){
            name=list.get(i).getName();
            url=list.get(i).getUrl();
            icon=list.get(i).getIcon();
            item_content=list.get(i).getItem_content();
            String[] a = item_content.split("\\|");
            item_url=list.get(i).getItem_url();
            String[] b = item_url.split("\\|");
            //        通过字符串的方式获取R.mipmap.的内容
            Field field=R.mipmap.class.getField(icon);
            int Icon= field.getInt(new R.mipmap());
            addItem(name,a,b,colors[(int) (Math.random()*(colors.length-1))],icons[(int) (Math.random()*(icons.length-1))],Icon,url);

        }
    }


    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "Smile.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSession() {
        return daoSession;
    }


//    3.具体item相关
    private void createItems() {
        addItem("京东", new String[]{"OPPO Reno4 Pro", "Apple iPhone 11", },new String[]{"https://item.jd.com/100007357987.html","https://item.jd.com/100008348542.html"} ,R.color.pink, R.mipmap.ic_ghost,R.mipmap.jingdong, "https://www.jd.com/");
        addItem("淘宝", new String[]{"Switch"},new String[]{"https://detail.tmall.com/item.htm?spm=a230r.1.14.1.39ff7830q4UNqd&id=615922280920&cm_id=140105335569ed55e27b&abbucket=15&sku_properties=5919063:57445706;122216431:27772"}, R.color.blue, R.mipmap.ic_ghost,R.mipmap.taobao,"https://www.taobao.com/");
    }



    private void addItem(String title, String[] subItems, String[] url_list,int colorRes, int iconRes, int iconRes2, final String url) {
        //获取到整个item的布局
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.expanding_layout);

        //如果获取成功，设置item的颜色和icon
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            item.setIndicatorIconRes(iconRes);
         //设置分割线
            View fg=(View) item.findViewById(R.id.fengexian);
            Drawable back = ContextCompat.getDrawable(this,colorRes);
            fg.setBackground(back);
        //这里设置了item的标题,绑定title的点击
            TextView ti=((TextView) item.findViewById(R.id.title));
            ti.setText(title);
            ti.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    ImageView am=(ImageView) item.findViewById(R.id.add_more_sub_items);
                    ImageView rm=(ImageView) item.findViewById(R.id.remove_it);
                    if(tag){
                        am.setVisibility(View.VISIBLE);
                        rm.setVisibility(View.VISIBLE);
                        tag=false;
                    }else{
                        am.setVisibility(View.GONE);
                        rm.setVisibility(View.GONE);
                        tag=true;
                    }

                }
            });

        //设置图标，自定义方法
            ImageView ib=(ImageView)item.findViewById(R.id.item_icon);
            ib.setImageResource(iconRes2);

            //根据传入的subItems的长度创建子item
            item.createSubItems(subItems.length);
            for (int i = 0; i < item.getSubItemsCount(); i++) {
                //从0到最后一个，逐个获取
                final View view = item.getSubItemView(i);
                //设置相关标题，封装具体方法，传入url并绑定点击
                configureSubItem(item, view, subItems[i],url_list[i]);
            }

            //为每一个item的添加绑定事件
            item.findViewById(R.id.item_icon).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        Web(url);
//                    Uri uri = Uri.parse("https://www.baidu.com");
//                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                    startActivity(intent);
//                    WebView webView = (WebView) findViewById(R.id.web_view);
//                    webView.setVisibility(View.VISIBLE);
//                    //WebView是否可以后退
//                    boolean canGoBack = webView.canGoBack();
//                    //WebView后退
//                    webView.goBack();
//                    //WebView是否可以前进
//                    boolean canGoForward = webView.canGoForward();
//                    //WebView前进
//                    webView.goForward();
//                    //以当前的index为起始点前进或者后退到历史记录中指定的steps
//                    //如果steps为负数则为后退，正数则为前进
////                    boolean canGoBackOrForward = webView.canGoBackOrForward(step);
//
//                    webView.getSettings().setJavaScriptEnabled(true);
//                    webView.setWebViewClient(new WebViewClient());
//                    webView.loadUrl("http://www.baidu.com");
//                    new FinestWebView.Builder(MainActivity.this).show("http://www.baidu.com");
//                    Toast.makeText(MainActivity.this,"你点击了确定按钮",Toast.LENGTH_LONG ).show();
                }
            });
            ImageView am=(ImageView) item.findViewById(R.id.add_more_sub_items);
            am.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInsertDialog(new OnItemCreated() {
                        @Override
                        public void itemCreated(String title,String url) {
                            //创建一个新的最小子项
                            View newSubItem = item.createSubItem();
                            configureSubItem(item, newSubItem, title,url);
//                            TextView name=((TextView) findViewById(R.id.title));
                            String Name=ti.getText().toString();
                            item_add(Name,title,url);
                        }
                    });
                }
            });
            //删除
            item.findViewById(R.id.remove_it).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExpandingList.removeItem(item);
                    TextView name=((TextView) findViewById(R.id.title));
                    delete(name.getText().toString());
                }
            });
        }
    }



    private void configureSubItem(final ExpandingItem item, final View view, String subTitle,String url) {
        //为最小子项设置标题
        TextView st=((TextView) view.findViewById(R.id.sub_title));
        st.setText(subTitle);
        //设置绑定浏览器跳转
        st.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Web(url);
            }
        });
        //设置绑定删除当前最小子项
        view.findViewById(R.id.remove_sub_item).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item.removeSubItem(view);
                String subT=st.getText().toString();
                TextView name=((TextView) item.findViewById(R.id.title));
                String Name=name.getText().toString();

                Toast.makeText(MainActivity.this, Name+subT+url, Toast.LENGTH_SHORT).show();
                item_remove(Name,subT,url);

            }
        });
//        rb.setChecked(true);



    }




    private void showInsertDialog(final OnItemCreated positive) {
//        设置传回对象，方便回传
        final String[] Text = new String[1];
        final String[] Url = new String[1];

//两个输入框，但不知什么原因，第二个输入框反而先执行，所以将输入框位置对换
        new PanterDialog(this)
                .setHeaderBackground(R.drawable.duihuakuang)
                .setHeaderLogo(R.drawable.duihuakuang_zhong)
                .setDialogType(DialogType.INPUT)
                .isCancelable(true)
                .input("URL:\n"+"http://\n"+"https://",
                        null, new
                                OnTextInputConfirmListener() {
                                    @Override
                                    public void onTextInputConfirmed(String text) {
                                        Url[0] =text;
//                                        将输入框内容传回
                                        positive.itemCreated(Text[0],Url[0]);
//                                        Toast.makeText(MainActivity.this, text, Toast.LENGTH_LONG).show();
                                    }
                                })
                .setPositive("I GOT IT")
                .setNegative("DISMISS")
                .show();

        new PanterDialog(this)
                .setHeaderBackground(R.drawable.content)
                .setHeaderLogo(R.drawable.duihuakuang_zhong)
                .setDialogType(DialogType.INPUT)
                .isCancelable(true)
                .input("NAME:",
                        null, new
                                OnTextInputConfirmListener() {
                                    @Override
                                    public void onTextInputConfirmed(String text) {
                                        Text[0] =text;
//                                        Toast.makeText(MainActivity.this,Text[0], Toast.LENGTH_LONG).show();
                                    }
                                })
                .setPositive("I GOT IT")
                .setNegative("DISMISS")
                .show();

    }
//接口，传回第一个输入框中的name，第二个输入框中的url
    interface OnItemCreated {
        void itemCreated(String title, String url);
    }



    //    自定义浏览器相关方法
    private void Web(String url){
        new FinestWebView.Builder(MainActivity.this).theme(R.style.FinestWebViewTheme)
                .titleDefault("Dribbble")
                .toolbarScrollFlags(0)
                .statusBarColorRes(R.color.blackPrimaryDark)
                .toolbarColorRes(R.color.blackPrimary)
                .titleColorRes(R.color.finestWhite)
                .urlColorRes(R.color.blackPrimaryLight)
                .iconDefaultColorRes(R.color.finestWhite)
                .progressBarColorRes(R.color.finestWhite)
                .swipeRefreshColorRes(R.color.blackPrimaryDark)
                .menuSelector(R.drawable.selector_light_theme)
                .menuTextGravity(Gravity.CENTER_VERTICAL | Gravity.RIGHT)
                .menuTextPaddingRightRes(R.dimen.defaultMenuTextPaddingLeft)
                .dividerHeight(0)
                .gradientDivider(false)
                //                    .setCustomAnimations(R.anim.slide_up, R.anim.hold, R.anim.hold, R.anim.slide_down)
                .setCustomAnimations(R.anim.slide_left_in, R.anim.hold, R.anim.hold,
                        R.anim.slide_right_out)
                //                    .setCustomAnimations(R.anim.fade_in_fast, R.anim.fade_out_medium, R.anim.fade_in_medium, R.anim.fade_out_fast)
                .disableIconBack(false)
                .disableIconClose(false)
                .disableIconForward(false)
                .disableIconMenu(false)
                .show(url);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tV1:
                Intent intent1=new Intent(MainActivity.this,One.class);
                startActivity(intent1);
//                LockMenu = false;
//                closeAnim(t1, 0, 5, 300);
//                closeAnim(t2, 1, 5, 300);
//                closeAnim(t3, 2, 5, 300);
//                closeAnim(t4, 3, 5, 300);
//                closeAnim(t5, 4, 5, 300);
                it();
                this.finish();

                break;
            case R.id.tV2:
                Intent intent2=new Intent(MainActivity.this,Two.class);
                startActivity(intent2);
//                LockMenu = false;
//                closeAnim(t1, 0, 5, 300);
//                closeAnim(t2, 1, 5, 300);
//                closeAnim(t3, 2, 5, 300);
//                closeAnim(t4, 3, 5, 300);
//                closeAnim(t5, 4, 5, 300);
                it();
                this.finish();
                break;
            case R.id.tV3:
                Intent intent3=new Intent(MainActivity.this,Three.class);
                startActivity(intent3);
//                LockMenu = false;
//                closeAnim(t1, 0, 5, 300);
//                closeAnim(t2, 1, 5, 300);
//                closeAnim(t3, 2, 5, 300);
//                closeAnim(t4, 3, 5, 300);
//                closeAnim(t5, 4, 5, 300);
                it();
                this.finish();
                break;
            case R.id.tV4:
                Intent intent4=new Intent(MainActivity.this,Four.class);
                startActivity(intent4);
//                LockMenu = false;
//                closeAnim(t1, 0, 5, 300);
//                closeAnim(t2, 1, 5, 300);
//                closeAnim(t3, 2, 5, 300);
//                closeAnim(t4, 3, 5, 300);
//                closeAnim(t5, 4, 5, 300);
                it();
                this.finish();
                break;
            case R.id.tV5:
                Intent intent5=new Intent(MainActivity.this,Five.class);
                startActivity(intent5);
//                LockMenu = false;
//                closeAnim(t1, 0, 5, 300);
//                closeAnim(t2, 1, 5, 300);
//                closeAnim(t3, 2, 5, 300);
//                closeAnim(t4, 3, 5, 300);
//                closeAnim(t5, 4, 5, 300);
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



