package com.cupidapp.live.base.safe;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.Base64;
import androidx.core.content.ContextCompat;
import com.cupidapp.live.base.network.NetworkClient;
import com.cupidapp.live.base.network.ObservableExtensionKt$handle$disposed$2;
import com.cupidapp.live.base.network.i;
import com.cupidapp.live.base.utils.j;
import com.kuaishou.weapon.p0.g;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.f;
import p1.l;

/* compiled from: ImeiHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ImeiHelper {

    /* renamed from: d, reason: collision with root package name */
    @Nullable
    public static String f12179d;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ImeiHelper f12176a = new ImeiHelper();

    /* renamed from: b, reason: collision with root package name */
    public static boolean f12177b = true;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public static final p1.a<String> f12178c = new p1.a<>(new f("FINKA_ENCODE_IMEI", new l()));

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    public static String f12180e = "";

    public final boolean a(Context context) {
        return ContextCompat.checkSelfPermission(context, g.f36117c) == 0;
    }

    public final void b(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return;
        }
        if ((str == null || str.length() == 0) || !s.d(str, str2)) {
            Disposable disposed = NetworkClient.f11868a.I().b(c(str2), com.cupidapp.live.base.network.a.f11902a.o()).flatMap(new i()).observeOn(AndroidSchedulers.mainThread()).subscribe(new com.cupidapp.live.base.network.e(new Function1<Object, p>() { // from class: com.cupidapp.live.base.safe.ImeiHelper$checkUpdateImeiValueToService$$inlined$handle$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(Object obj) {
                    invoke2(obj);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    j.f12332a.a("ImeiHelper", "UpdateImeiValueToService succeed");
                }
            }), new com.cupidapp.live.base.network.e(new ObservableExtensionKt$handle$disposed$2(new Function1<Throwable, Boolean>() { // from class: com.cupidapp.live.base.safe.ImeiHelper$checkUpdateImeiValueToService$2
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull Throwable it) {
                    s.i(it, "it");
                    j.f12332a.a("ImeiHelper", "UpdateImeiValueToService failed");
                    return Boolean.TRUE;
                }
            }, null)));
            if (disposed != null) {
                s.h(disposed, "disposed");
            }
            s.h(disposed, "disposed");
        }
    }

    public final String c(String str) {
        String encodeToString = Base64.encodeToString(l1.a.c(str, "4503fb7f0f6ebe50"), 2);
        s.h(encodeToString, "encodeToString(imei.aesE…6ebe50\"), Base64.NO_WRAP)");
        return encodeToString;
    }

    public final void d(@NotNull Context context) {
        String deviceId;
        s.i(context, "context");
        Object systemService = context.getSystemService("phone");
        String str = null;
        TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
        try {
            boolean a10 = a(context);
            j.f12332a.a("ImeiHelper", "获取IMEI权限是否允许:" + a10);
            if (a10) {
                int i10 = Build.VERSION.SDK_INT;
                if (i10 >= 28) {
                    str = "";
                } else {
                    if (i10 >= 26) {
                        if (telephonyManager != null) {
                            deviceId = telephonyManager.getImei();
                        }
                    } else if (telephonyManager != null) {
                        deviceId = telephonyManager.getDeviceId();
                    }
                    str = deviceId;
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        f12179d = str;
        String c4 = str == null || str.length() == 0 ? "" : c(str);
        j.f12332a.a("ImeiHelper", "imei:" + str + "  encodeImei:" + c4);
        b(f12178c.c(), c4);
        if (c4.length() > 0) {
            g(c4);
        }
    }

    @NotNull
    public final String e() {
        if ((f12180e.length() == 0) && f12177b) {
            f12177b = false;
            String c4 = f12178c.c();
            if (c4 == null) {
                c4 = "";
            }
            f12180e = c4;
        }
        return f12180e;
    }

    @Nullable
    public final String f() {
        return f12179d;
    }

    public final void g(@NotNull String value) {
        s.i(value, "value");
        f12180e = value;
        f12178c.d(value);
    }
}
