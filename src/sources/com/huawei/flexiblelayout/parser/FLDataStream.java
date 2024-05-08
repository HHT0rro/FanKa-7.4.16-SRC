package com.huawei.flexiblelayout.parser;

import com.huawei.flexiblelayout.data.FLDataSource;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface FLDataStream {
    public static final int INVALID_COMBO_CARD = 2;
    public static final int INVALID_DATA = 1;
    public static final int OK = 0;

    void apply(FLDataSource fLDataSource);

    void apply(FLDataSource fLDataSource, boolean z10);

    int getResult();

    @Deprecated
    DataItem getRoot();

    void setResult(int i10);
}
