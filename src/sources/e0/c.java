package e0;

import com.alipay.tscenter.biz.rpc.report.general.model.DataReportRequest;
import com.alipay.tscenter.biz.rpc.report.general.model.DataReportResult;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DataReportRequest f48857b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b f48858c;

    public c(b bVar, DataReportRequest dataReportRequest) {
        this.f48858c = bVar;
        this.f48857b = dataReportRequest;
    }

    @Override // java.lang.Runnable
    public void run() {
        DataReportResult dataReportResult;
        DataReportResult dataReportResult2;
        com.alipay.tscenter.biz.rpc.report.general.a aVar;
        try {
            aVar = this.f48858c.f48856c;
            DataReportResult unused = b.f48853e = aVar.a();
        } catch (Throwable th) {
            DataReportResult unused2 = b.f48853e = new DataReportResult();
            dataReportResult = b.f48853e;
            dataReportResult.success = false;
            dataReportResult2 = b.f48853e;
            dataReportResult2.resultCode = "static data rpc upload error, " + z.a.b(th);
            z.a.b(th);
        }
    }
}
