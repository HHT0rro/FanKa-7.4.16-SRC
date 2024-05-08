package com.huawei.appgallery.agd.agdpro.impl.reward;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import com.huawei.appgallery.agd.agdpro.R$id;
import com.huawei.appgallery.agd.agdpro.R$layout;
import com.huawei.appgallery.agd.agdpro.R$string;
import com.huawei.appgallery.agd.agdpro.api.RewardInfo;
import com.huawei.appgallery.agd.agdpro.impl.reward.RewardController;
import com.huawei.appgallery.agd.agdpro.impl.web.WebViewLauncher;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.core.impl.store.carddata.ICommonInfo;
import com.huawei.appgallery.agd.core.impl.store.rewardverify.RewardVerifyRequest;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.appgallery.agd.serverreq.ServerAgent;
import com.huawei.appgallery.agd.serverreq.utils.network.NetworkUtil;
import com.huawei.flexiblelayout.card.interation.CellFinder;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.jmessage.api.EventQueue;
import com.huawei.jmessage.api.EventSourceManager;
import com.huawei.jmessage.api.MessageChannelPayload;
import com.huawei.jmessage.sources.MessageChannelSource;
import e9.a;
import e9.e;
import e9.o;
import e9.p;
import e9.t;
import e9.u;
import e9.v;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class RewardController {

    /* renamed from: a, reason: collision with root package name */
    public ICommonInfo f27255a;

    /* renamed from: b, reason: collision with root package name */
    public CardEventInfo f27256b;

    /* renamed from: c, reason: collision with root package name */
    public final AgdRewardAd f27257c;

    /* renamed from: d, reason: collision with root package name */
    public JSONObject f27258d;

    /* renamed from: e, reason: collision with root package name */
    public long f27259e;

    /* renamed from: f, reason: collision with root package name */
    public long f27260f;

    /* renamed from: g, reason: collision with root package name */
    public int f27261g;

    /* renamed from: h, reason: collision with root package name */
    public Listener f27262h;

    /* renamed from: k, reason: collision with root package name */
    public boolean f27265k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f27266l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f27267m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f27268n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f27269o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f27270p;

    /* renamed from: i, reason: collision with root package name */
    public int f27263i = 0;

    /* renamed from: j, reason: collision with root package name */
    public boolean f27264j = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f27271q = false;

    /* renamed from: r, reason: collision with root package name */
    public final EventQueue f27272r = (EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq");

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface Listener {
        boolean isActive();

        void setColorSystemUIForAppPage();

        void showConfirmDialog();

        void videoFinished();
    }

    public RewardController(AgdRewardAd agdRewardAd, @NonNull JSONArray jSONArray) {
        this.f27257c = agdRewardAd;
        e.f48945d.i("RewardController", "parseRewardInfo");
        try {
            JSONObject jSONObject = jSONArray.getJSONObject(0).getJSONArray(CardConstants.KEY_DATA_LIST).getJSONObject(0).getJSONObject(CardConstants.KEY_EXT_PARAM);
            this.f27258d = jSONObject;
            long j10 = jSONObject.getLong("rewardTime");
            this.f27259e = j10;
            this.f27260f = j10;
        } catch (JSONException unused) {
            e.f48945d.e("RewardController", "parseRewardInfo failed");
        }
    }

    public static /* synthetic */ Object c(Object[] objArr) throws RemoteException {
        e.f48945d.i("RewardController", "notImplemented");
        return null;
    }

    public static void init() {
        e.f48945d.i("RewardController", "init");
        EventSourceManager eventSourceManager = (EventSourceManager) ComponentRepository.getRepository().lookup(jmessage.name).create(EventSourceManager.class);
        eventSourceManager.register("rewardVerify", (String) new o());
        eventSourceManager.register("videoControl", (String) new p());
    }

    public final void a() {
        e.f48945d.i("RewardController", "onVideoPause");
        if (this.f27268n || this.f27269o) {
            return;
        }
        this.f27269o = true;
    }

    public final void b() {
        e.f48945d.i("RewardController", "onVideoResume");
        if (this.f27269o && this.f27262h.isActive()) {
            this.f27269o = false;
        }
    }

    public void enableVideoStatus(boolean z10) {
        e.f48945d.i("RewardController", "enableVideoStatus shouldPlay " + z10);
        this.f27272r.publish("videoControl", Integer.valueOf(z10 ? 2 : 1));
    }

    public CardEventInfo getCardEventInfo() {
        return this.f27256b;
    }

    public ICommonInfo getCommonInfo() {
        return this.f27255a;
    }

    public long getRemainingTime() {
        return this.f27260f;
    }

    public int getStopReason() {
        return this.f27263i;
    }

    public boolean isAppPage() {
        return this.f27264j;
    }

    public boolean isJumpWebWhenVideoCompleted() {
        return this.f27265k;
    }

    public boolean isRewarded() {
        return this.f27266l;
    }

    public boolean isVideoError() {
        return this.f27270p;
    }

    public void onCardEvent(@NonNull CardEventInfo cardEventInfo) {
        if (!"videoProgress".equals(cardEventInfo.type)) {
            a.c("onCardEvent ", cardEventInfo, e.f48945d, "RewardController");
        }
        String str = cardEventInfo.type;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1641913779:
                if (str.equals(CardEventType.CLICK_ACTION_VIDEO_ERROR)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1632258501:
                if (str.equals("videoPause")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1267953720:
                if (str.equals("videoProgress")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1263202134:
                if (str.equals("openWeb")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1177422000:
                if (str.equals("openDeeplink")) {
                    c4 = 4;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c4 = 5;
                    break;
                }
                break;
            case 187991823:
                if (str.equals(CardEventType.CLICK_ACTION_AUDIO_MUTE)) {
                    c4 = 6;
                    break;
                }
                break;
            case 492941256:
                if (str.equals(CardEventType.CLICK_ACTION_AUDIO_UN_MUTE)) {
                    c4 = 7;
                    break;
                }
                break;
            case 660473070:
                if (str.equals(CardEventType.CLICK_ACTION_VIDEO_FINISH)) {
                    c4 = '\b';
                    break;
                }
                break;
            case 1000489096:
                if (str.equals("videoResume")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 1332829775:
                if (str.equals(CardEventType.CLICK_ACTION_VIDEO_PLAY)) {
                    c4 = '\n';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                e.f48945d.i("RewardController", "onVideoError");
                this.f27256b = cardEventInfo;
                AgdRewardAd agdRewardAd = this.f27257c;
                if (agdRewardAd != null && agdRewardAd.g() != null) {
                    this.f27257c.g().onAdShowError(10002);
                    if (!this.f27271q) {
                        MaintBi.reportAdShowError(10002, cardEventInfo.adVideoUrl, "video error", this.f27257c.j());
                        this.f27271q = true;
                        OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_FAILURE, this.f27257c.j());
                    }
                }
                AgdRewardAd agdRewardAd2 = this.f27257c;
                if (agdRewardAd2 != null) {
                    agdRewardAd2.i().setVideoError(true);
                    return;
                }
                return;
            case 1:
                a();
                return;
            case 2:
                onVideoTime(cardEventInfo);
                return;
            case 3:
            case 4:
                this.f27263i = 1;
                return;
            case 5:
                e eVar = e.f48945d;
                StringBuilder b4 = a.b("onVideoClose#msg = ");
                b4.append(cardEventInfo.toString());
                eVar.i("RewardController", b4.toString());
                if (this.f27266l) {
                    cardEventInfo.flContext.getActivity().finish();
                    return;
                }
                Listener listener = this.f27262h;
                if (listener != null) {
                    listener.showConfirmDialog();
                    return;
                }
                return;
            case 6:
                OperationBi.reportVideoViewAction("videoMute", System.currentTimeMillis() - this.f27257c.c(), this.f27257c.j());
                return;
            case 7:
                OperationBi.reportVideoViewAction("videoSoundOn", System.currentTimeMillis() - this.f27257c.c(), this.f27257c.j());
                return;
            case '\b':
                if (!this.f27268n) {
                    this.f27268n = true;
                    e.f48945d.i("RewardController", "onVideoComplete ");
                    Listener listener2 = this.f27262h;
                    if (listener2 != null) {
                        listener2.videoFinished();
                    }
                    new Handler().postDelayed(new u(this, cardEventInfo), 2L);
                }
                onVideoTime(cardEventInfo);
                return;
            case '\t':
                b();
                return;
            case '\n':
                e.f48945d.i("RewardController", "onVideoStart");
                this.f27256b = cardEventInfo;
                this.f27272r.publish("rewardVerify", Boolean.FALSE);
                this.f27268n = false;
                this.f27269o = false;
                this.f27257c.i().setVideoError(false);
                return;
            default:
                return;
        }
    }

    public void onVideoTime(@NonNull CardEventInfo cardEventInfo) {
        e eVar = e.f48945d;
        StringBuilder b4 = a.b("onVideoTime passTime ");
        b4.append(cardEventInfo.videoProgress);
        b4.append(", rewardTime ");
        b4.append(this.f27259e);
        b4.append(", videoLength ");
        b4.append(cardEventInfo.videoDuration);
        eVar.i("RewardController", b4.toString());
        int i10 = (int) (this.f27268n ? cardEventInfo.videoDuration : cardEventInfo.videoProgress);
        this.f27261g = i10;
        long j10 = cardEventInfo.videoDuration;
        if (j10 <= 2) {
            eVar.d("RewardController", "videoTime length error");
            return;
        }
        long j11 = this.f27259e;
        if (j11 > j10 || j11 <= 0) {
            this.f27259e = j10;
            this.f27260f = j10;
        }
        if (this.f27260f <= 0) {
            return;
        }
        long j12 = this.f27259e - i10;
        this.f27260f = j12;
        if (j12 < 0) {
            this.f27260f = 0L;
        }
        if (this.f27260f == 2 && !this.f27267m) {
            this.f27267m = true;
            eVar.i("RewardController", "onVideoTime reward time closing, send callback");
            JSONObject jSONObject = this.f27258d;
            if (jSONObject == null) {
                eVar.e("RewardController", "rewardData is empty errorCode=2007,errorMsg=rewardData is empty");
                a(null, 2007, "rewardData is empty");
            } else {
                String userId = AgdAdManager.getConfig() != null ? AgdAdManager.getConfig().getUserId() : "";
                RewardVerifyRequest rewardVerifyRequest = new RewardVerifyRequest();
                rewardVerifyRequest.setRewardInfo(jSONObject);
                rewardVerifyRequest.setMediaParam(userId);
                rewardVerifyRequest.setSlotId(this.f27257c.getAdSlot().getSlotId());
                ServerAgent.invokeServerEx(rewardVerifyRequest, new v(this, jSONObject));
            }
        }
        if (this.f27260f == 0) {
            eVar.i("RewardController", "onVideoTime reward time up");
            if (this.f27262h != null) {
                a(cardEventInfo.flContext.getActivity(), R$string.rewardad_has_rewarded);
            }
            this.f27266l = true;
            this.f27272r.publish("rewardVerify", Boolean.TRUE);
        }
    }

    public void setListener(Listener listener) {
        this.f27262h = listener;
    }

    public void setStopReason(int i10) {
        this.f27263i = i10;
    }

    public void setVideoError(boolean z10) {
        this.f27270p = z10;
    }

    public void stopVideo() {
        e.f48945d.i("RewardController", "stopVideo");
        this.f27272r.publish("videoControl", 3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void b(Activity activity, int i10) {
        if ((activity instanceof LifecycleOwner) && !((LifecycleOwner) activity).getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            e.f48945d.w("RewardController", "showToast#Activity invisible");
            return;
        }
        Context applicationContext = activity.getApplicationContext();
        String string = applicationContext.getResources().getString(i10);
        Toast toast = new Toast(applicationContext);
        View inflate = LayoutInflater.from(applicationContext).inflate(R$layout.toast_reward, (ViewGroup) null);
        ((TextView) inflate.findViewById(R$id.tv_toast_content)).setText(string);
        toast.setDuration(1);
        toast.setView(inflate);
        toast.show();
    }

    public final void a(@NonNull final Activity activity, @StringRes final int i10) {
        activity.runOnUiThread(new Runnable() { // from class: h9.d
            @Override // java.lang.Runnable
            public final void run() {
                RewardController.b(activity, i10);
            }
        });
    }

    public final void a(JSONObject jSONObject, int i10, String str) {
        e eVar = e.f48945d;
        eVar.i("RewardController", "notifyReward errorCode " + i10 + ", msg=" + str);
        RewardInfo rewardInfo = new RewardInfo(jSONObject, i10, str);
        if (this.f27257c.g() != null) {
            this.f27257c.g().onRewardVerify(rewardInfo);
        } else {
            eVar.e("RewardController", "InteractionListener is null");
        }
        MaintBi.reportDistributionReward(rewardInfo.getCode(), rewardInfo.getMessage(), this.f27257c.j());
        OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_REWARD_SENT, this.f27257c.j());
    }

    public final void a(@NonNull CardEventInfo cardEventInfo) {
        Activity activity = cardEventInfo.flContext.getActivity();
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
            if (!TextUtils.isEmpty(cardEventInfo.adWapUrl)) {
                if (!NetworkUtil.hasActiveNetwork(cardEventInfo.flContext.getContext())) {
                    e.f48945d.w("RewardController", "showToast#Activity invisible");
                    a(cardEventInfo.flContext.getActivity(), R$string.rewardad_no_network);
                    t.e(cardEventInfo, MaintKey.EVENT_WAP_PAGE_START_ERROR, "rewardad_no_network", cardEventInfo.adWapUrl);
                    return;
                } else {
                    a.d(a.b("jump to dsp web page: "), cardEventInfo.adWapUrl, e.f48945d, "RewardController");
                    WebViewLauncher.startWebViewActivity(cardEventInfo.flContext.getActivity(), cardEventInfo);
                    this.f27265k = true;
                    cardEventInfo.flContext.getActivity().finish();
                    t.e(cardEventInfo, MaintKey.EVENT_WAP_PAGE_START_ERROR, "rewardad_no_network", cardEventInfo.adWapUrl);
                    return;
                }
            }
            e eVar = e.f48945d;
            eVar.i("RewardController", "switch to app landing page");
            this.f27264j = true;
            Listener listener = this.f27262h;
            if (listener != null) {
                listener.setColorSystemUIForAppPage();
            }
            MessageChannelPayload build = new MessageChannelPayload.Builder("cardVisibility").args(Jsons.newJson().put("visibility", 8)).success(new MessageChannelPayload.Callback() { // from class: h9.a
                @Override // com.huawei.jmessage.api.MessageChannelPayload.Callback
                public final Object call(Object[] objArr) {
                    return RewardController.a(objArr);
                }
            }).error(new MessageChannelPayload.Callback() { // from class: h9.b
                @Override // com.huawei.jmessage.api.MessageChannelPayload.Callback
                public final Object call(Object[] objArr) {
                    return RewardController.b(objArr);
                }
            }).notImplemented(new MessageChannelPayload.Callback() { // from class: h9.c
                @Override // com.huawei.jmessage.api.MessageChannelPayload.Callback
                public final Object call(Object[] objArr) {
                    return RewardController.c(objArr);
                }
            }).build();
            eVar.i("RewardController", "send Message change card Visibility!");
            ArrayList arrayList = new ArrayList();
            arrayList.add("//com.huawei.appgallery.agd.rewardcontrlheadcard");
            arrayList.add("//com.huawei.appgallery.agd.rewardsinglecard");
            arrayList.add("//com.huawei.appgallery.agd.rewardadendcard");
            Iterator<E> iterator2 = arrayList.iterator2();
            while (iterator2.hasNext()) {
                this.f27272r.publish(MessageChannelSource.TOPIC, build, new CellFinder(cardEventInfo.flCell).findByXPath((String) iterator2.next()));
            }
            return;
        }
        e.f48945d.i("RewardController", "goToLandingPage with page has been closed");
    }

    public static /* synthetic */ Object b(Object[] objArr) throws RemoteException {
        e.f48945d.i("RewardController", "error");
        return null;
    }

    public static /* synthetic */ Object a(Object[] objArr) throws RemoteException {
        e.f48945d.i("RewardController", "success");
        return null;
    }
}
