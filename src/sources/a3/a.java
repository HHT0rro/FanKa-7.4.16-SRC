package a3;

import com.cupidapp.live.vip.wrapper.VipPurchaseEntranceType;
import kotlin.d;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: MatchEvent.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f695a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f696b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public final VipPurchaseEntranceType f697c;

    public a(@NotNull String sensorFrom, boolean z10, @Nullable VipPurchaseEntranceType vipPurchaseEntranceType) {
        s.i(sensorFrom, "sensorFrom");
        this.f695a = sensorFrom;
        this.f696b = z10;
        this.f697c = vipPurchaseEntranceType;
    }

    public final boolean a() {
        return this.f696b;
    }

    @NotNull
    public final String b() {
        return this.f695a;
    }

    public /* synthetic */ a(String str, boolean z10, VipPurchaseEntranceType vipPurchaseEntranceType, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i10 & 2) != 0 ? false : z10, (i10 & 4) != 0 ? null : vipPurchaseEntranceType);
    }
}
