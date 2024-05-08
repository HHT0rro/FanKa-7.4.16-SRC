package com.huawei.quickcard.framework.processor;

import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.quickcard.base.annotation.DoNotShrink;

@DoNotShrink
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public interface EventProcessor<T extends View> {
    void applyEvent(@NonNull T t2, String str, String str2);

    void cleanEvent(@NonNull T t2, String str);
}
