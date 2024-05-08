package com.huawei.flexiblelayout.css;

import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class CSSParser {
    public static CSSDefinition parse(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return null;
        }
        CSSDefinition cSSDefinition = new CSSDefinition(a.b().a());
        c.a(CSSDefinition.PAGE_LINK, jSONObject, cSSDefinition);
        return cSSDefinition;
    }
}
