package e0;

import android.content.Context;
import com.alipay.android.phone.mrpc.core.aa;
import com.alipay.android.phone.mrpc.core.h;
import com.alipay.android.phone.mrpc.core.w;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;
import com.irisdt.StatConfig;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class b implements a {

    /* renamed from: d, reason: collision with root package name */
    public static b f48852d;

    /* renamed from: e, reason: collision with root package name */
    public static DataReportResult f48853e;

    /* renamed from: a, reason: collision with root package name */
    public w f48854a;

    /* renamed from: b, reason: collision with root package name */
    public com.alipay.tscenter.biz.rpc.a.a f48855b;

    /* renamed from: c, reason: collision with root package name */
    public com.alipay.tscenter.biz.rpc.report.general.a f48856c;

    public b(Context context, String str) {
        this.f48854a = null;
        this.f48855b = null;
        this.f48856c = null;
        aa aaVar = new aa();
        aaVar.a(str);
        h hVar = new h(context);
        this.f48854a = hVar;
        this.f48855b = (com.alipay.tscenter.biz.rpc.a.a) hVar.a(com.alipay.tscenter.biz.rpc.a.a.class, aaVar);
        this.f48856c = (com.alipay.tscenter.biz.rpc.report.general.a) this.f48854a.a(com.alipay.tscenter.biz.rpc.report.general.a.class, aaVar);
    }

    public static synchronized b e(Context context, String str) {
        b bVar;
        synchronized (b.class) {
            if (f48852d == null) {
                f48852d = new b(context, str);
            }
            bVar = f48852d;
        }
        return bVar;
    }

    @Override // e0.a
    public DataReportResult a(DataReportRequest dataReportRequest) {
        if (dataReportRequest == null) {
            return null;
        }
        if (this.f48856c != null) {
            f48853e = null;
            new Thread(new c(this, dataReportRequest)).start();
            for (int i10 = StatConfig.STAT_DAU_PERIOD; f48853e == null && i10 >= 0; i10 -= 50) {
                Thread.sleep(50L);
            }
        }
        return f48853e;
    }

    @Override // e0.a
    public boolean a(String str) {
        com.alipay.tscenter.biz.rpc.a.a aVar;
        if (z.a.d(str) || (aVar = this.f48855b) == null) {
            return false;
        }
        String str2 = null;
        try {
            z.a.k(str);
            str2 = aVar.a();
        } catch (Throwable unused) {
        }
        if (z.a.d(str2)) {
            return false;
        }
        return ((Boolean) new JSONObject(str2).get("success")).booleanValue();
    }
}
