package com.cupidapp.live.chat2.holder;

import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatSystemEmojiPagerViewHolder.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatSystemEmojiPagerUiModel {

    @NotNull
    private final List<String> emojiList;

    public ChatSystemEmojiPagerUiModel(@NotNull List<String> emojiList) {
        s.i(emojiList, "emojiList");
        this.emojiList = emojiList;
    }

    @NotNull
    public final List<String> getEmojiList() {
        return this.emojiList;
    }
}
