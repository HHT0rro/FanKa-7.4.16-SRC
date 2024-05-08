package com.xiaomi.push;

import com.vivo.push.PushClientConstants;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public final class a5 {

    /* renamed from: a, reason: collision with root package name */
    public static int f47111a = 5000;

    /* renamed from: b, reason: collision with root package name */
    public static int f47112b = 330000;

    /* renamed from: c, reason: collision with root package name */
    public static int f47113c = 600000;

    /* renamed from: d, reason: collision with root package name */
    public static Vector<String> f47114d = new Vector<>();

    static {
        try {
            for (ClassLoader classLoader : e()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack-config.xml");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        try {
                            inputStream = resources.nextElement().openStream();
                            XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                            newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                            newPullParser.setInput(inputStream, "UTF-8");
                            int eventType = newPullParser.getEventType();
                            do {
                                if (eventType == 2) {
                                    if (newPullParser.getName().equals(PushClientConstants.TAG_CLASS_NAME)) {
                                        d(newPullParser);
                                    } else if (newPullParser.getName().equals("packetReplyTimeout")) {
                                        f47111a = b(newPullParser, f47111a);
                                    } else if (newPullParser.getName().equals("keepAliveInterval")) {
                                        f47112b = b(newPullParser, f47112b);
                                    } else if (newPullParser.getName().equals("mechName")) {
                                        f47114d.add(newPullParser.nextText());
                                    }
                                }
                                eventType = newPullParser.next();
                            } while (eventType != 1);
                        } catch (Throwable th) {
                            try {
                                inputStream.close();
                            } catch (Exception unused) {
                            }
                            throw th;
                        }
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                    try {
                        inputStream.close();
                    } catch (Exception unused2) {
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static int a() {
        return f47112b;
    }

    public static int b(XmlPullParser xmlPullParser, int i10) {
        try {
            return Integer.parseInt(xmlPullParser.nextText());
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            return i10;
        }
    }

    public static String c() {
        return "3.1.0";
    }

    public static void d(XmlPullParser xmlPullParser) {
        String nextText = xmlPullParser.nextText();
        try {
            Class.forName(nextText);
        } catch (ClassNotFoundException unused) {
            System.err.println("Error! A startup class specified in smack-config.xml could not be loaded: " + nextText);
        }
    }

    public static ClassLoader[] e() {
        ClassLoader[] classLoaderArr = {a5.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            ClassLoader classLoader = classLoaderArr[i10];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }

    public static int f() {
        return f47113c;
    }
}
