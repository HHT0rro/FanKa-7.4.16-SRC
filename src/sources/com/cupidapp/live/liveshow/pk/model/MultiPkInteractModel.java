package com.cupidapp.live.liveshow.pk.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MultiPersonPkGrpcModel.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MultiPkInteractModel {

    @NotNull
    private final List<MultiPkResultModel> result;

    public MultiPkInteractModel(@NotNull List<MultiPkResultModel> result) {
        s.i(result, "result");
        this.result = result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MultiPkInteractModel copy$default(MultiPkInteractModel multiPkInteractModel, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = multiPkInteractModel.result;
        }
        return multiPkInteractModel.copy(list);
    }

    @NotNull
    public final List<MultiPkResultModel> component1() {
        return this.result;
    }

    @NotNull
    public final MultiPkInteractModel copy(@NotNull List<MultiPkResultModel> result) {
        s.i(result, "result");
        return new MultiPkInteractModel(result);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof MultiPkInteractModel) && s.d(this.result, ((MultiPkInteractModel) obj).result);
    }

    @NotNull
    public final List<MultiPkResultModel> getResult() {
        return this.result;
    }

    public int hashCode() {
        return this.result.hashCode();
    }

    @NotNull
    public String toString() {
        return "MultiPkInteractModel(result=" + ((Object) this.result) + ")";
    }
}
