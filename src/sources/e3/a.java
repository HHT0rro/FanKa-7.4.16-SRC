package e3;

import android.os.Build;
import kotlin.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: SdkVersionUtils.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f48859a = new a();

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public final boolean b() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public final boolean c() {
        return Build.VERSION.SDK_INT >= 30;
    }
}
