package com.wangmai.common.Iinterface;

import android.view.ViewGroup;
import com.wangmai.common.Ibase.IBaseInterface;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface IPatchInterface extends IBaseInterface<IPatchInterface> {
    void destroy();

    long getCurrentPosition();

    long getDuration();

    void show(ViewGroup viewGroup);
}
