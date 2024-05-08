package com.vivo.push.sdk;

import android.content.Intent;
import android.os.Message;
import com.vivo.push.ab;
import com.vivo.push.util.g;
import com.vivo.push.util.u;

/* compiled from: CommandWorker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class a extends ab {

    /* renamed from: c, reason: collision with root package name */
    private static a f46368c;

    /* renamed from: d, reason: collision with root package name */
    private String f46369d = "";

    private a() {
    }

    public final String b() {
        return this.f46369d;
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (f46368c == null) {
                f46368c = new a();
            }
            aVar = f46368c;
        }
        return aVar;
    }

    @Override // com.vivo.push.ab
    public final void b(Message message) {
        Intent intent = (Intent) message.obj;
        if (intent != null && this.f46074a != null) {
            com.vivo.push.restructure.a.b bVar = new com.vivo.push.restructure.a.b(intent);
            try {
                u.d("CommandWorker", "received msg : ".concat(String.valueOf(bVar.a())));
                g.a().execute(new b(this, bVar));
                return;
            } catch (Exception e2) {
                u.a("CommandWorker", "handle message err : " + e2.getMessage());
                return;
            }
        }
        u.d("CommandWorker", " handleMessage error: intent : " + ((Object) intent) + ", mContext: " + ((Object) this.f46074a));
    }

    public final void a(String str) {
        this.f46369d = str;
    }

    public final void a(Intent intent) {
        if (intent != null && this.f46074a != null) {
            Message obtain = Message.obtain();
            obtain.obj = intent;
            a(obtain);
        } else {
            u.d("CommandWorker", " sendMessage error: intent : " + ((Object) intent) + ", mContext: " + ((Object) this.f46074a));
        }
    }
}
