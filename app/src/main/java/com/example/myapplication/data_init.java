package com.example.myapplication;

import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;
import java.util.List;

import blcs.lwb.utils.greendao.DaoMaster;
import blcs.lwb.utils.greendao.DaoSession;
import blcs.lwb.utils.greendao.entertainmentDao;
import blcs.lwb.utils.greendao.informationDao;
import blcs.lwb.utils.greendao.lifeDao;
import blcs.lwb.utils.greendao.shoppingDao;
import blcs.lwb.utils.greendao.testDao;

public class data_init {
    private static DaoSession daoSession;
    private static shoppingDao sdao1;
    private static entertainmentDao sdao2;
    private static informationDao sdao3;
    private static lifeDao sdao4;
    public void init(){
        //获取GreenDao数据库操作对象
        DaoSession daoSession = MainActivity.getDaoSession();
        //获取指定的操作对象
        sdao1 = daoSession.getShoppingDao();
        sdao2 = daoSession.getEntertainmentDao();
        sdao3 = daoSession.getInformationDao();
        sdao4 = daoSession.getLifeDao();


        insert1("京东","https://www.jd.com/","jingdong","OPPO Reno4 Pro|Apple iPhone 11","https://item.jd.com/100007357987.html|https://item.jd.com/100008348542.html");
        insert1("淘宝","https://www.taobao.com/","taobao","Switch","https://detail.tmall.com/item.htm?spm=a230r.1.14.1.39ff7830q4UNqd&id=615922280920&cm_id=140105335569ed55e27b&abbucket=15&sku_properties=5919063:57445706;122216431:27772");
        insert1("聚划算","https://mos.m.taobao.com/union/jhsjx2020?pid=mm_43125636_4246598_109950500130","juhuasuan","夏季工装短袖白衬衫","https://uland.taobao.com/coupon/edetail?spm=a2e0r.13900673.18858355.2&e=cvMtK5oEXtkNfLV8niU3RxrSI%2FOabn6qNg4Gqf8CT4A2Aq%2FO3VjMOBXkOHxIT4pimMHpNfYdHdB7lLxsN%2FZBNi8webzzsiVAnhYYpfJt3hWZgvCKWVsP2WmJVN16a%2FqWXaoOY8%2F9eEd9GGpqzOUllev10KdVrJvYFF6O9STo8Qi8HzXEgh689Qk%2FwPX6CUItJTNWSR3CwiY%3D&app_pvid=59590_11.9.61.58_558_1592115113280&ptl=floorId%3A20493%3Bapp_pvid%3A59590_11.9.61.58_558_1592115113280%3Btpp_pvid%3A403ef602-a0d4-4282-a715-8837cf113314&union_lens=lensId%3AOPT%401592115113%40403ef602-a0d4-4282-a715-8837cf113314_598083119210%401%3Brecoveryid%3Aa2e0r.13900673_1592115110139_025166982782313774_o1%2FMF%3Bprepvid%3Aa2e0r.13900673_1592115110139_025166982782313774_o1%2FMF&pid=mm_43125636_4246598_109950500130");
        insert1("唯品会","https://www.vip.com/","weipinhui","MINISO名创优品 U能量超薄移动电源5000毫安充电宝可爱女生迷你|MINISO/名创优品 Kerokerokeroppi临时停车号码牌","https://detail.vip.com/detail-1710618032-6918688460358534288.html|https://detail.vip.com/detail-1710618032-6918688460595168400.html");
        insert1("一号店","https://www.yhd.com/","yihaodianpng","【优质二手书8-95新】追风筝的人","https://item.yhd.com/70202541888.html");
        insert1("苏宁易购","https://www.suning.com/","suningyigou","LORDE里兜豆腐猫砂 2.6kg/6L装 快速结团无粉尘 除臭可冲厕所","https://product.suning.com/0000000000/10933522375.html?safp=d488778a.46602.productWrap.2&safc=prd.0.0&safpn=10006.500552");

        insert2("爱奇艺","https://www.iqiyi.com/","aiqiyi","奔跑吧第4季:蔡徐坤Baby梦回北宋拼演技 沙溢趾压板初体验被虐哭","https://www.iqiyi.com/v_19rxmjk2ts.html?vfrm=pcw_home&vfrmblk=B&vfrmrst=fcs_0_t13");
        insert2("优酷","https://www.youku.com/","youku","聊斋残卷之六道天书","https://v.youku.com/v_show/id_XNDY3NzQ3NDA0OA==.html?spm=a2hcb.12675304.m_7182_c_14738.d_1&s=294456efbfbd6f2611ef&scm=20140719.rcmd.7182.show_294456efbfbd6f2611ef");
        insert2("4399","http://www.4399.com/","sisan","九宫麻将","http://www.4399.com/flash/212958.htm");
        insert2("哔哩哔哩","https://www.bilibili.com/","bilibili","守望先锋联赛","https://live.bilibili.com/76?spm_id_from=333.851.b_62696c695f7265706f72745f6c697665.3");
        insert2("斗鱼","https://www.douyu.com/","douyu","峡谷直接第一 GJTX","https://www.douyu.com/787747");
        insert2("虎牙","https://www.huya.com/","huya","KZ 1:0 BS CFML春季赛","https://www.huya.com/cfml2020");
        insert2("游民星空","https://www.gamersky.com/","youminxingkong","GTA5","https://www.gamersky.com/z/gta5/");
        insert2("直播吧","https://www.zhibo8.cc/","zhiboba","科比与周杰伦合作的《天地一斗》","https://www.zhibo8.cc/nba/2020/0614-f9ec3ea-svideo.htm");
        insert2("起点中文网","https://www.qidian.com/","qidianzhongwen","斗破苍穹","https://book.qidian.com/info/1209977");
        insert2("网易云","https://music.163.com/","wangyiyun","夏天的风","https://music.163.com/#/song?id=1436709403");
        insert2("豆瓣","https://www.douban.com/","douban","关于宇宙的浪漫句子","https://www.douban.com/gallery/topic/148585/?from=hot_topic_anony_sns");
        insert2("天涯社区","http://www.tianya.cn/","tianyashequ","","");

        insert3("腾讯网","https://www.qq.com/","tengxun","科技兴粮、绿色兴粮 力促粮食生产稳产提质","https://new.qq.com/omn/20200614/20200614A0AZSQ00.html");
        insert3("新浪网","https://www.sina.com.cn/","xinlang","邓伦绿洲营业晒帅气半脸照：麻烦一杯mojito","https://ent.sina.com.cn/s/m/2020-06-14/doc-iircuyvi8428337.shtml");
        insert3("微博","https://weibo.com/","weibo","战疫电影《一呼百应》浙江新闻报道阅读量热力跨越10万","https://weibo.com/ttarticle/p/show?id=2309404515751221395690");
        insert3("搜狐网","https://www.sohu.com/","souhu","北京一地区升级为疫情高风险，10个街乡为中风险","https://www.sohu.com/a/401803274_114988?spm=smpc.home.top-news2.1.1592127617338f8mVwHV&_f=index_news_0");
        insert3("网易","https://www.163.com/","wangyi","又见华尔街踩踏 暴跌1861点","https://money.163.com/20/0614/08/FF2NKKMQ00258105.html");
        insert3("光明网","http://www.gmw.cn/","guangmingwang","非遗老手艺,如何化为脱贫新动力","https://news.gmw.cn/2020-06/12/content_33905987.htm");
        insert3("央视网","https://www.cctv.com/","yangshiwang","时政微视频","http://news.cctv.com/2020/06/14/ARTIJAucQreLdK7Z2BES7gpZ200614.shtml?spm=C96370.PsikHJQ1ICOX.Eebd5GfxbSav.1");
        insert3("人民网","http://www.people.com.cn/","renminwang","重庆  政策利好多 外贸底气足（在危机中育新机 于变局中开新局）","http://politics.people.com.cn/n1/2020/0614/c1001-31745928.html");
        insert3("中国网","http://www.china.com.cn/","zhongguowang","李克强向2020中国－东盟数字经济合作年开幕式致贺信","http://news.china.com.cn/2020-06/12/content_76156951.htm");
        insert3("中国日报","http://www.chinadaily.com.cn/","zhongguoribao","Govt orders better monitoring of dangerous goods","https://news.ifeng.com/c/7xICpCeHgTQ");
        insert3("凤凰网","http://www.ifeng.com/","fenghuangwang","让国歌在香港唱得更嘹亮","http://www.chinadaily.com.cn/a/202006/14/WS5ee54480a310834817252d69.html");
        insert3("新华网","http://www.xinhuanet.com/","xinhuawang","浙江境内高速槽罐车爆炸已造成19人遇难","http://www.xinhuanet.com/politics/2020-06/14/c_1126112336.htm");
        insert3("中关村在线","http://www.zol.com.cn/","zhongguancun","高端ITX平台核心 微星MEG Z490I UNIFY评测","http://diy.zol.com.cn/745/7459793.html");
        insert3("观察者网","https://www.guancha.cn/","guanchazhe","张维为《这就是中国》第58期：探索新型民主","https://www.guancha.cn/ZhangWeiWei/2020_06_14_554040.shtml");
        insert3("东方财富","https://www.eastmoney.com/","dongfangcaifu","外汇","http://forex.eastmoney.com/");
        insert3("虎扑体育","http://www.hupu.com/","hupu","利拉德晒新专辑封面：看看这些给我灵感的GOAT是谁","https://bbs.hupu.com/35965184.html");
        insert3("汽车之家","https://www.autohome.com.cn/beijing/","qichezijia","为外观代言，非英菲尼迪QX50莫属","https://leads.autohome.com.cn/landingpage/html/auto_pc?seriesId=3591&pageId=20000006&articleId=2167558&eid=2167558&channelId=15&autoTaskId=257");
        insert3("雪球","https://xueqiu.com/","xueqiu","雪球热帖","https://xueqiu.com/?category=snb_article");

        insert4("大众点评","http://www.dianping.com/","dazongdianping","私房菜","http://www.dianping.com/kaifeng/ch10/g1338");
        insert4("智联招聘","https://www.zhaopin.com/","zhilianzhaopin","投资经理","https://sou.zhaopin.com/?jl=720&kw=%E6%8A%95%E8%B5%84%E7%BB%8F%E7%90%86&kt=3");
        insert4("QQ邮箱","https://mail.qq.com/","youxiang","","");
        insert4("快递100","https://www.kuaidi100.com/","kuaidi","快递大全","https://www.kuaidi100.com/all/");

    }



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




}
