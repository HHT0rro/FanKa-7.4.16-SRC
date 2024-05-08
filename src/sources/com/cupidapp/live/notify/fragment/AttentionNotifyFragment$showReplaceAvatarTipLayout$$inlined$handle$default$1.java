package com.cupidapp.live.notify.fragment;

import android.content.Context;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.notify.layout.ReplaceAvatarTipLayout;
import com.cupidapp.live.notify.model.CheckAvatarModel;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: ObservableExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AttentionNotifyFragment$showReplaceAvatarTipLayout$$inlined$handle$default$1 extends Lambda implements Function1<CheckAvatarModel, p> {
    public final /* synthetic */ AttentionNotifyFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AttentionNotifyFragment$showReplaceAvatarTipLayout$$inlined$handle$default$1(AttentionNotifyFragment attentionNotifyFragment) {
        super(1);
        this.this$0 = attentionNotifyFragment;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(CheckAvatarModel checkAvatarModel) {
        m2745invoke(checkAvatarModel);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2745invoke(CheckAvatarModel checkAvatarModel) {
        if (checkAvatarModel.getRealFake()) {
            Context it = this.this$0.getContext();
            if (it != null) {
                s.h(it, "it");
                new ReplaceAvatarTipLayout(it).e(SensorPosition.NotifyAloha);
                return;
            }
            return;
        }
        com.cupidapp.live.base.view.h.f12779a.c(this.this$0.getContext(), R$string.avatar_under_review_review_pass_to_unlock);
    }
}
