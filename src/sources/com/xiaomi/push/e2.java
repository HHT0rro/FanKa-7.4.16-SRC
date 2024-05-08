package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import com.baidu.mobads.sdk.internal.bk;
import com.xiaomi.push.r;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e2 {

    /* renamed from: c, reason: collision with root package name */
    public static volatile e2 f47197c;

    /* renamed from: a, reason: collision with root package name */
    public final ConcurrentLinkedQueue<b> f47198a;

    /* renamed from: b, reason: collision with root package name */
    public Context f47199b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class a extends b {
        public a() {
            super();
        }

        @Override // com.xiaomi.push.e2.b, com.xiaomi.push.r.b
        public void b() {
            e2.this.i();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class b extends r.b {

        /* renamed from: a, reason: collision with root package name */
        public long f47201a = System.currentTimeMillis();

        public b() {
        }

        @Override // com.xiaomi.push.r.b
        public void b() {
        }

        public boolean d() {
            return true;
        }

        public final boolean e() {
            return System.currentTimeMillis() - this.f47201a > bk.f9896e;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class c extends b {

        /* renamed from: c, reason: collision with root package name */
        public String f47203c;

        /* renamed from: d, reason: collision with root package name */
        public String f47204d;

        /* renamed from: e, reason: collision with root package name */
        public File f47205e;

        /* renamed from: f, reason: collision with root package name */
        public int f47206f;

        /* renamed from: g, reason: collision with root package name */
        public boolean f47207g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f47208h;

        public c(String str, String str2, File file, boolean z10) {
            super();
            this.f47203c = str;
            this.f47204d = str2;
            this.f47205e = file;
            this.f47208h = z10;
        }

        @Override // com.xiaomi.push.e2.b, com.xiaomi.push.r.b
        public void b() {
            try {
                if (f()) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("uid", kc.x.f());
                    hashMap.put("token", this.f47204d);
                    hashMap.put("net", j0.g(e2.this.f47199b));
                    j0.k(this.f47203c, hashMap, this.f47205e, "file");
                }
                this.f47207g = true;
            } catch (IOException unused) {
            }
        }

        @Override // com.xiaomi.push.r.b
        public void c() {
            if (!this.f47207g) {
                int i10 = this.f47206f + 1;
                this.f47206f = i10;
                if (i10 < 3) {
                    e2.this.f47198a.add(this);
                }
            }
            if (this.f47207g || this.f47206f >= 3) {
                this.f47205e.delete();
            }
            e2.this.e((1 << this.f47206f) * 1000);
        }

        @Override // com.xiaomi.push.e2.b
        public boolean d() {
            return j0.r(e2.this.f47199b) || (this.f47208h && j0.p(e2.this.f47199b));
        }

        public final boolean f() {
            int i10;
            int i11 = 0;
            SharedPreferences sharedPreferences = e2.this.f47199b.getSharedPreferences("log.timestamp", 0);
            String string = sharedPreferences.getString("log.requst", "");
            long currentTimeMillis = System.currentTimeMillis();
            try {
                JSONObject jSONObject = new JSONObject(string);
                currentTimeMillis = jSONObject.getLong("time");
                i10 = jSONObject.getInt("times");
            } catch (JSONException unused) {
                i10 = 0;
            }
            if (System.currentTimeMillis() - currentTimeMillis >= 86400000) {
                currentTimeMillis = System.currentTimeMillis();
            } else {
                if (i10 > 10) {
                    return false;
                }
                i11 = i10;
            }
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("time", currentTimeMillis);
                jSONObject2.put("times", i11 + 1);
                sharedPreferences.edit().putString("log.requst", jSONObject2.toString()).commit();
            } catch (JSONException e2) {
                fc.c.m("JSONException on put " + e2.getMessage());
            }
            return true;
        }
    }

    public e2(Context context) {
        ConcurrentLinkedQueue<b> concurrentLinkedQueue = new ConcurrentLinkedQueue<>();
        this.f47198a = concurrentLinkedQueue;
        this.f47199b = context;
        concurrentLinkedQueue.add(new a());
        j(0L);
    }

    public static e2 b(Context context) {
        if (f47197c == null) {
            synchronized (e2.class) {
                if (f47197c == null) {
                    f47197c = new e2(context);
                }
            }
        }
        f47197c.f47199b = context;
        return f47197c;
    }

    public void d() {
        k();
        e(0L);
    }

    public final void e(long j10) {
        b peek = this.f47198a.peek();
        if (peek == null || !peek.d()) {
            return;
        }
        j(j10);
    }

    public void h(String str, String str2, Date date, Date date2, int i10, boolean z10) {
        this.f47198a.add(new f2(this, i10, date, date2, str, str2, z10));
        j(0L);
    }

    public final void i() {
        if (com.xiaomi.push.b.c() || com.xiaomi.push.b.b()) {
            return;
        }
        try {
            File file = new File(((Object) this.f47199b.getExternalFilesDir(null)) + "/.logcache");
            if (file.exists() && file.isDirectory()) {
                for (File file2 : file.listFiles()) {
                    file2.delete();
                }
            }
        } catch (NullPointerException unused) {
        }
    }

    public final void j(long j10) {
        if (this.f47198a.isEmpty()) {
            return;
        }
        v5.b(new g2(this), j10);
    }

    public final void k() {
        while (!this.f47198a.isEmpty()) {
            b peek = this.f47198a.peek();
            if (peek != null) {
                if (!peek.e() && this.f47198a.size() <= 6) {
                    return;
                }
                fc.c.m("remove Expired task");
                this.f47198a.remove(peek);
            }
        }
    }
}
