package com.wangmai.common.Ibase;

import android.os.Bundle;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IBaseInterface<T> {
    String getCurrentVCode();

    int getECPM();

    String getRequestId();

    void sendLossNotificationWithInfo(Bundle bundle);

    void sendWinNotificationWithInfo(Bundle bundle);

    void setImplement(T t2);
}
