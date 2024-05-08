package com.alimm.tanx.core.ad.ad.feed;

import android.content.Context;
import android.view.View;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.view.TanxAdView;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ITanxFeedAd extends ITanxAd {
    public static final int ITEM_VIEW_TYPE_NORMAL = 0;
    public static final int ITEM_VIEW_TYPE_VERTICAL_PIC_AD = 5;
    public static final int ITEM_VIEW_TYPE_VIDEO = 4;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public interface DislikeOnClickListener {
        void onClick(View view);
    }

    void bindDislikeView(List<View> list, DislikeOnClickListener dislikeOnClickListener);

    void bindFeedAdView(TanxAdView tanxAdView, View view, ITanxFeedInteractionListener iTanxFeedInteractionListener);

    void click(TanxAdView tanxAdView);

    int getAdType();

    ITanxVideoView getITanxVideoView(Context context);
}
