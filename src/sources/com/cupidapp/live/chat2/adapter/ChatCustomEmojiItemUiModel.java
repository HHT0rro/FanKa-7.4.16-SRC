package com.cupidapp.live.chat2.adapter;

import androidx.annotation.DrawableRes;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: ChatCustomEmojiItemAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatCustomEmojiItemUiModel {
    private final int imageResId;

    @NotNull
    private final String name;

    @NotNull
    private final String textMessage;

    public ChatCustomEmojiItemUiModel(@NotNull String name, @DrawableRes int i10, @NotNull String textMessage) {
        s.i(name, "name");
        s.i(textMessage, "textMessage");
        this.name = name;
        this.imageResId = i10;
        this.textMessage = textMessage;
    }

    public final int getImageResId() {
        return this.imageResId;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getTextMessage() {
        return this.textMessage;
    }
}
