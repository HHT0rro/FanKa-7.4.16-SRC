package com.cupidapp.live.consult.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RequestConnectCountGrpcModel extends BaseConsultLiveGrpcModel {
    private final int count;

    public RequestConnectCountGrpcModel(@Nullable String str, int i10) {
        super(str);
        this.count = i10;
    }

    public final int getCount() {
        return this.count;
    }
}
