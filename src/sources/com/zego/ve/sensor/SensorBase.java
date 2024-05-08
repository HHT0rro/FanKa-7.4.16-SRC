package com.zego.ve.sensor;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface SensorBase {
    int addNativeCallbackObj(long j10);

    int create(Context context);

    void destroy();

    int removeNativeCallbackObj(long j10);

    int start();

    void stop();
}
