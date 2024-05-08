package w1;

import com.cupidapp.live.R$mipmap;
import com.cupidapp.live.chat.model.CustomEmojiCode;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MessageEmojiCode.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f54094a = new a();

    public final int a(@Nullable String str) {
        if (s.d(str, CustomEmojiCode.Smile.getEmojiCNCode())) {
            return R$mipmap.smilling_face;
        }
        if (s.d(str, CustomEmojiCode.Happy.getEmojiCNCode())) {
            return R$mipmap.grinning_face_smiling_eyes;
        }
        if (s.d(str, CustomEmojiCode.Snicker.getEmojiCNCode())) {
            return R$mipmap.smirking_face;
        }
        if (s.d(str, CustomEmojiCode.Greet.getEmojiCNCode())) {
            return R$mipmap.hi_hand;
        }
        if (s.d(str, CustomEmojiCode.Wow.getEmojiCNCode())) {
            return R$mipmap.smilling_face_with_heart_shaped_eyes;
        }
        if (s.d(str, CustomEmojiCode.WaterPistol.getEmojiCNCode())) {
            return R$mipmap.ic_zi_water;
        }
        if (s.d(str, CustomEmojiCode.PatPat.getEmojiCNCode())) {
            return R$mipmap.ic_paste;
        }
        if (s.d(str, CustomEmojiCode.Poke.getEmojiCNCode())) {
            return R$mipmap.ic_poke;
        }
        if (s.d(str, CustomEmojiCode.TouchHead.getEmojiCNCode())) {
            return R$mipmap.ic_touch_head;
        }
        if (s.d(str, CustomEmojiCode.PinchFace.getEmojiCNCode())) {
            return R$mipmap.ic_pinch_face;
        }
        if (s.d(str, CustomEmojiCode.ThanHeart.getEmojiCNCode())) {
            return R$mipmap.ic_than_heart;
        }
        return -1;
    }

    @Nullable
    public final String b(@Nullable String str) {
        if (s.d(str, CustomEmojiCode.Greet.getEmojiCNCode())) {
            return "hi.svga";
        }
        if (s.d(str, CustomEmojiCode.WaterPistol.getEmojiCNCode())) {
            return "water.svga";
        }
        if (s.d(str, CustomEmojiCode.PatPat.getEmojiCNCode())) {
            return "pat.svga";
        }
        if (s.d(str, CustomEmojiCode.Poke.getEmojiCNCode())) {
            return "poke.svga";
        }
        if (s.d(str, CustomEmojiCode.TouchHead.getEmojiCNCode())) {
            return "head.svga";
        }
        if (s.d(str, CustomEmojiCode.PinchFace.getEmojiCNCode())) {
            return "face.svga";
        }
        if (s.d(str, CustomEmojiCode.ThanHeart.getEmojiCNCode())) {
            return "heart.svga";
        }
        return null;
    }
}
