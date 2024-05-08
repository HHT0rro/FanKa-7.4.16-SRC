package d0;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import org.json.JSONObject;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public File f48601a;

    /* renamed from: b, reason: collision with root package name */
    public g0.a f48602b;

    public b(String str, g0.a aVar) {
        this.f48601a = null;
        this.f48602b = null;
        this.f48601a = new File(str);
        this.f48602b = aVar;
    }

    public static String a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "id");
            jSONObject.put("error", str);
            return jSONObject.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public final void b() {
        new Thread(new c(this)).start();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void d() {
        File file = this.f48601a;
        if (file == null) {
            return;
        }
        if (file.exists() && this.f48601a.isDirectory() && this.f48601a.list().length != 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f48601a.list()) {
                arrayList.add(str);
            }
            Collections.sort(arrayList);
            String str2 = (String) arrayList.get(arrayList.size() - 1);
            int size = arrayList.size();
            if (str2.equals(new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".log")) {
                if (arrayList.size() < 2) {
                    return;
                }
                str2 = (String) arrayList.get(arrayList.size() - 2);
                size--;
            }
            if (!this.f48602b.a(a(z.b.a(this.f48601a.getAbsolutePath(), str2)))) {
                size--;
            }
            for (int i10 = 0; i10 < size; i10++) {
                new File(this.f48601a, (String) arrayList.get(i10)).delete();
            }
        }
    }
}
