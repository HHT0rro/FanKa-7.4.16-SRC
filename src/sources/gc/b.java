package gc;

import com.huawei.appgallery.agd.core.impl.report.MaintKey;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class b extends d {

    /* renamed from: h, reason: collision with root package name */
    public String f49441h;

    /* renamed from: i, reason: collision with root package name */
    public int f49442i;

    /* renamed from: j, reason: collision with root package name */
    public long f49443j;

    /* renamed from: k, reason: collision with root package name */
    public String f49444k;

    @Override // gc.d
    public JSONObject c() {
        try {
            JSONObject c4 = super.c();
            if (c4 == null) {
                return null;
            }
            c4.put("eventId", this.f49441h);
            c4.put(MaintKey.EVENT_TYPE, this.f49442i);
            c4.put("eventTime", this.f49443j);
            String str = this.f49444k;
            if (str == null) {
                str = "";
            }
            c4.put("eventContent", str);
            return c4;
        } catch (JSONException e2) {
            fc.c.k(e2);
            return null;
        }
    }

    @Override // gc.d
    public String d() {
        return super.d();
    }
}
