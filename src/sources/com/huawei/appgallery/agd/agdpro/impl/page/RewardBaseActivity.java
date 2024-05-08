package com.huawei.appgallery.agd.agdpro.impl.page;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.huawei.appgallery.agd.agdpro.R$color;
import com.huawei.appgallery.agd.agdpro.R$id;
import com.huawei.appgallery.agd.agdpro.R$layout;
import com.huawei.appgallery.agd.agdpro.R$plurals;
import com.huawei.appgallery.agd.agdpro.R$string;
import com.huawei.appgallery.agd.agdpro.impl.page.RewardBaseActivity;
import com.huawei.appgallery.agd.agdpro.impl.reward.AgdRewardAd;
import com.huawei.appgallery.agd.agdpro.impl.reward.RewardController;
import com.huawei.appgallery.agd.agdpro.o;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import com.huawei.appgallery.agd.pageframe.api.FLFragment;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.secure.android.common.intent.SafeIntent;
import e9.e;
import e9.t;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RewardBaseActivity extends FragmentActivity implements FLFragment.RewardVideoCallBack {

    /* renamed from: b, reason: collision with root package name */
    public AgdRewardAd f27237b;

    /* renamed from: d, reason: collision with root package name */
    public AlertDialog f27239d;

    /* renamed from: h, reason: collision with root package name */
    public long f27243h;

    /* renamed from: i, reason: collision with root package name */
    public String f27244i;

    /* renamed from: c, reason: collision with root package name */
    public boolean f27238c = false;

    /* renamed from: e, reason: collision with root package name */
    public Handler f27240e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f27241f = true;

    /* renamed from: g, reason: collision with root package name */
    public String f27242g = "others";

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements RewardController.Listener {
        public a() {
        }

        @Override // com.huawei.appgallery.agd.agdpro.impl.reward.RewardController.Listener
        public boolean isActive() {
            return RewardBaseActivity.this.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED);
        }

        @Override // com.huawei.appgallery.agd.agdpro.impl.reward.RewardController.Listener
        public void setColorSystemUIForAppPage() {
            RewardBaseActivity.this.N0();
        }

        @Override // com.huawei.appgallery.agd.agdpro.impl.reward.RewardController.Listener
        public void showConfirmDialog() {
            RewardBaseActivity rewardBaseActivity = RewardBaseActivity.this;
            rewardBaseActivity.f27242g = MaintBi.REASON_CLICK_VIDEO_TOP_CARD_CLOSE;
            rewardBaseActivity.t0(0);
        }

        @Override // com.huawei.appgallery.agd.agdpro.impl.reward.RewardController.Listener
        public void videoFinished() {
            RewardBaseActivity.this.f27238c = true;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i10) {
            dialogInterface.cancel();
            RewardBaseActivity.this.M0();
            RewardBaseActivity.this.f27242g = "others";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0(DialogInterface dialogInterface, int i10) {
        this.f27238c = true;
        if (this.f27237b != null) {
            OperationBi.reportVideoViewAction(OperationBi.ACTION_VIDEO_SURE_LEAVE, System.currentTimeMillis() - this.f27237b.c(), this.f27237b.j());
            MaintBi.reportAdClose(s0(), this.f27237b.getUniqueId(), this.f27244i);
            CardEventInfo cardEventInfo = this.f27237b.i().getCardEventInfo();
            if (cardEventInfo != null) {
                t.c(8, cardEventInfo);
            }
            OperationBi.reportAdCallBackOperate("close", this.f27237b.j());
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z0(DialogInterface dialogInterface) {
        M0();
    }

    public final boolean J0() {
        return (getResources().getConfiguration().uiMode & 48) == 32;
    }

    public final void M0() {
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd == null || this.f27238c) {
            return;
        }
        agdRewardAd.i().enableVideoStatus(true);
    }

    public final void N0() {
        if (J0()) {
            getWindow().setStatusBarColor(-16777216);
            getWindow().setNavigationBarColor(-16777216);
            getWindow().setBackgroundDrawable(getResources().getDrawable(R$color.agd_black));
        } else {
            getWindow().setStatusBarColor(-1);
            getWindow().setNavigationBarColor(-1);
            getWindow().setBackgroundDrawable(getResources().getDrawable(R$color.agd_white));
        }
    }

    public final void O0() {
        getWindow().setStatusBarColor(-16777216);
        getWindow().setNavigationBarColor(-16777216);
        getWindow().setBackgroundDrawable(getResources().getDrawable(R$color.agd_black));
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.RewardVideoCallBack
    public void closeVideo() {
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd != null) {
            agdRewardAd.i().stopVideo();
        }
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    @Nullable
    public JSONArray getLayoutData() {
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd != null) {
            return agdRewardAd.h();
        }
        return null;
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.RewardVideoCallBack
    public boolean isVideoCompleted() {
        return this.f27238c;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        AgdRewardAd agdRewardAd;
        AlertDialog alertDialog = this.f27239d;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.f27239d.cancel();
            return;
        }
        if (!this.f27238c && ((agdRewardAd = this.f27237b) == null || !agdRewardAd.i().isRewarded())) {
            AgdRewardAd agdRewardAd2 = this.f27237b;
            if (agdRewardAd2 != null && !agdRewardAd2.i().isRewarded()) {
                this.f27242g = MaintBi.REASON_CLICK_BACK_CLOSE;
                t0(1);
                return;
            } else {
                e.f48945d.e("RewardBaseActivity", "onBackPressed rewardAd null");
                return;
            }
        }
        super.onBackPressed();
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NonNull Configuration configuration) {
        super.onConfigurationChanged(configuration);
        e.f48945d.i("RewardBaseActivity", "onConfigurationChanged!");
        if (J0()) {
            getWindow().setBackgroundDrawableResource(R$color.agd_black);
            AgdRewardAd agdRewardAd = this.f27237b;
            if (agdRewardAd == null || !agdRewardAd.i().isAppPage()) {
                return;
            }
            getWindow().setStatusBarColor(-16777216);
            getWindow().setNavigationBarColor(-16777216);
            return;
        }
        getWindow().setBackgroundDrawableResource(R$color.agd_white);
        AgdRewardAd agdRewardAd2 = this.f27237b;
        if (agdRewardAd2 == null || !agdRewardAd2.i().isAppPage()) {
            return;
        }
        getWindow().setStatusBarColor(-1);
        getWindow().setNavigationBarColor(-1);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        int i10 = 1;
        requestWindowFeature(1);
        super.onCreate(bundle);
        setContentView(R$layout.activity_reward_base);
        if (ApplicationWrapper.getInstance() != null && ApplicationWrapper.getInstance().getContext() != null) {
            SafeIntent safeIntent = new SafeIntent(getIntent());
            if (!safeIntent.hasExtra("ad_id")) {
                e.f48945d.e("RewardBaseActivity", "onCreate,  adid null ");
                finish();
                MaintBi.reportAdShow(2002, 0L, s0());
                return;
            }
            if (safeIntent.hasExtra("video_Orientation")) {
                if (safeIntent.getIntExtra("video_Orientation", 0) == 1) {
                    i10 = 6;
                }
            } else {
                e.f48945d.w("RewardBaseActivity", "onCreate, requestedOrientation is  null ");
            }
            setRequestedOrientation(i10);
            String stringExtra = safeIntent.getStringExtra("ad_id");
            this.f27244i = stringExtra;
            AgdRewardAd e2 = AgdRewardAd.e(stringExtra);
            this.f27237b = e2;
            if (e2 == null) {
                e.f48945d.e("RewardBaseActivity", "onCreate, rewardAd null");
                finish();
                MaintBi.reportAdShow(2010, 0L, s0());
                return;
            }
            AgdAdManager.setActiveAdSlot(e2.getAdSlot());
            if (bundle == null) {
                FLFragment fLFragment = new FLFragment();
                FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
                beginTransaction.replace(R$id.fl_layout, fLFragment);
                beginTransaction.commit();
                O0();
            }
            if (this.f27240e == null) {
                this.f27240e = new com.huawei.appgallery.agd.agdpro.a(this, getMainLooper());
            }
            o.g().d(this.f27240e, 0);
            o.g().b(getApplicationContext());
            this.f27237b.i().setListener(new a());
            return;
        }
        finish();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        o.g().f();
        o.g().c(this.f27240e);
        Handler handler = this.f27240e;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            this.f27240e = null;
        }
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd != null && agdRewardAd.k() && !this.f27237b.i().isRewarded() && !this.f27237b.i().isVideoError()) {
            MaintBi.reportNoRewardExit(this.f27242g, s0());
        }
        if (isFinishing()) {
            AgdAdManager.removeAd(this.f27244i);
        }
        e.f48945d.i("RewardBaseActivity", "reportAdClose");
        AgdRewardAd agdRewardAd2 = this.f27237b;
        if (agdRewardAd2 == null || agdRewardAd2.g() == null || this.f27237b.i().isJumpWebWhenVideoCompleted()) {
            return;
        }
        this.f27237b.g().onAdClose();
        MaintBi.reportAdClose(s0(), this.f27237b.getUniqueId(), this.f27244i);
        OperationBi.reportAdCallBackOperate("close", s0());
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseNode(String str, @NonNull FLMap fLMap) {
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd != null && agdRewardAd.getAdSlot() != null) {
            AdSlot adSlot = this.f27237b.getAdSlot();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("slotId", adSlot.getSlotId());
                jSONObject.put(CardConstants.KEY_MEDIA_EXTRA, adSlot.getMediaExtra());
                jSONObject.put("ver", adSlot.getVer());
                jSONObject.put("layoutName", str);
            } catch (JSONException unused) {
                e.f48945d.e("RewardBaseActivity", "toJsonString: JSONException");
            }
            fLMap.put(CardConstants.KEY_REQUEST_DATA, jSONObject);
            fLMap.put(CardConstants.KEY_SOUND_STATE, Integer.valueOf(this.f27237b.getAdSlot().getSoundStatus()));
        }
        AgdRewardAd agdRewardAd2 = this.f27237b;
        if (agdRewardAd2 != null) {
            fLMap.put("uniqueId", agdRewardAd2.getUniqueId());
            fLMap.put("slotId", this.f27237b.j());
            fLMap.put(CardConstants.KEY_VIDEO_ORIENTATION, Integer.valueOf(this.f27237b.getAdSlot().getOrientation()));
        }
    }

    @Override // com.huawei.appgallery.agd.pageframe.api.FLFragment.Callback
    public void onParseResult(boolean z10, String str) {
        e.f48945d.i("RewardBaseActivity", "onParseResult#reason is " + str);
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd != null) {
            agdRewardAd.f(z10, str);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd == null || this.f27238c) {
            return;
        }
        agdRewardAd.i().enableVideoStatus(false);
    }

    @Override // android.app.Activity
    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        super.onRestoreInstanceState(bundle);
        this.f27244i = bundle.getString("ad_id");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        AlertDialog alertDialog = this.f27239d;
        if (alertDialog == null || !alertDialog.isShowing()) {
            M0();
        }
    }

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putString("ad_id", this.f27244i);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd == null || agdRewardAd.i().isRewarded()) {
            return;
        }
        MaintBi.reportRewardPauseOrResume(this.f27237b.i().getStopReason(), 1, s0(), (int) ((System.currentTimeMillis() - this.f27243h) / 1000));
        this.f27243h = 0L;
        this.f27237b.i().setStopReason(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        AgdRewardAd agdRewardAd = this.f27237b;
        if (agdRewardAd == null || agdRewardAd.i().isRewarded()) {
            return;
        }
        MaintBi.reportRewardPauseOrResume(this.f27237b.i().getStopReason(), 0, s0(), 0);
        this.f27243h = System.currentTimeMillis();
    }

    public final String s0() {
        AgdRewardAd agdRewardAd = this.f27237b;
        return agdRewardAd == null ? "" : agdRewardAd.j();
    }

    public void t0(int i10) {
        e eVar = e.f48945d;
        eVar.i("RewardBaseActivity", "showConformDialog " + i10);
        if (this.f27237b == null) {
            eVar.e("RewardBaseActivity", "showConformDialog rewardAd null, finish");
            finish();
            return;
        }
        AlertDialog alertDialog = this.f27239d;
        if (alertDialog == null || !alertDialog.isShowing()) {
            long remainingTime = this.f27237b.i().getRemainingTime();
            String quantityString = getResources().getQuantityString(R$plurals.rewardad_leaving_prompt, (int) remainingTime, Long.valueOf(remainingTime));
            AgdRewardAd agdRewardAd = this.f27237b;
            if (agdRewardAd != null && !this.f27238c) {
                agdRewardAd.i().enableVideoStatus(false);
            }
            AlertDialog create = new AlertDialog.Builder(this).setMessage(quantityString).setPositiveButton(R$string.rewardad_continue_watching, new b()).setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: g9.b
                @Override // android.content.DialogInterface.OnDismissListener
                public final void onDismiss(DialogInterface dialogInterface) {
                    RewardBaseActivity.this.z0(dialogInterface);
                }
            }).setNegativeButton(R$string.rewardad_confirm_leaving, new DialogInterface.OnClickListener() { // from class: g9.a
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i11) {
                    RewardBaseActivity.this.E0(dialogInterface, i11);
                }
            }).setCancelable(true).create();
            this.f27239d = create;
            create.show();
        }
    }
}
