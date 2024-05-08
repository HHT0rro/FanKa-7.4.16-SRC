package com.cupidapp.live.liveshow.model;

import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveMiniProfileResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ActionModel implements Serializable {

    @NotNull
    private final String type;

    public ActionModel(@NotNull String type) {
        s.i(type, "type");
        this.type = type;
    }

    public static /* synthetic */ ActionModel copy$default(ActionModel actionModel, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = actionModel.type;
        }
        return actionModel.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final ActionModel copy(@NotNull String type) {
        s.i(type, "type");
        return new ActionModel(type);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ActionModel) && s.d(this.type, ((ActionModel) obj).type);
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return this.type.hashCode();
    }

    @NotNull
    public String toString() {
        return "ActionModel(type=" + this.type + ")";
    }
}
