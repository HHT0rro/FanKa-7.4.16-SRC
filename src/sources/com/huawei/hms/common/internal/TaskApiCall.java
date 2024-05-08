package com.huawei.hms.common.internal;

import android.os.Parcelable;
import com.huawei.hmf.tasks.CancellationToken;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public abstract class TaskApiCall<ClientT extends AnyClient, ResultT> {

    /* renamed from: a, reason: collision with root package name */
    private final String f29735a;

    /* renamed from: b, reason: collision with root package name */
    private final String f29736b;

    /* renamed from: c, reason: collision with root package name */
    private Parcelable f29737c;

    /* renamed from: d, reason: collision with root package name */
    private String f29738d;

    /* renamed from: e, reason: collision with root package name */
    private CancellationToken f29739e;

    /* renamed from: f, reason: collision with root package name */
    private int f29740f;

    @Deprecated
    public TaskApiCall(String str, String str2) {
        this.f29740f = 1;
        this.f29735a = str;
        this.f29736b = str2;
        this.f29737c = null;
        this.f29738d = null;
    }

    public abstract void doExecute(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource);

    public int getApiLevel() {
        return this.f29740f;
    }

    @Deprecated
    public int getMinApkVersion() {
        return 30000000;
    }

    public Parcelable getParcelable() {
        return this.f29737c;
    }

    public String getRequestJson() {
        return this.f29736b;
    }

    public CancellationToken getToken() {
        return this.f29739e;
    }

    public String getTransactionId() {
        return this.f29738d;
    }

    public String getUri() {
        return this.f29735a;
    }

    public final void onResponse(ClientT clientt, ResponseErrorCode responseErrorCode, String str, TaskCompletionSource<ResultT> taskCompletionSource) {
        CancellationToken cancellationToken = this.f29739e;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            HMSLog.i("TaskApiCall", "This Task has been canceled, uri:" + this.f29735a + ", transactionId:" + this.f29738d);
            return;
        }
        HMSLog.i("TaskApiCall", "doExecute, uri:" + this.f29735a + ", errorCode:" + responseErrorCode.getErrorCode() + ", transactionId:" + this.f29738d);
        doExecute(clientt, responseErrorCode, str, taskCompletionSource);
    }

    public void setApiLevel(int i10) {
        this.f29740f = i10;
    }

    public void setParcelable(Parcelable parcelable) {
        this.f29737c = parcelable;
    }

    public void setToken(CancellationToken cancellationToken) {
        this.f29739e = cancellationToken;
    }

    public void setTransactionId(String str) {
        this.f29738d = str;
    }

    public TaskApiCall(String str, String str2, String str3) {
        this.f29740f = 1;
        this.f29735a = str;
        this.f29736b = str2;
        this.f29737c = null;
        this.f29738d = str3;
    }

    public TaskApiCall(String str, String str2, String str3, int i10) {
        this.f29735a = str;
        this.f29736b = str2;
        this.f29737c = null;
        this.f29738d = str3;
        this.f29740f = i10;
    }
}
