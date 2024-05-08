package kc;

import com.xiaomi.push.i3;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.v4;
import com.xiaomi.push.y4;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class e0 extends v4 {

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ XMPushService f50787k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e0(XMPushService xMPushService, Map map, int i10, String str, y4 y4Var) {
        super(map, i10, str, y4Var);
        this.f50787k = xMPushService;
    }

    @Override // com.xiaomi.push.v4
    public byte[] i() {
        try {
            i3 i3Var = new i3();
            i3Var.j(x.h().a());
            return i3Var.h();
        } catch (Exception e2) {
            fc.c.i("getOBBString err: " + e2.toString());
            return null;
        }
    }
}
