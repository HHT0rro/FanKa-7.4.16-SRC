package com.cupidapp.live.profile.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AlohaCancelListModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AlohaCancelListModel {

    @Nullable
    private List<AlohaCancelUserModel> list;

    @Nullable
    private String nextCursorId;
    private final boolean ssvipRequired;

    public AlohaCancelListModel(@Nullable List<AlohaCancelUserModel> list, @Nullable String str, boolean z10) {
        this.list = list;
        this.nextCursorId = str;
        this.ssvipRequired = z10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlohaCancelListModel copy$default(AlohaCancelListModel alohaCancelListModel, List list, String str, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = alohaCancelListModel.list;
        }
        if ((i10 & 2) != 0) {
            str = alohaCancelListModel.nextCursorId;
        }
        if ((i10 & 4) != 0) {
            z10 = alohaCancelListModel.ssvipRequired;
        }
        return alohaCancelListModel.copy(list, str, z10);
    }

    @Nullable
    public final List<AlohaCancelUserModel> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.nextCursorId;
    }

    public final boolean component3() {
        return this.ssvipRequired;
    }

    @NotNull
    public final AlohaCancelListModel copy(@Nullable List<AlohaCancelUserModel> list, @Nullable String str, boolean z10) {
        return new AlohaCancelListModel(list, str, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlohaCancelListModel)) {
            return false;
        }
        AlohaCancelListModel alohaCancelListModel = (AlohaCancelListModel) obj;
        return s.d(this.list, alohaCancelListModel.list) && s.d(this.nextCursorId, alohaCancelListModel.nextCursorId) && this.ssvipRequired == alohaCancelListModel.ssvipRequired;
    }

    @Nullable
    public final List<AlohaCancelUserModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    public final boolean getSsvipRequired() {
        return this.ssvipRequired;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        List<AlohaCancelUserModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.nextCursorId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        boolean z10 = this.ssvipRequired;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode2 + i10;
    }

    public final void setList(@Nullable List<AlohaCancelUserModel> list) {
        this.list = list;
    }

    public final void setNextCursorId(@Nullable String str) {
        this.nextCursorId = str;
    }

    @NotNull
    public String toString() {
        List<AlohaCancelUserModel> list = this.list;
        return "AlohaCancelListModel(list=" + ((Object) list) + ", nextCursorId=" + this.nextCursorId + ", ssvipRequired=" + this.ssvipRequired + ")";
    }

    public /* synthetic */ AlohaCancelListModel(List list, String str, boolean z10, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, str, (i10 & 4) != 0 ? false : z10);
    }
}
