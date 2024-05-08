package com.jd.ad.sdk.jad_na;

import androidx.annotation.NonNull;
import com.jd.ad.sdk.logger.Logger;
import com.kuaishou.weapon.p0.t;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ANPlacement.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class jad_er {
    public String jad_an;
    public int jad_bo;
    public int jad_cp;
    public int jad_dq;
    public int jad_er;
    public List<Integer> jad_fs;
    public int jad_hu;
    public int jad_jt;

    public JSONObject jad_an() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("ak", this.jad_an);
            jSONObject.putOpt("t", Integer.valueOf(this.jad_bo));
            jSONObject.putOpt("m", Integer.valueOf(this.jad_cp));
            jSONObject.putOpt("bs", Integer.valueOf(this.jad_dq));
            jSONObject.putOpt(Segment.JsonKey.START, Integer.valueOf(this.jad_er));
            JSONArray jSONArray = new JSONArray();
            List<Integer> list = this.jad_fs;
            if (list != null && list.size() > 0) {
                for (int i10 = 0; i10 < this.jad_fs.size(); i10++) {
                    jSONArray.put(this.jad_fs.get(i10));
                }
            }
            jSONObject.putOpt("tmp", jSONArray);
            jSONObject.putOpt("ds", Integer.valueOf(this.jad_jt));
            jSONObject.putOpt(t.f36226k, Integer.valueOf(this.jad_hu));
        } catch (Exception e2) {
            StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("an placement ");
            jad_an.append(e2.getMessage());
            Logger.d(jad_an.toString());
        }
        return jSONObject;
    }

    @NonNull
    public String toString() {
        StringBuilder jad_an = com.jd.ad.sdk.jad_bo.jad_bo.jad_an("ANPlacement{ak='");
        jad_an.append(this.jad_an);
        jad_an.append('\'');
        jad_an.append(", t=");
        jad_an.append(this.jad_bo);
        jad_an.append(", m=");
        jad_an.append(this.jad_cp);
        jad_an.append(", bs=");
        jad_an.append(this.jad_dq);
        jad_an.append(", st=");
        jad_an.append(this.jad_er);
        jad_an.append(", tmp=");
        jad_an.append((Object) this.jad_fs);
        jad_an.append(", ds=");
        jad_an.append(this.jad_jt);
        jad_an.append(", r=");
        jad_an.append(this.jad_hu);
        jad_an.append('}');
        return jad_an.toString();
    }
}
