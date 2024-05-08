package com.cupidapp.live.mediapicker.model;

import android.graphics.RectF;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FrameViewModel.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class UpdateImageEditPathEventModel {

    @Nullable
    private final RectF afterTrimImageBoundRectF;

    @Nullable
    private final String afterTrimOriginalImagePath;

    @Nullable
    private final String compressedImagePath;

    @Nullable
    private final String effectImagePathAfterTrim;

    public UpdateImageEditPathEventModel() {
        this(null, null, null, null, 15, null);
    }

    public UpdateImageEditPathEventModel(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable RectF rectF) {
        this.compressedImagePath = str;
        this.effectImagePathAfterTrim = str2;
        this.afterTrimOriginalImagePath = str3;
        this.afterTrimImageBoundRectF = rectF;
    }

    public static /* synthetic */ UpdateImageEditPathEventModel copy$default(UpdateImageEditPathEventModel updateImageEditPathEventModel, String str, String str2, String str3, RectF rectF, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = updateImageEditPathEventModel.compressedImagePath;
        }
        if ((i10 & 2) != 0) {
            str2 = updateImageEditPathEventModel.effectImagePathAfterTrim;
        }
        if ((i10 & 4) != 0) {
            str3 = updateImageEditPathEventModel.afterTrimOriginalImagePath;
        }
        if ((i10 & 8) != 0) {
            rectF = updateImageEditPathEventModel.afterTrimImageBoundRectF;
        }
        return updateImageEditPathEventModel.copy(str, str2, str3, rectF);
    }

    @Nullable
    public final String component1() {
        return this.compressedImagePath;
    }

    @Nullable
    public final String component2() {
        return this.effectImagePathAfterTrim;
    }

    @Nullable
    public final String component3() {
        return this.afterTrimOriginalImagePath;
    }

    @Nullable
    public final RectF component4() {
        return this.afterTrimImageBoundRectF;
    }

    @NotNull
    public final UpdateImageEditPathEventModel copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable RectF rectF) {
        return new UpdateImageEditPathEventModel(str, str2, str3, rectF);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdateImageEditPathEventModel)) {
            return false;
        }
        UpdateImageEditPathEventModel updateImageEditPathEventModel = (UpdateImageEditPathEventModel) obj;
        return s.d(this.compressedImagePath, updateImageEditPathEventModel.compressedImagePath) && s.d(this.effectImagePathAfterTrim, updateImageEditPathEventModel.effectImagePathAfterTrim) && s.d(this.afterTrimOriginalImagePath, updateImageEditPathEventModel.afterTrimOriginalImagePath) && s.d(this.afterTrimImageBoundRectF, updateImageEditPathEventModel.afterTrimImageBoundRectF);
    }

    @Nullable
    public final RectF getAfterTrimImageBoundRectF() {
        return this.afterTrimImageBoundRectF;
    }

    @Nullable
    public final String getAfterTrimOriginalImagePath() {
        return this.afterTrimOriginalImagePath;
    }

    @Nullable
    public final String getCompressedImagePath() {
        return this.compressedImagePath;
    }

    @Nullable
    public final String getEffectImagePathAfterTrim() {
        return this.effectImagePathAfterTrim;
    }

    public int hashCode() {
        String str = this.compressedImagePath;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.effectImagePathAfterTrim;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.afterTrimOriginalImagePath;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        RectF rectF = this.afterTrimImageBoundRectF;
        return hashCode3 + (rectF != null ? rectF.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UpdateImageEditPathEventModel(compressedImagePath=" + this.compressedImagePath + ", effectImagePathAfterTrim=" + this.effectImagePathAfterTrim + ", afterTrimOriginalImagePath=" + this.afterTrimOriginalImagePath + ", afterTrimImageBoundRectF=" + ((Object) this.afterTrimImageBoundRectF) + ")";
    }

    public /* synthetic */ UpdateImageEditPathEventModel(String str, String str2, String str3, RectF rectF, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : str2, (i10 & 4) != 0 ? null : str3, (i10 & 8) != 0 ? null : rectF);
    }
}
