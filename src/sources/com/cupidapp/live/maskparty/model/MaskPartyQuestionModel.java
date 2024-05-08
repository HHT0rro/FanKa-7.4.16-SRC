package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyQuestionModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyQuestionModel {

    @NotNull
    private final List<MaskPartyQuestionItemModel> questions;
    private final int type;

    @NotNull
    private final String typeName;

    public MaskPartyQuestionModel(int i10, @NotNull String typeName, @NotNull List<MaskPartyQuestionItemModel> questions) {
        s.i(typeName, "typeName");
        s.i(questions, "questions");
        this.type = i10;
        this.typeName = typeName;
        this.questions = questions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaskPartyQuestionModel copy$default(MaskPartyQuestionModel maskPartyQuestionModel, int i10, String str, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = maskPartyQuestionModel.type;
        }
        if ((i11 & 2) != 0) {
            str = maskPartyQuestionModel.typeName;
        }
        if ((i11 & 4) != 0) {
            list = maskPartyQuestionModel.questions;
        }
        return maskPartyQuestionModel.copy(i10, str, list);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.typeName;
    }

    @NotNull
    public final List<MaskPartyQuestionItemModel> component3() {
        return this.questions;
    }

    @NotNull
    public final MaskPartyQuestionModel copy(int i10, @NotNull String typeName, @NotNull List<MaskPartyQuestionItemModel> questions) {
        s.i(typeName, "typeName");
        s.i(questions, "questions");
        return new MaskPartyQuestionModel(i10, typeName, questions);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyQuestionModel)) {
            return false;
        }
        MaskPartyQuestionModel maskPartyQuestionModel = (MaskPartyQuestionModel) obj;
        return this.type == maskPartyQuestionModel.type && s.d(this.typeName, maskPartyQuestionModel.typeName) && s.d(this.questions, maskPartyQuestionModel.questions);
    }

    @NotNull
    public final List<MaskPartyQuestionItemModel> getQuestions() {
        return this.questions;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }

    public int hashCode() {
        return (((this.type * 31) + this.typeName.hashCode()) * 31) + this.questions.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyQuestionModel(type=" + this.type + ", typeName=" + this.typeName + ", questions=" + ((Object) this.questions) + ")";
    }
}
