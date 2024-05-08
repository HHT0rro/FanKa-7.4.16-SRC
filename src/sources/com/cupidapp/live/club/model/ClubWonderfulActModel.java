package com.cupidapp.live.club.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ClubWonderfulActModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ClubWonderfulActModel {

    @Nullable
    private final List<ClubBannerModel> list;

    @Nullable
    private final String title;

    public ClubWonderfulActModel(@Nullable String str, @Nullable List<ClubBannerModel> list) {
        this.title = str;
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ClubWonderfulActModel copy$default(ClubWonderfulActModel clubWonderfulActModel, String str, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = clubWonderfulActModel.title;
        }
        if ((i10 & 2) != 0) {
            list = clubWonderfulActModel.list;
        }
        return clubWonderfulActModel.copy(str, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final List<ClubBannerModel> component2() {
        return this.list;
    }

    @NotNull
    public final ClubWonderfulActModel copy(@Nullable String str, @Nullable List<ClubBannerModel> list) {
        return new ClubWonderfulActModel(str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClubWonderfulActModel)) {
            return false;
        }
        ClubWonderfulActModel clubWonderfulActModel = (ClubWonderfulActModel) obj;
        return s.d(this.title, clubWonderfulActModel.title) && s.d(this.list, clubWonderfulActModel.list);
    }

    @Nullable
    public final List<ClubBannerModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<ClubBannerModel> list = this.list;
        return hashCode + (list != null ? list.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ClubWonderfulActModel(title=" + this.title + ", list=" + ((Object) this.list) + ")";
    }
}
