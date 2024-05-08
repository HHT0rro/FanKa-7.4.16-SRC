package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.DateTimeZone;

/* compiled from: DateTimePrinterInternalPrinter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public class g implements m {

    /* renamed from: b, reason: collision with root package name */
    public final f f52609b;

    public g(f fVar) {
        this.f52609b = fVar;
    }

    public static m a(f fVar) {
        if (fVar == null) {
            return null;
        }
        return new g(fVar);
    }

    @Override // org.joda.time.format.m
    public int estimatePrintedLength() {
        return this.f52609b.estimatePrintedLength();
    }

    @Override // org.joda.time.format.m
    public void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException {
        if (appendable instanceof StringBuffer) {
            this.f52609b.b((StringBuffer) appendable, j10, aVar, i10, dateTimeZone, locale);
        } else if (appendable instanceof Writer) {
            this.f52609b.a((Writer) appendable, j10, aVar, i10, dateTimeZone, locale);
        } else {
            StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
            this.f52609b.b(stringBuffer, j10, aVar, i10, dateTimeZone, locale);
            appendable.append(stringBuffer);
        }
    }

    @Override // org.joda.time.format.m
    public void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException {
        if (appendable instanceof StringBuffer) {
            this.f52609b.d((StringBuffer) appendable, kVar, locale);
        } else if (appendable instanceof Writer) {
            this.f52609b.c((Writer) appendable, kVar, locale);
        } else {
            StringBuffer stringBuffer = new StringBuffer(estimatePrintedLength());
            this.f52609b.d(stringBuffer, kVar, locale);
            appendable.append(stringBuffer);
        }
    }
}
