package com.cupidapp.live.base.utils;

import android.os.CountDownTimer;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;

/* compiled from: FKCountDownTimer.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public CountDownTimer f12321a;

    /* renamed from: b, reason: collision with root package name */
    public long f12322b;

    /* compiled from: FKCountDownTimer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class a extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<kotlin.p> f12323a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i f12324b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Integer f12325c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<Integer, kotlin.p> f12326d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public a(Function0<kotlin.p> function0, i iVar, Integer num, Function1<? super Integer, kotlin.p> function1, long j10, long j11) {
            super(j10, j11);
            this.f12323a = function0;
            this.f12324b = iVar;
            this.f12325c = num;
            this.f12326d = function1;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Function0<kotlin.p> function0 = this.f12323a;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            this.f12324b.b(this.f12325c.intValue() - (j10 / 1000));
            int i10 = (int) (j10 / 1000);
            j.f12332a.a("FKCountDownTimer", "millisUntilFinished: " + j10 + " tick: " + i10);
            Function1<Integer, kotlin.p> function1 = this.f12326d;
            if (function1 != null) {
                function1.invoke(Integer.valueOf(i10));
            }
        }
    }

    /* compiled from: FKCountDownTimer.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public static final class b extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f12327a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f12328b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<kotlin.p> f12329c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<Long, kotlin.p> f12330d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public b(long j10, long j11, Function0<kotlin.p> function0, Function1<? super Long, kotlin.p> function1) {
            super(j10, j11);
            this.f12327a = j10;
            this.f12328b = j11;
            this.f12329c = function0;
            this.f12330d = function1;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            Function0<kotlin.p> function0 = this.f12329c;
            if (function0 != null) {
                function0.invoke();
            }
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j10) {
            Function1<Long, kotlin.p> function1;
            if (j10 <= this.f12327a - this.f12328b && (function1 = this.f12330d) != null) {
                function1.invoke(Long.valueOf(j10));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(i iVar, Integer num, int i10, Function0 function0, Function1 function1, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            function0 = null;
        }
        if ((i11 & 8) != 0) {
            function1 = null;
        }
        iVar.c(num, i10, function0, function1);
    }

    public final long a() {
        return this.f12322b;
    }

    public final void b(long j10) {
        this.f12322b = j10;
    }

    public final void c(@Nullable Integer num, int i10, @Nullable Function0<kotlin.p> function0, @Nullable Function1<? super Integer, kotlin.p> function1) {
        g();
        if (num != null) {
            num.intValue();
            this.f12321a = new a(function0, this, num, function1, num.intValue() * 1000, i10 * 1000).start();
        }
    }

    public final void e(long j10, long j11, @Nullable Function0<kotlin.p> function0, @Nullable Function1<? super Long, kotlin.p> function1) {
        g();
        this.f12321a = new b(j10, j11, function0, function1).start();
    }

    public final void g() {
        CountDownTimer countDownTimer = this.f12321a;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.f12321a = null;
    }
}
