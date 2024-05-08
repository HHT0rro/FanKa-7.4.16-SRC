package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyScriptTaskModel {

    @NotNull
    private final String characterName;

    @Nullable
    private final GuessIdentityModel identity;

    @Nullable
    private final String prologue;

    @Nullable
    private String story;

    @NotNull
    private final List<MaskPartyScriptTaskItemModel> task;

    public MaskPartyScriptTaskModel(@Nullable String str, @NotNull String characterName, @NotNull List<MaskPartyScriptTaskItemModel> task, @Nullable GuessIdentityModel guessIdentityModel, @Nullable String str2) {
        s.i(characterName, "characterName");
        s.i(task, "task");
        this.prologue = str;
        this.characterName = characterName;
        this.task = task;
        this.identity = guessIdentityModel;
        this.story = str2;
    }

    public static /* synthetic */ MaskPartyScriptTaskModel copy$default(MaskPartyScriptTaskModel maskPartyScriptTaskModel, String str, String str2, List list, GuessIdentityModel guessIdentityModel, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = maskPartyScriptTaskModel.prologue;
        }
        if ((i10 & 2) != 0) {
            str2 = maskPartyScriptTaskModel.characterName;
        }
        String str4 = str2;
        if ((i10 & 4) != 0) {
            list = maskPartyScriptTaskModel.task;
        }
        List list2 = list;
        if ((i10 & 8) != 0) {
            guessIdentityModel = maskPartyScriptTaskModel.identity;
        }
        GuessIdentityModel guessIdentityModel2 = guessIdentityModel;
        if ((i10 & 16) != 0) {
            str3 = maskPartyScriptTaskModel.story;
        }
        return maskPartyScriptTaskModel.copy(str, str4, list2, guessIdentityModel2, str3);
    }

    @Nullable
    public final String component1() {
        return this.prologue;
    }

    @NotNull
    public final String component2() {
        return this.characterName;
    }

    @NotNull
    public final List<MaskPartyScriptTaskItemModel> component3() {
        return this.task;
    }

    @Nullable
    public final GuessIdentityModel component4() {
        return this.identity;
    }

    @Nullable
    public final String component5() {
        return this.story;
    }

    @NotNull
    public final MaskPartyScriptTaskModel copy(@Nullable String str, @NotNull String characterName, @NotNull List<MaskPartyScriptTaskItemModel> task, @Nullable GuessIdentityModel guessIdentityModel, @Nullable String str2) {
        s.i(characterName, "characterName");
        s.i(task, "task");
        return new MaskPartyScriptTaskModel(str, characterName, task, guessIdentityModel, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyScriptTaskModel)) {
            return false;
        }
        MaskPartyScriptTaskModel maskPartyScriptTaskModel = (MaskPartyScriptTaskModel) obj;
        return s.d(this.prologue, maskPartyScriptTaskModel.prologue) && s.d(this.characterName, maskPartyScriptTaskModel.characterName) && s.d(this.task, maskPartyScriptTaskModel.task) && s.d(this.identity, maskPartyScriptTaskModel.identity) && s.d(this.story, maskPartyScriptTaskModel.story);
    }

    @NotNull
    public final String getCharacterName() {
        return this.characterName;
    }

    @Nullable
    public final GuessIdentityModel getIdentity() {
        return this.identity;
    }

    @Nullable
    public final String getPrologue() {
        return this.prologue;
    }

    @Nullable
    public final String getStory() {
        return this.story;
    }

    @NotNull
    public final List<MaskPartyScriptTaskItemModel> getTask() {
        return this.task;
    }

    public int hashCode() {
        String str = this.prologue;
        int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.characterName.hashCode()) * 31) + this.task.hashCode()) * 31;
        GuessIdentityModel guessIdentityModel = this.identity;
        int hashCode2 = (hashCode + (guessIdentityModel == null ? 0 : guessIdentityModel.hashCode())) * 31;
        String str2 = this.story;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final void setStory(@Nullable String str) {
        this.story = str;
    }

    @NotNull
    public String toString() {
        String str = this.prologue;
        String str2 = this.characterName;
        List<MaskPartyScriptTaskItemModel> list = this.task;
        GuessIdentityModel guessIdentityModel = this.identity;
        return "MaskPartyScriptTaskModel(prologue=" + str + ", characterName=" + str2 + ", task=" + ((Object) list) + ", identity=" + ((Object) guessIdentityModel) + ", story=" + this.story + ")";
    }
}
