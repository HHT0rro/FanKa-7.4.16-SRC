package com.cupidapp.live.match.model;

import com.cupidapp.live.base.network.model.ImageModel;
import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AlohaGuideModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class AlohaGuideModel {

    @Nullable
    private final List<ImageModel> newAlohaList;

    @Nullable
    private final String newAlohaText;

    public AlohaGuideModel(@Nullable List<ImageModel> list, @Nullable String str) {
        this.newAlohaList = list;
        this.newAlohaText = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AlohaGuideModel copy$default(AlohaGuideModel alohaGuideModel, List list, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = alohaGuideModel.newAlohaList;
        }
        if ((i10 & 2) != 0) {
            str = alohaGuideModel.newAlohaText;
        }
        return alohaGuideModel.copy(list, str);
    }

    @Nullable
    public final List<ImageModel> component1() {
        return this.newAlohaList;
    }

    @Nullable
    public final String component2() {
        return this.newAlohaText;
    }

    @NotNull
    public final AlohaGuideModel copy(@Nullable List<ImageModel> list, @Nullable String str) {
        return new AlohaGuideModel(list, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AlohaGuideModel)) {
            return false;
        }
        AlohaGuideModel alohaGuideModel = (AlohaGuideModel) obj;
        return s.d(this.newAlohaList, alohaGuideModel.newAlohaList) && s.d(this.newAlohaText, alohaGuideModel.newAlohaText);
    }

    @Nullable
    public final List<ImageModel> getNewAlohaList() {
        return this.newAlohaList;
    }

    @Nullable
    public final String getNewAlohaText() {
        return this.newAlohaText;
    }

    public int hashCode() {
        List<ImageModel> list = this.newAlohaList;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.newAlohaText;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        List<ImageModel> list = this.newAlohaList;
        return "AlohaGuideModel(newAlohaList=" + ((Object) list) + ", newAlohaText=" + this.newAlohaText + ")";
    }
}
