package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.a;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.m;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class PlatformScheduler$PlatformSchedulerService extends JobService {
    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        PersistableBundle extras = jobParameters.getExtras();
        int b4 = new Requirements(extras.getInt("requirements")).b(this);
        if (b4 == 0) {
            String str = (String) a.e(extras.getString("service_action"));
            j0.P0(this, new Intent(str).setPackage((String) a.e(extras.getString("service_package"))));
            return false;
        }
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("Requirements not met: ");
        sb2.append(b4);
        m.h("PlatformScheduler", sb2.toString());
        jobFinished(jobParameters, true);
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        return false;
    }
}
