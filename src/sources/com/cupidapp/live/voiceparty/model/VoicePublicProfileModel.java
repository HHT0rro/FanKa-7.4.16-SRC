package com.cupidapp.live.voiceparty.model;

import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePublicProfileModel {
    private boolean myPublic;
    private boolean otherPublic;

    public VoicePublicProfileModel(boolean z10, boolean z11) {
        this.myPublic = z10;
        this.otherPublic = z11;
    }

    public final boolean getMyPublic() {
        return this.myPublic;
    }

    public final boolean getOtherPublic() {
        return this.otherPublic;
    }

    @NotNull
    public final PublicProfileStatus getPublicProfileStatus() {
        boolean z10 = this.myPublic;
        return (z10 || this.otherPublic) ? (!z10 || this.otherPublic) ? (z10 || !this.otherPublic) ? (z10 && this.otherPublic) ? PublicProfileStatus.BOTH_PUBLIC : PublicProfileStatus.BOTH_NONE_PUBLIC : PublicProfileStatus.ONLY_OTHER_PUBLIC : PublicProfileStatus.ONLY_MY_PUBLIC : PublicProfileStatus.BOTH_NONE_PUBLIC;
    }

    public final void setMyPublic(boolean z10) {
        this.myPublic = z10;
    }

    public final void setOtherPublic(boolean z10) {
        this.otherPublic = z10;
    }
}
