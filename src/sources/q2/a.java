package q2;

import android.content.res.AssetManager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: FileUtils.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static char[] f53018a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static boolean a(File file) {
        File[] listFiles;
        if (!file.exists() || (listFiles = file.listFiles()) == null) {
            return true;
        }
        for (File file2 : listFiles) {
            if (file2.isDirectory()) {
                a(file2);
                file2.delete();
            } else if (file2.exists()) {
                file2.delete();
            }
        }
        return true;
    }

    public static void b(AssetManager assetManager, String str, String str2, String str3) throws IOException {
        String file = new File(str, str2).toString();
        if (e(assetManager, file)) {
            File file2 = new File(str3 + File.separator + str2);
            if (!file2.exists() && !file2.mkdirs()) {
                throw new IllegalStateException("mkdir failed");
            }
            String[] list = assetManager.list(file);
            if (list != null) {
                for (String str4 : list) {
                    b(assetManager, str, str2 + "/" + str4, str3);
                }
                return;
            }
            return;
        }
        d(assetManager.open(file), new File(str3, str2));
    }

    public static void c(AssetManager assetManager, String str, String str2, String str3) throws IOException {
        String path = new File(str, str2).getPath();
        String[] list = assetManager.list(path);
        if (list != null) {
            for (String str4 : list) {
                if (str4.equals("online_model")) {
                    String path2 = new File(path, str4).getPath();
                    for (String str5 : assetManager.list(path2)) {
                        b(assetManager, path2, str5, str3);
                    }
                } else {
                    b(assetManager, path, str4, str3);
                }
            }
        }
    }

    public static void d(InputStream inputStream, File file) throws IOException {
        if (file.exists()) {
            return;
        }
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read < 0) {
                    break;
                } else {
                    fileOutputStream.write(bArr, 0, read);
                }
            }
        } finally {
            fileOutputStream.flush();
            try {
                fileOutputStream.getFD().sync();
            } catch (IOException unused) {
            }
            fileOutputStream.close();
        }
    }

    public static boolean e(AssetManager assetManager, String str) {
        try {
            String[] list = assetManager.list(str);
            if (list != null) {
                return list.length > 0;
            }
            return false;
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
