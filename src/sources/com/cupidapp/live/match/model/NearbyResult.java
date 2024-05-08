package com.cupidapp.live.match.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class NearbyResult {
    private final int findCount;
    private boolean insufficient;

    @Nullable
    private final List<NearbyUserModel> list;

    @Nullable
    private final MapDataModel mapData;

    @Nullable
    private final String message;

    @Nullable
    private final String nextCursorId;

    @Nullable
    private final List<List<NearbyUserModel>> sameCityList;

    @Nullable
    private final List<NearbyUserModel> superboostList;
    private boolean vipRequired;
    private final int vipType;

    public NearbyResult(boolean z10, boolean z11, @Nullable String str, @Nullable List<NearbyUserModel> list, @Nullable String str2, @Nullable List<List<NearbyUserModel>> list2, @Nullable List<NearbyUserModel> list3, int i10, @Nullable MapDataModel mapDataModel, int i11) {
        this.vipRequired = z10;
        this.insufficient = z11;
        this.message = str;
        this.list = list;
        this.nextCursorId = str2;
        this.sameCityList = list2;
        this.superboostList = list3;
        this.findCount = i10;
        this.mapData = mapDataModel;
        this.vipType = i11;
    }

    public final boolean component1() {
        return this.vipRequired;
    }

    public final int component10() {
        return this.vipType;
    }

    public final boolean component2() {
        return this.insufficient;
    }

    @Nullable
    public final String component3() {
        return this.message;
    }

    @Nullable
    public final List<NearbyUserModel> component4() {
        return this.list;
    }

    @Nullable
    public final String component5() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<List<NearbyUserModel>> component6() {
        return this.sameCityList;
    }

    @Nullable
    public final List<NearbyUserModel> component7() {
        return this.superboostList;
    }

    public final int component8() {
        return this.findCount;
    }

    @Nullable
    public final MapDataModel component9() {
        return this.mapData;
    }

    @NotNull
    public final NearbyResult copy(boolean z10, boolean z11, @Nullable String str, @Nullable List<NearbyUserModel> list, @Nullable String str2, @Nullable List<List<NearbyUserModel>> list2, @Nullable List<NearbyUserModel> list3, int i10, @Nullable MapDataModel mapDataModel, int i11) {
        return new NearbyResult(z10, z11, str, list, str2, list2, list3, i10, mapDataModel, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NearbyResult)) {
            return false;
        }
        NearbyResult nearbyResult = (NearbyResult) obj;
        return this.vipRequired == nearbyResult.vipRequired && this.insufficient == nearbyResult.insufficient && s.d(this.message, nearbyResult.message) && s.d(this.list, nearbyResult.list) && s.d(this.nextCursorId, nearbyResult.nextCursorId) && s.d(this.sameCityList, nearbyResult.sameCityList) && s.d(this.superboostList, nearbyResult.superboostList) && this.findCount == nearbyResult.findCount && s.d(this.mapData, nearbyResult.mapData) && this.vipType == nearbyResult.vipType;
    }

    public final int getFindCount() {
        return this.findCount;
    }

    public final boolean getInsufficient() {
        return this.insufficient;
    }

    @Nullable
    public final List<NearbyUserModel> getList() {
        return this.list;
    }

    @Nullable
    public final MapDataModel getMapData() {
        return this.mapData;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
    public final String getNextCursorId() {
        return this.nextCursorId;
    }

    @Nullable
    public final List<List<NearbyUserModel>> getSameCityList() {
        return this.sameCityList;
    }

    @Nullable
    public final List<NearbyUserModel> getSuperboostList() {
        return this.superboostList;
    }

    public final boolean getVipRequired() {
        return this.vipRequired;
    }

    public final int getVipType() {
        return this.vipType;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    public int hashCode() {
        boolean z10 = this.vipRequired;
        ?? r02 = z10;
        if (z10) {
            r02 = 1;
        }
        int i10 = r02 * 31;
        boolean z11 = this.insufficient;
        int i11 = (i10 + (z11 ? 1 : z11 ? 1 : 0)) * 31;
        String str = this.message;
        int hashCode = (i11 + (str == null ? 0 : str.hashCode())) * 31;
        List<NearbyUserModel> list = this.list;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.nextCursorId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<List<NearbyUserModel>> list2 = this.sameCityList;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        List<NearbyUserModel> list3 = this.superboostList;
        int hashCode5 = (((hashCode4 + (list3 == null ? 0 : list3.hashCode())) * 31) + this.findCount) * 31;
        MapDataModel mapDataModel = this.mapData;
        return ((hashCode5 + (mapDataModel != null ? mapDataModel.hashCode() : 0)) * 31) + this.vipType;
    }

    public final void setInsufficient(boolean z10) {
        this.insufficient = z10;
    }

    public final void setVipRequired(boolean z10) {
        this.vipRequired = z10;
    }

    @NotNull
    public String toString() {
        boolean z10 = this.vipRequired;
        boolean z11 = this.insufficient;
        String str = this.message;
        List<NearbyUserModel> list = this.list;
        String str2 = this.nextCursorId;
        List<List<NearbyUserModel>> list2 = this.sameCityList;
        List<NearbyUserModel> list3 = this.superboostList;
        int i10 = this.findCount;
        MapDataModel mapDataModel = this.mapData;
        return "NearbyResult(vipRequired=" + z10 + ", insufficient=" + z11 + ", message=" + str + ", list=" + ((Object) list) + ", nextCursorId=" + str2 + ", sameCityList=" + ((Object) list2) + ", superboostList=" + ((Object) list3) + ", findCount=" + i10 + ", mapData=" + ((Object) mapDataModel) + ", vipType=" + this.vipType + ")";
    }

    public /* synthetic */ NearbyResult(boolean z10, boolean z11, String str, List list, String str2, List list2, List list3, int i10, MapDataModel mapDataModel, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z10, (i12 & 2) != 0 ? false : z11, str, list, (i12 & 16) != 0 ? null : str2, list2, list3, (i12 & 128) != 0 ? 0 : i10, (i12 & 256) != 0 ? null : mapDataModel, (i12 & 512) != 0 ? 0 : i11);
    }
}
