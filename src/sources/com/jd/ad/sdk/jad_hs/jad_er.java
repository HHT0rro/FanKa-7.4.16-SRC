package com.jd.ad.sdk.jad_hs;

import androidx.annotation.Nullable;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class jad_er extends IOException {
    public jad_er(String str, int i10, @Nullable Throwable th) {
        super(str + ", status code: " + i10, th);
    }
}
