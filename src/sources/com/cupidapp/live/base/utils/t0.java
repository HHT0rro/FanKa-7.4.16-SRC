package com.cupidapp.live.base.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import org.jetbrains.annotations.NotNull;

/* compiled from: ZipUtils.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class t0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final t0 f12378a = new t0();

    public static /* synthetic */ void b(t0 t0Var, String str, String str2, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = true;
        }
        t0Var.a(str, str2, z10);
    }

    public final void a(@NotNull String zipFilePath, @NotNull String desFolderPath, boolean z10) {
        kotlin.jvm.internal.s.i(zipFilePath, "zipFilePath");
        kotlin.jvm.internal.s.i(desFolderPath, "desFolderPath");
        try {
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath));
            for (ZipEntry nextEntry = zipInputStream.getNextEntry(); nextEntry != null; nextEntry = zipInputStream.getNextEntry()) {
                String name = nextEntry.getName();
                kotlin.jvm.internal.s.h(name, "zipEntry.name");
                if (nextEntry.isDirectory()) {
                    String substring = name.substring(0, name.length() - 1);
                    kotlin.jvm.internal.s.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    new File(desFolderPath + File.separator + substring).mkdirs();
                } else {
                    File file = new File(desFolderPath + File.separator + name);
                    if (!file.exists()) {
                        File parentFile = file.getParentFile();
                        if (parentFile != null && !parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        file.createNewFile();
                    }
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    byte[] bArr = new byte[1048576];
                    while (true) {
                        int read = zipInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        fileOutputStream.write(bArr, 0, read);
                        fileOutputStream.flush();
                    }
                    fileOutputStream.close();
                }
            }
            zipInputStream.close();
            if (z10) {
                File file2 = new File(zipFilePath);
                if (file2.exists()) {
                    file2.delete();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
