package d0;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static String f48604a = "";

    /* renamed from: b, reason: collision with root package name */
    public static String f48605b = "";

    /* renamed from: c, reason: collision with root package name */
    public static String f48606c = "";

    public static synchronized void a(String str) {
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            d(arrayList);
        }
    }

    public static synchronized void b(String str, String str2, String str3) {
        synchronized (d.class) {
            f48604a = str;
            f48605b = str2;
            f48606c = str3;
        }
    }

    public static synchronized void c(Throwable th) {
        String str;
        synchronized (d.class) {
            ArrayList arrayList = new ArrayList();
            if (th != null) {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                str = stringWriter.toString();
            } else {
                str = "";
            }
            arrayList.add(str);
            d(arrayList);
        }
    }

    public static synchronized void d(List<String> list) {
        synchronized (d.class) {
            if (!z.a.d(f48605b) && !z.a.d(f48606c)) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(f48606c);
                Iterator<String> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    stringBuffer.append(", " + iterator2.next());
                }
                stringBuffer.append("\n");
                try {
                    File file = new File(f48604a);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    File file2 = new File(f48604a, f48605b);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    FileWriter fileWriter = ((long) stringBuffer.length()) + file2.length() <= 51200 ? new FileWriter(file2, true) : new FileWriter(file2);
                    fileWriter.write(stringBuffer.toString());
                    fileWriter.flush();
                    fileWriter.close();
                } catch (Exception unused) {
                }
            }
        }
    }
}
