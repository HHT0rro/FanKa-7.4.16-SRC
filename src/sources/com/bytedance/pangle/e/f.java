package com.bytedance.pangle.e;

import android.os.SystemClock;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.i;
import com.bytedance.pangle.util.l;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class f {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
    public interface a {
        boolean a(String str, int i10);
    }

    public static void a() {
        if (GlobalParam.getInstance().isCloseBgDex2oat()) {
            return;
        }
        if ((i.e() || i.g() || i.b()) && com.bytedance.pangle.d.d.a(Zeus.getAppApplication())) {
            com.bytedance.pangle.d.e.a(new Runnable() { // from class: com.bytedance.pangle.e.f.1
                @Override // java.lang.Runnable
                public final void run() {
                    SystemClock.sleep(GlobalParam.getInstance().getDexOptDelayTime());
                    f.b();
                }
            });
        }
    }

    public static synchronized void b() {
        a aVar;
        synchronized (f.class) {
            Map<String, ?> all = b.a(Zeus.getAppApplication()).getAll();
            if (all.size() > 0) {
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat start:" + entry.getKey());
                    if (i.g()) {
                        aVar = new e();
                    } else if (i.e()) {
                        aVar = new d();
                    } else if (i.b()) {
                        aVar = new c();
                    } else {
                        aVar = new a() { // from class: com.bytedance.pangle.e.f.2
                            @Override // com.bytedance.pangle.e.f.a
                            public final boolean a(String str, int i10) {
                                return true;
                            }
                        };
                    }
                    if (aVar.a(entry.getKey(), ((Integer) entry.getValue()).intValue())) {
                        b.a(Zeus.getAppApplication()).edit().remove(entry.getKey()).apply();
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat success:" + entry.getKey());
                        l.a().b(entry.getKey(), ((Integer) entry.getValue()).intValue(), true);
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat markDexOptState:" + entry.getKey());
                    } else {
                        ZeusLogger.i(ZeusLogger.TAG_LOAD, "fullDex2oat failed:" + entry.getKey());
                    }
                }
            }
        }
    }
}
