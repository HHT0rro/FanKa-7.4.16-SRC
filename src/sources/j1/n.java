package j1;

import com.cupidapp.live.profile.model.UserRankModel;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: SensorsLogSuperProperties.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final n f50241a = new n();

    public final void a(@NotNull String id2) {
        s.i(id2, "id");
        z3.c.f54829a.o(id2);
    }

    public final void b(@NotNull UserRankModel result) {
        s.i(result, "result");
        Boolean realAvatar = result.getRealAvatar();
        boolean booleanValue = realAvatar != null ? realAvatar.booleanValue() : true;
        z3.c cVar = z3.c.f54829a;
        int vipType = result.getVipType();
        Boolean visitorEnable = result.getVisitorEnable();
        cVar.l(vipType, visitorEnable != null ? visitorEnable.booleanValue() : false, !booleanValue, result.getSuperLikeRemains(), result.getVipCount(), result.getSvipCount(), result.getVisitorCount(), result.getSsvipCount());
    }
}
