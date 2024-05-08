package com.cupidapp.live.voiceparty.model;

import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VoicePartyGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyLateNightModel extends MaskPartyChatConnectorMessageModel {
    private final int confirm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoicePartyLateNightModel(@NotNull String roomId, int i10) {
        super(roomId);
        s.i(roomId, "roomId");
        this.confirm = i10;
    }

    public final boolean isAcceptLateNight() {
        return this.confirm == 1;
    }
}
