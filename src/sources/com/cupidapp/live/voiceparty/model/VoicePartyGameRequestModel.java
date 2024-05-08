package com.cupidapp.live.voiceparty.model;

import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyGameRequestModel extends MaskPartyChatConnectorMessageModel {

    @Nullable
    private final String content;
    private final int countdownSec;

    @NotNull
    private final String inviteUserId;

    @Nullable
    private final String tip;

    @Nullable
    private final String title;
    private final int type;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoicePartyGameRequestModel(@NotNull String roomId, @NotNull String inviteUserId, int i10, int i11, @Nullable String str, @Nullable String str2, @Nullable String str3) {
        super(roomId);
        s.i(roomId, "roomId");
        s.i(inviteUserId, "inviteUserId");
        this.inviteUserId = inviteUserId;
        this.type = i10;
        this.countdownSec = i11;
        this.title = str;
        this.content = str2;
        this.tip = str3;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final int getCountdownSec() {
        return this.countdownSec;
    }

    @NotNull
    public final String getInviteUserId() {
        return this.inviteUserId;
    }

    @Nullable
    public final String getTip() {
        return this.tip;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }
}
