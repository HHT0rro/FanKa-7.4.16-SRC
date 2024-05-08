package v8;

import com.heytap.msp.push.mode.BaseMode;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public class a extends BaseMode {

    /* renamed from: a, reason: collision with root package name */
    public String f54051a;

    /* renamed from: b, reason: collision with root package name */
    public String f54052b;

    /* renamed from: c, reason: collision with root package name */
    public String f54053c;

    /* renamed from: d, reason: collision with root package name */
    public String f54054d;

    /* renamed from: e, reason: collision with root package name */
    public int f54055e;

    /* renamed from: f, reason: collision with root package name */
    public String f54056f;

    /* renamed from: g, reason: collision with root package name */
    public int f54057g = -2;

    /* renamed from: h, reason: collision with root package name */
    public String f54058h;

    public static <T> String a(List<T> list) {
        StringBuilder sb2 = new StringBuilder();
        Iterator<T> iterator2 = list.iterator2();
        while (iterator2.hasNext()) {
            sb2.append((Object) iterator2.next());
            sb2.append("&");
        }
        return sb2.toString();
    }

    public void b(int i10) {
        this.f54055e = i10;
    }

    public void c(String str) {
        this.f54051a = str;
    }

    public void d(int i10) {
        this.f54057g = i10;
    }

    public void e(String str) {
        this.f54052b = str;
    }

    public int f() {
        return this.f54055e;
    }

    public void g(String str) {
        this.f54056f = str;
    }

    @Override // com.heytap.msp.push.mode.BaseMode
    public int getType() {
        return 4105;
    }

    public String h() {
        return this.f54056f;
    }

    public void i(String str) {
        this.f54058h = str;
    }

    public int j() {
        return this.f54057g;
    }

    public String toString() {
        return "CallBackResult{, mRegisterID='" + this.f54053c + "', mSdkVersion='" + this.f54054d + "', mCommand=" + this.f54055e + "', mContent='" + this.f54056f + "', mAppPackage=" + this.f54058h + "', mResponseCode=" + this.f54057g + '}';
    }
}
