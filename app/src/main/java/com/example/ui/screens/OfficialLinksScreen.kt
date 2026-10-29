package com.example.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.data.CommunityDataSource
import com.example.localization.AppStrings
import com.example.model.AppLanguage
import com.example.ui.components.AppFooter
import com.example.ui.components.OfficialLinkCard
import com.example.ui.theme.GoogleBlue

@Composable
fun OfficialLinksScreen(
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("official_links_screen"),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Section Header
        item {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = AppStrings.navOfficialLinks(language),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Distinction between membership and event attendance
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = GoogleBlue.copy(alpha = 0.08f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = GoogleBlue,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = AppStrings.membershipDistinction(language),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Links List
        items(CommunityDataSource.verifiedOfficialLinks) { link ->
            OfficialLinkCard(
                link = link,
                language = language,
                modifier = Modifier.padding(bottom = 12.dp)
            )
        }

        // Footer
        item {
            AppFooter(language = language)
        }
    }
}
