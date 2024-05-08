package com.kwad.sdk.i;

import androidx.annotation.NonNull;
import java.util.Iterator;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class k implements b {
    public JSONObject aJt = new JSONObject();
    public String actionId = UUID.randomUUID().toString();

    public k(String str, String str2, i iVar) {
        JSONObject IY = h.Jc().Jg().IY();
        Iterator<String> keys = IY.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            c.a(IY, next, IY.opt(next));
        }
        c.putValue(this.aJt, "customKey", str);
        c.putValue(this.aJt, "customValue", str2);
        c.putValue(this.aJt, "timestamp", iVar.aJq);
        c.putValue(this.aJt, "actionId", this.actionId);
    }

    @Override // com.kwad.sdk.i.b
    public final JSONObject toJson() {
        return this.aJt;
    }

    @NonNull
    public final String toString() {
        return this.aJt.toString();
    }
}
