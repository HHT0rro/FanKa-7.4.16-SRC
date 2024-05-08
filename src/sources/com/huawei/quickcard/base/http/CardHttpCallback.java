package com.huawei.quickcard.base.http;

import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;
import java.io.IOException;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface CardHttpCallback {
    void onFail(@NonNull IOException iOException);

    void onResponse(@NonNull CardHttpResponse cardHttpResponse);
}
