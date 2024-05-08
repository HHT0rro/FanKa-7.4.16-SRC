package com.qq.e.comm.managers;

import com.qq.e.comm.managers.plugin.PM;
import com.qq.e.comm.managers.plugin.e;
import com.qq.e.comm.util.GDTLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f38266a;

    public a(b bVar) {
        this.f38266a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        PM pm;
        try {
            pm = this.f38266a.f38271d;
            pm.getPOFactory();
            this.f38266a.f38269b = true;
        } catch (e e2) {
            GDTLogger.e(e2.getMessage(), e2);
        }
    }
}
