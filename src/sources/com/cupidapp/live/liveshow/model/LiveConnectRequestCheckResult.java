package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKliveConnectResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveConnectRequestCheckResult implements Serializable {
    private final boolean hasRequest;

    @Nullable
    private final String videoError;

    @Nullable
    private final String voiceError;

    public LiveConnectRequestCheckResult(boolean z10, @Nullable String str, @Nullable String str2) {
        this.hasRequest = z10;
        this.voiceError = str;
        this.videoError = str2;
    }

    public static /* synthetic */ LiveConnectRequestCheckResult copy$default(LiveConnectRequestCheckResult liveConnectRequestCheckResult, boolean z10, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = liveConnectRequestCheckResult.hasRequest;
        }
        if ((i10 & 2) != 0) {
            str = liveConnectRequestCheckResult.voiceError;
        }
        if ((i10 & 4) != 0) {
            str2 = liveConnectRequestCheckResult.videoError;
        }
        return liveConnectRequestCheckResult.copy(z10, str, str2);
    }

    public final boolean component1() {
        return this.hasRequest;
    }

    @Nullable
    public final String component2() {
        return this.voiceError;
    }

    @Nullable
    public final String component3() {
        return this.videoError;
    }

    @NotNull
    public final LiveConnectRequestCheckResult copy(boolean z10, @Nullable String str, @Nullable String str2) {
        return new LiveConnectRequestCheckResult(z10, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveConnectRequestCheckResult)) {
            return false;
        }
        LiveConnectRequestCheckResult liveConnectRequestCheckResult = (LiveConnectRequestCheckResult) obj;
        return this.hasRequest == liveConnectRequestCheckResult.hasRequest && s.d(this.voiceError, liveConnectRequestCheckResult.voiceError) && s.d(this.videoError, liveConnectRequestCheckResult.videoError);
    }

    public final boolean getHasRequest() {
        return this.hasRequest;
    }

    @Nullable
    public final String getVideoError() {
        return this.videoError;
    }

    @Nullable
    public final String getVoiceError() {
        return this.voiceError;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    public int hashCode() {
        boolean z10 = this.hasRequest;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        String str = this.voiceError;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.videoError;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LiveConnectRequestCheckResult(hasRequest=" + this.hasRequest + ", voiceError=" + this.voiceError + ", videoError=" + this.videoError + ")";
    }
}
