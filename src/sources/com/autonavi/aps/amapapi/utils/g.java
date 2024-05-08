package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fn;
import com.amap.api.col.p0003l.kv;
import com.amap.api.location.AMapLocation;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: ReportRecorder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {

    /* renamed from: f, reason: collision with root package name */
    private static g f9654f;

    /* renamed from: i, reason: collision with root package name */
    private static long f9655i;

    /* renamed from: d, reason: collision with root package name */
    private File f9659d;

    /* renamed from: e, reason: collision with root package name */
    private String f9660e;

    /* renamed from: g, reason: collision with root package name */
    private Context f9661g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f9662h;

    /* renamed from: c, reason: collision with root package name */
    private LinkedHashMap<String, Long> f9658c = new LinkedHashMap<>();

    /* renamed from: a, reason: collision with root package name */
    public String f9656a = "";

    /* renamed from: b, reason: collision with root package name */
    public String f9657b = null;

    private g(Context context) {
        this.f9660e = null;
        Context applicationContext = context.getApplicationContext();
        this.f9661g = applicationContext;
        String path = applicationContext.getFilesDir().getPath();
        if (this.f9660e == null) {
            this.f9660e = j.l(this.f9661g);
        }
        try {
            this.f9659d = new File(path, "reportRecorder");
        } catch (Throwable th) {
            kv.a(th);
        }
        c();
    }

    public static synchronized g a(Context context) {
        g gVar;
        synchronized (g.class) {
            if (f9654f == null) {
                f9654f = new g(context);
            }
            gVar = f9654f;
        }
        return gVar;
    }

    private synchronized void c() {
        LinkedHashMap<String, Long> linkedHashMap = this.f9658c;
        if (linkedHashMap == null || linkedHashMap.size() <= 0) {
            try {
                this.f9656a = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis()));
                Iterator<String> iterator2 = j.a(this.f9659d).iterator2();
                while (iterator2.hasNext()) {
                    try {
                        try {
                            String[] split = new String(com.autonavi.aps.amapapi.security.a.b(fn.b(iterator2.next()), this.f9660e), "UTF-8").split(",");
                            if (split != null && split.length > 1) {
                                this.f9658c.put(split[0], Long.valueOf(Long.parseLong(split[1])));
                            }
                        } catch (UnsupportedEncodingException e2) {
                            e2.printStackTrace();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    private void d() {
        try {
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry<String, Long> entry : this.f9658c.entrySet()) {
                try {
                    sb2.append(fn.b(com.autonavi.aps.amapapi.security.a.a((entry.getKey() + "," + ((Object) entry.getValue())).getBytes("UTF-8"), this.f9660e)) + "\n");
                } catch (UnsupportedEncodingException e2) {
                    e2.printStackTrace();
                }
            }
            String sb3 = sb2.toString();
            if (TextUtils.isEmpty(sb3)) {
                return;
            }
            j.a(this.f9659d, sb3);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final synchronized void b() {
        try {
            if (b(this.f9661g)) {
                for (Map.Entry<String, Long> entry : this.f9658c.entrySet()) {
                    try {
                        if (!this.f9656a.equals(entry.getKey())) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("param_long_first", entry.getKey());
                            jSONObject.put("param_long_second", entry.getValue());
                            h.a(this.f9661g, "O023", jSONObject);
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public final synchronized void a() {
        if (this.f9662h) {
            d();
            this.f9662h = false;
        }
    }

    public final synchronized void a(AMapLocation aMapLocation) {
        try {
            if ((!this.f9658c.containsKey(this.f9656a) && this.f9658c.size() >= 8) || (this.f9658c.containsKey(this.f9656a) && this.f9658c.size() >= 9)) {
                ArrayList arrayList = new ArrayList();
                Iterator<Map.Entry<String, Long>> iterator2 = this.f9658c.entrySet().iterator2();
                while (iterator2.hasNext()) {
                    try {
                        arrayList.add(iterator2.next().getKey());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    if (arrayList.size() == this.f9658c.size() - 7) {
                        break;
                    }
                }
                Iterator<E> iterator22 = arrayList.iterator2();
                while (iterator22.hasNext()) {
                    this.f9658c.remove((String) iterator22.next());
                }
            }
            if (aMapLocation.getErrorCode() != 0) {
                return;
            }
            if (aMapLocation.getLocationType() != 6 && aMapLocation.getLocationType() != 5) {
                if (this.f9658c.containsKey(this.f9656a)) {
                    long longValue = this.f9658c.get(this.f9656a).longValue() + 1;
                    f9655i = longValue;
                    this.f9658c.put(this.f9656a, Long.valueOf(longValue));
                } else {
                    this.f9658c.put(this.f9656a, 1L);
                    f9655i = 1L;
                }
                long j10 = f9655i;
                if (j10 != 0 && j10 % 100 == 0) {
                    a();
                }
                this.f9662h = true;
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private boolean b(Context context) {
        if (this.f9657b == null) {
            this.f9657b = i.a(context, "pref", "lastavedate", "0");
        }
        if (this.f9657b.equals(this.f9656a)) {
            return false;
        }
        SharedPreferences.Editor a10 = i.a(context, "pref");
        i.a(a10, "lastavedate", this.f9656a);
        i.a(a10);
        this.f9657b = this.f9656a;
        return true;
    }
}
