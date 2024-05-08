package com.opensource.svgaplayer;

import android.content.Context;
import java.io.File;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.s;
import kotlin.jvm.internal.y;
import org.apache.commons.io.IOUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SVGACache.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SVGACache {

    /* renamed from: c, reason: collision with root package name */
    public static final SVGACache f37881c = new SVGACache();

    /* renamed from: a, reason: collision with root package name */
    public static Type f37879a = Type.DEFAULT;

    /* renamed from: b, reason: collision with root package name */
    public static String f37880b = "/";

    /* compiled from: SVGACache.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public enum Type {
        DEFAULT,
        FILE
    }

    @NotNull
    public final File a(@NotNull String audio) {
        s.j(audio, "audio");
        return new File(g() + audio + ".mp3");
    }

    @NotNull
    public final File b(@NotNull String cacheKey) {
        s.j(cacheKey, "cacheKey");
        return new File(g() + cacheKey + IOUtils.DIR_SEPARATOR_UNIX);
    }

    @NotNull
    public final String c(@NotNull String str) {
        s.j(str, "str");
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        Charset forName = Charset.forName("UTF-8");
        s.e(forName, "Charset.forName(charsetName)");
        byte[] bytes = str.getBytes(forName);
        s.e(bytes, "(this as java.lang.String).getBytes(charset)");
        messageDigest.update(bytes);
        String str2 = "";
        for (byte b4 : messageDigest.digest()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str2);
            y yVar = y.f51038a;
            String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b4)}, 1));
            s.e(format, "java.lang.String.format(format, *args)");
            sb2.append(format);
            str2 = sb2.toString();
        }
        return str2;
    }

    @NotNull
    public final String d(@NotNull URL url) {
        s.j(url, "url");
        String url2 = url.toString();
        s.e(url2, "url.toString()");
        return c(url2);
    }

    @NotNull
    public final File e(@NotNull String cacheKey) {
        s.j(cacheKey, "cacheKey");
        return new File(g() + cacheKey + ".svga");
    }

    public final void f(@NotNull String path) {
        File[] listFiles;
        s.j(path, "path");
        try {
            File file = new File(path);
            if (!file.exists()) {
                file = null;
            }
            if (file == null || (listFiles = file.listFiles()) == null) {
                return;
            }
            for (File file2 : listFiles) {
                if (file2.exists()) {
                    s.e(file2, "file");
                    if (file2.isDirectory()) {
                        SVGACache sVGACache = f37881c;
                        String absolutePath = file2.getAbsolutePath();
                        s.e(absolutePath, "file.absolutePath");
                        sVGACache.f(absolutePath);
                    }
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            ub.c.f54010a.c("SVGACache", "Clear svga cache path: " + path + " fail", e2);
        }
    }

    public final String g() {
        if (!s.d(f37880b, "/")) {
            File file = new File(f37880b);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        return f37880b;
    }

    public final boolean h(@NotNull String cacheKey) {
        File e2;
        s.j(cacheKey, "cacheKey");
        if (i()) {
            e2 = b(cacheKey);
        } else {
            e2 = e(cacheKey);
        }
        return e2.exists();
    }

    public final boolean i() {
        return f37879a == Type.DEFAULT;
    }

    public final boolean j() {
        return (s.d("/", g()) ^ true) && new File(g()).exists();
    }

    public final void k(@Nullable Context context) {
        l(context, Type.DEFAULT);
    }

    public final void l(@Nullable Context context, @NotNull Type type) {
        s.j(type, "type");
        if (j() || context == null) {
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        File cacheDir = context.getCacheDir();
        s.e(cacheDir, "context.cacheDir");
        sb2.append(cacheDir.getAbsolutePath());
        sb2.append("/svga/");
        f37880b = sb2.toString();
        File file = new File(g());
        if (!(!file.exists())) {
            file = null;
        }
        if (file != null) {
            file.mkdirs();
        }
        f37879a = type;
    }
}
