package com.huawei.appgallery.agd.api;

import android.content.Context;
import com.huawei.appgallery.agd.api.ResultCallback;
import com.huawei.appgallery.agd.internal.support.log.AgdLog;
import com.huawei.appgallery.agd.internalapi.CrossClientApi;
import com.huawei.appgallery.agd.internalapi.ICrossClient;
import com.huawei.appgallery.coreservice.api.PendingCall;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCRequest;
import com.huawei.appgallery.coreservice.internal.framework.ipc.transport.data.BaseIPCResponse;
import com.huawei.appmarket.framework.coreservice.Status;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class PendingResult<C extends BaseIPCRequest, R extends BaseIPCResponse> extends PendingCall<C, R> {
    public static final int RESOLUTION_AUTOFINISH = 1;
    public static final int RESOLUTION_DONOT_AUTOFINISH = 0;
    public static final String RESOLUTION_EXTRA_AUTOFINISH = "agd.extra.autofinish";
    public static final String RESOLUTION_EXTRA_BUNDLE = "agd.extra.bundle";
    public static final String RESOLUTION_EXTRA_BUNDLE_BINDER = "agd.extra.bundle.binder";
    public static final String RESOLUTION_EXTRA_BUNDLE_REQUESTCODE = "agd.extra.bundle.requestcode";

    /* renamed from: a, reason: collision with root package name */
    private boolean f27299a;

    /* renamed from: b, reason: collision with root package name */
    private ICrossClient f27300b;

    /* renamed from: c, reason: collision with root package name */
    private final Object f27301c;

    /* renamed from: d, reason: collision with root package name */
    private Context f27302d;

    /* renamed from: e, reason: collision with root package name */
    private C f27303e;

    public PendingResult(AgdApiClient agdApiClient, C c4) {
        super(agdApiClient, c4);
        this.f27301c = new Object();
        Context context = agdApiClient.getContext();
        this.f27302d = context;
        this.f27303e = c4;
        boolean needCrossClient = CrossClientApi.needCrossClient(context);
        this.f27299a = needCrossClient;
        if (needCrossClient) {
            this.f27300b = CrossClientApi.getCrossClient();
        }
    }

    @Override // com.huawei.appgallery.coreservice.api.PendingCall
    public void awaitOnAnyThread() {
        if (!this.f27299a) {
            super.awaitOnAnyThread();
            return;
        }
        if (this.api.get() != null) {
            setResult(this.mResult);
            return;
        }
        AgdLog.LOG.e("PendingResult", "api is null");
        synchronized (this.f27301c) {
            this.mResult.setStatusCode(12);
        }
    }

    public void setResultCallback(final ResultCallback<R> resultCallback) {
        AgdLog agdLog = AgdLog.LOG;
        agdLog.i("PendingResult", "setResultCallback");
        if (!this.f27299a) {
            resultCallback.getClass();
            super.setCallback(new PendingCall.Callback() { // from class: i9.a
                @Override // com.huawei.appgallery.coreservice.api.PendingCall.Callback
                public final void onReceiveStatus(Status status) {
                    ResultCallback.this.onResult(status);
                }
            });
        } else {
            agdLog.w("PendingResult", "crossClientTaskProcess");
            this.mResult = this.f27300b.crossClientTaskProcess(this.f27302d, this.f27303e);
            resultCallback.onResult(getResult());
        }
    }
}
