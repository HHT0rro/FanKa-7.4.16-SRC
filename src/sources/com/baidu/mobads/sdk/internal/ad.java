package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.api.BaiduNativeManager;
import com.baidu.mobads.sdk.api.NativeResponse;
import com.baidu.mobads.sdk.api.XAdNativeResponse;
import com.baidu.mobads.sdk.internal.f;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ad implements f.a {

    /* renamed from: a, reason: collision with root package name */
    private BaiduNativeManager.FeedAdListener f9754a;

    public ad(BaiduNativeManager.FeedAdListener feedAdListener) {
        this.f9754a = feedAdListener;
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(List<NativeResponse> list) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9754a;
        if (feedAdListener != null) {
            feedAdListener.onNativeLoad(list);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void b(int i10, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9754a;
        if (feedAdListener != null) {
            feedAdListener.onNativeFail(i10, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void c() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9754a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadFailed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(int i10, String str) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9754a;
        if (feedAdListener != null) {
            feedAdListener.onNoAd(i10, str);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void b(NativeResponse nativeResponse) {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9754a;
        if (feedAdListener != null && (feedAdListener instanceof BaiduNativeManager.PortraitVideoAdListener)) {
            ((BaiduNativeManager.PortraitVideoAdListener) feedAdListener).onAdClick();
        } else if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onAdClick();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(NativeResponse nativeResponse) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposed();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a(NativeResponse nativeResponse, int i10) {
        if (nativeResponse instanceof XAdNativeResponse) {
            ((XAdNativeResponse) nativeResponse).onADExposureFailed(i10);
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void b() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9754a;
        if (feedAdListener != null) {
            feedAdListener.onVideoDownloadSuccess();
        }
    }

    @Override // com.baidu.mobads.sdk.internal.f.a
    public void a() {
        BaiduNativeManager.FeedAdListener feedAdListener = this.f9754a;
        if (feedAdListener != null) {
            feedAdListener.onLpClosed();
        }
    }
}
