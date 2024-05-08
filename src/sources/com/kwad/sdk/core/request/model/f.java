package com.kwad.sdk.core.request.model;

import com.ksad.json.annotation.KsJson;

@KsJson
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class f extends com.kwad.sdk.core.response.a.a {
    public int adStyle;
    public long azP;
    public int count;
    public int taskType;

    public f() {
    }

    public final void ar(long j10) {
        this.azP = j10;
    }

    public f(int i10, int i11, int i12, long j10) {
        this.adStyle = i10;
        this.taskType = i11;
        this.count = 1;
        this.azP = j10;
    }
}
