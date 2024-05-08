package com.alibaba.security.realidentity.build;

import com.alibaba.security.common.http.ok.Headers;
import com.alibaba.security.common.http.ok.Response;
import com.alibaba.security.realidentity.build.ft;
import com.alibaba.security.realidentity.oss.common.utils.CaseInsensitiveHashMap;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.math.BigInteger;
import java.util.zip.CheckedInputStream;

/* compiled from: AbstractResponseParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public abstract class cz<T extends ft> implements dl {
    private static void b(dk dkVar) {
        try {
            dkVar.e();
        } catch (Exception unused) {
        }
    }

    @Override // com.alibaba.security.realidentity.build.dl
    public final T a(dk dkVar) throws IOException {
        boolean a10;
        try {
            try {
                T t2 = (T) ((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
                if (t2 != null) {
                    t2.f3698n = (String) dkVar.a().get(cc.f3295x);
                    t2.f3696l = dkVar.f3479c;
                    Response response = dkVar.f3477a;
                    CaseInsensitiveHashMap caseInsensitiveHashMap = new CaseInsensitiveHashMap();
                    Headers headers = response.headers();
                    for (int i10 = 0; i10 < headers.size(); i10++) {
                        caseInsensitiveHashMap.put(headers.name(i10), headers.value(i10));
                    }
                    t2.f3697m = caseInsensitiveHashMap;
                    InputStream b4 = dkVar.f3478b.b();
                    if (b4 != null && (b4 instanceof CheckedInputStream)) {
                        t2.a(Long.valueOf(((CheckedInputStream) b4).getChecksum().getValue()));
                    }
                    String str = (String) dkVar.a().get(cc.I);
                    if (str != null) {
                        t2.b(Long.valueOf(new BigInteger(str).longValue()));
                    }
                    t2 = a(dkVar, (dk) t2);
                }
                if (a10) {
                    try {
                        dkVar.e();
                    } catch (Exception unused) {
                    }
                }
                return t2;
            } catch (Exception e2) {
                IOException iOException = new IOException(e2.getMessage(), e2);
                e2.printStackTrace();
                cd.a(e2);
                throw iOException;
            }
        } finally {
            if (a()) {
                try {
                    dkVar.e();
                } catch (Exception unused2) {
                }
            }
        }
    }

    public abstract T a(dk dkVar, T t2) throws Exception;

    public boolean a() {
        return true;
    }

    private static CaseInsensitiveHashMap<String, String> a(Response response) {
        CaseInsensitiveHashMap<String, String> caseInsensitiveHashMap = new CaseInsensitiveHashMap<>();
        Headers headers = response.headers();
        for (int i10 = 0; i10 < headers.size(); i10++) {
            caseInsensitiveHashMap.put(headers.name(i10), headers.value(i10));
        }
        return caseInsensitiveHashMap;
    }

    private static <Result extends ft> void a(Result result, dk dkVar) {
        InputStream b4 = dkVar.f3478b.b();
        if (b4 != null && (b4 instanceof CheckedInputStream)) {
            result.a(Long.valueOf(((CheckedInputStream) b4).getChecksum().getValue()));
        }
        String str = (String) dkVar.a().get(cc.I);
        if (str != null) {
            result.b(Long.valueOf(new BigInteger(str).longValue()));
        }
    }
}
