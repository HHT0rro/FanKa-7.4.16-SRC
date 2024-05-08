package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.GuideInfoModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class DynamicGuideModel {

    @Nullable
    private final GuideInfoModel guideInfo;

    public DynamicGuideModel(@Nullable GuideInfoModel guideInfoModel) {
        this.guideInfo = guideInfoModel;
    }

    public static /* synthetic */ DynamicGuideModel copy$default(DynamicGuideModel dynamicGuideModel, GuideInfoModel guideInfoModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            guideInfoModel = dynamicGuideModel.guideInfo;
        }
        return dynamicGuideModel.copy(guideInfoModel);
    }

    @Nullable
    public final GuideInfoModel component1() {
        return this.guideInfo;
    }

    @NotNull
    public final DynamicGuideModel copy(@Nullable GuideInfoModel guideInfoModel) {
        return new DynamicGuideModel(guideInfoModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DynamicGuideModel) && kotlin.jvm.internal.s.d(this.guideInfo, ((DynamicGuideModel) obj).guideInfo);
    }

    @Nullable
    public final GuideInfoModel getGuideInfo() {
        return this.guideInfo;
    }

    public int hashCode() {
        GuideInfoModel guideInfoModel = this.guideInfo;
        if (guideInfoModel == null) {
            return 0;
        }
        return guideInfoModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "DynamicGuideModel(guideInfo=" + ((Object) this.guideInfo) + ")";
    }
}
