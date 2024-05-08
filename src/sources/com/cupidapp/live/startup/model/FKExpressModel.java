package com.cupidapp.live.startup.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: StartupModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class FKExpressModel {

    @Nullable
    private final List<FkAdModel> adFeedConfig;

    @Nullable
    private final Integer displayInterval;

    public FKExpressModel(@Nullable List<FkAdModel> list, @Nullable Integer num) {
        this.adFeedConfig = list;
        this.displayInterval = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FKExpressModel copy$default(FKExpressModel fKExpressModel, List list, Integer num, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = fKExpressModel.adFeedConfig;
        }
        if ((i10 & 2) != 0) {
            num = fKExpressModel.displayInterval;
        }
        return fKExpressModel.copy(list, num);
    }

    @Nullable
    public final List<FkAdModel> component1() {
        return this.adFeedConfig;
    }

    @Nullable
    public final Integer component2() {
        return this.displayInterval;
    }

    @NotNull
    public final FKExpressModel copy(@Nullable List<FkAdModel> list, @Nullable Integer num) {
        return new FKExpressModel(list, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FKExpressModel)) {
            return false;
        }
        FKExpressModel fKExpressModel = (FKExpressModel) obj;
        return s.d(this.adFeedConfig, fKExpressModel.adFeedConfig) && s.d(this.displayInterval, fKExpressModel.displayInterval);
    }

    @Nullable
    public final List<FkAdModel> getAdFeedConfig() {
        return this.adFeedConfig;
    }

    @Nullable
    public final Integer getDisplayInterval() {
        return this.displayInterval;
    }

    public int hashCode() {
        List<FkAdModel> list = this.adFeedConfig;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        Integer num = this.displayInterval;
        return hashCode + (num != null ? num.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FKExpressModel(adFeedConfig=" + ((Object) this.adFeedConfig) + ", displayInterval=" + ((Object) this.displayInterval) + ")";
    }
}
