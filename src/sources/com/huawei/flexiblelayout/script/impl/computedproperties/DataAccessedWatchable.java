package com.huawei.flexiblelayout.script.impl.computedproperties;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface DataAccessedWatchable {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface DataAccessedListener {
        void onDataAccessed(@NonNull Object obj, @NonNull String str, @Nullable Object obj2);
    }

    void addListener(@NonNull DataAccessedListener dataAccessedListener);

    void removeListener(@NonNull DataAccessedListener dataAccessedListener);
}
