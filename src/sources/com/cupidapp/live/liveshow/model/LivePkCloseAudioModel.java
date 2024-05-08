package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLivePkResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LivePkCloseAudioModel {
    private final boolean close;

    @NotNull
    private final String liveShowId;

    public LivePkCloseAudioModel(@NotNull String liveShowId, boolean z10) {
        s.i(liveShowId, "liveShowId");
        this.liveShowId = liveShowId;
        this.close = z10;
    }

    public static /* synthetic */ LivePkCloseAudioModel copy$default(LivePkCloseAudioModel livePkCloseAudioModel, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = livePkCloseAudioModel.liveShowId;
        }
        if ((i10 & 2) != 0) {
            z10 = livePkCloseAudioModel.close;
        }
        return livePkCloseAudioModel.copy(str, z10);
    }

    @NotNull
    public final String component1() {
        return this.liveShowId;
    }

    public final boolean component2() {
        return this.close;
    }

    @NotNull
    public final LivePkCloseAudioModel copy(@NotNull String liveShowId, boolean z10) {
        s.i(liveShowId, "liveShowId");
        return new LivePkCloseAudioModel(liveShowId, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LivePkCloseAudioModel)) {
            return false;
        }
        LivePkCloseAudioModel livePkCloseAudioModel = (LivePkCloseAudioModel) obj;
        return s.d(this.liveShowId, livePkCloseAudioModel.liveShowId) && this.close == livePkCloseAudioModel.close;
    }

    public final boolean getClose() {
        return this.close;
    }

    @NotNull
    public final String getLiveShowId() {
        return this.liveShowId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.liveShowId.hashCode() * 31;
        boolean z10 = this.close;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    @NotNull
    public String toString() {
        return "LivePkCloseAudioModel(liveShowId=" + this.liveShowId + ", close=" + this.close + ")";
    }
}
