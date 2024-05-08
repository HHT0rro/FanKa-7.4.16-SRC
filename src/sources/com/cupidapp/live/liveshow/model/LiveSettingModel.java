package com.cupidapp.live.liveshow.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveSettingModel {
    private final boolean giftExpirationReminder;
    private final boolean stealthWatching;

    public LiveSettingModel(boolean z10, boolean z11) {
        this.giftExpirationReminder = z10;
        this.stealthWatching = z11;
    }

    public static /* synthetic */ LiveSettingModel copy$default(LiveSettingModel liveSettingModel, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = liveSettingModel.giftExpirationReminder;
        }
        if ((i10 & 2) != 0) {
            z11 = liveSettingModel.stealthWatching;
        }
        return liveSettingModel.copy(z10, z11);
    }

    public final boolean component1() {
        return this.giftExpirationReminder;
    }

    public final boolean component2() {
        return this.stealthWatching;
    }

    @NotNull
    public final LiveSettingModel copy(boolean z10, boolean z11) {
        return new LiveSettingModel(z10, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveSettingModel)) {
            return false;
        }
        LiveSettingModel liveSettingModel = (LiveSettingModel) obj;
        return this.giftExpirationReminder == liveSettingModel.giftExpirationReminder && this.stealthWatching == liveSettingModel.stealthWatching;
    }

    public final boolean getGiftExpirationReminder() {
        return this.giftExpirationReminder;
    }

    public final boolean getStealthWatching() {
        return this.stealthWatching;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public int hashCode() {
        boolean z10 = this.giftExpirationReminder;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.stealthWatching;
        return i10 + (z11 ? 1 : z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        return "LiveSettingModel(giftExpirationReminder=" + this.giftExpirationReminder + ", stealthWatching=" + this.stealthWatching + ")";
    }
}
