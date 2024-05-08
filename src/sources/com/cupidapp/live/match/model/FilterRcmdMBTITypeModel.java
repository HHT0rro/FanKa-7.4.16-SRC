package com.cupidapp.live.match.model;

import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchFilterUiModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FilterRcmdMBTITypeModel {

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f16836id;

    @NotNull
    private final String tag;

    public FilterRcmdMBTITypeModel(@NotNull String id2, @NotNull String tag) {
        s.i(id2, "id");
        s.i(tag, "tag");
        this.f16836id = id2;
        this.tag = tag;
    }

    public static /* synthetic */ FilterRcmdMBTITypeModel copy$default(FilterRcmdMBTITypeModel filterRcmdMBTITypeModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = filterRcmdMBTITypeModel.f16836id;
        }
        if ((i10 & 2) != 0) {
            str2 = filterRcmdMBTITypeModel.tag;
        }
        return filterRcmdMBTITypeModel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.f16836id;
    }

    @NotNull
    public final String component2() {
        return this.tag;
    }

    @NotNull
    public final FilterRcmdMBTITypeModel copy(@NotNull String id2, @NotNull String tag) {
        s.i(id2, "id");
        s.i(tag, "tag");
        return new FilterRcmdMBTITypeModel(id2, tag);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilterRcmdMBTITypeModel)) {
            return false;
        }
        FilterRcmdMBTITypeModel filterRcmdMBTITypeModel = (FilterRcmdMBTITypeModel) obj;
        return s.d(this.f16836id, filterRcmdMBTITypeModel.f16836id) && s.d(this.tag, filterRcmdMBTITypeModel.tag);
    }

    @NotNull
    public final String getId() {
        return this.f16836id;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public int hashCode() {
        return (this.f16836id.hashCode() * 31) + this.tag.hashCode();
    }

    @NotNull
    public String toString() {
        return "FilterRcmdMBTITypeModel(id=" + this.f16836id + ", tag=" + this.tag + ")";
    }
}
