/*
 * Copyright (C) 2016 Litote
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.litote.kmongo.jackson

import com.fasterxml.jackson.databind.ObjectMapper
import org.bson.codecs.Codec
import org.bson.codecs.configuration.CodecProvider
import org.bson.codecs.configuration.CodecRegistry

internal class JacksonCodecProvider(
        val bsonObjectMapper: ObjectMapper,
        val notBsonObjectMapper: ObjectMapper) : CodecProvider {

    override fun <T : Any> get(type: Class<T>, registry: CodecRegistry): Codec<T> {
        return JacksonCodec(bsonObjectMapper, notBsonObjectMapper, registry, type)
    }
}
