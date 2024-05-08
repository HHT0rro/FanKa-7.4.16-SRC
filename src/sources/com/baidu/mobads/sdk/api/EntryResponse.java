package com.baidu.mobads.sdk.api;

import android.view.View;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface EntryResponse {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface EntryAdInteractionListener {
        void onADExposed();

        void onADExposureFailed(int i10);

        void onAdClick();

        void onAdUnionClick();
    }

    String getAdLogoUrl();

    String getBaiduLogoUrl();

    String getTitle();

    boolean isAdAvailable();

    void registerViewForInteraction(View view, List<View> list, List<View> list2, EntryAdInteractionListener entryAdInteractionListener);

    void unionLogoClick();
}
