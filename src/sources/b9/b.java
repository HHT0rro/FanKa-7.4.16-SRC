package b9;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class b {
    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void b(Reader reader, Writer writer) throws IOException {
        c(reader, writer, new char[4096]);
    }

    public static void c(Reader reader, Writer writer, char[] cArr) throws IOException {
        while (true) {
            int read = reader.read(cArr);
            if (-1 == read) {
                return;
            } else {
                writer.write(cArr, 0, read);
            }
        }
    }

    public static Map<String, String> d(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            hashMap.put(e(entry.getKey()), entry.getValue());
        }
        return hashMap;
    }

    public static String e(String str) {
        int i10 = 0;
        if (str.length() > 0) {
            while (str.charAt(i10) == '/') {
                i10++;
            }
        }
        return "/" + str.substring(i10);
    }

    public static z8.b f(String str, String str2) {
        if (str == null) {
            if (str2 != null) {
                if (str2.contains("connect-drcn")) {
                    return z8.b.f55028c;
                }
                if (str2.contains("connect-dre")) {
                    return z8.b.f55029d;
                }
                if (str2.contains("connect-drru")) {
                    return z8.b.f55030e;
                }
                if (str2.contains("connect-dra")) {
                    return z8.b.f55031f;
                }
            }
            return z8.b.f55027b;
        }
        char c4 = 65535;
        switch (str.hashCode()) {
            case 2155:
                if (str.equals("CN")) {
                    c4 = 0;
                    break;
                }
                break;
            case 2177:
                if (str.equals("DE")) {
                    c4 = 1;
                    break;
                }
                break;
            case 2627:
                if (str.equals("RU")) {
                    c4 = 2;
                    break;
                }
                break;
            case 2644:
                if (str.equals("SG")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return z8.b.f55028c;
            case 1:
                return z8.b.f55029d;
            case 2:
                return z8.b.f55030e;
            case 3:
                return z8.b.f55031f;
            default:
                return z8.b.f55027b;
        }
    }

    public static String g(InputStream inputStream, String str) throws UnsupportedEncodingException, IOException {
        StringWriter stringWriter = new StringWriter();
        b(new InputStreamReader(inputStream, str), stringWriter);
        return stringWriter.toString();
    }
}
