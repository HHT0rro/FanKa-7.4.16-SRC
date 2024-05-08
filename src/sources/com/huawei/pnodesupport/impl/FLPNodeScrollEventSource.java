package com.huawei.pnodesupport.impl;

import androidx.annotation.NonNull;
import com.huawei.flexiblelayout.card.FLPNode;
import com.huawei.jmessage.api.EventCallback;
import com.huawei.jmessage.api.EventSource;
import com.huawei.jmessage.api.Subscriber;
import com.huawei.uikit.hwviewpager.widget.HwPagerAdapter;
import com.huawei.uikit.hwviewpager.widget.HwViewPager;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class FLPNodeScrollEventSource extends EventSource {

    /* renamed from: b, reason: collision with root package name */
    public static final String f33066b = "FLPNodeScroll";

    /* renamed from: c, reason: collision with root package name */
    private static final String f33067c = "FLPNodeScrollEventSource";

    /* renamed from: a, reason: collision with root package name */
    private final Map<HwViewPager, a> f33068a = new HashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class PNodeScrollEvent {

        /* renamed from: a, reason: collision with root package name */
        private FLPNode f33069a;

        /* renamed from: b, reason: collision with root package name */
        private int f33070b;

        /* renamed from: c, reason: collision with root package name */
        private int f33071c;

        /* renamed from: d, reason: collision with root package name */
        private float f33072d;

        public int getFrom() {
            return this.f33070b;
        }

        public FLPNode getNode() {
            return this.f33069a;
        }

        public float getProgress() {
            return this.f33072d;
        }

        public int getTo() {
            return this.f33071c;
        }

        public void setFrom(int i10) {
            this.f33070b = i10;
        }

        public void setNode(FLPNode fLPNode) {
            this.f33069a = fLPNode;
        }

        public void setProgress(float f10) {
            this.f33072d = f10;
        }

        public void setTo(int i10) {
            this.f33071c = i10;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends HwViewPager.SimpleOnPageChangeListener {

        /* renamed from: a, reason: collision with root package name */
        private final FLPNode f33073a;

        public a(FLPNode fLPNode) {
            this.f33073a = fLPNode;
        }

        private void a(int i10, int i11, float f10) {
            if (i10 != i11) {
                f10 = 1.0f;
            }
            PNodeScrollEvent pNodeScrollEvent = new PNodeScrollEvent();
            pNodeScrollEvent.setNode(this.f33073a);
            pNodeScrollEvent.setFrom(i10);
            pNodeScrollEvent.setTo(i11);
            pNodeScrollEvent.setProgress(f10);
            FLPNodeScrollEventSource.this.fire(pNodeScrollEvent);
        }

        private void b(int i10, int i11, float f10) {
            float f11 = Math.abs(i10 - i11) <= 1 ? 1.0f - f10 : 1.0f;
            PNodeScrollEvent pNodeScrollEvent = new PNodeScrollEvent();
            pNodeScrollEvent.setNode(this.f33073a);
            pNodeScrollEvent.setFrom(i10);
            pNodeScrollEvent.setTo(i11);
            pNodeScrollEvent.setProgress(f11);
            FLPNodeScrollEventSource.this.fire(pNodeScrollEvent);
        }

        @Override // com.huawei.uikit.hwviewpager.widget.HwViewPager.SimpleOnPageChangeListener, com.huawei.uikit.hwviewpager.widget.HwViewPager.OnPageChangeListener
        public void onPageScrolled(int i10, float f10, int i11) {
            HwPagerAdapter adapter = this.f33073a.getViewPager().getAdapter();
            if (adapter == null) {
                return;
            }
            int currentItem = this.f33073a.getViewPager().getCurrentItem();
            if (i10 == currentItem) {
                a(currentItem, i10, f10);
                return;
            }
            if (i10 < currentItem) {
                int count = adapter.getCount() + i10;
                if (count - currentItem < currentItem - i10) {
                    a(currentItem, count, f10);
                    return;
                } else {
                    b(currentItem, i10, f10);
                    return;
                }
            }
            int count2 = i10 - adapter.getCount();
            if (currentItem - count2 < i10 - currentItem) {
                b(currentItem, count2, f10);
            } else {
                a(currentItem, i10, f10);
            }
        }
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onDispatch(@NonNull Subscriber subscriber, @NonNull EventCallback.Message message) {
        Object obj = message.payload;
        Object param = subscriber.getParam();
        return (param instanceof FLPNode) && (obj instanceof PNodeScrollEvent) && ((FLPNode) param) == ((PNodeScrollEvent) obj).getNode();
    }

    @Override // com.huawei.jmessage.api.EventSource
    public void onRelease() {
        for (Map.Entry<HwViewPager, a> entry : this.f33068a.entrySet()) {
            entry.getKey().removeOnPageChangeListener(entry.getValue());
        }
        this.f33068a.clear();
    }

    @Override // com.huawei.jmessage.api.EventSource
    public boolean onSubscribe(@NonNull Subscriber subscriber) {
        FLPNode fLPNode;
        HwViewPager viewPager;
        Object param = subscriber.getParam();
        if ((param instanceof FLPNode) && (viewPager = (fLPNode = (FLPNode) param).getViewPager()) != null && !this.f33068a.containsKey(viewPager)) {
            a aVar = new a(fLPNode);
            fLPNode.getViewPager().addOnPageChangeListener(aVar);
            this.f33068a.put(viewPager, aVar);
        }
        return true;
    }
}
