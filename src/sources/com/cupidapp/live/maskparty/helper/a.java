package com.cupidapp.live.maskparty.helper;

import com.cupidapp.live.maskparty.model.MaskPartyChatDiceModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageModel;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageSendState;
import com.cupidapp.live.maskparty.model.MaskPartyChatMessageType;
import com.cupidapp.live.maskparty.model.MaskPartyChatNotifyMessageModel;
import com.cupidapp.live.maskparty.model.MessageActionType;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyChatSendMessageHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f16351a = new a();

    public static /* synthetic */ MaskPartyChatMessageModel c(a aVar, MaskPartyChatDiceModel maskPartyChatDiceModel, boolean z10, User user, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            user = null;
        }
        return aVar.b(maskPartyChatDiceModel, z10, user);
    }

    public final MaskPartyChatMessageModel a(String str) {
        return new MaskPartyChatMessageModel(null, null, MaskPartyChatMessageType.InboxMessageImage.getValue(), true, null, System.currentTimeMillis(), MaskPartyChatMessageSendState.Sending, false, null, null, null, null, str, null, null, null, null, null, null, null, null, false, 4190099, null);
    }

    @NotNull
    public final MaskPartyChatMessageModel b(@NotNull MaskPartyChatDiceModel dice, boolean z10, @Nullable User user) {
        s.i(dice, "dice");
        return new MaskPartyChatMessageModel(null, null, MaskPartyChatMessageType.InboxMessageDice.getValue(), user == null, user, System.currentTimeMillis(), null, z10, null, null, null, null, null, null, null, null, null, null, null, null, dice, false, 3145539, null);
    }

    @NotNull
    public final MaskPartyChatMessageModel d(@Nullable Boolean bool, @NotNull String path) {
        s.i(path, "path");
        if (s.d(bool, Boolean.TRUE)) {
            return g(path);
        }
        return a(path);
    }

    @NotNull
    public final MaskPartyChatMessageModel e(@NotNull String text, @NotNull User sender, boolean z10) {
        s.i(text, "text");
        s.i(sender, "sender");
        return new MaskPartyChatMessageModel(null, null, MaskPartyChatMessageType.InboxMessageText.getValue(), false, sender, System.currentTimeMillis(), null, z10, null, MessageActionType.AutoInsertSysMessage, text, null, null, null, null, null, null, null, null, null, null, false, 4192579, null);
    }

    @NotNull
    public final MaskPartyChatMessageModel f(@Nullable MaskPartyChatNotifyMessageModel maskPartyChatNotifyMessageModel, @Nullable String str) {
        return new MaskPartyChatMessageModel(null, null, MaskPartyChatMessageType.InboxMessageNotice.getValue(), true, null, System.currentTimeMillis(), null, false, null, null, null, null, null, null, null, null, null, null, null, maskPartyChatNotifyMessageModel == null ? new MaskPartyChatNotifyMessageModel(null, str, null, null, null, null, null, 125, null) : maskPartyChatNotifyMessageModel, null, false, 3669971, null);
    }

    public final MaskPartyChatMessageModel g(String str) {
        return new MaskPartyChatMessageModel(null, null, MaskPartyChatMessageType.InboxMessageSnapImage.getValue(), true, null, System.currentTimeMillis(), MaskPartyChatMessageSendState.Sending, false, null, null, null, null, str, null, null, null, null, null, null, null, null, false, 4190099, null);
    }

    @NotNull
    public final MaskPartyChatMessageModel h(@NotNull String text, @NotNull MessageActionType type) {
        s.i(text, "text");
        s.i(type, "type");
        return new MaskPartyChatMessageModel(null, null, MaskPartyChatMessageType.InboxMessageText.getValue(), true, null, System.currentTimeMillis(), MaskPartyChatMessageSendState.Sending, false, null, type, text, null, null, null, null, null, null, null, null, null, null, false, 4192659, null);
    }
}
