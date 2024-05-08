package com.huawei.pnodesupport.api;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLPNodeData;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicator;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface FLPNodeDelegate {
    @Nullable
    HwDotsPageIndicator createIndicator(@NonNull FLContext fLContext);

    @Nullable
    HwViewPager createViewPager(@NonNull FLContext fLContext, @NonNull FLPNodeData fLPNodeData);

    void onViewPagerCreated(@NonNull HwViewPager hwViewPager, @NonNull FLPNodeData fLPNodeData, @NonNull FLPNodeParam fLPNodeParam);
}
