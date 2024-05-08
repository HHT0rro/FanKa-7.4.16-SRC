package com.cupidapp.live.startup.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKStartupMediaModel {
    private final int cacheTimeInterval;
    private final int coldBootInterval;
    private final int hotBootInterval;

    @Nullable
    private final List<List<List<FKStartupMediaConfigModel>>> startupMediaHotStartList;

    @Nullable
    private final List<List<List<FKStartupMediaConfigModel>>> startupMediaList;
    private final int timeOut;

    /* JADX WARN: Multi-variable type inference failed */
    public FKStartupMediaModel(@Nullable List<? extends List<? extends List<FKStartupMediaConfigModel>>> list, @Nullable List<? extends List<? extends List<FKStartupMediaConfigModel>>> list2, int i10, int i11, int i12, int i13) {
        this.startupMediaList = list;
        this.startupMediaHotStartList = list2;
        this.timeOut = i10;
        this.coldBootInterval = i11;
        this.hotBootInterval = i12;
        this.cacheTimeInterval = i13;
    }

    public static /* synthetic */ FKStartupMediaModel copy$default(FKStartupMediaModel fKStartupMediaModel, List list, List list2, int i10, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            list = fKStartupMediaModel.startupMediaList;
        }
        if ((i14 & 2) != 0) {
            list2 = fKStartupMediaModel.startupMediaHotStartList;
        }
        List list3 = list2;
        if ((i14 & 4) != 0) {
            i10 = fKStartupMediaModel.timeOut;
        }
        int i15 = i10;
        if ((i14 & 8) != 0) {
            i11 = fKStartupMediaModel.coldBootInterval;
        }
        int i16 = i11;
        if ((i14 & 16) != 0) {
            i12 = fKStartupMediaModel.hotBootInterval;
        }
        int i17 = i12;
        if ((i14 & 32) != 0) {
            i13 = fKStartupMediaModel.cacheTimeInterval;
        }
        return fKStartupMediaModel.copy(list, list3, i15, i16, i17, i13);
    }

    @Nullable
    public final List<List<List<FKStartupMediaConfigModel>>> component1() {
        return this.startupMediaList;
    }

    @Nullable
    public final List<List<List<FKStartupMediaConfigModel>>> component2() {
        return this.startupMediaHotStartList;
    }

    public final int component3() {
        return this.timeOut;
    }

    public final int component4() {
        return this.coldBootInterval;
    }

    public final int component5() {
        return this.hotBootInterval;
    }

    public final int component6() {
        return this.cacheTimeInterval;
    }

    @NotNull
    public final FKStartupMediaModel copy(@Nullable List<? extends List<? extends List<FKStartupMediaConfigModel>>> list, @Nullable List<? extends List<? extends List<FKStartupMediaConfigModel>>> list2, int i10, int i11, int i12, int i13) {
        return new FKStartupMediaModel(list, list2, i10, i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKStartupMediaModel)) {
            return false;
        }
        FKStartupMediaModel fKStartupMediaModel = (FKStartupMediaModel) obj;
        return s.d(this.startupMediaList, fKStartupMediaModel.startupMediaList) && s.d(this.startupMediaHotStartList, fKStartupMediaModel.startupMediaHotStartList) && this.timeOut == fKStartupMediaModel.timeOut && this.coldBootInterval == fKStartupMediaModel.coldBootInterval && this.hotBootInterval == fKStartupMediaModel.hotBootInterval && this.cacheTimeInterval == fKStartupMediaModel.cacheTimeInterval;
    }

    public final int getCacheTimeInterval() {
        return this.cacheTimeInterval;
    }

    public final int getColdBootInterval() {
        return this.coldBootInterval;
    }

    public final int getHotBootInterval() {
        return this.hotBootInterval;
    }

    @Nullable
    public final List<List<List<FKStartupMediaConfigModel>>> getStartupMediaHotStartList() {
        return this.startupMediaHotStartList;
    }

    @Nullable
    public final List<List<List<FKStartupMediaConfigModel>>> getStartupMediaList() {
        return this.startupMediaList;
    }

    public final int getTimeOut() {
        return this.timeOut;
    }

    public int hashCode() {
        List<List<List<FKStartupMediaConfigModel>>> list = this.startupMediaList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<List<List<FKStartupMediaConfigModel>>> list2 = this.startupMediaHotStartList;
        return ((((((((hashCode + (list2 != null ? list2.hashCode() : 0)) * 31) + this.timeOut) * 31) + this.coldBootInterval) * 31) + this.hotBootInterval) * 31) + this.cacheTimeInterval;
    }

    @NotNull
    public String toString() {
        List<List<List<FKStartupMediaConfigModel>>> list = this.startupMediaList;
        List<List<List<FKStartupMediaConfigModel>>> list2 = this.startupMediaHotStartList;
        return "FKStartupMediaModel(startupMediaList=" + ((Object) list) + ", startupMediaHotStartList=" + ((Object) list2) + ", timeOut=" + this.timeOut + ", coldBootInterval=" + this.coldBootInterval + ", hotBootInterval=" + this.hotBootInterval + ", cacheTimeInterval=" + this.cacheTimeInterval + ")";
    }
}
