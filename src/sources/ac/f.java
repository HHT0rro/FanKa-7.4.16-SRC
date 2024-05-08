package ac;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {
    public static String a(String str, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            boolean z10 = true;
            for (Map.Entry<?, ?> entry : b(new JSONObject(str).toString()).entrySet()) {
                stringBuffer.append(z10 ? "" : str2);
                stringBuffer.append((String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append(entry.getValue() != null ? entry.getValue() : "");
                z10 = false;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return stringBuffer.toString();
    }

    public static TreeMap<?, ?> b(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            TreeMap<?, ?> treeMap = new TreeMap<>();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                treeMap.put(next, jSONObject.getString(next));
            }
            return treeMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
