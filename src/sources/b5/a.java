package b5;

import com.google.android.exoplayer2.util.j0;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ClearKeyUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public final class a {
    public static byte[] a(byte[] bArr) {
        return j0.f22990a >= 27 ? bArr : j0.i0(c(j0.E(bArr)));
    }

    public static byte[] b(byte[] bArr) {
        if (j0.f22990a >= 27) {
            return bArr;
        }
        try {
            JSONObject jSONObject = new JSONObject(j0.E(bArr));
            StringBuilder sb2 = new StringBuilder("{\"keys\":[");
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i10 = 0; i10 < jSONArray.length(); i10++) {
                if (i10 != 0) {
                    sb2.append(",");
                }
                JSONObject jSONObject2 = jSONArray.getJSONObject(i10);
                sb2.append("{\"k\":\"");
                sb2.append(d(jSONObject2.getString("k")));
                sb2.append("\",\"kid\":\"");
                sb2.append(d(jSONObject2.getString("kid")));
                sb2.append("\",\"kty\":\"");
                sb2.append(jSONObject2.getString("kty"));
                sb2.append("\"}");
            }
            sb2.append("]}");
            return j0.i0(sb2.toString());
        } catch (JSONException e2) {
            String valueOf = String.valueOf(j0.E(bArr));
            com.google.android.exoplayer2.util.m.d("ClearKeyUtil", valueOf.length() != 0 ? "Failed to adjust response data: ".concat(valueOf) : new String("Failed to adjust response data: "), e2);
            return bArr;
        }
    }

    public static String c(String str) {
        return str.replace('+', '-').replace(IOUtils.DIR_SEPARATOR_UNIX, '_');
    }

    public static String d(String str) {
        return str.replace('-', '+').replace('_', IOUtils.DIR_SEPARATOR_UNIX);
    }
}
