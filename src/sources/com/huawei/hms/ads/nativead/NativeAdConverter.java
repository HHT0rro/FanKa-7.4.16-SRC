package com.huawei.hms.ads.nativead;

import android.content.Context;
import com.huawei.hms.ads.annotation.GlobalApi;
import com.huawei.hms.ads.bt;
import com.huawei.openalliance.ad.inter.data.g;

@GlobalApi
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class NativeAdConverter {
    @GlobalApi
    public static NativeAd deserialization(Context context, String str) {
        return deserialization(context, str, null);
    }

    @GlobalApi
    public static NativeAd deserialization(Context context, String str, NativeAdConfiguration nativeAdConfiguration) {
        g Code = g.a.Code(str);
        if (Code == null) {
            return null;
        }
        bt btVar = new bt(context, Code);
        if (nativeAdConfiguration != null) {
            btVar.Code(nativeAdConfiguration);
        }
        return btVar;
    }

    @GlobalApi
    public static String serialization(NativeAd nativeAd) {
        if (nativeAd instanceof bt) {
            return g.a.Code(((bt) nativeAd).Code());
        }
        return null;
    }
}
