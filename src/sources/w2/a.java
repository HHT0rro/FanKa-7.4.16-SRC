package w2;

import com.cupidapp.live.base.network.model.ConstantsResult;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.main.helper.LastAlohaOrNopeActionTimeModel;
import com.cupidapp.live.profile.model.User;
import kotlin.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p1.f;
import p1.g;
import p1.k;
import z0.v;

/* compiled from: MatchRedDotHelper.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f54095a = new a();

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    public static final p1.a<LastAlohaOrNopeActionTimeModel> f54096b = new p1.a<>(new f("LAST_ALOHA_OR_NOPE_ACTION_TIME", new k(LastAlohaOrNopeActionTimeModel.class)));

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public static LastAlohaOrNopeActionTimeModel f54097c;

    public final LastAlohaOrNopeActionTimeModel a() {
        if (f54097c == null) {
            p1.a<LastAlohaOrNopeActionTimeModel> aVar = f54096b;
            if (aVar.c() == null) {
                LastAlohaOrNopeActionTimeModel lastAlohaOrNopeActionTimeModel = new LastAlohaOrNopeActionTimeModel(null, 1, null);
                f54097c = lastAlohaOrNopeActionTimeModel;
                aVar.d(lastAlohaOrNopeActionTimeModel);
            } else {
                f54097c = aVar.c();
            }
        }
        return f54097c;
    }

    public final boolean b() {
        Integer matchTabRedDotWaitSecondWhenChangeTab;
        g gVar = g.f52734a;
        User X = gVar.X();
        String userId = X != null ? X.userId() : null;
        LastAlohaOrNopeActionTimeModel a10 = a();
        if (!(userId == null || userId.length() == 0) && a10 != null) {
            Long l10 = a10.getMap().get(userId);
            if (l10 == null) {
                return true;
            }
            long longValue = l10.longValue();
            ConstantsResult q10 = gVar.q();
            return System.currentTimeMillis() - longValue > 86400000 - v.r((q10 == null || (matchTabRedDotWaitSecondWhenChangeTab = q10.getMatchTabRedDotWaitSecondWhenChangeTab()) == null) ? 15 : matchTabRedDotWaitSecondWhenChangeTab.intValue());
        }
        j.f12332a.a("ChatTest", "userId:" + userId + "  model:" + ((Object) a10));
        return false;
    }

    public final void c() {
        User X = g.f52734a.X();
        String userId = X != null ? X.userId() : null;
        LastAlohaOrNopeActionTimeModel a10 = a();
        if (!(userId == null || userId.length() == 0) && a10 != null) {
            a10.getMap().put(userId, Long.valueOf(System.currentTimeMillis()));
            d(a10);
            return;
        }
        j.f12332a.a("ChatTest", "refreshActionTimeInMatch  userId:" + userId + "  model:" + ((Object) a10));
    }

    public final void d(LastAlohaOrNopeActionTimeModel lastAlohaOrNopeActionTimeModel) {
        f54097c = lastAlohaOrNopeActionTimeModel;
        f54096b.d(lastAlohaOrNopeActionTimeModel);
    }
}
