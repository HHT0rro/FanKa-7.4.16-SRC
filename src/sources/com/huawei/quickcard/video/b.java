package com.huawei.quickcard.video;

import com.kwad.sdk.core.response.model.SdkConfigData;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final StringBuilder f34322a;

    /* renamed from: b, reason: collision with root package name */
    private static final Formatter f34323b;

    static {
        StringBuilder sb2 = new StringBuilder();
        f34322a = sb2;
        f34323b = new Formatter(sb2, Locale.getDefault());
    }

    public static String a(int i10) {
        int i11 = i10 / 1000;
        int i12 = i11 % 60;
        int i13 = (i11 / 60) % 60;
        int i14 = i11 / SdkConfigData.DEFAULT_REQUEST_INTERVAL;
        f34322a.setLength(0);
        return i14 > 0 ? f34323b.format("%d:%02d:%02d", Integer.valueOf(i14), Integer.valueOf(i13), Integer.valueOf(i12)).toString() : f34323b.format("%02d:%02d", Integer.valueOf(i13), Integer.valueOf(i12)).toString();
    }
}
