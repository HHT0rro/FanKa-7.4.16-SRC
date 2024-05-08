package z0;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import org.jetbrains.annotations.NotNull;

/* compiled from: ViewGroupExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class z {
    @NotNull
    public static final View a(@NotNull ViewGroup viewGroup, @LayoutRes int i10, boolean z10) {
        kotlin.jvm.internal.s.i(viewGroup, "<this>");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i10, viewGroup, z10);
        kotlin.jvm.internal.s.h(inflate, "from(context).inflate(resId, this, attachToRoot)");
        return inflate;
    }

    public static /* synthetic */ View b(ViewGroup viewGroup, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        return a(viewGroup, i10, z10);
    }
}
