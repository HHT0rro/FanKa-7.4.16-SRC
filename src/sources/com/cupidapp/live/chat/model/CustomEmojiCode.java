package com.cupidapp.live.chat.model;

import androidx.annotation.DrawableRes;
import com.cupidapp.live.R$mipmap;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MessageEmojiCode.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public enum CustomEmojiCode {
    Smile("微笑", "[微笑]", R$mipmap.smilling_face),
    Happy("开心", "[开心]", R$mipmap.grinning_face_smiling_eyes),
    Snicker("坏笑", "[坏笑]", R$mipmap.smirking_face),
    Greet("Hi", "[Hi]", R$mipmap.hi_hand),
    Wow("WOW", "[WOW]", R$mipmap.smilling_face_with_heart_shaped_eyes),
    WaterPistol("WaterPistol", "[滋水枪]", R$mipmap.ic_zi_water),
    PatPat("PatPat", "[贴贴]", R$mipmap.ic_paste),
    Poke("Poke", "[戳一下]", R$mipmap.ic_poke),
    TouchHead("TouchHead", "[摸摸头]", R$mipmap.ic_touch_head),
    PinchFace("PinchFace", "[捏捏脸]", R$mipmap.ic_pinch_face),
    ThanHeart("Heart", "[比个心]", R$mipmap.ic_than_heart);


    @NotNull
    private final String emojiCNCode;

    @NotNull
    private final String emojiEnCode;
    private final int imageResId;

    CustomEmojiCode(String str, String str2, @DrawableRes int i10) {
        this.emojiEnCode = str;
        this.emojiCNCode = str2;
        this.imageResId = i10;
    }

    @NotNull
    public final String getEmojiCNCode() {
        return this.emojiCNCode;
    }

    @NotNull
    public final String getEmojiEnCode() {
        return this.emojiEnCode;
    }

    public final int getImageResId() {
        return this.imageResId;
    }
}
