package com.huawei.hms.scankit.p;

import com.android.internal.logging.nano.MetricsProto;
import com.ss.android.socialbase.downloader.constants.DownloadErrorCode;
import java.util.Locale;

/* compiled from: SymbolInfo.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class d7 {

    /* renamed from: i, reason: collision with root package name */
    public static final d7[] f30865i;

    /* renamed from: j, reason: collision with root package name */
    private static d7[] f30866j;

    /* renamed from: a, reason: collision with root package name */
    private final boolean f30867a;

    /* renamed from: b, reason: collision with root package name */
    private final int f30868b;

    /* renamed from: c, reason: collision with root package name */
    private final int f30869c;

    /* renamed from: d, reason: collision with root package name */
    public final int f30870d;

    /* renamed from: e, reason: collision with root package name */
    public final int f30871e;

    /* renamed from: f, reason: collision with root package name */
    private final int f30872f;

    /* renamed from: g, reason: collision with root package name */
    private final int f30873g;

    /* renamed from: h, reason: collision with root package name */
    private final int f30874h;

    static {
        d7[] d7VarArr = {new d7(false, 3, 5, 8, 8, 1), new d7(false, 5, 7, 10, 10, 1), new d7(true, 5, 7, 16, 6, 1), new d7(false, 8, 10, 12, 12, 1), new d7(true, 10, 11, 14, 6, 2), new d7(false, 12, 12, 14, 14, 1), new d7(true, 16, 14, 24, 10, 1), new d7(false, 18, 14, 16, 16, 1), new d7(false, 22, 18, 18, 18, 1), new d7(true, 22, 18, 16, 10, 2), new d7(false, 30, 20, 20, 20, 1), new d7(true, 32, 24, 16, 14, 2), new d7(false, 36, 24, 22, 22, 1), new d7(false, 44, 28, 24, 24, 1), new d7(true, 49, 28, 22, 14, 2), new d7(false, 62, 36, 14, 14, 4), new d7(false, 86, 42, 16, 16, 4), new d7(false, 114, 48, 18, 18, 4), new d7(false, 144, 56, 20, 20, 4), new d7(false, 174, 68, 22, 22, 4), new d7(false, 204, 84, 24, 24, 4, 102, 42), new d7(false, 280, 112, 14, 14, 16, 140, 56), new d7(false, 368, 144, 16, 16, 16, 92, 36), new d7(false, MetricsProto.MetricsEvent.ACTION_APP_DISAMBIG_JUST_ONCE, 192, 18, 18, 16, 114, 48), new d7(false, MetricsProto.MetricsEvent.DIALOG_WIFI_P2P_CANCEL_CONNECT, 224, 20, 20, 16, 144, 56), new d7(false, MetricsProto.MetricsEvent.ACTION_PERMISSION_DENIED_PROCESS_OUTGOING_CALLS, 272, 22, 22, 16, 174, 68), new d7(false, MetricsProto.MetricsEvent.ACTION_THEME, 336, 24, 24, 16, 136, 56), new d7(false, DownloadErrorCode.ERROR_NO_SDCARD_PERMISSION, 408, 18, 18, 36, 175, 68), new d7(false, MetricsProto.MetricsEvent.FIELD_DURATION_MILLIS, 496, 20, 20, 36, 163, 62), new i1()};
        f30865i = d7VarArr;
        f30866j = d7VarArr;
    }

    public d7(boolean z10, int i10, int i11, int i12, int i13, int i14) {
        this(z10, i10, i11, i12, i13, i14, i10, i11);
    }

    public static d7 a(int i10, e7 e7Var, l2 l2Var, l2 l2Var2, boolean z10) {
        for (d7 d7Var : f30866j) {
            if (!(e7Var == e7.FORCE_SQUARE && d7Var.f30867a) && ((e7Var != e7.FORCE_RECTANGLE || d7Var.f30867a) && ((l2Var == null || (d7Var.h() >= l2Var.b() && d7Var.g() >= l2Var.a())) && ((l2Var2 == null || (d7Var.h() <= l2Var2.b() && d7Var.g() <= l2Var2.a())) && i10 <= d7Var.f30868b)))) {
                return d7Var;
            }
        }
        if (!z10) {
            return null;
        }
        try {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i10);
        } catch (Exception e2) {
            throw e2;
        }
    }

    private int c() {
        int i10 = this.f30872f;
        int i11 = 1;
        if (i10 != 1) {
            i11 = 2;
            if (i10 != 2 && i10 != 4) {
                if (i10 == 16) {
                    return 4;
                }
                if (i10 == 36) {
                    return 6;
                }
                try {
                    throw new IllegalStateException("Cannot handle this number of data regions");
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        return i11;
    }

    private int i() {
        int i10 = this.f30872f;
        if (i10 == 1 || i10 == 2) {
            return 1;
        }
        if (i10 == 4) {
            return 2;
        }
        if (i10 == 16) {
            return 4;
        }
        if (i10 == 36) {
            return 6;
        }
        try {
            throw new IllegalStateException("Cannot handle this number of data regions");
        } catch (Exception e2) {
            throw e2;
        }
    }

    public final int b() {
        return this.f30869c;
    }

    public int d() {
        return this.f30868b / this.f30873g;
    }

    public final int e() {
        return i() * this.f30871e;
    }

    public final int f() {
        return c() * this.f30870d;
    }

    public final int g() {
        return e() + (i() * 2);
    }

    public final int h() {
        return f() + (c() * 2);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f30867a ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.f30870d);
        sb2.append(Locale.PRIVATE_USE_EXTENSION);
        sb2.append(this.f30871e);
        sb2.append(", symbol size ");
        sb2.append(h());
        sb2.append(Locale.PRIVATE_USE_EXTENSION);
        sb2.append(g());
        sb2.append(", symbol data size ");
        sb2.append(f());
        sb2.append(Locale.PRIVATE_USE_EXTENSION);
        sb2.append(e());
        sb2.append(", codewords ");
        sb2.append(this.f30868b);
        sb2.append('+');
        sb2.append(this.f30869c);
        return sb2.toString();
    }

    public d7(boolean z10, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        this.f30867a = z10;
        this.f30868b = i10;
        this.f30869c = i11;
        this.f30870d = i12;
        this.f30871e = i13;
        this.f30872f = i14;
        this.f30873g = i15;
        this.f30874h = i16;
    }

    public final int b(int i10) {
        return this.f30874h;
    }

    public final int a() {
        return this.f30868b;
    }

    public int a(int i10) {
        return this.f30873g;
    }
}
