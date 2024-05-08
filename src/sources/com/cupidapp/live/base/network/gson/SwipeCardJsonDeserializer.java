package com.cupidapp.live.base.network.gson;

import com.cupidapp.live.match.model.MatchGroupCampaignModel;
import com.cupidapp.live.match.model.MatchMarketingModel;
import com.cupidapp.live.match.model.MatchRecommendType;
import com.cupidapp.live.match.model.MatchRecommendUserModel;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import kotlin.d;
import kotlin.jvm.internal.s;
import org.jetbrains.annotations.Nullable;

/* compiled from: SwipeCardJsonDeserializer.kt */
@d
/* loaded from: C:\Users\35037\Desktop\fankahook\2\class2.dex */
public final class SwipeCardJsonDeserializer implements JsonDeserializer<Object> {
    @Override // com.google.gson.JsonDeserializer
    @Nullable
    public Object deserialize(@Nullable JsonElement jsonElement, @Nullable Type type, @Nullable JsonDeserializationContext jsonDeserializationContext) {
        if (jsonElement == null || !jsonElement.isJsonObject()) {
            return null;
        }
        JsonObject asJsonObject = jsonElement.getAsJsonObject();
        if (asJsonObject.has("type")) {
            JsonElement jsonElement2 = asJsonObject.get("type");
            String asString = jsonElement2 != null ? jsonElement2.getAsString() : null;
            if (s.d(asString, MatchRecommendType.GroupCampaign.getType()) ? true : s.d(asString, MatchRecommendType.HighEndDating.getType())) {
                if (jsonDeserializationContext != null) {
                    return jsonDeserializationContext.deserialize(jsonElement, MatchGroupCampaignModel.class);
                }
                return null;
            }
            if (s.d(asString, MatchRecommendType.Marketing.getType())) {
                if (jsonDeserializationContext != null) {
                    return jsonDeserializationContext.deserialize(jsonElement, MatchMarketingModel.class);
                }
                return null;
            }
        }
        if (jsonDeserializationContext != null) {
            return jsonDeserializationContext.deserialize(jsonElement, MatchRecommendUserModel.class);
        }
        return null;
    }
}
