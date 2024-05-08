package com.wangmai.common.Iinterface;

import android.content.Context;
import com.wangmai.common.Ibase.IBaseInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface InterstitialInterface extends IBaseInterface<InterstitialInterface> {
    void close();

    void destroy();

    boolean isReady();

    void load();

    void show(Context context);
}
