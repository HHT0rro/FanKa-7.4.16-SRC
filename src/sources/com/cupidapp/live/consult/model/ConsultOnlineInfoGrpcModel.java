package com.cupidapp.live.consult.model;

import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultOnlineInfoGrpcModel extends BaseConsultLiveGrpcModel {

    @Nullable
    private final String viewerCount;

    public ConsultOnlineInfoGrpcModel(@Nullable String str, @Nullable String str2) {
        super(str);
        this.viewerCount = str2;
    }

    @Nullable
    public final String getViewerCount() {
        return this.viewerCount;
    }
}
