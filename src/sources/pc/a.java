package pc;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.android.internal.content.NativeLibraryHelper;
import com.jifen.open.lib.relinkerx.MissingLibraryException;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import pc.b;

/* compiled from: ApkLibraryInstaller.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class a implements b.a {

    /* compiled from: ApkLibraryInstaller.java */
    /* renamed from: pc.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
    public static class C0806a {

        /* renamed from: a, reason: collision with root package name */
        public ZipFile f52979a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f52980b;

        public C0806a(ZipFile zipFile, ZipEntry zipEntry) {
            this.f52979a = zipFile;
            this.f52980b = zipEntry;
        }
    }

    @Override // pc.b.a
    public void a(Context context, String[] strArr, String str, File file, c cVar) {
        C0806a c4;
        String[] strArr2;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        long b4;
        C0806a c0806a = null;
        r0 = null;
        Closeable closeable = null;
        try {
            c4 = c(context, strArr, str, cVar);
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            if (c4 == null) {
                try {
                    strArr2 = f(context, str);
                } catch (Exception e2) {
                    strArr2 = new String[]{e2.toString()};
                }
                throw new MissingLibraryException(str, strArr, strArr2);
            }
            int i10 = 0;
            while (true) {
                int i11 = i10 + 1;
                if (i10 < 5) {
                    cVar.f("Found %s! Extracting...", str);
                    try {
                        if (file.exists() || file.createNewFile()) {
                            try {
                                inputStream = c4.f52979a.getInputStream(c4.f52980b);
                            } catch (FileNotFoundException | IOException unused) {
                                inputStream = null;
                            } catch (Throwable th3) {
                                th = th3;
                                inputStream = null;
                            }
                            try {
                                fileOutputStream = new FileOutputStream(file);
                            } catch (FileNotFoundException | IOException unused2) {
                                fileOutputStream = null;
                                d(inputStream);
                                d(fileOutputStream);
                                i10 = i11;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                            try {
                                b4 = b(inputStream, fileOutputStream);
                                fileOutputStream.getFD().sync();
                            } catch (FileNotFoundException | IOException unused3) {
                                d(inputStream);
                                d(fileOutputStream);
                                i10 = i11;
                            } catch (Throwable th5) {
                                th = th5;
                                closeable = fileOutputStream;
                                d(inputStream);
                                d(closeable);
                                throw th;
                            }
                            if (b4 != file.length()) {
                                d(inputStream);
                                d(fileOutputStream);
                            } else {
                                d(inputStream);
                                d(fileOutputStream);
                                file.setReadable(true, false);
                                file.setExecutable(true, false);
                                file.setWritable(true);
                                try {
                                    ZipFile zipFile = c4.f52979a;
                                    if (zipFile != null) {
                                        zipFile.close();
                                        return;
                                    }
                                    return;
                                } catch (IOException unused4) {
                                    return;
                                }
                            }
                        }
                    } catch (IOException unused5) {
                    }
                    i10 = i11;
                } else {
                    cVar.e("FATAL! Couldn't extract the library from the APK!");
                    try {
                        ZipFile zipFile2 = c4.f52979a;
                        if (zipFile2 != null) {
                            zipFile2.close();
                            return;
                        }
                        return;
                    } catch (IOException unused6) {
                        return;
                    }
                }
            }
        } catch (Throwable th6) {
            th = th6;
            c0806a = c4;
            if (c0806a != null) {
                try {
                    ZipFile zipFile3 = c0806a.f52979a;
                    if (zipFile3 != null) {
                        zipFile3.close();
                    }
                } catch (IOException unused7) {
                }
            }
            throw th;
        }
    }

    public final long b(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[4096];
        long j10 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                outputStream.flush();
                return j10;
            }
            outputStream.write(bArr, 0, read);
            j10 += read;
        }
    }

    public final C0806a c(Context context, String[] strArr, String str, c cVar) {
        String[] e2 = e(context);
        int length = e2.length;
        char c4 = 0;
        int i10 = 0;
        while (true) {
            ZipFile zipFile = null;
            if (i10 >= length) {
                return null;
            }
            String str2 = e2[i10];
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                if (i11 >= 5) {
                    break;
                }
                try {
                    zipFile = new ZipFile(new File(str2), 1);
                    break;
                } catch (IOException unused) {
                    i11 = i12;
                }
            }
            if (zipFile != null) {
                int i13 = 0;
                while (true) {
                    int i14 = i13 + 1;
                    if (i13 < 5) {
                        int length2 = strArr.length;
                        int i15 = 0;
                        while (i15 < length2) {
                            String str3 = NativeLibraryHelper.LIB_DIR_NAME + File.separatorChar + strArr[i15] + File.separatorChar + str;
                            Object[] objArr = new Object[2];
                            objArr[c4] = str3;
                            objArr[1] = str2;
                            cVar.f("Looking for %s in APK %s...", objArr);
                            ZipEntry entry = zipFile.getEntry(str3);
                            if (entry != null) {
                                return new C0806a(zipFile, entry);
                            }
                            i15++;
                            c4 = 0;
                        }
                        i13 = i14;
                        c4 = 0;
                    } else {
                        try {
                            zipFile.close();
                            break;
                        } catch (IOException unused2) {
                        }
                    }
                }
            }
            i10++;
            c4 = 0;
        }
    }

    public final void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public final String[] e(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr == null || strArr.length == 0) {
            return new String[]{applicationInfo.sourceDir};
        }
        String[] strArr2 = new String[strArr.length + 1];
        strArr2[0] = applicationInfo.sourceDir;
        System.arraycopy(strArr, 0, strArr2, 1, strArr.length);
        return strArr2;
    }

    public final String[] f(Context context, String str) {
        Pattern compile = Pattern.compile(NativeLibraryHelper.LIB_DIR_NAME + File.separatorChar + "([^\\" + File.separatorChar + "]*)" + File.separatorChar + str);
        HashSet hashSet = new HashSet();
        for (String str2 : e(context)) {
            try {
                Enumeration<? extends ZipEntry> entries = new ZipFile(new File(str2), 1).entries();
                while (entries.hasMoreElements()) {
                    Matcher matcher = compile.matcher(entries.nextElement().getName());
                    if (matcher.matches()) {
                        hashSet.add(matcher.group(1));
                    }
                }
            } catch (IOException unused) {
            }
        }
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }
}
