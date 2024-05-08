package com.kwai.adclient.kscommerciallogger.snapshot;

import com.alimm.tanx.core.ad.event.track.expose.ExposeManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class c {
    private final String aUo;
    private final LinkedList<d> aUp;
    private int aUq;
    private final int aUr;
    private long aUs;

    public c(String str) {
        this(str, 10);
    }

    public final synchronized long Or() {
        return this.aUs;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.aUo.equals(((c) obj).aUo);
    }

    public final String getName() {
        return this.aUo;
    }

    public int hashCode() {
        return Objects.hash(this.aUo);
    }

    public synchronized d hn(String str) {
        d dVar;
        if (this.aUp.size() >= this.aUr) {
            this.aUp.removeFirst();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("_");
        int i10 = this.aUq;
        this.aUq = i10 + 1;
        sb2.append(i10);
        dVar = new d(sb2.toString());
        this.aUp.addLast(dVar);
        this.aUs = System.currentTimeMillis();
        return dVar;
    }

    public synchronized JSONObject ho(String str) {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator<d> it = this.aUp.iterator2();
            while (it.hasNext()) {
                jSONArray.put(it.next().Oq());
            }
            jSONObject.put(ExposeManager.UtArgsNames.sessionId, str);
            jSONObject.put("segment_name", this.aUo);
            jSONObject.put("spans", jSONArray);
            this.aUs = System.currentTimeMillis();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public c(String str, int i10) {
        this.aUo = str == null ? "" : str;
        this.aUp = new LinkedList<>();
        this.aUr = Math.min(i10, 30);
        this.aUs = System.currentTimeMillis();
    }
}
