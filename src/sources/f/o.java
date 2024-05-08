package f;

import com.airbnb.lottie.model.DocumentData;
import java.util.List;

/* compiled from: TextKeyframeAnimation.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class o extends g<DocumentData> {

    /* compiled from: TextKeyframeAnimation.java */
    /* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
    public class a extends o.c<DocumentData> {

        /* renamed from: d, reason: collision with root package name */
        public final /* synthetic */ o.b f49067d;

        /* renamed from: e, reason: collision with root package name */
        public final /* synthetic */ o.c f49068e;

        /* renamed from: f, reason: collision with root package name */
        public final /* synthetic */ DocumentData f49069f;

        public a(o.b bVar, o.c cVar, DocumentData documentData) {
            this.f49067d = bVar;
            this.f49068e = cVar;
            this.f49069f = documentData;
        }

        @Override // o.c
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public DocumentData a(o.b<DocumentData> bVar) {
            this.f49067d.h(bVar.f(), bVar.a(), bVar.g().text, bVar.b().text, bVar.d(), bVar.c(), bVar.e());
            String str = (String) this.f49068e.a(this.f49067d);
            DocumentData b4 = bVar.c() == 1.0f ? bVar.b() : bVar.g();
            this.f49069f.set(str, b4.fontName, b4.size, b4.justification, b4.tracking, b4.lineHeight, b4.baselineShift, b4.color, b4.strokeColor, b4.strokeWidth, b4.strokeOverFill, b4.boxPosition, b4.boxSize);
            return this.f49069f;
        }
    }

    public o(List<o.a<DocumentData>> list) {
        super(list);
    }

    @Override // f.a
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public DocumentData i(o.a<DocumentData> aVar, float f10) {
        DocumentData documentData;
        o.c<A> cVar = this.f49027e;
        if (cVar == 0) {
            if (f10 == 1.0f && (documentData = aVar.f52212c) != null) {
                return documentData;
            }
            return aVar.f52211b;
        }
        float f11 = aVar.f52216g;
        Float f12 = aVar.f52217h;
        float floatValue = f12 == null ? Float.MAX_VALUE : f12.floatValue();
        DocumentData documentData2 = aVar.f52211b;
        DocumentData documentData3 = documentData2;
        DocumentData documentData4 = aVar.f52212c;
        return (DocumentData) cVar.b(f11, floatValue, documentData3, documentData4 == null ? documentData2 : documentData4, f10, d(), f());
    }

    public void q(o.c<String> cVar) {
        super.n(new a(new o.b(), cVar, new DocumentData()));
    }
}
