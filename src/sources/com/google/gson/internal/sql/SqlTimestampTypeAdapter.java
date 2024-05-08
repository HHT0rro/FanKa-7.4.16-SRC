package com.google.gson.internal.sql;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

/* loaded from: C:\Users\35037\Desktop\fankahook\2\class8.dex */
class SqlTimestampTypeAdapter extends TypeAdapter<Timestamp> {

    /* renamed from: b, reason: collision with root package name */
    public static final TypeAdapterFactory f27026b = new TypeAdapterFactory() { // from class: com.google.gson.internal.sql.SqlTimestampTypeAdapter.1
        @Override // com.google.gson.TypeAdapterFactory
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
            if (typeToken.getRawType() == Timestamp.class) {
                return new SqlTimestampTypeAdapter(gson.getAdapter(Date.class));
            }
            return null;
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final TypeAdapter<Date> f27027a;

    @Override // com.google.gson.TypeAdapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Timestamp read2(JsonReader jsonReader) throws IOException {
        Date read2 = this.f27027a.read2(jsonReader);
        if (read2 != null) {
            return new Timestamp(read2.getTime());
        }
        return null;
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void write(JsonWriter jsonWriter, Timestamp timestamp) throws IOException {
        this.f27027a.write(jsonWriter, timestamp);
    }

    public SqlTimestampTypeAdapter(TypeAdapter<Date> typeAdapter) {
        this.f27027a = typeAdapter;
    }
}
