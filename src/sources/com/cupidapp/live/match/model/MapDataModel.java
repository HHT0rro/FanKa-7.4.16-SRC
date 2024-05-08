package com.cupidapp.live.match.model;

import java.util.ArrayList;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NearByModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class MapDataModel {

    @Nullable
    private final String address;

    @Nullable
    private final String distance;
    private final int matchCount;

    @Nullable
    private final ArrayList<NearMatchModel> matchList;

    @Nullable
    private final String nextMatchCursorId;

    public MapDataModel(@Nullable String str, @Nullable String str2, int i10, @Nullable ArrayList<NearMatchModel> arrayList, @Nullable String str3) {
        this.address = str;
        this.distance = str2;
        this.matchCount = i10;
        this.matchList = arrayList;
        this.nextMatchCursorId = str3;
    }

    public static /* synthetic */ MapDataModel copy$default(MapDataModel mapDataModel, String str, String str2, int i10, ArrayList arrayList, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = mapDataModel.address;
        }
        if ((i11 & 2) != 0) {
            str2 = mapDataModel.distance;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            i10 = mapDataModel.matchCount;
        }
        int i12 = i10;
        if ((i11 & 8) != 0) {
            arrayList = mapDataModel.matchList;
        }
        ArrayList arrayList2 = arrayList;
        if ((i11 & 16) != 0) {
            str3 = mapDataModel.nextMatchCursorId;
        }
        return mapDataModel.copy(str, str4, i12, arrayList2, str3);
    }

    @Nullable
    public final String component1() {
        return this.address;
    }

    @Nullable
    public final String component2() {
        return this.distance;
    }

    public final int component3() {
        return this.matchCount;
    }

    @Nullable
    public final ArrayList<NearMatchModel> component4() {
        return this.matchList;
    }

    @Nullable
    public final String component5() {
        return this.nextMatchCursorId;
    }

    @NotNull
    public final MapDataModel copy(@Nullable String str, @Nullable String str2, int i10, @Nullable ArrayList<NearMatchModel> arrayList, @Nullable String str3) {
        return new MapDataModel(str, str2, i10, arrayList, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MapDataModel)) {
            return false;
        }
        MapDataModel mapDataModel = (MapDataModel) obj;
        return s.d(this.address, mapDataModel.address) && s.d(this.distance, mapDataModel.distance) && this.matchCount == mapDataModel.matchCount && s.d(this.matchList, mapDataModel.matchList) && s.d(this.nextMatchCursorId, mapDataModel.nextMatchCursorId);
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getDistance() {
        return this.distance;
    }

    public final int getMatchCount() {
        return this.matchCount;
    }

    @Nullable
    public final ArrayList<NearMatchModel> getMatchList() {
        return this.matchList;
    }

    @Nullable
    public final String getNextMatchCursorId() {
        return this.nextMatchCursorId;
    }

    public int hashCode() {
        String str = this.address;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.distance;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.matchCount) * 31;
        ArrayList<NearMatchModel> arrayList = this.matchList;
        int hashCode3 = (hashCode2 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        String str3 = this.nextMatchCursorId;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        String str = this.address;
        String str2 = this.distance;
        int i10 = this.matchCount;
        ArrayList<NearMatchModel> arrayList = this.matchList;
        return "MapDataModel(address=" + str + ", distance=" + str2 + ", matchCount=" + i10 + ", matchList=" + ((Object) arrayList) + ", nextMatchCursorId=" + this.nextMatchCursorId + ")";
    }

    public /* synthetic */ MapDataModel(String str, String str2, int i10, ArrayList arrayList, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? 0 : i10, (i11 & 8) != 0 ? null : arrayList, (i11 & 16) != 0 ? null : str3);
    }
}
