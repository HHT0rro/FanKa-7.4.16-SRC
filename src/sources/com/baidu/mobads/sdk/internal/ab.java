package com.baidu.mobads.sdk.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class ab implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ aa f9752a;

    public ab(aa aaVar) {
        this.f9752a = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f9752a.a("加载dex超过5秒");
    }
}
