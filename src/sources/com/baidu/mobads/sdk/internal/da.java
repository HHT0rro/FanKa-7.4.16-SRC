package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
class da implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IOAdEvent f10136a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ cz f10137b;

    public da(cz czVar, IOAdEvent iOAdEvent) {
        this.f10137b = czVar;
        this.f10136a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CPUDramaListener cPUDramaListener;
        String str;
        CPUDramaListener cPUDramaListener2;
        CPUDramaListener cPUDramaListener3;
        IOAdEvent iOAdEvent = this.f10136a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f10136a.getType();
        cPUDramaListener = this.f10137b.f10135a.f10134s;
        if (cPUDramaListener == null) {
            return;
        }
        if ("onContentLoaded".equals(type)) {
            cPUDramaListener3 = this.f10137b.f10135a.f10134s;
            cPUDramaListener3.onContentLoaded();
            return;
        }
        if ("onContentFailed".equals(type)) {
            HashMap hashMap = (HashMap) this.f10136a.getData();
            int i10 = 0;
            if (hashMap != null) {
                str = (String) hashMap.get("error_message");
                Object obj = hashMap.get("error_code");
                if (obj == null) {
                    obj = 0;
                }
                i10 = ((Integer) obj).intValue();
            } else {
                str = "";
            }
            cPUDramaListener2 = this.f10137b.f10135a.f10134s;
            cPUDramaListener2.onContentFailed(i10, str);
            return;
        }
        if (x.f10416ar.equals(type)) {
            this.f10137b.f10135a.l(this.f10136a);
        } else if (x.as.equals(type)) {
            this.f10137b.f10135a.m(this.f10136a);
        }
    }
}
