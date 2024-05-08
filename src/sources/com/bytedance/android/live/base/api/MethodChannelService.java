package com.bytedance.android.live.base.api;

import com.bytedance.android.live.base.IService;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface MethodChannelService extends IService {
    String identity();

    Object invokeMethod(String str, Object... objArr);
}
