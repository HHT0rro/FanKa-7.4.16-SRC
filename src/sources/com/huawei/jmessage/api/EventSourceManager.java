package com.huawei.jmessage.api;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface EventSourceManager {
    <T extends EventSource> T findEventSource(String str);

    <T extends EventSource> void register(@NonNull String str, T t2);

    void register(@NonNull String str, Class<? extends EventSource> cls);

    void unregister(@NonNull String str);
}
