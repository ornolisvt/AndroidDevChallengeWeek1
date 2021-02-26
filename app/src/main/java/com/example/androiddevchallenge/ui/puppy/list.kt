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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bumptech.glide.request.RequestOptions
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.PuppyRepository
import dev.chrisbanes.accompanist.glide.GlideImage

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

    Row(
        modifier.padding(8.dp).clip(RoundedCornerShape(4.dp))
            .background(color = MaterialTheme.colors.surface).clickable(
                onClick = { selectItem.invoke(item.id) }
            ).padding(16.dp)
    ) {
        GlideImage(
            data = item.photo,
            requestBuilder = {
                val options = RequestOptions()
                options.centerCrop()
                options.circleCrop()
                apply(options)
            },
            loading = {
                Box(Modifier.fillMaxWidth()) {
                    CircularProgressIndicator(Modifier.align(Alignment.Center))
                }
            },
        )
    }
}

@Composable
fun PuppiesList(
    list: List<Puppy>,
    selectItem: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(0.dp, 54.dp, 0.dp, 0.dp)
    ) {
        PuppyAppBar()
        LazyColumn(
            modifier = Modifier.padding(4.dp)
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
