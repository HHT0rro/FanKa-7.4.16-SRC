package n1;

import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: VibrateHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f52091a = new a();

    public static /* synthetic */ void b(a aVar, Context context, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = 40;
        }
        aVar.a(context, j10);
    }

    public final void a(@Nullable Context context, long j10) {
        if (context == null) {
            return;
        }
        Object systemService = context.getSystemService("vibrator");
        Vibrator vibrator = systemService instanceof Vibrator ? (Vibrator) systemService : null;
        if (vibrator != null && vibrator.hasVibrator()) {
            vibrator.cancel();
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(VibrationEffect.createOneShot(j10, -1));
            } else {
                vibrator.vibrate(j10);
            }
        }
    }
}
