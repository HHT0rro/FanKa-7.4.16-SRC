package com.huawei.flexiblelayout.services.exposure.impl;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseLongArray;
import android.view.View;
import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.FLayout;
import com.huawei.flexiblelayout.card.FLCell;
import com.huawei.flexiblelayout.data.FLCardData;
import com.huawei.flexiblelayout.k1;
import com.huawei.flexiblelayout.log.Log;
import com.huawei.flexiblelayout.services.exposure.CardExposureEvent;
import com.huawei.flexiblelayout.services.exposure.CardExposureService;
import com.huawei.flexiblelayout.services.exposure.ExposureParam;
import com.huawei.flexiblelayout.services.exposure.VisibleAreaCalculator;
import com.huawei.flexiblelayout.services.exposure.impl.AwaitViewLayout;
import com.huawei.flexiblelayout.services.exposure.impl.ExposureTaskBuilder;
import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObject;
import com.huawei.flexiblelayout.services.exposure.reusable.ReusableObjectPool;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CardExposureServiceImpl implements CardExposureService {

    /* renamed from: e, reason: collision with root package name */
    private static final Executor f28529e = Executors.newFixedThreadPool(1);

    /* renamed from: f, reason: collision with root package name */
    private static final String f28530f = "CardExposureServiceImpl";

    /* renamed from: a, reason: collision with root package name */
    private final Set<CardExposureService.CardExposureHandler> f28531a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    private final SparseLongArray f28532b = new SparseLongArray();

    /* renamed from: c, reason: collision with root package name */
    private final ExposureTaskBuilder f28533c;

    /* renamed from: d, reason: collision with root package name */
    private final Context f28534d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class EventObject implements CardExposureEvent, ReusableObject {

        /* renamed from: i, reason: collision with root package name */
        private static final int f28535i = -1;

        /* renamed from: a, reason: collision with root package name */
        private FLayout f28536a;

        /* renamed from: b, reason: collision with root package name */
        private FLCell<?> f28537b;

        /* renamed from: c, reason: collision with root package name */
        private View f28538c;

        /* renamed from: d, reason: collision with root package name */
        private FLCardData f28539d;

        /* renamed from: e, reason: collision with root package name */
        @ExposureEventType
        private int f28540e;

        /* renamed from: f, reason: collision with root package name */
        @ExposureParam.ExposureMode
        private String f28541f;

        /* renamed from: g, reason: collision with root package name */
        private int f28542g;

        /* renamed from: h, reason: collision with root package name */
        private long f28543h;

        @Override // com.huawei.flexiblelayout.services.exposure.CardExposureEvent
        @NonNull
        public FLCardData getData() {
            return this.f28539d;
        }

        @Override // com.huawei.flexiblelayout.services.exposure.CardExposureEvent
        public int getId() {
            return Objects.hash(this.f28536a, this.f28539d);
        }

        @Override // com.huawei.flexiblelayout.services.exposure.CardExposureEvent
        public int getPercent() {
            return this.f28542g;
        }

        @Override // com.huawei.flexiblelayout.services.exposure.CardExposureEvent
        public long getTimeStamp() {
            return this.f28543h;
        }

        @Override // com.huawei.flexiblelayout.services.exposure.CardExposureEvent
        public boolean isVisible() {
            return this.f28540e == 1;
        }

        @Override // com.huawei.flexiblelayout.services.exposure.reusable.ReusableObject
        public void reset() {
            a(null, null, null, null, 0, "default", -1, 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(FLayout fLayout, FLCell<?> fLCell, View view, FLCardData fLCardData, int i10, String str, int i11, long j10) {
            this.f28536a = fLayout;
            this.f28537b = fLCell;
            this.f28538c = view;
            this.f28539d = fLCardData;
            this.f28540e = i10;
            this.f28541f = str;
            this.f28542g = i11;
            this.f28543h = j10;
        }
    }

    public CardExposureServiceImpl(@NonNull Context context) {
        ExposureTaskBuilder exposureTaskBuilder = new ExposureTaskBuilder();
        this.f28533c = exposureTaskBuilder;
        this.f28534d = context.getApplicationContext();
        exposureTaskBuilder.addInterceptor(new RecyclerViewInterceptor()).addInterceptor(new ExposureContainerInterceptor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(FLayout fLayout, FLCell fLCell, View view, FLCardData fLCardData, int i10, String str, long j10) {
        try {
            EventObject eventObject = (EventObject) ReusableObjectPool.getInstance().acquire(EventObject.class);
            eventObject.a(fLayout, fLCell, view, fLCardData, i10, str, -1, j10);
            e(eventObject);
        } catch (Exception e2) {
            Log.w(f28530f, "notify event exception: ", e2);
            k1.f28184b.put("errorMessage", e2.getMessage()).build(this.f28534d).report();
        }
    }

    private void b(@NonNull EventObject eventObject) {
        if (f(eventObject)) {
            int a10 = a(eventObject);
            if (f(eventObject)) {
                if (TextUtils.equals(eventObject.f28541f, "custom")) {
                    eventObject.f28542g = a10;
                }
                if (a10 > 0) {
                    eventObject.f28540e = 1;
                } else {
                    eventObject.f28540e = 2;
                }
            }
        }
    }

    private void c(@NonNull EventObject eventObject) {
        if (this.f28532b.get(eventObject.getId()) == 0) {
            return;
        }
        this.f28532b.put(eventObject.getId(), 0L);
        Iterator<CardExposureService.CardExposureHandler> iterator2 = this.f28531a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onCardExposureEvent(eventObject);
        }
    }

    private void d(@NonNull EventObject eventObject) {
        if (this.f28532b.get(eventObject.getId()) == 0) {
            this.f28532b.put(eventObject.getId(), eventObject.f28543h);
        } else if (TextUtils.equals(eventObject.f28541f, "default")) {
            return;
        }
        Iterator<CardExposureService.CardExposureHandler> iterator2 = this.f28531a.iterator2();
        while (iterator2.hasNext()) {
            iterator2.next().onCardExposureEvent(eventObject);
        }
    }

    private void e(@NonNull EventObject eventObject) {
        if (eventObject.f28540e == 0) {
            b(eventObject);
        }
        if (eventObject.f28540e == 1) {
            d(eventObject);
        }
        if (eventObject.f28540e == 2) {
            c(eventObject);
        }
        ReusableObjectPool.getInstance().recycle(eventObject);
    }

    private boolean f(@NonNull EventObject eventObject) {
        return eventObject.f28537b.getData() == eventObject.f28539d && eventObject.f28538c.isAttachedToWindow();
    }

    @NonNull
    public ExposureTaskBuilder getExposureTaskBuilder() {
        return this.f28533c;
    }

    public void notify(@NonNull ExposureEvent exposureEvent) {
        final FLayout fLayout = exposureEvent.f28550a;
        final FLCell<?> fLCell = exposureEvent.f28551b;
        final View view = exposureEvent.f28552c;
        final FLCardData fLCardData = exposureEvent.f28553d;
        final int i10 = exposureEvent.f28554e;
        final String str = exposureEvent.f28555f;
        final long currentTimeMillis = System.currentTimeMillis();
        f28529e.execute(new Runnable() { // from class: com.huawei.flexiblelayout.services.exposure.impl.c
            @Override // java.lang.Runnable
            public final void run() {
                CardExposureServiceImpl.this.a(fLayout, fLCell, view, fLCardData, i10, str, currentTimeMillis);
            }
        });
    }

    @Override // com.huawei.flexiblelayout.services.exposure.CardExposureService
    public void registerHandler(@NonNull CardExposureService.CardExposureHandler cardExposureHandler) {
        this.f28531a.add(cardExposureHandler);
    }

    @Override // com.huawei.flexiblelayout.services.exposure.CardExposureService
    public void setup(@NonNull FLayout fLayout, @NonNull ExposureParam exposureParam) {
        if (ExposureTaskImpl.findTask(fLayout) != null) {
            Log.w(f28530f, "duplicated setup on view: " + ((Object) fLayout.getView()));
            return;
        }
        ExposureTaskImpl execute = this.f28533c.execute(new ExposureTaskBuilder.Param(fLayout, exposureParam));
        if (execute == null) {
            Log.w(f28530f, "start exposure failed");
        } else {
            ExposureTaskImpl.a(fLayout, execute);
        }
    }

    @Override // com.huawei.flexiblelayout.services.exposure.CardExposureService
    public void unregisterHandler(@NonNull CardExposureService.CardExposureHandler cardExposureHandler) {
        this.f28531a.remove(cardExposureHandler);
    }

    private int a(@NonNull EventObject eventObject) {
        final AtomicInteger atomicInteger = new AtomicInteger(0);
        ExposureTaskImpl findTask = ExposureTaskImpl.findTask(eventObject.f28536a);
        if (findTask == null) {
            return atomicInteger.get();
        }
        final VisibleAreaCalculator visibleAreaCalculator = findTask.getHelper().getParam().getVisibleAreaCalculator();
        AwaitViewLayout.a(eventObject.f28538c, new AwaitViewLayout.ViewPredicate() { // from class: com.huawei.flexiblelayout.services.exposure.impl.b
            @Override // com.huawei.flexiblelayout.services.exposure.impl.AwaitViewLayout.ViewPredicate
            public final boolean test(View view) {
                boolean a10;
                a10 = CardExposureServiceImpl.a(VisibleAreaCalculator.this, atomicInteger, view);
                return a10;
            }
        });
        return atomicInteger.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean a(VisibleAreaCalculator visibleAreaCalculator, AtomicInteger atomicInteger, View view) {
        int calculateVisiblePercents = visibleAreaCalculator.calculateVisiblePercents(view);
        atomicInteger.set(calculateVisiblePercents);
        return calculateVisiblePercents > 0;
    }
}
