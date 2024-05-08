package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowTagMessageModel {

    @Nullable
    private final String messageKey;

    public LiveShowTagMessageModel(@Nullable String str) {
        this.messageKey = str;
    }

    public static /* synthetic */ LiveShowTagMessageModel copy$default(LiveShowTagMessageModel liveShowTagMessageModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveShowTagMessageModel.messageKey;
        }
        return liveShowTagMessageModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.messageKey;
    }

    @NotNull
    public final LiveShowTagMessageModel copy(@Nullable String str) {
        return new LiveShowTagMessageModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveShowTagMessageModel) && kotlin.jvm.internal.s.d(this.messageKey, ((LiveShowTagMessageModel) obj).messageKey);
    }

    @Nullable
    public final String getMessageKey() {
        return this.messageKey;
    }

    public int hashCode() {
        String str = this.messageKey;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveShowTagMessageModel(messageKey=" + this.messageKey + ")";
    }
}
