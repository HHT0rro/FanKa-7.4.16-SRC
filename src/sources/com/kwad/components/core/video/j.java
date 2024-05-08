package com.kwad.components.core.video;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ad;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class j {
    private static Map<String, Integer> UY = new ConcurrentHashMap();

    public static boolean a(@NonNull String str, String str2, a.C0527a c0527a) {
        String bu = ad.bu(str2);
        long currentTimeMillis = System.currentTimeMillis();
        com.kwad.sdk.core.e.c.i("VideoCacheHelper", "start cache video key:" + bu + "--url:" + str);
        boolean b4 = com.kwad.sdk.core.diskcache.b.a.Dc().b(str, str2, c0527a);
        com.kwad.sdk.core.e.c.i("VideoCacheHelper", "finish cache video key:" + bu + "--cache time:" + (System.currentTimeMillis() - currentTimeMillis) + "--success:" + b4);
        return b4;
    }

    private static int aE(String str) {
        Integer num = UY.get(str);
        if (num != null) {
            return num.intValue();
        }
        return com.kwad.sdk.core.config.d.yU();
    }

    public static boolean ax(@NonNull AdTemplate adTemplate) {
        File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
        return bV != null && bV.exists();
    }

    public static String f(Context context, @NonNull AdTemplate adTemplate) {
        return a(context, com.kwad.sdk.core.response.b.e.eg(adTemplate), com.kwad.sdk.core.response.b.a.K(com.kwad.sdk.core.response.b.e.dQ(adTemplate)));
    }

    public static void n(String str, int i10) {
        UY.put(str, Integer.valueOf(i10));
    }

    public static String f(Context context, String str) {
        return a(context, aE(str), str);
    }

    private static String a(Context context, int i10, String str) {
        if (i10 >= 0) {
            return i10 > 0 ? com.kwad.sdk.core.videocache.c.a.bl(context).eA(str) : str;
        }
        File bV = com.kwad.sdk.core.diskcache.b.a.Dc().bV(str);
        return (bV == null || !bV.exists()) ? str : bV.getAbsolutePath();
    }
}
