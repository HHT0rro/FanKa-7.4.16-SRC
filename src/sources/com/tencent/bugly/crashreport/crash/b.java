package com.tencent.bugly.crashreport.crash;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import com.hailiang.advlib.core.ADEvent;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;
import com.tencent.bugly.proguard.ah;
import com.tencent.bugly.proguard.aj;
import com.tencent.bugly.proguard.ak;
import com.tencent.bugly.proguard.o;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static int f39228a;

    /* renamed from: b, reason: collision with root package name */
    private Context f39229b;

    /* renamed from: c, reason: collision with root package name */
    private u f39230c;

    /* renamed from: d, reason: collision with root package name */
    private p f39231d;

    /* renamed from: e, reason: collision with root package name */
    private com.tencent.bugly.crashreport.common.strategy.a f39232e;

    /* renamed from: f, reason: collision with root package name */
    private o f39233f;

    /* renamed from: g, reason: collision with root package name */
    private BuglyStrategy.a f39234g;

    public b(int i10, Context context, u uVar, p pVar, com.tencent.bugly.crashreport.common.strategy.a aVar, BuglyStrategy.a aVar2, o oVar) {
        f39228a = i10;
        this.f39229b = context;
        this.f39230c = uVar;
        this.f39231d = pVar;
        this.f39232e = aVar;
        this.f39234g = aVar2;
        this.f39233f = oVar;
    }

    private static List<a> a(List<a> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        for (a aVar : list) {
            if (aVar.f39189d && aVar.f39187b <= currentTimeMillis - 86400000) {
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private static ContentValues f(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return null;
        }
        try {
            ContentValues contentValues = new ContentValues();
            long j10 = crashDetailBean.f39160a;
            if (j10 > 0) {
                contentValues.put("_id", Long.valueOf(j10));
            }
            contentValues.put("_tm", Long.valueOf(crashDetailBean.f39177r));
            contentValues.put("_s1", crashDetailBean.f39180u);
            int i10 = 1;
            contentValues.put("_up", Integer.valueOf(crashDetailBean.f39163d ? 1 : 0));
            if (!crashDetailBean.f39169j) {
                i10 = 0;
            }
            contentValues.put("_me", Integer.valueOf(i10));
            contentValues.put("_uc", Integer.valueOf(crashDetailBean.f39171l));
            contentValues.put("_dt", z.a(crashDetailBean));
            return contentValues;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final boolean b(CrashDetailBean crashDetailBean) {
        if (crashDetailBean == null) {
            return true;
        }
        String str = c.f39250n;
        if (str != null && !str.isEmpty()) {
            x.c("Crash filter for crash stack is: %s", c.f39250n);
            if (crashDetailBean.f39176q.contains(c.f39250n)) {
                x.d("This crash contains the filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        String str2 = c.f39251o;
        if (str2 != null && !str2.isEmpty()) {
            x.c("Crash regular filter for crash stack is: %s", c.f39251o);
            if (Pattern.compile(c.f39251o).matcher(crashDetailBean.f39176q).find()) {
                x.d("This crash matches the regular filter string set. It will not be record and upload.", new Object[0]);
                return true;
            }
        }
        if (crashDetailBean.f39161b != 2) {
            r rVar = new r();
            rVar.f40190b = 1;
            rVar.f40191c = crashDetailBean.A;
            rVar.f40192d = crashDetailBean.B;
            rVar.f40193e = crashDetailBean.f39177r;
            this.f39231d.b(1);
            this.f39231d.a(rVar);
            x.b("[crash] a crash occur, handling...", new Object[0]);
        } else {
            x.b("[crash] a caught exception occur, handling...", new Object[0]);
        }
        List<a> b4 = b();
        ArrayList arrayList = null;
        if (b4 != null && b4.size() > 0) {
            arrayList = new ArrayList(10);
            ArrayList arrayList2 = new ArrayList(10);
            arrayList.addAll(a(b4));
            b4.removeAll(arrayList);
            if (b4.size() > 20) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("_id in ");
                sb2.append("(");
                sb2.append("SELECT _id");
                sb2.append(" FROM t_cr");
                sb2.append(" order by _id");
                sb2.append(" limit 5");
                sb2.append(")");
                String sb3 = sb2.toString();
                sb2.setLength(0);
                try {
                    x.c("deleted first record %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb3, (String[]) null, (o) null, true)));
                } catch (Throwable th) {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                }
            }
            int i10 = crashDetailBean.f39161b;
            if (!com.tencent.bugly.b.f39031c && (!((i10 == 3) || (i10 == 0 || i10 == 1)) || c.f39240d)) {
                boolean z10 = false;
                for (a aVar : b4) {
                    if (crashDetailBean.f39180u.equals(aVar.f39188c)) {
                        if (aVar.f39190e) {
                            z10 = true;
                        }
                        arrayList2.add(aVar);
                    }
                }
                if (z10 || arrayList2.size() >= c.f39239c) {
                    x.a("same crash occur too much do merged!", new Object[0]);
                    CrashDetailBean a10 = a(arrayList2, crashDetailBean);
                    for (a aVar2 : arrayList2) {
                        if (aVar2.f39186a != a10.f39160a) {
                            arrayList.add(aVar2);
                        }
                    }
                    e(a10);
                    c(arrayList);
                    x.b("[crash] save crash success. For this device crash many times, it will not upload crashes immediately", new Object[0]);
                    return true;
                }
            }
        }
        e(crashDetailBean);
        if (arrayList != null && !arrayList.isEmpty()) {
            c(arrayList);
        }
        x.b("[crash] save crash success", new Object[0]);
        return false;
    }

    public final void c(CrashDetailBean crashDetailBean) {
        int i10 = crashDetailBean.f39161b;
        if (i10 != 0) {
            if (i10 != 1) {
                if (i10 == 3 && !c.a().r()) {
                    return;
                }
            } else if (!c.a().q()) {
                return;
            }
        } else if (!c.a().q()) {
            return;
        }
        if (this.f39233f != null) {
            x.c("Calling 'onCrashHandleEnd' of RQD crash listener.", new Object[0]);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00a6 A[Catch: all -> 0x01db, TryCatch #0 {all -> 0x01db, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0067, B:19:0x007d, B:22:0x00a6, B:24:0x00ac, B:25:0x00bf, B:27:0x00c5, B:30:0x00d7, B:32:0x00e5, B:33:0x00f8, B:35:0x0104, B:37:0x0110, B:38:0x0147, B:41:0x0135, B:44:0x0161, B:46:0x016c, B:47:0x0191, B:49:0x0195, B:51:0x0198, B:52:0x01b2, B:53:0x01c0, B:55:0x01c4, B:57:0x01d3, B:62:0x017a, B:64:0x017e, B:66:0x0088, B:68:0x008c, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00c5 A[Catch: all -> 0x01db, TryCatch #0 {all -> 0x01db, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0067, B:19:0x007d, B:22:0x00a6, B:24:0x00ac, B:25:0x00bf, B:27:0x00c5, B:30:0x00d7, B:32:0x00e5, B:33:0x00f8, B:35:0x0104, B:37:0x0110, B:38:0x0147, B:41:0x0135, B:44:0x0161, B:46:0x016c, B:47:0x0191, B:49:0x0195, B:51:0x0198, B:52:0x01b2, B:53:0x01c0, B:55:0x01c4, B:57:0x01d3, B:62:0x017a, B:64:0x017e, B:66:0x0088, B:68:0x008c, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x016c A[Catch: all -> 0x01db, TryCatch #0 {all -> 0x01db, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0067, B:19:0x007d, B:22:0x00a6, B:24:0x00ac, B:25:0x00bf, B:27:0x00c5, B:30:0x00d7, B:32:0x00e5, B:33:0x00f8, B:35:0x0104, B:37:0x0110, B:38:0x0147, B:41:0x0135, B:44:0x0161, B:46:0x016c, B:47:0x0191, B:49:0x0195, B:51:0x0198, B:52:0x01b2, B:53:0x01c0, B:55:0x01c4, B:57:0x01d3, B:62:0x017a, B:64:0x017e, B:66:0x0088, B:68:0x008c, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0195 A[Catch: all -> 0x01db, TryCatch #0 {all -> 0x01db, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0067, B:19:0x007d, B:22:0x00a6, B:24:0x00ac, B:25:0x00bf, B:27:0x00c5, B:30:0x00d7, B:32:0x00e5, B:33:0x00f8, B:35:0x0104, B:37:0x0110, B:38:0x0147, B:41:0x0135, B:44:0x0161, B:46:0x016c, B:47:0x0191, B:49:0x0195, B:51:0x0198, B:52:0x01b2, B:53:0x01c0, B:55:0x01c4, B:57:0x01d3, B:62:0x017a, B:64:0x017e, B:66:0x0088, B:68:0x008c, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01c4 A[Catch: all -> 0x01db, TryCatch #0 {all -> 0x01db, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0067, B:19:0x007d, B:22:0x00a6, B:24:0x00ac, B:25:0x00bf, B:27:0x00c5, B:30:0x00d7, B:32:0x00e5, B:33:0x00f8, B:35:0x0104, B:37:0x0110, B:38:0x0147, B:41:0x0135, B:44:0x0161, B:46:0x016c, B:47:0x0191, B:49:0x0195, B:51:0x0198, B:52:0x01b2, B:53:0x01c0, B:55:0x01c4, B:57:0x01d3, B:62:0x017a, B:64:0x017e, B:66:0x0088, B:68:0x008c, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:61:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017a A[Catch: all -> 0x01db, TryCatch #0 {all -> 0x01db, blocks: (B:11:0x000e, B:12:0x0011, B:15:0x0062, B:17:0x0067, B:19:0x007d, B:22:0x00a6, B:24:0x00ac, B:25:0x00bf, B:27:0x00c5, B:30:0x00d7, B:32:0x00e5, B:33:0x00f8, B:35:0x0104, B:37:0x0110, B:38:0x0147, B:41:0x0135, B:44:0x0161, B:46:0x016c, B:47:0x0191, B:49:0x0195, B:51:0x0198, B:52:0x01b2, B:53:0x01c0, B:55:0x01c4, B:57:0x01d3, B:62:0x017a, B:64:0x017e, B:66:0x0088, B:68:0x008c, B:69:0x0017, B:72:0x0023, B:75:0x002f, B:78:0x003b, B:82:0x0049, B:86:0x0056), top: B:10:0x000e }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d(com.tencent.bugly.crashreport.crash.CrashDetailBean r13) {
        /*
            Method dump skipped, instructions count: 524
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.d(com.tencent.bugly.crashreport.crash.CrashDetailBean):void");
    }

    public final void e(CrashDetailBean crashDetailBean) {
        ContentValues f10;
        if (crashDetailBean == null || (f10 = f(crashDetailBean)) == null) {
            return;
        }
        long a10 = p.a().a("t_cr", f10, (o) null, true);
        if (a10 >= 0) {
            x.c("insert %s success!", "t_cr");
            crashDetailBean.f39160a = a10;
        }
    }

    private static void c(List<a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in ");
        sb2.append("(");
        Iterator<a> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().f39186a);
            sb2.append(",");
        }
        StringBuilder sb3 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        sb3.append(")");
        String sb4 = sb3.toString();
        sb3.setLength(0);
        try {
            x.c("deleted %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb4, (String[]) null, (o) null, true)));
        } catch (Throwable th) {
            if (x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private CrashDetailBean a(List<a> list, CrashDetailBean crashDetailBean) {
        List<CrashDetailBean> b4;
        String[] split;
        if (list == null || list.size() == 0) {
            return crashDetailBean;
        }
        CrashDetailBean crashDetailBean2 = null;
        ArrayList arrayList = new ArrayList(10);
        for (a aVar : list) {
            if (aVar.f39190e) {
                arrayList.add(aVar);
            }
        }
        if (arrayList.size() > 0 && (b4 = b(arrayList)) != null && b4.size() > 0) {
            Collections.sort(b4);
            for (int i10 = 0; i10 < b4.size(); i10++) {
                CrashDetailBean crashDetailBean3 = b4.get(i10);
                if (i10 == 0) {
                    crashDetailBean2 = crashDetailBean3;
                } else {
                    String str = crashDetailBean3.f39178s;
                    if (str != null && (split = str.split("\n")) != null) {
                        for (String str2 : split) {
                            if (!crashDetailBean2.f39178s.contains(str2)) {
                                crashDetailBean2.f39179t++;
                                crashDetailBean2.f39178s += str2 + "\n";
                            }
                        }
                    }
                }
            }
        }
        if (crashDetailBean2 == null) {
            crashDetailBean.f39169j = true;
            crashDetailBean.f39179t = 0;
            crashDetailBean.f39178s = "";
            crashDetailBean2 = crashDetailBean;
        }
        for (a aVar2 : list) {
            if (!aVar2.f39190e && !aVar2.f39189d) {
                String str3 = crashDetailBean2.f39178s;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(aVar2.f39187b);
                if (!str3.contains(sb2.toString())) {
                    crashDetailBean2.f39179t++;
                    crashDetailBean2.f39178s += aVar2.f39187b + "\n";
                }
            }
        }
        if (crashDetailBean2.f39177r != crashDetailBean.f39177r) {
            String str4 = crashDetailBean2.f39178s;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.f39177r);
            if (!str4.contains(sb3.toString())) {
                crashDetailBean2.f39179t++;
                crashDetailBean2.f39178s += crashDetailBean.f39177r + "\n";
            }
        }
        return crashDetailBean2;
    }

    public final boolean a(CrashDetailBean crashDetailBean) {
        return b(crashDetailBean);
    }

    public final List<CrashDetailBean> a() {
        StrategyBean c4 = com.tencent.bugly.crashreport.common.strategy.a.a().c();
        if (c4 == null) {
            x.d("have not synced remote!", new Object[0]);
            return null;
        }
        if (!c4.f39126e) {
            x.d("Crashreport remote closed, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            x.b("[init] WARNING! Crashreport closed by server, please check your APP ID correct and Version available, then uninstall and reinstall your app.", new Object[0]);
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long b4 = z.b();
        List<a> b10 = b();
        x.c("Size of crash list loaded from DB: %s", Integer.valueOf(b10.size()));
        if (b10.size() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(a(b10));
        b10.removeAll(arrayList);
        Iterator<a> iterator2 = b10.iterator2();
        while (iterator2.hasNext()) {
            a next = iterator2.next();
            long j10 = next.f39187b;
            if (j10 < b4 - c.f39243g) {
                iterator2.remove();
                arrayList.add(next);
            } else if (next.f39189d) {
                if (j10 >= currentTimeMillis - 86400000) {
                    iterator2.remove();
                } else if (!next.f39190e) {
                    iterator2.remove();
                    arrayList.add(next);
                }
            } else if (next.f39191f >= 3 && j10 < currentTimeMillis - 86400000) {
                iterator2.remove();
                arrayList.add(next);
            }
        }
        if (arrayList.size() > 0) {
            c(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        List<CrashDetailBean> b11 = b(b10);
        if (b11 != null && b11.size() > 0) {
            String str = com.tencent.bugly.crashreport.common.info.a.b().f39102j;
            Iterator<CrashDetailBean> iterator22 = b11.iterator2();
            while (iterator22.hasNext()) {
                CrashDetailBean next2 = iterator22.next();
                if (!str.equals(next2.f39165f)) {
                    iterator22.remove();
                    arrayList2.add(next2);
                }
            }
        }
        if (arrayList2.size() > 0) {
            d(arrayList2);
        }
        return b11;
    }

    private List<CrashDetailBean> b(List<a> list) {
        Cursor cursor;
        if (list == null || list.size() == 0) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("_id in ");
        sb2.append("(");
        Iterator<a> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append(iterator2.next().f39186a);
            sb2.append(",");
        }
        if (sb2.toString().contains(",")) {
            sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
        }
        sb2.append(")");
        String sb3 = sb2.toString();
        sb2.setLength(0);
        try {
            cursor = p.a().a("t_cr", null, sb3, null, null, true);
            if (cursor == null) {
                return null;
            }
            try {
                ArrayList arrayList = new ArrayList();
                sb2.append("_id in ");
                sb2.append("(");
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
                            x.d("unknown id!", new Object[0]);
                        }
                    }
                }
                if (sb2.toString().contains(",")) {
                    sb2 = new StringBuilder(sb2.substring(0, sb2.lastIndexOf(",")));
                }
                sb2.append(")");
                String sb4 = sb2.toString();
                if (i10 > 0) {
                    x.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb4, (String[]) null, (o) null, true)));
                }
                cursor.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                try {
                    if (!x.a(th)) {
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

    private static void d(List<CrashDetailBean> list) {
        if (list != null) {
            try {
                if (list.size() == 0) {
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                for (CrashDetailBean crashDetailBean : list) {
                    sb2.append(" or _id");
                    sb2.append(" = ");
                    sb2.append(crashDetailBean.f39160a);
                }
                String sb3 = sb2.toString();
                if (sb3.length() > 0) {
                    sb3 = sb3.substring(4);
                }
                sb2.setLength(0);
                x.c("deleted %s data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb3, (String[]) null, (o) null, true)));
            } catch (Throwable th) {
                if (x.a(th)) {
                    return;
                }
                th.printStackTrace();
            }
        }
    }

    private static a b(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        try {
            a aVar = new a();
            aVar.f39186a = cursor.getLong(cursor.getColumnIndex("_id"));
            aVar.f39187b = cursor.getLong(cursor.getColumnIndex("_tm"));
            aVar.f39188c = cursor.getString(cursor.getColumnIndex("_s1"));
            aVar.f39189d = cursor.getInt(cursor.getColumnIndex("_up")) == 1;
            aVar.f39190e = cursor.getInt(cursor.getColumnIndex("_me")) == 1;
            aVar.f39191f = cursor.getInt(cursor.getColumnIndex("_uc"));
            return aVar;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    public final void a(CrashDetailBean crashDetailBean, long j10, boolean z10) {
        if (c.f39248l) {
            x.a("try to upload right now", new Object[0]);
            ArrayList arrayList = new ArrayList();
            arrayList.add(crashDetailBean);
            a(arrayList, com.huawei.openalliance.ad.ipc.c.Code, z10, crashDetailBean.f39161b == 7, z10);
            return;
        }
        x.a("do not upload spot crash right now, crash would be uploaded when app next start", new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x009b A[Catch: all -> 0x00df, TryCatch #0 {all -> 0x00df, blocks: (B:23:0x0056, B:25:0x0062, B:29:0x006b, B:30:0x007b, B:32:0x0081, B:35:0x009b, B:37:0x00a3, B:39:0x00a9, B:41:0x00b1, B:43:0x00bb, B:45:0x00c3, B:47:0x00ca, B:49:0x00d6, B:51:0x0091), top: B:22:0x0056 }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00a3 A[Catch: all -> 0x00df, TryCatch #0 {all -> 0x00df, blocks: (B:23:0x0056, B:25:0x0062, B:29:0x006b, B:30:0x007b, B:32:0x0081, B:35:0x009b, B:37:0x00a3, B:39:0x00a9, B:41:0x00b1, B:43:0x00bb, B:45:0x00c3, B:47:0x00ca, B:49:0x00d6, B:51:0x0091), top: B:22:0x0056 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(final java.util.List<com.tencent.bugly.crashreport.crash.CrashDetailBean> r15, long r16, boolean r18, boolean r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.crashreport.crash.b.a(java.util.List, long, boolean, boolean, boolean):void");
    }

    private List<a> b() {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor a10 = p.a().a("t_cr", new String[]{"_id", "_tm", "_s1", "_up", "_me", "_uc"}, null, null, null, true);
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
                sb2.append("_id in ");
                sb2.append("(");
                int i10 = 0;
                while (a10.moveToNext()) {
                    a b4 = b(a10);
                    if (b4 != null) {
                        arrayList.add(b4);
                    } else {
                        try {
                            sb2.append(a10.getLong(a10.getColumnIndex("_id")));
                            sb2.append(",");
                            i10++;
                        } catch (Throwable unused) {
                            x.d("unknown id!", new Object[0]);
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
                    x.d("deleted %s illegal data %d", "t_cr", Integer.valueOf(p.a().a("t_cr", sb3, (String[]) null, (o) null, true)));
                }
                a10.close();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                cursor = a10;
                try {
                    if (!x.a(th)) {
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

    public static void a(boolean z10, List<CrashDetailBean> list) {
        if (list != null && list.size() > 0) {
            x.c("up finish update state %b", Boolean.valueOf(z10));
            for (CrashDetailBean crashDetailBean : list) {
                x.c("pre uid:%s uc:%d re:%b me:%b", crashDetailBean.f39162c, Integer.valueOf(crashDetailBean.f39171l), Boolean.valueOf(crashDetailBean.f39163d), Boolean.valueOf(crashDetailBean.f39169j));
                int i10 = crashDetailBean.f39171l + 1;
                crashDetailBean.f39171l = i10;
                crashDetailBean.f39163d = z10;
                x.c("set uid:%s uc:%d re:%b me:%b", crashDetailBean.f39162c, Integer.valueOf(i10), Boolean.valueOf(crashDetailBean.f39163d), Boolean.valueOf(crashDetailBean.f39169j));
            }
            Iterator<CrashDetailBean> iterator2 = list.iterator2();
            while (iterator2.hasNext()) {
                c.a().a(iterator2.next());
            }
            x.c("update state size %d", Integer.valueOf(list.size()));
        }
        if (z10) {
            return;
        }
        x.b("[crash] upload fail.", new Object[0]);
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
            CrashDetailBean crashDetailBean = (CrashDetailBean) z.a(blob, CrashDetailBean.CREATOR);
            if (crashDetailBean != null) {
                crashDetailBean.f39160a = j10;
            }
            return crashDetailBean;
        } catch (Throwable th) {
            if (!x.a(th)) {
                th.printStackTrace();
            }
            return null;
        }
    }

    private static ak a(Context context, CrashDetailBean crashDetailBean, com.tencent.bugly.crashreport.common.info.a aVar) {
        aj a10;
        aj a11;
        aj ajVar;
        if (context != null && crashDetailBean != null && aVar != null) {
            ak akVar = new ak();
            int i10 = crashDetailBean.f39161b;
            switch (i10) {
                case 0:
                    akVar.f40026a = crashDetailBean.f39169j ? "200" : ADEvent.PRICE_FILTER;
                    break;
                case 1:
                    akVar.f40026a = crashDetailBean.f39169j ? "201" : ADEvent.PRICE_LOW;
                    break;
                case 2:
                    akVar.f40026a = crashDetailBean.f39169j ? "202" : ADEvent.BLACKLIST_FILTER;
                    break;
                case 3:
                    akVar.f40026a = crashDetailBean.f39169j ? "203" : ADEvent.COMPETE_FILTER;
                    break;
                case 4:
                    akVar.f40026a = crashDetailBean.f39169j ? "204" : ADEvent.TIMEOUT_FILTER;
                    break;
                case 5:
                    akVar.f40026a = crashDetailBean.f39169j ? "207" : "107";
                    break;
                case 6:
                    akVar.f40026a = crashDetailBean.f39169j ? "206" : "106";
                    break;
                case 7:
                    akVar.f40026a = crashDetailBean.f39169j ? "208" : "108";
                    break;
                default:
                    x.e("crash type error! %d", Integer.valueOf(i10));
                    break;
            }
            akVar.f40027b = crashDetailBean.f39177r;
            akVar.f40028c = crashDetailBean.f39173n;
            akVar.f40029d = crashDetailBean.f39174o;
            akVar.f40030e = crashDetailBean.f39175p;
            akVar.f40032g = crashDetailBean.f39176q;
            akVar.f40033h = crashDetailBean.f39185z;
            akVar.f40034i = crashDetailBean.f39162c;
            akVar.f40035j = null;
            akVar.f40037l = crashDetailBean.f39172m;
            akVar.f40038m = crashDetailBean.f39164e;
            akVar.f40031f = crashDetailBean.B;
            akVar.f40039n = null;
            x.c("libInfo %s", akVar.f40040o);
            Map<String, PlugInBean> map = crashDetailBean.f39167h;
            if (map != null && map.size() > 0) {
                akVar.f40041p = new ArrayList<>();
                for (Map.Entry<String, PlugInBean> entry : crashDetailBean.f39167h.entrySet()) {
                    ah ahVar = new ah();
                    ahVar.f40009a = entry.getValue().f39085a;
                    ahVar.f40010b = entry.getValue().f39087c;
                    ahVar.f40011c = entry.getValue().f39086b;
                    akVar.f40041p.add(ahVar);
                }
            }
            if (crashDetailBean.f39169j) {
                akVar.f40036k = crashDetailBean.f39179t;
                String str = crashDetailBean.f39178s;
                if (str != null && str.length() > 0) {
                    if (akVar.f40042q == null) {
                        akVar.f40042q = new ArrayList<>();
                    }
                    try {
                        akVar.f40042q.add(new aj((byte) 1, "alltimes.txt", crashDetailBean.f39178s.getBytes("utf-8")));
                    } catch (UnsupportedEncodingException e2) {
                        e2.printStackTrace();
                        akVar.f40042q = null;
                    }
                }
                Object[] objArr = new Object[2];
                objArr[0] = Integer.valueOf(akVar.f40036k);
                ArrayList<aj> arrayList = akVar.f40042q;
                objArr[1] = Integer.valueOf(arrayList != null ? arrayList.size() : 0);
                x.c("crashcount:%d sz:%d", objArr);
            }
            if (crashDetailBean.f39182w != null) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                try {
                    akVar.f40042q.add(new aj((byte) 1, "log.txt", crashDetailBean.f39182w.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e10) {
                    e10.printStackTrace();
                    akVar.f40042q = null;
                }
            }
            if (crashDetailBean.f39183x != null) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                try {
                    akVar.f40042q.add(new aj((byte) 1, "jniLog.txt", crashDetailBean.f39183x.getBytes("utf-8")));
                } catch (UnsupportedEncodingException e11) {
                    e11.printStackTrace();
                    akVar.f40042q = null;
                }
            }
            if (!z.a(crashDetailBean.V)) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                try {
                    ajVar = new aj((byte) 1, "crashInfos.txt", crashDetailBean.V.getBytes("utf-8"));
                } catch (UnsupportedEncodingException e12) {
                    e12.printStackTrace();
                    ajVar = null;
                }
                if (ajVar != null) {
                    x.c("attach crash infos", new Object[0]);
                    akVar.f40042q.add(ajVar);
                }
            }
            if (crashDetailBean.W != null) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                aj a12 = a("backupRecord.zip", context, crashDetailBean.W);
                if (a12 != null) {
                    x.c("attach backup record", new Object[0]);
                    akVar.f40042q.add(a12);
                }
            }
            byte[] bArr = crashDetailBean.f39184y;
            if (bArr != null && bArr.length > 0) {
                aj ajVar2 = new aj((byte) 2, "buglylog.zip", bArr);
                x.c("attach user log", new Object[0]);
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                akVar.f40042q.add(ajVar2);
            }
            if (crashDetailBean.f39161b == 3) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                x.c("crashBean.anrMessages:%s", crashDetailBean.P);
                Map<String, String> map2 = crashDetailBean.P;
                if (map2 != null && map2.containsKey("BUGLY_CR_01")) {
                    try {
                        if (!TextUtils.isEmpty(crashDetailBean.P.get("BUGLY_CR_01"))) {
                            akVar.f40042q.add(new aj((byte) 1, "anrMessage.txt", crashDetailBean.P.get("BUGLY_CR_01").getBytes("utf-8")));
                            x.c("attach anr message", new Object[0]);
                        }
                    } catch (UnsupportedEncodingException e13) {
                        e13.printStackTrace();
                        akVar.f40042q = null;
                    }
                    crashDetailBean.P.remove("BUGLY_CR_01");
                }
                if (crashDetailBean.f39181v != null && NativeCrashHandler.getInstance().isEnableCatchAnrTrace() && (a11 = a("trace.zip", context, crashDetailBean.f39181v)) != null) {
                    x.c("attach traces", new Object[0]);
                    akVar.f40042q.add(a11);
                }
            }
            if (crashDetailBean.f39161b == 1) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                String str2 = crashDetailBean.f39181v;
                if (str2 != null && (a10 = a("tomb.zip", context, str2)) != null) {
                    x.c("attach tombs", new Object[0]);
                    akVar.f40042q.add(a10);
                }
            }
            List<String> list = aVar.C;
            if (list != null && !list.isEmpty()) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                StringBuilder sb2 = new StringBuilder();
                Iterator<String> iterator2 = aVar.C.iterator2();
                while (iterator2.hasNext()) {
                    sb2.append(iterator2.next());
                }
                try {
                    akVar.f40042q.add(new aj((byte) 1, "martianlog.txt", sb2.toString().getBytes("utf-8")));
                    x.c("attach pageTracingList", new Object[0]);
                } catch (UnsupportedEncodingException e14) {
                    e14.printStackTrace();
                }
            }
            byte[] bArr2 = crashDetailBean.U;
            if (bArr2 != null && bArr2.length > 0) {
                if (akVar.f40042q == null) {
                    akVar.f40042q = new ArrayList<>();
                }
                akVar.f40042q.add(new aj((byte) 1, "userExtraByteData", crashDetailBean.U));
                x.c("attach extraData", new Object[0]);
            }
            HashMap hashMap = new HashMap();
            akVar.f40043r = hashMap;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(crashDetailBean.C);
            hashMap.put("A9", sb3.toString());
            Map<String, String> map3 = akVar.f40043r;
            StringBuilder sb4 = new StringBuilder();
            sb4.append(crashDetailBean.D);
            map3.put("A11", sb4.toString());
            Map<String, String> map4 = akVar.f40043r;
            StringBuilder sb5 = new StringBuilder();
            sb5.append(crashDetailBean.E);
            map4.put("A10", sb5.toString());
            akVar.f40043r.put("A23", crashDetailBean.f39165f);
            akVar.f40043r.put("A7", aVar.f39099g);
            akVar.f40043r.put("A6", aVar.o());
            akVar.f40043r.put("A5", aVar.n());
            akVar.f40043r.put("A22", aVar.h());
            Map<String, String> map5 = akVar.f40043r;
            StringBuilder sb6 = new StringBuilder();
            sb6.append(crashDetailBean.G);
            map5.put("A2", sb6.toString());
            Map<String, String> map6 = akVar.f40043r;
            StringBuilder sb7 = new StringBuilder();
            sb7.append(crashDetailBean.F);
            map6.put("A1", sb7.toString());
            akVar.f40043r.put("A24", aVar.f39100h);
            Map<String, String> map7 = akVar.f40043r;
            StringBuilder sb8 = new StringBuilder();
            sb8.append(crashDetailBean.H);
            map7.put("A17", sb8.toString());
            akVar.f40043r.put("A25", aVar.h());
            akVar.f40043r.put("A15", aVar.r());
            Map<String, String> map8 = akVar.f40043r;
            StringBuilder sb9 = new StringBuilder();
            sb9.append((Object) aVar.s());
            map8.put("A13", sb9.toString());
            akVar.f40043r.put("A34", crashDetailBean.A);
            if (aVar.f39116x != null) {
                akVar.f40043r.put("productIdentify", aVar.f39116x);
            }
            try {
                akVar.f40043r.put("A26", URLEncoder.encode(crashDetailBean.I, "utf-8"));
            } catch (UnsupportedEncodingException e15) {
                e15.printStackTrace();
            }
            if (crashDetailBean.f39161b == 1) {
                akVar.f40043r.put("A27", crashDetailBean.K);
                akVar.f40043r.put("A28", crashDetailBean.J);
                Map<String, String> map9 = akVar.f40043r;
                StringBuilder sb10 = new StringBuilder();
                sb10.append(crashDetailBean.f39170k);
                map9.put("A29", sb10.toString());
            }
            akVar.f40043r.put("A30", crashDetailBean.L);
            Map<String, String> map10 = akVar.f40043r;
            StringBuilder sb11 = new StringBuilder();
            sb11.append(crashDetailBean.M);
            map10.put("A18", sb11.toString());
            Map<String, String> map11 = akVar.f40043r;
            StringBuilder sb12 = new StringBuilder();
            sb12.append(!crashDetailBean.N);
            map11.put("A36", sb12.toString());
            Map<String, String> map12 = akVar.f40043r;
            StringBuilder sb13 = new StringBuilder();
            sb13.append(aVar.f39109q);
            map12.put("F02", sb13.toString());
            Map<String, String> map13 = akVar.f40043r;
            StringBuilder sb14 = new StringBuilder();
            sb14.append(aVar.f39110r);
            map13.put("F03", sb14.toString());
            akVar.f40043r.put("F04", aVar.e());
            Map<String, String> map14 = akVar.f40043r;
            StringBuilder sb15 = new StringBuilder();
            sb15.append(aVar.f39111s);
            map14.put("F05", sb15.toString());
            akVar.f40043r.put("F06", aVar.f39108p);
            akVar.f40043r.put("F08", aVar.f39114v);
            akVar.f40043r.put("F09", aVar.f39115w);
            Map<String, String> map15 = akVar.f40043r;
            StringBuilder sb16 = new StringBuilder();
            sb16.append(aVar.f39112t);
            map15.put("F10", sb16.toString());
            if (crashDetailBean.Q >= 0) {
                Map<String, String> map16 = akVar.f40043r;
                StringBuilder sb17 = new StringBuilder();
                sb17.append(crashDetailBean.Q);
                map16.put("C01", sb17.toString());
            }
            if (crashDetailBean.R >= 0) {
                Map<String, String> map17 = akVar.f40043r;
                StringBuilder sb18 = new StringBuilder();
                sb18.append(crashDetailBean.R);
                map17.put("C02", sb18.toString());
            }
            Map<String, String> map18 = crashDetailBean.S;
            if (map18 != null && map18.size() > 0) {
                for (Map.Entry<String, String> entry2 : crashDetailBean.S.entrySet()) {
                    akVar.f40043r.put("C03_" + entry2.getKey(), entry2.getValue());
                }
            }
            Map<String, String> map19 = crashDetailBean.T;
            if (map19 != null && map19.size() > 0) {
                for (Map.Entry<String, String> entry3 : crashDetailBean.T.entrySet()) {
                    akVar.f40043r.put("C04_" + entry3.getKey(), entry3.getValue());
                }
            }
            akVar.f40044s = null;
            Map<String, String> map20 = crashDetailBean.O;
            if (map20 != null && map20.size() > 0) {
                Map<String, String> map21 = crashDetailBean.O;
                akVar.f40044s = map21;
                x.a("setted message size %d", Integer.valueOf(map21.size()));
            }
            Object[] objArr2 = new Object[12];
            objArr2[0] = crashDetailBean.f39173n;
            objArr2[1] = crashDetailBean.f39162c;
            objArr2[2] = aVar.e();
            objArr2[3] = Long.valueOf((crashDetailBean.f39177r - crashDetailBean.M) / 1000);
            objArr2[4] = Boolean.valueOf(crashDetailBean.f39170k);
            objArr2[5] = Boolean.valueOf(crashDetailBean.N);
            objArr2[6] = Boolean.valueOf(crashDetailBean.f39169j);
            objArr2[7] = Boolean.valueOf(crashDetailBean.f39161b == 1);
            objArr2[8] = Integer.valueOf(crashDetailBean.f39179t);
            objArr2[9] = crashDetailBean.f39178s;
            objArr2[10] = Boolean.valueOf(crashDetailBean.f39163d);
            objArr2[11] = Integer.valueOf(akVar.f40043r.size());
            x.c("%s rid:%s sess:%s ls:%ds isR:%b isF:%b isM:%b isN:%b mc:%d ,%s ,isUp:%b ,vm:%d", objArr2);
            return akVar;
        }
        x.d("enExp args == null", new Object[0]);
        return null;
    }

    private static aj a(String str, Context context, String str2) {
        FileInputStream fileInputStream;
        if (str2 != null && context != null) {
            x.c("zip %s", str2);
            File file = new File(str2);
            File file2 = new File(context.getCacheDir(), str);
            if (!z.a(file, file2, 5000)) {
                x.d("zip fail!", new Object[0]);
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
                x.c("read bytes :%d", Integer.valueOf(byteArray.length));
                aj ajVar = new aj((byte) 2, file2.getName(), byteArray);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    if (!x.a(e2)) {
                        e2.printStackTrace();
                    }
                }
                if (file2.exists()) {
                    x.c("del tmp", new Object[0]);
                    file2.delete();
                }
                return ajVar;
            } catch (Throwable th2) {
                th = th2;
                try {
                    if (!x.a(th)) {
                        th.printStackTrace();
                    }
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e10) {
                            if (!x.a(e10)) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        x.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    return null;
                } catch (Throwable th3) {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e11) {
                            if (!x.a(e11)) {
                                e11.printStackTrace();
                            }
                        }
                    }
                    if (file2.exists()) {
                        x.c("del tmp", new Object[0]);
                        file2.delete();
                    }
                    throw th3;
                }
            }
        }
        x.d("rqdp{  createZipAttachment sourcePath == null || context == null ,pls check}", new Object[0]);
        return null;
    }

    public static void a(String str, String str2, String str3, String str4, String str5, CrashDetailBean crashDetailBean) {
        String str6;
        com.tencent.bugly.crashreport.common.info.a b4 = com.tencent.bugly.crashreport.common.info.a.b();
        if (b4 == null) {
            return;
        }
        x.e("#++++++++++Record By Bugly++++++++++#", new Object[0]);
        x.e("# You can use Bugly(http:\\\\bugly.qq.com) to get more Crash Detail!", new Object[0]);
        x.e("# PKG NAME: %s", b4.f39095c);
        x.e("# APP VER: %s", b4.f39102j);
        x.e("# SDK VER: %s", b4.f39098f);
        x.e("# LAUNCH TIME: %s", z.a(new Date(com.tencent.bugly.crashreport.common.info.a.b().f39088a)));
        x.e("# CRASH TYPE: %s", str);
        x.e("# CRASH TIME: %s", str2);
        x.e("# CRASH PROCESS: %s", str3);
        x.e("# CRASH THREAD: %s", str4);
        if (crashDetailBean != null) {
            x.e("# REPORT ID: %s", crashDetailBean.f39162c);
            Object[] objArr = new Object[2];
            objArr[0] = b4.i();
            objArr[1] = b4.s().booleanValue() ? "ROOTED" : "UNROOT";
            x.e("# CRASH DEVICE: %s %s", objArr);
            x.e("# RUNTIME AVAIL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.C), Long.valueOf(crashDetailBean.D), Long.valueOf(crashDetailBean.E));
            x.e("# RUNTIME TOTAL RAM:%d ROM:%d SD:%d", Long.valueOf(crashDetailBean.F), Long.valueOf(crashDetailBean.G), Long.valueOf(crashDetailBean.H));
            if (!z.a(crashDetailBean.K)) {
                x.e("# EXCEPTION FIRED BY %s %s", crashDetailBean.K, crashDetailBean.J);
            } else if (crashDetailBean.f39161b == 3) {
                Object[] objArr2 = new Object[1];
                if (crashDetailBean.P == null) {
                    str6 = "null";
                } else {
                    str6 = crashDetailBean.P.get("BUGLY_CR_01");
                }
                objArr2[0] = str6;
                x.e("# EXCEPTION ANR MESSAGE:\n %s", objArr2);
            }
        }
        if (!z.a(str5)) {
            x.e("# CRASH STACK: ", new Object[0]);
            x.e(str5, new Object[0]);
        }
        x.e("#++++++++++++++++++++++++++++++++++++++++++#", new Object[0]);
    }
}
