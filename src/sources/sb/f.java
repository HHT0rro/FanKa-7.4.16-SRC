package sb;

import com.opensource.svgaplayer.entities.SVGAVideoShapeEntity;
import com.opensource.svgaplayer.proto.FrameEntity;
import com.opensource.svgaplayer.proto.SpriteEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.t;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: SVGAVideoSpriteEntity.kt */
@kotlin.d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class3.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f53702a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f53703b;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    public final List<g> f53704c;

    public f(@NotNull JSONObject obj) {
        s.j(obj, "obj");
        this.f53702a = obj.optString("imageKey");
        this.f53703b = obj.optString("matteKey");
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = obj.optJSONArray("frames");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i10 = 0; i10 < length; i10++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                if (optJSONObject != null) {
                    g gVar = new g(optJSONObject);
                    if ((!gVar.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.T(gVar.d())).i() && arrayList.size() > 0) {
                        gVar.f(((g) CollectionsKt___CollectionsKt.e0(arrayList)).d());
                    }
                    arrayList.add(gVar);
                }
            }
        }
        this.f53704c = CollectionsKt___CollectionsKt.x0(arrayList);
    }

    @NotNull
    public final List<g> a() {
        return this.f53704c;
    }

    @Nullable
    public final String b() {
        return this.f53702a;
    }

    @Nullable
    public final String c() {
        return this.f53703b;
    }

    public f(@NotNull SpriteEntity obj) {
        List<g> j10;
        s.j(obj, "obj");
        this.f53702a = obj.imageKey;
        this.f53703b = obj.matteKey;
        List<FrameEntity> list = obj.frames;
        if (list != null) {
            j10 = new ArrayList<>(t.t(list, 10));
            g gVar = null;
            for (FrameEntity it : list) {
                s.e(it, "it");
                g gVar2 = new g(it);
                if ((!gVar2.d().isEmpty()) && ((SVGAVideoShapeEntity) CollectionsKt___CollectionsKt.T(gVar2.d())).i() && gVar != null) {
                    gVar2.f(gVar.d());
                }
                j10.add(gVar2);
                gVar = gVar2;
            }
        } else {
            j10 = kotlin.collections.s.j();
        }
        this.f53704c = j10;
    }
}
