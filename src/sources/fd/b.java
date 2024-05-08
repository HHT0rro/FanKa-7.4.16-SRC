package fd;

import android.util.Base64;
import androidx.annotation.NonNull;
import dalvik.system.DexClassLoader;
import java.util.Map;

/* compiled from: CpcLoader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class b extends DexClassLoader {

    /* renamed from: a, reason: collision with root package name */
    public volatile boolean f49296a;

    public b(String str, String str2, String str3, ClassLoader classLoader) {
        super(str, str2, str3, classLoader);
    }

    public void a(@NonNull Map<Class, String> map) {
        String str = new String(Base64.decode("bG9hZENsYXNz", 3));
        for (Map.Entry<Class, String> entry : map.entrySet()) {
            try {
                com.hailiang.advlib.common.b.c().a(entry.getKey(), (Class) com.hailiang.advlib.common.c.a(this).a(str, entry.getValue()).c());
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.f49296a = true;
    }

    public boolean b() {
        return this.f49296a;
    }
}
