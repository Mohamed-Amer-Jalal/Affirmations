package com.example.affirmations.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.affirmations.R
import com.example.affirmations.data.Affirmation
import com.example.affirmations.data.Datasource
import com.example.affirmations.ui.theme.AffirmationsTheme

@Composable
fun AffirmationApp() {
    val layoutDirection = WindowInsets.safeDrawing
        .asPaddingValues()
        .calculateStartPadding(LocalLayoutDirection.current)
    Scaffold(
        topBar = { TopBar() },
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(start = layoutDirection, end = layoutDirection)
    ) { innerPadding ->
        AffirmationList(
            affirmationList = Datasource().loadAffirmations(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Affirmations", fontWeight = FontWeight.Bold) },
        colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.inverseOnSurface
        )
    )
}

@Composable
fun AffirmationCard(affirmation: Affirmation) {
    Card(modifier = Modifier.padding(dimensionResource(R.dimen.padding_8))) {
        Column {
            Image(
                painter = painterResource(affirmation.imageResourceId),
                contentDescription = stringResource(affirmation.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(R.dimen.image_height)),
                contentScale = ContentScale.Crop
            )
            Text(
                text = stringResource(affirmation.stringResourceId),
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_16)),
                style = MaterialTheme.typography.headlineLarge
            )
        }
    }
}

@Composable
fun AffirmationList(affirmationList: List<Affirmation>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(affirmationList) { affirmation ->
            AffirmationCard(
                affirmation = affirmation
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, locale = "ar")
@Composable
fun AffirmationCardDarkThemePreview() {
    AffirmationsTheme(darkTheme = true) {
        AffirmationApp()
    }
}

@Preview(showBackground = true, showSystemUi = true, locale = "ar")
@Composable
fun AffirmationCardWhiteThemePreview() {
    AffirmationsTheme(darkTheme = false) {
        AffirmationApp()
    }
}