/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.androiddevchallenge.ui.puppy.AppScaffold
import com.example.androiddevchallenge.ui.puppy.PuppyDetailScreen

private const val KEY_ARG_DETAILS_ID = "KEY_ARG_DETAILS_ID"

fun launchDetailActivity(context: Context, id: Int) {
    context.startActivity(createDetailActivityIntent(context, id))
}

fun createDetailActivityIntent(context: Context, id: Int): Intent {
    val intent = Intent(context, DetailActivity::class.java)
    intent.putExtra(KEY_ARG_DETAILS_ID, id)
    return intent
}

class DetailActivity : AppCompatActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val id = getDetailArgs(intent)
        setContent {
            AppScaffold(id = id, onBack = { finish() }) { id, onBack ->
                PuppyDetailScreen(id, onBack)
            }
        }
    }

    private fun getDetailArgs(intent: Intent): Int {
        val id = intent.getIntExtra(KEY_ARG_DETAILS_ID, 0)
        if (id == 0) {
            throw IllegalStateException("Id arg cannot be null or empty")
        }
        return id
    }
}

@ExperimentalMaterialApi
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreviewDetails() {
    AppScaffold(id = 50658910, onBack = { }) { id, onBack ->
        PuppyDetailScreen(id, onBack)
    }
}

@ExperimentalMaterialApi
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreviewDetails() {
    AppScaffold(id = 50658910, onBack = { }) { id, onBack ->
        PuppyDetailScreen(id, onBack)
    }
}
