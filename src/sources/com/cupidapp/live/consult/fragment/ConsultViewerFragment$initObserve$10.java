package com.cupidapp.live.consult.fragment;

import android.content.Context;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$raw;
import com.cupidapp.live.consult.model.ConsultApplyConnectGrpcModel;
import com.cupidapp.live.consult.view.ViewerConsultConnectLayout;
import com.huawei.uikit.hwcommon.anim.HwCubicBezierInterpolator;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ConsultViewerFragment.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultViewerFragment$initObserve$10 extends Lambda implements Function1<ConsultApplyConnectGrpcModel, p> {
    public final /* synthetic */ ConsultViewerFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConsultViewerFragment$initObserve$10(ConsultViewerFragment consultViewerFragment) {
        super(1);
        this.this$0 = consultViewerFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(ConsultViewerFragment this$0) {
        com.cupidapp.live.voiceparty.helper.b C1;
        com.cupidapp.live.voiceparty.helper.b C12;
        s.i(this$0, "this$0");
        C1 = this$0.C1();
        C1.b();
        C12 = this$0.C1();
        C12.h();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(ConsultApplyConnectGrpcModel consultApplyConnectGrpcModel) {
        invoke2(consultApplyConnectGrpcModel);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull ConsultApplyConnectGrpcModel it) {
        com.cupidapp.live.base.utils.d B1;
        boolean z10;
        com.cupidapp.live.voiceparty.helper.b C1;
        s.i(it, "it");
        B1 = this.this$0.B1();
        B1.b();
        this.this$0.K1(false);
        n1.a.f52091a.a(this.this$0.getContext(), 500L);
        z10 = this.this$0.f13796j;
        if (z10) {
            this.this$0.D1().applyConnect(it.getVoiceConnectType(), it.getNewRoomId(), it.getPrivateMapKey());
            return;
        }
        Context context = this.this$0.getContext();
        if (context != null) {
            final ConsultViewerFragment consultViewerFragment = this.this$0;
            C1 = consultViewerFragment.C1();
            C1.e(context, R$raw.arrival_sorting, new Function0<p>() { // from class: com.cupidapp.live.consult.fragment.ConsultViewerFragment$initObserve$10$1$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    com.cupidapp.live.voiceparty.helper.b C12;
                    C12 = ConsultViewerFragment.this.C1();
                    C12.c(0);
                }
            });
        }
        ViewerConsultConnectLayout viewerConsultConnectLayout = (ViewerConsultConnectLayout) this.this$0.S0(R$id.consult_viewer_connect_layout);
        final ConsultViewerFragment consultViewerFragment2 = this.this$0;
        viewerConsultConnectLayout.postDelayed(new Runnable() { // from class: com.cupidapp.live.consult.fragment.c
            @Override // java.lang.Runnable
            public final void run() {
                ConsultViewerFragment$initObserve$10.invoke$lambda$1(ConsultViewerFragment.this);
            }
        }, HwCubicBezierInterpolator.f34870a);
        this.this$0.D1().applyConnect(it.getVoiceConnectType(), it.getNewRoomId(), it.getPrivateMapKey());
    }
}
