package com.example.myapplication;

import androidx.fragment.app.Fragment;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.diegodobelo.expandingview.ExpandingItem;
import com.diegodobelo.expandingview.ExpandingList;
import com.eminayar.panter.DialogType;
import com.eminayar.panter.PanterDialog;
import com.eminayar.panter.interfaces.OnTextInputConfirmListener;
import com.thefinestartist.finestwebview.FinestWebView;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import blcs.lwb.utils.greendao.DaoMaster;
import blcs.lwb.utils.greendao.DaoSession;
import blcs.lwb.utils.greendao.entertainmentDao;

public class Second extends Fragment {
    private ExpandingList mExpandingList;
    boolean tag = true;
    private static DaoSession daoSession;
    private static entertainmentDao sdao;
    private String name;
    private String url;
    private String icon;
    private String item_content;
    private String item_url;
    final int [] colors = new int[]{R.color.color_1,R.color.color_2,R.color.color_3,R.color.color_4,R.color.color_5,R.color.color_6,R.color.color_7,R.color.color_8,R.color.color_9,R.color.color_10,R.color.color_11,R.color.color_12,R.color.color_13,R.color.color_14,R.color.color_15,R.color.color_16,R.color.color_17,R.color.color_18,R.color.color_19,R.color.color_20,R.color.color_21,R.color.color_22,R.color.color_23,R.color.color_24,R.color.color_25,R.color.color_26,R.color.color_27,R.color.color_28,R.color.color_29,R.color.color_30,R.color.color_31,R.color.color_31,R.color.color_32,R.color.color_33,R.color.color_34,R.color.color_34,R.color.color_36,R.color.color_37,R.color.color_38,R.color.color_39,R.color.color_40,R.color.color_41,R.color.color_42,R.color.color_43,R.color.color_44,R.color.color_45,R.color.color_46,R.color.color_47,R.color.color_48,R.color.color_49,R.color.color_50,R.color.color_51,R.color.color_52,R.color.color_53,R.color.color_54,R.color.color_55,R.color.color_56,R.color.color_57,R.color.color_58,R.color.color_59,R.color.color_60,R.color.color_61,R.color.color_62,R.color.color_63,R.color.color_64,R.color.color_65,R.color.color_66,R.color.color_67,R.color.color_68,R.color.color_69,R.color.color_70,R.color.color_71,R.color.color_72,R.color.color_73,R.color.color_74,R.color.color_75,R.color.color_76,R.color.color_77,R.color.color_78,R.color.color_79,R.color.color_80,R.color.color_81,R.color.color_82,R.color.color_83,R.color.color_84,R.color.color_85,R.color.color_86,R.color.color_87,R.color.color_88,R.color.color_89,R.color.color_90,R.color.color_91,R.color.color_92,R.color.color_93,R.color.color_94,R.color.color_95,R.color.color_96,R.color.color_97,R.color.color_98,R.color.color_99,R.color.color_100,R.color.color_101,R.color.color_102,R.color.color_103,R.color.color_104,R.color.color_105,R.color.color_106,R.color.color_107,R.color.color_108,R.color.color_109,R.color.color_110,R.color.color_111,R.color.color_112,R.color.color_113,R.color.color_114,R.color.color_115,R.color.color_116,R.color.color_117,R.color.color_118,R.color.color_119,R.color.color_120,R.color.color_121,R.color.color_122,R.color.color_123,R.color.color_124,R.color.color_125,R.color.color_126,R.color.color_127,R.color.color_128,R.color.color_129,R.color.color_130,R.color.color_131,R.color.color_132,R.color.color_133,R.color.color_134,R.color.color_135,R.color.color_136,R.color.color_137,R.color.color_138,R.color.color_140,R.color.color_141,R.color.color_142};
    final int [] icons=new int[]{R.mipmap.i1,R.mipmap.i2,R.mipmap.i3,R.mipmap.i4,R.mipmap.i5,R.mipmap.i6,R.mipmap.i7,R.mipmap.i8,R.mipmap.i9,R.mipmap.i10,R.mipmap.i11,R.mipmap.i12,R.mipmap.i13,R.mipmap.i14,R.mipmap.i15,R.mipmap.i16,R.mipmap.i17,R.mipmap.i18,R.mipmap.i19,R.mipmap.i20,R.mipmap.i21,R.mipmap.i22,R.mipmap.i23,R.mipmap.i24,R.mipmap.i25,R.mipmap.i26,R.mipmap.i27,R.mipmap.i28,R.mipmap.i29,R.mipmap.i30,R.mipmap.i31,};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.second, null);
        mExpandingList = (ExpandingList)view.findViewById(R.id.expanding_list_main);
        initGreenDao();
        //获取GreenDao数据库操作对象
        DaoSession daoSession = MainActivity.getDaoSession();
        //获取指定的操作对象
        sdao = daoSession.getEntertainmentDao();
        try {
            datebase();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return view;
    }

    //2.初始化页面
    public void datebase() throws NoSuchFieldException, IllegalAccessException {
        init();
    }


    //3数据库相关

    public void delete(String content){
        entertainment sm=sdao.queryBuilder().where(entertainmentDao.Properties.Name.eq(content)).unique();
        daoSession.delete(sm);
    }

    public void update(String name,String item_content,String item_url){
        entertainment sm=sdao.queryBuilder().where(entertainmentDao.Properties.Name.eq(name)).unique();
        sm.setItem_content(item_content);
        sm.setItem_url(item_url);
        daoSession.update(sm);
    }

    public void item_add(String name, String item,String url){
        entertainment sm=sdao.queryBuilder().where(entertainmentDao.Properties.Name.eq(name)).unique();
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
        entertainment sm=sdao.queryBuilder().where(entertainmentDao.Properties.Name.eq(name)).unique();
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
        List<entertainment> list=sdao.queryBuilder().list();
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
            if(item_content.equals("") || item_url.equals("")){
                addItem(name,new String[]{},new String[]{},colors[(int) (Math.random()*(colors.length-1))],icons[(int) (Math.random()*(icons.length-1))],Icon,url);

            }else{
                addItem(name,a,b,colors[(int) (Math.random()*(colors.length-1))],icons[(int) (Math.random()*(icons.length-1))],Icon,url);

            }
        }
    }


    private void initGreenDao() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this.getContext(), "Smile.db");
        SQLiteDatabase db = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
    public static DaoSession getDaoSession() {
        return daoSession;
    }


