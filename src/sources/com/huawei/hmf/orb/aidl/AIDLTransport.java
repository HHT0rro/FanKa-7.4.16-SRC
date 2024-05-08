package com.huawei.hmf.orb.aidl;

import com.huawei.hmf.orb.RemoteConnector;
import com.huawei.hmf.orb.RemoteInvoker;
import com.huawei.hmf.orb.aidl.client.ApiClient;
import com.huawei.hmf.orb.aidl.client.impl.ResolvePendingResult;
import com.huawei.hmf.orb.aidl.client.impl.ResolveResult;
import com.huawei.hmf.orb.aidl.request.InvokeService;
import com.huawei.hmf.orb.aidl.request.TypeKind;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class AIDLTransport implements RemoteInvoker {
    private ApiClient mApiClient;
    private String mModuleName;

    public AIDLTransport(String str, RemoteConnector remoteConnector) {
        this.mModuleName = str;
        this.mApiClient = (ApiClient) remoteConnector;
    }

    @Override // com.huawei.hmf.orb.RemoteInvoker
    public ResolvePendingResult<InvokeService.Response> post(String str, String str2, Object... objArr) {
        return InvokeService.build(this.mApiClient, this.mModuleName, str, str2, objArr);
    }

    @Override // com.huawei.hmf.orb.RemoteInvoker
    public InvokeService.Response send(String str, String str2, TypeKind typeKind, Object... objArr) {
        ResolveResult await = InvokeService.build(this.mApiClient, this.mModuleName, str, str2, typeKind, objArr).await();
        if (!await.getStatus().isSuccess() && await.getValue() == null) {
            InvokeService.Response response = new InvokeService.Response();
            response.failure(await.getStatus().getStatusCode());
            return response;
        }
        return (InvokeService.Response) await.getValue();
    }
}
