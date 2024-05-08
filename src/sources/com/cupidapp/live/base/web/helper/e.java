package com.cupidapp.live.base.web.helper;

import android.os.Looper;
import android.os.MessageQueue;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.base.web.FKWebView;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: WebViewResourcePreloadHelper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f13103a = new e();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public static FKWebView f13104b;

    public static final boolean c(FragmentActivity activity, String str) {
        s.i(activity, "$activity");
        if (f13104b != null) {
            return false;
        }
        FKWebView fKWebView = new FKWebView(activity);
        activity.getLifecycle().addObserver(fKWebView);
        fKWebView.u(str);
        f13104b = fKWebView;
        return false;
    }

    public final void b(@NotNull final FragmentActivity activity, @Nullable final String str) {
        s.i(activity, "activity");
        if (u0.a.f53817a.c()) {
            if (str == null || str.length() == 0) {
                return;
            }
            Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() { // from class: com.cupidapp.live.base.web.helper.d
                @Override // android.os.MessageQueue.IdleHandler
                public final boolean queueIdle() {
                    boolean c4;
                    c4 = e.c(FragmentActivity.this, str);
                    return c4;
                }
            });
        }
    }
}
