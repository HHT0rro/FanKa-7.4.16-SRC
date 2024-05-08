package kc;

import com.xiaomi.push.h6;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class d implements Runnable {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ List f50784b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f50785c;

    public d(List list, boolean z10) {
        this.f50784b = list;
        this.f50785c = z10;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean f10;
        boolean f11;
        f10 = c.f("www.baidu.com:80");
        Iterator iterator2 = this.f50784b.iterator2();
        while (true) {
            if (!iterator2.hasNext()) {
                break;
            }
            String str = (String) iterator2.next();
            if (!f10) {
                f11 = c.f(str);
                if (!f11) {
                    f10 = false;
                    if (!f10 && !this.f50785c) {
                        break;
                    }
                }
            }
            f10 = true;
            if (!f10) {
            }
        }
        h6.b(f10 ? 1 : 2);
    }
}
