package com.cupidapp.live.voiceparty.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyQuestionModel implements Serializable {
    private final boolean canSelect;

    @Nullable
    private final String desc;

    @Nullable
    private final List<VoicePartyQuestionItemModel> questions;
    private final int type;

    @NotNull
    private final String typeName;

    public VoicePartyQuestionModel(int i10, @NotNull String typeName, boolean z10, @Nullable String str, @Nullable List<VoicePartyQuestionItemModel> list) {
        s.i(typeName, "typeName");
        this.type = i10;
        this.typeName = typeName;
        this.canSelect = z10;
        this.desc = str;
        this.questions = list;
    }

    public static /* synthetic */ VoicePartyQuestionModel copy$default(VoicePartyQuestionModel voicePartyQuestionModel, int i10, String str, boolean z10, String str2, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = voicePartyQuestionModel.type;
        }
        if ((i11 & 2) != 0) {
            str = voicePartyQuestionModel.typeName;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            z10 = voicePartyQuestionModel.canSelect;
        }
        boolean z11 = z10;
        if ((i11 & 8) != 0) {
            str2 = voicePartyQuestionModel.desc;
        }
        String str4 = str2;
        if ((i11 & 16) != 0) {
            list = voicePartyQuestionModel.questions;
        }
        return voicePartyQuestionModel.copy(i10, str3, z11, str4, list);
    }

    public final int component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.typeName;
    }

    public final boolean component3() {
        return this.canSelect;
    }

    @Nullable
    public final String component4() {
        return this.desc;
    }

    @Nullable
    public final List<VoicePartyQuestionItemModel> component5() {
        return this.questions;
    }

    @NotNull
    public final VoicePartyQuestionModel copy(int i10, @NotNull String typeName, boolean z10, @Nullable String str, @Nullable List<VoicePartyQuestionItemModel> list) {
        s.i(typeName, "typeName");
        return new VoicePartyQuestionModel(i10, typeName, z10, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoicePartyQuestionModel)) {
            return false;
        }
        VoicePartyQuestionModel voicePartyQuestionModel = (VoicePartyQuestionModel) obj;
        return this.type == voicePartyQuestionModel.type && s.d(this.typeName, voicePartyQuestionModel.typeName) && this.canSelect == voicePartyQuestionModel.canSelect && s.d(this.desc, voicePartyQuestionModel.desc) && s.d(this.questions, voicePartyQuestionModel.questions);
    }

    public final boolean getCanSelect() {
        return this.canSelect;
    }

    @Nullable
    public final String getDesc() {
        return this.desc;
    }

    @Nullable
    public final List<VoicePartyQuestionItemModel> getQuestions() {
        return this.questions;
    }

    public final int getType() {
        return this.type;
    }

    @NotNull
    public final String getTypeName() {
        return this.typeName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.type * 31) + this.typeName.hashCode()) * 31;
        boolean z10 = this.canSelect;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode + i10) * 31;
        String str = this.desc;
        int hashCode2 = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        List<VoicePartyQuestionItemModel> list = this.questions;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VoicePartyQuestionModel(type=" + this.type + ", typeName=" + this.typeName + ", canSelect=" + this.canSelect + ", desc=" + this.desc + ", questions=" + ((Object) this.questions) + ")";
    }
}
