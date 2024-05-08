package com.cupidapp.live.maskparty.view;

import com.cupidapp.live.R$mipmap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyQuestionLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public enum QuestionType {
    Love(1, R$mipmap.icon_question_love, R$mipmap.icon_question_love_title),
    Adventure(2, R$mipmap.icon_question_adventure, R$mipmap.icon_question_adventure_title),
    Dramatic(3, R$mipmap.icon_question_dramatic, R$mipmap.icon_question_dramatic_title);


    @NotNull
    public static final a Companion = new a(null);
    private final int type;
    private final int typeImage;
    private final int typeTitle;

    /* compiled from: MaskPartyQuestionLayout.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final QuestionType a(int i10) {
            QuestionType questionType = QuestionType.Love;
            if (i10 == questionType.getType()) {
                return questionType;
            }
            QuestionType questionType2 = QuestionType.Adventure;
            if (i10 == questionType2.getType()) {
                return questionType2;
            }
            QuestionType questionType3 = QuestionType.Dramatic;
            if (i10 == questionType3.getType()) {
                return questionType3;
            }
            return null;
        }
    }

    QuestionType(int i10, int i11, int i12) {
        this.type = i10;
        this.typeImage = i11;
        this.typeTitle = i12;
    }

    public final int getType() {
        return this.type;
    }

    public final int getTypeImage() {
        return this.typeImage;
    }

    public final int getTypeTitle() {
        return this.typeTitle;
    }
}
