package com.cupidapp.live.base.network.model;

import java.util.List;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ABTestResult.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class ABTestListResult {

    @Nullable
    private final List<ABTestModel> testResults;

    public ABTestListResult(@Nullable List<ABTestModel> list) {
        this.testResults = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ABTestListResult copy$default(ABTestListResult aBTestListResult, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            list = aBTestListResult.testResults;
        }
        return aBTestListResult.copy(list);
    }

    @Nullable
    public final List<ABTestModel> component1() {
        return this.testResults;
    }

    @NotNull
    public final ABTestListResult copy(@Nullable List<ABTestModel> list) {
        return new ABTestListResult(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ABTestListResult) && s.d(this.testResults, ((ABTestListResult) obj).testResults);
    }

    @Nullable
    public final List<ABTestModel> getTestResults() {
        return this.testResults;
    }

    public int hashCode() {
        List<ABTestModel> list = this.testResults;
        if (list == null) {
            return 0;
        }
        return list.hashCode();
    }

    @NotNull
    public String toString() {
        return "ABTestListResult(testResults=" + ((Object) this.testResults) + ")";
    }
}
