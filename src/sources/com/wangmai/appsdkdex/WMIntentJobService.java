package com.wangmai.appsdkdex;

import android.app.Activity;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.wangmai.common.utils.DebugLog;
import zc.b;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class WMIntentJobService extends JobService {

    /* renamed from: c, reason: collision with root package name */
    public static final String f46913c = b.a("jt`bdujwjuz");

    /* renamed from: d, reason: collision with root package name */
    public static final String f46914d = b.a("boespje/joufou/fyusb/JOUFOU");

    /* renamed from: b, reason: collision with root package name */
    public static final String f46912b = WMIntentJobService.class.getSimpleName();

    /* renamed from: e, reason: collision with root package name */
    public static int f46915e = 20000;

    /* renamed from: f, reason: collision with root package name */
    public static int f46916f = 1001;

    public static boolean a(Context context, Intent intent, boolean z10) {
        String str = f46912b;
        DebugLog.W(str, b.a("鱄滧睎拢摰择Bdujwjuz...?XNJoufouKpcTfswjdf...?tubsuBdujwjuz"));
        if (context instanceof Activity) {
            try {
                DebugLog.W(str, b.a("澔抎Dpoufyu沟廏Bdujwjuz毟忌�蜵珦摰择"));
                context.startActivity(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        }
        DebugLog.W(str, b.a("澔抎Dpoufyu幎沟廏Bdujwjuz毟忌�鯿辯Joufou!Gmbh!Ofx!Ubtl摰择"));
        intent.addFlags(268435456);
        if (z10) {
            int i10 = f46915e + 1;
            f46915e = i10;
            try {
                PendingIntent.getActivity(context, i10, intent, 1073741824).send();
                return true;
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
        try {
            context.startActivity(intent);
            return true;
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        DebugLog.W(f46912b, b.a("摰择鱄滧睎拢...?XNJoufouKpcTfswjdf...?poDsfbuf"));
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        DebugLog.W(f46912b, b.a("ꕁ簂鱄滧睎拢...?XNJoufouKpcTfswjdf...?poEftuspz"));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i10, int i11) {
        DebugLog.W(f46912b, b.a("摰择鱄滧睎拢...?XNJoufouKpcTfswjdf...?poTubsuDpnnboe"));
        super.onStartCommand(intent, i10, i11);
        return 1;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        String str = f46912b;
        DebugLog.W(str, b.a("ꕁ簂鱄滧睎拢...?XNJoufouKpcTfswjdf...?poTubsuKpc"));
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        Bundle transientExtras = jobParameters.getTransientExtras();
        Intent intent = (Intent) transientExtras.getParcelable(f46914d);
        DebugLog.W(str, b.a("駂鸴龭蛅蜯硈Joufou...?;") + ((Object) intent));
        if (intent == null) {
            return false;
        }
        if (transientExtras.getBoolean(f46913c)) {
            DebugLog.W(str, b.a("瞦鈫Bdujwjuz蛅Joufou�犨颍鸴龭"));
            a(this, intent, false);
            return false;
        }
        try {
            DebugLog.W(str, b.a("瞦鈫ꞟBdujwjuz蛅Joufou�摰择睎拢"));
            startService(intent);
            return false;
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(b.a("tdifevmfTfswjdf!tubsuTfswjdf!fssps!;!"));
            sb2.append(e2.toString());
            return false;
        }
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        DebugLog.W(f46912b, b.a("悝箣鱄滧睎拢...?XNJoufouKpcTfswjdf...?poTupqKpc"));
        return false;
    }
}
