package com.cupidapp.live.maskparty.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MaskPartyScriptModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MaskPartyScriptTaskItemModel implements Serializable {

    @NotNull
    private final String desc;
    private final int status;

    public MaskPartyScriptTaskItemModel(int i10, @NotNull String desc) {
        s.i(desc, "desc");
        this.status = i10;
        this.desc = desc;
    }

    public static /* synthetic */ MaskPartyScriptTaskItemModel copy$default(MaskPartyScriptTaskItemModel maskPartyScriptTaskItemModel, int i10, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = maskPartyScriptTaskItemModel.status;
        }
        if ((i11 & 2) != 0) {
            str = maskPartyScriptTaskItemModel.desc;
        }
        return maskPartyScriptTaskItemModel.copy(i10, str);
    }

    public final int component1() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.desc;
    }

    @NotNull
    public final MaskPartyScriptTaskItemModel copy(int i10, @NotNull String desc) {
        s.i(desc, "desc");
        return new MaskPartyScriptTaskItemModel(i10, desc);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MaskPartyScriptTaskItemModel)) {
            return false;
        }
        MaskPartyScriptTaskItemModel maskPartyScriptTaskItemModel = (MaskPartyScriptTaskItemModel) obj;
        return this.status == maskPartyScriptTaskItemModel.status && s.d(this.desc, maskPartyScriptTaskItemModel.desc);
    }

    @NotNull
    public final String getDesc() {
        return this.desc;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (this.status * 31) + this.desc.hashCode();
    }

    @NotNull
    public String toString() {
        return "MaskPartyScriptTaskItemModel(status=" + this.status + ", desc=" + this.desc + ")";
    }
}
