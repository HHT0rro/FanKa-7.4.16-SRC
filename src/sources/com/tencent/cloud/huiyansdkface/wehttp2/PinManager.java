package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okio.ByteString;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class PinManager {

    /* renamed from: a, reason: collision with root package name */
    private volatile String f42295a;

    /* renamed from: b, reason: collision with root package name */
    private Object f42296b = new Object();

    /* renamed from: c, reason: collision with root package name */
    private List<Pin> f42297c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    private List<Pin> f42298d = new ArrayList();

    private PinManager a(List<Pin> list, String str, String[] strArr) {
        if (str == null) {
            throw new IllegalArgumentException("must set  pin host");
        }
        if (strArr == null) {
            return this;
        }
        synchronized (this.f42296b) {
            for (int length = strArr.length - 1; length >= 0; length--) {
                String str2 = strArr[length];
                if (str2 != null) {
                    list.add(0, new Pin(str, str2));
                }
            }
        }
        return this;
    }

    private List<String> a(List<Pin> list, String str) {
        ArrayList arrayList;
        synchronized (this.f42296b) {
            arrayList = new ArrayList();
            for (Pin pin : list) {
                if (pin.match(str)) {
                    arrayList.add(pin.getPin());
                }
            }
        }
        return arrayList;
    }

    private void a(String str, boolean z10) {
        if (str == null) {
            return;
        }
        Iterator<Pin> iterator2 = (z10 ? this.f42298d : this.f42297c).iterator2();
        while (iterator2.hasNext()) {
            if (iterator2.next().getPattern().equals(str)) {
                iterator2.remove();
            }
        }
    }

    private List<String> b(List<Pin> list, String str) {
        ArrayList arrayList;
        synchronized (this.f42296b) {
            arrayList = new ArrayList();
            for (Pin pin : list) {
                if (pin.getPattern().equals(str)) {
                    arrayList.add(pin.getPin());
                }
            }
        }
        return arrayList;
    }

    public PinManager addErrorPins(String... strArr) {
        return addErrorPins4Host(this.f42295a, strArr);
    }

    public PinManager addErrorPins4Host(String str, String... strArr) {
        return a(this.f42298d, str, strArr);
    }

    public PinManager addPemPins(String... strArr) {
        return addPemPins4Host(this.f42295a, strArr);
    }

    public PinManager addPemPins4Host(String str, String... strArr) {
        LinkedList linkedList = new LinkedList();
        if (strArr != null) {
            for (String str2 : strArr) {
                if (str2 != null && !str2.isEmpty()) {
                    linkedList.add(new Pin(str, "sha256/" + ByteString.decodeHex(HttpsCertificateUtils.getFingerPrint(HttpsCertificateUtils.getCertificate(str2))).base64()));
                }
            }
        }
        synchronized (this.f42296b) {
            this.f42297c.addAll(0, linkedList);
        }
        return this;
    }

    @Deprecated
    public PinManager addPins(List<byte[]> list) {
        return addPins4Host(this.f42295a, list);
    }

    public PinManager addPins(String... strArr) {
        return addPins4Host(this.f42295a, strArr);
    }

    @Deprecated
    public PinManager addPins4Host(String str, List<byte[]> list) {
        if (list == null) {
            return this;
        }
        synchronized (this.f42296b) {
            for (int size = list.size() - 1; size >= 0; size--) {
                byte[] bArr = list.get(size);
                if (bArr != null) {
                    this.f42297c.add(0, new Pin(str, "sha1/" + ByteString.of(bArr).base64()));
                }
            }
        }
        return this;
    }

    public PinManager addPins4Host(String str, String... strArr) {
        return a(this.f42297c, str, strArr);
    }

    public List<Pin> getAllPinErrorList() {
        return Collections.unmodifiableList(this.f42298d);
    }

    public List<Pin> getAllPinList() {
        List<Pin> unmodifiableList;
        synchronized (this.f42296b) {
            unmodifiableList = Collections.unmodifiableList(this.f42297c);
        }
        return unmodifiableList;
    }

    public List<String> getErrorPins() {
        return b(this.f42298d, this.f42295a);
    }

    public List<String> getErrorPins(String str) {
        return a(this.f42298d, str);
    }

    public String[] getPinArray4HostPattern(String str) {
        List<String> b4 = b(this.f42297c, str);
        return (String[]) b4.toArray(new String[b4.size()]);
    }

    public String getPinDefHostPattern() {
        return this.f42295a;
    }

    public List<String> getPinList4HostPattern(String str) {
        return b(this.f42297c, str);
    }

    public List<String> getPins() {
        return b(this.f42297c, this.f42295a);
    }

    public List<String> getPins(String str) {
        return a(this.f42297c, str);
    }

    public String pinListToString() {
        return pinListToString(null);
    }

    public String pinListToString(String str) {
        String trim;
        synchronized (this.f42296b) {
            HashMap hashMap = new HashMap();
            for (Pin pin : this.f42297c) {
                String pattern = pin.getPattern();
                if (str == null || str.equals(pattern)) {
                    List list = (List) hashMap.get(pattern);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(pattern, list);
                    }
                    list.add(pin.getPin());
                }
            }
            StringBuilder sb2 = new StringBuilder();
            for (Map.Entry entry : hashMap.entrySet()) {
                sb2.append(((String) entry.getKey()) + ":\n");
                Iterator iterator2 = ((List) entry.getValue()).iterator2();
                while (iterator2.hasNext()) {
                    sb2.append("\t" + ((String) iterator2.next()));
                }
                sb2.append("\n");
            }
            trim = sb2.toString().trim();
        }
        return trim;
    }

    public PinManager setErrorPins(String... strArr) {
        setErrorPins4Host(this.f42295a, strArr);
        return this;
    }

    public PinManager setErrorPins4Host(String str, String... strArr) {
        PinManager addErrorPins4Host;
        synchronized (this.f42296b) {
            a(str, true);
            addErrorPins4Host = addErrorPins4Host(str, strArr);
        }
        return addErrorPins4Host;
    }

    public PinManager setPinDefHostPattern(String str) {
        if (str != null) {
            this.f42295a = str;
        }
        return this;
    }

    public PinManager setPins(String... strArr) {
        return setPins4Host(this.f42295a, strArr);
    }

    public PinManager setPins4Host(String str, String... strArr) {
        if (str == null) {
            throw new IllegalArgumentException("must set  pin host");
        }
        synchronized (this.f42296b) {
            a(str, false);
            addPins4Host(str, strArr);
        }
        return this;
    }
}
