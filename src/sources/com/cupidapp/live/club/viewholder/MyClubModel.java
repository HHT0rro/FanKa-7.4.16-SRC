package com.cupidapp.live.club.viewholder;

import com.cupidapp.live.club.model.ClubModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MyClubViewHolder.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MyClubModel {

    @NotNull
    private List<ClubModel> clubList;

    public MyClubModel(@NotNull List<ClubModel> clubList) {
        s.i(clubList, "clubList");
        this.clubList = clubList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MyClubModel copy$default(MyClubModel myClubModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = myClubModel.clubList;
        }
        return myClubModel.copy(list);
    }

    @NotNull
    public final List<ClubModel> component1() {
        return this.clubList;
    }

    @NotNull
    public final MyClubModel copy(@NotNull List<ClubModel> clubList) {
        s.i(clubList, "clubList");
        return new MyClubModel(clubList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MyClubModel) && s.d(this.clubList, ((MyClubModel) obj).clubList);
    }

    @NotNull
    public final List<ClubModel> getClubList() {
        return this.clubList;
    }

    public int hashCode() {
        return this.clubList.hashCode();
    }

    public final void setClubList(@NotNull List<ClubModel> list) {
        s.i(list, "<set-?>");
        this.clubList = list;
    }

    @NotNull
    public String toString() {
        return "MyClubModel(clubList=" + ((Object) this.clubList) + ")";
    }
}
