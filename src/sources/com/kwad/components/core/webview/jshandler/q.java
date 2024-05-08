package com.kwad.components.core.webview.jshandler;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.quickcard.base.Attributes;
import com.kwad.sdk.utils.ba;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class q implements SensorEventListener, com.kwad.sdk.core.webview.c.a {
    private Map<Integer, com.kwad.sdk.core.webview.c.c> Wi = new ConcurrentHashMap();

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public int Wl;
        public ArrayList<Float> Wm;
        public int accuracy;
        public long timestamp;
        public int type;

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final void parseJson(@Nullable JSONObject jSONObject) {
            if (jSONObject == null) {
                return;
            }
            this.type = jSONObject.optInt("type");
            this.Wl = jSONObject.optInt(Attributes.Style.INTERVAL);
            this.timestamp = jSONObject.optLong("timestamp");
            this.accuracy = jSONObject.optInt("accuracy");
            JSONArray optJSONArray = jSONObject.optJSONArray("values");
            ArrayList<Float> arrayList = new ArrayList<>();
            if (optJSONArray == null) {
                this.Wm = arrayList;
                return;
            }
            for (int i10 = 0; i10 < optJSONArray.length(); i10++) {
                try {
                    Object obj = optJSONArray.get(i10);
                    if (obj != null) {
                        arrayList.add((Float) obj);
                    }
                } catch (Throwable unused) {
                }
            }
            this.Wm = arrayList;
        }

        @Override // com.kwad.sdk.core.response.a.a, com.kwad.sdk.core.b
        public final JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            int i10 = this.type;
            if (i10 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "type", i10);
            }
            int i11 = this.Wl;
            if (i11 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, Attributes.Style.INTERVAL, i11);
            }
            long j10 = this.timestamp;
            if (j10 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "timestamp", j10);
            }
            int i12 = this.accuracy;
            if (i12 != 0) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "accuracy", i12);
            }
            if (!this.Wm.isEmpty()) {
                com.kwad.sdk.utils.t.putValue(jSONObject, "values", this.Wm);
            }
            return jSONObject;
        }
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        if (!TextUtils.isEmpty(str)) {
            a aVar = new a();
            try {
                aVar.parseJson(new JSONObject(str));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            this.Wi.put(Integer.valueOf(aVar.type), cVar);
            a(aVar.type, aVar.Wl, cVar);
            return;
        }
        cVar.onError(-1, "data is empty");
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerSensorListener";
    }

    @Override // android.hardware.SensorEventListener
    public final void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        com.kwad.sdk.utils.ba.MB().a(this);
    }

    @Override // android.hardware.SensorEventListener
    public final void onSensorChanged(SensorEvent sensorEvent) {
        a(sensorEvent);
    }

    private void a(int i10, int i11, final com.kwad.sdk.core.webview.c.c cVar) {
        com.kwad.sdk.utils.ba.MB().a(i10, i11, this, new ba.b() { // from class: com.kwad.components.core.webview.jshandler.q.1
            @Override // com.kwad.sdk.utils.ba.b
            public final void onFailed() {
                cVar.onError(-1, "sensor is not support");
            }
        });
    }

    private void a(SensorEvent sensorEvent) {
        int type = sensorEvent.sensor.getType();
        if (type == 4) {
            type = 2;
        } else if (type == 10) {
            type = 1;
        }
        com.kwad.sdk.core.webview.c.c cVar = this.Wi.get(Integer.valueOf(type));
        if (cVar == null) {
            return;
        }
        ArrayList<Float> arrayList = new ArrayList<>();
        int i10 = 0;
        while (true) {
            float[] fArr = sensorEvent.values;
            if (i10 < fArr.length) {
                arrayList.add(Float.valueOf(fArr[i10]));
                i10++;
            } else {
                a aVar = new a();
                aVar.Wm = arrayList;
                aVar.timestamp = sensorEvent.timestamp;
                aVar.accuracy = sensorEvent.accuracy;
                cVar.a(aVar);
                return;
            }
        }
    }
}
