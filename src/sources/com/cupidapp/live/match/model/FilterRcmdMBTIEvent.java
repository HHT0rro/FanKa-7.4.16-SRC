package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterRcmdMBTIEvent {

    @NotNull
    private final FilterRcmdMBTITypeListModel model;

    public FilterRcmdMBTIEvent(@NotNull FilterRcmdMBTITypeListModel model) {
        s.i(model, "model");
        this.model = model;
    }

    public static /* synthetic */ FilterRcmdMBTIEvent copy$default(FilterRcmdMBTIEvent filterRcmdMBTIEvent, FilterRcmdMBTITypeListModel filterRcmdMBTITypeListModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            filterRcmdMBTITypeListModel = filterRcmdMBTIEvent.model;
        }
        return filterRcmdMBTIEvent.copy(filterRcmdMBTITypeListModel);
    }

    @NotNull
    public final FilterRcmdMBTITypeListModel component1() {
        return this.model;
    }

    @NotNull
    public final FilterRcmdMBTIEvent copy(@NotNull FilterRcmdMBTITypeListModel model) {
        s.i(model, "model");
        return new FilterRcmdMBTIEvent(model);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FilterRcmdMBTIEvent) && s.d(this.model, ((FilterRcmdMBTIEvent) obj).model);
    }

    @NotNull
    public final FilterRcmdMBTITypeListModel getModel() {
        return this.model;
    }

    public int hashCode() {
        return this.model.hashCode();
    }

    @NotNull
    public String toString() {
        return "FilterRcmdMBTIEvent(model=" + ((Object) this.model) + ")";
    }
}
