package com.huawei.hmf.orb.aidl.request;

import com.huawei.hmf.orb.IMessageEntity;
import com.huawei.hmf.orb.RemoteSessionManager;
import com.huawei.hmf.orb.aidl.client.ApiClient;
import com.huawei.hmf.orb.aidl.client.impl.ResolvePendingResult;
import com.huawei.hmf.orb.aidl.communicate.AIDLRequest;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class DisconnectService extends AIDLRequest<Request> {
    public static final String name = "DisconnectService";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Request implements IMessageEntity {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class Response implements IMessageEntity {
    }

    public static ResolvePendingResult<Response> build(ApiClient apiClient) {
        return ResolvePendingResult.build(apiClient, name, new Request(), Response.class);
    }

    @Override // com.huawei.hmf.orb.aidl.communicate.AIDLRequest
    public void onRequest(Request request) {
        Response response = new Response();
        RemoteSessionManager.remove(this.clientIdentity.appID);
        this.response.call(response);
    }
}
