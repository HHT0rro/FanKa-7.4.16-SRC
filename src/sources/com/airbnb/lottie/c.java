package com.airbnb.lottie;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import java.io.File;

/* compiled from: L.java */
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f1878a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f1879b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f1880c = true;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f1881d = true;

    /* renamed from: e, reason: collision with root package name */
    public static String[] f1882e;

    /* renamed from: f, reason: collision with root package name */
    public static long[] f1883f;

    /* renamed from: g, reason: collision with root package name */
    public static int f1884g;

    /* renamed from: h, reason: collision with root package name */
    public static int f1885h;

    /* renamed from: i, reason: collision with root package name */
    public static l.c f1886i;

    /* renamed from: j, reason: collision with root package name */
    public static l.b f1887j;

    /* renamed from: k, reason: collision with root package name */
    public static volatile l.e f1888k;

    /* renamed from: l, reason: collision with root package name */
    public static volatile l.d f1889l;

    /* compiled from: L.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a implements l.b {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f1890a;

        public a(Context context) {
            this.f1890a = context;
        }

        @Override // l.b
        @NonNull
        public File a() {
            return new File(this.f1890a.getCacheDir(), "lottie_network_cache");
        }
    }

    public static void a(String str) {
        if (f1879b) {
            int i10 = f1884g;
            if (i10 == 20) {
                f1885h++;
                return;
            }
            f1882e[i10] = str;
            f1883f[i10] = System.nanoTime();
            TraceCompat.beginSection(str);
            f1884g++;
        }
    }

    public static float b(String str) {
        int i10 = f1885h;
        if (i10 > 0) {
            f1885h = i10 - 1;
            return 0.0f;
        }
        if (!f1879b) {
            return 0.0f;
        }
        int i11 = f1884g - 1;
        f1884g = i11;
        if (i11 != -1) {
            if (str.equals(f1882e[i11])) {
                TraceCompat.endSection();
                return ((float) (System.nanoTime() - f1883f[f1884g])) / 1000000.0f;
            }
            throw new IllegalStateException("Unbalanced trace call " + str + ". Expected " + f1882e[f1884g] + ".");
        }
        throw new IllegalStateException("Can't end trace section. There are none.");
    }

    public static boolean c() {
        return f1881d;
    }

    @Nullable
    public static l.d d(@NonNull Context context) {
        if (!f1880c) {
            return null;
        }
        Context applicationContext = context.getApplicationContext();
        l.d dVar = f1889l;
        if (dVar == null) {
            synchronized (l.d.class) {
                dVar = f1889l;
                if (dVar == null) {
                    l.b bVar = f1887j;
                    if (bVar == null) {
                        bVar = new a(applicationContext);
                    }
                    dVar = new l.d(bVar);
                    f1889l = dVar;
                }
            }
        }
        return dVar;
    }

    @NonNull
    public static l.e e(@NonNull Context context) {
        l.e eVar = f1888k;
        if (eVar == null) {
            synchronized (l.e.class) {
                eVar = f1888k;
                if (eVar == null) {
                    l.d d10 = d(context);
                    l.c cVar = f1886i;
                    if (cVar == null) {
                        cVar = new l.a();
                    }
                    eVar = new l.e(d10, cVar);
                    f1888k = eVar;
                }
            }
        }
        return eVar;
    }
}
