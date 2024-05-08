package com.baidu.mobads.sdk.api;

import android.app.Fragment;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface CPUComponent {
    void destroy();

    @Nullable
    Fragment getFragment();

    @Nullable
    androidx.fragment.app.Fragment getSupportFragment();

    void refresh();
}
