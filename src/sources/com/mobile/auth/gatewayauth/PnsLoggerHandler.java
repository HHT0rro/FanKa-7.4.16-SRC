package com.mobile.auth.gatewayauth;

import com.mobile.auth.gatewayauth.annotations.AuthNumber;

@AuthNumber
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public interface PnsLoggerHandler {
    void debug(String str);

    void error(String str);

    void info(String str);

    void monitor(String str);

    void verbose(String str);

    void warning(String str);
}
