package com.tencent.bugly.idasc.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import com.android.internal.logging.nano.MetricsProto;
import com.hailiang.advlib.core.ADEvent;
import com.tencent.bugly.idasc.BuglyStrategy;
import com.tencent.bugly.idasc.crashreport.common.info.PlugInBean;
import com.tencent.bugly.idasc.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.idasc.proguard.ag;
import com.wangmai.okhttp.db.DBHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class as {

    /* renamed from: a, reason: collision with root package name */
    public static int f39616a;

    /* renamed from: h, reason: collision with root package name */
    private static final Map<Integer, Pair<String, String>> f39617h = new HashMap<Integer, Pair<String, String>>() { // from class: com.tencent.bugly.idasc.proguard.as.1
        {
            put(3, new Pair("203", ADEvent.COMPETE_FILTER));
            put(7, new Pair("208", "108"));
            put(0, new Pair("200", ADEvent.PRICE_FILTER));
            put(1, new Pair("201", ADEvent.PRICE_LOW));
            put(2, new Pair("202", ADEvent.BLACKLIST_FILTER));
            put(4, new Pair("204", ADEvent.TIMEOUT_FILTER));
            put(6, new Pair("206", "106"));
            put(5, new Pair("207", "107"));
        }
    };

    /* renamed from: i, reason: collision with root package name */
    private static final ArrayList<a> f39618i = new ArrayList<a>() { // from class: com.tencent.bugly.idasc.proguard.as.2
        {
            byte b4 = 0;
            add(new b(b4));
            add(new c(b4));
            add(new d(b4));
            add(new e(b4));
            add(new h(b4));
            add(new i(b4));
            add(new f(b4));
            add(new g(b4));
        }
    };

    /* renamed from: j, reason: collision with root package name */
    private static final Map<Integer, Integer> f39619j = new HashMap<Integer, Integer>() { // from class: com.tencent.bugly.idasc.proguard.as.3
        {
            put(3, 4);
            put(7, 7);
            put(2, 1);
            put(0, 0);
            put(1, 2);
            put(4, 3);
            put(5, 5);
            put(6, 6);
        }
    };

    /* renamed from: k, reason: collision with root package name */
    private static final Map<Integer, String> f39620k = new HashMap<Integer, String>() { // from class: com.tencent.bugly.idasc.proguard.as.4
        {
            put(3, "BuglyAnrCrash");
            put(0, "BuglyJavaCrash");
            put(1, "BuglyNativeCrash");
        }
    };

    /* renamed from: l, reason: collision with root package name */
    private static final Map<Integer, String> f39621l = new HashMap<Integer, String>() { // from class: com.tencent.bugly.idasc.proguard.as.5
        {
            put(3, "BuglyAnrCrashReport");
            put(0, "BuglyJavaCrashReport");
            put(1, "BuglyNativeCrashReport");
        }
    };

    /* renamed from: b, reason: collision with root package name */
    public final Context f39622b;

    /* renamed from: c, reason: collision with root package name */
    public final ai f39623c;

    /* renamed from: d, reason: collision with root package name */
    public final w f39624d;

    /* renamed from: e, reason: collision with root package name */
    public final ac f39625e;

    /* renamed from: f, reason: collision with root package name */
    public aw f39626f;

    /* renamed from: g, reason: collision with root package name */
    public BuglyStrategy.a f39627g;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static abstract class a {

        /* renamed from: a, reason: collision with root package name */
        public final int f39632a;

        private a(int i10) {
            this.f39632a = i10;
        }

        public /* synthetic */ a(int i10, byte b4) {
            this(i10);
        }

        public abstract boolean a();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b extends a {
        private b() {
            super(3, (byte) 0);
        }

        public /* synthetic */ b(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return at.a().k();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c extends a {
        private c() {
            super(7, (byte) 0);
        }

        public /* synthetic */ c(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class d extends a {
        private d() {
            super(2, (byte) 0);
        }

        public /* synthetic */ d(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class e extends a {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private e() {
            /*
                r1 = this;
                r0 = 0
                r1.<init>(r0, r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.as.e.<init>():void");
        }

        public /* synthetic */ e(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return at.a().j();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class f extends a {
        private f() {
            super(5, (byte) 0);
        }

        public /* synthetic */ f(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return (at.a().B & 2) > 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class g extends a {
        private g() {
            super(6, (byte) 0);
        }

        public /* synthetic */ g(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return (at.a().B & 1) > 0;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class h extends a {
        private h() {
            super(1, (byte) 0);
        }

        public /* synthetic */ h(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return at.a().j();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class i extends a {
        private i() {
            super(4, (byte) 0);
        }

        public /* synthetic */ i(byte b4) {
            this();
        }

        @Override // com.tencent.bugly.idasc.proguard.as.a
        public final boolean a() {
            return (at.a().B & 4) > 0;
        }
    }

    public as(Context context, ai aiVar, w wVar, ac acVar, BuglyStrategy.a aVar) {
        f39616a = 1004;
        this.f39622b = context;
        this.f39623c = aiVar;
        this.f39624d = wVar;
        this.f39625e = acVar;
        this.f39627g = aVar;
        this.f39626f = null;
    }

    private static CrashDetailBean a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex("_dt"));
            if (blob == null) {
                return null;
            }
            long j10 = cursor.getLong(cursor.getColumnIndex("_id"));
            CrashDetailBean crashDetailBean = (CrashDetailBean) ap.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f39408a = j10;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static CrashDetailBean a(List<ar> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> c4;
        if (list.isEmpty()) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (ar arVar : list) {
            if (arVar.f39614e) {
                arrayList.add(arVar);
            }
        }
        if (!arrayList.isEmpty() && (c4 = c(arrayList)) != null && !c4.isEmpty()) {
            Collections.sort(c4);
            crashDetailBean2 = c4.get(0);
            a(crashDetailBean2, c4);
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f39418j = true;
            crashDetailBean.f39428t = 0;
            crashDetailBean.f39427s = "";
            crashDetailBean2 = crashDetailBean;
        }
        b(crashDetailBean2, list);
        if (crashDetailBean2.f39426r != crashDetailBean.f39426r) {
            String str = crashDetailBean2.f39427s;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.f39426r);
            if (!str.contains(sb2.toString())) {
                crashDetailBean2.f39428t++;
                crashDetailBean2.f39427s += crashDetailBean.f39426r + "\n";
            }
        }
        return crashDetailBean2;
    }

    private static bn a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 == null || context == null) {
            al.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
            return null;
        }
        al.c("zip %s", str2);
        File file = new File(str2);
        File file2 = new File(context.getCacheDir(), str);
        if (!ap.a(file, file2)) {
            al.d("zip fail!", new Object[0]);
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file2);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
                byteArrayOutputStream.flush();
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            al.c("read bytes :%d", Integer.valueOf(byteArray.length));
            bn bnVar = new bn((byte) 2, file2.getName(), byteArray);
            try {
                fileInputStream.close();
            } catch (IOException e2) {
                if (!al.a(e2)) {
                    e2.printStackTrace();
                }
            }
            if (file2.exists()) {
                al.c("del tmp", new Object[0]);
                file2.delete();
            }
            return bnVar;
        } catch (Throwable th2) {
            th = th2;
            try {
                if (!al.a(th)) {
                    th.printStackTrace();
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e10) {
                        if (!al.a(e10)) {
                            e10.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    al.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return null;
            } catch (Throwable th3) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e11) {
                        if (!al.a(e11)) {
                            e11.printStackTrace();
                        }
                    }
                }
                if (file2.exists()) {
                    al.c("del tmp", new Object[0]);
                    file2.delete();
                }
                throw th3;
            }
        }
    }

    private static bo a(Context context, CrashDetailBean crashDetailBean, aa aaVar) {
        ArrayList<bl> arrayList = null;
        if (context == null || crashDetailBean == null || aaVar == null) {
            al.d("enExp args == null", new Object[0]);
            return null;
        }
        bo boVar = new bo();
        boVar.f39776a = e(crashDetailBean);
        boVar.f39777b = crashDetailBean.f39426r;
        boVar.f39778c = crashDetailBean.f39422n;
        boVar.f39779d = crashDetailBean.f39423o;
        boVar.f39780e = crashDetailBean.f39424p;
        boVar.f39782g = crashDetailBean.f39425q;
        boVar.f39783h = crashDetailBean.f39434z;
        boVar.f39784i = crashDetailBean.f39411c;
        boVar.f39785j = null;
        boVar.f39787l = crashDetailBean.f39421m;
        boVar.f39788m = crashDetailBean.f39413e;
        boVar.f39781f = crashDetailBean.B;
        boVar.f39789n = null;
        Map<String, PlugInBean> map = crashDetailBean.f39416h;
        if (map != null && !map.isEmpty()) {
            arrayList = new ArrayList<>(crashDetailBean.f39416h.size());
            for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f39416h.entrySet()) {
                bl blVar = new bl();
                blVar.f39759a = entry.getValue().f39382a;
                blVar.f39761c = entry.getValue().f39384c;
                blVar.f39763e = entry.getValue().f39383b;
                arrayList.add(blVar);
            }
        }
        boVar.f39791p = arrayList;
        al.c("libInfo %s", boVar.f39790o);
        ArrayList<bn> arrayList2 = new ArrayList<>(20);
        a(arrayList2, crashDetailBean);
        a(arrayList2, crashDetailBean.f39431w);
        b(arrayList2, crashDetailBean.f39432x);
        c(arrayList2, crashDetailBean.Z);
        a(arrayList2, crashDetailBean.f39409aa, context);
        a(arrayList2, crashDetailBean.f39433y);
        a(arrayList2, crashDetailBean, context);
        b(arrayList2, crashDetailBean, context);
        a(arrayList2, aaVar.L);
        b(arrayList2, crashDetailBean.Y);
        boVar.f39792q = arrayList2;
        if (crashDetailBean.f39418j) {
            boVar.f39786k = crashDetailBean.f39428t;
        }
        boVar.f39793r = a(crashDetailBean, aaVar);
        boVar.f39794s = new HashMap();
        Map<String, String> map2 = crashDetailBean.S;
        if (map2 != null && map2.size() > 0) {
            boVar.f39794s.putAll(crashDetailBean.S);
            al.a("setted message size %d", Integer.valueOf(boVar.f39794s.size()));
        }
        Map<String, String> map3 = boVar.f39794s;
        al.c("pss:" + crashDetailBean.I + " vss:" + crashDetailBean.J + " javaHeap:" + crashDetailBean.K, new Object[0]);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(crashDetailBean.I);
        map3.put("SDK_UPLOAD_U1", sb2.toString());
        StringBuilder sb3 = new StringBuilder();
        sb3.append(crashDetailBean.J);
        map3.put("SDK_UPLOAD_U2", sb3.toString());
        StringBuilder sb4 = new StringBuilder();
        sb4.append(crashDetailBean.K);
        map3.put("SDK_UPLOAD_U3", sb4.toString());
        Object[] objArr = new Object[12];
        objArr[0] = crashDetailBean.f39422n;
        objArr[1] = crashDetailBean.f39411c;
        objArr[2] = aaVar.d();
        objArr[3] = Long.valueOf((crashDetailBean.f39426r - crashDetailBean.Q) / 1000);
        objArr[4] = Boolean.valueOf(crashDetailBean.f39419k);
        objArr[5] = Boolean.valueOf(crashDetailBean.R);
        objArr[6] = Boolean.valueOf(crashDetailBean.f39418j);
        objArr[7] = Boolean.valueOf(crashDetailBean.f39410b == 1);
        objArr[8] = Integer.valueOf(crashDetailBean.f39428t);
        objArr[9] = crashDetailBean.f39427s;
        objArr[10] = Boolean.valueOf(crashDetailBean.f39412d);
        objArr[11] = Integer.valueOf(boVar.f39793r.size());
        al.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr);
        return boVar;
    }

    private static bp a(Context context, List<CrashDetailBean> list, aa aaVar) {
        if (context == null || list == null || list.size() == 0 || aaVar == null) {
            al.d("enEXPPkg args == null!", new Object[0]);
            return null;
        }
        bp bpVar = new bp();
        bpVar.f39798a = new ArrayList<>();
        Iterator<CrashDetailBean> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            bpVar.f39798a.add(a(context, iterator2.next(), aaVar));
        }
        return bpVar;
    }

    public static List<CrashDetailBean> a() {
        StrategyBean c4 = ac.a().c();
        if (c4 == null) {
            al.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!c4.f39390f) {
            al.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            al.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b4 = ap.b();
        List<ar> b10 = b();
        al.c("Size of crash list loaded from DB: %s", Integer.valueOf(b10.size()));
        if (b10.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.addAll(a(b10));
        b10.removeAll(arrayList);
        Iterator<ar> iterator2 = b10.iterator2();
        while (iterator2.hasNext()) {
            ar next = iterator2.next();
            long j10 = next.f39611b;
            if (j10 < b4 - at.f39641j) {
                arrayList2.add(next);
            } else if (next.f39613d) {
                if (j10 >= currentTimeMillis - 86400000) {
                    iterator2.remove();
                } else if (!next.f39614e) {
                }
            } else if (next.f39615f >= 3 && j10 < currentTimeMillis - 86400000) {
            }
            iterator2.remove();
            arrayList.add(next);
        }
        b(arrayList2);
        if (arrayList.size() > 0) {
            d(arrayList);
        }
        ArrayList arrayList3 = new ArrayList();
        List<CrashDetailBean> c10 = c(b10);
        if (c10 != null && c10.size() > 0) {
            String str = aa.b().f39485o;
            Iterator<CrashDetailBean> iterator22 = c10.iterator2();
            while (iterator22.hasNext()) {
                CrashDetailBean next2 = iterator22.next();
                if (!str.equals(next2.f39414f)) {
                    iterator22.remove();
                    arrayList3.add(next2);
                }
            }
        }
        if (arrayList3.size() > 0) {
            e(arrayList3);
        }
        return c10;
    }

    private static List<ar> a(List<ar> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (ar arVar : list) {
            if (arVar.f39613d && arVar.f39611b <= currentTimeMillis - 86400000) {
                arrayList.add(arVar);
            }
        }
        return arrayList;
    }

    private static Map<String, String> a(CrashDetailBean crashDetailBean, aa aaVar) {
        HashMap hashMap = new HashMap(30);
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.C);
            hashMap.put("A9", sb2.toString());
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.D);
            hashMap.put("A11", sb3.toString());
            StringBuilder sb4 = new StringBuilder();
            sb4.append(crashDetailBean.E);
            hashMap.put("A10", sb4.toString());
            hashMap.put("A23", crashDetailBean.f39414f);
            StringBuilder sb5 = new StringBuilder();
            aaVar.getClass();
            hashMap.put("A7", sb5.toString());
            hashMap.put("A6", aa.n());
            hashMap.put("A5", aaVar.m());
            hashMap.put("A22", aaVar.g());
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.G);
            hashMap.put("A2", sb6.toString());
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.F);
            hashMap.put("A1", sb7.toString());
            hashMap.put("A24", aaVar.f39481k);
            StringBuilder sb8 = new StringBuilder();
            sb8.append(crashDetailBean.H);
            hashMap.put("A17", sb8.toString());
            hashMap.put("A25", aaVar.g());
            hashMap.put("A15", aaVar.q());
            StringBuilder sb9 = new StringBuilder();
            sb9.append((Object) aaVar.r());
            hashMap.put("A13", sb9.toString());
            hashMap.put("A34", crashDetailBean.A);
            if (aaVar.G != null) {
                hashMap.put("productIdentify", aaVar.G);
            }
            hashMap.put("A26", URLEncoder.encode(crashDetailBean.L, "utf-8"));
            boolean z10 = true;
            if (crashDetailBean.f39410b == 1) {
                hashMap.put("A27", crashDetailBean.O);
                hashMap.put("A28", crashDetailBean.N);
                StringBuilder sb10 = new StringBuilder();
                sb10.append(crashDetailBean.f39419k);
                hashMap.put("A29", sb10.toString());
            }
            hashMap.put("A30", crashDetailBean.P);
            StringBuilder sb11 = new StringBuilder();
            sb11.append(crashDetailBean.Q);
            hashMap.put("A18", sb11.toString());
            StringBuilder sb12 = new StringBuilder();
            if (crashDetailBean.R) {
                z10 = false;
            }
            sb12.append(z10);
            hashMap.put("A36", sb12.toString());
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aaVar.f39496z);
            hashMap.put("F02", sb13.toString());
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aaVar.A);
            hashMap.put("F03", sb14.toString());
            hashMap.put("F04", aaVar.d());
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aaVar.B);
            hashMap.put("F05", sb15.toString());
            hashMap.put("F06", aaVar.f39495y);
            hashMap.put("F08", aaVar.E);
            hashMap.put("F09", aaVar.F);
            StringBuilder sb16 = new StringBuilder();
            sb16.append(aaVar.C);
            hashMap.put("F10", sb16.toString());
            a(hashMap, crashDetailBean);
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
        }
        return hashMap;
    }

    private static void a(CrashDetailBean crashDetailBean, List<CrashDetailBean> list) {
        String[] split;
        StringBuilder sb2 = new StringBuilder(128);
        for (int i10 = 1; i10 < list.size(); i10++) {
            String str = list.get(i10).f39427s;
            if (str != null && (split = str.split("\n")) != null) {
                for (String str2 : split) {
                    if (!crashDetailBean.f39427s.contains(str2)) {
                        crashDetailBean.f39428t++;
                        sb2.append(str2);
                        sb2.append("\n");
                    }
                }
            }
        }
        crashDetailBean.f39427s += sb2.toString();
    }

    private static void a(CrashDetailBean crashDetailBean, Map<String, String> map) {
        String value;
        if (map == null || map.isEmpty()) {
            al.d("extra map is empty. CrashBean won't have userDatas.", new Object[0]);
            return;
        }
        crashDetailBean.S = new LinkedHashMap(map.size());
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!ap.b(entry.getKey())) {
                String key = entry.getKey();
                if (key.length() > 100) {
                    key = key.substring(0, 100);
                    al.d("setted key length is over limit %d substring to %s", 100, key);
                }
                if (ap.b(entry.getValue()) || entry.getValue().length() <= 100000) {
                    value = entry.getValue();
                } else {
                    value = entry.getValue().substring(entry.getValue().length() - 100000);
                    al.d("setted %s value length is over limit %d substring", key, 100000);
                }
                crashDetailBean.S.put(key, value);
                al.a("add setted key %s value size:%d", key, Integer.valueOf(value.length()));
            }
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        aa b4 = aa.b();
        if (b4 == null) {
            return;
        }
        al.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        al.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        al.e("# PKG NAME: %s", b4.f39473c);
        al.e("# APP VER: %s", b4.f39485o);
        al.e("# SDK VER: %s", b4.f39478h);
        al.e("# LAUNCH TIME: %s", ap.a(new Date(aa.b().f39465a)));
        al.e("# CRASH TYPE: %s", str);
        al.e("# CRASH TIME: %s", str2);
        al.e("# CRASH PROCESS: %s", str3);
        al.e("# CRASH FOREGROUND: %s", Boolean.valueOf(b4.a()));
        al.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            al.e("# REPORT ID: %s", crashDetailBean.f39411c);
            Object[] objArr = new Object[2];
            objArr[0] = b4.h();
            objArr[1] = b4.r().booleanValue() ? "ROOTED" : "UNROOT";
            al.e("# CRASH DEVICE: %s %s", objArr);
            al.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            al.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!ap.b(crashDetailBean.O)) {
                al.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.O, crashDetailBean.N);
            } else if (crashDetailBean.f39410b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.T == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.T.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                al.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!ap.b(str5)) {
            al.e("# CRASH STACK: ", new Object[0]);
            al.e(str5, new Object[0]);
        }
        al.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean) {
        String str;
        if (crashDetailBean.f39418j && (str = crashDetailBean.f39427s) != null && str.length() > 0) {
            try {
                arrayList.add(new bn((byte) 1, "alltimes.txt", crashDetailBean.f39427s.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        bn a10;
        if (crashDetailBean.f39410b != 3) {
            return;
        }
        al.c("crashBean.anrMessages:%s", crashDetailBean.T);
        try {
            Map<String, String> map = crashDetailBean.T;
            if (map != null && map.containsKey("BUGLY_CR_01")) {
                if (!TextUtils.isEmpty(crashDetailBean.T.get("BUGLY_CR_01"))) {
                    arrayList.add(new bn((byte) 1, "anrMessage.txt", crashDetailBean.T.get("BUGLY_CR_01").getBytes("utf-8")));
                    al.c("attach anr message", new Object[0]);
                }
                crashDetailBean.T.remove("BUGLY_CR_01");
            }
            String str = crashDetailBean.f39430v;
            if (str == null || (a10 = a("trace.zip", context, str)) == null) {
                return;
            }
            al.c("attach traces", new Object[0]);
            arrayList.add(a10);
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
        }
    }

    private static void a(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "log.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, String str, Context context) {
        if (str != null) {
            try {
                bn a10 = a("backupRecord.zip", context, str);
                if (a10 != null) {
                    al.c("attach backup record", new Object[0]);
                    arrayList.add(a10);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void a(ArrayList<bn> arrayList, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        Iterator<String> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next());
        }
        try {
            arrayList.add(new bn((byte) 1, "martianlog.txt", sb2.toString().getBytes("utf-8")));
            al.c("attach pageTracingList", new Object[0]);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 2, "buglylog.zip", bArr);
            al.c("attach user log", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e2) {
            al.a(e2);
        }
    }

    public static /* synthetic */ void a(List list, boolean z10, long j10, String str, String str2) {
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            CrashDetailBean crashDetailBean = (CrashDetailBean) iterator2.next();
            String str3 = f39621l.get(Integer.valueOf(crashDetailBean.f39410b));
            if (!TextUtils.isEmpty(str3)) {
                arrayList.add(new ag.c(crashDetailBean.f39411c, str3, crashDetailBean.f39426r, z10, j10, str, str2));
            }
        }
        ag.a.a().a(arrayList);
    }

    private static void a(Map<String, String> map, CrashDetailBean crashDetailBean) {
        if (crashDetailBean.U >= 0) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(crashDetailBean.U);
            map.put("C01", sb2.toString());
        }
        if (crashDetailBean.V >= 0) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.V);
            map.put("C02", sb3.toString());
        }
        Map<String, String> map2 = crashDetailBean.W;
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry<String, String> entry : crashDetailBean.W.entrySet()) {
                map.put("C03_" + entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map3 = crashDetailBean.X;
        if (map3 == null || map3.size() <= 0) {
            return;
        }
        for (Map.Entry<String, String> entry2 : crashDetailBean.X.entrySet()) {
            map.put("C04_" + entry2.getKey(), entry2.getValue());
        }
    }

    public static void a(boolean z10, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            al.c("up finish update state %b", Boolean.valueOf(z10));
            for (CrashDetailBean crashDetailBean : list) {
                al.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f39411c, Integer.valueOf(crashDetailBean.f39420l), Boolean.valueOf(crashDetailBean.f39412d), Boolean.valueOf(crashDetailBean.f39418j));
                int i10 = crashDetailBean.f39420l + 1;
                crashDetailBean.f39420l = i10;
                crashDetailBean.f39412d = z10;
                al.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f39411c, Integer.valueOf(i10), Boolean.valueOf(crashDetailBean.f39412d), Boolean.valueOf(crashDetailBean.f39418j));
            }
            Iterator<CrashDetailBean> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                at.a().a(iterator2.next());
            }
            al.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z10) {
            return;
        }
        al.b("[crash] upload fail.", new Object[0]);
    }

    private static boolean a(CrashDetailBean crashDetailBean, List<ar> list, List<ar> list2) {
        boolean z10 = false;
        for (ar arVar : list) {
            if (crashDetailBean.f39429u.equals(arVar.f39612c)) {
                if (arVar.f39614e) {
                    z10 = true;
                }
                list2.add(arVar);
            }
        }
        return z10;
    }

    private static boolean a(String str) {
        String str2 = at.f39649r;
        if (str2 != null && !str2.isEmpty()) {
            try {
                al.c("Crash regular filter for crash stack is: %s", at.f39649r);
                if (Pattern.compile(at.f39649r).matcher(str).find()) {
                    al.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                    return true;
                }
            } catch (Exception e2) {
                al.a(e2);
                al.d("Failed to compile " + at.f39649r, new Object[0]);
            }
        }
        return false;
    }

    private static ar b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            ar arVar = new ar();
            arVar.f39610a = cursor.getLong(cursor.getColumnIndex("_id"));
            arVar.f39611b = cursor.getLong(cursor.getColumnIndex("_tm"));
            arVar.f39612c = cursor.getString(cursor.getColumnIndex("_s1"));
            arVar.f39613d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            arVar.f39614e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            arVar.f39615f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return arVar;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static List<ar> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a10 = w.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, (String) null);
            if (a10 == null) {
                if (a10 != null) {
                    a10.close();
                }
                return null;
            }
            try {
                if (a10.getCount() <= 0) {
                    a10.close();
                    return arrayList;
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id in (");
                int i10 = 0;
                while (a10.moveToNext()) {
                    ar b4 = b(a10);
                    if (b4 != null) {
                        arrayList.add(b4);
                    } else {
                        try {
                            sb2.append(a10.getLong(a10.getColumnIndex("_id")));
                            sb2.append(",");
                            i10++;
                        } catch (Throwable unused) {
                            al.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                String sb3 = sb2.toString();
                sb2.setLength(0);
                if (i10 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
                }
                a10.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a10;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    return arrayList;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static void b(CrashDetailBean crashDetailBean, List<ar> list) {
        StringBuilder sb2 = new StringBuilder(64);
        for (ar arVar : list) {
            if (!arVar.f39614e && !arVar.f39613d) {
                String str = crashDetailBean.f39427s;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(arVar.f39611b);
                if (!str.contains(sb3.toString())) {
                    crashDetailBean.f39428t++;
                    sb2.append(arVar.f39611b);
                    sb2.append("\n");
                }
            }
        }
        crashDetailBean.f39427s += sb2.toString();
    }

    private static void b(ArrayList<bn> arrayList, CrashDetailBean crashDetailBean, Context context) {
        String str;
        if (crashDetailBean.f39410b == 1 && (str = crashDetailBean.f39430v) != null) {
            try {
                bn a10 = a("tomb.zip", context, str);
                if (a10 != null) {
                    al.c("attach tombs", new Object[0]);
                    arrayList.add(a10);
                }
            } catch (Exception e2) {
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, String str) {
        if (str != null) {
            try {
                arrayList.add(new bn((byte) 1, "jniLog.txt", str.getBytes("utf-8")));
            } catch (Exception e2) {
                e2.printStackTrace();
                al.a(e2);
            }
        }
    }

    private static void b(ArrayList<bn> arrayList, byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        try {
            arrayList.add(new bn((byte) 1, "userExtraByteData", bArr));
            al.c("attach extraData", new Object[0]);
        } catch (Exception e2) {
            al.a(e2);
        }
    }

    private static void b(List<ar> list) {
        List<CrashDetailBean> c4 = c(list);
        if (c4 == null || c4.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (CrashDetailBean crashDetailBean : c4) {
            String str = f39621l.get(Integer.valueOf(crashDetailBean.f39410b));
            if (!TextUtils.isEmpty(str)) {
                al.c("find expired data,crashId:%s eventType:%s", crashDetailBean.f39411c, str);
                arrayList.add(new ag.c(crashDetailBean.f39411c, str, crashDetailBean.f39426r, false, 0L, com.alibaba.security.realidentity.build.aq.P, null));
            }
        }
        ag.a.a().a(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0036, code lost:
    
        if (r0.size() >= com.tencent.bugly.idasc.proguard.at.f39635d) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean r9, java.util.List<com.tencent.bugly.idasc.proguard.ar> r10, java.util.List<com.tencent.bugly.idasc.proguard.ar> r11) {
        /*
            r8 = this;
            int r0 = r9.f39410b
            r1 = 1
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r3 = 0
            goto Lc
        Lb:
            r3 = 1
        Lc:
            r4 = 3
            if (r0 != r4) goto L11
            r0 = 1
            goto L12
        L11:
            r0 = 0
        L12:
            boolean r4 = com.tencent.bugly.idasc.proguard.p.f39908c
            if (r4 != 0) goto L1f
            if (r0 != 0) goto L1c
            if (r3 != 0) goto L1c
            r0 = 1
            goto L20
        L1c:
            boolean r0 = com.tencent.bugly.idasc.proguard.at.f39636e
            goto L20
        L1f:
            r0 = 0
        L20:
            if (r0 != 0) goto L23
            return r2
        L23:
            java.util.ArrayList r0 = new java.util.ArrayList
            r3 = 10
            r0.<init>(r3)
            boolean r10 = a(r9, r10, r0)
            if (r10 != 0) goto L38
            int r10 = r0.size()     // Catch: java.lang.Exception -> L6d
            int r3 = com.tencent.bugly.idasc.proguard.at.f39635d     // Catch: java.lang.Exception -> L6d
            if (r10 < r3) goto L78
        L38:
            java.lang.String r10 = "same crash occur too much do merged!"
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.idasc.proguard.al.a(r10, r3)     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean r9 = a(r0, r9)     // Catch: java.lang.Exception -> L6d
            java.util.Iterator r10 = r0.iterator2()     // Catch: java.lang.Exception -> L6d
        L47:
            boolean r0 = r10.hasNext()     // Catch: java.lang.Exception -> L6d
            if (r0 == 0) goto L5f
            java.lang.Object r0 = r10.next()     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.idasc.proguard.ar r0 = (com.tencent.bugly.idasc.proguard.ar) r0     // Catch: java.lang.Exception -> L6d
            long r3 = r0.f39610a     // Catch: java.lang.Exception -> L6d
            long r5 = r9.f39408a     // Catch: java.lang.Exception -> L6d
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L47
            r11.add(r0)     // Catch: java.lang.Exception -> L6d
            goto L47
        L5f:
            r8.b(r9)     // Catch: java.lang.Exception -> L6d
            d(r11)     // Catch: java.lang.Exception -> L6d
            java.lang.String r9 = "[crash] save crash success. For this device crash many times, it will not upload crashes immediately"
            java.lang.Object[] r10 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L6d
            com.tencent.bugly.idasc.proguard.al.b(r9, r10)     // Catch: java.lang.Exception -> L6d
            return r1
        L6d:
            r9 = move-exception
            com.tencent.bugly.idasc.proguard.al.a(r9)
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r10 = "Failed to merge crash."
            com.tencent.bugly.idasc.proguard.al.d(r10, r9)
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.as.b(com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean, java.util.List, java.util.List):boolean");
    }

    private static ContentValues c(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = crashDetailBean.f39408a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f39426r));
            contentValues.put("_s1", crashDetailBean.f39429u);
            int i10 = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f39412d ? 1 : 0));
            if (!crashDetailBean.f39418j) {
                i10 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i10));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f39420l));
            contentValues.put("_dt", ap.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static List<CrashDetailBean> c(List<ar> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in (");
        Iterator<ar> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().f39610a);
            sb2.append(",");
        }
        if (sb2.toString().contains(",")) {
            sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        }
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            cursor = w.a().a("t_cr", (String[]) null, sb3);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb2.append("_id in (");
                int i10 = 0;
                while (cursor.moveToNext()) {
                    CrashDetailBean a10 = a(cursor);
                    if (a10 != null) {
                        arrayList.add(a10);
                    } else {
                        try {
                            sb2.append(cursor.getLong(cursor.getColumnIndex("_id")));
                            sb2.append(",");
                            i10++;
                        } catch (Throwable unused) {
                            al.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                String sb4 = sb2.toString();
                if (i10 > 0) {
                    al.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb4)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!al.a(th)) {
                        th.printStackTrace();
                    }
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } finally {
                    if (cursor != null) {
                        cursor.close();
                    }
                }
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = null;
        }
    }

    private static void c(ArrayList<bn> arrayList, String str) {
        if (ap.b(str)) {
            return;
        }
        try {
            bn bnVar = new bn((byte) 1, "crashInfos.txt", str.getBytes("utf-8"));
            al.c("attach crash infos", new Object[0]);
            arrayList.add(bnVar);
        } catch (Exception e2) {
            e2.printStackTrace();
            al.a(e2);
        }
    }

    private static void d(List<ar> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in (");
        Iterator<ar> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().f39610a);
            sb2.append(",");
        }
        StringBuilder sb3 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        sb3.append(")");
        String sb4 = sb3.toString();
        sb3.setLength(0);
        try {
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb4)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private boolean d(CrashDetailBean crashDetailBean) {
        try {
            al.c("save eup logs", new Object[0]);
            aa b4 = aa.b();
            String str = "#--------\npackage:" + b4.e() + "\nversion:" + b4.f39485o + "\nsdk:" + b4.f39478h + "\nprocess:" + crashDetailBean.A + "\ndate:" + ap.a(new Date(crashDetailBean.f39426r)) + "\ntype:" + crashDetailBean.f39422n + "\nmessage:" + crashDetailBean.f39423o + "\nstack:\n" + crashDetailBean.f39425q + "\neupID:" + crashDetailBean.f39411c + "\n";
            String str2 = null;
            if (at.f39644m != null) {
                File file = new File(at.f39644m);
                if (file.isFile()) {
                    file = file.getParentFile();
                }
                str2 = file.getAbsolutePath();
            } else if (Environment.getExternalStorageState().equals("mounted")) {
                str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Tencent/" + this.f39622b.getPackageName();
            }
            am.a(str2 + "/euplog.txt", str, at.f39645n);
            return true;
        } catch (Throwable th) {
            al.d("rqdp{  save error} %s", th.toString());
            if (!al.a(th)) {
                th.printStackTrace();
            }
            return false;
        }
    }

    private static String e(CrashDetailBean crashDetailBean) {
        try {
            Pair<String, String> pair = f39617h.get(Integer.valueOf(crashDetailBean.f39410b));
            if (pair != null) {
                return crashDetailBean.f39418j ? (String) pair.first : (String) pair.second;
            }
            al.e("crash type error! %d", Integer.valueOf(crashDetailBean.f39410b));
            return "";
        } catch (Exception e2) {
            al.a(e2);
            return "";
        }
    }

    private static void e(List<CrashDetailBean> list) {
        try {
            if (list.size() == 0) {
                return;
            }
            StringBuilder sb2 = new StringBuilder();
            for (CrashDetailBean crashDetailBean : list) {
                sb2.append(" or _id = ");
                sb2.append(crashDetailBean.f39408a);
            }
            String sb3 = sb2.toString();
            if (sb3.length() > 0) {
                sb3 = sb3.substring(4);
            }
            sb2.setLength(0);
            al.c("deleted %s data %d", "t_cr", Integer.valueOf(w.a().a("t_cr", sb3)));
        } catch (Throwable th) {
            if (al.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public final void a(CrashDetailBean crashDetailBean) {
        int i10 = crashDetailBean.f39410b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 3 && !at.a().k()) {
                    return;
                }
            } else if (!at.a().j()) {
                return;
            }
        } else if (!at.a().j()) {
            return;
        }
        if (this.f39626f != null) {
            al.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    public final void a(final List<CrashDetailBean> list, long j10, final boolean z10, boolean z11, boolean z12) {
        if (!aa.a(this.f39622b).f39476f) {
            al.d("warn: not upload process", new Object[0]);
            return;
        }
        ai aiVar = this.f39623c;
        if (aiVar == null) {
            al.d("warn: upload manager is null", new Object[0]);
            return;
        }
        if (!z12 && !aiVar.b(at.f39633a)) {
            al.d("warn: not crashHappen or not should upload", new Object[0]);
            return;
        }
        StrategyBean c4 = this.f39625e.c();
        if (!c4.f39390f) {
            al.d("remote report is disable!", new Object[0]);
            al.b("[crash] server closed bugly in this app. please check your appid if is correct, and re-install it", new Object[0]);
            return;
        }
        if (list == null || list.size() == 0) {
            al.d("warn: crashList is null or crashList num is 0", new Object[0]);
            return;
        }
        try {
            String str = c4.f39402r;
            String str2 = StrategyBean.f39386b;
            bp a10 = a(this.f39622b, list, aa.b());
            if (a10 == null) {
                al.d("create eupPkg fail!", new Object[0]);
                return;
            }
            byte[] a11 = ae.a((m) a10);
            if (a11 == null) {
                al.d("send encode fail!", new Object[0]);
                return;
            }
            bq a12 = ae.a(this.f39622b, MetricsProto.MetricsEvent.ACTION_SETTINGS_TILE_CLICK, a11);
            if (a12 == null) {
                al.d("request package is null.", new Object[0]);
                return;
            }
            final long currentTimeMillis = System.currentTimeMillis();
            ah ahVar = new ah() { // from class: com.tencent.bugly.idasc.proguard.as.6
                @Override // com.tencent.bugly.idasc.proguard.ah
                public final void a(boolean z13, String str3) {
                    as.a(list, z13, System.currentTimeMillis() - currentTimeMillis, z10 ? "realtime" : DBHelper.TABLE_CACHE, str3);
                    as.a(z13, (List<CrashDetailBean>) list);
                }
            };
            if (z10) {
                this.f39623c.a(f39616a, a12, str, str2, ahVar, j10, z11);
            } else {
                this.f39623c.a(f39616a, a12, str, str2, ahVar, false);
            }
        } catch (Throwable th) {
            al.e("req cr error %s", th.toString());
            if (al.b(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x024a A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean a(com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 646
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.idasc.proguard.as.a(com.tencent.bugly.idasc.crashreport.crash.CrashDetailBean, boolean):boolean");
    }

    public final void b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return;
        }
        ContentValues c4 = c(crashDetailBean);
        if (c4 != null) {
            long a10 = w.a().a("t_cr", c4, (v) null);
            if (a10 >= 0) {
                al.c("insert %s success!", "t_cr");
                crashDetailBean.f39408a = a10;
            }
        }
        if (at.f39643l) {
            d(crashDetailBean);
        }
    }

    public final void b(CrashDetailBean crashDetailBean, boolean z10) {
        if (!at.f39646o) {
            al.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
            return;
        }
        al.a("try to upload right now", new Object[0]);
        ArrayList arrayList = new ArrayList();
        arrayList.add(crashDetailBean);
        a(arrayList, com.huawei.openalliance.ad.ipc.c.Code, z10, crashDetailBean.f39410b == 7, z10);
    }
}
