package com.danlan.android.cognition.collector;

import android.content.Context;
import com.danlan.android.cognition.StringFog;
import com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector;
import com.danlan.android.cognition.collector.base.CollectorMap;
import com.danlan.android.cognition.collector.util.SafeJSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class TotalInfoCollector extends BaseDeviceInfoCollector {
    private Context context;

    public TotalInfoCollector(Context context, String str) {
        super(context, str);
        this.context = context;
        this.collectJsonData = new SafeJSONObject();
    }

    @Override // com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector
    public List<CollectorMap> collectors() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(CollectorMap.HARDARE);
        arrayList.add(CollectorMap.SYSTEM);
        arrayList.add(CollectorMap.NETWORK);
        arrayList.add(CollectorMap.APP);
        arrayList.add(CollectorMap.SIM);
        arrayList.add(CollectorMap.BATTERY);
        arrayList.add(CollectorMap.DISPLAY);
        arrayList.add(CollectorMap.CPU);
        arrayList.add(CollectorMap.MEMORY);
        arrayList.add(CollectorMap.CAMEAR);
        arrayList.add(CollectorMap.AUDIO);
        arrayList.add(CollectorMap.RISK);
        arrayList.add(CollectorMap.SENSOR);
        return arrayList;
    }

    @Override // com.danlan.android.cognition.collector.base.BaseDeviceInfoCollector
    public void doCollectAutomatically() {
        super.doCollectAutomatically();
    }

    public void setAdditionalData(String str, Map<String, Object> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        SafeJSONObject safeJSONObject = new SafeJSONObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                safeJSONObject.put(entry.getKey(), "");
            } else {
                safeJSONObject.put(entry.getKey(), entry.getValue());
            }
        }
        this.collectJsonData.put(str, safeJSONObject);
    }

    public void setMapData(Map<String, Object> map) {
        setAdditionalData(StringFog.decrypt("RFtQUUA="), map);
    }
}
