package com.huawei.flexiblelayout.services.task;

import com.huawei.flexiblelayout.FLayout;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface TaskHandler {
    void execute(FLayout fLayout, int i10);

    Exception getException();

    boolean isCompleted();

    boolean isSuccessful();

    void repeat();
}
