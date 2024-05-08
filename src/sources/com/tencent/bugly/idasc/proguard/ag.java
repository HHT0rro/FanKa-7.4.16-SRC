package com.tencent.bugly.idasc.proguard;

import android.content.ContentValues;
import android.database.Cursor;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class ag {

    /* renamed from: a */
    private final SimpleDateFormat f39513a;

    /* renamed from: b */
    private final ad f39514b;

    /* renamed from: com.tencent.bugly.idasc.proguard.ag$1 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ List f39515a;

        public AnonymousClass1(List list) {
            r2 = list;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ag.c(r2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: a */
        private static final ag f39517a = new ag((byte) 0);

        public static /* synthetic */ ag a() {
            return f39517a;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a */
        public String f39518a;

        /* renamed from: b */
        public long f39519b;

        /* renamed from: c */
        public String f39520c;

        public final String toString() {
            return "SLAData{uuid='" + this.f39518a + "', time=" + this.f39519b + ", data='" + this.f39520c + "'}";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class c {

        /* renamed from: a */
        public String f39521a;

        /* renamed from: b */
        public String f39522b;

        /* renamed from: c */
        public long f39523c;

        /* renamed from: d */
        public boolean f39524d;

        /* renamed from: e */
        public long f39525e;

        /* renamed from: f */
        public String f39526f;

        /* renamed from: g */
        public String f39527g;

        public c() {
        }

        public c(String str, String str2, long j10, boolean z10, long j11, String str3, String str4) {
            this.f39521a = str;
            this.f39522b = str2;
            this.f39523c = j10;
            this.f39524d = z10;
            this.f39525e = j11;
            this.f39526f = str3;
            this.f39527g = str4;
        }
    }

    private ag() {
        this.f39513a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US);
        this.f39514b = new ad();
    }

    public /* synthetic */ ag(byte b4) {
        this();
    }

    private static String a(String str, Iterable<b> iterable) {
        Iterator<b> iterator2 = iterable.iterator2();
        if (!iterator2.hasNext()) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            sb2.append("'");
            sb2.append(iterator2.next().f39518a);
            sb2.append("'");
            if (!iterator2.hasNext()) {
                return sb2.toString();
            }
            sb2.append(str);
        }
    }

    public static List<b> a() {
        Cursor a10 = w.a().a("t_sla", new String[]{"_id", "_tm", "_dt"}, (String) null, "_tm", "30");
        if (a10 == null) {
            return null;
        }
        if (a10.getCount() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (a10.moveToNext()) {
            try {
                b bVar = new b();
                bVar.f39518a = a10.getString(a10.getColumnIndex("_id"));
                bVar.f39519b = a10.getLong(a10.getColumnIndex("_tm"));
                bVar.f39520c = a10.getString(a10.getColumnIndex("_dt"));
                al.c(bVar.toString(), new Object[0]);
                arrayList.add(bVar);
            } finally {
                try {
                    return arrayList;
                } finally {
                }
            }
        }
        return arrayList;
    }

    private b b(c cVar) {
        if (cVar == null || TextUtils.isEmpty(cVar.f39522b)) {
            al.d("sla convert event is null", new Object[0]);
            return null;
        }
        aa b4 = aa.b();
        if (b4 == null) {
            al.d("sla convert failed because ComInfoManager is null", new Object[0]);
            return null;
        }
        StringBuilder sb2 = new StringBuilder("&app_version=");
        sb2.append(b4.f39485o);
        sb2.append("&app_name=");
        sb2.append(b4.f39487q);
        sb2.append("&app_bundle_id=");
        sb2.append(b4.f39473c);
        sb2.append("&client_type=android&user_id=");
        sb2.append(b4.f());
        sb2.append("&sdk_version=");
        sb2.append(b4.f39478h);
        sb2.append("&event_code=");
        sb2.append(cVar.f39522b);
        sb2.append("&event_result=");
        sb2.append(cVar.f39524d ? 1 : 0);
        sb2.append("&event_time=");
        sb2.append(this.f39513a.format(new Date(cVar.f39523c)));
        sb2.append("&event_cost=");
        sb2.append(cVar.f39525e);
        sb2.append("&device_id=");
        sb2.append(b4.g());
        sb2.append("&debug=");
        sb2.append(b4.D ? 1 : 0);
        sb2.append("&param_0=");
        sb2.append(cVar.f39526f);
        sb2.append("&param_1=");
        sb2.append(cVar.f39521a);
        sb2.append("&param_2=");
        sb2.append(b4.M ? "rqd" : "ext");
        sb2.append("&param_4=");
        sb2.append(b4.e());
        String sb3 = sb2.toString();
        if (!TextUtils.isEmpty(cVar.f39527g)) {
            sb3 = sb3 + "&param_3=" + cVar.f39527g;
        }
        al.c("sla convert eventId:%s eventType:%s, eventTime:%s success:%s cost:%s from:%s uploadMsg:", cVar.f39521a, cVar.f39522b, Long.valueOf(cVar.f39523c), Boolean.valueOf(cVar.f39524d), Long.valueOf(cVar.f39525e), cVar.f39526f, cVar.f39527g);
        String str = cVar.f39521a + "-" + cVar.f39522b;
        b bVar = new b();
        bVar.f39518a = str;
        bVar.f39519b = cVar.f39523c;
        bVar.f39520c = sb3;
        return bVar;
    }

    public static void c(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch report data is empty", new Object[0]);
            return;
        }
        al.c("sla batch report list size:%s", Integer.valueOf(list.size()));
        if (list.size() > 30) {
            list = list.subList(0, 29);
        }
        ArrayList arrayList = new ArrayList();
        Iterator<b> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            arrayList.add(iterator2.next().f39520c);
        }
        Pair<Integer, String> a10 = ad.a(arrayList);
        al.c("sla batch report result, rspCode:%s rspMsg:%s", a10.first, a10.second);
        if (((Integer) a10.first).intValue() == 200) {
            d(list);
        }
    }

    public static void d(List<b> list) {
        if (list == null || list.isEmpty()) {
            al.c("sla batch delete list is null", new Object[0]);
            return;
        }
        al.c("sla batch delete list size:%s", Integer.valueOf(list.size()));
        try {
            String str = "_id in (" + a(",", list) + ")";
            al.c("sla batch delete where:%s", str);
            w.a().a("t_sla", str);
        } catch (Throwable th) {
            al.b(th);
        }
    }

    private static void e(List<b> list) {
        for (b bVar : list) {
            al.c("sla save id:%s time:%s msg:%s", bVar.f39518a, Long.valueOf(bVar.f39519b), bVar.f39520c);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("_id", bVar.f39518a);
                contentValues.put("_tm", Long.valueOf(bVar.f39519b));
                contentValues.put("_dt", bVar.f39520c);
                w.a().a("t_sla", contentValues, (v) null);
            } catch (Throwable th) {
                al.b(th);
            }
        }
    }

    public final void a(c cVar) {
        if (TextUtils.isEmpty(cVar.f39522b)) {
            al.d("sla report event is null", new Object[0]);
        } else {
            al.c("sla report single event", new Object[0]);
            a(Collections.singletonList(cVar));
        }
    }

    public final void a(List<c> list) {
        if (list == null || list.isEmpty()) {
            al.d("sla batch report event is null", new Object[0]);
            return;
        }
        al.c("sla batch report event size:%s", Integer.valueOf(list.size()));
        ArrayList arrayList = new ArrayList();
        Iterator<c> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            b b4 = b(iterator2.next());
            if (b4 != null) {
                arrayList.add(b4);
            }
        }
        e(arrayList);
        b(arrayList);
    }

    public final void b(List<b> list) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            ak.a().a(new Runnable() { // from class: com.tencent.bugly.idasc.proguard.ag.1

                /* renamed from: a */
                public final /* synthetic */ List f39515a;

                public AnonymousClass1(List list2) {
                    r2 = list2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ag.c(r2);
                }
            });
        } else {
            c(list2);
        }
    }
}
