package h;

import org.apache.commons.lang3.StringUtils;

/* compiled from: Marker.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    public final String f49483a;

    /* renamed from: b, reason: collision with root package name */
    public final float f49484b;

    /* renamed from: c, reason: collision with root package name */
    public final float f49485c;

    public f(String str, float f10, float f11) {
        this.f49483a = str;
        this.f49485c = f11;
        this.f49484b = f10;
    }

    public boolean a(String str) {
        if (this.f49483a.equalsIgnoreCase(str)) {
            return true;
        }
        if (this.f49483a.endsWith(StringUtils.CR)) {
            String str2 = this.f49483a;
            if (str2.substring(0, str2.length() - 1).equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }
}
