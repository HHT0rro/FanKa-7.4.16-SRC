package com.cupidapp.live.chat2.fragment;

import com.cupidapp.live.R$id;
import com.cupidapp.live.chat2.model.ChatPanelType;
import com.cupidapp.live.chat2.view.ChatDetailInputPanelLayout;
import com.cupidapp.live.chat2.view.ChatTopicLayout;
import com.cupidapp.live.profile.model.ZodiacElfInfoModel;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatDetailFragment.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatDetailFragment$initObserve$16 extends Lambda implements Function1<List<? extends ZodiacElfInfoModel>, p> {
    public final /* synthetic */ ChatDetailFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatDetailFragment$initObserve$16(ChatDetailFragment chatDetailFragment) {
        super(1);
        this.this$0 = chatDetailFragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(ChatDetailFragment this$0) {
        s.i(this$0, "this$0");
        ChatDetailInputPanelLayout chatDetailInputPanelLayout = (ChatDetailInputPanelLayout) this$0.d1(R$id.chat_detail_input_panel_layout);
        if (chatDetailInputPanelLayout != null) {
            chatDetailInputPanelLayout.M(ChatPanelType.CHAT_TOPIC);
        }
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ p invoke(List<? extends ZodiacElfInfoModel> list) {
        invoke2((List<ZodiacElfInfoModel>) list);
        return p.f51048a;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<ZodiacElfInfoModel> list) {
        s.i(list, "list");
        ((ChatTopicLayout) this.this$0.d1(R$id.chat_detail_topic_layout)).r(list);
        ChatDetailInputPanelLayout chatDetailInputPanelLayout = (ChatDetailInputPanelLayout) this.this$0.d1(R$id.chat_detail_input_panel_layout);
        if (chatDetailInputPanelLayout != null) {
            final ChatDetailFragment chatDetailFragment = this.this$0;
            chatDetailInputPanelLayout.post(new Runnable() { // from class: com.cupidapp.live.chat2.fragment.l
                @Override // java.lang.Runnable
                public final void run() {
                    ChatDetailFragment$initObserve$16.invoke$lambda$0(ChatDetailFragment.this);
                }
            });
        }
    }
}
