package d0;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public String f48594a;

    /* renamed from: b, reason: collision with root package name */
    public String f48595b;

    /* renamed from: c, reason: collision with root package name */
    public String f48596c;

    /* renamed from: d, reason: collision with root package name */
    public String f48597d;

    /* renamed from: e, reason: collision with root package name */
    public String f48598e;

    /* renamed from: f, reason: collision with root package name */
    public String f48599f;

    /* renamed from: g, reason: collision with root package name */
    public String f48600g;

    public a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.f48594a = str;
        this.f48595b = str2;
        this.f48596c = str3;
        this.f48597d = str4;
        this.f48598e = str5;
        this.f48599f = str6;
        this.f48600g = str7;
    }

    public final String toString() {
        StringBuilder sb2;
        String str;
        StringBuilder sb3;
        String str2;
        StringBuilder sb4;
        String str3;
        StringBuffer stringBuffer = new StringBuffer(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(Calendar.getInstance().getTime()));
        stringBuffer.append("," + this.f48594a);
        stringBuffer.append("," + this.f48595b);
        stringBuffer.append("," + this.f48596c);
        stringBuffer.append("," + this.f48597d);
        if (z.a.d(this.f48598e) || this.f48598e.length() < 20) {
            sb2 = new StringBuilder(",");
            str = this.f48598e;
        } else {
            sb2 = new StringBuilder(",");
            str = this.f48598e.substring(0, 20);
        }
        sb2.append(str);
        stringBuffer.append(sb2.toString());
        if (z.a.d(this.f48599f) || this.f48599f.length() < 20) {
            sb3 = new StringBuilder(",");
            str2 = this.f48599f;
        } else {
            sb3 = new StringBuilder(",");
            str2 = this.f48599f.substring(0, 20);
        }
        sb3.append(str2);
        stringBuffer.append(sb3.toString());
        if (z.a.d(this.f48600g) || this.f48600g.length() < 20) {
            sb4 = new StringBuilder(",");
            str3 = this.f48600g;
        } else {
            sb4 = new StringBuilder(",");
            str3 = this.f48600g.substring(0, 20);
        }
        sb4.append(str3);
        stringBuffer.append(sb4.toString());
        return stringBuffer.toString();
    }
}
