package sun.net.www;

import com.alipay.sdk.util.i;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
public class MessageHeader {
    private String[] keys;
    private int nkeys;
    private String[] values;

    public MessageHeader() {
        grow();
    }

    public MessageHeader(InputStream is) throws IOException {
        parseHeader(is);
    }

    public synchronized String getHeaderNamesInList() {
        StringJoiner joiner;
        joiner = new StringJoiner(",");
        for (int i10 = 0; i10 < this.nkeys; i10++) {
            joiner.add(this.keys[i10]);
        }
        return joiner.toString();
    }

    public synchronized void reset() {
        this.keys = null;
        this.values = null;
        this.nkeys = 0;
        grow();
    }

    public synchronized String findValue(String k10) {
        if (k10 == null) {
            int i10 = this.nkeys;
            do {
                i10--;
                if (i10 >= 0) {
                }
            } while (this.keys[i10] != null);
            return this.values[i10];
        }
        int i11 = this.nkeys;
        do {
            i11--;
            if (i11 >= 0) {
            }
        } while (!k10.equalsIgnoreCase(this.keys[i11]));
        return this.values[i11];
        return null;
    }

    public synchronized int getKey(String k10) {
        int i10 = this.nkeys;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            String str = this.keys[i10];
            if (str == k10 || (k10 != null && k10.equalsIgnoreCase(str))) {
                break;
            }
        }
        return i10;
    }

    public synchronized String getKey(int n10) {
        if (n10 >= 0) {
            if (n10 < this.nkeys) {
                return this.keys[n10];
            }
        }
        return null;
    }

    public synchronized String getValue(int n10) {
        if (n10 >= 0) {
            if (n10 < this.nkeys) {
                return this.values[n10];
            }
        }
        return null;
    }

    public synchronized String findNextValue(String k10, String v2) {
        boolean foundV = false;
        if (k10 == null) {
            int i10 = this.nkeys;
            while (true) {
                i10--;
                if (i10 < 0) {
                    break;
                }
                if (this.keys[i10] == null) {
                    if (foundV) {
                        return this.values[i10];
                    }
                    if (this.values[i10] == v2) {
                        foundV = true;
                    }
                }
            }
        } else {
            int i11 = this.nkeys;
            while (true) {
                i11--;
                if (i11 < 0) {
                    break;
                }
                if (k10.equalsIgnoreCase(this.keys[i11])) {
                    if (foundV) {
                        return this.values[i11];
                    }
                    if (this.values[i11] == v2) {
                        foundV = true;
                    }
                }
            }
        }
        return null;
    }

    public boolean filterNTLMResponses(String k10) {
        int i10;
        String str;
        boolean found = false;
        int i11 = 0;
        while (true) {
            if (i11 < this.nkeys) {
                if (!k10.equalsIgnoreCase(this.keys[i11]) || (str = this.values[i11]) == null || str.length() <= 5 || !this.values[i11].substring(0, 5).equalsIgnoreCase("NTLM ")) {
                    i11++;
                } else {
                    found = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (found) {
            int j10 = 0;
            int i12 = 0;
            while (true) {
                i10 = this.nkeys;
                if (i12 >= i10) {
                    break;
                }
                if (!k10.equalsIgnoreCase(this.keys[i12]) || (!"Negotiate".equalsIgnoreCase(this.values[i12]) && !"Kerberos".equalsIgnoreCase(this.values[i12]))) {
                    if (i12 != j10) {
                        String[] strArr = this.keys;
                        strArr[j10] = strArr[i12];
                        String[] strArr2 = this.values;
                        strArr2[j10] = strArr2[i12];
                    }
                    j10++;
                }
                i12++;
            }
            if (j10 != i10) {
                this.nkeys = j10;
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class5.dex
 */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class5.dex.bak */
    class HeaderIterator implements Iterator<String> {
        String key;
        Object lock;
        int index = 0;
        int next = -1;
        boolean haveNext = false;

        public HeaderIterator(String k10, Object lock) {
            this.key = k10;
            this.lock = lock;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            synchronized (this.lock) {
                if (this.haveNext) {
                    return true;
                }
                while (this.index < MessageHeader.this.nkeys) {
                    if (this.key.equalsIgnoreCase(MessageHeader.this.keys[this.index])) {
                        this.haveNext = true;
                        int i10 = this.index;
                        this.index = i10 + 1;
                        this.next = i10;
                        return true;
                    }
                    this.index++;
                }
                return false;
            }
        }

        @Override // java.util.Iterator
        public String next() {
            synchronized (this.lock) {
                if (this.haveNext) {
                    this.haveNext = false;
                    return MessageHeader.this.values[this.next];
                }
                if (hasNext()) {
                    return next();
                }
                throw new NoSuchElementException("No more elements");
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("remove not allowed");
        }
    }

    public Iterator<String> multiValueIterator(String k10) {
        return new HeaderIterator(k10, this);
    }

    public synchronized Map<String, List<String>> getHeaders() {
        return getHeaders(null);
    }

    public synchronized Map<String, List<String>> getHeaders(String[] excludeList) {
        return filterAndAddHeaders(excludeList, null);
    }

    public synchronized Map<String, List<String>> filterAndAddHeaders(String[] excludeList, Map<String, List<String>> include) {
        Map<String, List<String>> m10;
        boolean skipIt = false;
        m10 = new HashMap<>();
        int i10 = this.nkeys;
        while (true) {
            i10--;
            if (i10 < 0) {
                break;
            }
            if (excludeList != null) {
                int j10 = 0;
                while (true) {
                    if (j10 >= excludeList.length) {
                        break;
                    }
                    if (excludeList[j10] == null || !excludeList[j10].equalsIgnoreCase(this.keys[i10])) {
                        j10++;
                    } else {
                        skipIt = true;
                        break;
                    }
                }
            }
            if (!skipIt) {
                List<String> l10 = m10.get(this.keys[i10]);
                if (l10 == null) {
                    l10 = new ArrayList<>();
                    m10.put(this.keys[i10], l10);
                }
                l10.add(this.values[i10]);
            } else {
                skipIt = false;
            }
        }
        if (include != null) {
            for (Map.Entry<String, List<String>> entry : include.entrySet()) {
                List<String> l11 = m10.get(entry.getKey());
                if (l11 == null) {
                    l11 = new ArrayList<>();
                    m10.put(entry.getKey(), l11);
                }
                l11.addAll(entry.getValue());
            }
        }
        for (String key : m10.h()) {
            m10.put(key, Collections.unmodifiableList(m10.get(key)));
        }
        return Collections.unmodifiableMap(m10);
    }

    public synchronized void print(PrintStream p10) {
        for (int i10 = 0; i10 < this.nkeys; i10++) {
            if (this.keys[i10] != null) {
                p10.print(this.keys[i10] + (this.values[i10] != null ? ": " + this.values[i10] : "") + IOUtils.LINE_SEPARATOR_WINDOWS);
            }
        }
        p10.print(IOUtils.LINE_SEPARATOR_WINDOWS);
        p10.flush();
    }

    public synchronized void add(String k10, String v2) {
        grow();
        String[] strArr = this.keys;
        int i10 = this.nkeys;
        strArr[i10] = k10;
        this.values[i10] = v2;
        this.nkeys = i10 + 1;
    }

    public synchronized void prepend(String k10, String v2) {
        grow();
        for (int i10 = this.nkeys; i10 > 0; i10--) {
            String[] strArr = this.keys;
            strArr[i10] = strArr[i10 - 1];
            String[] strArr2 = this.values;
            strArr2[i10] = strArr2[i10 - 1];
        }
        this.keys[0] = k10;
        this.values[0] = v2;
        this.nkeys++;
    }

    public synchronized void set(int i10, String k10, String v2) {
        grow();
        if (i10 < 0) {
            return;
        }
        if (i10 >= this.nkeys) {
            add(k10, v2);
        } else {
            this.keys[i10] = k10;
            this.values[i10] = v2;
        }
    }

    private void grow() {
        String[] strArr = this.keys;
        if (strArr == null || this.nkeys >= strArr.length) {
            int i10 = this.nkeys;
            String[] nk = new String[i10 + 4];
            String[] nv = new String[i10 + 4];
            if (strArr != null) {
                System.arraycopy(strArr, 0, nk, 0, i10);
            }
            String[] strArr2 = this.values;
            if (strArr2 != null) {
                System.arraycopy(strArr2, 0, nv, 0, this.nkeys);
            }
            this.keys = nk;
            this.values = nv;
        }
    }

    public synchronized void remove(String k10) {
        int i10;
        int i11;
        if (k10 == null) {
            for (int i12 = 0; i12 < this.nkeys; i12++) {
                while (this.keys[i12] == null && i12 < this.nkeys) {
                    int j10 = i12;
                    while (true) {
                        i11 = this.nkeys;
                        if (j10 < i11 - 1) {
                            String[] strArr = this.keys;
                            strArr[j10] = strArr[j10 + 1];
                            String[] strArr2 = this.values;
                            strArr2[j10] = strArr2[j10 + 1];
                            j10++;
                        }
                    }
                    this.nkeys = i11 - 1;
                }
            }
        } else {
            for (int i13 = 0; i13 < this.nkeys; i13++) {
                while (k10.equalsIgnoreCase(this.keys[i13]) && i13 < this.nkeys) {
                    int j11 = i13;
                    while (true) {
                        i10 = this.nkeys;
                        if (j11 < i10 - 1) {
                            String[] strArr3 = this.keys;
                            strArr3[j11] = strArr3[j11 + 1];
                            String[] strArr4 = this.values;
                            strArr4[j11] = strArr4[j11 + 1];
                            j11++;
                        }
                    }
                    this.nkeys = i10 - 1;
                }
            }
        }
    }

    public synchronized void set(String k10, String v2) {
        int i10 = this.nkeys;
        do {
            i10--;
            if (i10 < 0) {
                add(k10, v2);
                return;
            }
        } while (!k10.equalsIgnoreCase(this.keys[i10]));
        this.values[i10] = v2;
    }

    public synchronized void setIfNotSet(String k10, String v2) {
        if (findValue(k10) == null) {
            add(k10, v2);
        }
    }

    public static String canonicalID(String id2) {
        int c4;
        if (id2 == null) {
            return "";
        }
        int st = 0;
        int len = id2.length();
        boolean substr = false;
        while (st < len && ((c4 = id2.charAt(st)) == 60 || c4 <= 32)) {
            st++;
            substr = true;
        }
        while (st < len) {
            int c10 = id2.charAt(len - 1);
            if (c10 != 62 && c10 > 32) {
                break;
            }
            len--;
            substr = true;
        }
        return substr ? id2.substring(st, len) : id2;
    }

    public void parseHeader(InputStream is) throws IOException {
        synchronized (this) {
            this.nkeys = 0;
        }
        mergeHeader(is);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:15:0x0029. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mergeHeader(java.io.InputStream r13) throws java.io.IOException {
        /*
            r12 = this;
            if (r13 != 0) goto L3
            return
        L3:
            r0 = 10
            char[] r1 = new char[r0]
            int r2 = r13.read()
        Lb:
            if (r2 == r0) goto La4
            r3 = 13
            if (r2 == r3) goto La4
            if (r2 < 0) goto La4
            r4 = 0
            r5 = -1
            r6 = 0
            r7 = 32
            if (r2 <= r7) goto L1c
            r8 = 1
            goto L1d
        L1c:
            r8 = r6
        L1d:
            int r9 = r4 + 1
            char r10 = (char) r2
            r1[r4] = r10
        L22:
            int r4 = r13.read()
            r10 = r4
            if (r4 < 0) goto L68
            switch(r10) {
                case 9: goto L51;
                case 10: goto L35;
                case 13: goto L35;
                case 32: goto L53;
                case 58: goto L2d;
                default: goto L2c;
            }
        L2c:
            goto L55
        L2d:
            if (r8 == 0) goto L32
            if (r9 <= 0) goto L32
            r5 = r9
        L32:
            r4 = 0
            r8 = r4
            goto L55
        L35:
            int r2 = r13.read()
            if (r10 != r3) goto L47
            if (r2 != r0) goto L47
            int r2 = r13.read()
            if (r2 != r3) goto L47
            int r2 = r13.read()
        L47:
            if (r2 == r0) goto L69
            if (r2 == r3) goto L69
            if (r2 <= r7) goto L4e
            goto L69
        L4e:
            r10 = 32
            goto L55
        L51:
            r10 = 32
        L53:
            r4 = 0
            r8 = r4
        L55:
            int r4 = r1.length
            if (r9 < r4) goto L61
            int r4 = r1.length
            int r4 = r4 * 2
            char[] r4 = new char[r4]
            java.lang.System.arraycopy(r1, r6, r4, r6, r9)
            r1 = r4
        L61:
            int r4 = r9 + 1
            char r11 = (char) r10
            r1[r9] = r11
            r9 = r4
            goto L22
        L68:
            r2 = -1
        L69:
            if (r9 <= 0) goto L74
            int r3 = r9 + (-1)
            char r3 = r1[r3]
            if (r3 > r7) goto L74
            int r9 = r9 + (-1)
            goto L69
        L74:
            if (r5 > 0) goto L79
            r3 = 0
            r4 = 0
            goto L91
        L79:
            java.lang.String r3 = java.lang.String.copyValueOf(r1, r6, r5)
            if (r5 >= r9) goto L87
            char r4 = r1[r5]
            r6 = 58
            if (r4 != r6) goto L87
            int r5 = r5 + 1
        L87:
            if (r5 >= r9) goto L90
            char r4 = r1[r5]
            if (r4 > r7) goto L90
            int r5 = r5 + 1
            goto L87
        L90:
            r4 = r5
        L91:
            if (r4 < r9) goto L99
            java.lang.String r5 = new java.lang.String
            r5.<init>()
            goto L9f
        L99:
            int r5 = r9 - r4
            java.lang.String r5 = java.lang.String.copyValueOf(r1, r4, r5)
        L9f:
            r12.add(r3, r5)
            goto Lb
        La4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.net.www.MessageHeader.mergeHeader(java.io.InputStream):void");
    }

    public synchronized String toString() {
        String result;
        result = super.toString() + this.nkeys + " pairs: ";
        for (int i10 = 0; i10 < this.keys.length && i10 < this.nkeys; i10++) {
            result = result + "{" + this.keys[i10] + ": " + this.values[i10] + i.f4738d;
        }
        return result;
    }
}
