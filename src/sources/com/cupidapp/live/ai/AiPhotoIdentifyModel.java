package com.cupidapp.live.ai;

import com.cupidapp.live.match.model.NearbyUserProfileModel;
import java.io.Serializable;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AiPhotoIdentifyResultActivity.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiPhotoIdentifyModel implements Serializable {

    @Nullable
    private final List<NearbyUserProfileModel> list;

    @Nullable
    private final String localPath;

    public AiPhotoIdentifyModel(@Nullable List<NearbyUserProfileModel> list, @Nullable String str) {
        this.list = list;
        this.localPath = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AiPhotoIdentifyModel copy$default(AiPhotoIdentifyModel aiPhotoIdentifyModel, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = aiPhotoIdentifyModel.list;
        }
        if ((i10 & 2) != 0) {
            str = aiPhotoIdentifyModel.localPath;
        }
        return aiPhotoIdentifyModel.copy(list, str);
    }

    @Nullable
    public final List<NearbyUserProfileModel> component1() {
        return this.list;
    }

    @Nullable
    public final String component2() {
        return this.localPath;
    }

    @NotNull
    public final AiPhotoIdentifyModel copy(@Nullable List<NearbyUserProfileModel> list, @Nullable String str) {
        return new AiPhotoIdentifyModel(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiPhotoIdentifyModel)) {
            return false;
        }
        AiPhotoIdentifyModel aiPhotoIdentifyModel = (AiPhotoIdentifyModel) obj;
        return s.d(this.list, aiPhotoIdentifyModel.list) && s.d(this.localPath, aiPhotoIdentifyModel.localPath);
    }

    @Nullable
    public final List<NearbyUserProfileModel> getList() {
        return this.list;
    }

    @Nullable
    public final String getLocalPath() {
        return this.localPath;
    }

    public int hashCode() {
        List<NearbyUserProfileModel> list = this.list;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.localPath;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<NearbyUserProfileModel> list = this.list;
        return "AiPhotoIdentifyModel(list=" + ((Object) list) + ", localPath=" + this.localPath + ")";
    }
}
