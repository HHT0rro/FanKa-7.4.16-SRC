package com.autonavi.aps.amapapi.restruct;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.amap.api.col.p0003l.fn;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: AgeEstimator.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public abstract class a<T> {

    /* renamed from: a, reason: collision with root package name */
    public String f9395a;

    /* renamed from: b, reason: collision with root package name */
    private File f9396b;

    /* renamed from: e, reason: collision with root package name */
    private Handler f9399e;

    /* renamed from: f, reason: collision with root package name */
    private String f9400f;

    /* renamed from: g, reason: collision with root package name */
    private boolean f9401g;

    /* renamed from: c, reason: collision with root package name */
    private boolean f9397c = false;

    /* renamed from: d, reason: collision with root package name */
    private Map<String, C0111a> f9398d = new ConcurrentHashMap();

    /* renamed from: h, reason: collision with root package name */
    private Runnable f9402h = new Runnable() { // from class: com.autonavi.aps.amapapi.restruct.a.2
        @Override // java.lang.Runnable
        public final void run() {
            if (a.this.f9397c) {
                if (a.this.f9401g) {
                    a.this.e();
                    a.e(a.this);
                }
                if (a.this.f9399e != null) {
                    a.this.f9399e.postDelayed(a.this.f9402h, 60000L);
                }
            }
        }
    };

    /* compiled from: AgeEstimator.java */
    /* renamed from: com.autonavi.aps.amapapi.restruct.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static class C0111a {

        /* renamed from: a, reason: collision with root package name */
        public int f9405a;

        /* renamed from: b, reason: collision with root package name */
        public long f9406b;

        /* renamed from: c, reason: collision with root package name */
        public long f9407c;

        public C0111a(int i10, long j10, long j11) {
            this.f9405a = i10;
            this.f9406b = j10;
            this.f9407c = j11;
        }
    }

    public a(Context context, String str, Handler handler) {
        this.f9400f = null;
        if (context == null) {
            return;
        }
        this.f9399e = handler;
        this.f9395a = TextUtils.isEmpty(str) ? "unknow" : str;
        this.f9400f = com.autonavi.aps.amapapi.utils.j.l(context);
        try {
            this.f9396b = new File(context.getFilesDir().getPath(), this.f9395a);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        d();
    }

    public static int a(long j10, long j11) {
        if (j10 < j11) {
            return -1;
        }
        return j10 == j11 ? 0 : 1;
    }

    public static /* synthetic */ boolean e(a aVar) {
        aVar.f9401g = false;
        return false;
    }

    public abstract void a(T t2, long j10);

    public abstract long b();

    public abstract String b(T t2);

    public abstract int c(T t2);

    public abstract long c();

    public abstract long d(T t2);

    private void b(T t2, long j10) {
        if (t2 == null || d((a<T>) t2) < 0) {
            return;
        }
        String b4 = b((a<T>) t2);
        C0111a c0111a = this.f9398d.get(b4);
        if (c0111a == null) {
            a((a<T>) t2, j10);
            this.f9398d.put(b4, new C0111a(c((a<T>) t2), d((a<T>) t2), j10));
            this.f9401g = true;
            return;
        }
        c0111a.f9407c = j10;
        if (c0111a.f9405a != c((a<T>) t2)) {
            a((a<T>) t2, j10);
            c0111a.f9405a = c((a<T>) t2);
            c0111a.f9406b = d((a<T>) t2);
            this.f9401g = true;
            return;
        }
        a((a<T>) t2, c0111a.f9406b);
    }

    private void d() {
        long b4;
        try {
            Iterator<String> iterator2 = com.autonavi.aps.amapapi.utils.j.a(this.f9396b).iterator2();
            while (iterator2.hasNext()) {
                try {
                    String[] split = new String(com.autonavi.aps.amapapi.security.a.b(fn.b(iterator2.next()), this.f9400f), "UTF-8").split(",");
                    if (split.length >= 4) {
                        b4 = Long.parseLong(split[3]);
                    } else {
                        b4 = com.autonavi.aps.amapapi.utils.j.b();
                    }
                    this.f9398d.put(split[0], new C0111a(Integer.parseInt(split[1]), Long.parseLong(split[2]), b4));
                } catch (Throwable th) {
                    if (this.f9396b.exists()) {
                        this.f9396b.delete();
                    }
                    th.printStackTrace();
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (c() > 0) {
            this.f9398d.size();
            if (b() > 0) {
                long b4 = com.autonavi.aps.amapapi.utils.j.b();
                Iterator<Map.Entry<String, C0111a>> iterator2 = this.f9398d.entrySet().iterator2();
                while (iterator2.hasNext()) {
                    if (b4 - this.f9398d.get(iterator2.next().getKey()).f9407c > b()) {
                        iterator2.remove();
                    }
                }
            }
            if (this.f9398d.size() > c()) {
                ArrayList arrayList = new ArrayList(this.f9398d.h());
                Collections.sort(arrayList, new Comparator<String>() { // from class: com.autonavi.aps.amapapi.restruct.a.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // java.util.Comparator
                    /* renamed from: a, reason: merged with bridge method [inline-methods] */
                    public int compare(String str, String str2) {
                        return a.a(((C0111a) a.this.f9398d.get(str2)).f9407c, ((C0111a) a.this.f9398d.get(str)).f9407c);
                    }
                });
                for (int c4 = (int) c(); c4 < arrayList.size(); c4++) {
                    this.f9398d.remove(arrayList.get(c4));
                }
            }
        }
        StringBuilder sb2 = new StringBuilder();
        for (Map.Entry<String, C0111a> entry : this.f9398d.entrySet()) {
            try {
                sb2.append(fn.b(com.autonavi.aps.amapapi.security.a.a((entry.getKey() + "," + entry.getValue().f9405a + "," + entry.getValue().f9406b + "," + entry.getValue().f9407c).getBytes("UTF-8"), this.f9400f)) + "\n");
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        String sb3 = sb2.toString();
        if (TextUtils.isEmpty(sb3)) {
            return;
        }
        com.autonavi.aps.amapapi.utils.j.a(this.f9396b, sb3);
    }

    public final void a() {
        Handler handler;
        if (!this.f9397c && (handler = this.f9399e) != null) {
            handler.removeCallbacks(this.f9402h);
            this.f9399e.postDelayed(this.f9402h, 60000L);
        }
        this.f9397c = true;
    }

    public final void a(boolean z10) {
        Handler handler = this.f9399e;
        if (handler != null) {
            handler.removeCallbacks(this.f9402h);
        }
        if (!z10) {
            this.f9402h.run();
        }
        this.f9397c = false;
    }

    public final void a(T t2) {
        b(t2, com.autonavi.aps.amapapi.utils.j.b());
    }

    public final void a(List<T> list) {
        long b4 = com.autonavi.aps.amapapi.utils.j.b();
        Iterator<T> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            b(iterator2.next(), b4);
        }
        if (this.f9398d.size() >= list.size()) {
            this.f9401g = true;
        }
        if (this.f9398d.size() > 16384 || c() <= 0) {
            this.f9398d.clear();
            for (T t2 : list) {
                this.f9398d.put(b((a<T>) t2), new C0111a(c((a<T>) t2), d((a<T>) t2), b4));
            }
        }
    }

    public final long e(T t2) {
        return (com.autonavi.aps.amapapi.utils.j.b() - d((a<T>) t2)) / 1000;
    }
}
