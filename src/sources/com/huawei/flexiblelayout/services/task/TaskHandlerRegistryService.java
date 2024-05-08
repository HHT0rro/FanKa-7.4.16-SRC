package com.huawei.flexiblelayout.services.task;

import com.huawei.flexiblelayout.data.primitive.FLMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface TaskHandlerRegistryService {
    TaskHandler create(String str, FLMap fLMap);

    void register(String str, Class<? extends TaskHandler> cls);
}
