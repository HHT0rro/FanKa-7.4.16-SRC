package m;

import com.airbnb.lottie.model.content.MergePaths;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* compiled from: MergePathsParser.java */
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class7.dex */
public class y {

    /* renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f51785a = JsonReader.a.a("nm", "mm", "hd");

    public static MergePaths a(JsonReader jsonReader) throws IOException {
        String str = null;
        MergePaths.MergePathsMode mergePathsMode = null;
        boolean z10 = false;
        while (jsonReader.i()) {
            int y10 = jsonReader.y(f51785a);
            if (y10 == 0) {
                str = jsonReader.r();
            } else if (y10 == 1) {
                mergePathsMode = MergePaths.MergePathsMode.forId(jsonReader.l());
            } else if (y10 != 2) {
                jsonReader.z();
                jsonReader.A();
            } else {
                z10 = jsonReader.j();
            }
        }
        return new MergePaths(str, mergePathsMode, z10);
    }
}
