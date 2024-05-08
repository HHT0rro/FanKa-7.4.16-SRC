package io.reactivex.internal.disposables;

import io.reactivex.annotations.Experimental;
import io.reactivex.disposables.Disposable;

@Experimental
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface ResettableConnectable {
    void resetIf(Disposable disposable);
}
