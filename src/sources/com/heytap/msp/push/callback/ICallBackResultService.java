package com.heytap.msp.push.callback;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ICallBackResultService {
    void onGetNotificationStatus(int i10, int i11);

    void onGetPushStatus(int i10, int i11);

    void onRegister(int i10, String str);

    void onSetPushTime(int i10, String str);

    void onUnRegister(int i10);
}
