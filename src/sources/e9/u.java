package e9;

import com.huawei.appgallery.agd.agdpro.impl.reward.RewardController;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class u implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ CardEventInfo f48987b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RewardController f48988c;

    public u(RewardController rewardController, CardEventInfo cardEventInfo) {
        this.f48988c = rewardController;
        this.f48987b = cardEventInfo;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f48988c.a(this.f48987b);
    }
}
