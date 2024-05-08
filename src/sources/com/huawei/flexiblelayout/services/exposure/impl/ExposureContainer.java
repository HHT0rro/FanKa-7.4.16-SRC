package com.huawei.flexiblelayout.services.exposure.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.adapter.Visit;
import com.huawei.flexiblelayout.services.exposure.CardAttachStateOwner;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public interface ExposureContainer {
    @NonNull
    CardAttachStateOwner getAttachStateOwner();

    @NonNull
    List<Visit> getExposureItems();
}
