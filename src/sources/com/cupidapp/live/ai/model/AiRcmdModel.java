package com.cupidapp.live.ai.model;

import com.cupidapp.live.base.network.model.ImageModel;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AiIdentifyGraphModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiRcmdModel {

    @Nullable
    private final ImageModel image;
    private boolean isChecked;

    @Nullable
    private String localPath;

    @Nullable
    private final String name;

    @Nullable
    private final String trackname;

    public AiRcmdModel(@Nullable String str, @Nullable ImageModel imageModel, boolean z10, @Nullable String str2, @Nullable String str3) {
        this.name = str;
        this.image = imageModel;
        this.isChecked = z10;
        this.localPath = str2;
        this.trackname = str3;
    }

    public static /* synthetic */ AiRcmdModel copy$default(AiRcmdModel aiRcmdModel, String str, ImageModel imageModel, boolean z10, String str2, String str3, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = aiRcmdModel.name;
        }
        if ((i10 & 2) != 0) {
            imageModel = aiRcmdModel.image;
        }
        ImageModel imageModel2 = imageModel;
        if ((i10 & 4) != 0) {
            z10 = aiRcmdModel.isChecked;
        }
        boolean z11 = z10;
        if ((i10 & 8) != 0) {
            str2 = aiRcmdModel.localPath;
        }
        String str4 = str2;
        if ((i10 & 16) != 0) {
            str3 = aiRcmdModel.trackname;
        }
        return aiRcmdModel.copy(str, imageModel2, z11, str4, str3);
    }

    @Nullable
    public final String component1() {
        return this.name;
    }

    @Nullable
    public final ImageModel component2() {
        return this.image;
    }

    public final boolean component3() {
        return this.isChecked;
    }

    @Nullable
    public final String component4() {
        return this.localPath;
    }

    @Nullable
    public final String component5() {
        return this.trackname;
    }

    @NotNull
    public final AiRcmdModel copy(@Nullable String str, @Nullable ImageModel imageModel, boolean z10, @Nullable String str2, @Nullable String str3) {
        return new AiRcmdModel(str, imageModel, z10, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiRcmdModel)) {
            return false;
        }
        AiRcmdModel aiRcmdModel = (AiRcmdModel) obj;
        return s.d(this.name, aiRcmdModel.name) && s.d(this.image, aiRcmdModel.image) && this.isChecked == aiRcmdModel.isChecked && s.d(this.localPath, aiRcmdModel.localPath) && s.d(this.trackname, aiRcmdModel.trackname);
    }

    @Nullable
    public final ImageModel getImage() {
        return this.image;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getTrackname() {
        return this.trackname;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.name;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        ImageModel imageModel = this.image;
        int hashCode2 = (hashCode + (imageModel == null ? 0 : imageModel.hashCode())) * 31;
        boolean z10 = this.isChecked;
        int i10 = z10;
        if (z10 != 0) {
            i10 = 1;
        }
        int i11 = (hashCode2 + i10) * 31;
        String str2 = this.localPath;
        int hashCode3 = (i11 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.trackname;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z10) {
        this.isChecked = z10;
    }

    public final void setLocalPath(@Nullable String str) {
        this.localPath = str;
    }

    @NotNull
    public String toString() {
        String str = this.name;
        ImageModel imageModel = this.image;
        return "AiRcmdModel(name=" + str + ", image=" + ((Object) imageModel) + ", isChecked=" + this.isChecked + ", localPath=" + this.localPath + ", trackname=" + this.trackname + ")";
    }
}
