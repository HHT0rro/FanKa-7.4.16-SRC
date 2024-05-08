package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-base@@17.4.0 */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class.dex */
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator<BitmapTeleporter> CREATOR = new v6.a();

    /* renamed from: b, reason: collision with root package name */
    public final int f23522b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public ParcelFileDescriptor f23523c;

    /* renamed from: d, reason: collision with root package name */
    public final int f23524d;

    /* renamed from: e, reason: collision with root package name */
    @Nullable
    public Bitmap f23525e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f23526f = false;

    /* renamed from: g, reason: collision with root package name */
    public File f23527g;

    public BitmapTeleporter(int i10, ParcelFileDescriptor parcelFileDescriptor, int i11) {
        this.f23522b = i10;
        this.f23523c = parcelFileDescriptor;
        this.f23524d = i11;
    }

    public static void g(Closeable closeable) {
        try {
            closeable.close();
        } catch (IOException unused) {
        }
    }

    public final FileOutputStream f() {
        File file = this.f23527g;
        if (file != null) {
            try {
                File createTempFile = File.createTempFile("teleporter", ".tmp", file);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                    this.f23523c = ParcelFileDescriptor.open(createTempFile, 268435456);
                    createTempFile.delete();
                    return fileOutputStream;
                } catch (FileNotFoundException unused) {
                    throw new IllegalStateException("Temporary file is somehow already deleted");
                }
            } catch (IOException e2) {
                throw new IllegalStateException("Could not create temporary file", e2);
            }
        }
        throw new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@RecentlyNonNull Parcel parcel, @RecentlyNonNull int i10) {
        if (this.f23523c == null) {
            Bitmap bitmap = (Bitmap) h.h(this.f23525e);
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(f()));
            try {
                try {
                    dataOutputStream.writeInt(array.length);
                    dataOutputStream.writeInt(bitmap.getWidth());
                    dataOutputStream.writeInt(bitmap.getHeight());
                    dataOutputStream.writeUTF(bitmap.getConfig().toString());
                    dataOutputStream.write(array);
                } catch (IOException e2) {
                    throw new IllegalStateException("Could not write into unlinked file", e2);
                }
            } finally {
                g(dataOutputStream);
            }
        }
        int a10 = w6.a.a(parcel);
        w6.a.j(parcel, 1, this.f23522b);
        w6.a.n(parcel, 2, this.f23523c, i10 | 1, false);
        w6.a.j(parcel, 3, this.f23524d);
        w6.a.b(parcel, a10);
        this.f23523c = null;
    }
}
