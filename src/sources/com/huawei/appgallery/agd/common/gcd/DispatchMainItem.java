package com.huawei.appgallery.agd.common.gcd;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DispatchMainItem {

    /* renamed from: a, reason: collision with root package name */
    public static Handler f27341a = new Handler(Looper.getMainLooper());

    public void excute(DispatchBlock dispatchBlock) {
        Message obtain = Message.obtain(f27341a, dispatchBlock);
        obtain.what = 1;
        obtain.sendToTarget();
    }
}
