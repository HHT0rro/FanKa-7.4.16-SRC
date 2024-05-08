package com.cupidapp.live.ai.model;

import com.cupidapp.live.match.model.NearbyUserProfileModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AiIdentifyGraphModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiIdentifyModel {

    @Nullable
    private final List<NearbyUserProfileModel> list;

    public AiIdentifyModel(@Nullable List<NearbyUserProfileModel> list) {
        this.list = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AiIdentifyModel copy$default(AiIdentifyModel aiIdentifyModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = aiIdentifyModel.list;
        }
        return aiIdentifyModel.copy(list);
    }

    @Nullable
    public final List<NearbyUserProfileModel> component1() {
        return this.list;
    }

    @NotNull
    public final AiIdentifyModel copy(@Nullable List<NearbyUserProfileModel> list) {
        return new AiIdentifyModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AiIdentifyModel) && s.d(this.list, ((AiIdentifyModel) obj).list);
    }

    @Nullable
    public final List<NearbyUserProfileModel> getList() {
        return this.list;
    }

    public int hashCode() {
        List<NearbyUserProfileModel> list = this.list;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "AiIdentifyModel(list=" + ((Object) this.list) + ")";
    }
}
