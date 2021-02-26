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

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.transform.RoundedCornersTransformation
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.PuppyRepository
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyAppBar() {
    TopAppBar(
        modifier = Modifier.height(54.dp)
    ) {
        Text(
            text = "Adopt a puppy",
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterVertically),
        )
        IconButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            onClick = { /* todo */ }
        ) {
            Icon(
                imageVector = Icons.Filled.Pets,
                contentDescription = null
            )
        }
    }
}

@Preview
@Composable
fun PuppyAppBarP() {
    PuppyAppBar()
}

@Composable
fun PuppyItem(
    item: Puppy,
    selectItem: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Row(
            Modifier.fillMaxWidth().padding(2.dp).clip(RoundedCornerShape(4.dp))
                .clickable(
                    onClick = { selectItem.invoke(item.id) }
                )
        ) {
            CoilImage(
                data = item.photo,
                "Puppy image",
                Modifier.requiredSize(64.dp),
                requestBuilder = {
                    transformations(RoundedCornersTransformation(8f))
                },
                loading = {
                    Box(Modifier.fillMaxSize()) {
                        CircularProgressIndicator(Modifier.align(Alignment.Center))
                    }
                }
            )
            Column(
                modifier.fillMaxWidth(1f).padding(8.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(item.name, style = MaterialTheme.typography.body1)
                Text(
                    "Age: ${item.age}",
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(0.6f)
                )
            }
        }
    }
}

@Composable
fun PuppiesList(
    list: List<Puppy>,
    selectItem: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column {
        PuppyAppBar()
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
                .background(color = MaterialTheme.colors.onSurface.copy(alpha = 0.1f))
        ) {
            items(list) { obj ->
                PuppyItem(obj, selectItem)
            }
        }
    }
}

@Preview
@Composable
fun ListPuppies() {
    PuppiesList(list = PuppyRepository.listPuppies(), selectItem = { /*TODO*/ })
}
