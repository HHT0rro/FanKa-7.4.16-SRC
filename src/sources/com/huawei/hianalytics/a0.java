package com.huawei.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.bk;
import com.huawei.hianalytics.core.crypto.AesCipher;
import com.huawei.hianalytics.core.crypto.HexUtil;
import com.huawei.hianalytics.core.log.HiLog;
import com.huawei.hianalytics.core.storage.CommonHeaderEx;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.framework.constant.FrameworkConstant;
import com.huawei.hianalytics.framework.datahandler.ReportTask;
import com.huawei.hianalytics.framework.threadpool.TaskThread;
import com.huawei.hianalytics.util.DeviceUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a0 implements Runnable {
    public String ijk;
    public Context lmn;
    public List<Event> klm = new ArrayList();
    public List<CommonHeaderEx> ikl = new ArrayList();

    public a0(Context context, String str) {
        this.lmn = context;
        this.ijk = str;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:18|(3:20|(1:31)(3:22|23|(1:30)(3:25|26|(1:28)))|29)|32|33|35|29|16) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0086, code lost:
    
        com.huawei.hianalytics.core.log.HiLog.e("InitDataSupport", "cache data is not json format");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void lmn(java.lang.String r7) {
        /*
            r6 = this;
            android.content.Context r0 = r6.lmn
            long r0 = com.huawei.hianalytics.j0.ikl(r0, r7)
            r2 = -1
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto Ld
            return
        Ld:
            r2 = 5242880(0x500000, double:2.590327E-317)
            java.lang.String r4 = "InitDataSupport"
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 <= 0) goto L29
            java.lang.String r0 = "sp stat file length > 5M,begin delete it"
            com.huawei.hianalytics.core.log.HiLog.i(r4, r0)
            android.content.Context r0 = r6.lmn
            boolean r7 = com.huawei.hianalytics.j0.lmn(r0, r7)
            if (r7 == 0) goto L28
            java.lang.String r7 = "sp stat file delete success"
            com.huawei.hianalytics.core.log.HiLog.i(r4, r7)
        L28:
            return
        L29:
            android.content.SharedPreferences r0 = com.huawei.hianalytics.j0.lmn(r7)
            java.util.Map r0 = r0.getAll()
            android.content.Context r1 = r6.lmn
            com.huawei.hianalytics.j0.lmn(r1, r7)
            int r1 = r0.size()
            if (r1 != 0) goto L3d
            return
        L3d:
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator2()
        L45:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L8c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "_default_config_tag"
            boolean r5 = r3.equals(r2)
            if (r5 == 0) goto L60
            goto L7e
        L60:
            java.lang.String r3 = "-"
            java.lang.String[] r2 = r2.split(r3)
            int r3 = r2.length
            r5 = 2
            if (r3 == r5) goto L6b
            goto L45
        L6b:
            r3 = 0
            r3 = r2[r3]
            r5 = 1
            r2 = r2[r5]
            boolean r5 = android.text.TextUtils.isEmpty(r3)
            if (r5 != 0) goto L45
            boolean r2 = android.text.TextUtils.isEmpty(r2)
            if (r2 == 0) goto L7e
            goto L45
        L7e:
            java.lang.Object r1 = r1.getValue()     // Catch: org.json.JSONException -> L86
            r6.lmn(r3, r1, r7)     // Catch: org.json.JSONException -> L86
            goto L45
        L86:
            java.lang.String r1 = "cache data is not json format"
            com.huawei.hianalytics.core.log.HiLog.e(r4, r1)
            goto L45
        L8c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hianalytics.a0.lmn(java.lang.String):void");
    }

    @Override // java.lang.Runnable
    public void run() {
        String lmn = j0.lmn("global_v2", "upload_url", "");
        long lmn2 = j0.lmn("global_v2", "upload_url_time", 0L);
        long currentTimeMillis = System.currentTimeMillis();
        if (!TextUtils.isEmpty(lmn) && currentTimeMillis - lmn2 <= 86400000) {
            try {
                JSONArray jSONArray = new JSONArray(lmn);
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i10 = 0; i10 < length; i10++) {
                    String optString = jSONArray.optString(i10, "");
                    if (k0.lmn(optString)) {
                        strArr[i10] = FrameworkConstant.HttpUrls.PREINS_DATA_UPLOAD_URL.replace(FrameworkConstant.URL_PALCEHOLDER, optString);
                    }
                }
                u.lmn().lmn("preload_url_tag", strArr);
                e eVar = c.klm().lmn;
                Objects.requireNonNull(eVar);
                eVar.f28749f = (String[]) strArr.clone();
                c.klm().lmn.bcd = false;
            } catch (JSONException unused) {
                HiLog.e("InitDataSupport", "cache pre url is error,need retrieve upload url");
                c.klm().lmn.bcd = true;
            }
        } else {
            c.klm().lmn.bcd = true;
        }
        if (j0.lmn("global_v2", "v2_1DataHandlerFlag", false)) {
            StringBuilder b4 = e9.a.b("cached data by HASDKV2 has already handled.TAG: ");
            b4.append(this.ijk);
            HiLog.i("InitDataSupport", b4.toString());
        } else {
            HiLog.i("InitDataSupport", "handler historical data...");
            lmn("stat_v2_1");
            lmn("cached_v2_1");
            long ikl = j0.ikl(this.lmn, "common_nc");
            if (ikl != -1) {
                if (ikl > 5242880) {
                    HiLog.i("InitDataSupport", "sp stat file length > 5M,begin delete it");
                    if (j0.lmn(this.lmn, "common_nc")) {
                        HiLog.i("InitDataSupport", "sp stat file delete success");
                    }
                } else {
                    Map<String, ?> all = j0.lmn("common_nc").getAll();
                    j0.lmn(this.lmn, "common_nc");
                    if (all.size() != 0) {
                        for (Map.Entry<String, ?> entry : all.entrySet()) {
                            String key = entry.getKey();
                            if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty((String) entry.getValue())) {
                                CommonHeaderEx commonHeaderEx = new CommonHeaderEx();
                                commonHeaderEx.setEvtExHashCode(key);
                                commonHeaderEx.setCommonHeaderEx((String) entry.getValue());
                                this.ikl.add(commonHeaderEx);
                            }
                        }
                    }
                }
            }
            j0.lmn(this.lmn, "backup_event");
            if (this.klm.size() > 0) {
                HiLog.i("InitDataSupport", "insert events...");
                f lmn3 = f.lmn(this.lmn);
                lmn3.lmn.getEventDao().insertInTx(this.klm);
            }
            if (this.ikl.size() > 0) {
                HiLog.i("InitDataSupport", "insert common nc...");
                f lmn4 = f.lmn(this.lmn);
                lmn4.lmn.getCommonHeaderExDao().insertInTx(this.ikl);
            }
            j0.klm("global_v2", "v2_1DataHandlerFlag", true);
        }
        String str = c.klm().lmn.cde;
        String str2 = c.klm().lmn.def;
        if (TextUtils.isEmpty(str)) {
            StringBuilder b10 = e9.a.b("app ver is first save!TAG: ");
            b10.append(this.ijk);
            HiLog.i("InitDataSupport", b10.toString());
        } else {
            if (str.equals(str2)) {
                return;
            }
            StringBuilder b11 = e9.a.b("the appVers are different!TAG: ");
            b11.append(this.ijk);
            HiLog.i("InitDataSupport", b11.toString());
            if (TextUtils.isEmpty(DeviceUtil.getNetworkType(c.klm().lmn.f28748e))) {
                e9.a.e(e9.a.b("The network is unavailable.TAG: "), this.ijk, "InitDataSupport");
            } else {
                TaskThread.getUpdateThread().addToQueue(new ReportTask("", "", new b0(), str));
            }
        }
    }

    public final void lmn(String str, Object obj, String str2) {
        String optString;
        String str3;
        if (obj instanceof String) {
            JSONArray jSONArray = new JSONArray((String) obj);
            int length = jSONArray.length();
            if (length > 5000) {
                HiLog.w("InitDataSupport", "migratingData(): array size is too long");
                return;
            }
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i10);
                if (System.currentTimeMillis() - Long.parseLong(jSONObject.getString("eventtime")) <= bk.f9895d) {
                    if ("stat_v2_1".equals(str2)) {
                        optString = jSONObject.optString("content");
                    } else {
                        optString = jSONObject.optString("properties");
                    }
                    String decryptCbc = AesCipher.decryptCbc(optString, q.lmn().klm());
                    if (TextUtils.isEmpty(decryptCbc)) {
                        HiLog.i("InitDataSupport", "decryptCbc content is empty");
                        str3 = "";
                    } else {
                        String initRandomKey = HexUtil.initRandomKey(12);
                        str3 = initRandomKey + sa.b.f(decryptCbc, q.lmn().klm(), initRandomKey);
                    }
                    if (TextUtils.isEmpty(str3)) {
                        HiLog.i("InitDataSupport", "content is empty");
                    } else {
                        Event event = new Event();
                        event.formJson(jSONObject);
                        event.setServicetag(str);
                        event.setContent(str3);
                        event.setProcessname(d.klm());
                        this.klm.add(event);
                    }
                }
            }
        }
    }
}
