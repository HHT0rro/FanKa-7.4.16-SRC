package com.cupidapp.live.liveshow.view;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.network.model.LivePopupWindowModel;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import kotlin.p;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.joda.time.LocalDate;

/* compiled from: FKLivePopupWindowView.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class FKLivePopupWindowWrapper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final FKLivePopupWindowWrapper f15260a = new FKLivePopupWindowWrapper();

    public final boolean a(LivePopupWindowModel livePopupWindowModel) {
        p1.g gVar = p1.g.f52734a;
        LivePopupWindowSettingModel c4 = gVar.U().c();
        if (c4 == null) {
            c4 = new LivePopupWindowSettingModel(null, 0, 0L, 7, null);
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z10 = false;
        if (!s.d(c4.getLivePopupWindowId(), livePopupWindowModel.getId()) || new LocalDate(c4.getShowPopTime()).dayOfMonth().get() != new LocalDate().dayOfMonth().get()) {
            c4.setLivePopupWindowId(livePopupWindowModel.getId());
            c4.setShowCount(0);
            c4.setShowPopTime(0L);
        }
        if (c4.getShowCount() < livePopupWindowModel.getDayMaxViewCount() && currentTimeMillis - c4.getShowPopTime() >= livePopupWindowModel.getIntervalViewTime() * 60000) {
            c4.setShowCount(c4.getShowCount() + 1);
            c4.setShowPopTime(currentTimeMillis);
            z10 = true;
        }
        gVar.U().d(c4);
        return z10;
    }

    public final void b(@Nullable Context context) {
        ConstantsResult q10 = p1.g.f52734a.q();
        LivePopupWindowModel livePopupWindow = q10 != null ? q10.getLivePopupWindow() : null;
        if (context == null || livePopupWindow == null || !a(livePopupWindow)) {
            return;
        }
        FKLivePopupWindowView fKLivePopupWindowView = new FKLivePopupWindowView(context, livePopupWindow);
        final AlertDialog create = z0.b.f54812a.e(context).create();
        fKLivePopupWindowView.setCloseLivePopupWindowView(new Function0<p>() { // from class: com.cupidapp.live.liveshow.view.FKLivePopupWindowWrapper$show$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ p invoke() {
                invoke2();
                return p.f51048a;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                create.dismiss();
            }
        });
        create.show();
        create.setContentView(fKLivePopupWindowView);
        Window window = create.getWindow();
        if (window != null) {
            window.setLayout(-1, -1);
        }
        Window window2 = create.getWindow();
        if (window2 != null) {
            window2.setBackgroundDrawable(new ColorDrawable(com.cupidapp.live.base.utils.h.a(-16777216, 98.0f)));
        }
    }
}
