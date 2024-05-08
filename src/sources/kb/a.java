package kb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import com.huawei.openalliance.ad.constant.bb;
import com.kwad.sdk.core.imageloader.core.decode.BaseImageDecoder;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.IOException;
import java.io.InputStream;
import pb.d;

/* compiled from: BaseImageDecoder.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements kb.b {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f50750a;

    /* compiled from: BaseImageDecoder.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public final jb.c f50753a;

        /* renamed from: b, reason: collision with root package name */
        public final C0772a f50754b;

        public b(jb.c cVar, C0772a c0772a) {
            this.f50753a = cVar;
            this.f50754b = c0772a;
        }
    }

    public a(boolean z10) {
        this.f50750a = z10;
    }

    @Override // kb.b
    public Bitmap a(c cVar) throws IOException {
        InputStream f10 = f(cVar);
        if (f10 == null) {
            d.b(BaseImageDecoder.ERROR_NO_IMAGE_STREAM, cVar.g());
            return null;
        }
        try {
            b e2 = e(f10, cVar);
            f10 = h(f10, cVar);
            Bitmap decodeStream = BitmapFactory.decodeStream(f10, null, g(e2.f50753a, cVar));
            if (decodeStream == null) {
                d.b(BaseImageDecoder.ERROR_CANT_DECODE_IMAGE, cVar.g());
                return decodeStream;
            }
            C0772a c0772a = e2.f50754b;
            return c(decodeStream, cVar, c0772a.f50751a, c0772a.f50752b);
        } finally {
            pb.c.a(f10);
        }
    }

    public final boolean b(String str, String str2) {
        return bb.V.equalsIgnoreCase(str2) && ImageDownloader.Scheme.ofUri(str) == ImageDownloader.Scheme.FILE;
    }

    public Bitmap c(Bitmap bitmap, c cVar, int i10, boolean z10) {
        Matrix matrix = new Matrix();
        ImageScaleType h10 = cVar.h();
        if (h10 == ImageScaleType.EXACTLY || h10 == ImageScaleType.EXACTLY_STRETCHED) {
            jb.c cVar2 = new jb.c(bitmap.getWidth(), bitmap.getHeight(), i10);
            float b4 = pb.b.b(cVar2, cVar.j(), cVar.k(), h10 == ImageScaleType.EXACTLY_STRETCHED);
            if (Float.compare(b4, 1.0f) != 0) {
                matrix.setScale(b4, b4);
                if (this.f50750a) {
                    d.a(BaseImageDecoder.LOG_SCALE_IMAGE, cVar2, cVar2.c(b4), Float.valueOf(b4), cVar.g());
                }
            }
        }
        if (z10) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f50750a) {
                d.a(BaseImageDecoder.LOG_FLIP_IMAGE, cVar.g());
            }
        }
        if (i10 != 0) {
            matrix.postRotate(i10);
            if (this.f50750a) {
                d.a(BaseImageDecoder.LOG_ROTATE_IMAGE, Integer.valueOf(i10), cVar.g());
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (createBitmap != bitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    public C0772a d(String str) {
        int i10 = 0;
        boolean z10 = 1;
        try {
        } catch (IOException unused) {
            d.f("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(ImageDownloader.Scheme.FILE.crop(str)).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1)) {
            case 1:
            default:
                z10 = 0;
                break;
            case 2:
                break;
            case 3:
                z10 = i10;
                i10 = 180;
                break;
            case 4:
                i10 = 1;
                z10 = i10;
                i10 = 180;
                break;
            case 5:
                i10 = 1;
                z10 = i10;
                i10 = 270;
                break;
            case 6:
                z10 = i10;
                i10 = 90;
                break;
            case 7:
                i10 = 1;
                z10 = i10;
                i10 = 90;
                break;
            case 8:
                z10 = i10;
                i10 = 270;
                break;
        }
        return new C0772a(i10, z10);
    }

    public b e(InputStream inputStream, c cVar) throws IOException {
        C0772a c0772a;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String i10 = cVar.i();
        if (cVar.l() && b(i10, options.outMimeType)) {
            c0772a = d(i10);
        } else {
            c0772a = new C0772a();
        }
        return new b(new jb.c(options.outWidth, options.outHeight, c0772a.f50751a), c0772a);
    }

    public InputStream f(c cVar) throws IOException {
        return cVar.e().getStream(cVar.i(), cVar.f());
    }

    public BitmapFactory.Options g(jb.c cVar, c cVar2) {
        int a10;
        ImageScaleType h10 = cVar2.h();
        if (h10 == ImageScaleType.NONE) {
            a10 = 1;
        } else if (h10 == ImageScaleType.NONE_SAFE) {
            a10 = pb.b.c(cVar);
        } else {
            a10 = pb.b.a(cVar, cVar2.j(), cVar2.k(), h10 == ImageScaleType.IN_SAMPLE_POWER_OF_2);
        }
        if (a10 > 1 && this.f50750a) {
            d.a(BaseImageDecoder.LOG_SUBSAMPLE_IMAGE, cVar, cVar.d(a10), Integer.valueOf(a10), cVar2.g());
        }
        BitmapFactory.Options d10 = cVar2.d();
        d10.inSampleSize = a10;
        return d10;
    }

    public InputStream h(InputStream inputStream, c cVar) throws IOException {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException unused) {
            pb.c.a(inputStream);
            return f(cVar);
        }
    }

    /* compiled from: BaseImageDecoder.java */
    /* renamed from: kb.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static class C0772a {

        /* renamed from: a, reason: collision with root package name */
        public final int f50751a;

        /* renamed from: b, reason: collision with root package name */
        public final boolean f50752b;

        public C0772a() {
            this.f50751a = 0;
            this.f50752b = false;
        }

        public C0772a(int i10, boolean z10) {
            this.f50751a = i10;
            this.f50752b = z10;
        }
    }
}
