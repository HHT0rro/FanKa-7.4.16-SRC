package com.xiaomi.push;

import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q4 {

    /* renamed from: a, reason: collision with root package name */
    public XmlPullParser f48099a;

    public q4() {
        try {
            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
            this.f48099a = newPullParser;
            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
        } catch (XmlPullParserException unused) {
        }
    }

    public k5 a(byte[] bArr, u4 u4Var) {
        String name;
        String str;
        this.f48099a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
        this.f48099a.next();
        int eventType = this.f48099a.getEventType();
        String name2 = this.f48099a.getName();
        if (eventType != 2) {
            return null;
        }
        if (name2.equals("message")) {
            return r5.c(this.f48099a);
        }
        if (name2.equals("iq")) {
            return r5.b(this.f48099a, u4Var);
        }
        if (name2.equals("presence")) {
            return r5.d(this.f48099a);
        }
        if (this.f48099a.getName().equals("stream")) {
            return null;
        }
        if (this.f48099a.getName().equals("error")) {
            throw new gh(r5.e(this.f48099a));
        }
        if (this.f48099a.getName().equals("warning")) {
            this.f48099a.next();
            name = this.f48099a.getName();
            str = "multi-login";
        } else {
            name = this.f48099a.getName();
            str = "bind";
        }
        name.equals(str);
        return null;
    }
}
