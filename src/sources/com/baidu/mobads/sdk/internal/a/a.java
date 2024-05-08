package com.baidu.mobads.sdk.internal.a;

import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.api.IOAdEvent;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface a extends IOAdEvent {
    @NonNull
    IAdInterListener getDelegator();

    Object handleEvent(String str, String str2, Object[] objArr);
}
