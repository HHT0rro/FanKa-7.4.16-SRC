package com.cupidapp.live.base.network;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.cupidapp.live.AppApplication;
import com.cupidapp.live.base.extension.NetworkStateConstants;
import com.cupidapp.live.base.safe.ImeiHelper;
import com.cupidapp.live.profile.model.User;
import com.tencent.vasdolly.helper.ChannelReaderUtil;
import java.util.Arrays;
import java.util.Locale;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import kotlin.text.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AppInfo.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static String f11905d;

    /* renamed from: n, reason: collision with root package name */
    @Nullable
    public static String f11915n;

    /* renamed from: o, reason: collision with root package name */
    @Nullable
    public static String f11916o;

    /* renamed from: p, reason: collision with root package name */
    @Nullable
    public static String f11917p;

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public static String f11918q;

    /* renamed from: r, reason: collision with root package name */
    @Nullable
    public static String f11919r;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f11902a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static String f11903b = "None";

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static String f11904c = "";

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static String f11906e = "";

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    public static String f11907f = "";

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public static String f11908g = "";

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public static String f11909h = "";

    /* renamed from: i, reason: collision with root package name */
    @NotNull
    public static String f11910i = "";

    /* renamed from: j, reason: collision with root package name */
    @NotNull
    public static String f11911j = "";

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public static String f11912k = "";

    /* renamed from: l, reason: collision with root package name */
    @NotNull
    public static String f11913l = "";

    /* renamed from: m, reason: collision with root package name */
    @NotNull
    public static String f11914m = "";

    /* compiled from: AppInfo.kt */
    @kotlin.d
    /* renamed from: com.cupidapp.live.base.network.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public /* synthetic */ class C0136a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f11920a;

        static {
            int[] iArr = new int[NetworkStateConstants.values().length];
            try {
                iArr[NetworkStateConstants.MOBILE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NetworkStateConstants.WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f11920a = iArr;
        }
    }

    @NotNull
    public final String a() {
        return f11904c;
    }

    public final String b(Context context) {
        String str;
        try {
            str = ChannelReaderUtil.getChannel(AppApplication.f11612d.h());
        } catch (Exception unused) {
            str = null;
        }
        String n10 = str == null ? z0.h.n(context) : str;
        String str2 = f11919r;
        com.cupidapp.live.base.utils.j.f12332a.a("AppInfo", "channel:" + str + "  name:" + n10 + "  humeChannel:" + str2);
        if (str2 == null || str2.length() == 0) {
            return n10;
        }
        return n10 + "_" + str2;
    }

    public final String c() {
        y yVar = y.f51038a;
        String MANUFACTURER = Build.MANUFACTURER;
        s.h(MANUFACTURER, "MANUFACTURER");
        String DEVICE = Build.DEVICE;
        s.h(DEVICE, "DEVICE");
        String BRAND = Build.BRAND;
        s.h(BRAND, "BRAND");
        String MODEL = Build.MODEL;
        s.h(MODEL, "MODEL");
        String format = String.format("(Android %d/%s; %s; %s; %s; %s; %s; %s/%s;)", Arrays.copyOf(new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Build.VERSION.RELEASE, p.n(MANUFACTURER), p.n(DEVICE), p.n(BRAND), p.n(MODEL), f11909h, 704160, f11908g}, 9));
        s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String d() {
        return f11912k;
    }

    @NotNull
    public final String e(@NotNull String str) {
        s.i(str, "<this>");
        String encodeToString = Base64.encodeToString(l1.a.c(str, "4503fb7f0f6ebe50"), 2);
        s.h(encodeToString, "encodeToString(this.aesE…6ebe50\"), Base64.NO_WRAP)");
        return encodeToString;
    }

    public final String f() {
        return e(f1.a.f49107a.a());
    }

    public final String g(Context context) {
        f11905d = z0.h.i(context);
        String encodeToString = Base64.encodeToString(l1.a.c(z0.h.i(context), "4503fb7f0f6ebe50"), 2);
        s.h(encodeToString, "encodeToString(context.g…6ebe50\"), Base64.NO_WRAP)");
        return encodeToString;
    }

    @NotNull
    public final String h() {
        return f11910i;
    }

    @NotNull
    public final String i() {
        if (f11907f.length() == 0) {
            return p();
        }
        return f11907f;
    }

    @NotNull
    public final String j() {
        return f11906e;
    }

    @Nullable
    public final String k() {
        String str = f11918q;
        if (str == null || str.length() == 0) {
            String m10 = m();
            if (m10 == null) {
                m10 = "";
            }
            f11918q = f1.c.a(m10);
        }
        return f11918q;
    }

    @Nullable
    public final String l() {
        return f11919r;
    }

    public final String m() {
        String str = f11917p;
        if (str == null || str.length() == 0) {
            f11917p = "Finka0a/7.4.16 " + c();
        }
        return f11917p;
    }

    @Nullable
    public final String n() {
        return f11905d;
    }

    @NotNull
    public final String o() {
        if (f11913l.length() == 0) {
            f11913l = z0.h.h();
        }
        return f11913l;
    }

    public final String p() {
        Locale locale = Locale.getDefault();
        y yVar = y.f51038a;
        String format = String.format("%s-%s", Arrays.copyOf(new Object[]{locale.getLanguage(), locale.getCountry()}, 2));
        s.h(format, "format(format, *args)");
        return format;
    }

    @NotNull
    public final String q() {
        return f11911j;
    }

    @NotNull
    public final String r() {
        return f11908g;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        if ((r0 == null || r0.length() == 0) != false) goto L16;
     */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String s() {
        /*
            r3 = this;
            java.lang.String r0 = r3.t()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L11
            int r0 = r0.length()
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r0 = 0
            goto L12
        L11:
            r0 = 1
        L12:
            if (r0 != 0) goto L21
            java.lang.String r0 = com.cupidapp.live.base.network.a.f11916o
            if (r0 == 0) goto L1e
            int r0 = r0.length()
            if (r0 != 0) goto L1f
        L1e:
            r1 = 1
        L1f:
            if (r1 == 0) goto L31
        L21:
            java.lang.String r0 = r3.m()
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "UTF-8"
            java.lang.String r0 = java.net.URLEncoder.encode(r0, r1)
            com.cupidapp.live.base.network.a.f11916o = r0
        L31:
            java.lang.String r0 = com.cupidapp.live.base.network.a.f11916o
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.base.network.a.s():java.lang.String");
    }

    @Nullable
    public final String t() {
        String str = f11915n;
        if (str == null || str.length() == 0) {
            User X = p1.g.f52734a.X();
            if (X != null) {
                return X.userId();
            }
            return null;
        }
        return f11915n;
    }

    public final void u(@NotNull Context context) {
        String networkOperatorName;
        String simOperatorName;
        s.i(context, "context");
        try {
            f11919r = p0.a.d(context);
            f11908g = b(context);
            x(z0.h.g(context));
            Object systemService = context.getSystemService("phone");
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManager != null && (simOperatorName = telephonyManager.getSimOperatorName()) != null) {
                f11914m = simOperatorName;
            }
            if (telephonyManager != null && (networkOperatorName = telephonyManager.getNetworkOperatorName()) != null) {
                f11909h = networkOperatorName;
            }
            f11904c = g(context);
            f11906e = f();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void v(@Nullable Context context) {
        if (context == null) {
            return;
        }
        ImeiHelper.f12176a.d(context);
        f11911j = z0.h.j(context);
        f11912k = z0.h.e();
    }

    public final void w(@NotNull String str) {
        s.i(str, "<set-?>");
        f11910i = str;
    }

    public final void x(NetworkStateConstants networkStateConstants) {
        int i10 = C0136a.f11920a[networkStateConstants.ordinal()];
        f11903b = i10 != 1 ? i10 != 2 ? "NONE" : "WIFI" : "WWAN";
    }
}
