package com.cupidapp.live.maskparty.holder;

import com.cupidapp.live.maskparty.model.DiceAnimationFinishEvent;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import kotlin.d;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.greenrobot.eventbus.EventBus;
import org.jetbrains.annotations.NotNull;

/* compiled from: MaskPartyChatDiceViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyChatDiceViewHolder$fillRightView$1 extends Lambda implements Function1<MaskPartyChatDiceModel, p> {
    public final /* synthetic */ MaskPartyChatDiceViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MaskPartyChatDiceViewHolder$fillRightView$1(MaskPartyChatDiceViewHolder maskPartyChatDiceViewHolder) {
        super(1);
        this.this$0 = maskPartyChatDiceViewHolder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(MaskPartyChatDiceModel it) {
        s.i(it, "$it");
        EventBus.c().o(new DiceAnimationFinishEvent(it));
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(MaskPartyChatDiceModel maskPartyChatDiceModel) {
        invoke2(maskPartyChatDiceModel);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull final MaskPartyChatDiceModel it) {
        s.i(it, "it");
        this.this$0.itemView.postDelayed(new Runnable() { // from class: com.cupidapp.live.maskparty.holder.b
            @Override // java.lang.Runnable
            public final void run() {
                MaskPartyChatDiceViewHolder$fillRightView$1.invoke$lambda$0(MaskPartyChatDiceModel.this);
            }
        }, 300L);
    }
}
