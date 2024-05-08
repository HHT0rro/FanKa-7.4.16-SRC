package com.cupidapp.live.club.helper;

import com.cupidapp.live.chat2.model.ChatNoticeBtnType;
import com.cupidapp.live.chat2.model.MessageSendState;
import com.cupidapp.live.club.model.ClubChatMessageType;
import com.cupidapp.live.club.model.ClubChatMsgModel;
import com.cupidapp.live.club.model.QuoteInfoModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubChatSendMessageHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a */
    @NotNull
    public static final a f13611a = new a();

    public static /* synthetic */ ClubChatMsgModel c(a aVar, String str, ChatNoticeBtnType chatNoticeBtnType, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            chatNoticeBtnType = null;
        }
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return aVar.b(str, chatNoticeBtnType, str2);
    }

    @NotNull
    public final ClubChatMsgModel a(@NotNull String path) {
        s.i(path, "path");
        return new ClubChatMsgModel(null, ClubChatMessageType.InboxMessageImage.getValue(), true, null, System.currentTimeMillis(), MessageSendState.Sending, null, null, null, null, path, null, null, null, null, null, null, null, null, null, null, null, null, null, 16776137, null);
    }

    @NotNull
    public final ClubChatMsgModel b(@NotNull String notice, @Nullable ChatNoticeBtnType chatNoticeBtnType, @Nullable String str) {
        s.i(notice, "notice");
        return new ClubChatMsgModel(null, ClubChatMessageType.InboxMessageNotice.getValue(), true, null, System.currentTimeMillis(), MessageSendState.Sending, null, null, notice, null, null, str, chatNoticeBtnType, null, null, null, null, null, null, null, null, null, null, null, 16770761, null);
    }

    @NotNull
    public final ClubChatMsgModel d(@NotNull String text, @Nullable ClubChatMsgModel clubChatMsgModel) {
        QuoteInfoModel quoteInfoModel;
        s.i(text, "text");
        if (clubChatMsgModel == null) {
            quoteInfoModel = null;
        } else {
            String messageId = clubChatMsgModel.getMessageId();
            String type = clubChatMsgModel.getType();
            Boolean bool = Boolean.FALSE;
            User sender = clubChatMsgModel.getSender();
            quoteInfoModel = new QuoteInfoModel(messageId, type, bool, sender != null ? sender.getName() : null, clubChatMsgModel.getMsgListQuoteText(), clubChatMsgModel.getImage(), clubChatMsgModel.getImagePath(), clubChatMsgModel.getJumpUrl());
        }
        return new ClubChatMsgModel(null, ClubChatMessageType.InboxMessageText.getValue(), true, null, System.currentTimeMillis(), MessageSendState.Sending, null, null, text, null, null, null, null, null, null, null, null, null, null, null, null, quoteInfoModel, null, null, 14679753, null);
    }

    @NotNull
    public final ClubChatMsgModel e(@NotNull ClubChatMsgModel model) {
        s.i(model, "model");
        model.setMessageSendState(MessageSendState.Resend);
        return model;
    }
}
