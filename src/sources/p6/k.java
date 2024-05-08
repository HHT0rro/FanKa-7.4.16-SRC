package p6;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ContentMetadataMutations.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public final Map<String, Object> f52898a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f52899b = new ArrayList();

    public static k g(k kVar, long j10) {
        return kVar.e("exo_len", j10);
    }

    public static k h(k kVar, @Nullable Uri uri) {
        if (uri == null) {
            return kVar.d("exo_redir");
        }
        return kVar.f("exo_redir", uri.toString());
    }

    public final k a(String str, Object obj) {
        this.f52898a.put((String) com.google.android.exoplayer2.util.a.e(str), com.google.android.exoplayer2.util.a.e(obj));
        this.f52899b.remove(str);
        return this;
    }

    public Map<String, Object> b() {
        HashMap hashMap = new HashMap(this.f52898a);
        for (Map.Entry entry : hashMap.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                entry.setValue(Arrays.copyOf(bArr, bArr.length));
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public List<String> c() {
        return Collections.unmodifiableList(new ArrayList(this.f52899b));
    }

    public k d(String str) {
        this.f52899b.add(str);
        this.f52898a.remove(str);
        return this;
    }

    public k e(String str, long j10) {
        return a(str, Long.valueOf(j10));
    }

    public k f(String str, String str2) {
        return a(str, str2);
    }
}
