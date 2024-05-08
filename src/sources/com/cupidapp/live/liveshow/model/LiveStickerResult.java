package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveStickerResult {

    @NotNull
    private final List<LiveStickerModel> lightenChildPrivilege;

    public LiveStickerResult(@NotNull List<LiveStickerModel> lightenChildPrivilege) {
        s.i(lightenChildPrivilege, "lightenChildPrivilege");
        this.lightenChildPrivilege = lightenChildPrivilege;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ LiveStickerResult copy$default(LiveStickerResult liveStickerResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = liveStickerResult.lightenChildPrivilege;
        }
        return liveStickerResult.copy(list);
    }

    @NotNull
    public final List<LiveStickerModel> component1() {
        return this.lightenChildPrivilege;
    }

    @NotNull
    public final LiveStickerResult copy(@NotNull List<LiveStickerModel> lightenChildPrivilege) {
        s.i(lightenChildPrivilege, "lightenChildPrivilege");
        return new LiveStickerResult(lightenChildPrivilege);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveStickerResult) && s.d(this.lightenChildPrivilege, ((LiveStickerResult) obj).lightenChildPrivilege);
    }

    @NotNull
    public final List<LiveStickerModel> getLightenChildPrivilege() {
        return this.lightenChildPrivilege;
    }

    public int hashCode() {
        return this.lightenChildPrivilege.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveStickerResult(lightenChildPrivilege=" + ((Object) this.lightenChildPrivilege) + ")";
    }
}
