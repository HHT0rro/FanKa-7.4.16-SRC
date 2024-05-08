package com.cupidapp.live.maskparty.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyScriptModel {

    @NotNull
    private final List<ScriptRoleModel> role;

    @NotNull
    private final String story;

    @NotNull
    private final String title;

    public MaskPartyScriptModel(@NotNull String title, @NotNull List<ScriptRoleModel> role, @NotNull String story) {
        s.i(title, "title");
        s.i(role, "role");
        s.i(story, "story");
        this.title = title;
        this.role = role;
        this.story = story;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MaskPartyScriptModel copy$default(MaskPartyScriptModel maskPartyScriptModel, String str, List list, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = maskPartyScriptModel.title;
        }
        if ((i10 & 2) != 0) {
            list = maskPartyScriptModel.role;
        }
        if ((i10 & 4) != 0) {
            str2 = maskPartyScriptModel.story;
        }
        return maskPartyScriptModel.copy(str, list, str2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<ScriptRoleModel> component2() {
        return this.role;
    }

    @NotNull
    public final String component3() {
        return this.story;
    }

    @NotNull
    public final MaskPartyScriptModel copy(@NotNull String title, @NotNull List<ScriptRoleModel> role, @NotNull String story) {
        s.i(title, "title");
        s.i(role, "role");
        s.i(story, "story");
        return new MaskPartyScriptModel(title, role, story);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyScriptModel)) {
            return false;
        }
        MaskPartyScriptModel maskPartyScriptModel = (MaskPartyScriptModel) obj;
        return s.d(this.title, maskPartyScriptModel.title) && s.d(this.role, maskPartyScriptModel.role) && s.d(this.story, maskPartyScriptModel.story);
    }

    @NotNull
    public final List<ScriptRoleModel> getRole() {
        return this.role;
    }

    @NotNull
    public final String getStory() {
        return this.story;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.title.hashCode() * 31) + this.role.hashCode()) * 31) + this.story.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<ScriptRoleModel> list = this.role;
        return "MaskPartyScriptModel(title=" + str + ", role=" + ((Object) list) + ", story=" + this.story + ")";
    }
}
