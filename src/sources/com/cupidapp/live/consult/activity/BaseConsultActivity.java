package com.cupidapp.live.consult.activity;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.cupidapp.live.base.activity.FKBaseActivity;
import com.cupidapp.live.base.sensorslog.SensorPosition;
import com.cupidapp.live.base.share.fragment.ShareBottomFragment;
import com.cupidapp.live.base.share.fragment.ShareModel;
import com.cupidapp.live.base.share.helper.ShareBuilder;
import com.cupidapp.live.base.utils.j;
import com.cupidapp.live.base.utils.p0;
import com.cupidapp.live.consult.fragment.ConsultMiniProfileFragment;
import com.cupidapp.live.consult.fragment.ShowConsultMiniProfileModel;
import com.cupidapp.live.consult.model.ConsultLiveModel;
import com.cupidapp.live.liveshow.fragment.LiveShowWebFragment;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.s;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: BaseConsultActivity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class BaseConsultActivity extends FKBaseActivity {

    /* renamed from: q, reason: collision with root package name */
    @Nullable
    public LiveShowWebFragment f13714q;

    /* renamed from: r, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f13715r = new LinkedHashMap();

    public final void j1() {
        LiveShowWebFragment liveShowWebFragment = this.f13714q;
        if (liveShowWebFragment != null) {
            liveShowWebFragment.dismiss();
        }
        this.f13714q = null;
    }

    public final void k1(@Nullable ConsultLiveModel consultLiveModel) {
        if (consultLiveModel == null) {
            return;
        }
        SensorPosition sensorPosition = SensorPosition.CONSULT_ROOM;
        ShareBuilder a10 = com.cupidapp.live.base.share.helper.d.f12255a.a(this, consultLiveModel, sensorPosition);
        if (a10 == null) {
            j.f12332a.a("BaseConsultActivity", "showShareDialog shareBuilder = null");
            return;
        }
        ShareModel shareModel = new ShareModel(null, null, a10, null, null, sensorPosition, null, null, null, null, null, 2011, null);
        ShareBottomFragment a11 = ShareBottomFragment.f12224k.a();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        s.h(supportFragmentManager, "supportFragmentManager");
        ShareBottomFragment.w1(a11, supportFragmentManager, shareModel, null, 4, null);
    }

    public final void l1(@Nullable String str) {
        LiveShowWebFragment a10 = LiveShowWebFragment.f15059k.a(str, false);
        this.f13714q = a10;
        if (a10 != null) {
            FragmentManager supportFragmentManager = getSupportFragmentManager();
            s.h(supportFragmentManager, "supportFragmentManager");
            a10.e1(supportFragmentManager);
        }
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        p0.c(this, true, 0, 2, null);
        com.cupidapp.live.push.d.f17892a.j(true);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        com.cupidapp.live.push.d.f17892a.j(false);
    }

    @he.j(threadMode = ThreadMode.MAIN)
    public final void onEvent(@NotNull ShowConsultMiniProfileModel event) {
        s.i(event, "event");
        ConsultMiniProfileFragment.f13774g.a(getSupportFragmentManager(), event);
    }

    @Override // com.cupidapp.live.base.activity.FKBaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        com.cupidapp.live.push.d.f17892a.j(true);
    }
}
