package com.huawei.quickcard.elexecutor;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collection;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IExpressionContext {
    Object callFunction(String str, Object... objArr);

    void close();

    void create(@NonNull String str);

    Object evaluate(@NonNull String str);

    Object evaluate(@NonNull String str, @Nullable Collection<String> collection, @Nullable Collection<String> collection2);

    Object[] evaluate(@NonNull String[] strArr);

    Object get(String str);

    int getId();

    void set(String str, Object obj);
}
