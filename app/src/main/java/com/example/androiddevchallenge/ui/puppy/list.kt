package com.example.androiddevchallenge.ui.puppy

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import com.example.androiddevchallenge.model.Puppy
import com.example.androiddevchallenge.model.PuppyRepository

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

    Row(modifier.padding(8.dp).clip(RoundedCornerShape(4.dp))
        .background(color = MaterialTheme.colors.surface).clickable(
            onClick = { selectItem.invoke(item.id) }
        ).padding(16.dp)) {
        Surface(
            modifier = modifier.requiredSize(50.dp),
            color = MaterialTheme.colors.surface,
            shape = MaterialTheme.shapes.medium
        ) {
            //Image
        }

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
