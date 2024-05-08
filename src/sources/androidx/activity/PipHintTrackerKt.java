package androidx.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import androidx.annotation.RequiresApi;
import kotlin.coroutines.Continuation;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PipHintTracker.kt */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class PipHintTrackerKt {
    @RequiresApi(26)
    @Nullable
    public static final Object trackPipAnimationHintView(@NotNull final Activity activity, @NotNull View view, @NotNull Continuation<? super p> continuation) {
        Object a10 = kotlinx.coroutines.flow.e.d(new PipHintTrackerKt$trackPipAnimationHintView$flow$1(view, null)).a(new kotlinx.coroutines.flow.d() { // from class: androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$2
            @Override // kotlinx.coroutines.flow.d
            public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation2) {
                return emit((Rect) obj, (Continuation<? super p>) continuation2);
            }

            @Nullable
            public final Object emit(@NotNull Rect rect, @NotNull Continuation<? super p> continuation2) {
                Api26Impl.INSTANCE.setPipParamsSourceRectHint(activity, rect);
                return p.f51048a;
            }
        }, continuation);
        return a10 == sd.a.d() ? a10 : p.f51048a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect trackPipAnimationHintView$positionInWindow(View view) {
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect;
    }
}
