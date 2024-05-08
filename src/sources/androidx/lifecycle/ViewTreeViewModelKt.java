package androidx.lifecycle;

import android.view.View;
import kotlin.jvm.internal.s;

/* compiled from: ViewTreeViewModel.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewTreeViewModelKt {
    public static final /* synthetic */ ViewModelStoreOwner findViewTreeViewModelStoreOwner(View view) {
        s.i(view, "view");
        return ViewTreeViewModelStoreOwner.get(view);
    }
}
