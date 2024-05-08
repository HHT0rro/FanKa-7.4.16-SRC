package com.kwad.sdk.crash.model.message;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class CaughtExceptionMessage extends JavaExceptionMessage {
    private static final long serialVersionUID = -4220068453451250185L;

    @Override // com.kwad.sdk.crash.model.message.JavaExceptionMessage, com.kwad.sdk.crash.model.message.ExceptionMessage
    public final String getTypePrefix() {
        return "CAUGHT_";
    }
}
