package com.huawei.appgallery.agd.agdpro.api;

import android.view.View;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface InteractionListener {
    void onAdClicked(View view);

    void onAdShow(View view);

    void onRenderFail(View view, int i10, String str);

    void onRenderSuccess(View view, float f10, float f11);
}
