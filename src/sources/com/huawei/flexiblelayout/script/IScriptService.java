package com.huawei.flexiblelayout.script;

import androidx.annotation.Nullable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IScriptService {
    @Nullable
    IScriptContext acquireContext();

    @Nullable
    IScriptContext acquireContext(String str);

    void close();

    @Nullable
    IScriptContext findContext(String str);
}
