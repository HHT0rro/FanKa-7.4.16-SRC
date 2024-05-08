package com.inno.innosdk.utils.v;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityManager;
import androidx.core.app.NotificationCompat;
import com.alipay.sdk.util.n;
import com.huawei.openalliance.ad.constant.u;
import com.kuaishou.weapon.p0.bi;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.util.List;

/* compiled from: ScriptDetector.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static volatile a f35673a;

    /* renamed from: c, reason: collision with root package name */
    public boolean f35675c;

    /* renamed from: d, reason: collision with root package name */
    public Context f35676d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f35677e;

    /* renamed from: f, reason: collision with root package name */
    public String f35678f;

    /* renamed from: b, reason: collision with root package name */
    public int f35674b = 0;

    /* renamed from: g, reason: collision with root package name */
    public String[] f35679g = {"Alarms", "Android", "DCIM", "Movies", "Music", "Notifications", "Pictures", "Podcasts", "Ringtones", bi.f35840j};

    /* renamed from: h, reason: collision with root package name */
    public String[] f35680h = {"com.google.android", "com.android.settings", "com.android.packageinstaller", "com.android.iconnect", "com.baidu", "com.bjbyhd.screenreader_huawei", "com.huawei", "com.didi.es.psngr", n.f4751b, "com.miui", "com.xiaomi.gamecenter.sdk.service", "com.netease.nie.yosemite", "com.tencent", "com.meizu", "com.sohu.inputmethod.sogou", "com.vivo", "com.oppo", "com.coloros", "com.gionee", "com.gome", "com.sec.android.app.camera", "com.samsung.android", "com.UCMobile", "com.amigo", "com.fooview", "com.singulariti.niapp", "com.honeycomb.launcher", "com.myos.appsstore", "com.hunting.matrix", "com.kugou.android.ringtone", "com.oneapp.max", "com.hmct", "com.android.timeservice", "com.colorphone.smooth.dialer", "com.yufly.mobilemanager", "com.xmiles.callshow", "com.qualcomm.qti.perfdump", "com.aliyun", "cn.nubia", "zte.com.market", "com.snda.lantern.wifilocating", "com.phone.booster", "com.normandy.booster", "com.omarea", "com.noxgroup.app.cleaner", "com.oh.super.cleaner", "com.nirenr.talkman.geek", "com.mycheering", "com.microsoft", "com.cootek", "com.cleanmaster", "cn.kuwo", "com.lenovo", "com.mydream.wifi"};

    public a(Context context) {
        this.f35675c = false;
        this.f35676d = context;
        String[] split = com.inno.innosdk.b.a.v().split(",");
        this.f35677e = split;
        if (split.length <= 0 || !TextUtils.equals(split[0], "tmn")) {
            return;
        }
        this.f35675c = true;
    }

    public static a a(Context context) {
        if (f35673a == null) {
            synchronized (a.class) {
                if (f35673a == null) {
                    f35673a = new a(context);
                }
            }
        }
        return f35673a;
    }

    private String c() {
        StringBuilder sb2 = new StringBuilder();
        AccessibilityManager accessibilityManager = (AccessibilityManager) this.f35676d.getSystemService("accessibility");
        if (accessibilityManager == null) {
            return sb2.toString();
        }
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = accessibilityManager.getEnabledAccessibilityServiceList(16);
        if (enabledAccessibilityServiceList != null && enabledAccessibilityServiceList.size() != 0) {
            for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
                if (!a(accessibilityServiceInfo.getId())) {
                    String[] strArr = accessibilityServiceInfo.packageNames;
                    if (strArr == null) {
                        sb2.append(accessibilityServiceInfo.getId());
                        sb2.append(",");
                    } else {
                        for (String str : strArr) {
                            if (this.f35676d.getPackageName().equals(str)) {
                                sb2.append(accessibilityServiceInfo.getId());
                                sb2.append(",");
                            }
                        }
                    }
                }
            }
            return sb2.toString();
        }
        return sb2.toString();
    }

    private String d() {
        try {
            int i10 = this.f35676d.getPackageManager().getApplicationInfo(this.f35676d.getPackageName(), 128).uid;
            return t.f36224i + (i10 / 100000) + "_a" + (i10 % 10000);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    private int e() {
        try {
            return this.f35676d.getPackageManager().getApplicationInfo(this.f35676d.getPackageName(), 128).uid / 100000;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public String b() {
        if (TextUtils.isEmpty(this.f35678f)) {
            this.f35678f = c();
        }
        return this.f35678f;
    }

    public String f() {
        String str;
        String absolutePath = this.f35676d.getFilesDir().getAbsolutePath();
        String[] split = absolutePath.split("/");
        if (Build.VERSION.SDK_INT <= 22) {
            str = split[3];
        } else {
            str = split[4];
        }
        com.inno.innosdk.utils.u.a.a((Object) ("check div: " + absolutePath + "-----" + str + "  p: " + this.f35676d.getPackageName()));
        if (TextUtils.equals(str, this.f35676d.getPackageName())) {
            str = e() != 0 ? NotificationCompat.CATEGORY_SYSTEM : "";
        }
        return TextUtils.isEmpty(str) ? a() : str;
    }

    public String a() {
        String d10 = d();
        String str = Integer.parseInt(d10.split("a")[1]) < 10 ? "processid " + d10 : "";
        String a10 = com.inno.innosdk.utils.s.a.a(Build.VERSION.SDK_INT >= 26 ? "ps -A | grep " + d10 : "ps | grep " + d10);
        if (TextUtils.isEmpty(a10)) {
            str = str + "ps empty";
        }
        String[] split = a10.split("\n");
        if (split.length <= 3) {
            str = str + "ps count " + split.length;
        }
        for (String str2 : split) {
            int lastIndexOf = str2.lastIndexOf(" ");
            String substring = str2.substring(lastIndexOf <= 0 ? 0 : lastIndexOf + 1);
            if (substring.contains("com.qihoo.magic")) {
                str = "com.qihoo.magic";
            } else if (substring.contains("com.excelliance.dualaid")) {
                str = "com.excelliance.dualaid";
            }
            if (!TextUtils.equals(substring, "sh") && !TextUtils.equals(substring, "ps") && !TextUtils.equals(substring, "grep") && !substring.contains(u.bD) && new File(String.format("/data/data/%s", substring)).exists() && !TextUtils.equals(substring, this.f35676d.getPackageName())) {
                str = substring;
            }
        }
        return str;
    }

    private boolean a(String str) {
        for (String str2 : this.f35680h) {
            if (str.startsWith(str2)) {
                return true;
            }
        }
        return false;
    }
}
