package com.nostra13.universalimageloader.core.download;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import pb.c;

/* compiled from: BaseImageDownloader.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public class a implements ImageDownloader {

    /* renamed from: a, reason: collision with root package name */
    public final Context f37803a;

    /* renamed from: b, reason: collision with root package name */
    public final int f37804b;

    /* renamed from: c, reason: collision with root package name */
    public final int f37805c;

    /* compiled from: BaseImageDownloader.java */
    /* renamed from: com.nostra13.universalimageloader.core.download.a$a, reason: collision with other inner class name */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static /* synthetic */ class C0566a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f37806a;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            f37806a = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f37806a[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f37806a[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f37806a[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f37806a[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f37806a[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f37806a[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public a(Context context) {
        this(context, 5000, 20000);
    }

    public HttpURLConnection a(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, "@#&=*+-_.,:!?()/~'%")).openConnection();
        httpURLConnection.setConnectTimeout(this.f37804b);
        httpURLConnection.setReadTimeout(this.f37805c);
        return httpURLConnection;
    }

    public InputStream b(Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(this.f37803a.getContentResolver(), uri, true);
    }

    public InputStream c(String str, Object obj) throws IOException {
        return this.f37803a.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    public InputStream d(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.f37803a.getContentResolver();
        Uri parse = Uri.parse(str);
        if (j(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith("content://com.android.contacts/")) {
            return b(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    public InputStream e(String str, Object obj) {
        return this.f37803a.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    public InputStream f(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        if (k(str)) {
            return i(crop);
        }
        return new jb.a(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    public InputStream g(String str, Object obj) throws IOException {
        HttpURLConnection a10 = a(str, obj);
        for (int i10 = 0; a10.getResponseCode() / 100 == 3 && i10 < 5; i10++) {
            a10 = a(a10.getHeaderField("Location"), obj);
        }
        try {
            InputStream inputStream = a10.getInputStream();
            if (l(a10)) {
                return new jb.a(new BufferedInputStream(inputStream, 32768), a10.getContentLength());
            }
            c.a(inputStream);
            throw new IOException("Image request failed with response code " + a10.getResponseCode());
        } catch (IOException e2) {
            c.c(a10.getErrorStream());
            throw e2;
        }
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        switch (C0566a.f37806a[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return g(str, obj);
            case 3:
                return f(str, obj);
            case 4:
                return d(str, obj);
            case 5:
                return c(str, obj);
            case 6:
                return e(str, obj);
            default:
                return h(str, obj);
        }
    }

    public InputStream h(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format("UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))", str));
    }

    public final InputStream i(String str) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
        if (createVideoThumbnail == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
        return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
    }

    public final boolean j(Uri uri) {
        String type = this.f37803a.getContentResolver().getType(uri);
        return type != null && type.startsWith("video/");
    }

    public final boolean k(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(str));
        return mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/");
    }

    public boolean l(HttpURLConnection httpURLConnection) throws IOException {
        return httpURLConnection.getResponseCode() == 200;
    }

    public a(Context context, int i10, int i11) {
        this.f37803a = context.getApplicationContext();
        this.f37804b = i10;
        this.f37805c = i11;
    }
}
