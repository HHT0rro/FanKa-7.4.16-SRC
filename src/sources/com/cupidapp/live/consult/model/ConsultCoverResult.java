package com.cupidapp.live.consult.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ConsultTotalModelFile.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ConsultCoverResult {

    @Nullable
    private final ImageModel cover;

    @Nullable
    private final Boolean hasUpload;

    public ConsultCoverResult(@Nullable ImageModel imageModel, @Nullable Boolean bool) {
        this.cover = imageModel;
        this.hasUpload = bool;
    }

    public static /* synthetic */ ConsultCoverResult copy$default(ConsultCoverResult consultCoverResult, ImageModel imageModel, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            imageModel = consultCoverResult.cover;
        }
        if ((i10 & 2) != 0) {
            bool = consultCoverResult.hasUpload;
        }
        return consultCoverResult.copy(imageModel, bool);
    }

    @Nullable
    public final ImageModel component1() {
        return this.cover;
    }

    @Nullable
    public final Boolean component2() {
        return this.hasUpload;
    }

    @NotNull
    public final ConsultCoverResult copy(@Nullable ImageModel imageModel, @Nullable Boolean bool) {
        return new ConsultCoverResult(imageModel, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConsultCoverResult)) {
            return false;
        }
        ConsultCoverResult consultCoverResult = (ConsultCoverResult) obj;
        return s.d(this.cover, consultCoverResult.cover) && s.d(this.hasUpload, consultCoverResult.hasUpload);
    }

    @Nullable
    public final ImageModel getCover() {
        return this.cover;
    }

    @Nullable
    public final Boolean getHasUpload() {
        return this.hasUpload;
    }

    public int hashCode() {
        ImageModel imageModel = this.cover;
        int hashCode = (imageModel == null ? 0 : imageModel.hashCode()) * 31;
        Boolean bool = this.hasUpload;
        return hashCode + (bool != null ? bool.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "ConsultCoverResult(cover=" + ((Object) this.cover) + ", hasUpload=" + ((Object) this.hasUpload) + ")";
    }
}
