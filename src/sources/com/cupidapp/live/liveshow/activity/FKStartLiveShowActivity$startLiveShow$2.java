package com.cupidapp.live.liveshow.activity;

import android.os.Handler;
import com.cupidapp.live.AppApplication;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: FKStartLiveShowActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKStartLiveShowActivity$startLiveShow$2 extends Lambda implements Function1<Throwable, Boolean> {
    public final /* synthetic */ FKStartLiveShowActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FKStartLiveShowActivity$startLiveShow$2(FKStartLiveShowActivity fKStartLiveShowActivity) {
        super(1);
        this.this$0 = fKStartLiveShowActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$0(FKStartLiveShowActivity this$0) {
        s.i(this$0, "this$0");
        this$0.finish();
    }

    @Override // kotlin.jvm.functions.Function1
    @NotNull
    public final Boolean invoke(@NotNull Throwable it) {
        s.i(it, "it");
        Handler j10 = AppApplication.f11612d.h().j();
        final FKStartLiveShowActivity fKStartLiveShowActivity = this.this$0;
        j10.post(new Runnable() { // from class: com.cupidapp.live.liveshow.activity.g
            @Override // java.lang.Runnable
            public final void run() {
                FKStartLiveShowActivity$startLiveShow$2.invoke$lambda$0(FKStartLiveShowActivity.this);
            }
        });
        return Boolean.FALSE;
    }
}
