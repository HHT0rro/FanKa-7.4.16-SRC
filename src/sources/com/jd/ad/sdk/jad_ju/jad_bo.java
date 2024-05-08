package com.jd.ad.sdk.jad_ju;

import android.net.Uri;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_bo {
    public static boolean jad_an(int i10, int i11) {
        return i10 != Integer.MIN_VALUE && i11 != Integer.MIN_VALUE && i10 <= 512 && i11 <= 384;
    }

    public static boolean jad_an(Uri uri) {
        return uri != null && "content".equals(uri.getScheme()) && "media".equals(uri.getAuthority());
    }
}
