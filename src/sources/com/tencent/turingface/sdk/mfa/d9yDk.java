package com.tencent.turingface.sdk.mfa;

import androidx.recyclerview.widget.ItemTouchHelper;
import com.android.internal.accessibility.common.ShortcutConstants;
import com.huawei.flexiblelayout.u0;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class d9yDk {

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f45757a = {"px", t.f36232q, "sp", "pt", u0.f28637e, "mm"};

    /* renamed from: b, reason: collision with root package name */
    public e7l68 f45758b;

    /* renamed from: c, reason: collision with root package name */
    public Map<String, String> f45759c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public byte[] f45760d;

    /* renamed from: e, reason: collision with root package name */
    public String[] f45761e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f45762f;

    /* renamed from: g, reason: collision with root package name */
    public int f45763g;

    /* renamed from: h, reason: collision with root package name */
    public int f45764h;

    /* renamed from: i, reason: collision with root package name */
    public int f45765i;

    /* renamed from: j, reason: collision with root package name */
    public int f45766j;

    public final Document a(InputStream inputStream) throws IOException, ParserConfigurationException {
        String b4;
        String str;
        Element createElementNS;
        String format;
        byte[] bArr;
        e7l68 e7l68Var = new e7l68();
        this.f45758b = e7l68Var;
        byte[] bArr2 = new byte[inputStream.available()];
        this.f45760d = bArr2;
        inputStream.read(bArr2);
        inputStream.close();
        while (true) {
            int i10 = this.f45766j;
            if (i10 < this.f45760d.length) {
                int a10 = a(i10);
                int i11 = -1;
                if (a10 == -1) {
                    this.f45758b.getClass();
                } else if (a10 == 524291) {
                    e7l68 e7l68Var2 = this.f45758b;
                    Document newDocument = e7l68Var2.f45769c.newDocument();
                    e7l68Var2.f45768b = newDocument;
                    e7l68Var2.f45767a.push(newDocument);
                    this.f45766j += 8;
                } else if (a10 == 524672) {
                    int a11 = a(this.f45766j + 4);
                    int i12 = (a11 / 4) - 2;
                    this.f45765i = i12;
                    this.f45762f = new int[i12];
                    for (int i13 = 0; i13 < this.f45765i; i13++) {
                        this.f45762f[i13] = a(((i13 + 2) * 4) + this.f45766j);
                    }
                    this.f45766j += a11;
                } else if (a10 != 1835009) {
                    switch (a10) {
                        case 1048832:
                            a(true);
                            break;
                        case 1048833:
                            a(false);
                            break;
                        case 1048834:
                            int a12 = a(this.f45766j + 16);
                            int a13 = a(this.f45766j + 20);
                            int i14 = this.f45766j + 28;
                            byte[] bArr3 = this.f45760d;
                            int i15 = (65280 & (bArr3[i14 + 1] << 8)) | ((bArr3[i14 + 0] << 0) & 255);
                            String b10 = b(a13);
                            if (a12 == -1) {
                                str = b10;
                                b4 = "";
                            } else {
                                b4 = b(a12);
                                str = this.f45759c.containsKey(b4) ? this.f45759c.get(b4) + ShortcutConstants.SERVICES_SEPARATOR + b10 : b10;
                            }
                            this.f45766j += 36;
                            tLlmS[] tllmsArr = new tLlmS[i15];
                            int i16 = 0;
                            while (i16 < i15) {
                                int a14 = a(this.f45766j);
                                int a15 = a(this.f45766j + 4);
                                int a16 = a(this.f45766j + 8);
                                int a17 = a(this.f45766j + 12);
                                int a18 = a(this.f45766j + 16);
                                tLlmS tllms = new tLlmS();
                                tllms.f45944a = b(a15);
                                if (a14 == i11) {
                                    tllms.f45946c = null;
                                    tllms.f45945b = null;
                                } else {
                                    String b11 = b(a14);
                                    if (this.f45759c.containsKey(b11)) {
                                        tllms.f45946c = b11;
                                        tllms.f45945b = this.f45759c.get(b11);
                                    }
                                }
                                if (a16 == i11) {
                                    switch (a17) {
                                        case 16777224:
                                            format = String.format("@id/0x%08X", Integer.valueOf(a18));
                                            break;
                                        case 33554440:
                                            format = String.format("?id/0x%08X", Integer.valueOf(a18));
                                            break;
                                        case 50331656:
                                            format = b(a18);
                                            break;
                                        case 67108872:
                                            format = Float.toString(Float.intBitsToFloat(a18));
                                            break;
                                        case 83886088:
                                            format = Integer.toString(a18 >> 8) + f45757a[a18 & 255];
                                            break;
                                        case 100663304:
                                            format = new DecimalFormat("#.##%").format(a18 / 2.147483647E9d);
                                            break;
                                        case 268435464:
                                        case 285212680:
                                            format = Integer.toString(a18);
                                            break;
                                        case 301989896:
                                            format = Boolean.toString(a18 != 0);
                                            break;
                                        case 469762056:
                                        case 486539272:
                                            format = String.format("#%08X", Integer.valueOf(a18));
                                            break;
                                        default:
                                            format = String.format("%08X/0x%08X", Integer.valueOf(a17), Integer.valueOf(a18));
                                            break;
                                    }
                                    tllms.f45947d = format;
                                } else {
                                    tllms.f45947d = b(a16);
                                }
                                tllmsArr[i16] = tllms;
                                this.f45766j += 20;
                                i16++;
                                i11 = -1;
                            }
                            e7l68 e7l68Var3 = this.f45758b;
                            e7l68Var3.getClass();
                            if (b4 == null || "".equals(b4)) {
                                createElementNS = e7l68Var3.f45768b.createElement(b10);
                            } else {
                                createElementNS = e7l68Var3.f45768b.createElementNS(b4, str);
                            }
                            for (int i17 = 0; i17 < i15; i17++) {
                                tLlmS tllms2 = tllmsArr[i17];
                                String str2 = tllms2.f45946c;
                                if (str2 == null || "".equals(str2)) {
                                    createElementNS.setAttribute(tllms2.f45944a, tllms2.f45947d);
                                } else {
                                    createElementNS.setAttributeNS(tllms2.f45946c, tllms2.f45945b + ShortcutConstants.SERVICES_SEPARATOR + tllms2.f45944a, tllms2.f45947d);
                                }
                            }
                            e7l68Var3.f45767a.peek().appendChild(createElementNS);
                            e7l68Var3.f45767a.push(createElementNS);
                            break;
                        case 1048835:
                            int a19 = a(this.f45766j + 16);
                            b(a(this.f45766j + 20));
                            if (a19 != -1) {
                                b(a19);
                            }
                            this.f45758b.f45767a.pop();
                            this.f45766j += 24;
                            break;
                        case 1048836:
                            String b12 = b(a(this.f45766j + 16));
                            e7l68 e7l68Var4 = this.f45758b;
                            e7l68Var4.f45767a.peek().appendChild(e7l68Var4.f45768b.createCDATASection(b12));
                            this.f45766j += 28;
                            break;
                        default:
                            this.f45766j += 4;
                            break;
                    }
                } else {
                    int a20 = a(this.f45766j + 4);
                    this.f45763g = a(this.f45766j + 8);
                    this.f45764h = a(this.f45766j + 12);
                    int i18 = this.f45766j;
                    int a21 = a(i18 + 20) + i18;
                    int a22 = a(this.f45766j + 24);
                    this.f45761e = new String[this.f45763g];
                    for (int i19 = 0; i19 < this.f45763g; i19++) {
                        int a23 = a(((i19 + 7) * 4) + this.f45766j) + a21;
                        String[] strArr = this.f45761e;
                        byte[] bArr4 = this.f45760d;
                        int i20 = a23 + 1;
                        if (bArr4[i20] == bArr4[a23]) {
                            int i21 = bArr4[a23];
                            bArr = new byte[i21];
                            for (int i22 = 0; i22 < i21; i22++) {
                                bArr[i22] = this.f45760d[a23 + 2 + i22];
                            }
                        } else {
                            int i23 = (bArr4[a23] & 255) | ((bArr4[i20] << 8) & 65280);
                            bArr = new byte[i23];
                            for (int i24 = 0; i24 < i23; i24++) {
                                bArr[i24] = this.f45760d[(i24 * 2) + a23 + 2];
                            }
                        }
                        strArr[i19] = new String(bArr);
                    }
                    if (a22 > 0) {
                        for (int i25 = 0; i25 < this.f45764h; i25++) {
                        }
                    }
                    this.f45766j += a20;
                }
            } else {
                this.f45758b.getClass();
                return e7l68Var.f45768b;
            }
        }
    }

    public final String b(int i10) {
        if (i10 < 0 || i10 >= this.f45763g) {
            return null;
        }
        return this.f45761e[i10];
    }

    /* JADX WARN: Type inference failed for: r3v6, types: [java.util.Map<java.lang.String, java.lang.String>, java.util.HashMap] */
    public final void a(boolean z10) {
        int a10 = a(this.f45766j + 16);
        String b4 = b(a(this.f45766j + 20));
        String b10 = b(a10);
        if (z10) {
            this.f45758b.getClass();
            this.f45759c.put(b4, b10);
        } else {
            this.f45758b.getClass();
            this.f45759c.remove(b4);
        }
        this.f45766j += 24;
    }

    public final int a(int i10) {
        byte[] bArr = this.f45760d;
        return ((bArr[i10 + 0] << 0) & 255) | ((bArr[i10 + 3] << 24) & (-16777216)) | ((bArr[i10 + 2] << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((bArr[i10 + 1] << 8) & 65280);
    }
}
