package com.xiaomi.push;

import android.text.TextUtils;
import com.huawei.appgallery.agd.pageframe.api.CardEventType;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.gp;
import com.xiaomi.push.i5;
import com.xiaomi.push.n5;
import com.xiaomi.push.service.aq;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class r5 {

    /* renamed from: a, reason: collision with root package name */
    public static XmlPullParser f48143a;

    public static h5 a(String str, String str2, XmlPullParser xmlPullParser) {
        Object b4 = q5.a().b("all", "xm:chat");
        if (b4 == null || !(b4 instanceof kc.f0)) {
            return null;
        }
        return ((kc.f0) b4).c(xmlPullParser);
    }

    public static i5 b(XmlPullParser xmlPullParser, u4 u4Var) {
        String attributeValue = xmlPullParser.getAttributeValue("", "id");
        String attributeValue2 = xmlPullParser.getAttributeValue("", RemoteMessageConst.TO);
        String attributeValue3 = xmlPullParser.getAttributeValue("", RemoteMessageConst.FROM);
        String attributeValue4 = xmlPullParser.getAttributeValue("", "chid");
        i5.a a10 = i5.a.a(xmlPullParser.getAttributeValue("", "type"));
        HashMap hashMap = new HashMap();
        boolean z10 = false;
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            hashMap.put(attributeName, xmlPullParser.getAttributeValue("", attributeName));
        }
        i5 i5Var = null;
        n5 n5Var = null;
        while (!z10) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("error")) {
                    n5Var = f(xmlPullParser);
                } else {
                    i5Var = new i5();
                    i5Var.h(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("iq")) {
                z10 = true;
            }
        }
        if (i5Var == null) {
            if (i5.a.f47525b == a10 || i5.a.f47526c == a10) {
                s5 s5Var = new s5();
                s5Var.n(attributeValue);
                s5Var.r(attributeValue3);
                s5Var.t(attributeValue2);
                s5Var.z(i5.a.f47528e);
                s5Var.p(attributeValue4);
                s5Var.i(new n5(n5.a.f48007f));
                u4Var.j(s5Var);
                fc.c.n("iq usage error. send packet in packet parser.");
                return null;
            }
            i5Var = new t5();
        }
        i5Var.n(attributeValue);
        i5Var.r(attributeValue2);
        i5Var.p(attributeValue4);
        i5Var.t(attributeValue3);
        i5Var.z(a10);
        i5Var.i(n5Var);
        i5Var.A(hashMap);
        return i5Var;
    }

    public static k5 c(XmlPullParser xmlPullParser) {
        String str;
        boolean z10 = false;
        String str2 = null;
        if ("1".equals(xmlPullParser.getAttributeValue("", com.kuaishou.weapon.p0.t.f36222g))) {
            String attributeValue = xmlPullParser.getAttributeValue("", "chid");
            String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
            String attributeValue3 = xmlPullParser.getAttributeValue("", RemoteMessageConst.FROM);
            String attributeValue4 = xmlPullParser.getAttributeValue("", RemoteMessageConst.TO);
            String attributeValue5 = xmlPullParser.getAttributeValue("", "type");
            aq.b b4 = aq.c().b(attributeValue, attributeValue4);
            if (b4 == null) {
                b4 = aq.c().b(attributeValue, attributeValue3);
            }
            if (b4 == null) {
                throw new gh("the channel id is wrong while receiving a encrypted message");
            }
            k5 k5Var = null;
            while (!z10) {
                int next = xmlPullParser.next();
                if (next == 2) {
                    if (!com.kuaishou.weapon.p0.t.f36222g.equals(xmlPullParser.getName())) {
                        throw new gh("error while receiving a encrypted message with wrong format");
                    }
                    if (xmlPullParser.next() != 4) {
                        throw new gh("error while receiving a encrypted message with wrong format");
                    }
                    String text = xmlPullParser.getText();
                    if ("5".equals(attributeValue) || "6".equals(attributeValue)) {
                        j5 j5Var = new j5();
                        j5Var.p(attributeValue);
                        j5Var.D(true);
                        j5Var.t(attributeValue3);
                        j5Var.r(attributeValue4);
                        j5Var.n(attributeValue2);
                        j5Var.L(attributeValue5);
                        h5 h5Var = new h5(com.kuaishou.weapon.p0.t.f36222g, null, null, null);
                        h5Var.g(text);
                        j5Var.h(h5Var);
                        return j5Var;
                    }
                    h(kc.s.h(kc.s.g(b4.f48230i, attributeValue2), text));
                    f48143a.next();
                    k5Var = c(f48143a);
                } else if (next == 3 && xmlPullParser.getName().equals("message")) {
                    z10 = true;
                }
            }
            if (k5Var != null) {
                return k5Var;
            }
            throw new gh("error while receiving a encrypted message with wrong format");
        }
        j5 j5Var2 = new j5();
        String attributeValue6 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue6 == null) {
            attributeValue6 = "ID_NOT_AVAILABLE";
        }
        j5Var2.n(attributeValue6);
        j5Var2.r(xmlPullParser.getAttributeValue("", RemoteMessageConst.TO));
        j5Var2.t(xmlPullParser.getAttributeValue("", RemoteMessageConst.FROM));
        j5Var2.p(xmlPullParser.getAttributeValue("", "chid"));
        j5Var2.y(xmlPullParser.getAttributeValue("", "appid"));
        try {
            str = xmlPullParser.getAttributeValue("", "transient");
        } catch (Exception unused) {
            str = null;
        }
        try {
            String attributeValue7 = xmlPullParser.getAttributeValue("", "seq");
            if (!TextUtils.isEmpty(attributeValue7)) {
                j5Var2.C(attributeValue7);
            }
        } catch (Exception unused2) {
        }
        try {
            String attributeValue8 = xmlPullParser.getAttributeValue("", "mseq");
            if (!TextUtils.isEmpty(attributeValue8)) {
                j5Var2.F(attributeValue8);
            }
        } catch (Exception unused3) {
        }
        try {
            String attributeValue9 = xmlPullParser.getAttributeValue("", "fseq");
            if (!TextUtils.isEmpty(attributeValue9)) {
                j5Var2.H(attributeValue9);
            }
        } catch (Exception unused4) {
        }
        try {
            String attributeValue10 = xmlPullParser.getAttributeValue("", "status");
            if (!TextUtils.isEmpty(attributeValue10)) {
                j5Var2.J(attributeValue10);
            }
        } catch (Exception unused5) {
        }
        j5Var2.A(!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true"));
        j5Var2.L(xmlPullParser.getAttributeValue("", "type"));
        String i10 = i(xmlPullParser);
        if (i10 == null || "".equals(i10.trim())) {
            k5.x();
        } else {
            j5Var2.R(i10);
        }
        while (!z10) {
            int next2 = xmlPullParser.next();
            if (next2 == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (TextUtils.isEmpty(namespace)) {
                    namespace = "xm";
                }
                if (name.equals("subject")) {
                    i(xmlPullParser);
                    j5Var2.N(g(xmlPullParser));
                } else if (name.equals("body")) {
                    String attributeValue11 = xmlPullParser.getAttributeValue("", "encode");
                    String g3 = g(xmlPullParser);
                    if (TextUtils.isEmpty(attributeValue11)) {
                        j5Var2.P(g3);
                    } else {
                        j5Var2.z(g3, attributeValue11);
                    }
                } else if (name.equals("thread")) {
                    if (str2 == null) {
                        str2 = xmlPullParser.nextText();
                    }
                } else if (name.equals("error")) {
                    j5Var2.i(f(xmlPullParser));
                } else {
                    j5Var2.h(a(name, namespace, xmlPullParser));
                }
            } else if (next2 == 3 && xmlPullParser.getName().equals("message")) {
                z10 = true;
            }
        }
        j5Var2.Q(str2);
        return j5Var2;
    }

    public static gp d(XmlPullParser xmlPullParser) {
        gp.b bVar = gp.b.available;
        String attributeValue = xmlPullParser.getAttributeValue("", "type");
        if (attributeValue != null && !attributeValue.equals("")) {
            try {
                bVar = gp.b.valueOf(attributeValue);
            } catch (IllegalArgumentException unused) {
                System.err.println("Found invalid presence type " + attributeValue);
            }
        }
        gp gpVar = new gp(bVar);
        gpVar.r(xmlPullParser.getAttributeValue("", RemoteMessageConst.TO));
        gpVar.t(xmlPullParser.getAttributeValue("", RemoteMessageConst.FROM));
        gpVar.p(xmlPullParser.getAttributeValue("", "chid"));
        String attributeValue2 = xmlPullParser.getAttributeValue("", "id");
        if (attributeValue2 == null) {
            attributeValue2 = "ID_NOT_AVAILABLE";
        }
        gpVar.n(attributeValue2);
        boolean z10 = false;
        while (!z10) {
            int next = xmlPullParser.next();
            if (next == 2) {
                String name = xmlPullParser.getName();
                String namespace = xmlPullParser.getNamespace();
                if (name.equals("status")) {
                    gpVar.B(xmlPullParser.nextText());
                } else if (name.equals("priority")) {
                    try {
                        gpVar.y(Integer.parseInt(xmlPullParser.nextText()));
                    } catch (NumberFormatException unused2) {
                    } catch (IllegalArgumentException unused3) {
                        gpVar.y(0);
                    }
                } else if (name.equals("show")) {
                    String nextText = xmlPullParser.nextText();
                    try {
                        gpVar.z(gp.a.valueOf(nextText));
                    } catch (IllegalArgumentException unused4) {
                        System.err.println("Found invalid presence mode " + nextText);
                    }
                } else if (name.equals("error")) {
                    gpVar.i(f(xmlPullParser));
                } else {
                    gpVar.h(a(name, namespace, xmlPullParser));
                }
            } else if (next == 3 && xmlPullParser.getName().equals("presence")) {
                z10 = true;
            }
        }
        return gpVar;
    }

    public static m5 e(XmlPullParser xmlPullParser) {
        m5 m5Var = null;
        boolean z10 = false;
        while (!z10) {
            int next = xmlPullParser.next();
            if (next == 2) {
                m5Var = new m5(xmlPullParser.getName());
            } else if (next == 3 && xmlPullParser.getName().equals("error")) {
                z10 = true;
            }
        }
        return m5Var;
    }

    public static n5 f(XmlPullParser xmlPullParser) {
        ArrayList arrayList = new ArrayList();
        boolean z10 = false;
        String str = "-1";
        String str2 = null;
        String str3 = null;
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            if (xmlPullParser.getAttributeName(i10).equals("code")) {
                str = xmlPullParser.getAttributeValue("", "code");
            }
            if (xmlPullParser.getAttributeName(i10).equals("type")) {
                str3 = xmlPullParser.getAttributeValue("", "type");
            }
            if (xmlPullParser.getAttributeName(i10).equals("reason")) {
                str2 = xmlPullParser.getAttributeValue("", "reason");
            }
        }
        String str4 = null;
        String str5 = null;
        while (!z10) {
            int next = xmlPullParser.next();
            if (next == 2) {
                if (xmlPullParser.getName().equals("text")) {
                    str5 = xmlPullParser.nextText();
                } else {
                    String name = xmlPullParser.getName();
                    String namespace = xmlPullParser.getNamespace();
                    if ("urn:ietf:params:xml:ns:xmpp-stanzas".equals(namespace)) {
                        str4 = name;
                    } else {
                        arrayList.add(a(name, namespace, xmlPullParser));
                    }
                }
            } else if (next == 3) {
                if (xmlPullParser.getName().equals("error")) {
                    z10 = true;
                }
            } else if (next == 4) {
                str5 = xmlPullParser.getText();
            }
        }
        return new n5(Integer.parseInt(str), str3 == null ? CardEventType.CLICK_ACTION_CANCEL : str3, str2, str4, str5, arrayList);
    }

    public static String g(XmlPullParser xmlPullParser) {
        int depth = xmlPullParser.getDepth();
        String str = "";
        while (true) {
            if (xmlPullParser.next() == 3 && xmlPullParser.getDepth() == depth) {
                return str;
            }
            str = str + xmlPullParser.getText();
        }
    }

    public static void h(byte[] bArr) {
        if (f48143a == null) {
            try {
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                f48143a = newPullParser;
                newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
            } catch (XmlPullParserException e2) {
                e2.printStackTrace();
            }
        }
        f48143a.setInput(new InputStreamReader(new ByteArrayInputStream(bArr)));
    }

    public static String i(XmlPullParser xmlPullParser) {
        for (int i10 = 0; i10 < xmlPullParser.getAttributeCount(); i10++) {
            String attributeName = xmlPullParser.getAttributeName(i10);
            if ("xml:lang".equals(attributeName) || ("lang".equals(attributeName) && "xml".equals(xmlPullParser.getAttributePrefix(i10)))) {
                return xmlPullParser.getAttributeValue(i10);
            }
        }
        return null;
    }
}
