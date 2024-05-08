package android.widget;

import java.util.function.Supplier;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* compiled from: D8$$SyntheticClass */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public final /* synthetic */ class SelectionActionModeHelper$$ExternalSyntheticLambda3 implements Supplier {
    public final /* synthetic */ TextView f$0;

    public /* synthetic */ SelectionActionModeHelper$$ExternalSyntheticLambda3(TextView textView) {
        this.f$0 = textView;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return this.f$0.getTextClassificationSession();
    }
}
