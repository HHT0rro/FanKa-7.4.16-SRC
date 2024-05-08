package com.amap.api.col.s;

import com.amap.api.col.s.dq;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.json.JSONObject;

/* compiled from: LogEngine.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public final class ec {
    public static void a(String str, byte[] bArr, eb ebVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        dq dqVar;
        OutputStream outputStream = null;
        try {
            if (a(ebVar.f7872a, str)) {
                return;
            }
            File file = new File(ebVar.f7872a);
            if (!file.exists()) {
                file.mkdirs();
            }
            dqVar = dq.a(file, ebVar.f7873b);
            try {
                dqVar.a(ebVar.f7875d);
                byte[] b4 = ebVar.f7876e.b(bArr);
                dq.a b10 = dqVar.b(str);
                outputStream = b10.a();
                outputStream.write(b4);
                b10.b();
                dqVar.b();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    dqVar.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th4.printStackTrace();
                    }
                }
                if (dqVar != null) {
                    try {
                        dqVar.close();
                        throw th;
                    } catch (Throwable th5) {
                        th5.printStackTrace();
                        throw th;
                    }
                }
                throw th;
            }
        } catch (Throwable th6) {
            th = th6;
            dqVar = null;
        }
    }

    public static int a(eb ebVar) {
        dq dqVar = null;
        try {
            try {
                if (ebVar.f7877f.c()) {
                    ebVar.f7877f.a(true);
                    dq a10 = dq.a(new File(ebVar.f7872a), ebVar.f7873b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] a11 = a(a10, ebVar, arrayList);
                        if (a11 != null && a11.length != 0) {
                            de deVar = new de(a11, ebVar.f7874c);
                            dt.a();
                            JSONObject jSONObject = new JSONObject(new String(dt.a(deVar).f7866a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                eu euVar = ebVar.f7877f;
                                if (euVar != null) {
                                    euVar.a(a11.length);
                                }
                                if (ebVar.f7877f.b() < Integer.MAX_VALUE) {
                                    a(a10, arrayList);
                                } else {
                                    try {
                                        a10.c();
                                    } catch (Throwable th) {
                                        df.c(th, "ofm", "dlo");
                                    }
                                }
                                return a11.length;
                            }
                            dqVar = a10;
                        }
                        try {
                            a10.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        return -1;
                    } catch (Throwable th3) {
                        th = th3;
                        dqVar = a10;
                        try {
                            df.c(th, "leg", "uts");
                            if (dqVar != null) {
                                dqVar.close();
                            }
                            return -1;
                        } catch (Throwable th4) {
                            if (dqVar != null) {
                                try {
                                    dqVar.close();
                                } catch (Throwable th5) {
                                    th5.printStackTrace();
                                }
                            }
                            throw th4;
                        }
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
            if (dqVar != null) {
                dqVar.close();
            }
        } catch (Throwable th7) {
            th7.printStackTrace();
        }
        return -1;
    }

    private static byte[] a(dq dqVar, eb ebVar, List<String> list) {
        try {
            File a10 = dqVar.a();
            if (a10 != null && a10.exists()) {
                int i10 = 0;
                for (String str : a10.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a11 = eh.a(dqVar, str2);
                        i10 += a11.length;
                        list.add(str2);
                        if (i10 > ebVar.f7877f.b()) {
                            break;
                        }
                        ebVar.f7878g.b(a11);
                    }
                }
                if (i10 <= 0) {
                    return null;
                }
                return ebVar.f7878g.a();
            }
        } catch (Throwable th) {
            df.c(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(dq dqVar, List<String> list) {
        if (dqVar != null) {
            try {
                Iterator<String> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    dqVar.c(iterator2.next());
                }
                dqVar.close();
            } catch (Throwable th) {
                df.c(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            df.c(th, "leg", IAdInterListener.AdReqParam.FET);
            return false;
        }
    }
}
