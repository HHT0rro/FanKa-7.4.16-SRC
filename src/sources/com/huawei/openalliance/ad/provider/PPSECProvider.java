package com.huawei.openalliance.ad.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.constant.u;
import com.huawei.openalliance.ad.inter.b;
import com.huawei.openalliance.ad.utils.ak;
import com.huawei.openalliance.ad.utils.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class PPSECProvider extends ContentProvider {
    private static final int B = 1;
    private static final int C = 2;
    private static final String Code = "PPSATProvider";
    private static final int D = 5;
    private static final int F = 4;
    private static final String I = "errcode";
    private static final int S = 3;
    private static final String V = "getAccessToken";
    private static final int Z = 0;
    private final Map<String, a> L = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    private final a f32579a = new a() { // from class: com.huawei.openalliance.ad.provider.PPSECProvider.1
        @Override // com.huawei.openalliance.ad.provider.a
        public Bundle Code(String str, Bundle bundle) {
            String Code2;
            Bundle bundle2 = new Bundle();
            try {
                Code2 = ak.Code(PPSECProvider.this.getContext());
                gl.V(PPSECProvider.Code, "callingPackage " + Code2);
            } catch (Throwable th) {
                bundle2.putInt("errcode", 5);
                gl.I(PPSECProvider.Code, "getAccessToken exception: " + th.getClass().getSimpleName());
            }
            if (TextUtils.isEmpty(Code2)) {
                bundle2.putInt("errcode", 2);
                return bundle2;
            }
            if (!e.C(PPSECProvider.this.getContext(), Code2)) {
                bundle2.putInt("errcode", 3);
                return bundle2;
            }
            String V2 = b.Code().V();
            if (TextUtils.isEmpty(V2)) {
                gl.I(PPSECProvider.Code, "at is null.");
                bundle2.putInt("errcode", 4);
                return bundle2;
            }
            bundle2.putString(u.cO, V2);
            bundle2.putInt("errcode", 0);
            return bundle2;
        }
    };

    @Override // android.content.ContentProvider
    public Bundle call(String str, String str2, Bundle bundle) {
        gl.V(Code, "call method: " + str);
        a aVar = this.L.get(str);
        if (aVar != null) {
            return aVar.Code(str2, bundle);
        }
        Bundle bundle2 = new Bundle();
        bundle2.putInt("errcode", 1);
        return bundle2;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        this.L.put(V, this.f32579a);
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
