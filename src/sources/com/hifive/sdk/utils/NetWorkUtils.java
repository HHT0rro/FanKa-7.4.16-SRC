package com.hifive.sdk.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.regex.Pattern;
import kotlin.TypeCastException;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NetWorkUtils.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class NetWorkUtils {
    public static final NetWorkUtils INSTANCE = new NetWorkUtils();

    private NetWorkUtils() {
    }

    public final boolean is3gConnected(@NotNull Context context) {
        s.j(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 0;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final boolean isNetWorkAvailable(@NotNull Context context) {
        s.j(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public final boolean isWifiConnected(@NotNull Context context) {
        s.j(context, "context");
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.getType() == 1;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    @NotNull
    public final String replaceBlank(@Nullable String str) {
        if (str == null) {
            return "";
        }
        String replaceAll = Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
        s.e(replaceAll, "m.replaceAll(\"\")");
        return replaceAll;
    }
}
