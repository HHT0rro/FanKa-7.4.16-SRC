package m9;

import android.text.TextUtils;
import com.huawei.appgallery.agd.common.FlavorApi;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.support.api.entity.safetydetect.RiskTokenResponse;
import com.huawei.hms.support.api.safetydetect.SafetyDetect;
import com.huawei.hms.support.api.safetydetect.SafetyDetectClient;
import com.huawei.hms.support.api.safetydetect.SafetyDetectStatusCodes;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class g {

    /* renamed from: b, reason: collision with root package name */
    public static volatile SafetyDetectClient f51953b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile String f51954c;

    /* renamed from: d, reason: collision with root package name */
    public static volatile boolean f51955d;

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f51956e;

    /* renamed from: f, reason: collision with root package name */
    public static volatile long f51957f;

    /* renamed from: h, reason: collision with root package name */
    public static TimerTask f51959h;

    /* renamed from: a, reason: collision with root package name */
    public static final Object f51952a = new Object();

    /* renamed from: g, reason: collision with root package name */
    public static Timer f51958g = new Timer();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class b implements OnSuccessListener<RiskTokenResponse>, OnFailureListener {

        /* renamed from: a, reason: collision with root package name */
        public c f51960a;

        @Override // com.huawei.hmf.tasks.OnSuccessListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(RiskTokenResponse riskTokenResponse) {
            synchronized (g.f51952a) {
                if (riskTokenResponse == null) {
                    n9.a.f52175d.e("RiskTokenHelper", "riskTokenResponse == null");
                    g.j(this.f51960a, -3, null);
                    return;
                }
                long unused = g.f51957f = System.currentTimeMillis();
                n9.a.f52175d.i("RiskTokenHelper", "get risk token result from hms success, refresh timeStamp:" + g.f51957f);
                g.j(this.f51960a, 0, riskTokenResponse.getRiskToken());
            }
        }

        @Override // com.huawei.hmf.tasks.OnFailureListener
        public void onFailure(Exception exc) {
            synchronized (g.f51952a) {
                String message = exc.getMessage();
                if (exc instanceof ApiException) {
                    message = SafetyDetectStatusCodes.getStatusCodeString(((ApiException) exc).getStatusCode()) + ": " + message;
                }
                n9.a.f52175d.e("RiskTokenHelper", "Get riskToken failed. Error info: " + message);
                SafetyDetectClient unused = g.f51953b = null;
                boolean unused2 = g.f51955d = false;
                long unused3 = g.f51957f = System.currentTimeMillis();
                String riskToken = FlavorApi.getConfig().getRiskToken();
                if (!TextUtils.isEmpty(riskToken)) {
                    String unused4 = g.f51954c = riskToken;
                }
                g.j(this.f51960a, -3, g.f51954c);
            }
        }

        public b(c cVar) {
            this.f51960a = cVar;
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public interface c {
        void a(int i10, String str);
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class d extends TimerTask {

        /* renamed from: b, reason: collision with root package name */
        public c f51961b;

        public d(c cVar) {
            this.f51961b = cVar;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            n9.a aVar = n9.a.f52175d;
            aVar.i("RiskTokenHelper", "Run riskToken timer task");
            if (g.p()) {
                g.i(this.f51961b);
            } else {
                g.t();
                aVar.i("RiskTokenHelper", "RiskToken timer task interrupted, pre-check failed");
            }
        }
    }

    public static void i(c cVar) {
        synchronized (f51952a) {
            n9.a aVar = n9.a.f52175d;
            aVar.i("RiskTokenHelper", "get RiskToken from Hms");
            if (!w()) {
                aVar.e("RiskTokenHelper", "init client failed");
                j(cVar, -2, null);
            } else if (f51953b == null) {
                aVar.e("RiskTokenHelper", "get RiskToken From Hms failed, client == null");
                j(cVar, -2, null);
            } else {
                b bVar = new b(cVar);
                f51953b.getRiskToken().addOnSuccessListener(bVar).addOnFailureListener(bVar);
            }
        }
    }

    public static void j(c cVar, int i10, String str) {
        n(str);
        if (cVar != null) {
            cVar.a(i10, str);
            n9.a.f52175d.i("RiskTokenHelper", "onResult: rtnCode is " + i10);
        }
    }

    public static boolean k(long j10) {
        return System.currentTimeMillis() - j10 > 1500000;
    }

    public static boolean l(String str) {
        synchronized (f51952a) {
            n9.a aVar = n9.a.f52175d;
            aVar.i("RiskTokenHelper", "initAntiFraud, packageName:" + str);
            if (f51953b == null) {
                aVar.e("RiskTokenHelper", "initAntiFraud failed, client == null");
                f51955d = false;
                return false;
            }
            f51953b.initAntiFraud(str);
            f51955d = true;
            return true;
        }
    }

    public static void n(String str) {
        synchronized (f51952a) {
            f51954c = str;
        }
    }

    public static void o(c cVar) {
        synchronized (f51952a) {
            if (!f51956e) {
                s(cVar);
                return;
            }
            n9.a aVar = n9.a.f52175d;
            aVar.i("RiskTokenHelper", "Get riskToken for callback");
            if (!q(cVar)) {
                aVar.i("RiskTokenHelper", "getRiskToken for callback failed, pre-checked failed");
                v();
                return;
            }
            if (k(f51957f)) {
                v();
            }
            if (!TextUtils.isEmpty(f51954c)) {
                j(cVar, 0, f51954c);
            } else {
                i(cVar);
            }
        }
    }

    public static /* synthetic */ boolean p() {
        return x();
    }

    public static boolean q(c cVar) {
        if (f.a(ApplicationWrapper.getInstance().getContext(), 40002301)) {
            return true;
        }
        n9.a.f52175d.i("RiskTokenHelper", "hms version invalid");
        j(cVar, -4, null);
        return false;
    }

    public static void s(c cVar) {
        synchronized (f51952a) {
            t();
            u(cVar);
        }
    }

    public static void t() {
        try {
            Timer timer = f51958g;
            if (timer != null) {
                timer.cancel();
            }
            TimerTask timerTask = f51959h;
            if (timerTask != null) {
                timerTask.cancel();
            }
        } catch (RuntimeException e2) {
            n9.a.f52175d.e("RiskTokenHelper", "cancelTimer:" + e2.getMessage());
        }
    }

    public static void u(c cVar) {
        try {
            try {
                f51958g = new Timer();
                d dVar = new d(cVar);
                f51959h = dVar;
                f51958g.schedule(dVar, 0L, 1500000L);
            } catch (RuntimeException e2) {
                n9.a.f52175d.e("RiskTokenHelper", "scheduleTask:" + e2.getMessage());
            }
        } finally {
            f51956e = true;
        }
    }

    public static void v() {
        synchronized (f51952a) {
            n9.a.f52175d.i("RiskTokenHelper", "clear riskToken");
            n(null);
            f51957f = 0L;
        }
    }

    public static boolean w() {
        synchronized (f51952a) {
            if (f51953b == null) {
                f51953b = SafetyDetect.getClient(ApplicationWrapper.getInstance().getContext());
                f51955d = false;
            }
            if (f51955d) {
                return true;
            }
            String packageName = ApplicationWrapper.getInstance().getContext().getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                n9.a.f52175d.e("RiskTokenHelper", "initAntiFraud failed, packageName is empty.");
                return false;
            }
            return l(packageName);
        }
    }

    public static boolean x() {
        return q(null);
    }
}
