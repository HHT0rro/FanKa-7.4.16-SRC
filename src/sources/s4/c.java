package s4;

import android.app.job.JobParameters;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.JobInfoSchedulerService;

/* compiled from: JobInfoSchedulerService.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final JobInfoSchedulerService f53581b;

    /* renamed from: c, reason: collision with root package name */
    public final JobParameters f53582c;

    public c(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        this.f53581b = jobInfoSchedulerService;
        this.f53582c = jobParameters;
    }

    public static Runnable a(JobInfoSchedulerService jobInfoSchedulerService, JobParameters jobParameters) {
        return new c(jobInfoSchedulerService, jobParameters);
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f53581b.jobFinished(this.f53582c, false);
    }
}
