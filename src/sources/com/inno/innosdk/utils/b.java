package com.inno.innosdk.utils;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.huawei.appgallery.agd.common.utils.StringUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: AntiReptile.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static int f35563a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f35564b = null;

    /* renamed from: c, reason: collision with root package name */
    public static long f35565c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static String f35566d = "";

    /* renamed from: e, reason: collision with root package name */
    public Timer f35567e;

    /* renamed from: f, reason: collision with root package name */
    public Map<String, Long> f35568f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, Integer> f35569g;

    /* renamed from: h, reason: collision with root package name */
    public Map<String, Integer> f35570h;

    /* renamed from: i, reason: collision with root package name */
    public Map<String, Long> f35571i;

    /* renamed from: j, reason: collision with root package name */
    public Map<String, String> f35572j;

    /* renamed from: k, reason: collision with root package name */
    public long f35573k = 0;

    /* renamed from: l, reason: collision with root package name */
    public RelativeLayout f35574l;

    /* renamed from: m, reason: collision with root package name */
    public Activity f35575m;

    /* compiled from: AntiReptile.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f35576a;

        public a(String str) {
            this.f35576a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.f35569g.put(this.f35576a, 0);
            if (com.inno.innosdk.utils.a.f35558b.get() == null) {
                return;
            }
            b.this.a(com.inno.innosdk.utils.a.f35558b.get());
        }
    }

    /* compiled from: AntiReptile.java */
    /* renamed from: com.inno.innosdk.utils.b$b, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class C0348b extends TimerTask {

        /* compiled from: AntiReptile.java */
        /* renamed from: com.inno.innosdk.utils.b$b$a */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.d();
            }
        }

        public C0348b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                if (com.inno.innosdk.utils.a.f35558b.get() == null) {
                    return;
                }
                new Handler(com.inno.innosdk.utils.a.f35558b.get().getMainLooper()).post(new a());
                b.this.f35567e.cancel();
                b.this.f35567e = null;
            } catch (Throwable th) {
                com.inno.innosdk.utils.u.a.a(th);
            }
        }
    }

    public b() {
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Activity activity) {
    }

    public void c() {
        this.f35568f = new HashMap(16);
        this.f35569g = new HashMap(16);
        this.f35570h = new HashMap(16);
        this.f35571i = new HashMap(16);
        this.f35572j = new HashMap(16);
        this.f35570h.put(StringUtils.NO_PRINT_CODE, 100);
        this.f35571i.put(StringUtils.NO_PRINT_CODE, 30L);
        this.f35572j.put(StringUtils.NO_PRINT_CODE, "1");
    }

    public void d() {
        Activity activity;
        if (this.f35574l == null || (activity = this.f35575m) == null) {
            return;
        }
        ((ViewGroup) activity.getWindow().getDecorView()).removeView(this.f35574l);
        this.f35575m = null;
        this.f35574l = null;
    }

    public void e() {
        try {
            Timer timer = this.f35567e;
            if (timer != null) {
                timer.cancel();
                this.f35567e = null;
            }
            Timer timer2 = new Timer();
            this.f35567e = timer2;
            timer2.schedule(new C0348b(), 120000L);
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }

    public synchronized String b(String str) {
        try {
            String b4 = q.b(str);
            long b10 = b();
            String a10 = q.a();
            String c4 = c(b4);
            a(c4, b4);
            byte[] a11 = NativeUtils.a(b10, a10, c4, f35565c, b4);
            if (a11 != null && a11.length != 0) {
                String encodeToString = Base64.encodeToString(a11, 2);
                if (!TextUtils.isEmpty(encodeToString)) {
                    if (encodeToString.length() >= 10) {
                        return encodeToString;
                    }
                }
                return "-1";
            }
            return "unknown";
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "-2";
        }
    }

    public static b a() {
        if (f35564b == null) {
            synchronized (b.class) {
                if (f35564b == null) {
                    f35564b = new b();
                }
            }
        }
        return f35564b;
    }

    private String c(String str) {
        long longValue;
        if (f35563a == 0) {
            return "0";
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (this.f35568f.get(str) == null) {
            this.f35568f.put(str, Long.valueOf(currentTimeMillis));
            longValue = 0;
        } else {
            longValue = this.f35568f.get(str).longValue();
        }
        long intValue = this.f35570h.get(str) != null ? this.f35570h.get(str).intValue() : 0L;
        if (intValue == 0) {
            intValue = this.f35570h.get(StringUtils.NO_PRINT_CODE).intValue();
        }
        long longValue2 = this.f35571i.get(str) != null ? this.f35571i.get(str).longValue() : 0L;
        if (longValue2 == 0) {
            longValue2 = this.f35571i.get(StringUtils.NO_PRINT_CODE).longValue();
        }
        String str2 = this.f35572j.get(str) != null ? this.f35572j.get(str) : "";
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f35572j.get(StringUtils.NO_PRINT_CODE);
        }
        int i10 = 0;
        if (this.f35569g.get(str) == null) {
            this.f35569g.put(str, 0);
        }
        if (currentTimeMillis - longValue > longValue2) {
            this.f35568f.put(str, Long.valueOf(currentTimeMillis));
            this.f35569g.put(str, 0);
        } else {
            i10 = this.f35569g.get(str).intValue() + 1;
            this.f35569g.put(str, Integer.valueOf(i10));
        }
        f35565c++;
        return ((long) i10) > intValue ? str2 : "0";
    }

    public void a(String str, long j10, String str2) {
        this.f35573k = j10;
        f35566d = str2;
        String[] split = str.split("\\|");
        if (split.length > 0) {
            for (String str3 : split) {
                String[] split2 = str3.split(",");
                if (split2.length == 4) {
                    this.f35570h.put(split2[0], Integer.valueOf(Integer.parseInt(split2[2])));
                    this.f35571i.put(split2[0], Long.valueOf(Long.parseLong(split2[1])));
                    this.f35572j.put(split2[0], split2[3]);
                }
            }
        }
    }

    private long b() {
        return (System.currentTimeMillis() / 1000) + this.f35573k;
    }

    public String a(String str) {
        try {
            String b4 = q.b(str);
            long b10 = b();
            String a10 = q.a();
            String c4 = c(b4);
            a(c4, b4);
            byte[] a11 = NativeUtils.a(b10, a10, c4, f35565c, b4);
            if (a11 != null && a11.length != 0) {
                String encodeToString = Base64.encodeToString(a11, 2);
                return !TextUtils.isEmpty(encodeToString) ? encodeToString.length() < 10 ? "-1" : encodeToString : "-1";
            }
            return "unknown";
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
            return "-2";
        }
    }

    private void a(String str, String str2) {
        try {
            if (com.inno.innosdk.utils.a.f35558b == null) {
                return;
            }
            if (!(!TextUtils.isEmpty(f35566d) && (StringUtils.NO_PRINT_CODE.equals(f35566d) || f35566d.equals(str))) || com.inno.innosdk.utils.a.f35558b.get() == null) {
                return;
            }
            new Handler(com.inno.innosdk.utils.a.f35558b.get().getMainLooper()).post(new a(str2));
        } catch (Throwable th) {
            com.inno.innosdk.utils.u.a.a(th);
        }
    }
}
