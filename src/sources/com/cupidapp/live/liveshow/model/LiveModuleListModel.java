package com.cupidapp.live.liveshow.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveListResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveModuleListModel {

    @Nullable
    private final List<AdModel> adList;

    @Nullable
    private final List<BigPictureModel> bigPictureList;

    @Nullable
    private final List<LiveShowModel> followList;
    private final boolean haveMore;

    /* renamed from: id, reason: collision with root package name */
    @NotNull
    private final String f15099id;

    @Nullable
    private final List<LiveShowModel> nearbyList;

    @Nullable
    private final List<LiveShowModel> squareCardList;

    @Nullable
    private final String title;
    private final int type;

    public LiveModuleListModel(@NotNull String id2, int i10, @Nullable String str, @Nullable List<BigPictureModel> list, @Nullable List<LiveShowModel> list2, @Nullable List<AdModel> list3, @Nullable List<LiveShowModel> list4, @Nullable List<LiveShowModel> list5, boolean z10) {
        s.i(id2, "id");
        this.f15099id = id2;
        this.type = i10;
        this.title = str;
        this.bigPictureList = list;
        this.followList = list2;
        this.adList = list3;
        this.squareCardList = list4;
        this.nearbyList = list5;
        this.haveMore = z10;
    }

    @NotNull
    public final String component1() {
        return this.f15099id;
    }

    public final int component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.title;
    }

    @Nullable
    public final List<BigPictureModel> component4() {
        return this.bigPictureList;
    }

    @Nullable
    public final List<LiveShowModel> component5() {
        return this.followList;
    }

    @Nullable
    public final List<AdModel> component6() {
        return this.adList;
    }

    @Nullable
    public final List<LiveShowModel> component7() {
        return this.squareCardList;
    }

    @Nullable
    public final List<LiveShowModel> component8() {
        return this.nearbyList;
    }

    public final boolean component9() {
        return this.haveMore;
    }

    @NotNull
    public final LiveModuleListModel copy(@NotNull String id2, int i10, @Nullable String str, @Nullable List<BigPictureModel> list, @Nullable List<LiveShowModel> list2, @Nullable List<AdModel> list3, @Nullable List<LiveShowModel> list4, @Nullable List<LiveShowModel> list5, boolean z10) {
        s.i(id2, "id");
        return new LiveModuleListModel(id2, i10, str, list, list2, list3, list4, list5, z10);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LiveModuleListModel)) {
            return false;
        }
        LiveModuleListModel liveModuleListModel = (LiveModuleListModel) obj;
        return s.d(this.f15099id, liveModuleListModel.f15099id) && this.type == liveModuleListModel.type && s.d(this.title, liveModuleListModel.title) && s.d(this.bigPictureList, liveModuleListModel.bigPictureList) && s.d(this.followList, liveModuleListModel.followList) && s.d(this.adList, liveModuleListModel.adList) && s.d(this.squareCardList, liveModuleListModel.squareCardList) && s.d(this.nearbyList, liveModuleListModel.nearbyList) && this.haveMore == liveModuleListModel.haveMore;
    }

    @Nullable
    public final List<AdModel> getAdList() {
        return this.adList;
    }

    @Nullable
    public final List<BigPictureModel> getBigPictureList() {
        return this.bigPictureList;
    }

    @Nullable
    public final List<LiveShowModel> getFollowList() {
        return this.followList;
    }

    public final boolean getHaveMore() {
        return this.haveMore;
    }

    @NotNull
    public final String getId() {
        return this.f15099id;
    }

    @Nullable
    public final List<LiveShowModel> getNearbyList() {
        return this.nearbyList;
    }

    @Nullable
    public final List<LiveShowModel> getSquareCardList() {
        return this.squareCardList;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.f15099id.hashCode() * 31) + this.type) * 31;
        String str = this.title;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<BigPictureModel> list = this.bigPictureList;
        int hashCode3 = (hashCode2 + (list == null ? 0 : list.hashCode())) * 31;
        List<LiveShowModel> list2 = this.followList;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<AdModel> list3 = this.adList;
        int hashCode5 = (hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31;
        List<LiveShowModel> list4 = this.squareCardList;
        int hashCode6 = (hashCode5 + (list4 == null ? 0 : list4.hashCode())) * 31;
        List<LiveShowModel> list5 = this.nearbyList;
        int hashCode7 = (hashCode6 + (list5 != null ? list5.hashCode() : 0)) * 31;
        boolean z10 = this.haveMore;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        return hashCode7 + i10;
    }

    @NotNull
    public String toString() {
        String str = this.f15099id;
        int i10 = this.type;
        String str2 = this.title;
        List<BigPictureModel> list = this.bigPictureList;
        List<LiveShowModel> list2 = this.followList;
        List<AdModel> list3 = this.adList;
        List<LiveShowModel> list4 = this.squareCardList;
        List<LiveShowModel> list5 = this.nearbyList;
        return "LiveModuleListModel(id=" + str + ", type=" + i10 + ", title=" + str2 + ", bigPictureList=" + ((Object) list) + ", followList=" + ((Object) list2) + ", adList=" + ((Object) list3) + ", squareCardList=" + ((Object) list4) + ", nearbyList=" + ((Object) list5) + ", haveMore=" + this.haveMore + ")";
    }
}
