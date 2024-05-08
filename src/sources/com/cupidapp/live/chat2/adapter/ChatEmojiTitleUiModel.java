package com.cupidapp.live.chat2.adapter;

import androidx.annotation.DrawableRes;
import kotlin.d;

/* compiled from: ChatEmojiTitleAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ChatEmojiTitleUiModel {
    private final int imageResId;
    private boolean isSelected;

    public ChatEmojiTitleUiModel(@DrawableRes int i10, boolean z10) {
        this.imageResId = i10;
        this.isSelected = z10;
    }

    public final int getImageResId() {
        return this.imageResId;
    }

    public final boolean isSelected() {
        return this.isSelected;
    }

    public final void setSelected(boolean z10) {
        this.isSelected = z10;
    }
}
