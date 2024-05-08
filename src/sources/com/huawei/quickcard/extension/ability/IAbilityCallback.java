package com.huawei.quickcard.extension.ability;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.extension.AsyncEnv;
import com.huawei.quickcard.extension.IJSCallback;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface IAbilityCallback extends IJSCallback {
    void cancel(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject);

    void complete(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object obj);

    void fail(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object obj, int i10);

    void success(@NonNull AsyncEnv asyncEnv, CardDataObject cardDataObject, Object obj);
}
