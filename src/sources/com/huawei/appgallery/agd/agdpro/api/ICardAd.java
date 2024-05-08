package com.huawei.appgallery.agd.agdpro.api;

import com.huawei.appgallery.agd.core.impl.IAgdAd;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ICardAd extends IAgdAd {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface LoadListener {
        void onError(int i10, String str);
    }

    void setDislikeClickListener(DislikeClickListener dislikeClickListener);

    void setDownloadListener(AppDownloadListener appDownloadListener);

    void setVideoAdListener(VideoAdListener videoAdListener);
}
