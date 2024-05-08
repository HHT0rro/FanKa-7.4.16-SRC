package com.baidu.mobads.sdk.internal;

import android.app.Activity;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class df implements ViewTreeObserver.OnWindowFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RelativeLayout f10152a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ db f10153b;

    public df(db dbVar, RelativeLayout relativeLayout) {
        this.f10153b = dbVar;
        this.f10152a = relativeLayout;
    }

    @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
    public void onWindowFocusChanged(boolean z10) {
        if (z10) {
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("novel_activity", (Activity) this.f10153b.f9878h);
            hashMap.put("banner_container", this.f10152a);
            hashMap.put("entry", Integer.valueOf(this.f10153b.D));
            hashMap.put("channelId", Integer.valueOf(this.f10153b.E));
            hashMap.put("novel_id", this.f10153b.F);
            hashMap.put("isnight", Boolean.valueOf(this.f10153b.x()));
            this.f10153b.a(db.f10143u, hashMap);
        }
    }
}
