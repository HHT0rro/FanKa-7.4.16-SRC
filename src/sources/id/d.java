package id;

import android.database.Cursor;
import com.tanx.exposer.achieve.retry.AdMonitorRetryType;
import com.tanx.exposer.framework.connectivity.tanxc_do;
import java.util.ArrayList;

/* compiled from: AdMonitorRetryManager.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ b f49889b;

    public d(b bVar) {
        this.f49889b = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        this.f49889b.e();
        String a10 = rc.c.a(System.currentTimeMillis(), "yyyy-MM-dd");
        rc.b.a("AdRetryExposeManager", "currentDate=" + a10);
        b bVar = this.f49889b;
        a aVar = bVar.f49879c;
        int i10 = bVar.f49884h;
        synchronized (aVar) {
            try {
                long delete = aVar.getWritableDatabase().delete("retry_monitor_info", "date != ? or retry_times >= ?", new String[]{a10, String.valueOf(i10)});
                if (rc.b.f53376a) {
                    rc.b.a("RetryMonitorDbHelper", "delete: deletedRows = " + delete + ", date = " + a10 + ", maxRetryTimes = " + i10);
                }
            } catch (Throwable th) {
                rc.b.b("RetryMonitorDbHelper", "delete by date exception.", th);
            }
        }
        b bVar2 = this.f49889b;
        bVar2.e();
        String a11 = rc.c.a(System.currentTimeMillis(), "yyyy-MM-dd");
        a aVar2 = bVar2.f49879c;
        synchronized (aVar2) {
            arrayList = new ArrayList();
            Cursor query = aVar2.getReadableDatabase().query("retry_monitor_info", null, "date = ?", new String[]{a11}, null, null, null, null);
            while (query != null) {
                try {
                    try {
                        if (!query.moveToNext()) {
                            break;
                        }
                        gd.a aVar3 = new gd.a(query);
                        arrayList.add(aVar3);
                        if (rc.b.f53376a) {
                            rc.b.a("RetryMonitorDbHelper", "query: add retryMonitorInfo = " + ((Object) aVar3));
                        }
                    } catch (Exception e2) {
                        rc.b.b("RetryMonitorDbHelper", "query exception, date = " + a11, e2);
                        query.close();
                    }
                } finally {
                    query.close();
                }
            }
            if (query != null) {
            }
            if (rc.b.f53376a) {
                rc.b.a("RetryMonitorDbHelper", "query: exposeDate = " + a11 + ", retryMonitorInfoList = " + ((Object) arrayList));
            }
        }
        if (arrayList.isEmpty()) {
            if (rc.b.f53376a) {
                rc.b.a("AdRetryExposeManager", "sendRetryMonitor return because no retry monitor info.");
                return;
            }
            return;
        }
        int size = arrayList.size();
        if (rc.b.f53376a) {
            rc.b.a("AdRetryExposeManager", "sendRetryMonitor: count = " + size);
        }
        for (int i11 = 0; i11 < size; i11++) {
            gd.a aVar4 = (gd.a) arrayList.get(i11);
            aVar4.f49466l = AdMonitorRetryType.DB;
            if (bVar2.d(aVar4)) {
                if (!bVar2.f49885i.contains(aVar4)) {
                    bVar2.h();
                    bVar2.f49885i.add(aVar4);
                } else {
                    bVar2.f49879c.a(aVar4.f49455a);
                }
            } else {
                bVar2.f49879c.a(aVar4.f49455a);
            }
        }
        if (!(tanxc_do.c.f38989a.f38985e != -1)) {
            if (rc.b.f53376a) {
                rc.b.a("AdRetryExposeManager", "sendRetryMonitor return because no net.");
                return;
            }
            return;
        }
        bVar2.a();
    }
}
