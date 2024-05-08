package com.huawei.flexiblelayout.card;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import com.huawei.flexiblelayout.FLContext;
import com.huawei.flexiblelayout.FLEngine;
import com.huawei.flexiblelayout.card.interation.CellFinder;
import com.huawei.flexiblelayout.data.FLDataGroup;
import com.huawei.flexiblelayout.data.IndicatorCardData;
import com.huawei.flexiblelayout.data.primitive.FLMap;
import com.huawei.flexiblelayout.json.Jsons;
import com.huawei.flexiblelayout.services.exposure.NonExposureTarget;
import com.huawei.hmf.md.spec.jmessage;
import com.huawei.hmf.repository.ComponentRepository;
import com.huawei.hwwidgetsupport.api.HwWidgetService;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventQueue;
import com.huawei.jmessage.api.MessageChannelPayload;
import com.huawei.jmessage.sources.LifecycleSource;
import com.huawei.jmessage.sources.MessageChannelSource;
import com.huawei.pnodesupport.api.FLPNodeDelegate;
import com.huawei.pnodesupport.api.FLPNodeService;
import com.huawei.uikit.hwdotspageindicator.widget.HwDotsPageIndicator;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.util.Objects;

@NonExposureTarget
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class IndicatorCard extends FLCard<IndicatorCardData> {

    /* renamed from: e, reason: collision with root package name */
    public static final String f27793e = "indicatorcard";

    /* renamed from: f, reason: collision with root package name */
    public static final String f27794f = "indicatorCard";

    /* renamed from: g, reason: collision with root package name */
    private static final String f27795g = "interval";

    /* renamed from: h, reason: collision with root package name */
    public static final String f27796h = "bind";

    /* renamed from: i, reason: collision with root package name */
    public static final String f27797i = "newConfig";

    /* renamed from: j, reason: collision with root package name */
    public static final String f27798j = "requestStart";

    /* renamed from: k, reason: collision with root package name */
    public static final String f27799k = "requestStop";

    /* renamed from: l, reason: collision with root package name */
    public static final String f27800l = "setInterval";

    /* renamed from: a, reason: collision with root package name */
    private HwDotsPageIndicator f27801a;

    /* renamed from: b, reason: collision with root package name */
    private HwViewPager f27802b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f27803c = false;

    /* renamed from: d, reason: collision with root package name */
    private int f27804d = 0;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements EventCallback {
        public a() {
        }

        @Override // com.huawei.jmessage.api.EventCallback
        public void call(EventCallback.Message message) {
            MessageChannelSource.Payload payload;
            if (message == null || (payload = (MessageChannelSource.Payload) message.getPayload(MessageChannelSource.Payload.class)) == null) {
                return;
            }
            String method = payload.getMethod();
            method.hashCode();
            char c4 = 65535;
            switch (method.hashCode()) {
                case -1735228601:
                    if (method.equals(IndicatorCard.f27800l)) {
                        c4 = 0;
                        break;
                    }
                    break;
                case -1058512638:
                    if (method.equals(IndicatorCard.f27797i)) {
                        c4 = 1;
                        break;
                    }
                    break;
                case 3023933:
                    if (method.equals("bind")) {
                        c4 = 2;
                        break;
                    }
                    break;
                case 1150062385:
                    if (method.equals(IndicatorCard.f27799k)) {
                        c4 = 3;
                        break;
                    }
                    break;
                case 1292182291:
                    if (method.equals(IndicatorCard.f27798j)) {
                        c4 = 4;
                        break;
                    }
                    break;
            }
            switch (c4) {
                case 0:
                    IndicatorCardData data = IndicatorCard.this.getData();
                    if (data != null) {
                        data.a((Integer) payload.getArgument("interval", Integer.class));
                        IndicatorCard.this.e();
                        payload.onSuccess(new Object[0]);
                        return;
                    }
                    payload.onError(new Object[0]);
                    return;
                case 1:
                    com.huawei.pnodesupport.impl.b bVar = (com.huawei.pnodesupport.impl.b) payload.getArgument(FLPNode.KEY_CONFIG, com.huawei.pnodesupport.impl.b.class);
                    if (bVar != null) {
                        IndicatorCard.this.a(bVar);
                        payload.onSuccess(new Object[0]);
                        return;
                    } else {
                        payload.onError(new Object[0]);
                        return;
                    }
                case 2:
                    HwViewPager hwViewPager = (HwViewPager) payload.getArgument(FLPNode.KEY_VIEW_PAGER, HwViewPager.class);
                    com.huawei.pnodesupport.impl.b bVar2 = (com.huawei.pnodesupport.impl.b) payload.getArgument(FLPNode.KEY_CONFIG, com.huawei.pnodesupport.impl.b.class);
                    if (hwViewPager != null && bVar2 != null) {
                        IndicatorCard.this.a(hwViewPager, bVar2);
                        payload.onSuccess(new Object[0]);
                        return;
                    } else {
                        payload.onError(new Object[0]);
                        return;
                    }
                case 3:
                    IndicatorCard.this.d();
                    payload.onSuccess(new Object[0]);
                    return;
                case 4:
                    IndicatorCard.this.e();
                    payload.onSuccess(new Object[0]);
                    return;
                default:
                    payload.onNotImplemented();
                    return;
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f27806a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f27806a = iArr;
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27806a[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f27806a[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void c() {
        if (this.f27804d != 0) {
            return;
        }
        this.f27804d = ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).subscribe(MessageChannelSource.TOPIC, this, new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        HwDotsPageIndicator hwDotsPageIndicator = this.f27801a;
        if (hwDotsPageIndicator == null || this.f27802b == null) {
            return;
        }
        hwDotsPageIndicator.stopAutoPlay();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Integer a10 = getData() != null ? getData().a() : null;
        if (Objects.equals(a10, 0)) {
            d();
        } else {
            a(a10);
        }
    }

    @Override // com.huawei.flexiblelayout.card.FLCard
    public View build(FLContext fLContext, ViewGroup viewGroup) {
        FLPNodeDelegate delegate = ((FLPNodeService) FLEngine.getInstance(fLContext.getContext()).getService(FLPNodeService.class)).getDelegate();
        if (delegate != null) {
            this.f27801a = delegate.createIndicator(fLContext);
        }
        if (this.f27801a == null) {
            HwDotsPageIndicator hwDotsPageIndicator = (HwDotsPageIndicator) ((HwWidgetService) FLEngine.getInstance(fLContext.getContext()).getService(HwWidgetService.class)).createWidget(HwDotsPageIndicator.class, fLContext.getContext());
            this.f27801a = hwDotsPageIndicator;
            hwDotsPageIndicator.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            this.f27801a.setImportantForAccessibility(2);
            this.f27801a.setClickable(false);
        }
        b();
        return this.f27801a;
    }

    @Override // com.huawei.flexiblelayout.card.FLCard
    public void setClickAction(FLContext fLContext) {
    }

    @Override // com.huawei.flexiblelayout.card.FLCell
    public void unbind(FLContext fLContext) {
        super.unbind(fLContext);
        if (this.f27804d != 0) {
            ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).unsubscribe(this.f27804d);
            this.f27804d = 0;
        }
    }

    private void b() {
        final EventQueue eventQueue = (EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq");
        eventQueue.subscribe(LifecycleSource.TOPIC, this.f27801a, new EventCallback() { // from class: com.huawei.flexiblelayout.card.k
            @Override // com.huawei.jmessage.api.EventCallback
            public final void call(EventCallback.Message message) {
                IndicatorCard.this.a(eventQueue, message);
            }
        });
    }

    @Override // com.huawei.flexiblelayout.card.FLCard
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void setData(FLContext fLContext, FLDataGroup fLDataGroup, IndicatorCardData indicatorCardData) {
        c();
        if (this.f27802b == null) {
            a();
        }
    }

    private void a() {
        FLCell<?> findByXPath = new CellFinder(this).findByXPath("//flpnode");
        if (findByXPath != null) {
            FLMap newJson = Jsons.newJson();
            newJson.put(f27794f, this);
            ((EventQueue) ComponentRepository.getRepository().lookup(jmessage.name).create(EventQueue.class, "mq")).publish(MessageChannelSource.TOPIC, new MessageChannelPayload.Builder("bind").args(newJson).build(), findByXPath);
        }
    }

    private void a(@Nullable Integer num) {
        HwViewPager hwViewPager;
        HwDotsPageIndicator hwDotsPageIndicator = this.f27801a;
        if (hwDotsPageIndicator != null && hwDotsPageIndicator.isAttachedToWindow() && (hwViewPager = this.f27802b) != null && hwViewPager.isSupportLoop() && this.f27803c) {
            if (num != null) {
                this.f27801a.startAutoPlay(num.intValue());
            } else {
                this.f27801a.startAutoPlay();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(EventQueue eventQueue, EventCallback.Message message) throws RemoteException {
        if (message != null) {
            Object obj = message.payload;
            if (obj instanceof LifecycleSource.LifecycleEvent) {
                int i10 = b.f27806a[((LifecycleSource.LifecycleEvent) obj).getEvent().ordinal()];
                if (i10 == 1) {
                    this.f27803c = true;
                    e();
                } else if (i10 == 2) {
                    this.f27803c = false;
                    d();
                } else {
                    if (i10 != 3) {
                        return;
                    }
                    eventQueue.unsubscribe(message.subscribeId);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HwViewPager hwViewPager, com.huawei.pnodesupport.impl.b bVar) {
        this.f27802b = hwViewPager;
        this.f27801a.setViewPager(hwViewPager);
        a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.huawei.pnodesupport.impl.b bVar) {
        HwViewPager hwViewPager = this.f27802b;
        boolean z10 = hwViewPager != null && hwViewPager.isSupportLoop();
        this.f27801a.setVisibility(z10 && bVar.a() == 1 && getData().isVisible() ? 0 : 4);
        if (z10) {
            e();
        } else {
            d();
        }
    }
}
