package com.cupidapp.live.maskparty.model;

import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class ScriptRoleModel {

    @NotNull
    private final String characterName;

    /* renamed from: id, reason: collision with root package name */
    private final int f16373id;
    private boolean selected;

    public ScriptRoleModel(int i10, @NotNull String characterName, boolean z10) {
        s.i(characterName, "characterName");
        this.f16373id = i10;
        this.characterName = characterName;
        this.selected = z10;
    }

    public static /* synthetic */ ScriptRoleModel copy$default(ScriptRoleModel scriptRoleModel, int i10, String str, boolean z10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = scriptRoleModel.f16373id;
        }
        if ((i11 & 2) != 0) {
            str = scriptRoleModel.characterName;
        }
        if ((i11 & 4) != 0) {
            z10 = scriptRoleModel.selected;
        }
        return scriptRoleModel.copy(i10, str, z10);
    }

    public final int component1() {
        return this.f16373id;
    }

    @NotNull
    public final String component2() {
        return this.characterName;
    }

    public final boolean component3() {
        return this.selected;
    }

    @NotNull
    public final ScriptRoleModel copy(int i10, @NotNull String characterName, boolean z10) {
        s.i(characterName, "characterName");
        return new ScriptRoleModel(i10, characterName, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ScriptRoleModel)) {
            return false;
        }
        ScriptRoleModel scriptRoleModel = (ScriptRoleModel) obj;
        return this.f16373id == scriptRoleModel.f16373id && s.d(this.characterName, scriptRoleModel.characterName) && this.selected == scriptRoleModel.selected;
    }

    @NotNull
    public final String getCharacterName() {
        return this.characterName;
    }

    public final int getId() {
        return this.f16373id;
    }

    public final boolean getSelected() {
        return this.selected;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f16373id * 31) + this.characterName.hashCode()) * 31;
        boolean z10 = this.selected;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode + i10;
    }

    public final void setSelected(boolean z10) {
        this.selected = z10;
    }

    @NotNull
    public String toString() {
        return "ScriptRoleModel(id=" + this.f16373id + ", characterName=" + this.characterName + ", selected=" + this.selected + ")";
    }

    public /* synthetic */ ScriptRoleModel(int i10, String str, boolean z10, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(i10, str, (i11 & 4) != 0 ? false : z10);
    }
}
