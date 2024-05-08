package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.wehttp2.WeReq;
import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class WeBaseCallback<T> extends BaseCallback<Resp<T>> {

    /* renamed from: a, reason: collision with root package name */
    private static int f42314a;

    /* renamed from: b, reason: collision with root package name */
    private int f42315b = f42314a;

    public static void successCodeGlobal(int i10) {
        f42314a = i10;
    }

    public abstract void failed(WeReq weReq, WeReq.ErrType errType, int i10, String str, IOException iOException);

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
    public void onFailed(WeReq weReq, WeReq.ErrType errType, int i10, String str, IOException iOException) {
        failed(weReq, errType, i10, str, iOException);
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.Callback, com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
    public void onSuccess(WeReq weReq, Resp<T> resp) {
        if (resp == null || resp.getCode() != this.f42315b) {
            failed(weReq, WeReq.ErrType.SERVER, resp.getCode(), resp.getMsg(), null);
        } else {
            success(weReq, resp.getResult());
        }
    }

    public abstract void success(WeReq weReq, T t2);

    public WeBaseCallback<T> successCode(int i10) {
        this.f42315b = i10;
        return this;
    }
}
