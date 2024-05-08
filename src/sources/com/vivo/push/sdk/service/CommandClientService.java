package com.vivo.push.sdk.service;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class CommandClientService extends CommandService {
    @Override // com.vivo.push.sdk.service.CommandService
    public final boolean a(String str) {
        return "com.vivo.pushclient.action.RECEIVE".equals(str);
    }
}
