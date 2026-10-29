package com.example.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.model.*
import com.example.ui.theme.*

@Composable
fun OfficialLinkCard(
    link: OfficialLink,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link.url))
                context.startActivity(intent)
            }
            .testTag("official_link_${link.id}"),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.4f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(46.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(
                        when (link.platform) {
                            LinkPlatform.WEBSITE -> GoogleBlue.copy(alpha = 0.14f)
                            LinkPlatform.FACEBOOK -> Color(0xFF1877F2).copy(alpha = 0.14f)
                            LinkPlatform.LINKEDIN -> Color(0xFF0A66C2).copy(alpha = 0.14f)
                            LinkPlatform.INSTAGRAM -> Color(0xFFE4405F).copy(alpha = 0.14f)
                            LinkPlatform.DISCORD -> Color(0xFF5865F2).copy(alpha = 0.14f)
                            LinkPlatform.COMMUNITY -> GoogleYellow.copy(alpha = 0.18f)
                            LinkPlatform.FORM -> GoogleGreen.copy(alpha = 0.14f)
                        }
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = when (link.platform) {
                        LinkPlatform.WEBSITE -> Icons.Default.Language
                        LinkPlatform.FACEBOOK -> Icons.Default.Public
                        LinkPlatform.LINKEDIN -> Icons.Default.Work
                        LinkPlatform.INSTAGRAM -> Icons.Default.CameraAlt
                        LinkPlatform.DISCORD -> Icons.Default.Forum
                        LinkPlatform.COMMUNITY -> Icons.Default.Groups
                        LinkPlatform.FORM -> Icons.Default.Assignment
                    },
                    contentDescription = link.platform.name,
                    tint = when (link.platform) {
                        LinkPlatform.WEBSITE -> GoogleBlue
                        LinkPlatform.FACEBOOK -> Color(0xFF1877F2)
                        LinkPlatform.LINKEDIN -> Color(0xFF0A66C2)
                        LinkPlatform.INSTAGRAM -> Color(0xFFE4405F)
                        LinkPlatform.DISCORD -> Color(0xFF5865F2)
                        LinkPlatform.COMMUNITY -> GoogleYellow
                        LinkPlatform.FORM -> GoogleGreen
                    },
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(14.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = link.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                if (link.description != null) {
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = link.description.get(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = link.url,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Spacer(modifier = Modifier.width(8.dp))

            Icon(
                imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                contentDescription = "Open Link",
                tint = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

@Composable
fun TrackCard(
    track: DevFestTrack,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    val trackColor = when (track.type) {
        DevFestTrackType.AI_ML -> GoogleBlue
        DevFestTrackType.ANDROID_KOTLIN -> GoogleGreen
        DevFestTrackType.CLOUD_DEVOPS -> GoogleYellow
        DevFestTrackType.WEB_TECHNOLOGIES -> GoogleRed
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("track_card_${track.type.name}"),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(18.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(trackColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = when (track.type) {
                            DevFestTrackType.AI_ML -> Icons.Default.Psychology
                            DevFestTrackType.ANDROID_KOTLIN -> Icons.Default.Android
                            DevFestTrackType.CLOUD_DEVOPS -> Icons.Default.Cloud
                            DevFestTrackType.WEB_TECHNOLOGIES -> Icons.Default.Code
                        },
                        contentDescription = null,
                        tint = trackColor,
                        modifier = Modifier.size(22.dp)
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = track.title.get(language),
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = track.description.get(language),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                lineHeight = MaterialTheme.typography.bodyMedium.lineHeight
            )
        }
    }
}

@Composable
fun ProgramActivityCard(
    activity: ProgramActivity,
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    val accentColor = when (activity.trackType) {
        DevFestTrackType.AI_ML -> GoogleBlue
        DevFestTrackType.ANDROID_KOTLIN -> GoogleGreen
        DevFestTrackType.CLOUD_DEVOPS -> GoogleYellow
        DevFestTrackType.WEB_TECHNOLOGIES -> GoogleRed
    }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .testTag("activity_card_${activity.id}"),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        shape = RoundedCornerShape(14.dp),
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.35f)),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant
                ) {
                    Text(
                        text = activity.timeSlot,
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }

                Surface(
                    shape = RoundedCornerShape(6.dp),
                    color = accentColor.copy(alpha = 0.12f)
                ) {
                    Text(
                        text = activity.activityTypeLabel.get(language),
                        style = MaterialTheme.typography.labelSmall,
                        fontWeight = FontWeight.SemiBold,
                        color = accentColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = activity.title.get(language),
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = activity.description.get(language),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}
