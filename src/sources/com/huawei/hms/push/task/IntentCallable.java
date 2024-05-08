package com.huawei.hms.push.task;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import java.util.concurrent.Callable;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class IntentCallable implements Callable<Void> {

    /* renamed from: a, reason: collision with root package name */
    private Context f30459a;

    /* renamed from: b, reason: collision with root package name */
    private Intent f30460b;

    /* renamed from: c, reason: collision with root package name */
    private String f30461c;

    public IntentCallable(Context context, Intent intent, String str) {
        this.f30459a = context;
        this.f30460b = intent;
        this.f30461c = str;
    }

    @Override // java.util.concurrent.Callable
    public Void call() throws Exception {
        this.f30459a.sendBroadcast(this.f30460b);
        PushBiUtil.reportExit(this.f30459a, PushNaming.SET_NOTIFY_FLAG, this.f30461c, ErrorEnum.SUCCESS);
        return null;
    }
}
