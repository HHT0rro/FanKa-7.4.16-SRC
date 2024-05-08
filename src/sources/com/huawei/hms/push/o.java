package com.huawei.hms.push;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import java.nio.charset.Charset;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: PushSelfShowMessage.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class o {
    private int B;
    private String D;

    /* renamed from: b, reason: collision with root package name */
    private int f30425b;

    /* renamed from: c, reason: collision with root package name */
    private String f30426c;

    /* renamed from: d, reason: collision with root package name */
    private String f30427d;

    /* renamed from: l, reason: collision with root package name */
    private String f30435l;

    /* renamed from: m, reason: collision with root package name */
    private String f30436m;

    /* renamed from: n, reason: collision with root package name */
    private String f30437n;

    /* renamed from: o, reason: collision with root package name */
    private String f30438o;

    /* renamed from: p, reason: collision with root package name */
    private String f30439p;

    /* renamed from: r, reason: collision with root package name */
    private String f30441r;

    /* renamed from: s, reason: collision with root package name */
    private String f30442s;

    /* renamed from: z, reason: collision with root package name */
    private String f30449z;

    /* renamed from: a, reason: collision with root package name */
    private String f30424a = "";

    /* renamed from: e, reason: collision with root package name */
    private String f30428e = "";

    /* renamed from: f, reason: collision with root package name */
    private String f30429f = "";

    /* renamed from: g, reason: collision with root package name */
    private String f30430g = "";

    /* renamed from: h, reason: collision with root package name */
    private String f30431h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f30432i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f30433j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f30434k = "";

    /* renamed from: q, reason: collision with root package name */
    private String f30440q = "";

    /* renamed from: t, reason: collision with root package name */
    private int f30443t = k.STYLE_DEFAULT.ordinal();

    /* renamed from: u, reason: collision with root package name */
    private String f30444u = "";

    /* renamed from: v, reason: collision with root package name */
    private String f30445v = "";

    /* renamed from: w, reason: collision with root package name */
    private String f30446w = "";

    /* renamed from: x, reason: collision with root package name */
    private int f30447x = 0;

    /* renamed from: y, reason: collision with root package name */
    private int f30448y = 0;
    private String A = "";
    private String C = "";
    private String E = "";
    private String F = "";

    public o(byte[] bArr, byte[] bArr2) {
        Charset charset = m.f30420a;
        this.f30441r = new String(bArr, charset);
        this.f30442s = new String(bArr2, charset);
    }

    private JSONObject a(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject);
        jSONObject2.put("group", this.f30424a);
        jSONObject2.put("tag", this.A);
        jSONObject2.put(RemoteMessageConst.Notification.AUTO_CANCEL, this.f30447x);
        jSONObject2.put("visibility", this.f30448y);
        jSONObject2.put(RemoteMessageConst.Notification.WHEN, this.f30449z);
        return jSONObject2;
    }

    private JSONObject b(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("cmd", this.f30430g);
        jSONObject2.put("content", this.f30431h);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_ICON, this.f30432i);
        jSONObject2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, this.f30433j);
        jSONObject2.put("notifySummary", this.f30434k);
        jSONObject2.put("param", jSONObject);
        return jSONObject2;
    }

    private void c(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(IAdInterListener.AdReqParam.AP)) {
            String string = jSONObject.getString(IAdInterListener.AdReqParam.AP);
            StringBuilder sb2 = new StringBuilder();
            if (!TextUtils.isEmpty(string) && string.length() < 48) {
                int length = 48 - string.length();
                for (int i10 = 0; i10 < length; i10++) {
                    sb2.append("0");
                }
                sb2.append(string);
                this.f30427d = sb2.toString();
                return;
            }
            this.f30427d = string.substring(0, 48);
        }
    }

    private boolean d(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(RemoteMessageConst.Notification.CLICK_ACTION)) {
            this.f30436m = jSONObject.getString(RemoteMessageConst.Notification.CLICK_ACTION);
        }
        if (jSONObject.has(RemoteMessageConst.Notification.INTENT_URI)) {
            this.f30426c = jSONObject.getString(RemoteMessageConst.Notification.INTENT_URI);
        }
        if (jSONObject.has(com.huawei.openalliance.ad.download.app.d.F)) {
            this.f30435l = jSONObject.getString(com.huawei.openalliance.ad.download.app.d.F);
            return true;
        }
        HMSLog.d("PushSelfShowLog", "appPackageName is null");
        return false;
    }

    private boolean e(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MSGID)) {
            Object obj = jSONObject.get(RemoteMessageConst.MSGID);
            if (obj instanceof String) {
                this.f30428e = (String) obj;
                return true;
            }
            if (!(obj instanceof Integer)) {
                return true;
            }
            this.f30428e = String.valueOf(((Integer) obj).intValue());
            return true;
        }
        HMSLog.i("PushSelfShowLog", "msgId == null");
        return false;
    }

    private boolean f(JSONObject jSONObject) {
        HMSLog.d("PushSelfShowLog", "enter parseNotifyParam");
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
            if (jSONObject2.has("style")) {
                this.f30443t = jSONObject2.getInt("style");
            }
            this.f30444u = jSONObject2.optString("bigTitle");
            this.f30445v = jSONObject2.optString("bigContent");
            this.E = jSONObject2.optString("icon");
            return true;
        } catch (JSONException e2) {
            HMSLog.i("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    private void g(JSONObject jSONObject) {
        this.f30424a = jSONObject.optString("group");
        HMSLog.d("PushSelfShowLog", "NOTIFY_GROUP:" + this.f30424a);
        this.f30447x = jSONObject.optInt(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        HMSLog.d("PushSelfShowLog", "autoCancel: " + this.f30447x);
        this.f30448y = jSONObject.optInt("visibility", 0);
        this.f30449z = jSONObject.optString(RemoteMessageConst.Notification.WHEN);
        this.A = jSONObject.optString("tag");
    }

    private boolean h(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject("param");
            if (jSONObject2.has("autoClear")) {
                this.f30425b = jSONObject2.getInt("autoClear");
            } else {
                this.f30425b = 0;
            }
            if (!"app".equals(this.f30430g) && !"cosa".equals(this.f30430g)) {
                if ("url".equals(this.f30430g)) {
                    k(jSONObject2);
                    return true;
                }
                if (!"rp".equals(this.f30430g)) {
                    return true;
                }
                j(jSONObject2);
                return true;
            }
            d(jSONObject2);
            return true;
        } catch (Exception e2) {
            HMSLog.e("PushSelfShowLog", "ParseParam error ", e2);
            return false;
        }
    }

    private boolean i(JSONObject jSONObject) throws JSONException {
        if (jSONObject.has(RemoteMessageConst.MessageBody.PS_CONTENT)) {
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
            this.f30430g = jSONObject2.getString("cmd");
            this.f30431h = jSONObject2.optString("content");
            this.f30432i = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f30433j = jSONObject2.optString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f30434k = jSONObject2.optString("notifySummary");
            this.D = jSONObject2.optString(RemoteMessageConst.Notification.TICKER);
            if ((!jSONObject2.has(RemoteMessageConst.MessageBody.NOTIFY_DETAIL) || f(jSONObject2)) && jSONObject2.has("param")) {
                return h(jSONObject2);
            }
        }
        return false;
    }

    private boolean j(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has(com.huawei.openalliance.ad.download.app.d.F)) {
            this.f30435l = jSONObject.getString(com.huawei.openalliance.ad.download.app.d.F);
        }
        if (jSONObject.has("rpt") && jSONObject.has("rpl")) {
            this.f30438o = jSONObject.getString("rpl");
            this.f30439p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f30440q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "rpl or rpt is null");
        return false;
    }

    private boolean k(JSONObject jSONObject) throws JSONException {
        if (jSONObject == null) {
            return false;
        }
        if (jSONObject.has("url")) {
            this.f30437n = jSONObject.getString("url");
            if (jSONObject.has(com.huawei.openalliance.ad.download.app.d.F)) {
                this.f30435l = jSONObject.getString(com.huawei.openalliance.ad.download.app.d.F);
            }
            if (!jSONObject.has("rpt") || !jSONObject.has("rpl")) {
                return true;
            }
            this.f30438o = jSONObject.getString("rpl");
            this.f30439p = jSONObject.getString("rpt");
            if (!jSONObject.has("rpct")) {
                return true;
            }
            this.f30440q = jSONObject.getString("rpct");
            return true;
        }
        HMSLog.d("PushSelfShowLog", "url is null");
        return false;
    }

    private JSONObject q() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("style", this.f30443t);
        jSONObject.put("bigTitle", this.f30444u);
        jSONObject.put("bigContent", this.f30445v);
        jSONObject.put("bigPic", this.f30446w);
        return jSONObject;
    }

    private JSONObject u() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("autoClear", this.f30425b);
        jSONObject.put("url", this.f30437n);
        jSONObject.put("rpl", this.f30438o);
        jSONObject.put("rpt", this.f30439p);
        jSONObject.put("rpct", this.f30440q);
        jSONObject.put(com.huawei.openalliance.ad.download.app.d.F, this.f30435l);
        jSONObject.put(RemoteMessageConst.Notification.CLICK_ACTION, this.f30436m);
        jSONObject.put(RemoteMessageConst.Notification.INTENT_URI, this.f30426c);
        return jSONObject;
    }

    public String l() {
        return this.E;
    }

    public String m() {
        return this.f30426c;
    }

    public byte[] n() {
        try {
            return a(a(b(u()), q())).toString().getBytes(m.f30420a);
        } catch (JSONException e2) {
            HMSLog.e("PushSelfShowLog", "getMsgData failed JSONException:", e2);
            return new byte[0];
        }
    }

    public String o() {
        HMSLog.d("PushSelfShowLog", "msgId =" + this.f30428e);
        return this.f30428e;
    }

    public String p() {
        return this.A;
    }

    public int r() {
        return this.B;
    }

    public String s() {
        return this.f30434k;
    }

    public String t() {
        return this.f30433j;
    }

    public int v() {
        return this.f30443t;
    }

    public String w() {
        return this.D;
    }

    public byte[] x() {
        return this.f30442s.getBytes(m.f30420a);
    }

    public boolean y() {
        try {
            if (TextUtils.isEmpty(this.f30441r)) {
                HMSLog.d("PushSelfShowLog", "msg is null");
                return false;
            }
            JSONObject jSONObject = new JSONObject(this.f30441r);
            g(jSONObject);
            JSONObject jSONObject2 = jSONObject.getJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
            if (!e(jSONObject2)) {
                return false;
            }
            this.f30429f = jSONObject2.optString("dispPkgName");
            c(jSONObject2);
            this.B = jSONObject2.optInt(RemoteMessageConst.Notification.NOTIFY_ID, -1);
            this.C = jSONObject2.optString("data");
            this.F = jSONObject2.optString(RemoteMessageConst.ANALYTIC_INFO);
            return i(jSONObject2);
        } catch (JSONException unused) {
            HMSLog.d("PushSelfShowLog", "parse message exception.");
            return false;
        } catch (Exception e2) {
            HMSLog.d("PushSelfShowLog", e2.toString());
            return false;
        }
    }

    private JSONObject a(JSONObject jSONObject, JSONObject jSONObject2) throws JSONException {
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("dispPkgName", this.f30429f);
        jSONObject3.put(RemoteMessageConst.MSGID, this.f30428e);
        jSONObject3.put(IAdInterListener.AdReqParam.AP, this.f30427d);
        jSONObject3.put(RemoteMessageConst.Notification.NOTIFY_ID, this.B);
        jSONObject3.put(RemoteMessageConst.MessageBody.PS_CONTENT, jSONObject);
        jSONObject3.put(RemoteMessageConst.MessageBody.NOTIFY_DETAIL, jSONObject2);
        jSONObject3.put(RemoteMessageConst.Notification.TICKER, this.D);
        jSONObject3.put("data", this.C);
        return jSONObject3;
    }

    public String b() {
        return this.F;
    }

    public int d() {
        return this.f30447x;
    }

    public String g() {
        return this.f30444u;
    }

    public int e() {
        return this.f30425b;
    }

    public String f() {
        return this.f30445v;
    }

    public String j() {
        return this.f30429f;
    }

    public String c() {
        return this.f30435l;
    }

    public String k() {
        return this.f30424a;
    }

    public String h() {
        return this.f30430g;
    }

    public String i() {
        return this.f30431h;
    }

    public String a() {
        return this.f30436m;
    }

    public void a(int i10) {
        this.B = i10;
    }
}
