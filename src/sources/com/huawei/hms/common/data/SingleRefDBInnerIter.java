package com.huawei.hms.common.data;

import com.huawei.hms.common.internal.Preconditions;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class SingleRefDBInnerIter<T> extends DBInnerIter<T> {
    public SingleRefDBInnerIter(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    @Override // com.huawei.hms.common.data.DBInnerIter, java.util.Iterator
    public T next() {
        if (!hasNext()) {
            return null;
        }
        int i10 = this.index + 1;
        this.index = i10;
        if (i10 == 0) {
            Preconditions.checkState(this.dataBuffer.get(0) instanceof DataBufferRef, "DataBuffer reference of type " + ((Object) this.dataBuffer.get(0).getClass()) + " is not movable");
            ((DataBufferRef) this.dataBuffer.get(0)).getWindowIndex(this.index);
        }
        return (T) this.dataBuffer.get(0);
    }
}
