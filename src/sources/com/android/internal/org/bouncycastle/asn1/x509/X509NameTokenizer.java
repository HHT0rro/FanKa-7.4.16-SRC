package com.android.internal.org.bouncycastle.asn1.x509;

import org.apache.commons.io.IOUtils;

/* JADX WARN: Classes with same name are omitted:
  C:\Users\35037\Desktop\fankahook\2\class11.dex
 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class11.dex.bak */
public class X509NameTokenizer {
    private StringBuffer buf;
    private int index;
    private char separator;
    private String value;

    public X509NameTokenizer(String oid) {
        this(oid, ',');
    }

    public X509NameTokenizer(String oid, char separator) {
        this.buf = new StringBuffer();
        this.value = oid;
        this.index = -1;
        this.separator = separator;
    }

    public boolean hasMoreTokens() {
        return this.index != this.value.length();
    }

    public String nextToken() {
        if (this.index == this.value.length()) {
            return null;
        }
        int end = this.index + 1;
        boolean quoted = false;
        boolean escaped = false;
        this.buf.setLength(0);
        while (end != this.value.length()) {
            char c4 = this.value.charAt(end);
            if (c4 == '\"') {
                if (!escaped) {
                    quoted = !quoted;
                }
                this.buf.append(c4);
                escaped = false;
            } else if (escaped || quoted) {
                this.buf.append(c4);
                escaped = false;
            } else if (c4 == '\\') {
                this.buf.append(c4);
                escaped = true;
            } else {
                if (c4 == this.separator) {
                    break;
                }
                if (c4 == '#') {
                    StringBuffer stringBuffer = this.buf;
                    if (stringBuffer.charAt(stringBuffer.length() - 1) == '=') {
                        this.buf.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                        this.buf.append(c4);
                    }
                }
                if (c4 == '+' && this.separator != '+') {
                    this.buf.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                }
                this.buf.append(c4);
            }
            end++;
        }
        this.index = end;
        return this.buf.toString();
    }
}
