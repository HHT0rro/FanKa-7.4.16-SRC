package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.t;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class DiskInfo implements b, Serializable {
    private static final long serialVersionUID = -154725647775465930L;
    public double mDataAvailableGB;
    public double mDataTotalGB;
    public double mExternalStorageAvailableGB;
    public double mExternalStorageTotalGB;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mDataTotalGB = jSONObject.optDouble("mDataTotalGB");
        this.mDataAvailableGB = jSONObject.optDouble("mDataAvailableGB");
        this.mExternalStorageTotalGB = jSONObject.optDouble("mExternalStorageTotalGB");
        this.mExternalStorageAvailableGB = jSONObject.optDouble("mExternalStorageAvailableGB");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "mDataTotalGB", this.mDataTotalGB);
        t.putValue(jSONObject, "mDataAvailableGB", this.mDataAvailableGB);
        t.putValue(jSONObject, "mExternalStorageTotalGB", this.mExternalStorageTotalGB);
        t.putValue(jSONObject, "mExternalStorageAvailableGB", this.mExternalStorageAvailableGB);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("\t总存储空间: ");
        sb2.append(this.mDataTotalGB);
        sb2.append(" (GB)\n\t可用存储空间: ");
        sb2.append(this.mDataAvailableGB);
        sb2.append(" (GB)\n\t总SD卡空间: ");
        sb2.append(this.mExternalStorageTotalGB);
        sb2.append(" (GB)\n\t可用SD卡空间: ");
        sb2.append(this.mExternalStorageAvailableGB);
        sb2.append(" (GB)\n");
        return sb2.substring(0);
    }
}
