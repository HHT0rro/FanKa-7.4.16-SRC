package com.google.android.gms.clearcut;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import b7.f;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.internal.clearcut.a5;
import com.google.android.gms.internal.clearcut.c5;
import com.google.android.gms.internal.clearcut.e5;
import com.google.android.gms.internal.clearcut.l2;
import com.google.android.gms.internal.clearcut.zzge$zzv$zzb;
import com.google.android.gms.internal.clearcut.zzr;
import com.google.android.gms.phenotype.ExperimentTokens;
import java.util.ArrayList;
import java.util.TimeZone;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: n, reason: collision with root package name */
    public static final a.g<c5> f23308n;

    /* renamed from: o, reason: collision with root package name */
    public static final a.AbstractC0213a<c5, Object> f23309o;

    /* renamed from: p, reason: collision with root package name */
    @Deprecated
    public static final com.google.android.gms.common.api.a<Object> f23310p;

    /* renamed from: q, reason: collision with root package name */
    public static final ExperimentTokens[] f23311q;

    /* renamed from: r, reason: collision with root package name */
    public static final String[] f23312r;

    /* renamed from: s, reason: collision with root package name */
    public static final byte[][] f23313s;

    /* renamed from: a, reason: collision with root package name */
    public final Context f23314a;

    /* renamed from: b, reason: collision with root package name */
    public final String f23315b;

    /* renamed from: c, reason: collision with root package name */
    public final int f23316c;

    /* renamed from: d, reason: collision with root package name */
    public String f23317d;

    /* renamed from: e, reason: collision with root package name */
    public int f23318e;

    /* renamed from: f, reason: collision with root package name */
    public String f23319f;

    /* renamed from: g, reason: collision with root package name */
    public String f23320g;

    /* renamed from: h, reason: collision with root package name */
    public final boolean f23321h;

    /* renamed from: i, reason: collision with root package name */
    public zzge$zzv$zzb f23322i;

    /* renamed from: j, reason: collision with root package name */
    public final t6.b f23323j;

    /* renamed from: k, reason: collision with root package name */
    public final b7.d f23324k;

    /* renamed from: l, reason: collision with root package name */
    public d f23325l;

    /* renamed from: m, reason: collision with root package name */
    public final b f23326m;

    /* renamed from: com.google.android.gms.clearcut.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public class C0211a {

        /* renamed from: a, reason: collision with root package name */
        public int f23327a;

        /* renamed from: b, reason: collision with root package name */
        public String f23328b;

        /* renamed from: c, reason: collision with root package name */
        public String f23329c;

        /* renamed from: d, reason: collision with root package name */
        public String f23330d;

        /* renamed from: e, reason: collision with root package name */
        public zzge$zzv$zzb f23331e;

        /* renamed from: f, reason: collision with root package name */
        public final c f23332f;

        /* renamed from: g, reason: collision with root package name */
        public ArrayList<Integer> f23333g;

        /* renamed from: h, reason: collision with root package name */
        public ArrayList<String> f23334h;

        /* renamed from: i, reason: collision with root package name */
        public ArrayList<Integer> f23335i;

        /* renamed from: j, reason: collision with root package name */
        public ArrayList<ExperimentTokens> f23336j;

        /* renamed from: k, reason: collision with root package name */
        public ArrayList<byte[]> f23337k;

        /* renamed from: l, reason: collision with root package name */
        public boolean f23338l;

        /* renamed from: m, reason: collision with root package name */
        public final a5 f23339m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f23340n;

        public C0211a(a aVar, byte[] bArr) {
            this(bArr, (c) null);
        }

        public C0211a(byte[] bArr, c cVar) {
            this.f23327a = a.this.f23318e;
            this.f23328b = a.this.f23317d;
            this.f23329c = a.this.f23319f;
            this.f23330d = null;
            this.f23331e = a.this.f23322i;
            this.f23333g = null;
            this.f23334h = null;
            this.f23335i = null;
            this.f23336j = null;
            this.f23337k = null;
            this.f23338l = true;
            a5 a5Var = new a5();
            this.f23339m = a5Var;
            this.f23340n = false;
            this.f23329c = a.this.f23319f;
            this.f23330d = null;
            a5Var.B = com.google.android.gms.internal.clearcut.a.a(a.this.f23314a);
            a5Var.f23789d = a.this.f23324k.b();
            a5Var.f23790e = a.this.f23324k.a();
            d unused = a.this.f23325l;
            a5Var.f23805t = TimeZone.getDefault().getOffset(a5Var.f23789d) / 1000;
            if (bArr != null) {
                a5Var.f23800o = bArr;
            }
            this.f23332f = null;
        }

        public /* synthetic */ C0211a(a aVar, byte[] bArr, t6.a aVar2) {
            this(aVar, bArr);
        }

        public void a() {
            if (this.f23340n) {
                throw new IllegalStateException("do not reuse LogEventBuilder");
            }
            this.f23340n = true;
            zze zzeVar = new zze(new zzr(a.this.f23315b, a.this.f23316c, this.f23327a, this.f23328b, this.f23329c, this.f23330d, a.this.f23321h, this.f23331e), this.f23339m, null, null, a.g(null), null, a.g(null), null, null, this.f23338l);
            if (a.this.f23326m.a(zzeVar)) {
                a.this.f23323j.a(zzeVar);
            } else {
                u6.b.a(Status.f23378g, null);
            }
        }

        public C0211a b(int i10) {
            this.f23339m.f23793h = i10;
            return this;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface b {
        boolean a(zze zzeVar);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        byte[] zza();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class d {
    }

    static {
        a.g<c5> gVar = new a.g<>();
        f23308n = gVar;
        t6.a aVar = new t6.a();
        f23309o = aVar;
        f23310p = new com.google.android.gms.common.api.a<>("ClearcutLogger.API", aVar, gVar);
        f23311q = new ExperimentTokens[0];
        f23312r = new String[0];
        f23313s = new byte[0];
    }

    public a(Context context, int i10, String str, String str2, String str3, boolean z10, t6.b bVar, b7.d dVar, d dVar2, b bVar2) {
        this.f23318e = -1;
        zzge$zzv$zzb zzge_zzv_zzb = zzge$zzv$zzb.DEFAULT;
        this.f23322i = zzge_zzv_zzb;
        this.f23314a = context;
        this.f23315b = context.getPackageName();
        this.f23316c = c(context);
        this.f23318e = -1;
        this.f23317d = str;
        this.f23319f = str2;
        this.f23320g = null;
        this.f23321h = z10;
        this.f23323j = bVar;
        this.f23324k = dVar;
        this.f23325l = new d();
        this.f23322i = zzge_zzv_zzb;
        this.f23326m = bVar2;
        if (z10) {
            h.b(str2 == null, "can't be anonymous with an upload account");
        }
    }

    public a(Context context, String str, String str2) {
        this(context, -1, str, str2, null, false, l2.l(context), f.c(), null, new e5(context));
    }

    public static a a(Context context, String str) {
        return new a(context, -1, str, null, null, true, l2.l(context), f.c(), null, new e5(context));
    }

    public static int c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.wtf("ClearcutLogger", "This can't happen.", e2);
            return 0;
        }
    }

    public static int[] e(ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        int i10 = 0;
        int i11 = 0;
        while (i10 < size) {
            Integer num = arrayList.get(i10);
            i10++;
            iArr[i11] = num.intValue();
            i11++;
        }
        return iArr;
    }

    public static /* synthetic */ int[] g(ArrayList arrayList) {
        return e(null);
    }

    public final C0211a b(byte[] bArr) {
        return new C0211a(this, bArr, (t6.a) null);
    }
}
