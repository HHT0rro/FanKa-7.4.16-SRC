package com.amap.api.col.p0003l;

import com.amap.api.col.p0003l.ht;
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
public final class ih {
    public static void a(String str, byte[] bArr, ig igVar) throws IOException, CertificateException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        ht htVar;
        OutputStream outputStream = null;
        try {
            if (a(igVar.f6450a, str)) {
                return;
            }
            File file = new File(igVar.f6450a);
            if (!file.exists()) {
                file.mkdirs();
            }
            htVar = ht.a(file, igVar.f6451b);
            try {
                htVar.a(igVar.f6453d);
                byte[] b4 = igVar.f6454e.b(bArr);
                ht.a b10 = htVar.b(str);
                outputStream = b10.a();
                outputStream.write(b4);
                b10.b();
                htVar.c();
                try {
                    outputStream.close();
                } catch (Throwable th) {
                    th.printStackTrace();
                }
                try {
                    htVar.close();
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
                if (htVar != null) {
                    try {
                        htVar.close();
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
            htVar = null;
        }
    }

    public static int a(ig igVar) {
        ht htVar = null;
        try {
            try {
                if (igVar.f6455f.d()) {
                    igVar.f6455f.a_(true);
                    ht a10 = ht.a(new File(igVar.f6450a), igVar.f6451b);
                    try {
                        ArrayList arrayList = new ArrayList();
                        byte[] a11 = a(a10, igVar, arrayList);
                        if (a11 != null && a11.length != 0) {
                            gx gxVar = new gx(a11, igVar.f6452c);
                            hw.a();
                            JSONObject jSONObject = new JSONObject(new String(hw.a(gxVar).f6444a));
                            if (jSONObject.has("code") && jSONObject.getInt("code") == 1) {
                                ja jaVar = igVar.f6455f;
                                if (jaVar != null) {
                                    jaVar.a_(a11.length);
                                }
                                if (igVar.f6455f.a() < Integer.MAX_VALUE) {
                                    a(a10, arrayList);
                                } else {
                                    try {
                                        a10.d();
                                    } catch (Throwable th) {
                                        gy.b(th, "ofm", "dlo");
                                    }
                                }
                                return a11.length;
                            }
                            htVar = a10;
                        }
                        try {
                            a10.close();
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                        return -1;
                    } catch (Throwable th3) {
                        th = th3;
                        htVar = a10;
                        try {
                            gy.b(th, "leg", "uts");
                            if (htVar != null) {
                                htVar.close();
                            }
                            return -1;
                        } catch (Throwable th4) {
                            if (htVar != null) {
                                try {
                                    htVar.close();
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
            if (htVar != null) {
                htVar.close();
            }
        } catch (Throwable th7) {
            th7.printStackTrace();
        }
        return -1;
    }

    private static byte[] a(ht htVar, ig igVar, List<String> list) {
        try {
            File b4 = htVar.b();
            if (b4 != null && b4.exists()) {
                int i10 = 0;
                for (String str : b4.list()) {
                    if (str.contains(".0")) {
                        String str2 = str.split("\\.")[0];
                        byte[] a10 = in.a(htVar, str2);
                        i10 += a10.length;
                        list.add(str2);
                        if (i10 > igVar.f6455f.a()) {
                            break;
                        }
                        igVar.f6456g.b(a10);
                    }
                }
                if (i10 <= 0) {
                    return null;
                }
                return igVar.f6456g.a();
            }
        } catch (Throwable th) {
            gy.b(th, "leg", "gCo");
        }
        return new byte[0];
    }

    private static void a(ht htVar, List<String> list) {
        if (htVar != null) {
            try {
                Iterator<String> iterator2 = list.iterator2();
                while (iterator2.hasNext()) {
                    htVar.c(iterator2.next());
                }
                htVar.close();
            } catch (Throwable th) {
                gy.b(th, "ofm", "dlo");
            }
        }
    }

    private static boolean a(String str, String str2) {
        try {
            return new File(str, str2 + ".0").exists();
        } catch (Throwable th) {
            gy.b(th, "leg", IAdInterListener.AdReqParam.FET);
            return false;
        }
    }
}
