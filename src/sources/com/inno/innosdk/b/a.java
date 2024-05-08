package com.inno.innosdk.b;

import android.text.TextUtils;
import com.inno.innosdk.a.c;
import com.inno.innosdk.bean.FyDeviceInfo;
import com.inno.innosdk.utils.q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DbApi.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {
    public static void a(long j10) {
        try {
            q.d(c.k(), "InnoEndTime", String.valueOf(j10));
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void b(long j10) {
        try {
            long h10 = h();
            q.d(c.k(), "myAppTime", String.valueOf(h10 + j10));
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void c() {
        try {
            q.d(c.k(), "innoBattery", null);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void d(String str) {
        try {
            q.d(c.k(), "Inno_xjl", str);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static boolean e(String str) {
        com.inno.innosdk.utils.c.a(c.k()).b(c.k());
        return q.d(c.k(), "innotechBlackApps", str);
    }

    public static void f(String str) {
        q.d(c.k(), "innotechBlackUp", str);
    }

    public static long g() {
        try {
            return Long.parseLong(q.b(c.k(), "InnoEndTime", "0"));
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return 0L;
        }
    }

    public static long h() {
        try {
            return Long.parseLong(q.b(c.k(), "myAppTime", "0"));
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return 0L;
        }
    }

    public static String i() {
        try {
            return q.b(c.k(), "innoBattery", "");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            try {
                q.d(c.k(), "innoBattery", "");
                return "";
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
                return "";
            }
        }
    }

    public static void j(String str) {
        q.d(c.k(), "innotechBlackpidnVersion", str);
    }

    public static void k(String str) {
        q.d(c.k(), "innotechSimuApps", str);
    }

    public static void l(String str) {
        q.d(c.k(), "innotechSimuAppsVersion", str);
    }

    public static String m() {
        return q.b(c.k(), "lastReceiveTime", "");
    }

    public static String n() {
        try {
            return q.b(c.k(), "Inno_xjl", "");
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            try {
                q.d(c.k(), "Inno_xjl", "");
                return "";
            } catch (Throwable th2) {
                com.inno.innosdk.utils.u.a.a(th2);
                return "";
            }
        }
    }

    public static String o() {
        return q.b(c.k(), "innotechBlackApps", "all.parttimeguidesystem,cn.com.longene.www.myapplication,cn.laibiji.bf,cn.mmsmpj.trqqm.kfmofc.gcqk,cn.qlkj.tcm,cn.shadowsocks.ow,cn.wq.myandroidtoolsxposed,cn.xiaoxue.xx4nianxxsx.xx4ssxsc,com.adsmobile.ytflg,com.android.beeplay,com.android.emu.coreservice,com.app.czjz,com.applisto.appcloner,com.bangju.xiaolongmoney,com.beikenet.diandian,com.bfire.da.nui,com.bly.dkplat,com.bocharov.xposed.fsbi,com.bpfdcdfpblckdgdgcocb.tpl,com.chuangdian.ipjl2,com.ckbbdkcmcdahjjjj.mianfeiyuedu,com.cmcm.happyearn,com.cyjh.adv.mobileanjian,com.cyjh.mobileanjian,com.datouma.xuanshangmao,com.dianjiqi,com.diao.qianyan,com.dingweizshou,com.dkfhckbebdccdmfn.wukong,com.dnfjcoebbncnbncn.yunde,com.dracrays.fakeloc,com.dracrays.fakelocc,com.ds.and.rrxs,com.earn.app,com.example.myxposed,com.excelliance.dualaid,com.fengwobang.app,com.fkzhang.qqxposed,com.gmail.heagoo.apkeditor.pro,com.godinsec.godinsec_private_space,com.gosing.article.news.jh,com.gtxx.slbproject,com.guanchenghuzhuya.hzy,com.guopao.luckymoney,com.haijun.weizhongrenbang,com.heikeji.xianbao,com.huihui.multopen,com.huluxia.gametools,com.jbelf.imei,com.jhjljjjojgjhjljpjnjgjm.chengguancoc,com.jhjljmjljpjhjnjgjgjgjn.jwautoread,com.jhjojhjjjnjgjjjojpjhjg.bajie,com.jhjojhjjjnjgjjjojpjhjg.mingbei,com.jhjojhjjjnjgjjjojpjhjg.xiaomifeng.xiaozhu.z,com.jhjojhjjjnjgjjjojpjhjg.xiaoniu,com.jhjojhjjjnjgjjjojpjhjg.xinke,com.jhjojhjjjnjgjjjojpjhjg.yundian,com.jhjojhjjjnjgjjjojpjhjg.zhanshen,com.jhjojpjkjojhjgjnjijljl.yyoo,com.jianzhiku.zhongrenbang,com.jike.noobmoney,com.jkjpjpjpjljljljojo.geishouxiaozhushou,com.jljjjgjojnjojnjljg.mxlpro,com.joyapp.quanminjianzhi,com.joyapp.universalearn,com.kjmonimpnjlpmhmemn.duotoutiaonowechat,com.kkmlnmmpmcmpnjmojgjjjpjl.jhydzs,com.kkmlnmmpmcmpnjmojgjjjpjl.jhydzszy,com.lbe.parallel,com.leaves.mulopen,com.ljmobile.yjb.root.uninstall,com.lqsw.duowanenvelope,com.mcjijljjjkjjjpjljojl.com.autoreader,com.mcmnmojnjhjgjmjojhjgjkji.superchicken,com.mcmpngmpmemnjijgjg.yd,com.mhjhjjjmjljmjpjojhjijnjn.note.er,com.mhjnjmjkjmjpjgjm.lianheyuedu,com.mjninknkmf.ziyuexiaojinglin,com.mmnlmnnjjijgjhji.toutiaoyuedu,com.mnmfmkmemm.zidongyuedu,com.mobileuncle.toolhero,com.moneyhelp,com.monlmfnpnlnjmomlme.meizutiantianzhuan,com.mugunghwa.blossom,com.mzhapp.mzz,com.namanknomcmlmf.byzs,com.namomhmemnmomhmpmimhmf.sq.vsex.treebear,com.nhjnjljgjhjnjgjijh.llllllll,com.nhnhjnjhjkjmjpjpjijojg.xiaoxicoc,com.ninton.adbu.lazycat,com.nkmlmhninjnimfmhmk.com.qw.rdrelease,com.nompmhmfmemampmhmemn.lhyd,com.nonlmlmlninimfmemnmlni.qttzdgjjb,com.phoneinfo.changerpro,com.planet.light2345,com.qf.mybf,com.qijiol.cn,com.qingsongyue,com.qts.tasktribe,com.quanminzan.app,com.qubangzuanwwa.app,com.quxian.qxz,com.quxianzhuan.wap,com.qy.quyou,com.rise.automatic.autoclicker.clicker,com.robot.heyue,com.sanyou.wanzhuan,com.saurik.substrate,com.scriptelf,com.shichuo.zrb,com.shikexiaobing2,com.shuame.mobile,com.shuame.sprite,com.shunshoubang.bang,com.sigma_rt.totalcontrol,com.smart.bon.superman,com.smartzone.checkpass,com.soft.apk008Tool,com.soft.apk008v,com.sollyu.xposed.hook.model,com.sollyu.xposed.hook.model.dev,com.stardust.scriptdroid,com.tandy.android.mockwxlocation,com.tencent.tmgp.pubgmhdbb,com.tongyi.bishang,com.topjohnwu.magisk,com.touchsprite.android,com.txy.anywhere,com.txy.anywhere.clone,com.uy0.wuyoulin,com.virtualdroid.gps,com.virtualdroid.kit,com.virtualdroid.loc,com.virtualdroid.txl,com.virtualdroid.wxg,com.virtualdroid.wzs,com.wangbaiwan.youshang,com.weizhuan.dbx,com.weizhuan.dqx,com.weizhuan.mtf,com.wifi99.android.locationcheater,com.wxfx.z,com.xiaoyuzhuanqian,com.xiqu.box,com.xm.lyj.quyouzhuan,com.xuniu.zqya,com.xunzhi.cloudtask,com.xxAssistant,com.xzzq.xiaozhuo,com.youchen.mh,com.yunbu.rp.bountyoftimes,com.yuzhuan.task,com.zanqzan.app,com.zdanjian.zdanjian,com.zhangy.huluz,com.zhangy.ttqw,com.zhima.bianjibao,com.zidongdianji,com.zwang.huirenzuan,com.zwang.toutouzhuan,de.robv.android.xposed.installer,in.zhaoj.shadowsocksr,io.hnkj.H54C7DF88,me.gaoshou.money,me.haima.androidassist,net.anylocation,net.anylocation.ultra,net.pinrenwu.pinrenwu,org.autojs.autojs,pro.burgerz.wsm.manager,ren.gaibang.app,sjingbang.com,top.a1024bytes.mockloc.ca.pro,xiake.xserver,xpt.com.hsz,xpt.com.ttz,xpt.com.wwz,yk.juejin,zpp.wjy.xxsq,com.AutfyYun");
    }

    public static Map<String, Boolean> p() {
        HashMap hashMap = new HashMap(16);
        for (String str : q.b(c.k(), "innotechBlackUp", "").split(",")) {
            hashMap.put(str, Boolean.TRUE);
        }
        return hashMap;
    }

    public static String q() {
        return q.b(c.k(), "innotechBlackUp", "");
    }

    public static String r() {
        return q.b(c.k(), "innotechBlackUpVersion", "-1");
    }

    public static String s() {
        Exception e2;
        String str = "56";
        String b4 = q.b(c.k(), "innotechBlackVersion", "0");
        try {
            if (Float.parseFloat(b4) < Float.parseFloat("56")) {
                if (e("all.parttimeguidesystem,cn.com.longene.www.myapplication,cn.laibiji.bf,cn.mmsmpj.trqqm.kfmofc.gcqk,cn.qlkj.tcm,cn.shadowsocks.ow,cn.wq.myandroidtoolsxposed,cn.xiaoxue.xx4nianxxsx.xx4ssxsc,com.adsmobile.ytflg,com.android.beeplay,com.android.emu.coreservice,com.app.czjz,com.applisto.appcloner,com.bangju.xiaolongmoney,com.beikenet.diandian,com.bfire.da.nui,com.bly.dkplat,com.bocharov.xposed.fsbi,com.bpfdcdfpblckdgdgcocb.tpl,com.chuangdian.ipjl2,com.ckbbdkcmcdahjjjj.mianfeiyuedu,com.cmcm.happyearn,com.cyjh.adv.mobileanjian,com.cyjh.mobileanjian,com.datouma.xuanshangmao,com.dianjiqi,com.diao.qianyan,com.dingweizshou,com.dkfhckbebdccdmfn.wukong,com.dnfjcoebbncnbncn.yunde,com.dracrays.fakeloc,com.dracrays.fakelocc,com.ds.and.rrxs,com.earn.app,com.example.myxposed,com.excelliance.dualaid,com.fengwobang.app,com.fkzhang.qqxposed,com.gmail.heagoo.apkeditor.pro,com.godinsec.godinsec_private_space,com.gosing.article.news.jh,com.gtxx.slbproject,com.guanchenghuzhuya.hzy,com.guopao.luckymoney,com.haijun.weizhongrenbang,com.heikeji.xianbao,com.huihui.multopen,com.huluxia.gametools,com.jbelf.imei,com.jhjljjjojgjhjljpjnjgjm.chengguancoc,com.jhjljmjljpjhjnjgjgjgjn.jwautoread,com.jhjojhjjjnjgjjjojpjhjg.bajie,com.jhjojhjjjnjgjjjojpjhjg.mingbei,com.jhjojhjjjnjgjjjojpjhjg.xiaomifeng.xiaozhu.z,com.jhjojhjjjnjgjjjojpjhjg.xiaoniu,com.jhjojhjjjnjgjjjojpjhjg.xinke,com.jhjojhjjjnjgjjjojpjhjg.yundian,com.jhjojhjjjnjgjjjojpjhjg.zhanshen,com.jhjojpjkjojhjgjnjijljl.yyoo,com.jianzhiku.zhongrenbang,com.jike.noobmoney,com.jkjpjpjpjljljljojo.geishouxiaozhushou,com.jljjjgjojnjojnjljg.mxlpro,com.joyapp.quanminjianzhi,com.joyapp.universalearn,com.kjmonimpnjlpmhmemn.duotoutiaonowechat,com.kkmlnmmpmcmpnjmojgjjjpjl.jhydzs,com.kkmlnmmpmcmpnjmojgjjjpjl.jhydzszy,com.lbe.parallel,com.leaves.mulopen,com.ljmobile.yjb.root.uninstall,com.lqsw.duowanenvelope,com.mcjijljjjkjjjpjljojl.com.autoreader,com.mcmnmojnjhjgjmjojhjgjkji.superchicken,com.mcmpngmpmemnjijgjg.yd,com.mhjhjjjmjljmjpjojhjijnjn.note.er,com.mhjnjmjkjmjpjgjm.lianheyuedu,com.mjninknkmf.ziyuexiaojinglin,com.mmnlmnnjjijgjhji.toutiaoyuedu,com.mnmfmkmemm.zidongyuedu,com.mobileuncle.toolhero,com.moneyhelp,com.monlmfnpnlnjmomlme.meizutiantianzhuan,com.mugunghwa.blossom,com.mzhapp.mzz,com.namanknomcmlmf.byzs,com.namomhmemnmomhmpmimhmf.sq.vsex.treebear,com.nhjnjljgjhjnjgjijh.llllllll,com.nhnhjnjhjkjmjpjpjijojg.xiaoxicoc,com.ninton.adbu.lazycat,com.nkmlmhninjnimfmhmk.com.qw.rdrelease,com.nompmhmfmemampmhmemn.lhyd,com.nonlmlmlninimfmemnmlni.qttzdgjjb,com.phoneinfo.changerpro,com.planet.light2345,com.qf.mybf,com.qijiol.cn,com.qingsongyue,com.qts.tasktribe,com.quanminzan.app,com.qubangzuanwwa.app,com.quxian.qxz,com.quxianzhuan.wap,com.qy.quyou,com.rise.automatic.autoclicker.clicker,com.robot.heyue,com.sanyou.wanzhuan,com.saurik.substrate,com.scriptelf,com.shichuo.zrb,com.shikexiaobing2,com.shuame.mobile,com.shuame.sprite,com.shunshoubang.bang,com.sigma_rt.totalcontrol,com.smart.bon.superman,com.smartzone.checkpass,com.soft.apk008Tool,com.soft.apk008v,com.sollyu.xposed.hook.model,com.sollyu.xposed.hook.model.dev,com.stardust.scriptdroid,com.tandy.android.mockwxlocation,com.tencent.tmgp.pubgmhdbb,com.tongyi.bishang,com.topjohnwu.magisk,com.touchsprite.android,com.txy.anywhere,com.txy.anywhere.clone,com.uy0.wuyoulin,com.virtualdroid.gps,com.virtualdroid.kit,com.virtualdroid.loc,com.virtualdroid.txl,com.virtualdroid.wxg,com.virtualdroid.wzs,com.wangbaiwan.youshang,com.weizhuan.dbx,com.weizhuan.dqx,com.weizhuan.mtf,com.wifi99.android.locationcheater,com.wxfx.z,com.xiaoyuzhuanqian,com.xiqu.box,com.xm.lyj.quyouzhuan,com.xuniu.zqya,com.xunzhi.cloudtask,com.xxAssistant,com.xzzq.xiaozhuo,com.youchen.mh,com.yunbu.rp.bountyoftimes,com.yuzhuan.task,com.zanqzan.app,com.zdanjian.zdanjian,com.zhangy.huluz,com.zhangy.ttqw,com.zhima.bianjibao,com.zidongdianji,com.zwang.huirenzuan,com.zwang.toutouzhuan,de.robv.android.xposed.installer,in.zhaoj.shadowsocksr,io.hnkj.H54C7DF88,me.gaoshou.money,me.haima.androidassist,net.anylocation,net.anylocation.ultra,net.pinrenwu.pinrenwu,org.autojs.autojs,pro.burgerz.wsm.manager,ren.gaibang.app,sjingbang.com,top.a1024bytes.mockloc.ca.pro,xiake.xserver,xpt.com.hsz,xpt.com.ttz,xpt.com.wwz,yk.juejin,zpp.wjy.xxsq,com.AutfyYun")) {
                    try {
                        h("56");
                        return "56";
                    } catch (Exception e10) {
                        e2 = e10;
                        com.inno.innosdk.utils.u.a.a((Throwable) e2);
                        return str;
                    }
                }
            }
            return b4;
        } catch (Exception e11) {
            e2 = e11;
            str = b4;
        }
    }

    public static String t() {
        return q.b(c.k(), "innotechBlackpidn", "");
    }

    public static String u() {
        return q.b(c.k(), "innotechBlackpidnVersion", "-1");
    }

    public static String v() {
        return q.b(c.k(), "scriptKeys", "BestResolution,ChangeFileList,Description,FileVersion");
    }

    public static String w() {
        return q.b(c.k(), "innotechSimuApps", "com.mumu.launcher,com.ami.duosupdater.ui,com.ami.launchmetro,com.ami.syncduosservices,com.bluestacks.home,com.bluestacks.windowsfilemanager,com.bluestacks.settings,com.bluestacks.bluestackslocationprovider,com.bluestacks.appsettings,com.bluestacks.bstfolder,com.bluestacks.BstCommandProcessor,com.bluestacks.s2p,com.bluestacks.setup,com.bluestacks.appmart,com.kaopu001.tiantianserver,com.kpzs.helpercenter,com.kaopu001.tiantianime,com.android.development_settings,com.android.development,com.android.customlocale2,com.genymotion.superuser,com.genymotion.clipboardproxy,com.uc.xxzs.keyboard,com.uc.xxzs,com.blue.huang17.agent,com.blue.huang17.launcher,com.blue.huang17.ime,com.microvirt.guide,com.microvirt.market,com.microvirt.memuime,cn.itools.vm.launcher,cn.itools.vm.proxy,cn.itools.vm.softkeyboard,cn.itools.avdmarket,com.syd.IME,com.bignox.app.store.hd,com.bignox.launcher,com.bignox.app.phone,com.bignox.app.noxservice,com.android.noxpush,com.haimawan.push,me.haima.helpcenter,com.windroy.launcher,com.windroy.superuser,com.windroy.launcher,com.windroy.ime,com.android.flysilkworm,com.android.emu.inputservice,com.tiantian.ime,com.microvirt.launcher,me.le8.androidassist,com.vphone.helper,com.vphone.launcher,com.duoyi.giftcenter.giftcenter,com.google.android.launcher.layouts.genymotion");
    }

    public static String x() {
        return q.b(c.k(), "innotechSimuAppsVersion", "-1");
    }

    public static void f() {
        try {
            q.d(c.k(), "Inno_xjl", null);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static String j() {
        return q.b(c.k(), "hostErrName", "");
    }

    public static String k() {
        return q.b(c.k(), "hostErrNetStat", "");
    }

    public static String l() {
        return q.b(c.k(), "lastPostTime", "");
    }

    public static void a() {
        try {
            q.d(c.k(), "InnoEndTime", null);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void c(String str) {
        if (!TextUtils.isEmpty(str) && str.length() <= 1024) {
            q.d(c.k(), "hostErrNetStat", str);
        }
    }

    public static void d() {
        q.d(c.k(), "hostErrName", null);
    }

    public static void e() {
        q.d(c.k(), "hostErrNetStat", null);
    }

    public static void g(String str) {
        q.d(c.k(), "innotechBlackUpVersion", str);
    }

    public static boolean h(String str) {
        return q.d(c.k(), "innotechBlackVersion", str);
    }

    public static void b() {
        try {
            q.d(c.k(), "myAppTime", null);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public static void d(long j10) {
        q.d(c.k(), "lastReceiveTime", String.valueOf(j10));
    }

    public static void a(String str, String str2, String str3, FyDeviceInfo fyDeviceInfo) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (h(str3)) {
                fyDeviceInfo.bv = str3;
                return;
            }
            return;
        }
        ArrayList<String> arrayList = new ArrayList(Arrays.asList(o().split(",")));
        if (!TextUtils.isEmpty(str2)) {
            for (String str4 : str2.split(",")) {
                arrayList.remove(str4);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            for (String str5 : str.split(",")) {
                if (!arrayList.contains(str5)) {
                    arrayList.add(str5);
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (String str6 : arrayList) {
            if (sb2.length() > 0) {
                sb2.append(",");
            }
            sb2.append(str6);
        }
        com.inno.innosdk.utils.u.a.a((Object) ("bv:" + str3));
        com.inno.innosdk.utils.u.a.a((Object) ("baa:" + str));
        com.inno.innosdk.utils.u.a.a((Object) ("sb:" + sb2.toString()));
        if (e(sb2.toString()) && h(str3)) {
            fyDeviceInfo.bv = str3;
        }
    }

    public static void i(String str) {
        q.d(c.k(), "innotechBlackpidn", str);
    }

    public static void b(String str) {
        if (!TextUtils.isEmpty(str) && str.length() <= 1024) {
            q.d(c.k(), "hostErrName", str);
        }
    }

    public static void c(long j10) {
        q.d(c.k(), "lastPostTime", String.valueOf(j10));
    }

    public static void a(String str, String str2) {
        q.d(c.k(), "innojs_" + str, str2);
    }

    public static String a(String str) {
        return q.b(c.k(), "innojs_" + str, "");
    }
}
