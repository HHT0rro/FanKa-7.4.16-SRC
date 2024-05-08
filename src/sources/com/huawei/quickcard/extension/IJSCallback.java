package com.huawei.quickcard.extension;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IJSCallback {
    void apply(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object... objArr);

    void apply(@NonNull String str, @NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object... objArr);
}
