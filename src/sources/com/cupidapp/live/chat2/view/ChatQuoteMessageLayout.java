package com.cupidapp.live.chat2.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.cupidapp.live.R$id;
import com.cupidapp.live.R$layout;
import com.cupidapp.live.R$string;
import com.cupidapp.live.base.imageloader.ImageLoaderView;
import com.cupidapp.live.base.router.j;
import com.cupidapp.live.chat2.activity.ChatLookTextActivity;
import com.cupidapp.live.club.model.ClubChatMessageType;
import com.cupidapp.live.club.model.QuoteInfoModel;
import com.cupidapp.live.maskparty.activity.ChatLookImageActivity;
import com.cupidapp.live.maskparty.activity.ChatLookImageData;
import com.cupidapp.live.track.group.EventTrackMessageType;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z0.y;
import z0.z;

/* compiled from: ChatQuoteMessageLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatQuoteMessageLayout extends FrameLayout {

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13451b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatQuoteMessageLayout(@NotNull Context context) {
        super(context);
        s.i(context, "context");
        this.f13451b = new LinkedHashMap();
        c();
    }

    @Nullable
    public View a(int i10) {
        Map<Integer, View> map = this.f13451b;
        View view = map.get(Integer.valueOf(i10));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i10);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i10), findViewById);
        return findViewById;
    }

    public final void b(@NotNull final QuoteInfoModel model) {
        s.i(model, "model");
        if (s.d(model.getCancel(), Boolean.TRUE)) {
            ((TextView) a(R$id.chat_quote_msg_text)).setText(model.getText());
            ((ImageLoaderView) a(R$id.chat_quote_msg_img)).setVisibility(8);
            ConstraintLayout chat_quote_meg_root_layout = (ConstraintLayout) a(R$id.chat_quote_meg_root_layout);
            s.h(chat_quote_meg_root_layout, "chat_quote_meg_root_layout");
            y.d(chat_quote_meg_root_layout, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatQuoteMessageLayout$configQuoteMessageData$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                }
            });
            return;
        }
        String type = model.getType();
        boolean z10 = true;
        if (s.d(type, ClubChatMessageType.InboxMessageImage.getValue())) {
            ((TextView) a(R$id.chat_quote_msg_text)).setText(getContext().getString(R$string.feed_comment_user, model.getNickname()));
            int i10 = R$id.chat_quote_msg_img;
            ((ImageLoaderView) a(i10)).setVisibility(0);
            String imagePath = model.getImagePath();
            if (imagePath != null && imagePath.length() != 0) {
                z10 = false;
            }
            if (!z10) {
                ImageLoaderView chat_quote_msg_img = (ImageLoaderView) a(i10);
                s.h(chat_quote_msg_img, "chat_quote_msg_img");
                ImageLoaderView.f(chat_quote_msg_img, new com.cupidapp.live.base.imageloader.b(false, model.getImagePath(), null, null, null, null, null, 0, 0, null, null, null, null, false, 0, 0, false, null, null, 524285, null), null, 2, null);
            } else if (model.getImage() != null) {
                ImageLoaderView chat_quote_msg_img2 = (ImageLoaderView) a(i10);
                s.h(chat_quote_msg_img2, "chat_quote_msg_img");
                ImageLoaderView.g(chat_quote_msg_img2, model.getImage(), null, null, 6, null);
            }
            ConstraintLayout chat_quote_meg_root_layout2 = (ConstraintLayout) a(R$id.chat_quote_meg_root_layout);
            s.h(chat_quote_meg_root_layout2, "chat_quote_meg_root_layout");
            y.d(chat_quote_meg_root_layout2, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatQuoteMessageLayout$configQuoteMessageData$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    z3.b.f54828a.e(EventTrackMessageType.QUOTE, QuoteInfoModel.this.getMessageId());
                    ChatLookImageActivity.f16224r.a(this.getContext(), new ChatLookImageData(QuoteInfoModel.this.getImage(), QuoteInfoModel.this.getImagePath(), null));
                }
            });
            return;
        }
        if (s.d(type, ClubChatMessageType.InboxMessageText.getValue())) {
            ((TextView) a(R$id.chat_quote_msg_text)).setText(getContext().getString(R$string.one_colon_two, model.getNickname(), model.getText()));
            ((ImageLoaderView) a(R$id.chat_quote_msg_img)).setVisibility(8);
            ConstraintLayout chat_quote_meg_root_layout3 = (ConstraintLayout) a(R$id.chat_quote_meg_root_layout);
            s.h(chat_quote_meg_root_layout3, "chat_quote_meg_root_layout");
            y.d(chat_quote_meg_root_layout3, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatQuoteMessageLayout$configQuoteMessageData$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    z3.b.f54828a.e(EventTrackMessageType.QUOTE, QuoteInfoModel.this.getMessageId());
                    ChatLookTextActivity.a aVar = ChatLookTextActivity.f13291r;
                    Context context = this.getContext();
                    s.h(context, "context");
                    aVar.a(context, QuoteInfoModel.this.getText());
                }
            });
            return;
        }
        if (s.d(type, ClubChatMessageType.InboxMessageActivity.getValue())) {
            ((TextView) a(R$id.chat_quote_msg_text)).setText(getContext().getString(R$string.one_colon_two, model.getNickname(), model.getText()));
            ((ImageLoaderView) a(R$id.chat_quote_msg_img)).setVisibility(8);
            ConstraintLayout chat_quote_meg_root_layout4 = (ConstraintLayout) a(R$id.chat_quote_meg_root_layout);
            s.h(chat_quote_meg_root_layout4, "chat_quote_meg_root_layout");
            y.d(chat_quote_meg_root_layout4, new Function1<View, p>() { // from class: com.cupidapp.live.chat2.view.ChatQuoteMessageLayout$configQuoteMessageData$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ p invoke(View view) {
                    invoke2(view);
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable View view) {
                    z3.b.f54828a.e(EventTrackMessageType.QUOTE, QuoteInfoModel.this.getMessageId());
                    j.a.b(com.cupidapp.live.base.router.j.f12156c, this.getContext(), QuoteInfoModel.this.getActivityJumpUrl(), null, 4, null);
                }
            });
        }
    }

    public final void c() {
        z.a(this, R$layout.layout_chat_quote_message, true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatQuoteMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        s.i(context, "context");
        this.f13451b = new LinkedHashMap();
        c();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatQuoteMessageLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        s.i(context, "context");
        this.f13451b = new LinkedHashMap();
        c();
    }
}
