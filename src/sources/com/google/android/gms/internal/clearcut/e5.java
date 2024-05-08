package com.google.android.gms.internal.clearcut;

import android.content.Context;
import com.google.android.gms.clearcut.a;
import com.google.android.gms.clearcut.zze;
import com.google.android.gms.internal.clearcut.v4;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class e5 implements a.b {

    /* renamed from: b, reason: collision with root package name */
    public static final Charset f23881b = Charset.forName("UTF-8");

    /* renamed from: c, reason: collision with root package name */
    public static final o f23882c;

    /* renamed from: d, reason: collision with root package name */
    public static final o f23883d;

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, e<v4>> f23884e;

    /* renamed from: f, reason: collision with root package name */
    public static final HashMap<String, e<String>> f23885f;

    /* renamed from: g, reason: collision with root package name */
    public static Boolean f23886g;

    /* renamed from: h, reason: collision with root package name */
    public static Long f23887h;

    /* renamed from: i, reason: collision with root package name */
    public static final e<Boolean> f23888i;

    /* renamed from: a, reason: collision with root package name */
    public final Context f23889a;

    static {
        o h10 = new o(m7.a.a("com.google.android.gms.clearcut.public")).f("gms:playlog:service:samplingrules_").h("LogSamplingRules__");
        f23882c = h10;
        f23883d = new o(m7.a.a("com.google.android.gms.clearcut.public")).f("gms:playlog:service:sampling_").h("LogSampling__");
        f23884e = new ConcurrentHashMap<>();
        f23885f = new HashMap<>();
        f23886g = null;
        f23887h = null;
        f23888i = h10.e("enable_log_sampling_rules", false);
    }

    public e5(Context context) {
        this.f23889a = context;
        if (context != null) {
            e.b(context);
        }
    }

    public static long b(String str, long j10) {
        if (str == null || str.isEmpty()) {
            return d5.c(ByteBuffer.allocate(8).putLong(j10).array());
        }
        byte[] bytes = str.getBytes(f23881b);
        ByteBuffer allocate = ByteBuffer.allocate(bytes.length + 8);
        allocate.put(bytes);
        allocate.putLong(j10);
        return d5.c(allocate.array());
    }

    public static v4.b c(String str) {
        String str2;
        if (str == null) {
            return null;
        }
        int indexOf = str.indexOf(44);
        int i10 = 0;
        if (indexOf >= 0) {
            i10 = indexOf + 1;
            str2 = str.substring(0, indexOf);
        } else {
            str2 = "";
        }
        int indexOf2 = str.indexOf(47, i10);
        if (indexOf2 <= 0) {
            if (str.length() != 0) {
                "Failed to parse the rule: ".concat(str);
            }
            return null;
        }
        try {
            long parseLong = Long.parseLong(str.substring(i10, indexOf2));
            long parseLong2 = Long.parseLong(str.substring(indexOf2 + 1));
            if (parseLong >= 0 && parseLong2 >= 0) {
                return v4.b.x().n(str2).o(parseLong).p(parseLong2).m();
            }
            StringBuilder sb2 = new StringBuilder(72);
            sb2.append("negative values not supported: ");
            sb2.append(parseLong);
            sb2.append("/");
            sb2.append(parseLong2);
            return null;
        } catch (NumberFormatException unused) {
            if (str.length() != 0) {
                "parseLong() failed while parsing: ".concat(str);
            }
            return null;
        }
    }

    public static boolean d(long j10, long j11, long j12) {
        if (j11 < 0 || j12 <= 0) {
            return true;
        }
        return ((j10 > 0L ? 1 : (j10 == 0L ? 0 : -1)) >= 0 ? j10 % j12 : (((Long.MAX_VALUE % j12) + 1) + ((j10 & Long.MAX_VALUE) % j12)) % j12) < j11;
    }

    public static boolean e(Context context) {
        if (f23886g == null) {
            f23886g = Boolean.valueOf(d7.b.a(context).a("com.google.android.providers.gsf.permission.READ_GSERVICES") == 0);
        }
        return f23886g.booleanValue();
    }

    public static long f(Context context) {
        if (f23887h == null) {
            if (context == null) {
                return 0L;
            }
            f23887h = Long.valueOf(e(context) ? k5.a(context.getContentResolver(), "android_id", 0L) : 0L);
        }
        return f23887h.longValue();
    }

    @Override // com.google.android.gms.clearcut.a.b
    public final boolean a(zze zzeVar) {
        List<v4.b> p10;
        e<v4> putIfAbsent;
        zzr zzrVar = zzeVar.f23345b;
        String str = zzrVar.f24156h;
        int i10 = zzrVar.f24152d;
        a5 a5Var = zzeVar.f23353j;
        int i11 = a5Var != null ? a5Var.f23793h : 0;
        String str2 = null;
        if (!f23888i.a().booleanValue()) {
            if (str == null || str.isEmpty()) {
                str = i10 >= 0 ? String.valueOf(i10) : null;
            }
            if (str == null) {
                return true;
            }
            Context context = this.f23889a;
            if (context != null && e(context)) {
                HashMap<String, e<String>> hashMap = f23885f;
                e<String> eVar = hashMap.get(str);
                if (eVar == null) {
                    eVar = f23883d.b(str, null);
                    hashMap.put(str, eVar);
                }
                str2 = eVar.a();
            }
            v4.b c4 = c(str2);
            if (c4 != null) {
                return d(b(c4.u(), f(this.f23889a)), c4.v(), c4.w());
            }
            return true;
        }
        if (str == null || str.isEmpty()) {
            str = i10 >= 0 ? String.valueOf(i10) : null;
        }
        if (str == null) {
            return true;
        }
        if (this.f23889a == null) {
            p10 = Collections.emptyList();
        } else {
            ConcurrentHashMap<String, e<v4>> concurrentHashMap = f23884e;
            e<v4> eVar2 = concurrentHashMap.get(str);
            if (eVar2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(str, (eVar2 = f23882c.a(str, v4.q(), f5.f23897a)))) != null) {
                eVar2 = putIfAbsent;
            }
            p10 = eVar2.a().p();
        }
        for (v4.b bVar : p10) {
            if (!bVar.t() || bVar.p() == 0 || bVar.p() == i11) {
                if (!d(b(bVar.u(), f(this.f23889a)), bVar.v(), bVar.w())) {
                    return false;
                }
            }
        }
        return true;
    }
}
