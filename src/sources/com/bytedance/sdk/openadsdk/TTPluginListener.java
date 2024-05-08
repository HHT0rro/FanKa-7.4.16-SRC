package com.bytedance.sdk.openadsdk;

import android.content.res.Resources;
import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface TTPluginListener {
    Bundle config();

    void onPluginListener(int i10, ClassLoader classLoader, Resources resources, Bundle bundle);

    String packageName();
}
