package com.huawei.hianalytics;

import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.constant.SymbolValues;
import com.huawei.hianalytics.core.crypto.AesCipher;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.transport.ITransportHandler;
import com.huawei.hianalytics.core.transport.net.HttpTransportHandler;
import com.huawei.hianalytics.core.transport.net.Response;
import com.huawei.openalliance.ad.constant.as;
import com.huawei.quickcard.cardmanager.util.CardUriUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class ghi implements Runnable {
    public String lmn = ikl.klm().lmn();
    public String klm = ikl.klm().ijk();
    public String ikl = ikl.klm().ikl();

    public final Response lmn(Exception exc) {
        if (exc instanceof SecurityException) {
            return e9.a.a("ABTest/SyncDataTask", HiLog.ErrorCode.NE003, "No Permission：INTERNET.", Response.Code.INTERNET_PERMISSION_ERROR, "");
        }
        if (exc instanceof SSLPeerUnverifiedException) {
            return e9.a.a("ABTest/SyncDataTask", HiLog.ErrorCode.NE002, "Certificate has not been verified,Request is restricted!", Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof SSLHandshakeException) {
            return e9.a.a("ABTest/SyncDataTask", HiLog.ErrorCode.NE002, "Chain validation failed,Certificate expired", Response.Code.SSL_VALIDATION_ERROR, "");
        }
        if (exc instanceof ConnectException) {
            return e9.a.a("ABTest/SyncDataTask", HiLog.ErrorCode.NE005, "Network is unreachable or Connection refused", Response.Code.CONNECTION_ERROR, "");
        }
        if (exc instanceof UnknownHostException) {
            return e9.a.a("ABTest/SyncDataTask", HiLog.ErrorCode.NE006, "Invalid URL.No address associated with hostname", -104, "");
        }
        if (exc instanceof IOException) {
            StringBuilder b4 = e9.a.b("IO Exception.");
            b4.append(exc.getMessage());
            HiLog.e("ABTest/SyncDataTask", HiLog.ErrorCode.NE004, b4.toString());
        } else {
            StringBuilder b10 = e9.a.b("other Exception:");
            b10.append(exc.getMessage());
            HiLog.e("ABTest/SyncDataTask", b10.toString());
        }
        return new Response(Response.Code.TIMEOUT_OR_OTHER_ERROR, "");
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        Response lmn;
        HiLog.i("ABTest/SyncDataTask", "sync data running..");
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(as.f32242q, this.klm);
        } catch (JSONException unused) {
            HiLog.w("ABTest/SyncDataTask", "getBody: json exception");
        }
        String jSONObject2 = jSONObject.toString();
        String str2 = this.lmn;
        e eVar = c.klm().lmn;
        if (TextUtils.isEmpty(eVar.fgh)) {
            str = eVar.ghi;
        } else {
            str = eVar.fgh;
        }
        String valueOf = String.valueOf(System.currentTimeMillis());
        String replace = UUID.randomUUID().toString().replace("-", "");
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("|");
        sb2.append(valueOf);
        sb2.append("|");
        sb2.append(replace);
        sb2.append("|");
        int indexOf = str2.indexOf(SymbolValues.QUESTION_EN_SYMBOL);
        sb2.append(indexOf != -1 ? str2.substring(indexOf + 1, str2.length()) : "");
        sb2.append("|");
        sb2.append(jSONObject2);
        String byteArray2HexString = HexUtil.byteArray2HexString(HexUtil.sha256Hmac(sb2.toString(), this.ikl));
        HashMap hashMap = new HashMap();
        hashMap.put("appId", str);
        hashMap.put("timestamp", valueOf);
        hashMap.put("random", replace);
        hashMap.put(CardUriUtils.PARAM_SIGN, byteArray2HexString);
        try {
            String[] strArr = {this.lmn + "/api/gateway/ab/api/service/shunting/hasdk/api/v1/getuserparameters"};
            HttpTransportHandler httpTransportHandler = new HttpTransportHandler();
            httpTransportHandler.setUrls(strArr);
            httpTransportHandler.setReportData(jSONObject2.getBytes("UTF-8"));
            httpTransportHandler.setSSLConfig(d.lmn(), Build.VERSION.SDK_INT >= 29 ? ITransportHandler.Protocols.TLS1_3 : ITransportHandler.Protocols.TLS1_2, "", true);
            httpTransportHandler.setHttpHeaders(hashMap);
            try {
                lmn = httpTransportHandler.execute();
            } catch (Exception e2) {
                lmn = lmn(e2);
            }
            String content = lmn.getContent();
            if (!TextUtils.isEmpty(content)) {
                try {
                    JSONArray jSONArray = new JSONObject(content).getJSONArray("parameters");
                    ijk[] ijkVarArr = new ijk[jSONArray.length()];
                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                    for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                        JSONObject jSONObject3 = jSONArray.getJSONObject(i10);
                        String string = jSONObject3.getString("groupId");
                        String string2 = jSONObject3.getString("key");
                        ijkVarArr[i10] = new ijk(jSONObject3.getString("value"), string);
                        concurrentHashMap.put(string2, ijkVarArr[i10]);
                    }
                    HiLog.i("ABTest/SyncDataTask", "Start caching data!");
                    SharedPreferences.Editor edit = j0.lmn("abtest").edit();
                    edit.putString("exp_data", AesCipher.encryptCbc(content, q.lmn().klm()));
                    edit.putLong("expdata_refresh_time", System.currentTimeMillis());
                    edit.commit();
                } catch (JSONException unused2) {
                    HiLog.w("ABTest/SyncDataTask", "experiment data error");
                }
            }
        } catch (IOException unused3) {
            HiLog.w("ABTest/SyncDataTask", "getBody: body to bytes error!");
        }
        ikl iklVar = ikl.hij;
        synchronized (iklVar) {
            iklVar.ikl = true;
        }
        ikl iklVar2 = ikl.hij;
        synchronized (iklVar2) {
            iklVar2.klm = false;
        }
    }
}
