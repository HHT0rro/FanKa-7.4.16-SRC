package com.alipay.android.phone.mrpc.core;

import com.huawei.hms.ads.jsb.constant.Constant;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class j extends a {

    /* renamed from: g, reason: collision with root package name */
    private g f4235g;

    public j(g gVar, Method method, int i10, String str, byte[] bArr, boolean z10) {
        super(method, i10, str, bArr, "application/x-www-form-urlencoded", z10);
        this.f4235g = gVar;
    }

    @Override // com.alipay.android.phone.mrpc.core.v
    public final Object a() {
        o oVar = new o(this.f4235g.a());
        oVar.a(this.f4204b);
        oVar.a(this.f4207e);
        oVar.a(this.f4208f);
        oVar.a("id", String.valueOf(this.f4206d));
        oVar.a("operationType", this.f4205c);
        oVar.a("gzip", String.valueOf(this.f4235g.d()));
        oVar.a(new BasicHeader(Constant.MAP_KEY_UUID, UUID.randomUUID().toString()));
        List<Header> b4 = this.f4235g.c().b();
        if (b4 != null && !b4.isEmpty()) {
            Iterator<Header> iterator2 = b4.iterator2();
            while (iterator2.hasNext()) {
                oVar.a(iterator2.next());
            }
        }
        Thread.currentThread().getId();
        oVar.toString();
        try {
            u uVar = this.f4235g.b().a(oVar).get();
            if (uVar != null) {
                return uVar.b();
            }
            throw new RpcException((Integer) 9, "response is null");
        } catch (InterruptedException e2) {
            throw new RpcException(13, "", e2);
        } catch (CancellationException e10) {
            throw new RpcException(13, "", e10);
        } catch (ExecutionException e11) {
            Throwable cause = e11.getCause();
            if (cause == null || !(cause instanceof HttpException)) {
                throw new RpcException(9, "", e11);
            }
            HttpException httpException = (HttpException) cause;
            int code = httpException.getCode();
            switch (code) {
                case 1:
                    code = 2;
                    break;
                case 2:
                    code = 3;
                    break;
                case 3:
                    code = 4;
                    break;
                case 4:
                    code = 5;
                    break;
                case 5:
                    code = 6;
                    break;
                case 6:
                    code = 7;
                    break;
                case 7:
                    code = 8;
                    break;
                case 8:
                    code = 15;
                    break;
                case 9:
                    code = 16;
                    break;
            }
            throw new RpcException(Integer.valueOf(code), httpException.getMsg());
        }
    }
}
