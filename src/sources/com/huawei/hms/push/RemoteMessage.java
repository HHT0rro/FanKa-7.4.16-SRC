package com.huawei.hms.push;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.DateUtil;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.api.push.PushException;
import com.huawei.hms.support.log.HMSLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class RemoteMessage implements Parcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR;
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;

    /* renamed from: c, reason: collision with root package name */
    private static final String[] f30370c;

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f30371d;

    /* renamed from: e, reason: collision with root package name */
    private static final long[] f30372e;

    /* renamed from: f, reason: collision with root package name */
    private static final HashMap<String, Object> f30373f;

    /* renamed from: g, reason: collision with root package name */
    private static final HashMap<String, Object> f30374g;

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<String, Object> f30375h;

    /* renamed from: i, reason: collision with root package name */
    private static final HashMap<String, Object> f30376i;

    /* renamed from: j, reason: collision with root package name */
    private static final HashMap<String, Object> f30377j;

    /* renamed from: a, reason: collision with root package name */
    private Bundle f30378a;

    /* renamed from: b, reason: collision with root package name */
    private Notification f30379b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        private final Bundle f30380a;

        /* renamed from: b, reason: collision with root package name */
        private final Map<String, String> f30381b;

        public Builder(String str) {
            Bundle bundle = new Bundle();
            this.f30380a = bundle;
            this.f30381b = new HashMap();
            bundle.putString(RemoteMessageConst.TO, str);
        }

        public Builder addData(String str, String str2) {
            if (str != null) {
                this.f30381b.put(str, str2);
                return this;
            }
            throw new IllegalArgumentException("add data failed, key is null.");
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry<String, String> entry : this.f30381b.entrySet()) {
                    jSONObject.put(entry.getKey(), entry.getValue());
                }
                try {
                    String jSONObject2 = jSONObject.toString();
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(RemoteMessageConst.COLLAPSE_KEY, this.f30380a.getString(RemoteMessageConst.COLLAPSE_KEY));
                    jSONObject3.put(RemoteMessageConst.TTL, this.f30380a.getInt(RemoteMessageConst.TTL));
                    jSONObject3.put(RemoteMessageConst.SEND_MODE, this.f30380a.getInt(RemoteMessageConst.SEND_MODE));
                    jSONObject3.put(RemoteMessageConst.RECEIPT_MODE, this.f30380a.getInt(RemoteMessageConst.RECEIPT_MODE));
                    JSONObject jSONObject4 = new JSONObject();
                    if (jSONObject.length() != 0) {
                        jSONObject4.put("data", jSONObject2);
                    }
                    jSONObject4.put(RemoteMessageConst.MSGID, this.f30380a.getString(RemoteMessageConst.MSGID));
                    jSONObject3.put(RemoteMessageConst.MessageBody.MSG_CONTENT, jSONObject4);
                    bundle.putByteArray(RemoteMessageConst.MSGBODY, jSONObject3.toString().getBytes(m.f30420a));
                    bundle.putString(RemoteMessageConst.TO, this.f30380a.getString(RemoteMessageConst.TO));
                    bundle.putString(RemoteMessageConst.MSGTYPE, this.f30380a.getString(RemoteMessageConst.MSGTYPE));
                    return new RemoteMessage(bundle);
                } catch (JSONException unused) {
                    HMSLog.w("RemoteMessage", "JSONException: parse message body failed.");
                    throw new PushException(PushException.EXCEPTION_SEND_FAILED);
                }
            } catch (JSONException unused2) {
                HMSLog.w("RemoteMessage", "JSONException: parse data to json failed.");
                throw new PushException(PushException.EXCEPTION_SEND_FAILED);
            }
        }

        public Builder clearData() {
            this.f30381b.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.f30380a.putString(RemoteMessageConst.COLLAPSE_KEY, str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.f30381b.clear();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                this.f30381b.put(entry.getKey(), entry.getValue());
            }
            return this;
        }

        public Builder setMessageId(String str) {
            this.f30380a.putString(RemoteMessageConst.MSGID, str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.f30380a.putString(RemoteMessageConst.MSGTYPE, str);
            return this;
        }

        public Builder setReceiptMode(int i10) {
            if (i10 != 1 && i10 != 0) {
                throw new IllegalArgumentException("receipt mode can only be 0 or 1.");
            }
            this.f30380a.putInt(RemoteMessageConst.RECEIPT_MODE, i10);
            return this;
        }

        public Builder setSendMode(int i10) {
            if (i10 != 0 && i10 != 1) {
                throw new IllegalArgumentException("send mode can only be 0 or 1.");
            }
            this.f30380a.putInt(RemoteMessageConst.SEND_MODE, i10);
            return this;
        }

        public Builder setTtl(int i10) {
            if (i10 >= 1 && i10 <= 1296000) {
                this.f30380a.putInt(RemoteMessageConst.TTL, i10);
                return this;
            }
            throw new IllegalArgumentException("ttl must be greater than or equal to 1 and less than or equal to 1296000");
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public @interface MessagePriority {
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public static class Notification implements Serializable {
        private final long[] A;
        private final String B;

        /* renamed from: a, reason: collision with root package name */
        private final String f30382a;

        /* renamed from: b, reason: collision with root package name */
        private final String f30383b;

        /* renamed from: c, reason: collision with root package name */
        private final String[] f30384c;

        /* renamed from: d, reason: collision with root package name */
        private final String f30385d;

        /* renamed from: e, reason: collision with root package name */
        private final String f30386e;

        /* renamed from: f, reason: collision with root package name */
        private final String[] f30387f;

        /* renamed from: g, reason: collision with root package name */
        private final String f30388g;

        /* renamed from: h, reason: collision with root package name */
        private final String f30389h;

        /* renamed from: i, reason: collision with root package name */
        private final String f30390i;

        /* renamed from: j, reason: collision with root package name */
        private final String f30391j;

        /* renamed from: k, reason: collision with root package name */
        private final String f30392k;

        /* renamed from: l, reason: collision with root package name */
        private final String f30393l;

        /* renamed from: m, reason: collision with root package name */
        private final String f30394m;

        /* renamed from: n, reason: collision with root package name */
        private final Uri f30395n;

        /* renamed from: o, reason: collision with root package name */
        private final int f30396o;

        /* renamed from: p, reason: collision with root package name */
        private final String f30397p;

        /* renamed from: q, reason: collision with root package name */
        private final int f30398q;

        /* renamed from: r, reason: collision with root package name */
        private final int f30399r;

        /* renamed from: s, reason: collision with root package name */
        private final int f30400s;

        /* renamed from: t, reason: collision with root package name */
        private final int[] f30401t;

        /* renamed from: u, reason: collision with root package name */
        private final String f30402u;

        /* renamed from: v, reason: collision with root package name */
        private final int f30403v;

        /* renamed from: w, reason: collision with root package name */
        private final String f30404w;

        /* renamed from: x, reason: collision with root package name */
        private final int f30405x;

        /* renamed from: y, reason: collision with root package name */
        private final String f30406y;

        /* renamed from: z, reason: collision with root package name */
        private final String f30407z;

        public /* synthetic */ Notification(Bundle bundle, a aVar) {
            this(bundle);
        }

        private Integer a(String str) {
            if (str != null) {
                try {
                    return Integer.valueOf(str);
                } catch (NumberFormatException unused) {
                    HMSLog.w("RemoteMessage", "NumberFormatException: get " + str + " failed.");
                }
            }
            return null;
        }

        public Integer getBadgeNumber() {
            return a(this.f30404w);
        }

        public String getBody() {
            return this.f30385d;
        }

        public String[] getBodyLocalizationArgs() {
            String[] strArr = this.f30387f;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getBodyLocalizationKey() {
            return this.f30386e;
        }

        public String getChannelId() {
            return this.f30394m;
        }

        public String getClickAction() {
            return this.f30392k;
        }

        public String getColor() {
            return this.f30391j;
        }

        public String getIcon() {
            return this.f30388g;
        }

        public Uri getImageUrl() {
            String str = this.f30397p;
            if (str == null) {
                return null;
            }
            return Uri.parse(str);
        }

        public Integer getImportance() {
            return a(this.f30406y);
        }

        public String getIntentUri() {
            return this.f30393l;
        }

        public int[] getLightSettings() {
            int[] iArr = this.f30401t;
            return iArr == null ? new int[0] : (int[]) iArr.clone();
        }

        public Uri getLink() {
            return this.f30395n;
        }

        public int getNotifyId() {
            return this.f30396o;
        }

        public String getSound() {
            return this.f30389h;
        }

        public String getTag() {
            return this.f30390i;
        }

        public String getTicker() {
            return this.f30407z;
        }

        public String getTitle() {
            return this.f30382a;
        }

        public String[] getTitleLocalizationArgs() {
            String[] strArr = this.f30384c;
            return strArr == null ? new String[0] : (String[]) strArr.clone();
        }

        public String getTitleLocalizationKey() {
            return this.f30383b;
        }

        public long[] getVibrateConfig() {
            long[] jArr = this.A;
            return jArr == null ? new long[0] : (long[]) jArr.clone();
        }

        public Integer getVisibility() {
            return a(this.B);
        }

        public Long getWhen() {
            if (!TextUtils.isEmpty(this.f30402u)) {
                try {
                    return Long.valueOf(DateUtil.parseUtcToMillisecond(this.f30402u));
                } catch (StringIndexOutOfBoundsException unused) {
                    HMSLog.w("RemoteMessage", "StringIndexOutOfBoundsException: parse when failed.");
                } catch (ParseException unused2) {
                    HMSLog.w("RemoteMessage", "ParseException: parse when failed.");
                }
            }
            return null;
        }

        public boolean isAutoCancel() {
            return this.f30405x == 1;
        }

        public boolean isDefaultLight() {
            return this.f30398q == 1;
        }

        public boolean isDefaultSound() {
            return this.f30399r == 1;
        }

        public boolean isDefaultVibrate() {
            return this.f30400s == 1;
        }

        public boolean isLocalOnly() {
            return this.f30403v == 1;
        }

        private Notification(Bundle bundle) {
            this.f30382a = bundle.getString(RemoteMessageConst.Notification.NOTIFY_TITLE);
            this.f30385d = bundle.getString("content");
            this.f30383b = bundle.getString(RemoteMessageConst.Notification.TITLE_LOC_KEY);
            this.f30386e = bundle.getString(RemoteMessageConst.Notification.BODY_LOC_KEY);
            this.f30384c = bundle.getStringArray(RemoteMessageConst.Notification.TITLE_LOC_ARGS);
            this.f30387f = bundle.getStringArray(RemoteMessageConst.Notification.BODY_LOC_ARGS);
            this.f30388g = bundle.getString("icon");
            this.f30391j = bundle.getString("color");
            this.f30389h = bundle.getString(RemoteMessageConst.Notification.SOUND);
            this.f30390i = bundle.getString("tag");
            this.f30394m = bundle.getString("channelId");
            this.f30392k = bundle.getString(RemoteMessageConst.Notification.CLICK_ACTION);
            this.f30393l = bundle.getString(RemoteMessageConst.Notification.INTENT_URI);
            this.f30396o = bundle.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            String string = bundle.getString("url");
            this.f30395n = !TextUtils.isEmpty(string) ? Uri.parse(string) : null;
            this.f30397p = bundle.getString(RemoteMessageConst.Notification.NOTIFY_ICON);
            this.f30398q = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS);
            this.f30399r = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_SOUND);
            this.f30400s = bundle.getInt(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS);
            this.f30401t = bundle.getIntArray(RemoteMessageConst.Notification.LIGHT_SETTINGS);
            this.f30402u = bundle.getString(RemoteMessageConst.Notification.WHEN);
            this.f30403v = bundle.getInt(RemoteMessageConst.Notification.LOCAL_ONLY);
            this.f30404w = bundle.getString(RemoteMessageConst.Notification.BADGE_SET_NUM, null);
            this.f30405x = bundle.getInt(RemoteMessageConst.Notification.AUTO_CANCEL);
            this.f30406y = bundle.getString("priority", null);
            this.f30407z = bundle.getString(RemoteMessageConst.Notification.TICKER);
            this.A = bundle.getLongArray(RemoteMessageConst.Notification.VIBRATE_TIMINGS);
            this.B = bundle.getString("visibility", null);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
    public class a implements Parcelable.Creator<RemoteMessage> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage createFromParcel(Parcel parcel) {
            return new RemoteMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RemoteMessage[] newArray(int i10) {
            return new RemoteMessage[i10];
        }
    }

    static {
        String[] strArr = new String[0];
        f30370c = strArr;
        int[] iArr = new int[0];
        f30371d = iArr;
        long[] jArr = new long[0];
        f30372e = jArr;
        HashMap<String, Object> hashMap = new HashMap<>(8);
        f30373f = hashMap;
        hashMap.put(RemoteMessageConst.FROM, "");
        hashMap.put(RemoteMessageConst.COLLAPSE_KEY, "");
        hashMap.put(RemoteMessageConst.SEND_TIME, "");
        hashMap.put(RemoteMessageConst.TTL, Integer.valueOf(RemoteMessageConst.DEFAULT_TTL));
        hashMap.put("urgency", 2);
        hashMap.put(RemoteMessageConst.ORI_URGENCY, 2);
        hashMap.put(RemoteMessageConst.SEND_MODE, 0);
        hashMap.put(RemoteMessageConst.RECEIPT_MODE, 0);
        HashMap<String, Object> hashMap2 = new HashMap<>(8);
        f30374g = hashMap2;
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_KEY, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_ICON, "");
        hashMap2.put(RemoteMessageConst.Notification.TITLE_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.BODY_LOC_ARGS, strArr);
        hashMap2.put(RemoteMessageConst.Notification.TICKER, "");
        hashMap2.put(RemoteMessageConst.Notification.NOTIFY_TITLE, "");
        hashMap2.put("content", "");
        HashMap<String, Object> hashMap3 = new HashMap<>(8);
        f30375h = hashMap3;
        hashMap3.put("icon", "");
        hashMap3.put("color", "");
        hashMap3.put(RemoteMessageConst.Notification.SOUND, "");
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_LIGHT_SETTINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.LIGHT_SETTINGS, iArr);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_SOUND, 1);
        hashMap3.put(RemoteMessageConst.Notification.DEFAULT_VIBRATE_TIMINGS, 1);
        hashMap3.put(RemoteMessageConst.Notification.VIBRATE_TIMINGS, jArr);
        HashMap<String, Object> hashMap4 = new HashMap<>(8);
        f30376i = hashMap4;
        hashMap4.put("tag", "");
        hashMap4.put(RemoteMessageConst.Notification.WHEN, "");
        hashMap4.put(RemoteMessageConst.Notification.LOCAL_ONLY, 1);
        hashMap4.put(RemoteMessageConst.Notification.BADGE_SET_NUM, "");
        hashMap4.put("priority", "");
        hashMap4.put(RemoteMessageConst.Notification.AUTO_CANCEL, 1);
        hashMap4.put("visibility", "");
        hashMap4.put("channelId", "");
        HashMap<String, Object> hashMap5 = new HashMap<>(3);
        f30377j = hashMap5;
        hashMap5.put(RemoteMessageConst.Notification.CLICK_ACTION, "");
        hashMap5.put(RemoteMessageConst.Notification.INTENT_URI, "");
        hashMap5.put("url", "");
        CREATOR = new a();
    }

    public RemoteMessage(Bundle bundle) {
        this.f30378a = a(bundle);
    }

    private Bundle a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        JSONObject b4 = b(bundle);
        JSONObject a10 = a(b4);
        String string = JsonUtil.getString(a10, "data", null);
        bundle2.putString(RemoteMessageConst.ANALYTIC_INFO, JsonUtil.getString(a10, RemoteMessageConst.ANALYTIC_INFO, null));
        bundle2.putString(RemoteMessageConst.DEVICE_TOKEN, bundle.getString(RemoteMessageConst.DEVICE_TOKEN));
        JSONObject d10 = d(a10);
        JSONObject b10 = b(d10);
        JSONObject c4 = c(d10);
        if (bundle.getInt(RemoteMessageConst.INPUT_TYPE) == 1 && d.a(a10, d10, string)) {
            bundle2.putString("data", com.huawei.hms.push.a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
            return bundle2;
        }
        String string2 = bundle.getString(RemoteMessageConst.TO);
        String string3 = bundle.getString(RemoteMessageConst.MSGTYPE);
        String string4 = JsonUtil.getString(a10, RemoteMessageConst.MSGID, null);
        bundle2.putString(RemoteMessageConst.TO, string2);
        bundle2.putString("data", string);
        bundle2.putString(RemoteMessageConst.MSGID, string4);
        bundle2.putString(RemoteMessageConst.MSGTYPE, string3);
        JsonUtil.transferJsonObjectToBundle(b4, bundle2, f30373f);
        bundle2.putBundle("notification", a(b4, a10, d10, b10, c4));
        return bundle2;
    }

    private static JSONObject b(Bundle bundle) {
        try {
            return new JSONObject(com.huawei.hms.push.a.a(bundle.getByteArray(RemoteMessageConst.MSGBODY)));
        } catch (JSONException unused) {
            HMSLog.w("RemoteMessage", "JSONException:parse message body failed.");
            return null;
        }
    }

    private static JSONObject c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject("param");
        }
        return null;
    }

    private static JSONObject d(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public String getAnalyticInfo() {
        return this.f30378a.getString(RemoteMessageConst.ANALYTIC_INFO);
    }

    public Map<String, String> getAnalyticInfoMap() {
        HashMap hashMap = new HashMap();
        String string = this.f30378a.getString(RemoteMessageConst.ANALYTIC_INFO);
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get analyticInfo from map failed.");
            }
        }
        return hashMap;
    }

    public String getCollapseKey() {
        return this.f30378a.getString(RemoteMessageConst.COLLAPSE_KEY);
    }

    public String getData() {
        return this.f30378a.getString("data");
    }

    public Map<String, String> getDataOfMap() {
        HashMap hashMap = new HashMap();
        String string = this.f30378a.getString("data");
        if (string != null && !string.trim().isEmpty()) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String valueOf = String.valueOf(keys.next());
                    hashMap.put(valueOf, String.valueOf(jSONObject.get(valueOf)));
                }
            } catch (JSONException unused) {
                HMSLog.w("RemoteMessage", "JSONException: get data from map failed");
            }
        }
        return hashMap;
    }

    public String getFrom() {
        return this.f30378a.getString(RemoteMessageConst.FROM);
    }

    public String getMessageId() {
        return this.f30378a.getString(RemoteMessageConst.MSGID);
    }

    public String getMessageType() {
        return this.f30378a.getString(RemoteMessageConst.MSGTYPE);
    }

    public Notification getNotification() {
        Bundle bundle = this.f30378a.getBundle("notification");
        a aVar = null;
        if (this.f30379b == null && bundle != null) {
            this.f30379b = new Notification(bundle, aVar);
        }
        if (this.f30379b == null) {
            this.f30379b = new Notification(new Bundle(), aVar);
        }
        return this.f30379b;
    }

    public int getOriginalUrgency() {
        int i10 = this.f30378a.getInt(RemoteMessageConst.ORI_URGENCY);
        if (i10 == 1 || i10 == 2) {
            return i10;
        }
        return 0;
    }

    public int getReceiptMode() {
        return this.f30378a.getInt(RemoteMessageConst.RECEIPT_MODE);
    }

    public int getSendMode() {
        return this.f30378a.getInt(RemoteMessageConst.SEND_MODE);
    }

    public long getSentTime() {
        try {
            String string = this.f30378a.getString(RemoteMessageConst.SEND_TIME);
            if (TextUtils.isEmpty(string)) {
                return 0L;
            }
            return Long.parseLong(string);
        } catch (NumberFormatException unused) {
            HMSLog.w("RemoteMessage", "NumberFormatException: get sendTime error.");
            return 0L;
        }
    }

    public String getTo() {
        return this.f30378a.getString(RemoteMessageConst.TO);
    }

    public String getToken() {
        return this.f30378a.getString(RemoteMessageConst.DEVICE_TOKEN);
    }

    public int getTtl() {
        return this.f30378a.getInt(RemoteMessageConst.TTL);
    }

    public int getUrgency() {
        int i10 = this.f30378a.getInt("urgency");
        if (i10 == 1 || i10 == 2) {
            return i10;
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeBundle(this.f30378a);
        parcel.writeSerializable(this.f30379b);
    }

    public RemoteMessage(Parcel parcel) {
        this.f30378a = parcel.readBundle();
        this.f30379b = (Notification) parcel.readSerializable();
    }

    private static JSONObject b(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.NOTIFY_DETAIL);
        }
        return null;
    }

    private Bundle a(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, JSONObject jSONObject5) {
        Bundle bundle = new Bundle();
        JsonUtil.transferJsonObjectToBundle(jSONObject3, bundle, f30374g);
        JsonUtil.transferJsonObjectToBundle(jSONObject4, bundle, f30375h);
        JsonUtil.transferJsonObjectToBundle(jSONObject, bundle, f30376i);
        JsonUtil.transferJsonObjectToBundle(jSONObject5, bundle, f30377j);
        bundle.putInt(RemoteMessageConst.Notification.NOTIFY_ID, JsonUtil.getInt(jSONObject2, RemoteMessageConst.Notification.NOTIFY_ID, 0));
        return bundle;
    }

    private static JSONObject a(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
        }
        return null;
    }
}
