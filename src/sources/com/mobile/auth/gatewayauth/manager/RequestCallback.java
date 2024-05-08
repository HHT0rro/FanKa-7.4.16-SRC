package com.mobile.auth.gatewayauth.manager;

import com.mobile.auth.gatewayauth.annotations.SafeProtector;

@SafeProtector
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface RequestCallback<T, K> {
    void onError(K k10);

    void onSuccess(T t2);
}
