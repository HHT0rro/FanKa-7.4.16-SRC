package com.huawei.hmf.services.inject;

import com.huawei.hmf.services.Module;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface InjectInstanceCreator<T> {
    T createInstance(Module module, String str);
}
