package com.cupidapp.live.voiceparty.layout;

import com.cupidapp.live.R$mipmap;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoiceQuestionLayout.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum VoiceQuestionType {
    Love(1, R$mipmap.icon_question_love),
    Adventure(2, R$mipmap.icon_question_adventure),
    LateNight(4, R$mipmap.icon_question_late_night);


    @NotNull
    public static final a Companion = new a(null);
    private final int type;
    private final int typeImage;

    /* compiled from: VoiceQuestionLayout.kt */
    @d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final VoiceQuestionType a(int i10) {
            VoiceQuestionType voiceQuestionType = VoiceQuestionType.Love;
            if (i10 == voiceQuestionType.getType()) {
                return voiceQuestionType;
            }
            VoiceQuestionType voiceQuestionType2 = VoiceQuestionType.Adventure;
            if (i10 == voiceQuestionType2.getType()) {
                return voiceQuestionType2;
            }
            VoiceQuestionType voiceQuestionType3 = VoiceQuestionType.LateNight;
            if (i10 == voiceQuestionType3.getType()) {
                return voiceQuestionType3;
            }
            return null;
        }
    }

    VoiceQuestionType(int i10, int i11) {
        this.type = i10;
        this.typeImage = i11;
    }

    public final int getType() {
        return this.type;
    }

    public final int getTypeImage() {
        return this.typeImage;
    }
}
