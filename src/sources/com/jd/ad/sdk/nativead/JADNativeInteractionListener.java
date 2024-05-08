package com.jd.ad.sdk.nativead;

import android.view.View;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface JADNativeInteractionListener {
    void onClick(View view);

    void onClose(@Nullable View view);

    void onExposure();
}
