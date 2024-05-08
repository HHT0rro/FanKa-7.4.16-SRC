package com.cupidapp.live.chat2.helper;

import com.cupidapp.live.chat.model.MessagePostModel;
import com.cupidapp.live.chat2.model.ChatMessageModel;
import com.cupidapp.live.chat2.model.ChatMessageType;
import com.cupidapp.live.chat2.model.ChatNoticeBtnType;
import com.cupidapp.live.chat2.model.MessageSendState;
import com.cupidapp.live.feed.model.FeedModel;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ChatSendMessageHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f13369a = new g();

    public static /* synthetic */ ChatMessageModel e(g gVar, String str, ChatNoticeBtnType chatNoticeBtnType, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            chatNoticeBtnType = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return gVar.d(str, chatNoticeBtnType, str2);
    }

    public final ChatMessageModel a(String str) {
        return new ChatMessageModel(null, ChatMessageType.InboxMessageImage.getValue(), null, true, null, null, System.currentTimeMillis(), null, MessageSendState.Sending, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147475125, null);
    }

    public final ChatMessageModel b(String str, Integer num) {
        return new ChatMessageModel(null, ChatMessageType.InboxMessageText.getValue(), null, true, null, null, System.currentTimeMillis(), null, MessageSendState.Sending, null, str, num, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147480245, null);
    }

    @NotNull
    public final ChatMessageModel c(@Nullable Boolean bool, @NotNull String path) {
        s.i(path, "path");
        if (s.d(bool, Boolean.TRUE)) {
            return g(path);
        }
        return a(path);
    }

    @NotNull
    public final ChatMessageModel d(@NotNull String notice, @Nullable ChatNoticeBtnType chatNoticeBtnType, @Nullable String str) {
        s.i(notice, "notice");
        return new ChatMessageModel(null, ChatMessageType.InboxMessageNotice.getValue(), null, true, null, null, System.currentTimeMillis(), null, MessageSendState.Sending, null, str, null, null, null, null, null, null, null, null, notice, chatNoticeBtnType, null, null, null, null, null, null, null, null, null, null, 2145909429, null);
    }

    @Nullable
    public final ChatMessageModel f(@Nullable FeedModel feedModel) {
        if (feedModel == null) {
            return null;
        }
        return new ChatMessageModel(null, ChatMessageType.InboxMessagePostReferer.getValue(), null, true, null, null, System.currentTimeMillis(), null, MessageSendState.Sending, null, null, null, null, null, null, null, null, null, null, null, null, new MessagePostModel(feedModel.getPostId(), feedModel.getType(), feedModel.getImageListFirst(), feedModel.getVideo()), null, null, null, null, null, null, null, null, null, 2145386165, null);
    }

    public final ChatMessageModel g(String str) {
        return new ChatMessageModel(null, ChatMessageType.InboxMessageSnapImage.getValue(), null, true, null, null, System.currentTimeMillis(), null, MessageSendState.Sending, null, null, null, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147475125, null);
    }

    public final ChatMessageModel h(String str) {
        return new ChatMessageModel(null, ChatMessageType.InboxMessageSnapText.getValue(), null, true, null, null, System.currentTimeMillis(), null, MessageSendState.Sending, null, str, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147482293, null);
    }

    @NotNull
    public final ChatMessageModel i() {
        return new ChatMessageModel(null, ChatMessageType.InboxMessageUserLabel.getValue(), null, true, null, null, System.currentTimeMillis(), null, MessageSendState.Sending, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 2147483317, null);
    }

    @NotNull
    public final ChatMessageModel j(@Nullable Boolean bool, @NotNull String text, @Nullable Integer num) {
        s.i(text, "text");
        if (s.d(bool, Boolean.TRUE)) {
            return h(text);
        }
        return b(text, num);
    }

    @NotNull
    public final ChatMessageModel k(@NotNull ChatMessageModel model) {
        s.i(model, "model");
        model.setMessageSendState(MessageSendState.Resend);
        return model;
    }
}
