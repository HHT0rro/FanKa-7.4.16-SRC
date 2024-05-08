package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyMatchConfigResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyMatchStatusModel {

    @Nullable
    private final Integer confineMatchSeconds;
    private final boolean isVoiceChat;
    private final boolean matching;
    private final boolean quit;

    public MaskPartyMatchStatusModel(boolean z10, boolean z11, @Nullable Integer num, boolean z12) {
        this.matching = z10;
        this.quit = z11;
        this.confineMatchSeconds = num;
        this.isVoiceChat = z12;
    }

    public static /* synthetic */ MaskPartyMatchStatusModel copy$default(MaskPartyMatchStatusModel maskPartyMatchStatusModel, boolean z10, boolean z11, Integer num, boolean z12, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = maskPartyMatchStatusModel.matching;
        }
        if ((i10 & 2) != 0) {
            z11 = maskPartyMatchStatusModel.quit;
        }
        if ((i10 & 4) != 0) {
            num = maskPartyMatchStatusModel.confineMatchSeconds;
        }
        if ((i10 & 8) != 0) {
            z12 = maskPartyMatchStatusModel.isVoiceChat;
        }
        return maskPartyMatchStatusModel.copy(z10, z11, num, z12);
    }

    public final boolean component1() {
        return this.matching;
    }

    public final boolean component2() {
        return this.quit;
    }

    @Nullable
    public final Integer component3() {
        return this.confineMatchSeconds;
    }

    public final boolean component4() {
        return this.isVoiceChat;
    }

    @NotNull
    public final MaskPartyMatchStatusModel copy(boolean z10, boolean z11, @Nullable Integer num, boolean z12) {
        return new MaskPartyMatchStatusModel(z10, z11, num, z12);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyMatchStatusModel)) {
            return false;
        }
        MaskPartyMatchStatusModel maskPartyMatchStatusModel = (MaskPartyMatchStatusModel) obj;
        return this.matching == maskPartyMatchStatusModel.matching && this.quit == maskPartyMatchStatusModel.quit && s.d(this.confineMatchSeconds, maskPartyMatchStatusModel.confineMatchSeconds) && this.isVoiceChat == maskPartyMatchStatusModel.isVoiceChat;
    }

    @Nullable
    public final Integer getConfineMatchSeconds() {
        return this.confineMatchSeconds;
    }

    public final boolean getMatching() {
        return this.matching;
    }

    public final boolean getQuit() {
        return this.quit;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    public int hashCode() {
        boolean z10 = this.matching;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        ?? r22 = this.quit;
        int i11 = r22;
        if (r22 != 0) {
            i11 = 1;
        }
        int i12 = (i10 + i11) * 31;
        Integer num = this.confineMatchSeconds;
        int hashCode = (i12 + (num == null ? 0 : num.hashCode())) * 31;
        boolean z11 = this.isVoiceChat;
        return hashCode + (z11 ? 1 : z11 ? 1 : 0);
    }

    public final boolean isVoiceChat() {
        return this.isVoiceChat;
    }

    @NotNull
    public String toString() {
        boolean z10 = this.matching;
        boolean z11 = this.quit;
        Integer num = this.confineMatchSeconds;
        return "MaskPartyMatchStatusModel(matching=" + z10 + ", quit=" + z11 + ", confineMatchSeconds=" + ((Object) num) + ", isVoiceChat=" + this.isVoiceChat + ")";
    }
}
