package android.view;

import android.util.SparseArray;
import java.util.function.IntFunction;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final /* synthetic */ class View$InspectionCompanion$$ExternalSyntheticLambda0 implements IntFunction {
    public final /* synthetic */ SparseArray f$0;

    public /* synthetic */ View$InspectionCompanion$$ExternalSyntheticLambda0(SparseArray sparseArray) {
        this.f$0 = sparseArray;
    }

    @Override // java.util.function.IntFunction
    public final Object apply(int i10) {
        return (String) this.f$0.get(i10);
    }
}
