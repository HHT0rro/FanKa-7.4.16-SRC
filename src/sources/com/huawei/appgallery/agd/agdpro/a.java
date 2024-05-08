package com.huawei.appgallery.agd.agdpro;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import com.huawei.appgallery.agd.agdpro.impl.page.RewardBaseActivity;
import com.huawei.appgallery.agd.agdpro.impl.reward.AgdRewardAd;
import com.huawei.appgallery.agd.agdpro.o;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RewardBaseActivity f27219a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(RewardBaseActivity rewardBaseActivity, Looper looper) {
        super(looper);
        this.f27219a = rewardBaseActivity;
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        o.d dVar;
        AgdRewardAd agdRewardAd;
        if (message == null || message.what != 0) {
            return;
        }
        int i10 = message.arg1;
        if (i10 == 0) {
            dVar = o.d.UNKNOWN;
        } else if (i10 == 1) {
            dVar = o.d.CONNECTED;
        } else if (i10 != 2) {
            dVar = o.d.UNKNOWN;
        } else {
            dVar = o.d.NOT_CONNECTED;
        }
        boolean z10 = dVar == o.d.CONNECTED;
        RewardBaseActivity rewardBaseActivity = this.f27219a;
        if (!rewardBaseActivity.f27241f && z10 && (agdRewardAd = rewardBaseActivity.f27237b) != null && agdRewardAd.i().isVideoError()) {
            this.f27219a.f27237b.i().enableVideoStatus(true);
        }
        this.f27219a.f27241f = z10;
    }
}
