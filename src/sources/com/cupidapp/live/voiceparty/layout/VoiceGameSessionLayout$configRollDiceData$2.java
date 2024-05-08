package com.cupidapp.live.voiceparty.layout;

import android.widget.ImageView;
import com.cupidapp.live.R$id;
import com.cupidapp.live.base.view.animation.FKSVGAImageView;
import com.cupidapp.live.maskparty.model.DicePoint;
import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.voiceparty.layout.VoiceGameSessionLayout;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: VoiceGameSessionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoiceGameSessionLayout$configRollDiceData$2 extends Lambda implements Function0<p> {
    public final /* synthetic */ MaskPartyChatDiceModel $model;
    public final /* synthetic */ VoiceGameSessionLayout this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public VoiceGameSessionLayout$configRollDiceData$2(VoiceGameSessionLayout voiceGameSessionLayout, MaskPartyChatDiceModel maskPartyChatDiceModel) {
        super(0);
        this.this$0 = voiceGameSessionLayout;
        this.$model = maskPartyChatDiceModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1$lambda$0(VoiceGameSessionLayout this$0, MaskPartyChatDiceModel model) {
        VoiceGameSessionLayout.a aVar;
        s.i(this$0, "this$0");
        s.i(model, "$model");
        aVar = this$0.f19022d;
        if (aVar != null) {
            aVar.d(model);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ p invoke() {
        invoke2();
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((FKSVGAImageView) this.this$0.a(R$id.voice_right_dice_svga)).setVisibility(4);
        VoiceGameSessionLayout voiceGameSessionLayout = this.this$0;
        int i10 = R$id.voice_right_dice_img;
        ((ImageView) voiceGameSessionLayout.a(i10)).setVisibility(0);
        DicePoint a10 = DicePoint.Companion.a(this.$model.getMyDiceNum());
        if (a10 != null) {
            final VoiceGameSessionLayout voiceGameSessionLayout2 = this.this$0;
            final MaskPartyChatDiceModel maskPartyChatDiceModel = this.$model;
            ((ImageView) voiceGameSessionLayout2.a(i10)).setImageResource(a10.getIcon());
            ((ImageView) voiceGameSessionLayout2.a(i10)).postDelayed(new Runnable() { // from class: com.cupidapp.live.voiceparty.layout.a
                @Override // java.lang.Runnable
                public final void run() {
                    VoiceGameSessionLayout$configRollDiceData$2.invoke$lambda$1$lambda$0(VoiceGameSessionLayout.this, maskPartyChatDiceModel);
                }
            }, 1500L);
        }
    }
}
