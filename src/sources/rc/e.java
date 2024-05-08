package rc;

import android.content.Context;
import com.tanx.exposer.AdMonitorInitResult;
import com.tanx.exposer.achieve.AdMonitorCommitResult;
import com.tanx.exposer.achieve.AdMonitorType;
import id.b;
import java.util.List;
import kd.a;

/* compiled from: AdMonitorManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public rc.a f53378a;

    /* renamed from: b, reason: collision with root package name */
    public jd.a f53379b;

    /* renamed from: c, reason: collision with root package name */
    public Context f53380c;

    /* compiled from: AdMonitorManager.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public static volatile e f53381a = new e(0);
    }

    public /* synthetic */ e(byte b4) {
        this();
    }

    public AdMonitorInitResult a(Context context, rc.a aVar) {
        try {
            if (aVar == null) {
                b.d("adMonitorInitError", "params is null");
                return AdMonitorInitResult.PARAMS_ERROR;
            }
            this.f53380c = context.getApplicationContext();
            this.f53378a = aVar;
            this.f53379b = new jd.a();
            a.C0773a.f50879a.f50878a = aVar.j();
            id.b bVar = b.c.f49887a;
            bVar.f49877a = context;
            bVar.f49878b = this;
            if (f() != null) {
                bVar.f49884h = f().f();
            }
            ld.b.a(new id.d(bVar), 0L);
            ld.b.a(new id.c(bVar), 10000L);
            return AdMonitorInitResult.SUCCESS;
        } catch (Exception e2) {
            e2.printStackTrace();
            b.d("adMonitorInitError", e2.getMessage());
            return AdMonitorInitResult.INTERNAL_ERROR;
        }
    }

    public AdMonitorCommitResult b(List<String> list, f fVar) {
        AdMonitorType adMonitorType = AdMonitorType.EXPOSE;
        try {
            if (b.f53376a && fVar != null) {
                b.d("utArgs", fVar.toString());
            }
            if (list != null && !list.isEmpty()) {
                String str = adMonitorType == AdMonitorType.CLICK ? "tanx_click_invoke_success" : "tanx_expose_invoke_success";
                if (fVar == null) {
                    b.a(str, "AdMonitorExtraParams is null");
                } else {
                    ld.b.b(str, d.f(fVar), true);
                }
                return new hd.b(adMonitorType, list, fVar).a();
            }
            md.b.a(fVar, adMonitorType, "urls is empty");
            return AdMonitorCommitResult.PARAMS_ERROR;
        } catch (Exception e2) {
            e2.printStackTrace();
            md.b.a(fVar, adMonitorType, e2.getMessage());
            return AdMonitorCommitResult.INTERNAL_ERROR;
        }
    }

    public jd.a c() {
        return this.f53379b;
    }

    public void d(sc.a aVar) {
        jd.a aVar2 = this.f53379b;
        if (aVar2 != null) {
            aVar2.f50560a = aVar;
        }
    }

    public AdMonitorCommitResult e(List<String> list, f fVar) {
        AdMonitorType adMonitorType = AdMonitorType.CLICK;
        try {
            if (b.f53376a && fVar != null) {
                b.d("utArgs", fVar.toString());
            }
            if (list != null && !list.isEmpty()) {
                if (fVar == null) {
                    b.a("tanx_click_invoke_success", "AdMonitorExtraParams is null");
                } else {
                    ld.b.b("tanx_click_invoke_success", d.f(fVar), true);
                }
                if (adMonitorType == AdMonitorType.EXPOSE) {
                    return new hd.b(adMonitorType, list, fVar).a();
                }
                return new hd.a(adMonitorType, list, fVar).a();
            }
            md.b.a(fVar, adMonitorType, "urls is empty");
            return AdMonitorCommitResult.PARAMS_ERROR;
        } catch (Exception e2) {
            e2.printStackTrace();
            md.b.a(fVar, adMonitorType, e2.getMessage());
            return AdMonitorCommitResult.INTERNAL_ERROR;
        }
    }

    public rc.a f() {
        return this.f53378a;
    }

    public Context g() {
        return this.f53380c;
    }

    public e() {
    }
}
