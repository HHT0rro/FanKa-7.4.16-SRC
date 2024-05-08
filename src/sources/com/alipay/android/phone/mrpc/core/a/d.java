package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.alipay.sdk.util.l;
import com.huawei.openalliance.ad.constant.u;
import java.lang.reflect.Type;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d extends a {
    public d(Type type, byte[] bArr) {
        super(type, bArr);
    }

    @Override // com.alipay.android.phone.mrpc.core.a.c
    public final Object a() {
        try {
            String str = new String(this.f4210b);
            Thread.currentThread().getId();
            JSONObject jSONObject = new JSONObject(str);
            int i10 = jSONObject.getInt(l.f4746a);
            if (i10 == 1000) {
                return this.f4209a == String.class ? jSONObject.optString("result") : x.e.b(jSONObject.optString("result"), this.f4209a);
            }
            throw new RpcException(Integer.valueOf(i10), jSONObject.optString("tips"));
        } catch (Exception e2) {
            StringBuilder sb2 = new StringBuilder("response  =");
            sb2.append(new String(this.f4210b));
            sb2.append(u.bD);
            sb2.append((Object) e2);
            throw new RpcException((Integer) 10, sb2.toString() == null ? "" : e2.getMessage());
        }
    }
}
