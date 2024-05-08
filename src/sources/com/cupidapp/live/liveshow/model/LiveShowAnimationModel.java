package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveAnimationModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveShowAnimationModel {

    @NotNull
    private final String presetLargeImageKey;

    @Nullable
    private final String soundKey;

    @Nullable
    private final AnimationType type;

    public LiveShowAnimationModel(@NotNull String presetLargeImageKey, @Nullable String str, @Nullable AnimationType animationType) {
        s.i(presetLargeImageKey, "presetLargeImageKey");
        this.presetLargeImageKey = presetLargeImageKey;
        this.soundKey = str;
        this.type = animationType;
    }

    public static /* synthetic */ LiveShowAnimationModel copy$default(LiveShowAnimationModel liveShowAnimationModel, String str, String str2, AnimationType animationType, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveShowAnimationModel.presetLargeImageKey;
        }
        if ((i10 & 2) != 0) {
            str2 = liveShowAnimationModel.soundKey;
        }
        if ((i10 & 4) != 0) {
            animationType = liveShowAnimationModel.type;
        }
        return liveShowAnimationModel.copy(str, str2, animationType);
    }

    @NotNull
    public final String component1() {
        return this.presetLargeImageKey;
    }

    @Nullable
    public final String component2() {
        return this.soundKey;
    }

    @Nullable
    public final AnimationType component3() {
        return this.type;
    }

    @NotNull
    public final LiveShowAnimationModel copy(@NotNull String presetLargeImageKey, @Nullable String str, @Nullable AnimationType animationType) {
        s.i(presetLargeImageKey, "presetLargeImageKey");
        return new LiveShowAnimationModel(presetLargeImageKey, str, animationType);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveShowAnimationModel)) {
            return false;
        }
        LiveShowAnimationModel liveShowAnimationModel = (LiveShowAnimationModel) obj;
        return s.d(this.presetLargeImageKey, liveShowAnimationModel.presetLargeImageKey) && s.d(this.soundKey, liveShowAnimationModel.soundKey) && this.type == liveShowAnimationModel.type;
    }

    @NotNull
    public final String getPresetLargeImageKey() {
        return this.presetLargeImageKey;
    }

    @Nullable
    public final String getSoundKey() {
        return this.soundKey;
    }

    @Nullable
    public final AnimationType getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.presetLargeImageKey.hashCode() * 31;
        String str = this.soundKey;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        AnimationType animationType = this.type;
        return hashCode2 + (animationType != null ? animationType.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveShowAnimationModel(presetLargeImageKey=" + this.presetLargeImageKey + ", soundKey=" + this.soundKey + ", type=" + ((Object) this.type) + ")";
    }
}
