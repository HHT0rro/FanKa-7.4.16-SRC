package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatDiceModel extends MaskPartyChatConnectorMessageModel {

    @NotNull
    private final String diceAnimationCompleteMessage;
    private final boolean isWin;
    private final int myDiceNum;
    private final boolean needShowShotAnimation;
    private final int score;

    @Nullable
    private final String shotCompleteMessage;
    private final int targetDiceNum;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatDiceModel(@NotNull String roomId, int i10, int i11, boolean z10, @NotNull String diceAnimationCompleteMessage, boolean z11, @Nullable String str, int i12) {
        super(roomId);
        s.i(roomId, "roomId");
        s.i(diceAnimationCompleteMessage, "diceAnimationCompleteMessage");
        this.myDiceNum = i10;
        this.targetDiceNum = i11;
        this.isWin = z10;
        this.diceAnimationCompleteMessage = diceAnimationCompleteMessage;
        this.needShowShotAnimation = z11;
        this.shotCompleteMessage = str;
        this.score = i12;
    }

    @NotNull
    public final String getDiceAnimationCompleteMessage() {
        return this.diceAnimationCompleteMessage;
    }

    public final int getMyDiceNum() {
        return this.myDiceNum;
    }

    public final boolean getNeedShowShotAnimation() {
        return this.needShowShotAnimation;
    }

    public final int getScore() {
        return this.score;
    }

    @Nullable
    public final String getShotCompleteMessage() {
        return this.shotCompleteMessage;
    }

    public final int getTargetDiceNum() {
        return this.targetDiceNum;
    }

    public final boolean isWin() {
        return this.isWin;
    }
}
