package com.yxcorp.kuaishou.addfp;

import android.content.Context;
import android.os.Build;
import com.yxcorp.kuaishou.addfp.android.a.c;
import com.yxcorp.kuaishou.addfp.android.b.f;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KWEGIDDFP f48569a;

    public a(KWEGIDDFP kwegiddfp) {
        this.f48569a = kwegiddfp;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        String str;
        ResponseDfpCallback responseDfpCallback;
        ResponseDfpCallback responseDfpCallback2;
        Context unused;
        try {
            context = this.f48569a.mParamContext;
            if (context == null) {
                responseDfpCallback2 = this.f48569a.mCallBack;
                responseDfpCallback2.onFailed(-3, "parameter error");
                return;
            }
            unused = this.f48569a.mParamContext;
            int i10 = f.f48591c;
            if (Build.VERSION.SDK_INT >= 28) {
                f.a();
            }
            KWEGIDDFP kwegiddfp = this.f48569a;
            context2 = kwegiddfp.mParamContext;
            kwegiddfp.mPkgName = context2.getPackageName();
            c c4 = c.c();
            str = this.f48569a.mPkgName;
            c4.b(str);
            KWEGIDDFP kwegiddfp2 = this.f48569a;
            responseDfpCallback = kwegiddfp2.mCallBack;
            kwegiddfp2.getEGid(responseDfpCallback);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
