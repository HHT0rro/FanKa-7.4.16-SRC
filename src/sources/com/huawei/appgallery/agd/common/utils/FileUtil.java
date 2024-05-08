package com.huawei.appgallery.agd.common.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.huawei.appgallery.agd.common.CommonLog;
import com.huawei.appgallery.agd.common.application.ApplicationWrapper;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.huawei.secure.android.common.util.a;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class FileUtil {
    public static final String TAG = "FileUtil";

    public static InputStream bitmap2InputStream(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public static void close(Closeable closeable) {
        a.a(closeable);
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        CommonLog.LOG.i("FileUtil", "deleteFile");
        if (!file.exists()) {
            return true;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File file2 : listFiles) {
                deleteFile(file2);
            }
        }
        return file.delete();
    }

    public static Bitmap drawable2Bitmap(Drawable drawable) {
        Bitmap createBitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), drawable.getOpacity() != -1 ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    public static InputStream drawable2InputStream(Drawable drawable) {
        return bitmap2InputStream(drawable2Bitmap(drawable));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v33 */
    public static String getFileHashData(String str, String str2) {
        Throwable th;
        ?? r10;
        Throwable e2;
        BufferedInputStream bufferedInputStream;
        FileInputStream fileInputStream;
        CommonLog commonLog;
        String str3;
        MessageDigest messageDigest;
        FileInputStream fileInputStream2 = null;
        r1 = null;
        r1 = null;
        String str4 = null;
        try {
            try {
                messageDigest = MessageDigest.getInstance(str2);
                fileInputStream = new FileInputStream(str);
                try {
                    bufferedInputStream = new BufferedInputStream(fileInputStream);
                } catch (FileNotFoundException unused) {
                    bufferedInputStream = null;
                } catch (IOException e10) {
                    e2 = e10;
                    bufferedInputStream = null;
                } catch (IllegalArgumentException e11) {
                    e2 = e11;
                    bufferedInputStream = null;
                } catch (IndexOutOfBoundsException e12) {
                    e2 = e12;
                    bufferedInputStream = null;
                } catch (NoSuchAlgorithmException e13) {
                    e2 = e13;
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    fileInputStream2 = fileInputStream;
                    r10 = str;
                    a.b(r10);
                    a.b(fileInputStream2);
                    throw th;
                }
            } catch (FileNotFoundException unused2) {
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IOException e14) {
                e2 = e14;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IllegalArgumentException e15) {
                e2 = e15;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (IndexOutOfBoundsException e16) {
                e2 = e16;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (NoSuchAlgorithmException e17) {
                e2 = e17;
                bufferedInputStream = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                th = th3;
                r10 = 0;
                a.b(r10);
                a.b(fileInputStream2);
                throw th;
            }
            try {
                byte[] bArr = new byte[131072];
                long j10 = 0;
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    messageDigest.update(bArr, 0, read);
                    j10 += read;
                }
                if (j10 > 0) {
                    str4 = ByteUtil.byteArrayToHex(messageDigest.digest());
                }
            } catch (FileNotFoundException unused3) {
                CommonLog.LOG.e("FileUtil", "getFileHashData FileNotFoundException");
                a.b(bufferedInputStream);
                a.b(fileInputStream);
                return str4;
            } catch (IOException e18) {
                e2 = e18;
                commonLog = CommonLog.LOG;
                str3 = "getFileHashData IOException";
                commonLog.e("FileUtil", str3, e2);
                a.b(bufferedInputStream);
                a.b(fileInputStream);
                return str4;
            } catch (IllegalArgumentException e19) {
                e2 = e19;
                commonLog = CommonLog.LOG;
                str3 = "getFileHashData IllegalArgumentException";
                commonLog.e("FileUtil", str3, e2);
                a.b(bufferedInputStream);
                a.b(fileInputStream);
                return str4;
            } catch (IndexOutOfBoundsException e20) {
                e2 = e20;
                commonLog = CommonLog.LOG;
                str3 = "getFileHashData IndexOutOfBoundsException";
                commonLog.e("FileUtil", str3, e2);
                a.b(bufferedInputStream);
                a.b(fileInputStream);
                return str4;
            } catch (NoSuchAlgorithmException e21) {
                e2 = e21;
                commonLog = CommonLog.LOG;
                str3 = "getFileHashData NoSuchAlgorithmException";
                commonLog.e("FileUtil", str3, e2);
                a.b(bufferedInputStream);
                a.b(fileInputStream);
                return str4;
            }
            a.b(bufferedInputStream);
            a.b(fileInputStream);
            return str4;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String getImagesResourceRootDir() {
        CommonLog commonLog;
        String str;
        StringBuffer stringBuffer = new StringBuffer();
        try {
            stringBuffer.append(ApplicationWrapper.getInstance().getContext().getCacheDir().getCanonicalPath());
            String str2 = File.separator;
            stringBuffer.append(str2);
            stringBuffer.append(CardConstants.KEY_IMAGES);
            stringBuffer.append(str2);
            File file = new File(stringBuffer.toString());
            if (!file.exists() && !file.mkdirs()) {
                CommonLog.LOG.e("FileUtil", "create reportRoot images error");
            }
        } catch (IOException unused) {
            commonLog = CommonLog.LOG;
            str = "getCanonicalPath error";
            commonLog.e("FileUtil", str);
            return stringBuffer.toString();
        } catch (Exception unused2) {
            commonLog = CommonLog.LOG;
            str = "getCanonicalPath others error";
            commonLog.e("FileUtil", str);
            return stringBuffer.toString();
        }
        return stringBuffer.toString();
    }

    public static boolean saveFile(String str, InputStream inputStream) {
        Throwable th;
        BufferedInputStream bufferedInputStream;
        Exception e2;
        IOException e10;
        if (TextUtils.isEmpty(str) || inputStream == null) {
            CommonLog.LOG.e("FileUtil", "saveFile path or inputstream is null ");
            return false;
        }
        BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                File file = new File(str);
                if (file.exists()) {
                    CommonLog.LOG.i("FileUtil", "saveFile exist");
                    bufferedInputStream = null;
                } else {
                    boolean createNewFile = file.createNewFile();
                    CommonLog.LOG.i("FileUtil", "saveFile createNewFile result: " + createNewFile);
                    BufferedOutputStream bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                    try {
                        bufferedInputStream = new BufferedInputStream(inputStream);
                        try {
                            byte[] bArr = new byte[8192];
                            while (true) {
                                int read = bufferedInputStream.read(bArr);
                                if (read == -1) {
                                    break;
                                }
                                CommonLog.LOG.e("FileUtil", "saveFile read cout is " + read);
                                bufferedOutputStream2.write(bArr, 0, read);
                                bufferedOutputStream2.flush();
                            }
                            bufferedOutputStream = bufferedOutputStream2;
                        } catch (IOException e11) {
                            e10 = e11;
                            bufferedOutputStream = bufferedOutputStream2;
                            CommonLog commonLog = CommonLog.LOG;
                            commonLog.e("FileUtil", "saveFile IOException " + e10.getMessage());
                            a.b(bufferedInputStream);
                            a.c(bufferedOutputStream);
                            commonLog.i("FileUtil", "saveFile storefile finish");
                            return false;
                        } catch (Exception e12) {
                            e2 = e12;
                            bufferedOutputStream = bufferedOutputStream2;
                            CommonLog commonLog2 = CommonLog.LOG;
                            commonLog2.e("FileUtil", "saveFile others Exception " + e2.getMessage());
                            a.b(bufferedInputStream);
                            a.c(bufferedOutputStream);
                            commonLog2.i("FileUtil", "saveFile storefile finish");
                            return false;
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedOutputStream = bufferedOutputStream2;
                            a.b(bufferedInputStream);
                            a.c(bufferedOutputStream);
                            CommonLog.LOG.i("FileUtil", "saveFile storefile finish");
                            throw th;
                        }
                    } catch (IOException e13) {
                        e10 = e13;
                        bufferedInputStream = null;
                    } catch (Exception e14) {
                        e2 = e14;
                        bufferedInputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedInputStream = null;
                    }
                }
                a.b(bufferedInputStream);
                a.c(bufferedOutputStream);
                CommonLog.LOG.i("FileUtil", "saveFile storefile finish");
                return true;
            } catch (IOException e15) {
                e10 = e15;
                bufferedInputStream = null;
            } catch (Exception e16) {
                e2 = e16;
                bufferedInputStream = null;
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
