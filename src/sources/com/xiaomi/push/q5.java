package com.xiaomi.push;

import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class q5 {

    /* renamed from: c, reason: collision with root package name */
    public static q5 f48100c;

    /* renamed from: a, reason: collision with root package name */
    public Map<String, Object> f48101a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public Map<String, Object> f48102b = new ConcurrentHashMap();

    public q5() {
        d();
    }

    public static synchronized q5 a() {
        q5 q5Var;
        synchronized (q5.class) {
            if (f48100c == null) {
                f48100c = new q5();
            }
            q5Var = f48100c;
        }
        return q5Var;
    }

    public Object b(String str, String str2) {
        return this.f48101a.get(c(str, str2));
    }

    public final String c(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<");
        sb2.append(str);
        sb2.append("/>");
        if (str != null) {
            sb2.append("<");
            sb2.append(str2);
            sb2.append("/>");
        }
        return sb2.toString();
    }

    public void d() {
        Map<String, Object> map;
        Object obj;
        Map<String, Object> map2;
        Object obj2;
        try {
            for (ClassLoader classLoader : f()) {
                Enumeration<URL> resources = classLoader.getResources("META-INF/smack.providers");
                while (resources.hasMoreElements()) {
                    InputStream inputStream = null;
                    try {
                        inputStream = resources.nextElement().openStream();
                        XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                        newPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", true);
                        newPullParser.setInput(inputStream, "UTF-8");
                        int eventType = newPullParser.getEventType();
                        do {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("iqProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText2 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText3 = newPullParser.nextText();
                                    String c4 = c(nextText, nextText2);
                                    if (!this.f48102b.containsKey(c4)) {
                                        try {
                                            Class<?> cls = Class.forName(nextText3);
                                            if (o5.class.isAssignableFrom(cls)) {
                                                map2 = this.f48102b;
                                                obj2 = cls.newInstance();
                                            } else if (i5.class.isAssignableFrom(cls)) {
                                                map2 = this.f48102b;
                                                obj2 = cls;
                                            }
                                            map2.put(c4, obj2);
                                        } catch (ClassNotFoundException e2) {
                                            e = e2;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                        }
                                    }
                                } else if (newPullParser.getName().equals("extensionProvider")) {
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText4 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText5 = newPullParser.nextText();
                                    newPullParser.next();
                                    newPullParser.next();
                                    String nextText6 = newPullParser.nextText();
                                    String c10 = c(nextText4, nextText5);
                                    if (!this.f48101a.containsKey(c10)) {
                                        try {
                                            Class<?> cls2 = Class.forName(nextText6);
                                            if (p5.class.isAssignableFrom(cls2)) {
                                                map = this.f48101a;
                                                obj = cls2.newInstance();
                                            } else if (l5.class.isAssignableFrom(cls2)) {
                                                map = this.f48101a;
                                                obj = cls2;
                                            }
                                            map.put(c10, obj);
                                        } catch (ClassNotFoundException e10) {
                                            e = e10;
                                            e.printStackTrace();
                                            eventType = newPullParser.next();
                                        }
                                    }
                                }
                            }
                            eventType = newPullParser.next();
                        } while (eventType != 1);
                        inputStream.close();
                    } catch (Throwable th) {
                        try {
                            inputStream.close();
                        } catch (Exception unused) {
                        }
                        throw th;
                    }
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void e(String str, String str2, Object obj) {
        if (!(obj instanceof p5) && !(obj instanceof Class)) {
            throw new IllegalArgumentException("Provider must be a PacketExtensionProvider or a Class instance.");
        }
        this.f48101a.put(c(str, str2), obj);
    }

    public final ClassLoader[] f() {
        ClassLoader[] classLoaderArr = {q5.class.getClassLoader(), Thread.currentThread().getContextClassLoader()};
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < 2; i10++) {
            ClassLoader classLoader = classLoaderArr[i10];
            if (classLoader != null) {
                arrayList.add(classLoader);
            }
        }
        return (ClassLoader[]) arrayList.toArray(new ClassLoader[arrayList.size()]);
    }
}
