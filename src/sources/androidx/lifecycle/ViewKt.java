package androidx.lifecycle;

import android.view.View;
import kotlin.jvm.internal.s;

/* compiled from: View.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ViewKt {
    public static final /* synthetic */ LifecycleOwner findViewTreeLifecycleOwner(View view) {
        s.i(view, "<this>");
        return ViewTreeLifecycleOwner.get(view);
    }
}
