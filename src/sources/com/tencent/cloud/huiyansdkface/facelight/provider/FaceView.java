package com.tencent.cloud.huiyansdkface.facelight.provider;

import android.graphics.RectF;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface FaceView {
    void onUpdateErrorTip(String str);

    void onUpdateErrorTipTextColor(int i10);

    void onUpdateFaceBorder(int i10);

    void onUpdateLongTipVisibility(int i10);

    void onUpdateNetworkRetry();

    void onUpdateRealFaceRect(RectF rectF);

    void onUpdateTip(String str);

    void onUpdateTipTextColor(int i10);
}
