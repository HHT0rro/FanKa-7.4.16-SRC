package com.tencent.cloud.huiyansdkface.wehttp2;

import java.io.IOException;
import java.lang.reflect.Type;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface WeReq {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface Callback<T> extends InnerCallback<T> {
        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        void onFailed(WeReq weReq, ErrType errType, int i10, String str, IOException iOException);

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        void onFinish();

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        void onStart(WeReq weReq);

        @Override // com.tencent.cloud.huiyansdkface.wehttp2.WeReq.InnerCallback
        void onSuccess(WeReq weReq, T t2);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum ErrType {
        NETWORK(2),
        HTTP(-1),
        SERVER(0),
        LOCAL(1);

        private final int type;

        ErrType(int i10) {
            this.type = i10;
        }

        public int type() {
            return this.type;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public interface InnerCallback<T> {
        void onFailed(WeReq weReq, ErrType errType, int i10, String str, IOException iOException);

        void onFinish();

        void onStart(WeReq weReq);

        void onSuccess(WeReq weReq, T t2);
    }

    void cancel();

    WeConfig context();

    <T> WeReq execute(Callback<T> callback);

    <T> T execute(Class<T> cls) throws ReqFailException;

    <T> T execute(Type type) throws ReqFailException;

    Observable subscribe();
}
