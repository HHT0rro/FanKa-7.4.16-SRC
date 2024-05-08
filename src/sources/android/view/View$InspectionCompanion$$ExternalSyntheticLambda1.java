package android.view;

import android.view.inspector.IntFlagMapping;
import java.util.function.IntFunction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final /* synthetic */ class View$InspectionCompanion$$ExternalSyntheticLambda1 implements IntFunction {
    public final /* synthetic */ IntFlagMapping f$0;

    public /* synthetic */ View$InspectionCompanion$$ExternalSyntheticLambda1(IntFlagMapping intFlagMapping) {
        this.f$0 = intFlagMapping;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i10) {
        return this.f$0.get(i10);
    }
}
