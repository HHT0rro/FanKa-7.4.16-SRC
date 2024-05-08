package org.joda.time.format;

import java.io.IOException;
import java.util.Locale;
import org.joda.time.DateTimeZone;

/* compiled from: InternalPrinter.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class4.dex */
public interface m {
    int estimatePrintedLength();

    void printTo(Appendable appendable, long j10, org.joda.time.a aVar, int i10, DateTimeZone dateTimeZone, Locale locale) throws IOException;

    void printTo(Appendable appendable, org.joda.time.k kVar, Locale locale) throws IOException;
}
