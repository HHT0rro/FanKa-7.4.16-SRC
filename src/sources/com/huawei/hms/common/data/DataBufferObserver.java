package com.huawei.hms.common.data;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface DataBufferObserver {
    void onDataChanged();

    void onDataRangeChanged(int i10, int i11);

    void onDataRangeInserted(int i10, int i11);

    void onDataRangeMoved(int i10, int i11, int i12);

    void onDataRangeRemoved(int i10, int i11);
}
