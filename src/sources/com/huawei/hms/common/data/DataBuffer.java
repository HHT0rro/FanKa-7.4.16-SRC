package com.huawei.hms.common.data;

import android.os.Bundle;
import com.huawei.hms.common.api.Releasable;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface DataBuffer<T> extends Releasable, Iterable<T> {
    @Deprecated
    void close();

    T get(int i10);

    int getCount();

    Bundle getMetadata();

    @Deprecated
    boolean isClosed();

    /* renamed from: iterator */
    Iterator<T> iterator2();

    @Override // com.huawei.hms.common.api.Releasable
    void release();

    Iterator<T> singleRefIterator();
}
