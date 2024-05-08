package z0;

import android.view.View;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* compiled from: ViewExtension.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class r implements View.OnClickListener {

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final Function1<View, kotlin.p> f54821b;

    /* renamed from: c, reason: collision with root package name */
    public long f54822c;

    /* renamed from: d, reason: collision with root package name */
    public final long f54823d = 300;

    /* JADX WARN: Multi-variable type inference failed */
    public r(@Nullable Function1<? super View, kotlin.p> function1) {
        this.f54821b = function1;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f54822c > this.f54823d) {
            Function1<View, kotlin.p> function1 = this.f54821b;
            if (function1 != null) {
                function1.invoke(view);
            }
            this.f54822c = currentTimeMillis;
        }
    }
}
