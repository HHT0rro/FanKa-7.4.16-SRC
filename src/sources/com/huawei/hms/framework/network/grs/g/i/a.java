package com.huawei.hms.framework.network.grs.g.i;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.g.j.d;
import com.huawei.hms.framework.network.grs.h.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f30027a = "a";

    /* renamed from: b, reason: collision with root package name */
    private static d f30028b;

    /* renamed from: c, reason: collision with root package name */
    private static final Object f30029c = new Object();

    public static synchronized d a(Context context) {
        synchronized (a.class) {
            synchronized (f30029c) {
                d dVar = f30028b;
                if (dVar != null) {
                    return dVar;
                }
                String a10 = c.a(GrsApp.getInstance().getBrand("/") + "grs_sdk_server_config.json", context);
                ArrayList arrayList = null;
                if (TextUtils.isEmpty(a10)) {
                    return null;
                }
                try {
                    JSONObject jSONObject = new JSONObject(a10).getJSONObject("grs_server");
                    JSONArray jSONArray = jSONObject.getJSONArray("grs_base_url");
                    if (jSONArray != null && jSONArray.length() > 0) {
                        arrayList = new ArrayList();
                        for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                            arrayList.add(jSONArray.get(i10).toString());
                        }
                    }
                    d dVar2 = new d();
                    f30028b = dVar2;
                    dVar2.a(arrayList);
                    f30028b.a(jSONObject.getString("grs_query_endpoint_2.0"));
                    f30028b.a(jSONObject.getInt("grs_query_timeout"));
                } catch (JSONException e2) {
                    Logger.w(f30027a, "getGrsServerBean catch JSONException: %s", StringUtils.anonymizeMessage(e2.getMessage()));
                }
                return f30028b;
            }
        }
    }
}