//先前的静态尝试
//    private void createItems() {
//        Random random = new Random();
//        final int [] colors = new int[]{R.color.color_1,R.color.color_2,R.color.color_3,R.color.color_4,R.color.color_5,R.color.color_6,R.color.color_7,R.color.color_8,R.color.color_9,R.color.color_10,R.color.color_11,R.color.color_12,R.color.color_13,R.color.color_14,R.color.color_15,R.color.color_16,R.color.color_17,R.color.color_18,R.color.color_19,R.color.color_20,R.color.color_21,R.color.color_22,R.color.color_23,R.color.color_24,R.color.color_25,R.color.color_26,R.color.color_27,R.color.color_28,R.color.color_29,R.color.color_30,R.color.color_31,R.color.color_31,R.color.color_32,R.color.color_33,R.color.color_34,R.color.color_34,R.color.color_36,R.color.color_37,R.color.color_38,R.color.color_39,R.color.color_40,R.color.color_41,R.color.color_42,R.color.color_43,R.color.color_44,R.color.color_45,R.color.color_46,R.color.color_47,R.color.color_48,R.color.color_49,R.color.color_50,R.color.color_51,R.color.color_52,R.color.color_53,R.color.color_54,R.color.color_55,R.color.color_56,R.color.color_57,R.color.color_58,R.color.color_59,R.color.color_60,R.color.color_61,R.color.color_62,R.color.color_63,R.color.color_64,R.color.color_65,R.color.color_66,R.color.color_67,R.color.color_68,R.color.color_69,R.color.color_70,R.color.color_71,R.color.color_72,R.color.color_73,R.color.color_74,R.color.color_75,R.color.color_76,R.color.color_77,R.color.color_78,R.color.color_79,R.color.color_80,R.color.color_81,R.color.color_82,R.color.color_83,R.color.color_84,R.color.color_85,R.color.color_86,R.color.color_87,R.color.color_88,R.color.color_89,R.color.color_90,R.color.color_91,R.color.color_92,R.color.color_93,R.color.color_94,R.color.color_95,R.color.color_96,R.color.color_97,R.color.color_98,R.color.color_99,R.color.color_100,R.color.color_101,R.color.color_102,R.color.color_103,R.color.color_104,R.color.color_105,R.color.color_106,R.color.color_107,R.color.color_108,R.color.color_109,R.color.color_110,R.color.color_111,R.color.color_112,R.color.color_113,R.color.color_114,R.color.color_115,R.color.color_116,R.color.color_117,R.color.color_118,R.color.color_119,R.color.color_120,R.color.color_121,R.color.color_122,R.color.color_123,R.color.color_124,R.color.color_125,R.color.color_126,R.color.color_127,R.color.color_128,R.color.color_129,R.color.color_130,R.color.color_131,R.color.color_132,R.color.color_133,R.color.color_134,R.color.color_135,R.color.color_136,R.color.color_137,R.color.color_138,R.color.color_140,R.color.color_141,R.color.color_142};
//        final int [] icons=new int[]{R.mipmap.i1,R.mipmap.i2,R.mipmap.i3,R.mipmap.i4,R.mipmap.i5,R.mipmap.i6,R.mipmap.i7,R.mipmap.i8,R.mipmap.i9,R.mipmap.i10,R.mipmap.i11,R.mipmap.i12,R.mipmap.i13,R.mipmap.i14,R.mipmap.i15,R.mipmap.i16,R.mipmap.i17,R.mipmap.i18,R.mipmap.i19,R.mipmap.i20,R.mipmap.i21,R.mipmap.i22,R.mipmap.i23,R.mipmap.i24,R.mipmap.i25,R.mipmap.i26,R.mipmap.i27,R.mipmap.i28,R.mipmap.i29,R.mipmap.i30,R.mipmap.i31,};
//        addItem("爱奇艺", new String[]{"奔跑吧第4季 : 蔡徐坤Baby梦回北宋拼演技 沙溢趾压板初体验被虐哭"},new String[]{"https://www.iqiyi.com/v_19rxmjk2ts.html?vfrm=pcw_home&vfrmblk=B&vfrmrst=fcs_0_t13"} ,colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.aiqiyi, "https://www.iqiyi.com/");
//        addItem("优酷", new String[]{"聊斋残卷之六道天书"},new String[]{"https://v.youku.com/v_show/id_XNDY3NzQ3NDA0OA==.html?spm=a2hcb.12675304.m_7182_c_14738.d_1&s=294456efbfbd6f2611ef&scm=20140719.rcmd.7182.show_294456efbfbd6f2611ef"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.youku,"https://www.youku.com/");
//        addItem("4399", new String[]{"九宫麻将"},new String[]{"http://www.4399.com/flash/212958.htm"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.sisan,"http://www.4399.com/");
//        addItem("哔哩哔哩", new String[]{"守望先锋联赛"},new String[]{"https://live.bilibili.com/76?spm_id_from=333.851.b_62696c695f7265706f72745f6c697665.3"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.bilibili,"https://www.bilibili.com/");
//        addItem("斗鱼", new String[]{"峡谷直接第一 GJTX"},new String[]{"https://www.douyu.com/787747"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.douyu,"https://www.douyu.com/");
//        addItem("虎牙", new String[]{"KZ 1:0 BS CFML春季赛"},new String[]{"https://www.huya.com/cfml2020"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.huya,"https://www.huya.com/");
//        addItem("游民星空", new String[]{"GTA5"},new String[]{"https://www.gamersky.com/z/gta5/"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.youminxingkong,"https://www.gamersky.com/");
//        addItem("直播吧", new String[]{"科比与周杰伦合作的《天地一斗》"},new String[]{"https://www.zhibo8.cc/nba/2020/0614-f9ec3ea-svideo.htm"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.zhiboba,"https://www.zhibo8.cc/");
//        addItem("起点中文网", new String[]{"斗破苍穹"},new String[]{"https://book.qidian.com/info/1209977"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.qidianzhongwen,"https://www.qidian.com/");
//        addItem("网易云", new String[]{"夏天的风"},new String[]{"https://music.163.com/#/song?id=1436709403"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.wangyiyun,"https://music.163.com/");
//        addItem("豆瓣", new String[]{"关于宇宙的浪漫句子"},new String[]{"https://www.douban.com/gallery/topic/148585/?from=hot_topic_anony_sns"},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.douban,"https://www.douban.com/");
//        addItem("天涯社区", new String[]{},new String[]{},colors[(int) (Math.random()*(colors.length-1))], icons[(int) (Math.random()*(icons.length-1))],R.mipmap.tianyashequ,"http://www.tianya.cn/");
//
//    }


    private void addItem(String title, String[] subItems, String[] url_list,int colorRes, int iconRes, int iconRes2, final String url) {
        //获取到整个item的布局
        final ExpandingItem item = mExpandingList.createNewItem(R.layout.expanding_layout);

        //如果获取成功，设置item的颜色和icon
        if (item != null) {
            item.setIndicatorColorRes(colorRes);
            item.setIndicatorIconRes(iconRes);

            //这里设置了item的标题,绑定title的点击
            TextView ti=((TextView) item.findViewById(R.id.title));
            ti.setText(title);
            ti.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    ImageView am=(ImageView) item.findViewById(R.id.add_more_sub_items);
                    ImageView rm=(ImageView) item.findViewById(R.id.remove_it);
//                    ImageView dm=(ImageView) item.findViewById(R.id.add_it);
                    if(tag){
                        am.setVisibility(View.VISIBLE);
                        rm.setVisibility(View.VISIBLE);
//                        dm.setVisibility(View.VISIBLE);
                        tag=false;
                    }else{
                        am.setVisibility(View.GONE);
                        rm.setVisibility(View.GONE);
//                        dm.setVisibility(View.GONE);
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
                }
            });
            ImageView am=(ImageView) item.findViewById(R.id.add_more_sub_items);
            am.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInsertDialog(new MainActivity.OnItemCreated() {
                        @Override
                        public void itemCreated(String title,String url) {
                            //创建一个新的最小子项
                            View newSubItem = item.createSubItem();
                            configureSubItem(item, newSubItem, title,url);
                            String Name=ti.getText().toString();
                            item_add(Name,title,url);
                        }
                    });
                }
            });
            //侧滑删除
            item.findViewById(R.id.remove_it).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mExpandingList.removeItem(item);
                    TextView name=((TextView) item.findViewById(R.id.title));
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
                item_remove(Name,subT,url);

            }
        });
//        rb.setChecked(true);



    }



    private void showInsertDialog(final MainActivity.OnItemCreated positive) {
//        设置传回对象，方便回传
        final String[] Text = new String[1];
        final String[] Url = new String[1];

//两个输入框，但不知什么原因，第二个输入框反而先执行，所以将输入框位置对换
        new PanterDialog(this.getContext())
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

        new PanterDialog(this.getContext())
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
        new FinestWebView.Builder(this.getContext()).theme(R.style.FinestWebViewTheme)
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

}