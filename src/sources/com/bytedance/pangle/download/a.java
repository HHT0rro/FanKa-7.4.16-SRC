package com.bytedance.pangle.download;

import android.app.Activity;
import com.bytedance.pangle.Zeus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f10693b;

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f10694a = new CopyOnWriteArrayList();

    public a() {
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(new com.bytedance.pangle.a() { // from class: com.bytedance.pangle.download.a.1
            @Override // com.bytedance.pangle.a, android.app.Application.ActivityLifecycleCallbacks
            public final void onActivityResumed(Activity activity) {
                Iterator iterator2 = a.this.f10694a.iterator2();
                while (iterator2.hasNext()) {
                    iterator2.next();
                    b.a();
                }
            }
        });
    }

    public static a a() {
        if (f10693b == null) {
            synchronized (a.class) {
                if (f10693b == null) {
                    f10693b = new a();
                }
            }
        }
        return f10693b;
    }
}
