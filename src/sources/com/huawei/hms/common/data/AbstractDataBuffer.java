package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.support.api.client.Result;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class AbstractDataBuffer<T> extends Result implements DataBuffer<T> {
    public final DataHolder mDataHolder;

    public AbstractDataBuffer(DataHolder dataHolder) {
        this.mDataHolder = dataHolder;
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    @Deprecated
    public final void close() {
        release();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public abstract T get(int i10);

    @Override // com.huawei.hms.common.data.DataBuffer
    public int getCount() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return 0;
        }
        return dataHolder.getCount();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public Bundle getMetadata() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return null;
        }
        return dataHolder.getMetadata();
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    @Deprecated
    public boolean isClosed() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder == null) {
            return true;
        }
        return dataHolder.isClosed();
    }

    @Override // com.huawei.hms.common.data.DataBuffer, java.lang.Iterable
    /* renamed from: iterator */
    public Iterator<T> iterator2() {
        return new DBInnerIter(this);
    }

    @Override // com.huawei.hms.common.data.DataBuffer, com.huawei.hms.common.api.Releasable
    public void release() {
        DataHolder dataHolder = this.mDataHolder;
        if (dataHolder != null) {
            dataHolder.close();
        }
    }

    @Override // com.huawei.hms.common.data.DataBuffer
    public Iterator<T> singleRefIterator() {
        return new SingleRefDBInnerIter(this);
    }
}
