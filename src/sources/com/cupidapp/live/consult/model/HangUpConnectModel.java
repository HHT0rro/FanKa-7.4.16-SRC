package com.cupidapp.live.consult.model;

import com.cupidapp.live.voiceparty.engine.IVoiceEngine;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class HangUpConnectModel {
    private final boolean active;

    @Nullable
    private final String connectType;
    private final boolean isMe;

    @Nullable
    private final IVoiceEngine.VoiceEngineOption option;

    @Nullable
    private final String tips;

    public HangUpConnectModel(boolean z10, boolean z11, @Nullable String str, @Nullable String str2, @Nullable IVoiceEngine.VoiceEngineOption voiceEngineOption) {
        this.isMe = z10;
        this.active = z11;
        this.tips = str;
        this.connectType = str2;
        this.option = voiceEngineOption;
    }

    public static /* synthetic */ HangUpConnectModel copy$default(HangUpConnectModel hangUpConnectModel, boolean z10, boolean z11, String str, String str2, IVoiceEngine.VoiceEngineOption voiceEngineOption, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = hangUpConnectModel.isMe;
        }
        if ((i10 & 2) != 0) {
            z11 = hangUpConnectModel.active;
        }
        boolean z12 = z11;
        if ((i10 & 4) != 0) {
            str = hangUpConnectModel.tips;
        }
        String str3 = str;
        if ((i10 & 8) != 0) {
            str2 = hangUpConnectModel.connectType;
        }
        String str4 = str2;
        if ((i10 & 16) != 0) {
            voiceEngineOption = hangUpConnectModel.option;
        }
        return hangUpConnectModel.copy(z10, z12, str3, str4, voiceEngineOption);
    }

    public final boolean component1() {
        return this.isMe;
    }

    public final boolean component2() {
        return this.active;
    }

    @Nullable
    public final String component3() {
        return this.tips;
    }

    @Nullable
    public final String component4() {
        return this.connectType;
    }

    @Nullable
    public final IVoiceEngine.VoiceEngineOption component5() {
        return this.option;
    }

    @NotNull
    public final HangUpConnectModel copy(boolean z10, boolean z11, @Nullable String str, @Nullable String str2, @Nullable IVoiceEngine.VoiceEngineOption voiceEngineOption) {
        return new HangUpConnectModel(z10, z11, str, str2, voiceEngineOption);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HangUpConnectModel)) {
            return false;
        }
        HangUpConnectModel hangUpConnectModel = (HangUpConnectModel) obj;
        return this.isMe == hangUpConnectModel.isMe && this.active == hangUpConnectModel.active && s.d(this.tips, hangUpConnectModel.tips) && s.d(this.connectType, hangUpConnectModel.connectType) && s.d(this.option, hangUpConnectModel.option);
    }

    public final boolean getActive() {
        return this.active;
    }

    @Nullable
    public final String getConnectType() {
        return this.connectType;
    }

    @Nullable
    public final IVoiceEngine.VoiceEngineOption getOption() {
        return this.option;
    }

    @Nullable
    public final String getTips() {
        return this.tips;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    public int hashCode() {
        boolean z10 = this.isMe;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.active;
        int i11 = (i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        String str = this.tips;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.connectType;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        IVoiceEngine.VoiceEngineOption voiceEngineOption = this.option;
        return hashCode2 + (voiceEngineOption != null ? voiceEngineOption.hashCode() : 0);
    }

    public final boolean isMe() {
        return this.isMe;
    }

    @NotNull
    public String toString() {
        return "HangUpConnectModel(isMe=" + this.isMe + ", active=" + this.active + ", tips=" + this.tips + ", connectType=" + this.connectType + ", option=" + ((Object) this.option) + ")";
    }
}
