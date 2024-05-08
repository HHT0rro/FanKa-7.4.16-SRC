package androidx.activity.result;

import android.content.Intent;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ActivityResult.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ActivityResultKt {
    public static final int component1(@NotNull ActivityResult activityResult) {
        s.i(activityResult, "<this>");
        return activityResult.getResultCode();
    }

    @Nullable
    public static final Intent component2(@NotNull ActivityResult activityResult) {
        s.i(activityResult, "<this>");
        return activityResult.getData();
    }
}
