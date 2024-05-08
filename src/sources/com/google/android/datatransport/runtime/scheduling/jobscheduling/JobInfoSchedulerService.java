package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.d;
import s4.c;

@RequiresApi(api = 21)
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class JobInfoSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String string = jobParameters.getExtras().getString("backendName");
        String string2 = jobParameters.getExtras().getString("extras");
        int i10 = jobParameters.getExtras().getInt("priority");
        int i11 = jobParameters.getExtras().getInt("attemptNumber");
        d.f(getApplicationContext());
        TransportContext.a d10 = TransportContext.a().b(string).d(v4.a.b(i10));
        if (string2 != null) {
            d10.c(Base64.decode(string2, 0));
        }
        d.c().e().g(d10.a(), i11, c.a(this, jobParameters));
        return true;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return true;
    }
}
