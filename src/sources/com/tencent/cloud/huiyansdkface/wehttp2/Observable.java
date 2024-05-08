package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class Observable<T> {

    /* renamed from: a, reason: collision with root package name */
    private WeReq f42290a;

    public Observable() {
    }

    public Observable(WeReq weReq) {
        this.f42290a = weReq;
    }

    public static <T> Observable<T> error(final int i10, final String str) {
        return new Observable<T>() { // from class: com.tencent.cloud.huiyansdkface.wehttp2.Observable.1
            @Override // com.tencent.cloud.huiyansdkface.wehttp2.Observable
            public void subscribe(WeReq.Callback<T> callback) {
                callback.onFailed(null, WeReq.ErrType.LOCAL, i10, str, null);
            }
        };
    }

    public void cancel() {
        WeReq weReq = this.f42290a;
        if (weReq != null) {
            weReq.cancel();
        }
    }

    public abstract void subscribe(WeReq.Callback<T> callback);
}
