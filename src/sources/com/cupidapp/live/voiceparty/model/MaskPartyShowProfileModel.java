package com.cupidapp.live.voiceparty.model;

import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: VoicePartyGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyShowProfileModel extends MaskPartyChatConnectorMessageModel {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyShowProfileModel(@NotNull String roomId) {
        super(roomId);
        s.i(roomId, "roomId");
    }
}
