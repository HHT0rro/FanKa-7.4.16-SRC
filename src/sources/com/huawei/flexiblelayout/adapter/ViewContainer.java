package com.huawei.flexiblelayout.adapter;

import android.view.View;
import android.view.ViewGroup;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.data.FLDataGroup;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ViewContainer {
    View createView(FLContext fLContext, FLDataGroup.Cursor cursor, ViewGroup viewGroup);

    void setData(FLContext fLContext, FLDataGroup.Cursor cursor);

    void unsetData(FLContext fLContext);
}
