package androidx.savedstate;

import android.view.View;
import kotlin.jvm.internal.s;

/* compiled from: View.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewKt {
    public static final /* synthetic */ SavedStateRegistryOwner findViewTreeSavedStateRegistryOwner(View view) {
        s.i(view, "<this>");
        return ViewTreeSavedStateRegistryOwner.get(view);
    }
}
