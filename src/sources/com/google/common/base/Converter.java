package com.google.common.base;

import java.io.Serializable;
import java.util.Iterator;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public abstract class Converter<A, B> implements g<A, B> {
    private final boolean handleNullAutomatically;
    private transient Converter<B, A> reverse;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class ConverterComposition<A, B, C> extends Converter<A, C> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Converter<A, B> first;
        public final Converter<B, C> second;

        public ConverterComposition(Converter<A, B> converter, Converter<B, C> converter2) {
            this.first = converter;
            this.second = converter2;
        }

        @Override // com.google.common.base.Converter
        public A correctedDoBackward(C c4) {
            return (A) this.first.correctedDoBackward(this.second.correctedDoBackward(c4));
        }

        @Override // com.google.common.base.Converter
        public C correctedDoForward(A a10) {
            return (C) this.second.correctedDoForward(this.first.correctedDoForward(a10));
        }

        @Override // com.google.common.base.Converter
        public A doBackward(C c4) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public C doForward(A a10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object obj) {
            if (!(obj instanceof ConverterComposition)) {
                return false;
            }
            ConverterComposition converterComposition = (ConverterComposition) obj;
            return this.first.equals(converterComposition.first) && this.second.equals(converterComposition.second);
        }

        public int hashCode() {
            return (this.first.hashCode() * 31) + this.second.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.first);
            String valueOf2 = String.valueOf(this.second);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10 + valueOf2.length());
            sb2.append(valueOf);
            sb2.append(".andThen(");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class FunctionBasedConverter<A, B> extends Converter<A, B> implements Serializable {
        private final g<? super B, ? extends A> backwardFunction;
        private final g<? super A, ? extends B> forwardFunction;

        public /* synthetic */ FunctionBasedConverter(g gVar, g gVar2, a aVar) {
            this(gVar, gVar2);
        }

        @Override // com.google.common.base.Converter
        public A doBackward(B b4) {
            return this.backwardFunction.apply(b4);
        }

        @Override // com.google.common.base.Converter
        public B doForward(A a10) {
            return this.forwardFunction.apply(a10);
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object obj) {
            if (!(obj instanceof FunctionBasedConverter)) {
                return false;
            }
            FunctionBasedConverter functionBasedConverter = (FunctionBasedConverter) obj;
            return this.forwardFunction.equals(functionBasedConverter.forwardFunction) && this.backwardFunction.equals(functionBasedConverter.backwardFunction);
        }

        public int hashCode() {
            return (this.forwardFunction.hashCode() * 31) + this.backwardFunction.hashCode();
        }

        public String toString() {
            String valueOf = String.valueOf(this.forwardFunction);
            String valueOf2 = String.valueOf(this.backwardFunction);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 18 + valueOf2.length());
            sb2.append("Converter.from(");
            sb2.append(valueOf);
            sb2.append(", ");
            sb2.append(valueOf2);
            sb2.append(")");
            return sb2.toString();
        }

        private FunctionBasedConverter(g<? super A, ? extends B> gVar, g<? super B, ? extends A> gVar2) {
            this.forwardFunction = (g) o.r(gVar);
            this.backwardFunction = (g) o.r(gVar2);
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class IdentityConverter<T> extends Converter<T, T> implements Serializable {
        public static final IdentityConverter<?> INSTANCE = new IdentityConverter<>();
        private static final long serialVersionUID = 0;

        private IdentityConverter() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Converter
        public <S> Converter<T, S> doAndThen(Converter<T, S> converter) {
            return (Converter) o.s(converter, "otherConverter");
        }

        @Override // com.google.common.base.Converter
        public T doBackward(T t2) {
            return t2;
        }

        @Override // com.google.common.base.Converter
        public T doForward(T t2) {
            return t2;
        }

        @Override // com.google.common.base.Converter
        public IdentityConverter<T> reverse() {
            return this;
        }

        public String toString() {
            return "Converter.identity()";
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static final class ReverseConverter<A, B> extends Converter<B, A> implements Serializable {
        private static final long serialVersionUID = 0;
        public final Converter<A, B> original;

        public ReverseConverter(Converter<A, B> converter) {
            this.original = converter;
        }

        @Override // com.google.common.base.Converter
        public B correctedDoBackward(A a10) {
            return this.original.correctedDoForward(a10);
        }

        @Override // com.google.common.base.Converter
        public A correctedDoForward(B b4) {
            return this.original.correctedDoBackward(b4);
        }

        @Override // com.google.common.base.Converter
        public B doBackward(A a10) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter
        public A doForward(B b4) {
            throw new AssertionError();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object obj) {
            if (obj instanceof ReverseConverter) {
                return this.original.equals(((ReverseConverter) obj).original);
            }
            return false;
        }

        public int hashCode() {
            return ~this.original.hashCode();
        }

        @Override // com.google.common.base.Converter
        public Converter<A, B> reverse() {
            return this.original;
        }

        public String toString() {
            String valueOf = String.valueOf(this.original);
            StringBuilder sb2 = new StringBuilder(valueOf.length() + 10);
            sb2.append(valueOf);
            sb2.append(".reverse()");
            return sb2.toString();
        }
    }

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public class a implements Iterable<B> {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Iterable f25939b;

        /* renamed from: com.google.common.base.Converter$a$a, reason: collision with other inner class name */
        /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
        public class C0221a implements Iterator<B> {

            /* renamed from: b, reason: collision with root package name */
            public final Iterator<? extends A> f25941b;

            public C0221a() {
                this.f25941b = a.this.f25939b.iterator2();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f25941b.hasNext();
            }

            @Override // java.util.Iterator
            public B next() {
                return (B) Converter.this.convert(this.f25941b.next());
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f25941b.remove();
            }
        }

        public a(Iterable iterable) {
            this.f25939b = iterable;
        }

        @Override // java.lang.Iterable
        /* renamed from: iterator */
        public Iterator<B> iterator2() {
            return new C0221a();
        }
    }

    public Converter() {
        this(true);
    }

    public static <A, B> Converter<A, B> from(g<? super A, ? extends B> gVar, g<? super B, ? extends A> gVar2) {
        return new FunctionBasedConverter(gVar, gVar2, null);
    }

    public static <T> Converter<T, T> identity() {
        return IdentityConverter.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private A unsafeDoBackward(B b4) {
        return (A) doBackward(k.a(b4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private B unsafeDoForward(A a10) {
        return (B) doForward(k.a(a10));
    }

    public final <C> Converter<A, C> andThen(Converter<B, C> converter) {
        return doAndThen(converter);
    }

    @Override // com.google.common.base.g
    @Deprecated
    public final B apply(A a10) {
        return convert(a10);
    }

    public final B convert(A a10) {
        return correctedDoForward(a10);
    }

    public Iterable<B> convertAll(Iterable<? extends A> iterable) {
        o.s(iterable, "fromIterable");
        return new a(iterable);
    }

    public A correctedDoBackward(B b4) {
        if (!this.handleNullAutomatically) {
            return unsafeDoBackward(b4);
        }
        if (b4 == null) {
            return null;
        }
        return (A) o.r(doBackward(b4));
    }

    public B correctedDoForward(A a10) {
        if (!this.handleNullAutomatically) {
            return unsafeDoForward(a10);
        }
        if (a10 == null) {
            return null;
        }
        return (B) o.r(doForward(a10));
    }

    public <C> Converter<A, C> doAndThen(Converter<B, C> converter) {
        return new ConverterComposition(this, (Converter) o.r(converter));
    }

    public abstract A doBackward(B b4);

    public abstract B doForward(A a10);

    @Override // com.google.common.base.g
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Converter<B, A> reverse() {
        Converter<B, A> converter = this.reverse;
        if (converter != null) {
            return converter;
        }
        ReverseConverter reverseConverter = new ReverseConverter(this);
        this.reverse = reverseConverter;
        return reverseConverter;
    }

    public Converter(boolean z10) {
        this.handleNullAutomatically = z10;
    }
}
