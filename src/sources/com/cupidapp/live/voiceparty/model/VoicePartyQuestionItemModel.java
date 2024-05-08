package com.cupidapp.live.voiceparty.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VoicePartyModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class VoicePartyQuestionItemModel implements Serializable {

    @NotNull
    private final String content;
    private final int index;

    public VoicePartyQuestionItemModel(int i10, @NotNull String content) {
        s.i(content, "content");
        this.index = i10;
        this.content = content;
    }

    public static /* synthetic */ VoicePartyQuestionItemModel copy$default(VoicePartyQuestionItemModel voicePartyQuestionItemModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = voicePartyQuestionItemModel.index;
        }
        if ((i11 & 2) != 0) {
            str = voicePartyQuestionItemModel.content;
        }
        return voicePartyQuestionItemModel.copy(i10, str);
    }

    public final int component1() {
        return this.index;
    }

    @NotNull
    public final String component2() {
        return this.content;
    }

    @NotNull
    public final VoicePartyQuestionItemModel copy(int i10, @NotNull String content) {
        s.i(content, "content");
        return new VoicePartyQuestionItemModel(i10, content);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof VoicePartyQuestionItemModel)) {
            return false;
        }
        VoicePartyQuestionItemModel voicePartyQuestionItemModel = (VoicePartyQuestionItemModel) obj;
        return this.index == voicePartyQuestionItemModel.index && s.d(this.content, voicePartyQuestionItemModel.content);
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
        return "VoicePartyQuestionItemModel(index=" + this.index + ", content=" + this.content + ")";
    }
}
