package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultOnlineInfoModel {

    @Nullable
    private final String viewerCount;

    public ConsultOnlineInfoModel(@Nullable String str) {
        this.viewerCount = str;
    }

    public static /* synthetic */ ConsultOnlineInfoModel copy$default(ConsultOnlineInfoModel consultOnlineInfoModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = consultOnlineInfoModel.viewerCount;
        }
        return consultOnlineInfoModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.viewerCount;
    }

    @NotNull
    public final ConsultOnlineInfoModel copy(@Nullable String str) {
        return new ConsultOnlineInfoModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ConsultOnlineInfoModel) && s.d(this.viewerCount, ((ConsultOnlineInfoModel) obj).viewerCount);
    }

    @Nullable
    public final String getViewerCount() {
        return this.viewerCount;
    }

    public int hashCode() {
        String str = this.viewerCount;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "ConsultOnlineInfoModel(viewerCount=" + this.viewerCount + ")";
    }
}
