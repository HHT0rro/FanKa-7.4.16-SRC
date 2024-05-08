package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.C$Gson$Preconditions;
import com.google.gson.internal.JavaVersion;
import com.google.gson.internal.PreJava9DateFormatProvider;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
public final class DefaultDateTypeAdapter<T extends Date> extends TypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    public final DateType<T> f26913a;

    /* renamed from: b, reason: collision with root package name */
    public final List<DateFormat> f26914b;

    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
    public static abstract class DateType<T extends Date> {

        /* renamed from: b, reason: collision with root package name */
        public static final DateType<Date> f26915b = new DateType<Date>(Date.class) { // from class: com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType.1
            @Override // com.google.gson.internal.bind.DefaultDateTypeAdapter.DateType
            public Date d(Date date) {
                return date;
            }
        };

        /* renamed from: a, reason: collision with root package name */
        public final Class<T> f26916a;

        public DateType(Class<T> cls) {
            this.f26916a = cls;
        }

        public final TypeAdapterFactory a(int i10, int i11) {
            return c(new DefaultDateTypeAdapter<>(this, i10, i11));
        }

        public final TypeAdapterFactory b(String str) {
            return c(new DefaultDateTypeAdapter<>(this, str));
        }

        public final TypeAdapterFactory c(DefaultDateTypeAdapter<T> defaultDateTypeAdapter) {
            return TypeAdapters.b(this.f26916a, defaultDateTypeAdapter);
        }

        public abstract T d(Date date);
    }

    public final Date a(JsonReader jsonReader) throws IOException {
        String nextString = jsonReader.nextString();
        synchronized (this.f26914b) {
            Iterator<DateFormat> iterator2 = this.f26914b.iterator2();
            while (iterator2.hasNext()) {
                try {
                    return iterator2.next().parse(nextString);
                } catch (ParseException unused) {
                }
            }
            try {
                return ISO8601Utils.c(nextString, new ParsePosition(0));
            } catch (ParseException e2) {
                throw new JsonSyntaxException("Failed parsing '" + nextString + "' as Date; at path " + jsonReader.getPreviousPath(), e2);
            }
        }
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public T read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        return this.f26913a.d(a(jsonReader));
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Date date) throws IOException {
        String format;
        if (date == null) {
            jsonWriter.nullValue();
            return;
        }
        DateFormat dateFormat = this.f26914b.get(0);
        synchronized (this.f26914b) {
            format = dateFormat.format(date);
        }
        jsonWriter.value(format);
    }

    public String toString() {
        DateFormat dateFormat = this.f26914b.get(0);
        if (dateFormat instanceof SimpleDateFormat) {
            return "DefaultDateTypeAdapter(" + ((SimpleDateFormat) dateFormat).toPattern() + ')';
        }
        return "DefaultDateTypeAdapter(" + dateFormat.getClass().getSimpleName() + ')';
    }

    public DefaultDateTypeAdapter(DateType<T> dateType, String str) {
        ArrayList arrayList = new ArrayList();
        this.f26914b = arrayList;
        this.f26913a = (DateType) C$Gson$Preconditions.b(dateType);
        Locale locale = Locale.US;
        arrayList.add(new SimpleDateFormat(str, locale));
        if (Locale.getDefault().equals(locale)) {
            return;
        }
        arrayList.add(new SimpleDateFormat(str));
    }

    public DefaultDateTypeAdapter(DateType<T> dateType, int i10, int i11) {
        ArrayList arrayList = new ArrayList();
        this.f26914b = arrayList;
        this.f26913a = (DateType) C$Gson$Preconditions.b(dateType);
        Locale locale = Locale.US;
        arrayList.add(DateFormat.getDateTimeInstance(i10, i11, locale));
        if (!Locale.getDefault().equals(locale)) {
            arrayList.add(DateFormat.getDateTimeInstance(i10, i11));
        }
        if (JavaVersion.d()) {
            arrayList.add(PreJava9DateFormatProvider.c(i10, i11));
        }
    }
}
