package com.wangmai.okhttp.adapter;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DefaultCallAdapter<T> implements CallAdapter<T, Call<T>> {
    @Override // com.wangmai.okhttp.adapter.CallAdapter
    public Call<T> adapt(Call<T> call, AdapterParam adapterParam) {
        return call;
    }
}
