package com.huawei.quickcard;

import android.content.res.Configuration;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.huawei.quickcard.framework.touch.ITouchEventManager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface QuickCardRoot {
    @NonNull
    Configuration getCardConfiguration();

    ViewGroup getRootViewGroup();

    ITouchEventManager getTouchEventManager();
}
