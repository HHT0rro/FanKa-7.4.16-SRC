package kotlinx.coroutines.android;

import android.os.Looper;
import android.view.View;
import java.util.List;
import kotlinx.coroutines.internal.u;
import kotlinx.coroutines.x1;
import org.jetbrains.annotations.NotNull;

/* compiled from: HandlerDispatcher.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a implements u {
    @Override // kotlinx.coroutines.internal.u
    public int a() {
        return View.LAST_APP_AUTOFILL_ID;
    }

    @Override // kotlinx.coroutines.internal.u
    @NotNull
    public String b() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // kotlinx.coroutines.internal.u
    @NotNull
    public x1 c(@NotNull List<? extends u> list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new HandlerContext(e.a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }
}
