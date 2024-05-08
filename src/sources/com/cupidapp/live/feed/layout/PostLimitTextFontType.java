package com.cupidapp.live.feed.layout;

import androidx.annotation.FontRes;
import com.cupidapp.live.R$font;

/* compiled from: PostLimitCreateTextLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum PostLimitTextFontType {
    DEFAULT(0),
    YOU_SHE(R$font.youshebiaotihei_2),
    SONG_TI(R$font.stsongti_sc_black),
    SAN_JI(R$font.sanjixingkaijianti_cu_2);

    private final int fontResId;

    PostLimitTextFontType(@FontRes int i10) {
        this.fontResId = i10;
    }

    public final int getFontResId() {
        return this.fontResId;
    }
}
