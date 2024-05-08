package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import android.util.Base64;
import com.huawei.hms.ads.jsb.constant.Constant;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;
import com.tencent.mm.opensdk.utils.Log;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d extends AsyncTask<Void, Void, a> {

    /* renamed from: h, reason: collision with root package name */
    private static String f45093h = "https://open.weixin.qq.com/connect/sdk/qrconnect?appid=%s&noncestr=%s&timestamp=%s&scope=%s&signature=%s";
    private String appId;

    /* renamed from: i, reason: collision with root package name */
    private String f45094i;

    /* renamed from: j, reason: collision with root package name */
    private String f45095j;

    /* renamed from: k, reason: collision with root package name */
    private OAuthListener f45096k;

    /* renamed from: l, reason: collision with root package name */
    private f f45097l;
    private String scope;
    private String signature;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a {

        /* renamed from: m, reason: collision with root package name */
        public OAuthErrCode f45098m;

        /* renamed from: n, reason: collision with root package name */
        public String f45099n;

        /* renamed from: o, reason: collision with root package name */
        public String f45100o;

        /* renamed from: p, reason: collision with root package name */
        public String f45101p;

        /* renamed from: q, reason: collision with root package name */
        public int f45102q;

        /* renamed from: r, reason: collision with root package name */
        public String f45103r;

        /* renamed from: s, reason: collision with root package name */
        public byte[] f45104s;

        private a() {
        }

        public static a a(byte[] bArr) {
            OAuthErrCode oAuthErrCode;
            String format;
            a aVar = new a();
            if (bArr != null && bArr.length != 0) {
                try {
                } catch (Exception e2) {
                    format = String.format("parse fail, build String fail, ex = %s", e2.getMessage());
                }
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
                    int i10 = jSONObject.getInt("errcode");
                    if (i10 != 0) {
                        Log.e("MicroMsg.SDK.GetQRCodeResult", String.format("resp errcode = %d", Integer.valueOf(i10)));
                        aVar.f45098m = OAuthErrCode.WechatAuth_Err_NormalErr;
                        aVar.f45102q = i10;
                        aVar.f45103r = jSONObject.optString("errmsg");
                        return aVar;
                    }
                    String string = jSONObject.getJSONObject("qrcode").getString("qrcodebase64");
                    if (string != null && string.length() != 0) {
                        byte[] decode = Base64.decode(string, 0);
                        if (decode != null && decode.length != 0) {
                            aVar.f45098m = OAuthErrCode.WechatAuth_Err_OK;
                            aVar.f45104s = decode;
                            aVar.f45099n = jSONObject.getString(Constant.MAP_KEY_UUID);
                            String string2 = jSONObject.getString("appname");
                            aVar.f45100o = string2;
                            Log.d("MicroMsg.SDK.GetQRCodeResult", String.format("parse succ, save in memory, uuid = %s, appname = %s, imgBufLength = %d", aVar.f45099n, string2, Integer.valueOf(aVar.f45104s.length)));
                            return aVar;
                        }
                        Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBuf is null");
                        aVar.f45098m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                        return aVar;
                    }
                    Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, qrcodeBase64 is null");
                    aVar.f45098m = OAuthErrCode.WechatAuth_Err_JsonDecodeErr;
                    return aVar;
                } catch (Exception e10) {
                    format = String.format("parse json fail, ex = %s", e10.getMessage());
                    Log.e("MicroMsg.SDK.GetQRCodeResult", format);
                    oAuthErrCode = OAuthErrCode.WechatAuth_Err_NormalErr;
                    aVar.f45098m = oAuthErrCode;
                    return aVar;
                }
            }
            Log.e("MicroMsg.SDK.GetQRCodeResult", "parse fail, buf is null");
            oAuthErrCode = OAuthErrCode.WechatAuth_Err_NetworkErr;
            aVar.f45098m = oAuthErrCode;
            return aVar;
        }
    }

    public d(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        this.appId = str;
        this.scope = str2;
        this.f45094i = str3;
        this.f45095j = str4;
        this.signature = str5;
        this.f45096k = oAuthListener;
    }

    public final boolean a() {
        Log.i("MicroMsg.SDK.GetQRCodeTask", "cancelTask");
        f fVar = this.f45097l;
        return fVar == null ? cancel(true) : fVar.cancel(true);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ a doInBackground(Void[] voidArr) {
        Thread.currentThread().setName("OpenSdkGetQRCodeTask");
        Log.i("MicroMsg.SDK.GetQRCodeTask", "doInBackground");
        String format = String.format(f45093h, this.appId, this.f45094i, this.f45095j, this.scope, this.signature);
        long currentTimeMillis = System.currentTimeMillis();
        byte[] a10 = e.a(format);
        Log.d("MicroMsg.SDK.GetQRCodeTask", String.format("doInBackground, url = %s, time consumed = %d(ms)", format, Long.valueOf(System.currentTimeMillis() - currentTimeMillis)));
        return a.a(a10);
    }

    @Override // android.os.AsyncTask
    public final /* synthetic */ void onPostExecute(a aVar) {
        a aVar2 = aVar;
        OAuthErrCode oAuthErrCode = aVar2.f45098m;
        if (oAuthErrCode != OAuthErrCode.WechatAuth_Err_OK) {
            Log.e("MicroMsg.SDK.GetQRCodeTask", String.format("onPostExecute, get qrcode fail, OAuthErrCode = %s", oAuthErrCode));
            this.f45096k.onAuthFinish(aVar2.f45098m, null);
            return;
        }
        Log.d("MicroMsg.SDK.GetQRCodeTask", "onPostExecute, get qrcode success imgBufSize = " + aVar2.f45104s.length);
        this.f45096k.onAuthGotQrcode(aVar2.f45101p, aVar2.f45104s);
        f fVar = new f(aVar2.f45099n, this.f45096k);
        this.f45097l = fVar;
        fVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }
}
