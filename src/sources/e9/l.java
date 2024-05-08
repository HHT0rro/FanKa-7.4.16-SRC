package e9;

import android.app.Activity;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import com.alimm.tanx.core.utils.LandingPageUtHelper;
import com.huawei.appgallery.agd.agdpro.api.AdsContext;
import com.huawei.appgallery.agd.agdpro.api.ITemplateAd;
import com.huawei.appgallery.agd.agdpro.api.InteractionListener;
import com.huawei.appgallery.agd.agdpro.api.SplashInteractionListener;
import com.huawei.appgallery.agd.agdpro.impl.TemplateView;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.common.utils.FileUtil;
import com.huawei.appgallery.agd.core.api.AdSlot;
import com.huawei.appgallery.agd.core.impl.AgdAdManager;
import com.huawei.appgallery.agd.core.impl.report.MaintBi;
import com.huawei.appgallery.agd.core.impl.report.MaintData;
import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import com.huawei.appgallery.agd.core.impl.report.OperationBi;
import com.huawei.appgallery.agd.pageframe.api.CardEventInfo;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.appgallery.agd.pageframe.carddata.BaseDataKeys;
import com.huawei.appgallery.agd.serverreq.utils.network.NetworkUtil;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.data.FLDataSource;
import com.huawei.flexiblelayout.parser.FLDataParser;
import com.huawei.flexiblelayout.parser.FLDataStream;
import com.huawei.flexiblelayout.parser.cardmanager.LocalCardProvider;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.qcardsupport.qcard.cardmanager.CloudCardProvider;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class l extends e9.b implements ITemplateAd {

    /* renamed from: d, reason: collision with root package name */
    public AdSlot f48970d;

    /* renamed from: e, reason: collision with root package name */
    public String f48971e;

    /* renamed from: h, reason: collision with root package name */
    public FLDataSource f48974h;

    /* renamed from: i, reason: collision with root package name */
    public JSONArray f48975i;

    /* renamed from: j, reason: collision with root package name */
    public AdsContext f48976j;

    /* renamed from: k, reason: collision with root package name */
    public final int f48977k;

    /* renamed from: l, reason: collision with root package name */
    public InteractionListener f48978l;

    /* renamed from: m, reason: collision with root package name */
    public Boolean f48979m = Boolean.TRUE;

    /* renamed from: n, reason: collision with root package name */
    public long f48980n = System.currentTimeMillis();

    /* renamed from: o, reason: collision with root package name */
    public List<String> f48981o = Collections.synchronizedList(new ArrayList());

    /* renamed from: g, reason: collision with root package name */
    public FLayout f48973g = null;

    /* renamed from: f, reason: collision with root package name */
    public TemplateView f48972f = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements OnSuccessListener<FLDataStream> {
        public a() {
        }

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        public void onSuccess(FLDataStream fLDataStream) {
            FLDataStream fLDataStream2 = fLDataStream;
            if (fLDataStream2 == null) {
                l.this.g(10001, "render is fail flDataStream is null");
                return;
            }
            if (fLDataStream2.getResult() == 0) {
                fLDataStream2.apply(l.this.f48974h);
                l lVar = l.this;
                if (lVar.f48978l == null) {
                    e.f48945d.e("TemplateAd", "interactionListener is null");
                    return;
                }
                lVar.f48978l.onRenderSuccess(lVar.f48972f, lVar.f48972f.getTemplateViewWidth(), lVar.f48972f.getTemplateViewHeight());
                MaintBi.report(new MaintData.Builder(MaintKey.EVENT_FLEX_LAYOUT_SUCCESS).setSlotId(lVar.f48970d.getSlotId()).setUniqueId(lVar.f48971e).build());
                OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_SUCCESS, lVar.f48970d.getSlotId());
                return;
            }
            StringBuilder b4 = e9.a.b("render is fail ");
            b4.append(fLDataStream2.getResult());
            l.this.g(10001, b4.toString());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TemplateView templateView = l.this.f48972f;
            if (templateView != null) {
                templateView.removeAllViews();
            }
            FLayout fLayout = l.this.f48973g;
            if (fLayout != null) {
                fLayout.destroy();
            }
            l lVar = l.this;
            lVar.f48978l = null;
            AgdAdManager.removeAd(lVar.f48971e);
            for (String str : l.this.f48981o) {
                if (!TextUtils.isEmpty(str)) {
                    FileUtil.deleteFile(new File(str));
                }
            }
            MaintBi.reportAdClose(l.this.f48970d.getSlotId(), l.this.f48971e, "");
            OperationBi.reportAdCallBackOperate("close", l.this.f48970d.getSlotId());
            e.f48945d.i("TemplateAd", "destroy success");
        }
    }

    public l(@NonNull AdSlot adSlot, @NonNull JSONArray jSONArray, @NonNull AdsContext adsContext, @NonNull int i10) {
        this.f48975i = jSONArray;
        this.f48970d = adSlot;
        this.f48971e = t.b(adSlot.getSlotId());
        this.f48976j = adsContext;
        this.f48977k = i10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(Exception exc) {
        StringBuilder b4 = e9.a.b("render is fail ");
        b4.append(exc.getMessage());
        g(10001, b4.toString());
    }

    @Override // e9.b
    public long c() {
        return this.f48980n;
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.ITemplateAd
    public void destroy() {
        e eVar = e.f48945d;
        StringBuilder b4 = e9.a.b(LandingPageUtHelper.XAD_UT_LP_DESTROY);
        b4.append(this.f48971e);
        eVar.i("TemplateAd", b4.toString());
        if (n() == null) {
            eVar.e("TemplateAd", "destroy failed as activity is null");
        } else {
            n().runOnUiThread(new b());
        }
    }

    public final void g(int i10, String str) {
        String str2 = str + " " + this.f48971e;
        e eVar = e.f48945d;
        eVar.e("TemplateAd", str2);
        MaintBi.report(new MaintData.Builder(MaintKey.EVENT_AD_LOAD_FAIL).setSlotId(this.f48970d.getSlotId()).setUniqueId(this.f48971e).setErrorCode(i10).setMsg(str).build());
        OperationBi.reportAdCallBackOperate(OperationBi.ACTION_AD_SHOW_FAILURE, this.f48970d.getSlotId());
        this.f48979m = Boolean.TRUE;
        InteractionListener interactionListener = this.f48978l;
        if (interactionListener == null) {
            eVar.e("TemplateAd", "interactionListener is null");
        } else {
            interactionListener.onRenderFail(this.f48972f, i10, str2);
        }
    }

    @Override // com.huawei.appgallery.agd.core.impl.IAgdAd
    public AdSlot getAdSlot() {
        return this.f48970d;
    }

    @Override // com.huawei.appgallery.agd.core.impl.IAgdAd
    public String getUniqueId() {
        return this.f48971e;
    }

    public final void h(Activity activity) {
        FLEngine fLEngine = FLEngine.getInstance(activity);
        FLDataParser.builder(fLEngine).setDataKeys(new BaseDataKeys()).addCardProvider(LocalCardProvider.getInstance(fLEngine)).addCardProvider(CloudCardProvider.getInstance(fLEngine)).setDataDelegate(new g(this)).build().parse(this.f48975i).addOnSuccessListener(new a()).addOnFailureListener(new OnFailureListener() { // from class: e9.j
            @Override // com.huawei.hmf.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                l.this.k(exc);
            }
        });
    }

    public void i(@NonNull CardEventInfo cardEventInfo) {
        e eVar = e.f48945d;
        StringBuilder b4 = e9.a.b("dispatchCardEvent type: ");
        b4.append(cardEventInfo.type);
        b4.append(", info: ");
        b4.append((Object) cardEventInfo);
        eVar.i("TemplateAd", b4.toString());
        String str = cardEventInfo.type;
        str.hashCode();
        char c4 = 65535;
        switch (str.hashCode()) {
            case -1313942207:
                if (str.equals(CardEventType.ACTION_TIME_OUT)) {
                    c4 = 0;
                    break;
                }
                break;
            case -1273977221:
                if (str.equals("openFastApp")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1263202134:
                if (str.equals("openWeb")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1177422000:
                if (str.equals("openDeeplink")) {
                    c4 = 3;
                    break;
                }
                break;
            case -934426579:
                if (str.equals("resume")) {
                    c4 = 4;
                    break;
                }
                break;
            case 3357525:
                if (str.equals(CardEventType.CLICK_ACTION_MORE)) {
                    c4 = 5;
                    break;
                }
                break;
            case 3532159:
                if (str.equals("skip")) {
                    c4 = 6;
                    break;
                }
                break;
            case 94756344:
                if (str.equals("close")) {
                    c4 = 7;
                    break;
                }
                break;
            case 106440182:
                if (str.equals("pause")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 187958017:
                if (str.equals("openNative")) {
                    c4 = '\t';
                    break;
                }
                break;
            case 884870824:
                if (str.equals("openAppDetail")) {
                    c4 = '\n';
                    break;
                }
                break;
            case 1957569947:
                if (str.equals("install")) {
                    c4 = 11;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                InteractionListener interactionListener = this.f48978l;
                if (interactionListener == null || !(interactionListener instanceof SplashInteractionListener)) {
                    return;
                }
                ((SplashInteractionListener) interactionListener).onAdTimeOver();
                return;
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case '\b':
            case '\t':
            case '\n':
            case 11:
                InteractionListener interactionListener2 = this.f48978l;
                if (interactionListener2 != null) {
                    interactionListener2.onAdClicked(this.f48972f);
                    return;
                }
                return;
            case 6:
                InteractionListener interactionListener3 = this.f48978l;
                if (interactionListener3 == null || !(interactionListener3 instanceof SplashInteractionListener)) {
                    return;
                }
                ((SplashInteractionListener) interactionListener3).onAdSkip();
                return;
            case 7:
                destroy();
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public final void m(@NonNull Activity activity) {
        if (this.f48973g == null) {
            this.f48973g = new FLayout(FLEngine.getInstance(ApplicationWrapper.getInstance().getContext()));
        }
        if (activity instanceof LifecycleOwner) {
            this.f48973g.enableAutoManage((LifecycleOwner) activity);
        }
        if (this.f48972f == null) {
            this.f48972f = new TemplateView(activity, this.f48970d, this);
        }
        e eVar = e.f48945d;
        StringBuilder b4 = e9.a.b("mLoadAdType is ");
        b4.append(this.f48977k);
        eVar.i("TemplateAd", b4.toString());
        this.f48972f.removeAllViews();
        this.f48973g.bind(FLayout.viewGroup(this.f48972f));
        this.f48973g.registerLayoutDelegate(new h());
        FLDataSource fLDataSource = new FLDataSource();
        this.f48974h = fLDataSource;
        this.f48973g.setDataSource(fLDataSource);
        h(activity);
    }

    public final Activity n() {
        if (this.f48976j.getActivity() == null) {
            e.f48945d.e("TemplateAd", "getContextRef is null");
            return null;
        }
        return this.f48976j.getActivity();
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.ITemplateAd
    @MainThread
    public void render() {
        e eVar = e.f48945d;
        StringBuilder b4 = e9.a.b("render ");
        b4.append(this.f48971e);
        eVar.i("TemplateAd", b4.toString());
        final Activity n10 = n();
        if (n10 != null && !n10.isFinishing()) {
            if (!NetworkUtil.hasActiveNetwork(ApplicationWrapper.getInstance().getContext())) {
                eVar.e("TemplateAd", "render error network unavailable!");
                g(2, "render error network unavailable!");
                return;
            } else {
                if (!this.f48979m.booleanValue()) {
                    eVar.i("TemplateAd", "rendering or render success before");
                    return;
                }
                this.f48979m = Boolean.FALSE;
                if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                    m(n10);
                    return;
                } else {
                    n10.runOnUiThread(new Runnable() { // from class: e9.k
                        @Override // java.lang.Runnable
                        public final void run() {
                            l.this.m(n10);
                        }
                    });
                    return;
                }
            }
        }
        eVar.e("TemplateAd", "render error context is wrong");
        g(10003, "render error context is wrong");
    }

    @Override // com.huawei.appgallery.agd.agdpro.api.ITemplateAd
    public void setInteractionListener(InteractionListener interactionListener) {
        this.f48978l = interactionListener;
        e.f48945d.i("TemplateAd", "setInteractionListener success");
    }
}
