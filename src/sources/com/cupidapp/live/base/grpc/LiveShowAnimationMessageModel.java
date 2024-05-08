package com.cupidapp.live.base.grpc;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowAnimationMessageModel {

    @NotNull
    private final String animationResKey;

    @Nullable
    private final String audioResKey;
    private final boolean playImmediately;

    public LiveShowAnimationMessageModel(@NotNull String animationResKey, @Nullable String str, boolean z10) {
        kotlin.jvm.internal.s.i(animationResKey, "animationResKey");
        this.animationResKey = animationResKey;
        this.audioResKey = str;
        this.playImmediately = z10;
    }

    public static /* synthetic */ LiveShowAnimationMessageModel copy$default(LiveShowAnimationMessageModel liveShowAnimationMessageModel, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveShowAnimationMessageModel.animationResKey;
        }
        if ((i10 & 2) != 0) {
            str2 = liveShowAnimationMessageModel.audioResKey;
        }
        if ((i10 & 4) != 0) {
            z10 = liveShowAnimationMessageModel.playImmediately;
        }
        return liveShowAnimationMessageModel.copy(str, str2, z10);
    }

    @NotNull
    public final String component1() {
        return this.animationResKey;
    }

    @Nullable
    public final String component2() {
        return this.audioResKey;
    }

    public final boolean component3() {
        return this.playImmediately;
    }

    @NotNull
    public final LiveShowAnimationMessageModel copy(@NotNull String animationResKey, @Nullable String str, boolean z10) {
        kotlin.jvm.internal.s.i(animationResKey, "animationResKey");
        return new LiveShowAnimationMessageModel(animationResKey, str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowAnimationMessageModel)) {
            return false;
        }
        LiveShowAnimationMessageModel liveShowAnimationMessageModel = (LiveShowAnimationMessageModel) obj;
        return kotlin.jvm.internal.s.d(this.animationResKey, liveShowAnimationMessageModel.animationResKey) && kotlin.jvm.internal.s.d(this.audioResKey, liveShowAnimationMessageModel.audioResKey) && this.playImmediately == liveShowAnimationMessageModel.playImmediately;
    }

    @NotNull
    public final String getAnimationResKey() {
        return this.animationResKey;
    }

    @Nullable
    public final String getAudioResKey() {
        return this.audioResKey;
    }

    public final boolean getPlayImmediately() {
        return this.playImmediately;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.animationResKey.hashCode() * 31;
        String str = this.audioResKey;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        boolean z10 = this.playImmediately;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    @NotNull
    public String toString() {
        return "LiveShowAnimationMessageModel(animationResKey=" + this.animationResKey + ", audioResKey=" + this.audioResKey + ", playImmediately=" + this.playImmediately + ")";
    }
}
