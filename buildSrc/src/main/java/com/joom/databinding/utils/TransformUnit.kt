/*
 * Copyright 2017 Michael Rozumyanskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.joom.databinding.utils

import java.io.File

data class TransformUnit(
    val input: File,
    val output: File,
    val format: Format,
    val changes: Changes
) {

  enum class Format {
    DIRECTORY,
    JAR
  }

  enum class Status {
    UNKNOWN,
    UNCHANGED,
    ADDED,
    CHANGED,
    REMOVED
  }
}
