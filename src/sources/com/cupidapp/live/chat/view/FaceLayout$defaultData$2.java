package com.cupidapp.live.chat.view;

import com.cupidapp.live.chat.model.CustomEmojiCode;
import java.util.List;
import kotlin.collections.s;
import kotlin.d;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: FaceLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FaceLayout$defaultData$2 extends Lambda implements Function0<List<CustomEmojiCode>> {
    public static final FaceLayout$defaultData$2 INSTANCE = new FaceLayout$defaultData$2();

    public FaceLayout$defaultData$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final List<CustomEmojiCode> invoke() {
        return s.o(CustomEmojiCode.Greet, CustomEmojiCode.WaterPistol, CustomEmojiCode.PatPat, CustomEmojiCode.Poke, CustomEmojiCode.TouchHead, CustomEmojiCode.PinchFace, CustomEmojiCode.ThanHeart);
    }
}
