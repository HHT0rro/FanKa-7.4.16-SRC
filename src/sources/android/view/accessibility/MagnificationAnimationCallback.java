package android.view.accessibility;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public interface MagnificationAnimationCallback {
    public static final MagnificationAnimationCallback STUB_ANIMATION_CALLBACK = new MagnificationAnimationCallback() { // from class: android.view.accessibility.MagnificationAnimationCallback$$ExternalSyntheticLambda0
        @Override // android.view.accessibility.MagnificationAnimationCallback
        public final void onResult(boolean z10) {
            MagnificationAnimationCallback.lambda$static$0(z10);
        }
    };

    void onResult(boolean z10);

    static /* synthetic */ void lambda$static$0(boolean success) {
    }
}
