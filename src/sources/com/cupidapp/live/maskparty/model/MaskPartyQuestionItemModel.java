package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyQuestionModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyQuestionItemModel {

    @NotNull
    private final String content;
    private final int index;

    public MaskPartyQuestionItemModel(int i10, @NotNull String content) {
        s.i(content, "content");
        this.index = i10;
        this.content = content;
    }

    public static /* synthetic */ MaskPartyQuestionItemModel copy$default(MaskPartyQuestionItemModel maskPartyQuestionItemModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = maskPartyQuestionItemModel.index;
        }
        if ((i11 & 2) != 0) {
            str = maskPartyQuestionItemModel.content;
        }
        return maskPartyQuestionItemModel.copy(i10, str);
    }

    public final int component1() {
        return this.index;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final MaskPartyQuestionItemModel copy(int i10, @NotNull String content) {
        s.i(content, "content");
        return new MaskPartyQuestionItemModel(i10, content);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyQuestionItemModel)) {
            return false;
        }
        MaskPartyQuestionItemModel maskPartyQuestionItemModel = (MaskPartyQuestionItemModel) obj;
        return this.index == maskPartyQuestionItemModel.index && s.d(this.content, maskPartyQuestionItemModel.content);
    }

    @NotNull
    public final String getContent() {
        return this.content;
    }

    public final int getIndex() {
        return this.index;
    }

    public int hashCode() {
        return (this.index * 31) + this.content.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyQuestionItemModel(index=" + this.index + ", content=" + this.content + ")";
    }
}
