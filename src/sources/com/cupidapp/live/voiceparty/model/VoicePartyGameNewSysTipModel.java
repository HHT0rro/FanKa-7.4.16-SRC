package com.cupidapp.live.voiceparty.model;

import com.cupidapp.live.maskparty.model.MaskPartyChatConnectorMessageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyGameNewSysTipModel extends MaskPartyChatConnectorMessageModel {

    @Nullable
    private final String content;
    private final int countdownSec;

    @Nullable
    private final Boolean isQuestion;

    @Nullable
    private final String title;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoicePartyGameNewSysTipModel(@NotNull String roomId, @Nullable String str, @Nullable String str2, int i10, @Nullable Boolean bool) {
        super(roomId);
        s.i(roomId, "roomId");
        this.title = str;
        this.content = str2;
        this.countdownSec = i10;
        this.isQuestion = bool;
    }

    @Nullable
    public final String getContent() {
        return this.content;
    }

    public final int getCountdownSec() {
        return this.countdownSec;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Boolean isQuestion() {
        return this.isQuestion;
    }
}
