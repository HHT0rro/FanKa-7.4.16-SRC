package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface PushObserver {

    /* renamed from: a, reason: collision with root package name */
    public static final PushObserver f41982a = new PushObserver() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.PushObserver.1
        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.PushObserver
        public boolean onData(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException {
            bufferedSource.skip(i11);
            return true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.PushObserver
        public boolean onHeaders(int i10, List<Header> list, boolean z10) {
            return true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.PushObserver
        public boolean onRequest(int i10, List<Header> list) {
            return true;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.PushObserver
        public void onReset(int i10, ErrorCode errorCode) {
        }
    };

    boolean onData(int i10, BufferedSource bufferedSource, int i11, boolean z10) throws IOException;

    boolean onHeaders(int i10, List<Header> list, boolean z10);

    boolean onRequest(int i10, List<Header> list);

    void onReset(int i10, ErrorCode errorCode);
}
