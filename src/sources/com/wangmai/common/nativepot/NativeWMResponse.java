package com.wangmai.common.nativepot;

import android.view.View;
import android.view.ViewGroup;
import com.wangmai.common.Ilistener.IWMAppDownloadListener;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface NativeWMResponse {
    void bindToAdContainer(ViewGroup viewGroup, View view);

    ViewGroup buildContainer(boolean z10);

    HtmlBean buildHtmlView();

    WMVideoBean buildVideoView(WMVideoOption wMVideoOption, WMVideoListener wMVideoListener);

    AdBaseInfo getBaseInfo();

    void notifyAdViewShow();

    void registerClickableViews(List<View> list);

    void setAppDownloadListener(IWMAppDownloadListener iWMAppDownloadListener);
}
