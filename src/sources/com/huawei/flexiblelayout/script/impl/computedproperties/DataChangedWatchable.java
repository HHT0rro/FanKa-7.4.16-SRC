package com.huawei.flexiblelayout.script.impl.computedproperties;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DataChangedWatchable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface DataChangedListener {
        void onDataChanged(@NonNull Object obj, @NonNull String str, @Nullable Object obj2, @Nullable Object obj3);
    }

    void addListener(@NonNull DataChangedListener dataChangedListener);

    void removeListener(@NonNull DataChangedListener dataChangedListener);
}
