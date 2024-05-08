package com.huawei.openalliance.ad.utils;

import com.huawei.hms.ads.gl;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class10.dex */
public class ap {
    private static final String Code = "ap";

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v6, types: [java.io.Closeable] */
    public static Serializable Code(String str) {
        FileInputStream fileInputStream;
        Throwable th;
        ao aoVar;
        String str2;
        String str3;
        Serializable serializable = null;
        try {
            try {
                fileInputStream = new FileInputStream((String) str);
                try {
                    aoVar = new ao(fileInputStream);
                } catch (FileNotFoundException unused) {
                    aoVar = null;
                } catch (IOException unused2) {
                    aoVar = null;
                } catch (ClassNotFoundException unused3) {
                    aoVar = null;
                } catch (Throwable th2) {
                    th = th2;
                    str = 0;
                    at.Code((Closeable) fileInputStream);
                    at.Code((Closeable) str);
                    throw th;
                }
            } catch (FileNotFoundException unused4) {
                aoVar = null;
                fileInputStream = null;
            } catch (IOException unused5) {
                aoVar = null;
                fileInputStream = null;
            } catch (ClassNotFoundException unused6) {
                aoVar = null;
                fileInputStream = null;
            } catch (Throwable th3) {
                fileInputStream = null;
                th = th3;
                str = 0;
            }
            try {
                Object readObject = aoVar.readObject();
                if (readObject instanceof Serializable) {
                    serializable = (Serializable) readObject;
                }
            } catch (FileNotFoundException unused7) {
                gl.Z(Code, "read file FileNotFoundException");
                at.Code((Closeable) fileInputStream);
                at.Code((Closeable) aoVar);
                return serializable;
            } catch (IOException unused8) {
                str2 = Code;
                str3 = "read file IOException";
                gl.I(str2, str3);
                at.Code((Closeable) fileInputStream);
                at.Code((Closeable) aoVar);
                return serializable;
            } catch (ClassNotFoundException unused9) {
                str2 = Code;
                str3 = "read file ClassNotFoundException";
                gl.I(str2, str3);
                at.Code((Closeable) fileInputStream);
                at.Code((Closeable) aoVar);
                return serializable;
            }
            at.Code((Closeable) fileInputStream);
            at.Code((Closeable) aoVar);
            return serializable;
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static String Code(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return "";
        }
        ObjectOutputStream objectOutputStream2 = null;
        byte[] bArr = null;
        objectOutputStream2 = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                } catch (IOException unused) {
                    objectOutputStream = null;
                } catch (Throwable th) {
                    th = th;
                    at.Code(objectOutputStream2);
                    at.Code(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException unused2) {
                byteArrayOutputStream = null;
                objectOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                byteArrayOutputStream = null;
            }
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.flush();
                bArr = byteArrayOutputStream.toByteArray();
            } catch (IOException unused3) {
                gl.Z(Code, "fail to get sequence");
                at.Code(objectOutputStream);
                at.Code(byteArrayOutputStream);
                return u.Code(bArr);
            }
            at.Code(objectOutputStream);
            at.Code(byteArrayOutputStream);
            return u.Code(bArr);
        } catch (Throwable th3) {
            th = th3;
            objectOutputStream2 = objectOutputStream;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [java.io.Closeable, java.io.ObjectOutputStream] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v7, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r4v9 */
    public static boolean Code(Serializable serializable, String str) {
        Object obj;
        Object obj2;
        String str2;
        String str3;
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                File file = new File((String) str);
                if (!file.getParentFile().exists() && !p.Code(file.getParentFile())) {
                    gl.I(Code, "writeObject, mkdir failed");
                }
                fileOutputStream = new FileOutputStream((String) str);
                try {
                    str = new ObjectOutputStream(fileOutputStream);
                } catch (FileNotFoundException unused) {
                    str = 0;
                } catch (IOException unused2) {
                    str = 0;
                } catch (Throwable th) {
                    th = th;
                    str = 0;
                }
            } catch (FileNotFoundException unused3) {
                obj2 = null;
            } catch (IOException unused4) {
                obj = null;
            } catch (Throwable th2) {
                th = th2;
                str = 0;
            }
            try {
                str.writeObject(serializable);
                at.Code(fileOutputStream);
                at.Code((Closeable) str);
                return true;
            } catch (FileNotFoundException unused5) {
                fileOutputStream2 = fileOutputStream;
                obj2 = str;
                str2 = Code;
                str3 = "write file FileNotFoundException";
                str = obj2;
                gl.I(str2, str3);
                at.Code(fileOutputStream2);
                at.Code((Closeable) str);
                return false;
            } catch (IOException unused6) {
                fileOutputStream2 = fileOutputStream;
                obj = str;
                str2 = Code;
                str3 = "write file IOException";
                str = obj;
                gl.I(str2, str3);
                at.Code(fileOutputStream2);
                at.Code((Closeable) str);
                return false;
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                at.Code(fileOutputStream2);
                at.Code((Closeable) str);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.ByteArrayInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static Serializable V(String str) {
        ao aoVar;
        String str2;
        String str3;
        Closeable closeable;
        Closeable closeable2;
        ?? Code2 = au.Code((String) str);
        Serializable serializable = null;
        try {
            if (Code2 != 0) {
                return null;
            }
            try {
                Code2 = new ByteArrayInputStream(u.Code((String) str));
                try {
                    aoVar = new ao(Code2);
                } catch (UnsupportedEncodingException unused) {
                    aoVar = null;
                } catch (IOException unused2) {
                    aoVar = null;
                } catch (ClassNotFoundException unused3) {
                    aoVar = null;
                } catch (Throwable th) {
                    th = th;
                    str = 0;
                    at.Code((Closeable) str);
                    at.Code((Closeable) Code2);
                    throw th;
                }
            } catch (UnsupportedEncodingException unused4) {
                aoVar = null;
                Code2 = 0;
            } catch (IOException unused5) {
                aoVar = null;
                Code2 = 0;
            } catch (ClassNotFoundException unused6) {
                aoVar = null;
                Code2 = 0;
            } catch (Throwable th2) {
                Code2 = 0;
                th = th2;
                str = 0;
            }
            try {
                Object readObject = aoVar.readObject();
                closeable2 = Code2;
                if (readObject instanceof Serializable) {
                    serializable = (Serializable) readObject;
                    closeable2 = Code2;
                }
            } catch (UnsupportedEncodingException unused7) {
                str2 = Code;
                str3 = "fail to get Serializable UnsupportedEncodingException";
                closeable = Code2;
                gl.Z(str2, str3);
                closeable2 = closeable;
                at.Code((Closeable) aoVar);
                at.Code(closeable2);
                return serializable;
            } catch (IOException unused8) {
                str2 = Code;
                str3 = "fail to get Serializable IOException";
                closeable = Code2;
                gl.Z(str2, str3);
                closeable2 = closeable;
                at.Code((Closeable) aoVar);
                at.Code(closeable2);
                return serializable;
            } catch (ClassNotFoundException unused9) {
                str2 = Code;
                str3 = "fail to get Serializable ClassNotFoundException";
                closeable = Code2;
                gl.Z(str2, str3);
                closeable2 = closeable;
                at.Code((Closeable) aoVar);
                at.Code(closeable2);
                return serializable;
            }
            at.Code((Closeable) aoVar);
            at.Code(closeable2);
            return serializable;
        } catch (Throwable th3) {
            th = th3;
        }
    }
}
