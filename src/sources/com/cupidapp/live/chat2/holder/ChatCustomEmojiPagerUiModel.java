package com.cupidapp.live.chat2.holder;

import com.cupidapp.live.chat2.adapter.ChatCustomEmojiItemUiModel;
import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatCustomEmojiPagerViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatCustomEmojiPagerUiModel {

    @NotNull
    private final List<ChatCustomEmojiItemUiModel> emojiList;

    public ChatCustomEmojiPagerUiModel(@NotNull List<ChatCustomEmojiItemUiModel> emojiList) {
        s.i(emojiList, "emojiList");
        this.emojiList = emojiList;
    }

    @NotNull
    public final List<ChatCustomEmojiItemUiModel> getEmojiList() {
        return this.emojiList;
    }
}
