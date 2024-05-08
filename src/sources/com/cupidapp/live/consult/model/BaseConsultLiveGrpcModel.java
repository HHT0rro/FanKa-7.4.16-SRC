package com.cupidapp.live.consult.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseConsultLiveGrpcModel implements Serializable {

    @Nullable
    private final String roomId;

    public BaseConsultLiveGrpcModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public BaseConsultLiveGrpcModel(@Nullable String str) {
        this.roomId = str;
    }

    @Nullable
    public final String getRoomId() {
        return this.roomId;
    }

    public /* synthetic */ BaseConsultLiveGrpcModel(String str, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str);
    }
}
