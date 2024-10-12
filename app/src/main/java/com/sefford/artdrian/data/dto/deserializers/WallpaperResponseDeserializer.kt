package com.sefford.artdrian.data.dto.deserializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.sefford.artdrian.model.Metadata
import java.lang.reflect.Type

class WallpaperResponseDeserializer : JsonDeserializer<WallpaperResponse> {

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): WallpaperResponse = WallpaperResponse(json.asJsonObject
        .get("pageProps")
        .asJsonObject
        .get("wallpapers")
        .asJsonArray
        .map { elem ->
            context.deserialize(elem, Metadata::class.java)
        })
}

@JvmInline
value class WallpaperResponse(val wallpapers: List<Metadata>)