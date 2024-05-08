package com.huawei.quickcard.extension.global.api;

import androidx.annotation.Nullable;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IJsFunction {
    void clearAllInterval();

    void clearAllTimeout();

    void clearInterval(int i10);

    void clearTimeout(int i10);

    Object getElementById(@Nullable String str);

    Object getLangDir(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3);

    long getTime();

    boolean isNotNull(@Nullable Object obj);

    Object requireModule(@Nullable String str);

    int setInterval(Object obj, Object obj2);

    void setMediaTheme(Object obj, Object obj2);

    int setTimeout(Object obj, Object obj2);
}
