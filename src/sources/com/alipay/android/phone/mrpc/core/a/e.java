package com.alipay.android.phone.mrpc.core.a;

import com.alipay.android.phone.mrpc.core.RpcException;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.openalliance.ad.constant.u;
import java.util.ArrayList;
import java.util.Objects;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class e extends b {

    /* renamed from: c, reason: collision with root package name */
    private int f4213c;

    /* renamed from: d, reason: collision with root package name */
    private Object f4214d;

    public e(int i10, String str, Object obj) {
        super(str, obj);
        this.f4213c = i10;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final void a(Object obj) {
        this.f4214d = obj;
    }

    @Override // com.alipay.android.phone.mrpc.core.a.f
    public final byte[] a() {
        try {
            ArrayList arrayList = new ArrayList();
            if (this.f4214d != null) {
                arrayList.add(new BasicNameValuePair(CardConstants.KEY_EXT_PARAM, x.f.a(this.f4214d)));
            }
            arrayList.add(new BasicNameValuePair("operationType", this.f4211a));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(this.f4213c);
            arrayList.add(new BasicNameValuePair("id", sb2.toString()));
            Objects.toString(this.f4212b);
            Object obj = this.f4212b;
            arrayList.add(new BasicNameValuePair(CardConstants.KEY_REQUEST_DATA, obj == null ? "[]" : x.f.a(obj)));
            return URLEncodedUtils.format(arrayList, "utf-8").getBytes();
        } catch (Exception e2) {
            StringBuilder sb3 = new StringBuilder("request  =");
            sb3.append(this.f4212b);
            sb3.append(u.bD);
            sb3.append((Object) e2);
            throw new RpcException(9, sb3.toString() == null ? "" : e2.getMessage(), e2);
        }
    }
}
