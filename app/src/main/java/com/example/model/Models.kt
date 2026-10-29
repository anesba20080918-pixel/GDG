package com.example.model

enum class AppLanguage(val code: String, val displayName: String, val isRtl: Boolean) {
    ARABIC("ar", "العربية", true),
    FRENCH("fr", "Français", false),
    ENGLISH("en", "English", false);

    companion object {
        fun fromCode(code: String): AppLanguage = entries.firstOrNull { it.code == code } ?: ENGLISH
    }
}

enum class ThemeMode(val code: String) {
    SYSTEM("system"),
    LIGHT("light"),
    DARK("dark")
}

/**
 * 6 Main Application Sections per Specification Section 6:
 * 1. Home
 * 2. About GDG Ghardaïa
 * 3. DevFest Ghardaïa 2026
 * 4. Program and Activities
 * 5. Official Links
 * 6. Developer — Anes BA
 */
enum class NavDestination {
    HOME,
    ABOUT_GDG,
    DEVFEST,
    PROGRAM,
    OFFICIAL_LINKS,
    DEVELOPER
}

data class LocalizedText(
    val ar: String,
    val fr: String,
    val en: String
) {
    fun get(lang: AppLanguage): String = when (lang) {
        AppLanguage.ARABIC -> ar
        AppLanguage.FRENCH -> fr
        AppLanguage.ENGLISH -> en
    }
}

enum class DevFestTrackType {
    AI_ML,
    ANDROID_KOTLIN,
    CLOUD_DEVOPS,
    WEB_TECHNOLOGIES
}

data class DevFestTrack(
    val type: DevFestTrackType,
    val title: LocalizedText,
    val description: LocalizedText,
    val iconName: String
)

data class ProgramActivity(
    val id: String,
    val timeSlot: String,
    val title: LocalizedText,
    val description: LocalizedText,
    val trackType: DevFestTrackType,
    val activityTypeLabel: LocalizedText
)

enum class LinkPlatform {
    WEBSITE,
    FACEBOOK,
    INSTAGRAM,
    LINKEDIN,
    COMMUNITY,
    DISCORD,
    FORM
}

enum class LinkCategory {
    WEBSITE,
    SOCIAL_MEDIA,
    COMMUNITY_EVENT,
    MEMBERSHIP
}

data class OfficialLink(
    val id: String,
    val name: String,
    val url: String,
    val platform: LinkPlatform,
    val category: LinkCategory,
    val categoryLabel: LocalizedText,
    val description: LocalizedText? = null
)

/**
 * Verified Developer Profile — Anes BA
 * Section 5 and Section 13 verified facts only.
 */
object DeveloperProfile {
    const val name = "Anes BA"

    val academicLevel = LocalizedText(
        ar = "طالب سنة أولى إعلام آلي",
        fr = "Étudiant en 1ère année Informatique",
        en = "First-year Computer Science student"
    )

    val faculty = LocalizedText(
        ar = "كلية العلوم والتكنولوجيا",
        fr = "Faculté des Sciences et de la Technologie",
        en = "Faculty of Science and Technology"
    )

    val community = LocalizedText(
        ar = "عضو في GDG غرداية",
        fr = "Membre de GDG Ghardaïa",
        en = "Member of GDG Ghardaïa"
    )

    val introduction = LocalizedText(
        ar = "أنس باء، طالب سنة أولى في مجال الإعلام الآلي بكلية العلوم والتكنولوجيا، وعضو في مجتمع مطوري غوغل غرداية (GDG Ghardaïa). قام بتصميم وتطوير هذا التطبيق المخصص للتعريف بالنادي وبفعالية DevFest Ghardaïa 2026.",
        fr = "Anes BA est étudiant en première année d'informatique à la Faculté des Sciences et de la Technologie, et membre de GDG Ghardaïa. Il a conçu et développé cette application officielle d'information pour faire rayonner la communauté et présenter DevFest Ghardaïa 2026.",
        en = "Anes BA is a first-year Computer Science student at the Faculty of Science and Technology and a member of GDG Ghardaïa. He designed and developed this informational application to showcase the club's identity and introduce DevFest Ghardaïa 2026."
    )
}
