package com.kwad.sdk.core.network;

import androidx.annotation.NonNull;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class c {
    public int avq = -1;
    public Exception avr;
    public String avs;
    public int code;

    public final boolean DM() {
        return this.code == 200;
    }

    @NonNull
    public final String toString() {
        return "BaseResponse{code=" + this.code + ", rawCode=" + this.avq + ", rawException=" + ((Object) this.avr) + ", body='" + this.avs + "'}";
    }
}
