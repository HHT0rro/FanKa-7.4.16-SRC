package com.huawei.hianalytics;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.huawei.hianalytics.core.storage.Event;
import com.huawei.hianalytics.framework.config.DeviceAttributeCollector;
import com.huawei.hianalytics.framework.config.EvtHeaderAttributeCollector;
import com.huawei.hianalytics.framework.config.ICollectorConfig;
import com.huawei.hianalytics.framework.config.ReportManager;
import com.huawei.hianalytics.framework.config.RomAttributeCollector;
import com.huawei.hianalytics.framework.config.ServerAddrGetTask;
import com.huawei.hianalytics.util.DeviceUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class fgh implements ICollectorConfig {
    public e klm = c.klm().lmn();
    public String lmn;

    public fgh(String str) {
        this.lmn = str;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public String getAppId() {
        z lmn = c.klm().lmn(this.lmn);
        String str = lmn != null ? lmn.hij : "";
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        e eVar = this.klm;
        if (TextUtils.isEmpty(eVar.fgh)) {
            return eVar.ghi;
        }
        return eVar.fgh;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public String[] getCollectUrls(String str) {
        String[] strArr = new String[1];
        w lmn = d.lmn(this.lmn, str);
        strArr[0] = lmn != null ? lmn.hij : "";
        return strArr;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public DeviceAttributeCollector getDeviceAttribute(String str) {
        return new efg(this.lmn, str);
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public EvtHeaderAttributeCollector getEvtCustomHeader(String str, JSONObject jSONObject) {
        return new def(jSONObject);
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public Map<String, String> getHttpHeader(String str) {
        HashMap hashMap = new HashMap();
        w lmn = d.lmn(this.lmn, str);
        Map<String, String> map = lmn != null ? lmn.f28847a : null;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return hashMap;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public ReportManager getReportManager() {
        return u.lmn();
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public RomAttributeCollector getRomAttribute(String str, String str2) {
        Pair<String, String> pair;
        w lmn;
        abc abcVar = new abc();
        String str3 = this.klm.lmn;
        if (TextUtils.isEmpty(str3)) {
            str3 = DeviceUtil.getEmuiVersion();
            this.klm.lmn = str3;
        }
        e eVar = this.klm;
        int i10 = eVar.f28757n;
        int i11 = eVar.f28758o;
        if (i11 == 0 || i10 == 0) {
            DisplayMetrics displayMetrics = eVar.f28748e.getResources().getDisplayMetrics();
            i10 = displayMetrics.heightPixels;
            i11 = displayMetrics.widthPixels;
            e eVar2 = this.klm;
            eVar2.f28757n = i10;
            eVar2.f28758o = i11;
        }
        m lmn2 = m.lmn();
        String str4 = this.lmn;
        Objects.requireNonNull(lmn2);
        z lmn3 = c.klm().lmn(str4);
        if ((lmn3 == null || (lmn = lmn3.lmn(str)) == null) ? false : lmn.klm) {
            String str5 = c.klm().lmn.f28744a;
            String str6 = c.klm().lmn.f28745b;
            if (!TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str6)) {
                pair = new Pair<>(str5, str6);
            } else {
                pair = l.ikl(lmn2.lmn);
                c.klm().lmn.f28744a = (String) pair.first;
                c.klm().lmn.f28745b = (String) pair.second;
            }
        } else {
            pair = new Pair<>("", "");
        }
        z lmn4 = c.klm().lmn(this.lmn);
        String str7 = lmn4 != null ? lmn4.def : "";
        if (TextUtils.isEmpty(str7)) {
            abcVar.def = "";
        } else {
            abcVar.def = str7;
        }
        abcVar.lmn = DeviceUtil.getSystemRomVer();
        if (TextUtils.isEmpty(str2)) {
            str2 = this.klm.def;
        }
        abcVar.hij = str2;
        abcVar.klm = str3;
        abcVar.efg = "hianalytics";
        abcVar.ghi = "3.0.1.501";
        abcVar.ikl = Build.MODEL;
        abcVar.ijk = this.klm.ghi;
        abcVar.fgh = o.klm(m.lmn().lmn, this.lmn, str);
        w lmn5 = d.lmn(this.lmn, str);
        String str8 = lmn5 != null ? lmn5.fgh : "";
        if (TextUtils.isEmpty(str8)) {
            abcVar.abc = "";
        } else {
            abcVar.abc = str8;
        }
        abcVar.f28733f = (String) pair.first;
        abcVar.f28734g = (String) pair.second;
        z lmn6 = c.klm().lmn(this.lmn);
        String str9 = lmn6 != null ? lmn6.ghi : "";
        if (TextUtils.isEmpty(str9)) {
            abcVar.cde = "";
        } else {
            abcVar.cde = str9;
        }
        z lmn7 = c.klm().lmn(this.lmn);
        String str10 = lmn7 != null ? lmn7.fgh : "";
        if (TextUtils.isEmpty(str10)) {
            abcVar.bcd = "";
        } else {
            abcVar.bcd = str10;
        }
        abcVar.f28728a = "android";
        abcVar.f28729b = Build.VERSION.RELEASE;
        abcVar.f28730c = i10;
        abcVar.f28731d = i11;
        DeviceUtil.getNetworkType(d.lmn());
        abcVar.f28732e = DeviceUtil.getLang(d.lmn());
        return abcVar;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public ServerAddrGetTask getServerAddrGetTask() {
        return new c0();
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public Event getSpecialEvent(String str) {
        return null;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public boolean isEnableSession(String str) {
        w lmn = d.lmn(this.lmn, str);
        if (lmn != null) {
            return lmn.ikl;
        }
        return false;
    }

    @Override // com.huawei.hianalytics.framework.config.ICollectorConfig
    public boolean isEncrypted(String str) {
        w lmn = d.lmn(this.lmn, str);
        if (lmn != null) {
            return lmn.f28851e;
        }
        return true;
    }
}
