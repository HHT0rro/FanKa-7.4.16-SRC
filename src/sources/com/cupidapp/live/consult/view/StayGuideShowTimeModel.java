package com.cupidapp.live.consult.view;

import java.util.List;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultConnectGuideLayout.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class StayGuideShowTimeModel {

    @NotNull
    private final List<Long> timeList;

    public StayGuideShowTimeModel(@NotNull List<Long> timeList) {
        s.i(timeList, "timeList");
        this.timeList = timeList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ StayGuideShowTimeModel copy$default(StayGuideShowTimeModel stayGuideShowTimeModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = stayGuideShowTimeModel.timeList;
        }
        return stayGuideShowTimeModel.copy(list);
    }

    @NotNull
    public final List<Long> component1() {
        return this.timeList;
    }

    @NotNull
    public final StayGuideShowTimeModel copy(@NotNull List<Long> timeList) {
        s.i(timeList, "timeList");
        return new StayGuideShowTimeModel(timeList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof StayGuideShowTimeModel) && s.d(this.timeList, ((StayGuideShowTimeModel) obj).timeList);
    }

    @NotNull
    public final List<Long> getTimeList() {
        return this.timeList;
    }

    public int hashCode() {
        return this.timeList.hashCode();
    }

    @NotNull
    public String toString() {
        return "StayGuideShowTimeModel(timeList=" + ((Object) this.timeList) + ")";
    }
}
