package com.alibaba.security.realidentity.http;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class RPHttpInvoker extends AbsHttpInvoker {
    @Override // com.alibaba.security.realidentity.http.AbsHttpInvoker
    public AbsRPCInvoker getRPCInvoker() {
        return new RpcInvoker();
    }
}
