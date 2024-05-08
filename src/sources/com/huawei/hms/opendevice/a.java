package com.huawei.hms.opendevice;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import java.util.concurrent.Callable;

/* compiled from: AAIDCallable.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a implements Callable<AAIDResult> {

    /* renamed from: a, reason: collision with root package name */
    private Context f30325a;

    public a(Context context) {
        this.f30325a = context;
    }

    @Override // java.util.concurrent.Callable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AAIDResult call() throws Exception {
        Context context = this.f30325a;
        if (context != null) {
            String b4 = b.b(context);
            AAIDResult aAIDResult = new AAIDResult();
            aAIDResult.setId(b4);
            return aAIDResult;
        }
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }
}
