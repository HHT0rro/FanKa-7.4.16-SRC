package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultLiveModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConnectFinishedModel {

    @Nullable
    private final String tips;

    public ConnectFinishedModel(@Nullable String str) {
        this.tips = str;
    }

    public static /* synthetic */ ConnectFinishedModel copy$default(ConnectFinishedModel connectFinishedModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = connectFinishedModel.tips;
        }
        return connectFinishedModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.tips;
    }

    @NotNull
    public final ConnectFinishedModel copy(@Nullable String str) {
        return new ConnectFinishedModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConnectFinishedModel) && s.d(this.tips, ((ConnectFinishedModel) obj).tips);
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    public int hashCode() {
        String str = this.tips;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConnectFinishedModel(tips=" + this.tips + ")";
    }
}
