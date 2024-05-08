package com.cupidapp.live.base.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.zip.ZipUtils;

/* compiled from: StringUtil.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class q0 {
    public static int a(Reader reader, Writer writer) {
        long b4 = b(reader, writer);
        if (b4 > ZipUtils.UPPER_UNIXTIME_BOUND) {
            return -1;
        }
        return (int) b4;
    }

    public static long b(Reader reader, Writer writer) throws RuntimeException {
        try {
            char[] cArr = new char[4096];
            long j10 = 0;
            while (true) {
                int read = reader.read(cArr);
                if (-1 == read) {
                    return j10;
                }
                writer.write(cArr, 0, read);
                j10 += read;
            }
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static <T> String c(String str, Collection<T> collection) {
        if (collection == null || collection.isEmpty()) {
            return "";
        }
        Iterator<T> iterator2 = collection.iterator2();
        StringBuilder sb2 = new StringBuilder(k(iterator2.next()));
        while (iterator2.hasNext()) {
            T next = iterator2.next();
            if (f(next)) {
                sb2.append(str);
                sb2.append(k(next));
            }
        }
        return sb2.toString();
    }

    public static <T> String d(String str, T... tArr) {
        return c(str, Arrays.asList(tArr));
    }

    public static String e(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb2 = new StringBuilder();
            for (byte b4 : digest) {
                String hexString = Integer.toHexString(b4);
                if (hexString.length() == 1) {
                    sb2.append('0');
                    sb2.append(hexString.charAt(hexString.length() - 1));
                } else {
                    sb2.append(hexString.substring(hexString.length() - 2));
                }
            }
            return sb2.toString();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean f(Object obj) {
        return k(obj).trim().length() != 0;
    }

    public static String g(InputStream inputStream) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    inputStream.close();
                    byteArrayOutputStream.close();
                    return new String(byteArrayOutputStream.toByteArray(), "utf-8");
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String[] h(String str, String str2) {
        if ("".equals(str)) {
            return null;
        }
        return str.split(str2);
    }

    public static String i(InputStream inputStream) {
        StringWriter stringWriter = new StringWriter();
        a(new InputStreamReader(inputStream), stringWriter);
        return stringWriter.toString();
    }

    public static String j(Reader reader) {
        StringWriter stringWriter = new StringWriter();
        a(reader, stringWriter);
        return stringWriter.toString();
    }

    public static String k(Object obj) {
        return l(obj, "");
    }

    public static String l(Object obj, String str) {
        return obj == null ? str : obj instanceof InputStream ? i((InputStream) obj) : obj instanceof Reader ? j((Reader) obj) : obj instanceof Object[] ? d(", ", (Object[]) obj) : obj instanceof Collection ? c(", ", (Collection) obj) : obj.toString();
    }
}
