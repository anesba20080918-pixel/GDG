package com.example.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.OpenInNew
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.R
import com.example.localization.AppStrings
import com.example.model.AppLanguage
import com.example.ui.components.AppFooter
import com.example.ui.components.GoogleColorsBar
import com.example.ui.components.MzabArchCard
import com.example.ui.theme.*

@Composable
fun AboutGDGScreen(
    language: AppLanguage,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val membershipFormUrl = "https://docs.google.com/forms/d/e/1FAIpQLSddyGm44owNr1LO_8J5xifPQd5GpiaCOjrudpfdUO6PwtxG6A/viewform"

    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .testTag("about_gdg_screen"),
        contentPadding = PaddingValues(16.dp)
    ) {
        // Header with Logo
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_gdg_ghardaia),
                    contentDescription = "GDG Ghardaïa Logo",
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(16.dp))
                )

                Spacer(modifier = Modifier.height(12.dp))

                Text(
                    text = AppStrings.aboutGDGTitle(language),
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Ghardaïa, Algeria • Google Developer Groups",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Medium
                )
            }
        }

        // Mission and Vision Card
        item {
            MzabArchCard(modifier = Modifier.padding(bottom = 16.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Default.Lightbulb,
                        contentDescription = null,
                        tint = GoogleYellow,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(
                        text = AppStrings.aboutGDGMission(language),
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = AppStrings.aboutGDGDescription(language),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    lineHeight = 22.sp
                )
            }
        }

        // Focus Areas / Topics
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
                shape = RoundedCornerShape(16.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.35f))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Text(
                        text = when (language) {
                            AppLanguage.ARABIC -> "المجالات التقنية والاهتمامات"
                            AppLanguage.FRENCH -> "Domaines Techniques & Ateliers"
                            AppLanguage.ENGLISH -> "Technical Domains & Activities"
                        },
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    DomainItem(
                        icon = Icons.Default.Android,
                        color = GoogleGreen,
                        title = when (language) {
                            AppLanguage.ARABIC -> "تطوير أندرويد و Flutter"
                            AppLanguage.FRENCH -> "Android & Flutter"
                            AppLanguage.ENGLISH -> "Android & Flutter"
                        },
                        desc = when (language) {
                            AppLanguage.ARABIC -> "بناء تطبيقات الهواتف الذكية بتقنيات حديثة وكوتلن."
                            AppLanguage.FRENCH -> "Développement d'applications mobiles modernes."
                            AppLanguage.ENGLISH -> "Native mobile and cross-platform app engineering."
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DomainItem(
                        icon = Icons.Default.Psychology,
                        color = GoogleBlue,
                        title = when (language) {
                            AppLanguage.ARABIC -> "الذكاء الاصطناعي و Gemini"
                            AppLanguage.FRENCH -> "IA & Gemini"
                            AppLanguage.ENGLISH -> "Artificial Intelligence & Gemini"
                        },
                        desc = when (language) {
                            AppLanguage.ARABIC -> "تضمين وتطوير حلول الذكاء الاصطناعي التوليدي والتعلم الآلي."
                            AppLanguage.FRENCH -> "Intégration des modèles de langage et Machine Learning."
                            AppLanguage.ENGLISH -> "Generative AI, multimodal models, and machine learning."
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DomainItem(
                        icon = Icons.Default.Cloud,
                        color = GoogleYellow,
                        title = when (language) {
                            AppLanguage.ARABIC -> "الحوسبة السحابية و Google Cloud"
                            AppLanguage.FRENCH -> "Cloud & GCP"
                            AppLanguage.ENGLISH -> "Cloud & Google Cloud Platform"
                        },
                        desc = when (language) {
                            AppLanguage.ARABIC -> "خدمات الاستضافة السحابية وهندسة البنى الموزعة الآمنة."
                            AppLanguage.FRENCH -> "Infrastructures résilientes et services cloud Google."
                            AppLanguage.ENGLISH -> "Scalable backend infrastructures and secure cloud computing."
                        }
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    DomainItem(
                        icon = Icons.Default.Code,
                        color = GoogleRed,
                        title = when (language) {
                            AppLanguage.ARABIC -> "تقنيات الويب والبرمجيات المفتوحة"
                            AppLanguage.FRENCH -> "Web & Open Source"
                            AppLanguage.ENGLISH -> "Modern Web & Open Source"
                        },
                        desc = when (language) {
                            AppLanguage.ARABIC -> "تطوير تطبيقات الويب السريعة والمساهمة في البرمجيات الحرة."
                            AppLanguage.FRENCH -> "Applications web performantes et culture open-source."
                            AppLanguage.ENGLISH -> "High-performance web apps and open-source collaboration."
                        }
                    )
                }
            }
        }

        // Join Community Membership Section
        item {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.4f)),
                shape = RoundedCornerShape(16.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.3f))
            ) {
                Column(modifier = Modifier.padding(18.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            imageVector = Icons.Default.Assignment,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(24.dp)
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = AppStrings.joinCommunity(language),
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = AppStrings.membershipDistinction(language),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Button(
                        onClick = {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(membershipFormUrl))
                            context.startActivity(intent)
                        },
                        shape = RoundedCornerShape(10.dp),
                        modifier = Modifier.fillMaxWidth().testTag("btn_join_club_form")
                    ) {
                        Text(text = AppStrings.joinCommunity(language))
                        Spacer(modifier = Modifier.width(8.dp))
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.OpenInNew,
                            contentDescription = null,
                            modifier = Modifier.size(18.dp)
                        )
                    }
                }
            }
        }

        // Footer
        item {
            AppFooter(language = language)
        }
    }
}

@Composable
private fun DomainItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    color: androidx.compose.ui.graphics.Color,
    title: String,
    desc: String
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.Top
    ) {
        Surface(
            shape = RoundedCornerShape(8.dp),
            color = color.copy(alpha = 0.15f),
            modifier = Modifier.size(36.dp)
        ) {
            Box(contentAlignment = Alignment.Center) {
                Icon(imageVector = icon, contentDescription = null, tint = color, modifier = Modifier.size(20.dp))
            }
        }
        Spacer(modifier = Modifier.width(12.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.onSurface)
            Spacer(modifier = Modifier.height(2.dp))
            Text(text = desc, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}
