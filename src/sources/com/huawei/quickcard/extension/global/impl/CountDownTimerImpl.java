package com.huawei.quickcard.extension.global.impl;

import androidx.annotation.NonNull;
import com.huawei.quickcard.CardContext;
import com.huawei.quickcard.Cleanable;
import com.huawei.quickcard.base.interfaces.CardDataObject;
import com.huawei.quickcard.base.log.CardLogUtils;
import com.huawei.quickcard.utils.QuickCardIntervalTimer;
import java.lang.ref.WeakReference;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class CountDownTimerImpl {

    /* renamed from: e, reason: collision with root package name */
    private static final String f33651e = "CountDownTimerImpl";

    /* renamed from: a, reason: collision with root package name */
    private final int f33652a;

    /* renamed from: b, reason: collision with root package name */
    private Cleanable f33653b;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<CardContext> f33654c;

    /* renamed from: d, reason: collision with root package name */
    private QuickCardIntervalTimer f33655d;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a extends QuickCardIntervalTimer {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ String f33656g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(long j10, String str) {
            super(j10);
            this.f33656g = str;
        }

        @Override // com.huawei.quickcard.utils.QuickCardIntervalTimer
        public void onTick() {
            try {
                CountDownTimerImpl.this.a(this.f33656g);
            } catch (Throwable unused) {
                CardLogUtils.e(CountDownTimerImpl.f33651e, "evaluate failed");
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class b extends QuickCardIntervalTimer {

        /* renamed from: g, reason: collision with root package name */
        public final /* synthetic */ CardDataObject f33658g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(long j10, CardDataObject cardDataObject) {
            super(j10);
            this.f33658g = cardDataObject;
        }

        @Override // com.huawei.quickcard.utils.QuickCardIntervalTimer
        public void onTick() {
            CardContext cardContext;
            if (CountDownTimerImpl.this.f33654c == null || (cardContext = (CardContext) CountDownTimerImpl.this.f33654c.get()) == null) {
                return;
            }
            cardContext.call(this.f33658g, new Object[0]);
        }
    }

    public CountDownTimerImpl(CardContext cardContext, int i10) {
        a(cardContext);
        this.f33652a = i10;
    }

    public void cancel() {
        QuickCardIntervalTimer quickCardIntervalTimer = this.f33655d;
        if (quickCardIntervalTimer != null) {
            quickCardIntervalTimer.cancel();
            this.f33655d = null;
        }
    }

    public int getId() {
        return this.f33652a;
    }

    public void start(String str, long j10, boolean z10) {
        QuickCardIntervalTimer quickCardIntervalTimer = this.f33655d;
        if (quickCardIntervalTimer != null) {
            quickCardIntervalTimer.cancel();
        }
        if (this.f33653b == null) {
            return;
        }
        a aVar = new a(j10, str);
        this.f33655d = aVar;
        aVar.start(z10);
    }

    private void a(CardContext cardContext) {
        if (cardContext == null) {
            return;
        }
        this.f33654c = new WeakReference<>(cardContext);
        Cleanable cleanable = new Cleanable() { // from class: com.huawei.quickcard.extension.global.impl.a
            @Override // com.huawei.quickcard.Cleanable
            public final void release() {
                CountDownTimerImpl.this.cancel();
            }
        };
        this.f33653b = cleanable;
        cardContext.addCleanQueue(cleanable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        CardContext cardContext;
        WeakReference<CardContext> weakReference = this.f33654c;
        if (weakReference == null || (cardContext = weakReference.get()) == null) {
            return;
        }
        cardContext.executeExpr(str);
    }

    public void start(@NonNull CardDataObject cardDataObject, long j10, boolean z10) {
        QuickCardIntervalTimer quickCardIntervalTimer = this.f33655d;
        if (quickCardIntervalTimer != null) {
            quickCardIntervalTimer.cancel();
        }
        if (this.f33653b == null) {
            return;
        }
        b bVar = new b(j10, cardDataObject);
        this.f33655d = bVar;
        bVar.start(z10);
    }
}
