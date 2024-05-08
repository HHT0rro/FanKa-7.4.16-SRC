package kc;

import android.util.Base64;
import com.xiaomi.push.g3;
import com.xiaomi.push.n7;
import com.xiaomi.push.r;
import com.xiaomi.push.z1;
import java.util.List;
import kc.x;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class y extends r.b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f50873a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f50874b;

    public y(x xVar) {
        this.f50874b = xVar;
    }

    @Override // com.xiaomi.push.r.b
    public void b() {
        try {
            g3 n10 = g3.n(Base64.decode(z1.f(n7.b(), "http://resolver.msg.xiaomi.net/psc/?t=a", null), 10));
            if (n10 != null) {
                this.f50874b.f50871b = n10;
                this.f50873a = true;
                this.f50874b.p();
            }
        } catch (Exception e2) {
            fc.c.i("fetch config failure: " + e2.getMessage());
        }
    }

    @Override // com.xiaomi.push.r.b
    public void c() {
        List list;
        List list2;
        x.a[] aVarArr;
        g3 g3Var;
        this.f50874b.f50872c = null;
        if (this.f50873a) {
            synchronized (this.f50874b) {
                list = this.f50874b.f50870a;
                list2 = this.f50874b.f50870a;
                aVarArr = (x.a[]) list.toArray(new x.a[list2.size()]);
            }
            for (x.a aVar : aVarArr) {
                g3Var = this.f50874b.f50871b;
                aVar.b(g3Var);
            }
        }
    }
}
