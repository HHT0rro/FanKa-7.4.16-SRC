package s4;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.zip.Adler32;

/* compiled from: JobInfoScheduler.java */
@RequiresApi(api = 21)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class b implements o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f53578a;

    /* renamed from: b, reason: collision with root package name */
    public final com.google.android.datatransport.runtime.scheduling.persistence.b f53579b;

    /* renamed from: c, reason: collision with root package name */
    public final SchedulerConfig f53580c;

    public b(Context context, com.google.android.datatransport.runtime.scheduling.persistence.b bVar, SchedulerConfig schedulerConfig) {
        this.f53578a = context;
        this.f53579b = bVar;
        this.f53580c = schedulerConfig;
    }

    @Override // s4.o
    public void a(TransportContext transportContext, int i10) {
        ComponentName componentName = new ComponentName(this.f53578a, (Class<?>) JobInfoSchedulerService.class);
        JobScheduler jobScheduler = (JobScheduler) this.f53578a.getSystemService("jobscheduler");
        int b4 = b(transportContext);
        if (c(jobScheduler, b4, i10)) {
            p4.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", transportContext);
            return;
        }
        long p10 = this.f53579b.p(transportContext);
        JobInfo.Builder c4 = this.f53580c.c(new JobInfo.Builder(b4, componentName), transportContext.d(), p10, i10);
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putInt("attemptNumber", i10);
        persistableBundle.putString("backendName", transportContext.b());
        persistableBundle.putInt("priority", v4.a.a(transportContext.d()));
        if (transportContext.c() != null) {
            persistableBundle.putString("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        c4.setExtras(persistableBundle);
        p4.a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", transportContext, Integer.valueOf(b4), Long.valueOf(this.f53580c.g(transportContext.d(), p10, i10)), Long.valueOf(p10), Integer.valueOf(i10));
        jobScheduler.schedule(c4.build());
    }

    @VisibleForTesting
    public int b(TransportContext transportContext) {
        Adler32 adler32 = new Adler32();
        adler32.update(this.f53578a.getPackageName().getBytes(Charset.forName("UTF-8")));
        adler32.update(transportContext.b().getBytes(Charset.forName("UTF-8")));
        adler32.update(ByteBuffer.allocate(4).putInt(v4.a.a(transportContext.d())).array());
        if (transportContext.c() != null) {
            adler32.update(transportContext.c());
        }
        return (int) adler32.getValue();
    }

    public final boolean c(JobScheduler jobScheduler, int i10, int i11) {
        for (JobInfo jobInfo : jobScheduler.getAllPendingJobs()) {
            int i12 = jobInfo.getExtras().getInt("attemptNumber");
            if (jobInfo.getId() == i10) {
                return i12 >= i11;
            }
        }
        return false;
    }
}
