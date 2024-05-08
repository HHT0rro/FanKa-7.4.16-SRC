package com.cupidapp.live.base.router.jumper;

import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import com.cupidapp.live.base.router.h;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.utils.CoordinateModel;
import com.cupidapp.live.base.utils.LocationUtils;
import com.cupidapp.live.match.activity.MapFilterNewActivity;
import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MapFilterUrlJumper.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class MapFilterUrlJumper implements com.cupidapp.live.base.router.h {
    @Override // com.cupidapp.live.base.router.h
    public void a(@Nullable final Context context, @NotNull final Uri uri, @Nullable String str) {
        kotlin.jvm.internal.s.i(uri, "uri");
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null) {
            LocationUtils.f12270h.e(context, new xb.b(fragmentActivity), new Function0<kotlin.p>() { // from class: com.cupidapp.live.base.router.jumper.MapFilterUrlJumper$jump$1$1
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
                    CoordinateModel j10 = LocationUtils.f12270h.a().j();
                    Context context2 = context;
                    if (context2 != null) {
                        MapFilterNewActivity.f16502z.a(context2, Double.valueOf(j10.getLatitude()), Double.valueOf(j10.getLongitude()), this.b(uri.getQueryParameter("source")), VipPurchaseEntranceType.MapFilter);
                    }
                }
            });
        }
    }

    @NotNull
    public SensorPosition b(@Nullable String str) {
        return h.a.a(this, str);
    }
}
