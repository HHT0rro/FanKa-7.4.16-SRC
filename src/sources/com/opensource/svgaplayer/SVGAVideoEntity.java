package com.opensource.svgaplayer;

import android.graphics.Bitmap;
import android.media.AudioAttributes;
import android.media.SoundPool;
import ce.n;
import com.google.android.material.shadow.ShadowDrawableWrapper;
import com.huawei.appgallery.agd.pageframe.api.CardConstants;
import com.opensource.svgaplayer.SVGAParser;
import com.opensource.svgaplayer.h;
import com.opensource.svgaplayer.proto.AudioEntity;
import com.opensource.svgaplayer.proto.MovieEntity;
import com.opensource.svgaplayer.proto.MovieParams;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.m;
import kotlin.collections.t;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.s;
import kotlin.p;
import kotlin.ranges.IntRange;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SVGAVideoEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class SVGAVideoEntity {

    /* renamed from: a, reason: collision with root package name */
    public final String f37944a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f37945b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    public MovieEntity f37946c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public tb.d f37947d;

    /* renamed from: e, reason: collision with root package name */
    public int f37948e;

    /* renamed from: f, reason: collision with root package name */
    public int f37949f;

    /* renamed from: g, reason: collision with root package name */
    @NotNull
    public List<sb.f> f37950g;

    /* renamed from: h, reason: collision with root package name */
    @NotNull
    public List<sb.a> f37951h;

    /* renamed from: i, reason: collision with root package name */
    @Nullable
    public SoundPool f37952i;

    /* renamed from: j, reason: collision with root package name */
    public h.a f37953j;

    /* renamed from: k, reason: collision with root package name */
    @NotNull
    public HashMap<String, Bitmap> f37954k;

    /* renamed from: l, reason: collision with root package name */
    public File f37955l;

    /* renamed from: m, reason: collision with root package name */
    public int f37956m;

    /* renamed from: n, reason: collision with root package name */
    public int f37957n;

    /* renamed from: o, reason: collision with root package name */
    public SVGAParser.d f37958o;

    /* renamed from: p, reason: collision with root package name */
    public Function0<p> f37959p;

    /* compiled from: SVGAVideoEntity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class a implements h.a {

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f37961b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ MovieEntity f37962c;

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function0 f37963d;

        public a(Ref$IntRef ref$IntRef, MovieEntity movieEntity, Function0 function0) {
            this.f37961b = ref$IntRef;
            this.f37962c = movieEntity;
            this.f37963d = function0;
        }
    }

    /* compiled from: SVGAVideoEntity.kt */
    @kotlin.d
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
    public static final class b implements SoundPool.OnLoadCompleteListener {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref$IntRef f37964a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ MovieEntity f37965b;

        /* renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0 f37966c;

        public b(Ref$IntRef ref$IntRef, MovieEntity movieEntity, Function0 function0) {
            this.f37964a = ref$IntRef;
            this.f37965b = movieEntity;
            this.f37966c = function0;
        }

        @Override // android.media.SoundPool.OnLoadCompleteListener
        public final void onLoadComplete(SoundPool soundPool, int i10, int i11) {
            ub.c.f54010a.e("SVGAParser", "pool_complete");
            Ref$IntRef ref$IntRef = this.f37964a;
            int i12 = ref$IntRef.element + 1;
            ref$IntRef.element = i12;
            List<AudioEntity> list = this.f37965b.audios;
            s.e(list, "entity.audios");
            if (i12 >= list.size()) {
                this.f37966c.invoke();
            }
        }
    }

    public SVGAVideoEntity(@NotNull JSONObject json, @NotNull File cacheDir, int i10, int i11) {
        s.j(json, "json");
        s.j(cacheDir, "cacheDir");
        this.f37944a = "SVGAVideoEntity";
        this.f37945b = true;
        this.f37947d = new tb.d(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        this.f37948e = 15;
        this.f37950g = kotlin.collections.s.j();
        this.f37951h = kotlin.collections.s.j();
        this.f37954k = new HashMap<>();
        this.f37957n = i10;
        this.f37956m = i11;
        this.f37955l = cacheDir;
        JSONObject optJSONObject = json.optJSONObject("movie");
        if (optJSONObject != null) {
            z(optJSONObject);
            try {
                t(json);
            } catch (Exception e2) {
                e2.printStackTrace();
            } catch (OutOfMemoryError e10) {
                e10.printStackTrace();
            }
            w(json);
        }
    }

    public static final /* synthetic */ Function0 a(SVGAVideoEntity sVGAVideoEntity) {
        Function0<p> function0 = sVGAVideoEntity.f37959p;
        if (function0 == null) {
            s.A("mCallback");
        }
        return function0;
    }

    public final void A(MovieParams movieParams) {
        Float f10 = movieParams.viewBoxWidth;
        this.f37947d = new tb.d(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, f10 != null ? f10.floatValue() : 0.0f, movieParams.viewBoxHeight != null ? r0.floatValue() : 0.0f);
        Integer num = movieParams.fps;
        this.f37948e = num != null ? num.intValue() : 20;
        Integer num2 = movieParams.frames;
        this.f37949f = num2 != null ? num2.intValue() : 0;
    }

    public final void B(MovieEntity movieEntity, Function0<p> function0) {
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = 0;
        if (h.f38009e.b()) {
            this.f37953j = new a(ref$IntRef, movieEntity, function0);
            return;
        }
        this.f37952i = j(movieEntity);
        ub.c.f54010a.e("SVGAParser", "pool_start");
        SoundPool soundPool = this.f37952i;
        if (soundPool != null) {
            soundPool.setOnLoadCompleteListener(new b(ref$IntRef, movieEntity, function0));
        }
    }

    public final void b() {
        if (h.f38009e.b()) {
            Iterator<sb.a> iterator2 = this.f37951h.iterator2();
            while (iterator2.hasNext()) {
                Integer c4 = iterator2.next().c();
                if (c4 != null) {
                    h.f38009e.f(c4.intValue());
                }
            }
            this.f37953j = null;
        }
        SoundPool soundPool = this.f37952i;
        if (soundPool != null) {
            soundPool.release();
        }
        this.f37952i = null;
        this.f37951h = kotlin.collections.s.j();
        this.f37950g = kotlin.collections.s.j();
        this.f37954k.clear();
    }

    public final Bitmap c(String str) {
        return qb.d.f53193a.a(str, this.f37957n, this.f37956m);
    }

    public final Bitmap d(byte[] bArr, String str) {
        Bitmap a10 = qb.b.f53192a.a(bArr, this.f37957n, this.f37956m);
        return a10 != null ? a10 : c(str);
    }

    public final sb.a e(AudioEntity audioEntity, HashMap<String, File> hashMap) {
        sb.a aVar = new sb.a(audioEntity);
        Integer num = audioEntity.startTime;
        double intValue = num != null ? num.intValue() : 0;
        Integer num2 = audioEntity.totalTime;
        double intValue2 = num2 != null ? num2.intValue() : 0;
        if (((int) intValue2) == 0) {
            return aVar;
        }
        SVGAParser.d dVar = this.f37958o;
        if (dVar != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<Map.Entry<String, File>> iterator2 = hashMap.entrySet().iterator2();
            while (iterator2.hasNext()) {
                arrayList.add(iterator2.next().getValue());
            }
            dVar.a(arrayList);
            Function0<p> function0 = this.f37959p;
            if (function0 == null) {
                s.A("mCallback");
            }
            function0.invoke();
            return aVar;
        }
        File file = hashMap.get(audioEntity.audioKey);
        if (file != null) {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                double available = fileInputStream.available();
                long j10 = (long) ((intValue / intValue2) * available);
                h hVar = h.f38009e;
                if (hVar.b()) {
                    aVar.f(Integer.valueOf(hVar.c(this.f37953j, fileInputStream.getFD(), j10, (long) available, 1)));
                } else {
                    SoundPool soundPool = this.f37952i;
                    aVar.f(soundPool != null ? Integer.valueOf(soundPool.load(fileInputStream.getFD(), j10, (long) available, 1)) : null);
                }
                p pVar = p.f51048a;
                kotlin.io.b.a(fileInputStream, null);
            } finally {
            }
        }
        return aVar;
    }

    public final File f(File file, byte[] bArr) {
        file.createNewFile();
        new FileOutputStream(file).write(bArr);
        return file;
    }

    public final HashMap<String, File> g(MovieEntity movieEntity) {
        HashMap<String, byte[]> h10 = h(movieEntity);
        HashMap<String, File> hashMap = new HashMap<>();
        if (h10.size() > 0) {
            for (Map.Entry<String, byte[]> entry : h10.entrySet()) {
                File a10 = SVGACache.f37881c.a(entry.getKey());
                String key = entry.getKey();
                File file = a10.exists() ? a10 : null;
                if (file == null) {
                    file = f(a10, entry.getValue());
                }
                hashMap.put(key, file);
            }
        }
        return hashMap;
    }

    public final HashMap<String, byte[]> h(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        HashMap<String, byte[]> hashMap = new HashMap<>();
        Map<String, ByteString> map = movieEntity.images;
        if (map != null && (entrySet = map.entrySet()) != null) {
            for (Map.Entry<String, ByteString> entry : entrySet) {
                String imageKey = entry.getKey();
                byte[] byteArray = entry.getValue().toByteArray();
                s.e(byteArray, "byteArray");
                if (byteArray.length >= 4) {
                    List<Byte> K = m.K(byteArray, new IntRange(0, 3));
                    if (K.get(0).byteValue() == 73 && K.get(1).byteValue() == 68 && K.get(2).byteValue() == 51) {
                        s.e(imageKey, "imageKey");
                        hashMap.put(imageKey, byteArray);
                    } else if (K.get(0).byteValue() == -1 && K.get(1).byteValue() == -5 && K.get(2).byteValue() == -108) {
                        s.e(imageKey, "imageKey");
                        hashMap.put(imageKey, byteArray);
                    }
                }
            }
        }
        return hashMap;
    }

    public final String i(String str, String str2) {
        String str3 = this.f37955l.getAbsolutePath() + "/" + str;
        String str4 = str3 + ".png";
        String str5 = this.f37955l.getAbsolutePath() + "/" + str2 + ".png";
        return new File(str3).exists() ? str3 : new File(str4).exists() ? str4 : new File(str5).exists() ? str5 : "";
    }

    public final SoundPool j(MovieEntity movieEntity) {
        try {
            SoundPool.Builder audioAttributes = new SoundPool.Builder().setAudioAttributes(new AudioAttributes.Builder().setUsage(1).build());
            List<AudioEntity> list = movieEntity.audios;
            s.e(list, "entity.audios");
            return audioAttributes.setMaxStreams(n.d(12, list.size())).build();
        } catch (Exception e2) {
            ub.c.f54010a.d(this.f37944a, e2);
            return null;
        }
    }

    public final boolean k() {
        return this.f37945b;
    }

    @NotNull
    public final List<sb.a> l() {
        return this.f37951h;
    }

    public final int m() {
        return this.f37948e;
    }

    public final int n() {
        return this.f37949f;
    }

    @NotNull
    public final HashMap<String, Bitmap> o() {
        return this.f37954k;
    }

    @Nullable
    public final SoundPool p() {
        return this.f37952i;
    }

    @NotNull
    public final List<sb.f> q() {
        return this.f37950g;
    }

    @NotNull
    public final tb.d r() {
        return this.f37947d;
    }

    public final void s(MovieEntity movieEntity) {
        Set<Map.Entry<String, ByteString>> entrySet;
        Map<String, ByteString> map = movieEntity.images;
        if (map == null || (entrySet = map.entrySet()) == null) {
            return;
        }
        for (Map.Entry<String, ByteString> entry : entrySet) {
            byte[] byteArray = entry.getValue().toByteArray();
            s.e(byteArray, "byteArray");
            if (byteArray.length >= 4) {
                List<Byte> K = m.K(byteArray, new IntRange(0, 3));
                if (K.get(0).byteValue() != 73 || K.get(1).byteValue() != 68 || K.get(2).byteValue() != 51) {
                    String utf8 = entry.getValue().utf8();
                    s.e(utf8, "entry.value.utf8()");
                    String key = entry.getKey();
                    s.e(key, "entry.key");
                    Bitmap d10 = d(byteArray, i(utf8, key));
                    if (d10 != null) {
                        HashMap<String, Bitmap> hashMap = this.f37954k;
                        String key2 = entry.getKey();
                        s.e(key2, "entry.key");
                        hashMap.put(key2, d10);
                    }
                }
            }
        }
    }

    public final void t(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject(CardConstants.KEY_IMAGES);
        if (optJSONObject != null) {
            Iterator<String> keys = optJSONObject.keys();
            s.e(keys, "imgJson.keys()");
            while (keys.hasNext()) {
                String imgKey = keys.next();
                String obj = optJSONObject.get(imgKey).toString();
                s.e(imgKey, "imgKey");
                String i10 = i(obj, imgKey);
                if (i10.length() == 0) {
                    return;
                }
                String A = kotlin.text.p.A(imgKey, ".matte", "", false, 4, null);
                Bitmap c4 = c(i10);
                if (c4 != null) {
                    this.f37954k.put(A, c4);
                }
            }
        }
    }

    public final void u(@NotNull Function0<p> callback, @Nullable SVGAParser.d dVar) {
        s.j(callback, "callback");
        this.f37959p = callback;
        this.f37958o = dVar;
        MovieEntity movieEntity = this.f37946c;
        if (movieEntity == null) {
            if (callback == null) {
                s.A("mCallback");
            }
            callback.invoke();
        } else {
            if (movieEntity == null) {
                s.u();
            }
            y(movieEntity, new Function0<p>() { // from class: com.opensource.svgaplayer.SVGAVideoEntity$prepare$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ p invoke() {
                    invoke2();
                    return p.f51048a;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    SVGAVideoEntity.a(SVGAVideoEntity.this).invoke();
                }
            });
        }
    }

    public final void v(MovieEntity movieEntity) {
        List<sb.f> j10;
        List<SpriteEntity> list = movieEntity.sprites;
        if (list != null) {
            j10 = new ArrayList<>(t.t(list, 10));
            for (SpriteEntity it : list) {
                s.e(it, "it");
                j10.add(new sb.f(it));
            }
        } else {
            j10 = kotlin.collections.s.j();
        }
        this.f37950g = j10;
    }

    public final void w(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("sprites");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    arrayList.add(new sb.f(optJSONObject));
                }
            }
        }
        this.f37950g = CollectionsKt___CollectionsKt.x0(arrayList);
    }

    public final void x(boolean z10) {
        this.f37945b = z10;
    }

    public final void y(MovieEntity movieEntity, Function0<p> function0) {
        List<AudioEntity> list = movieEntity.audios;
        if (list != null && !list.isEmpty()) {
            B(movieEntity, function0);
            HashMap<String, File> g3 = g(movieEntity);
            if (g3.size() == 0) {
                function0.invoke();
                return;
            }
            List<AudioEntity> list2 = movieEntity.audios;
            ArrayList arrayList = new ArrayList(t.t(list2, 10));
            for (AudioEntity audio : list2) {
                s.e(audio, "audio");
                arrayList.add(e(audio, g3));
            }
            this.f37951h = arrayList;
            return;
        }
        function0.invoke();
    }

    public final void z(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("viewBox");
        if (optJSONObject != null) {
            this.f37947d = new tb.d(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, optJSONObject.optDouble("width", ShadowDrawableWrapper.COS_45), optJSONObject.optDouble("height", ShadowDrawableWrapper.COS_45));
        }
        this.f37948e = jSONObject.optInt("fps", 20);
        this.f37949f = jSONObject.optInt("frames", 0);
    }

    public SVGAVideoEntity(@NotNull MovieEntity entity, @NotNull File cacheDir, int i10, int i11) {
        s.j(entity, "entity");
        s.j(cacheDir, "cacheDir");
        this.f37944a = "SVGAVideoEntity";
        this.f37945b = true;
        this.f37947d = new tb.d(ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45, ShadowDrawableWrapper.COS_45);
        this.f37948e = 15;
        this.f37950g = kotlin.collections.s.j();
        this.f37951h = kotlin.collections.s.j();
        this.f37954k = new HashMap<>();
        this.f37957n = i10;
        this.f37956m = i11;
        this.f37955l = cacheDir;
        this.f37946c = entity;
        MovieParams movieParams = entity.params;
        if (movieParams != null) {
            A(movieParams);
        }
        try {
            s(entity);
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (OutOfMemoryError e10) {
            e10.printStackTrace();
        }
        v(entity);
    }
}
