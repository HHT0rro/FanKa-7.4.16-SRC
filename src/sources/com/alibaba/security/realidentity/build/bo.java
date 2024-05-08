package com.alibaba.security.realidentity.build;

import com.alibaba.security.biometrics.service.model.result.SensorInfo;
import com.alibaba.security.biometrics.service.sensor.SensorGetter;
import com.alibaba.security.common.utils.JsonUtils;

/* compiled from: GetSensorInfoApi.java */
@aw(a = "rpGetSensor")
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class bo extends aq {
    private static final String ao = "bo";

    @Override // com.alibaba.security.realidentity.build.aq
    public final String a() {
        return "rpGetSensor";
    }

    @Override // com.alibaba.security.realidentity.build.aq
    public final boolean a(String str, final ay ayVar) {
        SensorGetter.getDefault().collectLightSensorInfo(new SensorGetter.SensorCallback() { // from class: com.alibaba.security.realidentity.build.bo.1
            @Override // com.alibaba.security.biometrics.service.sensor.SensorGetter.SensorCallback
            public final void onGetSensorValue(float f10) {
                SensorInfo sensorInfo = new SensorInfo(f10);
                bf bfVar = new bf();
                bfVar.a(aq.f3102ab, JsonUtils.toJSON(sensorInfo));
                bfVar.f3165a = 1;
                ayVar.b(bfVar);
                bo.this.a(bfVar, true);
            }
        });
        return true;
    }
}
