package com.cupidapp.live.liveshow.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectEndModel {

    @Nullable
    private final String accompanyLiveShowId;

    public LiveConnectEndModel(@Nullable String str) {
        this.accompanyLiveShowId = str;
    }

    public static /* synthetic */ LiveConnectEndModel copy$default(LiveConnectEndModel liveConnectEndModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = liveConnectEndModel.accompanyLiveShowId;
        }
        return liveConnectEndModel.copy(str);
    }

    @Nullable
    public final String component1() {
        return this.accompanyLiveShowId;
    }

    @NotNull
    public final LiveConnectEndModel copy(@Nullable String str) {
        return new LiveConnectEndModel(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveConnectEndModel) && s.d(this.accompanyLiveShowId, ((LiveConnectEndModel) obj).accompanyLiveShowId);
    }

    @Nullable
    public final String getAccompanyLiveShowId() {
        return this.accompanyLiveShowId;
    }

    public int hashCode() {
        String str = this.accompanyLiveShowId;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveConnectEndModel(accompanyLiveShowId=" + this.accompanyLiveShowId + ")";
    }
}
