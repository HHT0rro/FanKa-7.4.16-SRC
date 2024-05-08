package com.alibaba.security.common.http.ok;

import java.io.IOException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public interface Authenticator {
    public static final Authenticator NONE = new Authenticator() { // from class: com.alibaba.security.common.http.ok.Authenticator.1
        @Override // com.alibaba.security.common.http.ok.Authenticator
        public RPRequest authenticate(Route route, Response response) {
            return null;
        }
    };

    RPRequest authenticate(Route route, Response response) throws IOException;
}
