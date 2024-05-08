package p6;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.util.j0;
import com.google.android.exoplayer2.util.x;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.i1;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: CachedContentIndex.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap<String, g> f52880a;

    /* renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f52881b;

    /* renamed from: c, reason: collision with root package name */
    public final SparseBooleanArray f52882c;

    /* renamed from: d, reason: collision with root package name */
    public final SparseBooleanArray f52883d;

    /* renamed from: e, reason: collision with root package name */
    public c f52884e;

    /* renamed from: f, reason: collision with root package name */
    @Nullable
    public c f52885f;

    /* compiled from: CachedContentIndex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static final class a implements c {

        /* renamed from: e, reason: collision with root package name */
        public static final String[] f52886e = {"id", "key", "metadata"};

        /* renamed from: a, reason: collision with root package name */
        public final y4.a f52887a;

        /* renamed from: b, reason: collision with root package name */
        public final SparseArray<g> f52888b = new SparseArray<>();

        /* renamed from: c, reason: collision with root package name */
        public String f52889c;

        /* renamed from: d, reason: collision with root package name */
        public String f52890d;

        public a(y4.a aVar) {
            this.f52887a = aVar;
        }

        public static void i(y4.a aVar, String str) throws DatabaseIOException {
            try {
                String m10 = m(str);
                SQLiteDatabase writableDatabase = aVar.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    y4.c.c(writableDatabase, 1, str);
                    k(writableDatabase, m10);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        public static void k(SQLiteDatabase sQLiteDatabase, String str) {
            String valueOf = String.valueOf(str);
            sQLiteDatabase.execSQL(valueOf.length() != 0 ? "DROP TABLE IF EXISTS ".concat(valueOf) : new String("DROP TABLE IF EXISTS "));
        }

        public static String m(String str) {
            String valueOf = String.valueOf(str);
            return valueOf.length() != 0 ? "ExoPlayerCacheIndex".concat(valueOf) : new String("ExoPlayerCacheIndex");
        }

        @Override // p6.h.c
        public void a(long j10) {
            String hexString = Long.toHexString(j10);
            this.f52889c = hexString;
            this.f52890d = m(hexString);
        }

        @Override // p6.h.c
        public void b(HashMap<String, g> hashMap) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f52887a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    n(writableDatabase);
                    Iterator<g> iterator2 = hashMap.values().iterator2();
                    while (iterator2.hasNext()) {
                        h(writableDatabase, iterator2.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f52888b.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // p6.h.c
        public boolean c() throws DatabaseIOException {
            return y4.c.b(this.f52887a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f52889c)) != -1;
        }

        @Override // p6.h.c
        public void d(HashMap<String, g> hashMap) throws IOException {
            if (this.f52888b.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f52887a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i10 = 0; i10 < this.f52888b.size(); i10++) {
                    try {
                        g valueAt = this.f52888b.valueAt(i10);
                        if (valueAt == null) {
                            j(writableDatabase, this.f52888b.keyAt(i10));
                        } else {
                            h(writableDatabase, valueAt);
                        }
                    } finally {
                        writableDatabase.endTransaction();
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f52888b.clear();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // p6.h.c
        public void delete() throws DatabaseIOException {
            i(this.f52887a, (String) com.google.android.exoplayer2.util.a.e(this.f52889c));
        }

        @Override // p6.h.c
        public void e(g gVar) {
            this.f52888b.put(gVar.f52873a, gVar);
        }

        @Override // p6.h.c
        public void f(g gVar, boolean z10) {
            if (z10) {
                this.f52888b.delete(gVar.f52873a);
            } else {
                this.f52888b.put(gVar.f52873a, null);
            }
        }

        @Override // p6.h.c
        public void g(HashMap<String, g> hashMap, SparseArray<String> sparseArray) throws IOException {
            com.google.android.exoplayer2.util.a.g(this.f52888b.size() == 0);
            try {
                if (y4.c.b(this.f52887a.getReadableDatabase(), 1, (String) com.google.android.exoplayer2.util.a.e(this.f52889c)) != 1) {
                    SQLiteDatabase writableDatabase = this.f52887a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        n(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor l10 = l();
                while (l10.moveToNext()) {
                    try {
                        g gVar = new g(l10.getInt(0), (String) com.google.android.exoplayer2.util.a.e(l10.getString(1)), h.q(new DataInputStream(new ByteArrayInputStream(l10.getBlob(2)))));
                        hashMap.put(gVar.f52874b, gVar);
                        sparseArray.put(gVar.f52873a, gVar.f52874b);
                    } finally {
                    }
                }
                l10.close();
            } catch (SQLiteException e2) {
                hashMap.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e2);
            }
        }

        public final void h(SQLiteDatabase sQLiteDatabase, g gVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            h.t(gVar.c(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(gVar.f52873a));
            contentValues.put("key", gVar.f52874b);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) com.google.android.exoplayer2.util.a.e(this.f52890d), null, contentValues);
        }

        public final void j(SQLiteDatabase sQLiteDatabase, int i10) {
            sQLiteDatabase.delete((String) com.google.android.exoplayer2.util.a.e(this.f52890d), "id = ?", new String[]{Integer.toString(i10)});
        }

        public final Cursor l() {
            return this.f52887a.getReadableDatabase().query((String) com.google.android.exoplayer2.util.a.e(this.f52890d), f52886e, null, null, null, null, null);
        }

        public final void n(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            y4.c.d(sQLiteDatabase, 1, (String) com.google.android.exoplayer2.util.a.e(this.f52889c), 1);
            k(sQLiteDatabase, (String) com.google.android.exoplayer2.util.a.e(this.f52890d));
            String str = this.f52890d;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 88);
            sb2.append("CREATE TABLE ");
            sb2.append(str);
            sb2.append(" ");
            sb2.append("(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
            sQLiteDatabase.execSQL(sb2.toString());
        }
    }

    /* compiled from: CachedContentIndex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public static class b implements c {

        /* renamed from: a, reason: collision with root package name */
        public final boolean f52891a;

        /* renamed from: b, reason: collision with root package name */
        @Nullable
        public final Cipher f52892b;

        /* renamed from: c, reason: collision with root package name */
        @Nullable
        public final SecretKeySpec f52893c;

        /* renamed from: d, reason: collision with root package name */
        @Nullable
        public final SecureRandom f52894d;

        /* renamed from: e, reason: collision with root package name */
        public final com.google.android.exoplayer2.util.b f52895e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f52896f;

        /* renamed from: g, reason: collision with root package name */
        @Nullable
        public x f52897g;

        public b(File file, @Nullable byte[] bArr, boolean z10) {
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            com.google.android.exoplayer2.util.a.g((bArr == null && z10) ? false : true);
            if (bArr != null) {
                com.google.android.exoplayer2.util.a.a(bArr.length == 16);
                try {
                    cipher = h.a();
                    secretKeySpec = new SecretKeySpec(bArr, AESEncrypt.ALGORITHM);
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                    throw new IllegalStateException(e2);
                }
            } else {
                com.google.android.exoplayer2.util.a.a(!z10);
                cipher = null;
                secretKeySpec = null;
            }
            this.f52891a = z10;
            this.f52892b = cipher;
            this.f52893c = secretKeySpec;
            this.f52894d = z10 ? new SecureRandom() : null;
            this.f52895e = new com.google.android.exoplayer2.util.b(file);
        }

        @Override // p6.h.c
        public void a(long j10) {
        }

        @Override // p6.h.c
        public void b(HashMap<String, g> hashMap) throws IOException {
            l(hashMap);
            this.f52896f = false;
        }

        @Override // p6.h.c
        public boolean c() {
            return this.f52895e.c();
        }

        @Override // p6.h.c
        public void d(HashMap<String, g> hashMap) throws IOException {
            if (this.f52896f) {
                b(hashMap);
            }
        }

        @Override // p6.h.c
        public void delete() {
            this.f52895e.a();
        }

        @Override // p6.h.c
        public void e(g gVar) {
            this.f52896f = true;
        }

        @Override // p6.h.c
        public void f(g gVar, boolean z10) {
            this.f52896f = true;
        }

        @Override // p6.h.c
        public void g(HashMap<String, g> hashMap, SparseArray<String> sparseArray) {
            com.google.android.exoplayer2.util.a.g(!this.f52896f);
            if (j(hashMap, sparseArray)) {
                return;
            }
            hashMap.clear();
            sparseArray.clear();
            this.f52895e.a();
        }

        public final int h(g gVar, int i10) {
            int hashCode = (gVar.f52873a * 31) + gVar.f52874b.hashCode();
            if (i10 < 2) {
                long a10 = i.a(gVar.c());
                return (hashCode * 31) + ((int) (a10 ^ (a10 >>> 32)));
            }
            return (hashCode * 31) + gVar.c().hashCode();
        }

        public final g i(int i10, DataInputStream dataInputStream) throws IOException {
            l q10;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i10 < 2) {
                long readLong = dataInputStream.readLong();
                k kVar = new k();
                k.g(kVar, readLong);
                q10 = l.f52900c.d(kVar);
            } else {
                q10 = h.q(dataInputStream);
            }
            return new g(readInt, readUTF, q10);
        }

        public final boolean j(HashMap<String, g> hashMap, SparseArray<String> sparseArray) {
            if (!this.f52895e.c()) {
                return true;
            }
            DataInputStream dataInputStream = null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f52895e.d());
                DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    int readInt = dataInputStream2.readInt();
                    if (readInt >= 0 && readInt <= 2) {
                        if ((dataInputStream2.readInt() & 1) != 0) {
                            if (this.f52892b == null) {
                                j0.o(dataInputStream2);
                                return false;
                            }
                            byte[] bArr = new byte[16];
                            dataInputStream2.readFully(bArr);
                            try {
                                this.f52892b.init(2, (Key) j0.j(this.f52893c), new IvParameterSpec(bArr));
                                dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f52892b));
                            } catch (InvalidAlgorithmParameterException e2) {
                                e = e2;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e10) {
                                e = e10;
                                throw new IllegalStateException(e);
                            }
                        } else if (this.f52891a) {
                            this.f52896f = true;
                        }
                        int readInt2 = dataInputStream2.readInt();
                        int i10 = 0;
                        for (int i11 = 0; i11 < readInt2; i11++) {
                            g i12 = i(readInt, dataInputStream2);
                            hashMap.put(i12.f52874b, i12);
                            sparseArray.put(i12.f52873a, i12.f52874b);
                            i10 += h(i12, readInt);
                        }
                        int readInt3 = dataInputStream2.readInt();
                        boolean z10 = dataInputStream2.read() == -1;
                        if (readInt3 == i10 && z10) {
                            j0.o(dataInputStream2);
                            return true;
                        }
                        j0.o(dataInputStream2);
                        return false;
                    }
                    j0.o(dataInputStream2);
                    return false;
                } catch (IOException unused) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        j0.o(dataInputStream);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        j0.o(dataInputStream);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public final void k(g gVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(gVar.f52873a);
            dataOutputStream.writeUTF(gVar.f52874b);
            h.t(gVar.c(), dataOutputStream);
        }

        public final void l(HashMap<String, g> hashMap) throws IOException {
            x xVar;
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream f10 = this.f52895e.f();
                x xVar2 = this.f52897g;
                if (xVar2 == null) {
                    this.f52897g = new x(f10);
                } else {
                    xVar2.a(f10);
                }
                xVar = this.f52897g;
                dataOutputStream = new DataOutputStream(xVar);
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                int i10 = 0;
                dataOutputStream.writeInt(this.f52891a ? 1 : 0);
                if (this.f52891a) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) j0.j(this.f52894d)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) j0.j(this.f52892b)).init(1, (Key) j0.j(this.f52893c), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(xVar, this.f52892b));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e10) {
                        e = e10;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(hashMap.size());
                for (g gVar : hashMap.values()) {
                    k(gVar, dataOutputStream);
                    i10 += h(gVar, 2);
                }
                dataOutputStream.writeInt(i10);
                this.f52895e.b(dataOutputStream);
                j0.o(null);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                j0.o(dataOutputStream2);
                throw th;
            }
        }
    }

    /* compiled from: CachedContentIndex.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
    public interface c {
        void a(long j10);

        void b(HashMap<String, g> hashMap) throws IOException;

        boolean c() throws IOException;

        void d(HashMap<String, g> hashMap) throws IOException;

        void delete() throws IOException;

        void e(g gVar);

        void f(g gVar, boolean z10);

        void g(HashMap<String, g> hashMap, SparseArray<String> sparseArray) throws IOException;
    }

    public h(@Nullable y4.a aVar, @Nullable File file, @Nullable byte[] bArr, boolean z10, boolean z11) {
        com.google.android.exoplayer2.util.a.g((aVar == null && file == null) ? false : true);
        this.f52880a = new HashMap<>();
        this.f52881b = new SparseArray<>();
        this.f52882c = new SparseBooleanArray();
        this.f52883d = new SparseBooleanArray();
        a aVar2 = aVar != null ? new a(aVar) : null;
        b bVar = file != null ? new b(new File(file, "cached_content_index.exi"), bArr, z10) : null;
        if (aVar2 != null && (bVar == null || !z11)) {
            this.f52884e = aVar2;
            this.f52885f = bVar;
        } else {
            this.f52884e = (c) j0.j(bVar);
            this.f52885f = aVar2;
        }
    }

    public static /* synthetic */ Cipher a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return i();
    }

    public static Cipher i() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (j0.f22990a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    @VisibleForTesting
    public static int l(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i10 = 0;
        int keyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (keyAt >= 0) {
            return keyAt;
        }
        while (i10 < size && i10 == sparseArray.keyAt(i10)) {
            i10++;
        }
        return i10;
    }

    public static boolean o(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    public static l q(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i10 = 0; i10 < readInt; i10++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, 10485760);
                byte[] bArr = j0.f22995f;
                int i11 = 0;
                while (i11 != readInt2) {
                    int i12 = i11 + min;
                    bArr = Arrays.copyOf(bArr, i12);
                    dataInputStream.readFully(bArr, i11, min);
                    min = Math.min(readInt2 - i12, 10485760);
                    i11 = i12;
                }
                hashMap.put(readUTF, bArr);
            } else {
                StringBuilder sb2 = new StringBuilder(31);
                sb2.append("Invalid value size: ");
                sb2.append(readInt2);
                throw new IOException(sb2.toString());
            }
        }
        return new l(hashMap);
    }

    public static void t(l lVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> e2 = lVar.e();
        dataOutputStream.writeInt(e2.size());
        for (Map.Entry<String, byte[]> entry : e2) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public final g d(String str) {
        int l10 = l(this.f52881b);
        g gVar = new g(l10, str);
        this.f52880a.put(str, gVar);
        this.f52881b.put(l10, str);
        this.f52883d.put(l10, true);
        this.f52884e.e(gVar);
        return gVar;
    }

    public void e(String str, k kVar) {
        g m10 = m(str);
        if (m10.b(kVar)) {
            this.f52884e.e(m10);
        }
    }

    public int f(String str) {
        return m(str).f52873a;
    }

    @Nullable
    public g g(String str) {
        return this.f52880a.get(str);
    }

    public Collection<g> h() {
        return Collections.unmodifiableCollection(this.f52880a.values());
    }

    public j j(String str) {
        g g3 = g(str);
        return g3 != null ? g3.c() : l.f52900c;
    }

    @Nullable
    public String k(int i10) {
        return this.f52881b.get(i10);
    }

    public g m(String str) {
        g gVar = this.f52880a.get(str);
        return gVar == null ? d(str) : gVar;
    }

    @WorkerThread
    public void n(long j10) throws IOException {
        c cVar;
        this.f52884e.a(j10);
        c cVar2 = this.f52885f;
        if (cVar2 != null) {
            cVar2.a(j10);
        }
        if (!this.f52884e.c() && (cVar = this.f52885f) != null && cVar.c()) {
            this.f52885f.g(this.f52880a, this.f52881b);
            this.f52884e.b(this.f52880a);
        } else {
            this.f52884e.g(this.f52880a, this.f52881b);
        }
        c cVar3 = this.f52885f;
        if (cVar3 != null) {
            cVar3.delete();
            this.f52885f = null;
        }
    }

    public void p(String str) {
        g gVar = this.f52880a.get(str);
        if (gVar != null && gVar.f() && gVar.h()) {
            this.f52880a.remove(str);
            int i10 = gVar.f52873a;
            boolean z10 = this.f52883d.get(i10);
            this.f52884e.f(gVar, z10);
            if (z10) {
                this.f52881b.remove(i10);
                this.f52883d.delete(i10);
            } else {
                this.f52881b.put(i10, null);
                this.f52882c.put(i10, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void r() {
        i1 iterator2 = ImmutableSet.copyOf((Collection) this.f52880a.h()).iterator2();
        while (iterator2.hasNext()) {
            p((String) iterator2.next());
        }
    }

    @WorkerThread
    public void s() throws IOException {
        this.f52884e.d(this.f52880a);
        int size = this.f52882c.size();
        for (int i10 = 0; i10 < size; i10++) {
            this.f52881b.remove(this.f52882c.keyAt(i10));
        }
        this.f52882c.clear();
        this.f52883d.clear();
    }
}
