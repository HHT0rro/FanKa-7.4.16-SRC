package com.cupidapp.live.consult.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultCloseLiveFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorCloseLiveModel {

    @Nullable
    private final String liveDurationSec;

    @Nullable
    private final String newCommission;

    @Nullable
    private final String oneToOneVoiceConnectCount;

    @Nullable
    private final String viewers;

    @Nullable
    private final String voiceConnectCount;

    public ConsultAnchorCloseLiveModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        this.viewers = str;
        this.newCommission = str2;
        this.liveDurationSec = str3;
        this.voiceConnectCount = str4;
        this.oneToOneVoiceConnectCount = str5;
    }

    public static /* synthetic */ ConsultAnchorCloseLiveModel copy$default(ConsultAnchorCloseLiveModel consultAnchorCloseLiveModel, String str, String str2, String str3, String str4, String str5, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = consultAnchorCloseLiveModel.viewers;
        }
        if ((i10 & 2) != 0) {
            str2 = consultAnchorCloseLiveModel.newCommission;
        }
        String str6 = str2;
        if ((i10 & 4) != 0) {
            str3 = consultAnchorCloseLiveModel.liveDurationSec;
        }
        String str7 = str3;
        if ((i10 & 8) != 0) {
            str4 = consultAnchorCloseLiveModel.voiceConnectCount;
        }
        String str8 = str4;
        if ((i10 & 16) != 0) {
            str5 = consultAnchorCloseLiveModel.oneToOneVoiceConnectCount;
        }
        return consultAnchorCloseLiveModel.copy(str, str6, str7, str8, str5);
    }

    @Nullable
    public final String component1() {
        return this.viewers;
    }

    @Nullable
    public final String component2() {
        return this.newCommission;
    }

    @Nullable
    public final String component3() {
        return this.liveDurationSec;
    }

    @Nullable
    public final String component4() {
        return this.voiceConnectCount;
    }

    @Nullable
    public final String component5() {
        return this.oneToOneVoiceConnectCount;
    }

    @NotNull
    public final ConsultAnchorCloseLiveModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return new ConsultAnchorCloseLiveModel(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultAnchorCloseLiveModel)) {
            return false;
        }
        ConsultAnchorCloseLiveModel consultAnchorCloseLiveModel = (ConsultAnchorCloseLiveModel) obj;
        return s.d(this.viewers, consultAnchorCloseLiveModel.viewers) && s.d(this.newCommission, consultAnchorCloseLiveModel.newCommission) && s.d(this.liveDurationSec, consultAnchorCloseLiveModel.liveDurationSec) && s.d(this.voiceConnectCount, consultAnchorCloseLiveModel.voiceConnectCount) && s.d(this.oneToOneVoiceConnectCount, consultAnchorCloseLiveModel.oneToOneVoiceConnectCount);
    }

    @Nullable
    public final String getLiveDurationSec() {
        return this.liveDurationSec;
    }

    @Nullable
    public final String getNewCommission() {
        return this.newCommission;
    }

    @Nullable
    public final String getOneToOneVoiceConnectCount() {
        return this.oneToOneVoiceConnectCount;
    }

    @Nullable
    public final String getViewers() {
        return this.viewers;
    }

    @Nullable
    public final String getVoiceConnectCount() {
        return this.voiceConnectCount;
    }

    public int hashCode() {
        String str = this.viewers;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.newCommission;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.liveDurationSec;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.voiceConnectCount;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.oneToOneVoiceConnectCount;
        return hashCode4 + (str5 != null ? str5.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ConsultAnchorCloseLiveModel(viewers=" + this.viewers + ", newCommission=" + this.newCommission + ", liveDurationSec=" + this.liveDurationSec + ", voiceConnectCount=" + this.voiceConnectCount + ", oneToOneVoiceConnectCount=" + this.oneToOneVoiceConnectCount + ")";
    }
}
