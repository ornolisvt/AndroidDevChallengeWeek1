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
package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.PuppyRepository
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun AppScaffold(
    id: Int,
    onBack: () -> Unit,
    content: @Composable (id: Int, onBack: () -> Unit) -> Unit
) {
    MyTheme {
        Surface(color = MaterialTheme.colors.primary) {
            content(id, onBack)
        }
    }
}

@Composable
fun DetailAppBar(onBack: () -> Unit) {
    TopAppBar(
        modifier = Modifier.height(54.dp)
    ) {
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { onBack.invoke() }
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null
            )
        }
        Text(
            text = "Puppy details",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically),
        )
    }
}

@ExperimentalMaterialApi
@Composable
fun PuppyDetailScreen(
    id: Int,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    val item = remember(id) { PuppyRepository.getPuppy(id) }

    BackdropScaffold(
        modifier = modifier,
        scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed),
        frontLayerScrimColor = Color.Transparent,
        appBar = {
            DetailAppBar(onBack)
        },
        backLayerContent = {
            PuppyImage(item.photoCropped)
        },
        frontLayerContent = {
            PuppyDetails(item)
        }
    )
}

@Composable
fun PuppyDetails(item: Puppy) {
    Column(modifier = Modifier.fillMaxWidth().padding(16.dp, 24.dp)) {
        Text(text = item.name, style = MaterialTheme.typography.h4)
        Spacer(Modifier.width(16.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Breed: ${item.breed}",
                style = MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f)
            )
            Text(
                text = item.color,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.weight(1f)
            )
        }
        Spacer(Modifier.width(16.dp))
        Text(text = "Age: ${item.age}", style = MaterialTheme.typography.h6)
        Spacer(Modifier.width(16.dp))
        Text(text = "Gender: ${item.gender}", style = MaterialTheme.typography.subtitle2)
        Spacer(Modifier.width(16.dp))
        Text(text = "Size: ${item.size}", style = MaterialTheme.typography.subtitle2)
    }
}

@Composable
fun PuppyImage(image: String) {
    Column(modifier = Modifier.fillMaxWidth().height(300.dp)) {
        CoilImage(
            data = image,
            "Puppy image",
            Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds,
            fadeIn = true,
            loading = {
                Box(Modifier.fillMaxSize()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            }
        )
    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun DetailScreen() {
    AppScaffold(id = 50658910, onBack = { }) { id, back ->
        PuppyDetailScreen(id, back)
    }
}
