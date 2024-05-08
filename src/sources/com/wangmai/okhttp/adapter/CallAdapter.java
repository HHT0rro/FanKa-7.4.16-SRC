package com.wangmai.okhttp.adapter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface CallAdapter<T, R> {
    R adapt(Call<T> call, AdapterParam adapterParam);
}
