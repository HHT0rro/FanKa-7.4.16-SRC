package com.cupidapp.live.base.grpc;

import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKGRPCMessageIdCounter.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKGRPCMessageIdCounter {
    private long messageId;

    public final void checkAndUpdate(long j10, @NotNull Function0<kotlin.p> isUpdate) {
        kotlin.jvm.internal.s.i(isUpdate, "isUpdate");
        if (j10 > this.messageId) {
            isUpdate.invoke();
            this.messageId = j10;
        }
    }
}
