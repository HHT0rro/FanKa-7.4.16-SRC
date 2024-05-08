package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.match.activity.TravelMapActivity;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: TravelUseJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class TravelUseJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            xb.b bVar = new xb.b(fragmentActivity);
            final SensorPosition b4 = b(uri.getQueryParameter("source"));
            LocationUtils.f12270h.e(context, bVar, new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.TravelUseJumper$jump$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ kotlin.p invoke() {
                    invoke2();
                    return kotlin.p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    TravelMapActivity.f16565x.a(context, b4.getValue());
                }
            });
        }
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
