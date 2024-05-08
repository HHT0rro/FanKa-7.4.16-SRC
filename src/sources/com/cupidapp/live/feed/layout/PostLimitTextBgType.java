package com.cupidapp.live.feed.layout;

import androidx.annotation.ColorRes;
import com.cupidapp.live.R$color;

/* compiled from: PostLimitCreateTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PostLimitTextBgType {
    NO_BG_WHITE_TEXT(R$color.app_transparent, R$color.white_FEFFFE),
    WHITE_BG_BLACK_TEXT(R$color.app_white, R$color.text_black),
    BLACK_BG_WHITE_TEXT(R$color.app_black, R$color.app_white),
    NO_BG_BLACK_TEXT(R$color.app_transparent, R$color.text_black);

    private final int bgColorResId;
    private final int textColorResId;

    PostLimitTextBgType(@ColorRes int i10, @ColorRes int i11) {
        this.bgColorResId = i10;
        this.textColorResId = i11;
    }

    public final int getBgColorResId() {
        return this.bgColorResId;
    }

    public final int getTextColorResId() {
        return this.textColorResId;
    }
}
