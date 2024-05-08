package jd;

import android.os.Handler;
import android.os.Looper;
import com.tanx.exposer.achieve.AdMonitorType;
import rc.f;

/* compiled from: AdMonitorCallback.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements sc.a {

    /* renamed from: a, reason: collision with root package name */
    public sc.a f50560a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f50561b;

    /* compiled from: AdMonitorCallback.java */
    /* renamed from: jd.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class RunnableC0768a implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f50562b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AdMonitorType f50563c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f f50564d;

        public RunnableC0768a(String str, AdMonitorType adMonitorType, f fVar) {
            this.f50562b = str;
            this.f50563c = adMonitorType;
            this.f50564d = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sc.a aVar = a.this.f50560a;
            if (aVar != null) {
                aVar.tanxc_do(this.f50562b, this.f50563c, this.f50564d);
            }
        }
    }

    /* compiled from: AdMonitorCallback.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class b implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f50566b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f50567c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f50568d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AdMonitorType f50569e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f50570f;

        public b(int i10, String str, String str2, AdMonitorType adMonitorType, f fVar) {
            this.f50566b = i10;
            this.f50567c = str;
            this.f50568d = str2;
            this.f50569e = adMonitorType;
            this.f50570f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sc.a aVar = a.this.f50560a;
            if (aVar != null) {
                aVar.tanxc_do(this.f50566b, this.f50567c, this.f50568d, this.f50569e, this.f50570f);
            }
        }
    }

    /* compiled from: AdMonitorCallback.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public class c implements Runnable {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f50572b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f50573c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f50574d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ AdMonitorType f50575e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ f f50576f;

        public c(int i10, String str, String str2, AdMonitorType adMonitorType, f fVar) {
            this.f50572b = i10;
            this.f50573c = str;
            this.f50574d = str2;
            this.f50575e = adMonitorType;
            this.f50576f = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            sc.a aVar = a.this.f50560a;
            if (aVar != null) {
                aVar.tanxc_if(this.f50572b, this.f50573c, this.f50574d, this.f50575e, this.f50576f);
            }
        }
    }

    public final synchronized Handler a() {
        if (this.f50561b == null) {
            this.f50561b = new Handler(tanxc_do());
        }
        return this.f50561b;
    }

    @Override // sc.a
    public Looper tanxc_do() {
        sc.a aVar = this.f50560a;
        if (aVar != null && aVar.tanxc_do() != null) {
            return this.f50560a.tanxc_do();
        }
        return Looper.myLooper();
    }

    @Override // sc.a
    public void tanxc_if(int i10, String str, String str2, AdMonitorType adMonitorType, f fVar) {
        if (this.f50560a != null) {
            a().post(new c(i10, str, str2, adMonitorType, fVar));
        }
    }

    @Override // sc.a
    public void tanxc_do(int i10, String str, String str2, AdMonitorType adMonitorType, f fVar) {
        if (this.f50560a != null) {
            a().post(new b(i10, str, str2, adMonitorType, fVar));
        }
    }

    @Override // sc.a
    public void tanxc_do(String str, AdMonitorType adMonitorType, f fVar) {
        if (this.f50560a != null) {
            a().post(new RunnableC0768a(str, adMonitorType, fVar));
        }
    }
}
