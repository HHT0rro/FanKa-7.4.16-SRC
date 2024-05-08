package org.joda.time.format;

import java.io.IOException;
import java.io.Writer;
import java.util.Locale;
import org.joda.time.DateTimeZone;

/* compiled from: DateTimePrinter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface f {
    void a(Writer writer, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException;

    void b(StringBuffer stringBuffer, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale);

    void c(Writer writer, org.joda.time.k kVar, Locale locale) throws IOException;

    void d(StringBuffer stringBuffer, org.joda.time.k kVar, Locale locale);

    int estimatePrintedLength();
}
