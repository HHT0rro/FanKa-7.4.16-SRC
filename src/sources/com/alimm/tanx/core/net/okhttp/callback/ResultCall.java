package com.alimm.tanx.core.net.okhttp.callback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface ResultCall {
    void inProgress(float f10);

    void onAfter();

    void onBefore();

    void onError(int i10, String str);

    void onSuccess(String str);
}
