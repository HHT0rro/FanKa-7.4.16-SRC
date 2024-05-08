package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatMessageModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class DiceAnimationFinishEvent {

    @NotNull
    private final MaskPartyChatDiceModel dice;

    public DiceAnimationFinishEvent(@NotNull MaskPartyChatDiceModel dice) {
        s.i(dice, "dice");
        this.dice = dice;
    }

    public static /* synthetic */ DiceAnimationFinishEvent copy$default(DiceAnimationFinishEvent diceAnimationFinishEvent, MaskPartyChatDiceModel maskPartyChatDiceModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            maskPartyChatDiceModel = diceAnimationFinishEvent.dice;
        }
        return diceAnimationFinishEvent.copy(maskPartyChatDiceModel);
    }

    @NotNull
    public final MaskPartyChatDiceModel component1() {
        return this.dice;
    }

    @NotNull
    public final DiceAnimationFinishEvent copy(@NotNull MaskPartyChatDiceModel dice) {
        s.i(dice, "dice");
        return new DiceAnimationFinishEvent(dice);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DiceAnimationFinishEvent) && s.d(this.dice, ((DiceAnimationFinishEvent) obj).dice);
    }

    @NotNull
    public final MaskPartyChatDiceModel getDice() {
        return this.dice;
    }

    public int hashCode() {
        return this.dice.hashCode();
    }

    @NotNull
    public String toString() {
        return "DiceAnimationFinishEvent(dice=" + ((Object) this.dice) + ")";
    }
}
