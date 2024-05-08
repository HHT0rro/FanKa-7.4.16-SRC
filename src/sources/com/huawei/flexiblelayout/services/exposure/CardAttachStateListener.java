package com.huawei.flexiblelayout.services.exposure;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.adapter.Visit;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface CardAttachStateListener {
    void onViewAttachedToWindow(@NonNull Visit visit);

    void onViewDetachedFromWindow(@NonNull Visit visit);
}
