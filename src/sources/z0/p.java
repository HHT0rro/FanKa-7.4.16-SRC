package z0;

import android.view.View;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class p implements View.OnLongClickListener {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Function1<View, kotlin.p> f54820b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@Nullable Function1<? super View, kotlin.p> function1) {
        this.f54820b = function1;
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(@Nullable View view) {
        Function1<View, kotlin.p> function1 = this.f54820b;
        if (function1 == null) {
            return true;
        }
        function1.invoke(view);
        return true;
    }
}
