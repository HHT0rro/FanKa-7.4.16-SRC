package com.cupidapp.live.chat2.fragment;

import com.cupidapp.live.R$id;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatPanelType;
import com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;

/* compiled from: ChatDetailFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailFragment$initObserve$2 extends Lambda implements Function1<List<? extends ChatMessageModel>, p> {
    public final /* synthetic */ ChatDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailFragment$initObserve$2(ChatDetailFragment chatDetailFragment) {
        super(1);
        this.this$0 = chatDetailFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(ChatDetailFragment this$0) {
        s.i(this$0, "this$0");
        ChatDetailInputPanelLayout chatDetailInputPanelLayout = (ChatDetailInputPanelLayout) this$0.d1(R$id.chat_detail_input_panel_layout);
        if (chatDetailInputPanelLayout != null) {
            chatDetailInputPanelLayout.M(ChatPanelType.SOFT_KEYBOARD);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(List<? extends ChatMessageModel> list) {
        invoke2((List<ChatMessageModel>) list);
        return p.f51048a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0083, code lost:
    
        if ((r6 != null && r6.isOtherMsgShowSvga()) != false) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0079  */
    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(@org.jetbrains.annotations.Nullable java.util.List<com.cupidapp.live.chat2.model.ChatMessageModel> r6) {
        /*
            r5 = this;
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r0 = r5.this$0
            com.cupidapp.live.chat2.adapter.ChatDetailAdapter r0 = com.cupidapp.live.chat2.fragment.ChatDetailFragment.e1(r0)
            r0.u(r6)
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r0 = r5.this$0
            com.cupidapp.live.chat2.adapter.ChatDetailAdapter r0 = com.cupidapp.live.chat2.fragment.ChatDetailFragment.e1(r0)
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r1 = r5.this$0
            com.cupidapp.live.chat2.model.ChatBundleData r1 = com.cupidapp.live.chat2.fragment.ChatDetailFragment.f1(r1)
            java.lang.String r2 = "mBundleData"
            r3 = 0
            if (r1 != 0) goto L1e
            kotlin.jvm.internal.s.A(r2)
            r1 = r3
        L1e:
            boolean r0 = r0.x(r1)
            if (r0 == 0) goto L50
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r6 = r5.this$0
            int r0 = com.cupidapp.live.R$id.chat_detail_tips_layout
            android.view.View r6 = r6.d1(r0)
            com.cupidapp.live.chat2.view.ChatDetailTipsLayout r6 = (com.cupidapp.live.chat2.view.ChatDetailTipsLayout) r6
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r0 = r5.this$0
            com.cupidapp.live.chat2.model.ChatBundleData r0 = com.cupidapp.live.chat2.fragment.ChatDetailFragment.f1(r0)
            if (r0 != 0) goto L3a
            kotlin.jvm.internal.s.A(r2)
            r0 = r3
        L3a:
            com.cupidapp.live.profile.model.User r0 = r0.getOtherUser()
            java.lang.String r0 = r0.userId()
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r1 = r5.this$0
            com.cupidapp.live.base.sensorslog.FKSensorContext r1 = com.cupidapp.live.chat2.fragment.ChatDetailFragment.j1(r1)
            com.cupidapp.live.base.sensorslog.SensorPosition r1 = r1.getPosition()
            r6.l(r0, r1)
            goto L8e
        L50:
            if (r6 == 0) goto L59
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.f0(r6)
            com.cupidapp.live.chat2.model.ChatMessageModel r6 = (com.cupidapp.live.chat2.model.ChatMessageModel) r6
            goto L5a
        L59:
            r6 = r3
        L5a:
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L76
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r4 = r5.this$0
            com.cupidapp.live.chat2.model.ChatBundleData r4 = com.cupidapp.live.chat2.fragment.ChatDetailFragment.f1(r4)
            if (r4 != 0) goto L6a
            kotlin.jvm.internal.s.A(r2)
            r4 = r3
        L6a:
            boolean r4 = r4.isShowMineEmojiSvga()
            boolean r4 = r6.isMineMsgShowSvga(r4)
            if (r4 != r0) goto L76
            r4 = 1
            goto L77
        L76:
            r4 = 0
        L77:
            if (r4 != 0) goto L85
            if (r6 == 0) goto L82
            boolean r4 = r6.isOtherMsgShowSvga()
            if (r4 != r0) goto L82
            goto L83
        L82:
            r0 = 0
        L83:
            if (r0 == 0) goto L8e
        L85:
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r0 = r5.this$0
            java.lang.String r6 = r6.getText()
            com.cupidapp.live.chat2.fragment.ChatDetailFragment.u1(r0, r6)
        L8e:
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r6 = r5.this$0
            com.cupidapp.live.chat2.fragment.ChatDetailFragment.p1(r6)
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r6 = r5.this$0
            com.cupidapp.live.chat2.model.ChatBundleData r6 = com.cupidapp.live.chat2.fragment.ChatDetailFragment.f1(r6)
            if (r6 != 0) goto L9f
            kotlin.jvm.internal.s.A(r2)
            goto La0
        L9f:
            r3 = r6
        La0:
            boolean r6 = r3.isShowKeyboard()
            if (r6 == 0) goto Lbc
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r6 = r5.this$0
            int r0 = com.cupidapp.live.R$id.chat_detail_input_panel_layout
            android.view.View r6 = r6.d1(r0)
            com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout r6 = (com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout) r6
            if (r6 == 0) goto Lbc
            com.cupidapp.live.chat2.fragment.ChatDetailFragment r0 = r5.this$0
            com.cupidapp.live.chat2.fragment.m r1 = new com.cupidapp.live.chat2.fragment.m
            r1.<init>()
            r6.post(r1)
        Lbc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cupidapp.live.chat2.fragment.ChatDetailFragment$initObserve$2.invoke2(java.util.List):void");
    }
}
