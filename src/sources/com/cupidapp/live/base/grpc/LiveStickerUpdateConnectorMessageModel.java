package com.cupidapp.live.base.grpc;

import com.cupidapp.live.liveshow.model.LiveStickerViewInfoModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKGRPCConnectorMessage.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class LiveStickerUpdateConnectorMessageModel {

    @Nullable
    private final LiveStickerViewInfoModel entity;

    public LiveStickerUpdateConnectorMessageModel(@Nullable LiveStickerViewInfoModel liveStickerViewInfoModel) {
        this.entity = liveStickerViewInfoModel;
    }

    public static /* synthetic */ LiveStickerUpdateConnectorMessageModel copy$default(LiveStickerUpdateConnectorMessageModel liveStickerUpdateConnectorMessageModel, LiveStickerViewInfoModel liveStickerViewInfoModel, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            liveStickerViewInfoModel = liveStickerUpdateConnectorMessageModel.entity;
        }
        return liveStickerUpdateConnectorMessageModel.copy(liveStickerViewInfoModel);
    }

    @Nullable
    public final LiveStickerViewInfoModel component1() {
        return this.entity;
    }

    @NotNull
    public final LiveStickerUpdateConnectorMessageModel copy(@Nullable LiveStickerViewInfoModel liveStickerViewInfoModel) {
        return new LiveStickerUpdateConnectorMessageModel(liveStickerViewInfoModel);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof LiveStickerUpdateConnectorMessageModel) && kotlin.jvm.internal.s.d(this.entity, ((LiveStickerUpdateConnectorMessageModel) obj).entity);
    }

    @Nullable
    public final LiveStickerViewInfoModel getEntity() {
        return this.entity;
    }

    public int hashCode() {
        LiveStickerViewInfoModel liveStickerViewInfoModel = this.entity;
        if (liveStickerViewInfoModel == null) {
            return 0;
        }
        return liveStickerViewInfoModel.hashCode();
    }

    @NotNull
    public String toString() {
        return "LiveStickerUpdateConnectorMessageModel(entity=" + ((Object) this.entity) + ")";
    }
}
