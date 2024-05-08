package com.huawei.flexiblelayout.script;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.jslite.type.CoerceJavaScriptToJava;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface IScriptContext {
    @Nullable
    Object callFunction(@NonNull String str, Object... objArr);

    @Nullable
    Object evaluate(@NonNull String str);

    @Nullable
    <T> T evaluate(@NonNull String str, Class<T> cls);

    @Nullable
    Object get(@NonNull String str);

    boolean isClosed();

    void release();

    void set(@NonNull String str, @Nullable Object obj);

    void setCoerceJavaScriptToJava(@Nullable CoerceJavaScriptToJava coerceJavaScriptToJava);
}
