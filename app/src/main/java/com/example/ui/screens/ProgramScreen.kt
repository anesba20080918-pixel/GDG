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
import com.example.ui.components.ProgramActivityCard
import com.example.ui.theme.MzabOchre

@Composable
fun ProgramScreen(
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("program_screen"),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Title & Info
        item {
            Column(modifier = Modifier.padding(bottom = 16.dp)) {
                Text(
                    text = AppStrings.navProgram(language),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Honest Notice regarding Speaker Confirmation
                Surface(
                    shape = RoundedCornerShape(12.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.6f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(14.dp),
                        verticalAlignment = Alignment.Top
                    ) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = MzabOchre,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = AppStrings.programNotice(language),
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }
            }
        }

        // Program Activities List
        items(CommunityDataSource.devfestActivities) { activity ->
            ProgramActivityCard(
                activity = activity,
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
