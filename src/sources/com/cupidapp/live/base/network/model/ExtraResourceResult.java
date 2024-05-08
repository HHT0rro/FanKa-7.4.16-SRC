package com.cupidapp.live.base.network.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ExtraResourceModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ExtraResourceResult implements Serializable {

    @Nullable
    private final List<ExtraResourceModel> list;

    public ExtraResourceResult(@Nullable List<ExtraResourceModel> list) {
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ExtraResourceResult copy$default(ExtraResourceResult extraResourceResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = extraResourceResult.list;
        }
        return extraResourceResult.copy(list);
    }

    @Nullable
    public final List<ExtraResourceModel> component1() {
        return this.list;
    }

    @NotNull
    public final ExtraResourceResult copy(@Nullable List<ExtraResourceModel> list) {
        return new ExtraResourceResult(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ExtraResourceResult) && s.d(this.list, ((ExtraResourceResult) obj).list);
    }

    @Nullable
    public final List<ExtraResourceModel> getList() {
        return this.list;
    }

    public int hashCode() {
        List<ExtraResourceModel> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExtraResourceResult(list=" + ((Object) this.list) + ")";
    }
}
