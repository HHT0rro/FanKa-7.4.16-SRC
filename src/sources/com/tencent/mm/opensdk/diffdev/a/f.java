package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f extends AsyncTask<Void, Void, a> {

    /* renamed from: k, reason: collision with root package name */
    private OAuthListener f45105k;

    /* renamed from: n, reason: collision with root package name */
    private String f45106n;

    /* renamed from: t, reason: collision with root package name */
    private int f45107t;
    private String url;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: m, reason: collision with root package name */
        public OAuthErrCode f45108m;

        /* renamed from: u, reason: collision with root package name */
        public String f45109u;

        /* renamed from: v, reason: collision with root package name */
        public int f45110v;

        public static a b(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            OAuthErrCode oAuthErrCode2;
            a aVar = new a();
            Log.d("MicroMsg.SDK.NoopingResult", "star parse NoopingResult");
            if (bArr == null || bArr.length == 0) {
                Log.e("MicroMsg.SDK.NoopingResult", "parse fail, buf is null");
                oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            } else {
                try {
                    try {
                        JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                        int i10 = jSONObject.getInt("wx_errcode");
                        aVar.f45110v = i10;
                        Log.d("MicroMsg.SDK.NoopingResult", String.format("nooping uuidStatusCode = %d", Integer.valueOf(i10)));
                        int i11 = aVar.f45110v;
                        if (i11 == 408) {
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                        } else {
                            if (i11 != 500) {
                                switch (i11) {
                                    case 402:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Timeout;
                                        break;
                                    case 403:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_Cancel;
                                        break;
                                    case 404:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_OK;
                                        break;
                                    case 405:
                                        aVar.f45108m = OAuthErrCode.WechatAuth_Err_OK;
                                        aVar.f45109u = jSONObject.getString("wx_code");
                                        break;
                                    default:
                                        oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                                        break;
                                }
                                return aVar;
                            }
                            oAuthErrCode2 = OAuthErrCode.WechatAuth_Err_NormalErr;
                        }
                        aVar.f45108m = oAuthErrCode2;
                        return aVar;
                    } catch (Exception e2) {
                        format = String.format("parse json fail, ex = %s", e2.getMessage());
                        Log.e("MicroMsg.SDK.NoopingResult", format);
                        oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f45108m = oAuthErrCode;
                        return aVar;
                    }
                } catch (Exception e10) {
                    format = String.format("parse fail, build String fail, ex = %s", e10.getMessage());
                }
            }
            aVar.f45108m = oAuthErrCode;
            return aVar;
        }
    }

    public f(String str, OAuthListener oAuthListener) {
        this.f45106n = str;
        this.f45105k = oAuthListener;
        this.url = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) {
        a aVar;
        OAuthErrCode oAuthErrCode;
        String str;
        Thread.currentThread().setName("OpenSdkNoopingTask");
        String str2 = this.f45106n;
        if (str2 == null || str2.length() == 0) {
            Log.e("MicroMsg.SDK.NoopingTask", "run fail, uuid is null");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
        } else {
            Log.i("MicroMsg.SDK.NoopingTask", "doInBackground start " + isCancelled());
            while (!isCancelled()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(this.url);
                if (this.f45107t == 0) {
                    str = "";
                } else {
                    str = "&last=" + this.f45107t;
                }
                sb2.append(str);
                String sb3 = sb2.toString();
                long currentTimeMillis = System.currentTimeMillis();
                byte[] a10 = e.a(sb3);
                long currentTimeMillis2 = System.currentTimeMillis();
                a b4 = a.b(a10);
                Log.d("MicroMsg.SDK.NoopingTask", String.format("nooping, url = %s, errCode = %s, uuidStatusCode = %d, time consumed = %d(ms)", sb3, b4.f45108m.toString(), Integer.valueOf(b4.f45110v), Long.valueOf(currentTimeMillis2 - currentTimeMillis)));
                OAuthErrCode oAuthErrCode2 = b4.f45108m;
                if (oAuthErrCode2 != OAuthErrCode.WechatAuth_Err_OK) {
                    Log.e("MicroMsg.SDK.NoopingTask", String.format("nooping fail, errCode = %s, uuidStatusCode = %d", oAuthErrCode2.toString(), Integer.valueOf(b4.f45110v)));
                    return b4;
                }
                int i10 = b4.f45110v;
                this.f45107t = i10;
                if (i10 == g.UUID_SCANED.getCode()) {
                    this.f45105k.onQrcodeScanned();
                } else if (b4.f45110v != g.UUID_KEEP_CONNECT.getCode() && b4.f45110v == g.UUID_CONFIRM.getCode()) {
                    String str3 = b4.f45109u;
                    if (str3 == null || str3.length() == 0) {
                        Log.e("MicroMsg.SDK.NoopingTask", "nooping fail, confirm with an empty code!!!");
                        b4.f45108m = OAuthErrCode.WechatAuth_Err_NormalErr;
                    }
                    return b4;
                }
            }
            Log.i("MicroMsg.SDK.NoopingTask", "IDiffDevOAuth.stopAuth / detach invoked");
            aVar = new a();
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_Auth_Stopped;
        }
        aVar.f45108m = oAuthErrCode;
        return aVar;
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f45105k.onAuthFinish(aVar2.f45108m, aVar2.f45109u);
    }
}
