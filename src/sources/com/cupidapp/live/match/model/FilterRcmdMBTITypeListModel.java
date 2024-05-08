package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterRcmdMBTITypeListModel {

    @NotNull
    private final List<FilterRcmdMBTITypeModel> list;

    public FilterRcmdMBTITypeListModel(@NotNull List<FilterRcmdMBTITypeModel> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FilterRcmdMBTITypeListModel copy$default(FilterRcmdMBTITypeListModel filterRcmdMBTITypeListModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = filterRcmdMBTITypeListModel.list;
        }
        return filterRcmdMBTITypeListModel.copy(list);
    }

    @NotNull
    public final List<FilterRcmdMBTITypeModel> component1() {
        return this.list;
    }

    @NotNull
    public final FilterRcmdMBTITypeListModel copy(@NotNull List<FilterRcmdMBTITypeModel> list) {
        s.i(list, "list");
        return new FilterRcmdMBTITypeListModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FilterRcmdMBTITypeListModel) && s.d(this.list, ((FilterRcmdMBTITypeListModel) obj).list);
    }

    @NotNull
    public final List<FilterRcmdMBTITypeModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "FilterRcmdMBTITypeListModel(list=" + ((Object) this.list) + ")";
    }
}
