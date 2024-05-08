package com.cupidapp.live.liveshow.fanclub.adapter;

import com.cupidapp.live.liveshow.fanclub.model.FKFanClubMemberDataModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKFanClubForAnchorAdapter.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKClubMemberModel {

    @NotNull
    private final List<FKFanClubMemberDataModel> list;

    public FKClubMemberModel(@NotNull List<FKFanClubMemberDataModel> list) {
        s.i(list, "list");
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKClubMemberModel copy$default(FKClubMemberModel fKClubMemberModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = fKClubMemberModel.list;
        }
        return fKClubMemberModel.copy(list);
    }

    @NotNull
    public final List<FKFanClubMemberDataModel> component1() {
        return this.list;
    }

    @NotNull
    public final FKClubMemberModel copy(@NotNull List<FKFanClubMemberDataModel> list) {
        s.i(list, "list");
        return new FKClubMemberModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof FKClubMemberModel) && s.d(this.list, ((FKClubMemberModel) obj).list);
    }

    @NotNull
    public final List<FKFanClubMemberDataModel> getList() {
        return this.list;
    }

    public int hashCode() {
        return this.list.hashCode();
    }

    @NotNull
    public String toString() {
        return "FKClubMemberModel(list=" + ((Object) this.list) + ")";
    }
}
