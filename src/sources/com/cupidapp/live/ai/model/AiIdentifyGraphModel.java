package com.cupidapp.live.ai.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AiIdentifyGraphModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class AiIdentifyGraphModel {

    @Nullable
    private Integer freeCount;

    @Nullable
    private final List<AiRcmdModel> imageExamples;
    private final int productRequire;

    @Nullable
    private final String scanTip;

    @Nullable
    private final String tip;

    public AiIdentifyGraphModel(int i10, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable List<AiRcmdModel> list) {
        this.productRequire = i10;
        this.tip = str;
        this.scanTip = str2;
        this.freeCount = num;
        this.imageExamples = list;
    }

    public static /* synthetic */ AiIdentifyGraphModel copy$default(AiIdentifyGraphModel aiIdentifyGraphModel, int i10, String str, String str2, Integer num, List list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = aiIdentifyGraphModel.productRequire;
        }
        if ((i11 & 2) != 0) {
            str = aiIdentifyGraphModel.tip;
        }
        String str3 = str;
        if ((i11 & 4) != 0) {
            str2 = aiIdentifyGraphModel.scanTip;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            num = aiIdentifyGraphModel.freeCount;
        }
        Integer num2 = num;
        if ((i11 & 16) != 0) {
            list = aiIdentifyGraphModel.imageExamples;
        }
        return aiIdentifyGraphModel.copy(i10, str3, str4, num2, list);
    }

    public final int component1() {
        return this.productRequire;
    }

    @Nullable
    public final String component2() {
        return this.tip;
    }

    @Nullable
    public final String component3() {
        return this.scanTip;
    }

    @Nullable
    public final Integer component4() {
        return this.freeCount;
    }

    @Nullable
    public final List<AiRcmdModel> component5() {
        return this.imageExamples;
    }

    @NotNull
    public final AiIdentifyGraphModel copy(int i10, @Nullable String str, @Nullable String str2, @Nullable Integer num, @Nullable List<AiRcmdModel> list) {
        return new AiIdentifyGraphModel(i10, str, str2, num, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AiIdentifyGraphModel)) {
            return false;
        }
        AiIdentifyGraphModel aiIdentifyGraphModel = (AiIdentifyGraphModel) obj;
        return this.productRequire == aiIdentifyGraphModel.productRequire && s.d(this.tip, aiIdentifyGraphModel.tip) && s.d(this.scanTip, aiIdentifyGraphModel.scanTip) && s.d(this.freeCount, aiIdentifyGraphModel.freeCount) && s.d(this.imageExamples, aiIdentifyGraphModel.imageExamples);
    }

    @Nullable
    public final Integer getFreeCount() {
        return this.freeCount;
    }

    @Nullable
    public final List<AiRcmdModel> getImageExamples() {
        return this.imageExamples;
    }

    public final int getProductRequire() {
        return this.productRequire;
    }

    @Nullable
    public final String getScanTip() {
        return this.scanTip;
    }

    @Nullable
    public final String getTip() {
        return this.tip;
    }

    public int hashCode() {
        int i10 = this.productRequire * 31;
        String str = this.tip;
        int hashCode = (i10 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.scanTip;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.freeCount;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        List<AiRcmdModel> list = this.imageExamples;
        return hashCode3 + (list != null ? list.hashCode() : 0);
    }

    public final void setFreeCount(@Nullable Integer num) {
        this.freeCount = num;
    }

    @NotNull
    public String toString() {
        return "AiIdentifyGraphModel(productRequire=" + this.productRequire + ", tip=" + this.tip + ", scanTip=" + this.scanTip + ", freeCount=" + ((Object) this.freeCount) + ", imageExamples=" + ((Object) this.imageExamples) + ")";
    }
}
