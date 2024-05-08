package com.cupidapp.live.setting.model;

import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwitchAccountModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MultiAccountUserIdsModel implements Serializable {

    @NotNull
    private final List<String> list;

    public MultiAccountUserIdsModel(@NotNull List<String> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiAccountUserIdsModel copy$default(MultiAccountUserIdsModel multiAccountUserIdsModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = multiAccountUserIdsModel.list;
        }
        return multiAccountUserIdsModel.copy(list);
    }

    @NotNull
    public final List<String> component1() {
        return this.list;
    }

    @NotNull
    public final MultiAccountUserIdsModel copy(@NotNull List<String> list) {
        s.i(list, "list");
        return new MultiAccountUserIdsModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiAccountUserIdsModel) && s.d(this.list, ((MultiAccountUserIdsModel) obj).list);
    }

    @NotNull
    public final List<String> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiAccountUserIdsModel(list=" + ((Object) this.list) + ")";
    }
}
