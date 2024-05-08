package com.google.common.hash;

import com.google.common.base.o;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class Funnels {

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(byte[] bArr, k kVar) {
            kVar.e(bArr);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.integerFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Integer num, k kVar) {
            kVar.a(num.intValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.longFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Long l10, k kVar) {
            kVar.b(l10.longValue());
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        private final Funnel<E> elementFunnel;

        public SequentialFunnel(Funnel<E> funnel) {
            this.elementFunnel = (Funnel) o.r(funnel);
        }

        public boolean equals(Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.elementFunnel);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 26);
            sb2.append("Funnels.sequentialFunnel(");
            sb2.append(valueOf);
            sb2.append(")");
            return sb2.toString();
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(Iterable<? extends E> iterable, k kVar) {
            Iterator<? extends E> iterator2 = iterable.iterator2();
            while (iterator2.hasNext()) {
                this.elementFunnel.funnel(iterator2.next(), kVar);
            }
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        private final Charset charset;

        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public static class SerializedForm implements Serializable {
            private static final long serialVersionUID = 0;
            private final String charsetCanonicalName;

            public SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.a(Charset.forName(this.charsetCanonicalName));
            }
        }

        public StringCharsetFunnel(Charset charset) {
            this.charset = (Charset) o.r(charset);
        }

        public boolean equals(Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        public String toString() {
            String name = this.charset.name();
            StringBuilder sb2 = new StringBuilder(String.valueOf(name).length() + 22);
            sb2.append("Funnels.stringFunnel(");
            sb2.append(name);
            sb2.append(")");
            return sb2.toString();
        }

        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, k kVar) {
            kVar.d(charSequence, this.charset);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        @Override // java.lang.Enum
        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        @Override // com.google.common.hash.Funnel
        public void funnel(CharSequence charSequence, k kVar) {
            kVar.c(charSequence);
        }
    }

    public static Funnel<CharSequence> a(Charset charset) {
        return new StringCharsetFunnel(charset);
    }
}
