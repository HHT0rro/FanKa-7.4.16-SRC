package com.cupidapp.live.consult.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultGrpcModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultAnchorInfoChangeGrpcModel extends BaseConsultLiveGrpcModel {

    @Nullable
    private final Integer anchorLevel;

    @Nullable
    private final ConsultAnchorTaskModel anchorTask;

    @Nullable
    private final ImageModel levelIcon;

    public ConsultAnchorInfoChangeGrpcModel(@Nullable String str, @Nullable ImageModel imageModel, @Nullable Integer num, @Nullable ConsultAnchorTaskModel consultAnchorTaskModel) {
        super(str);
        this.levelIcon = imageModel;
        this.anchorLevel = num;
        this.anchorTask = consultAnchorTaskModel;
    }

    @Nullable
    public final Integer getAnchorLevel() {
        return this.anchorLevel;
    }

    @Nullable
    public final ConsultAnchorTaskModel getAnchorTask() {
        return this.anchorTask;
    }

    @Nullable
    public final ImageModel getLevelIcon() {
        return this.levelIcon;
    }
}
