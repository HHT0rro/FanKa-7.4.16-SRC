package com.kwad.sdk.utils;

import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class bv {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class a extends ZipOutputStream {
        private Map<String, Integer> aRk;

        public a(OutputStream outputStream) {
            super(outputStream);
            this.aRk = new HashMap();
        }

        @Override // java.util.zip.ZipOutputStream
        public final void putNextEntry(ZipEntry zipEntry) {
            ZipEntry zipEntry2;
            Integer num;
            String name = zipEntry.getName();
            Integer num2 = this.aRk.get(name);
            if (num2 != null && num2.intValue() > 0) {
                zipEntry2 = new ZipEntry(zipEntry.getName().replaceFirst("\\.", "(" + ((Object) num2) + ")."));
                num = Integer.valueOf(num2.intValue() + 1);
            } else {
                zipEntry2 = zipEntry;
                num = 1;
            }
            this.aRk.put(name, num);
            super.putNextEntry(zipEntry2);
        }
    }

    private static boolean a(File[] fileArr, File file) {
        if (file == null) {
            return false;
        }
        a aVar = null;
        try {
            byte[] bArr = new byte[4096];
            a aVar2 = new a(new BufferedOutputStream(new FileOutputStream(file, false)));
            for (int i10 = 0; i10 <= 0; i10++) {
                try {
                    a(aVar2, fileArr[0], null, bArr);
                } catch (Throwable th) {
                    th = th;
                    aVar = aVar2;
                    try {
                        com.kwad.sdk.core.e.c.e("ZipUtils", "error zip", th);
                        return false;
                    } finally {
                        com.kwad.sdk.crash.utils.b.closeQuietly(aVar);
                    }
                }
            }
            aVar2.flush();
            aVar2.closeEntry();
            com.kwad.sdk.crash.utils.b.closeQuietly(aVar2);
            return true;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static String hc(String str) {
        return ((!TextUtils.isEmpty(str) || str.length() <= 1) && !TextUtils.isEmpty(str) && str.charAt(0) == '.') ? str.substring(1) : str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v6 */
    public static boolean unZip(InputStream inputStream, String str) {
        BufferedInputStream bufferedInputStream;
        FileOutputStream fileOutputStream;
        Closeable closeable;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        ZipInputStream zipInputStream = null;
        try {
            try {
                bufferedInputStream = new BufferedInputStream(inputStream);
                try {
                    ZipInputStream zipInputStream2 = new ZipInputStream(bufferedInputStream);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            ZipEntry nextEntry = zipInputStream2.getNextEntry();
                            if (nextEntry != null) {
                                String name = nextEntry.getName();
                                if (!name.contains("../")) {
                                    if (nextEntry.isDirectory()) {
                                        new File(str + "/" + name).mkdirs();
                                    } else {
                                        File file2 = new File(str + "/" + name);
                                        if (!file2.getParentFile().exists()) {
                                            file2.getParentFile().mkdirs();
                                        }
                                        try {
                                            fileOutputStream = new FileOutputStream(file2);
                                            while (true) {
                                                try {
                                                    try {
                                                        int read = zipInputStream2.read(bArr);
                                                        if (read == -1) {
                                                            break;
                                                        }
                                                        fileOutputStream.write(bArr, 0, read);
                                                    } catch (IOException e2) {
                                                        e = e2;
                                                        com.kwad.sdk.core.e.c.e("ZipUtils", "error unZip when write", e);
                                                        closeable = fileOutputStream;
                                                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                                        zipInputStream2.closeEntry();
                                                    }
                                                } catch (Throwable th) {
                                                    th = th;
                                                    zipInputStream = fileOutputStream;
                                                    com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                                                    throw th;
                                                }
                                            }
                                            fileOutputStream.flush();
                                            fileOutputStream.getFD().sync();
                                            closeable = fileOutputStream;
                                        } catch (IOException e10) {
                                            e = e10;
                                            fileOutputStream = 0;
                                        } catch (Throwable th2) {
                                            th = th2;
                                        }
                                        com.kwad.sdk.crash.utils.b.closeQuietly(closeable);
                                        zipInputStream2.closeEntry();
                                    }
                                }
                            } else {
                                com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                                return true;
                            }
                        }
                    } catch (IOException e11) {
                        e = e11;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.core.e.c.e("ZipUtils", "error unZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        return false;
                    } catch (Throwable th3) {
                        th = th3;
                        zipInputStream = zipInputStream2;
                        com.kwad.sdk.crash.utils.b.closeQuietly(zipInputStream);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw th;
                    }
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (IOException e13) {
                e = e13;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }

    public static boolean zip(File file, File file2) {
        return a(new File[]{file}, file2);
    }

    public static void zipFile(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        String absolutePath = file.getAbsolutePath();
        if (absolutePath.endsWith(".zip")) {
            return;
        }
        if (zip(file, new File(absolutePath + ".zip"))) {
            file.delete();
        }
    }

    private static void a(ZipOutputStream zipOutputStream, File file, String str, byte[] bArr) {
        File[] listFiles;
        if (zipOutputStream != null && file != null) {
            if (!file.exists()) {
                com.kwad.sdk.core.e.c.e("ZipUtils", file.toString(), new FileNotFoundException("(doZip:142)Target File is missing"));
                return;
            }
            BufferedInputStream bufferedInputStream = null;
            String hc2 = TextUtils.isEmpty(str) ? hc(file.getName()) : str + File.separator + hc(file.getName());
            if (file.isFile()) {
                try {
                    BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                    try {
                        zipOutputStream.putNextEntry(new ZipEntry(hc2));
                        while (true) {
                            int read = bufferedInputStream2.read(bArr, 0, bArr.length);
                            if (-1 != read) {
                                zipOutputStream.write(bArr, 0, read);
                            } else {
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream2);
                                return;
                            }
                        }
                    } catch (IOException e2) {
                        e = e2;
                        bufferedInputStream = bufferedInputStream2;
                        com.kwad.sdk.core.e.c.e("ZipUtils", "error doZip", e);
                        com.kwad.sdk.crash.utils.b.closeQuietly(bufferedInputStream);
                        throw e;
                    }
                } catch (IOException e10) {
                    e = e10;
                }
            } else {
                if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    a(zipOutputStream, file2, hc2, bArr);
                }
            }
        } else {
            com.kwad.sdk.core.e.c.e("ZipUtils", "", new IOException("(dozip:179) I/O Object got NullPointerException"));
        }
    }
}
