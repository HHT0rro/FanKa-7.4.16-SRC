package com.xiaomi.push.service;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.quickcard.CardContext;
import com.xiaomi.push.j4;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class XMJobService extends Service {

    /* renamed from: c, reason: collision with root package name */
    public static Service f48153c;

    /* renamed from: b, reason: collision with root package name */
    public IBinder f48154b = null;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class a extends JobService {

        /* renamed from: b, reason: collision with root package name */
        public Binder f48155b;

        /* renamed from: c, reason: collision with root package name */
        public Handler f48156c;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
        public static class HandlerC0714a extends Handler {

            /* renamed from: a, reason: collision with root package name */
            public JobService f48157a;

            public HandlerC0714a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f48157a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                fc.c.i("Job finished " + jobParameters.getJobId());
                this.f48157a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    j4.d(false);
                }
            }
        }

        public a(Service service) {
            this.f48155b = null;
            this.f48155b = (Binder) com.xiaomi.push.k0.e(this, CardContext.ON_BIND_FUNC, new Intent());
            com.xiaomi.push.k0.e(this, "attachBaseContext", service);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            fc.c.i("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f48156c == null) {
                this.f48156c = new HandlerC0714a(this);
            }
            Handler handler = this.f48156c;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            fc.c.i("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f48154b;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f48154b = new a(this).f48155b;
        f48153c = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f48153c = null;
    }
}
