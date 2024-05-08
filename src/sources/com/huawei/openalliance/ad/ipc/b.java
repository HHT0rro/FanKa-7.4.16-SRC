package com.huawei.openalliance.ad.ipc;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.huawei.hms.ads.fr;
import com.huawei.hms.ads.gl;
import com.huawei.openalliance.ad.utils.at;
import com.huawei.openalliance.ad.utils.bc;
import com.huawei.openalliance.ad.utils.v;
import java.io.Closeable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class b {
    private static final String B = ".pps.apiprovider";
    private static final String C = ".pps.innerapiprovider";
    private static final String Code = "ApiCallManager";
    private static final String S = "com.huawei.hwid.pps.apiprovider";
    private static b V = null;
    private static final String Z = "content";
    private volatile Uri L;

    /* renamed from: a, reason: collision with root package name */
    private Context f32546a;
    private static final byte[] I = new byte[0];
    private static final String F = "/pps/api/call";
    private static final Uri D = new Uri.Builder().scheme("content").authority("com.huawei.hwid.pps.apiprovider").path(F).build();

    private b(Context context) {
        this.f32546a = context.getApplicationContext();
    }

    private Uri Code(boolean z10) {
        if (z10) {
            return D;
        }
        int t2 = fr.Code(this.f32546a).t();
        gl.V(Code, "ads selection:" + t2);
        if (v.V(this.f32546a) && (t2 == 0 || t2 == 2)) {
            return D;
        }
        if (!v.I()) {
            return D;
        }
        if (this.L == null) {
            this.L = new Uri.Builder().scheme("content").authority(this.f32546a.getPackageName() + C).path(F).build();
        }
        return this.L;
    }

    public static b Code(Context context) {
        b bVar;
        synchronized (I) {
            if (V == null) {
                V = new b(context);
            }
            bVar = V;
        }
        return bVar;
    }

    public <T> CallResult<T> Code(String str, String str2, Class<T> cls) {
        return Code(str, str2, cls, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <T> CallResult<T> Code(String str, String str2, Class<T> cls, boolean z10) {
        String message;
        CallResult<T> callResult = (CallResult<T>) new CallResult();
        Cursor cursor = null;
        try {
            try {
                try {
                    gl.V(Code, "call remote method: %s", str);
                    if (gl.Code()) {
                        gl.Code(Code, "paramContent: %s", bc.Code(str2));
                    }
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("sdk_version", "13.4.62.302");
                    jSONObject.put("content", str2);
                    cursor = this.f32546a.getContentResolver().query(Code(z10), null, null, new String[]{str, jSONObject.toString()}, null);
                    if (cursor != null && cursor.moveToFirst()) {
                        int i10 = cursor.getInt(cursor.getColumnIndexOrThrow("code"));
                        callResult.setCode(i10);
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("content"));
                        gl.Code(Code, "call: %s code: %s result: %s", str, Integer.valueOf(i10), string);
                        if (i10 == 200) {
                            callResult.setData(i.Code(string, cls));
                        } else {
                            callResult.setMsg(string);
                        }
                    }
                } catch (Throwable th) {
                    gl.I(Code, "callRemote " + th.getClass().getSimpleName());
                    callResult.setCode(-1);
                    message = th.getMessage();
                    callResult.setMsg(message);
                    at.Code(cursor);
                    gl.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                    return callResult;
                }
            } catch (IllegalArgumentException e2) {
                gl.I(Code, "callRemote IllegalArgumentException");
                callResult.setCode(-1);
                message = e2.getMessage();
                callResult.setMsg(message);
                at.Code(cursor);
                gl.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
                return callResult;
            }
            at.Code(cursor);
            gl.V(Code, "call %s code: %s msg: %s", str, Integer.valueOf(callResult.getCode()), callResult.getMsg());
            return callResult;
        } catch (Throwable th2) {
            at.Code((Closeable) null);
            throw th2;
        }
    }
}
