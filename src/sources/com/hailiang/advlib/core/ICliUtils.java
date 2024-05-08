package com.hailiang.advlib.core;

import android.os.Bundle;
import androidx.annotation.Keep;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ICliUtils {

    @Keep
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface BannerStateListener {
        void onADDeliveredResult(boolean z10, String str);

        void onADEventTriggered(int i10, Bundle bundle);

        void onADShown();
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface a {
        void a(ICliBundle iCliBundle);
    }
}
