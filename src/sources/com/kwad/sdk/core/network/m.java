package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.NormalResultData;
import com.kwad.sdk.core.network.n;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.bn;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class m<R extends n, T extends NormalResultData> extends a<R> {
    private static final String TAG = "NormalNetworking";

    @Nullable
    private g<R, T> mListener = null;

    private void onRequest(@NonNull g<R, T> gVar) {
        this.mListener = gVar;
    }

    @Override // com.kwad.sdk.core.network.a
    public void cancel() {
        super.cancel();
        this.mListener = null;
    }

    public abstract T createResponseData();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.kwad.sdk.core.network.a
    public void fetchImpl() {
        c cVar;
        n nVar = (n) createRequest();
        try {
            String url = nVar.getUrl();
            if (nVar.getMethod().equals("POST")) {
                cVar = com.kwad.sdk.f.xT().doPost(url, nVar.getHeader(), nVar.getBody());
            } else {
                cVar = com.kwad.sdk.f.xT().doGet(url, nVar.getHeader());
            }
            if (cVar != null && cVar.code == 200) {
                com.kwad.sdk.core.e.c.d(TAG, "normal request success:" + cVar.code);
            } else {
                com.kwad.sdk.core.e.c.d(TAG, "normal request failed");
            }
        } catch (Exception e2) {
            com.kwad.sdk.core.e.c.printStackTrace(e2);
            cVar = 0 == 0 ? new c() : null;
            cVar.code = -1;
            cVar.avr = e2;
        }
        onResponse((m<R, T>) nVar, cVar);
    }

    public void parseResponse(T t2, c cVar) {
        t2.parseResponse(cVar);
    }

    public void request(@NonNull g<R, T> gVar) {
        try {
            onRequest(gVar);
            fetch();
        } catch (Throwable th) {
            gVar.onError(null, e.avD.errorCode, bn.t(th));
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    @Override // com.kwad.sdk.core.network.a
    public void onResponse(R r10, c cVar) {
        if (this.mListener == null) {
            return;
        }
        if (cVar.DM()) {
            T createResponseData = createResponseData();
            parseResponse(createResponseData, cVar);
            this.mListener.onSuccess(r10, createResponseData);
        } else {
            g<R, T> gVar = this.mListener;
            int i10 = cVar.code;
            Exception exc = cVar.avr;
            gVar.onError(r10, i10, exc != null ? exc.getMessage() : "");
        }
    }
}
