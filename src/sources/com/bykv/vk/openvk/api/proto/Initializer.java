package com.bykv.vk.openvk.api.proto;

import android.content.Context;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public interface Initializer {
    Manager getManager();

    void init(Context context, ValueSet valueSet);

    boolean isInitSuccess();
}
