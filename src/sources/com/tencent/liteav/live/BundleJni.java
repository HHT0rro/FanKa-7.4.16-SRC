package com.tencent.liteav.live;

import android.os.Bundle;
import com.tencent.liteav.base.annotations.CalledByNative;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class BundleJni {
    @CalledByNative
    public static Bundle appendBoolean(Bundle bundle, String str, boolean z10) {
        bundle.putBoolean(str, z10);
        return bundle;
    }

    @CalledByNative
    public static Bundle appendBundle(Bundle bundle, String str, Bundle bundle2) {
        bundle.putBundle(str, bundle2);
        return bundle;
    }

    @CalledByNative
    public static Bundle appendByteArray(Bundle bundle, String str, byte[] bArr) {
        bundle.putByteArray(str, bArr);
        return bundle;
    }

    @CalledByNative
    public static Bundle appendDouble(Bundle bundle, String str, double d10) {
        bundle.putDouble(str, d10);
        return bundle;
    }

    @CalledByNative
    public static Bundle appendFloat(Bundle bundle, String str, float f10) {
        bundle.putFloat(str, f10);
        return bundle;
    }

    @CalledByNative
    public static Bundle appendInt(Bundle bundle, String str, int i10) {
        bundle.putInt(str, i10);
        return bundle;
    }

    @CalledByNative
    public static Bundle appendLong(Bundle bundle, String str, long j10) {
        bundle.putLong(str, j10);
        return bundle;
    }

    @CalledByNative
    public static Bundle appendString(Bundle bundle, String str, String str2) {
        bundle.putString(str, str2);
        return bundle;
    }

    @CalledByNative
    public static Bundle getBundle() {
        return new Bundle();
    }
}
