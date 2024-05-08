package com.cupidapp.live.liveshow.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.io.Serializable;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKLiveShowResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class RedEnvelopeTagModel implements Serializable {

    @Nullable
    private final String iconCategory;

    @NotNull
    private final ImageModel redPacketIcon;

    @NotNull
    private final String redPacketId;

    public RedEnvelopeTagModel(@NotNull ImageModel redPacketIcon, @NotNull String redPacketId, @Nullable String str) {
        s.i(redPacketIcon, "redPacketIcon");
        s.i(redPacketId, "redPacketId");
        this.redPacketIcon = redPacketIcon;
        this.redPacketId = redPacketId;
        this.iconCategory = str;
    }

    public static /* synthetic */ RedEnvelopeTagModel copy$default(RedEnvelopeTagModel redEnvelopeTagModel, ImageModel imageModel, String str, String str2, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = redEnvelopeTagModel.redPacketIcon;
        }
        if ((i10 & 2) != 0) {
            str = redEnvelopeTagModel.redPacketId;
        }
        if ((i10 & 4) != 0) {
            str2 = redEnvelopeTagModel.iconCategory;
        }
        return redEnvelopeTagModel.copy(imageModel, str, str2);
    }

    @NotNull
    public final ImageModel component1() {
        return this.redPacketIcon;
    }

    @NotNull
    public final String component2() {
        return this.redPacketId;
    }

    @Nullable
    public final String component3() {
        return this.iconCategory;
    }

    @NotNull
    public final RedEnvelopeTagModel copy(@NotNull ImageModel redPacketIcon, @NotNull String redPacketId, @Nullable String str) {
        s.i(redPacketIcon, "redPacketIcon");
        s.i(redPacketId, "redPacketId");
        return new RedEnvelopeTagModel(redPacketIcon, redPacketId, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RedEnvelopeTagModel)) {
            return false;
        }
        RedEnvelopeTagModel redEnvelopeTagModel = (RedEnvelopeTagModel) obj;
        return s.d(this.redPacketIcon, redEnvelopeTagModel.redPacketIcon) && s.d(this.redPacketId, redEnvelopeTagModel.redPacketId) && s.d(this.iconCategory, redEnvelopeTagModel.iconCategory);
    }

    @Nullable
    public final String getIconCategory() {
        return this.iconCategory;
    }

    @NotNull
    public final ImageModel getRedPacketIcon() {
        return this.redPacketIcon;
    }

    @NotNull
    public final String getRedPacketId() {
        return this.redPacketId;
    }

    public int hashCode() {
        int hashCode = ((this.redPacketIcon.hashCode() * 31) + this.redPacketId.hashCode()) * 31;
        String str = this.iconCategory;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        ImageModel imageModel = this.redPacketIcon;
        return "RedEnvelopeTagModel(redPacketIcon=" + ((Object) imageModel) + ", redPacketId=" + this.redPacketId + ", iconCategory=" + this.iconCategory + ")";
    }
}
