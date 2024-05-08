package com.kwad.sdk.core.report;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.report.e;
import com.kwad.sdk.core.response.model.BaseResultData;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public abstract class b<T extends e, R extends com.kwad.sdk.core.network.f> {
    private static ExecutorService axn;
    private static volatile Handler fS;
    private T axq;
    private Context mContext;
    private volatile long Tc = 120000;
    public l axm = new m();
    private AtomicInteger axo = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int axp = 5;

    public b() {
        if (axn == null) {
            axn = GlobalThreadPools.FF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void EC() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.axp) {
            if (andIncrement > 0) {
                this.Tc *= 2;
            }
            aq(this.Tc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aq(long j10) {
        if (fS == null) {
            return;
        }
        fS.removeMessages(16843025);
        Message obtain = Message.obtain(fS, a(this.mContext, this.axm, this.axo));
        obtain.what = 16843025;
        fS.sendMessageDelayed(obtain, j10);
    }

    public final boolean EA() {
        int i10 = this.mRetryCount.get();
        if (i10 > 16) {
            i10 = 16;
        }
        s sVar = (s) ServiceProvider.get(s.class);
        return this.axm.size() >= (sVar != null ? (long) (sVar.ym() << i10) : 20L);
    }

    public final void EB() {
        aq(0L);
    }

    public final void ap(long j10) {
        if (j10 < 60) {
            this.Tc = 60000L;
        } else {
            this.Tc = j10 * 1000;
        }
    }

    public synchronized void i(Context context, int i10) {
        this.mContext = context;
        if (fS == null) {
            fS = com.kwad.sdk.core.threads.a.Fz();
        }
    }

    public abstract R w(List<T> list);

    private void c(@NonNull final k<T> kVar) {
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            @NonNull
            private static BatchReportResult en(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                e EF = kVar.EF();
                b.this.axq = EF;
                return (R) b.this.a((b) EF);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.axn;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return en(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            private void a(@NonNull BatchReportResult batchReportResult) {
                com.kwad.sdk.core.e.c.d("BaseBatchReporter", "立即上报 onSuccess action= " + ((Object) b.this.axq) + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(@NonNull R r10, int i10, String str) {
                com.kwad.sdk.core.e.c.e("BaseBatchReporter", "立即上报 onError errorCode:" + i10 + " errorMsg:" + str + "\naction=" + ((Object) b.this.axq));
                b.this.a((k) new k<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.k
                    @NonNull
                    public final T EF() {
                        return (T) b.this.axq;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(@NonNull k<T> kVar) {
        try {
            c(kVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(th);
        }
    }

    public final void a(l lVar) {
        this.axm = lVar;
    }

    public final void a(@NonNull final k<T> kVar) {
        axn.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.fS != null && !b.fS.hasMessages(16843025)) {
                    b bVar = b.this;
                    bVar.aq(bVar.Tc);
                }
                e EF = kVar.EF();
                if (EF != null) {
                    b.this.axm.j(EF);
                }
                if (b.this.EA()) {
                    b.this.EB();
                }
            }
        });
    }

    public Runnable a(Context context, l<T> lVar, AtomicInteger atomicInteger) {
        return new u(context, lVar, this, atomicInteger);
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.axo.getAndIncrement();
        new com.kwad.sdk.core.network.l<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            @NonNull
            private static BatchReportResult en(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            @NonNull
            public final R createRequest() {
                return (R) b.this.w(list);
            }

            @Override // com.kwad.sdk.core.network.l
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.axn;
            }

            @Override // com.kwad.sdk.core.network.l
            @NonNull
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return en(str);
            }
        }.request(new com.kwad.sdk.core.network.o<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            private void a(@NonNull BatchReportResult batchReportResult) {
                b.this.axm.x(list);
                if (b.this.axo.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.EC();
                }
                b.this.ap(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.aq(bVar.Tc);
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final void onError(@NonNull R r10, int i10, String str) {
                atomicBoolean.set(true);
                if (b.this.axo.decrementAndGet() == 0) {
                    b.this.EC();
                }
            }

            @Override // com.kwad.sdk.core.network.o, com.kwad.sdk.core.network.g
            public final /* synthetic */ void onSuccess(@NonNull com.kwad.sdk.core.network.f fVar, @NonNull BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public R a(T t2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t2);
        return w(arrayList);
    }
}
