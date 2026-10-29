package com.example.data

import com.example.model.*

object CommunityDataSource {

    /**
     * All 8 Verified Official Links per Section 9 and Section 12:
     * 1. Official website: https://www.gdgghardaia.com/
     * 2. Alternative website: https://gdgghardaia.vercel.app/
     * 3. Facebook: https://fb.com/GDG.Ghardaia
     * 4. Instagram: https://www.instagram.com/gdg.ghardaia
     * 5. LinkedIn: https://dz.linkedin.com/company/gdgghardaia
     * 6. Google Developer Groups community / DevFest event page: https://gdg.community.dev/events/details/google-gdg-ghardaia-presents-devfest-ghardaia-2026/
     * 7. Discord community: https://discord.com/invite/GMueprF5dq
     * 8. Club membership form: https://docs.google.com/forms/d/e/1FAIpQLSddyGm44owNr1LO_8J5xifPQd5GpiaCOjrudpfdUO6PwtxG6A/viewform
     */
    val verifiedOfficialLinks = listOf(
        OfficialLink(
            id = "link-website-primary",
            name = "GDG Ghardaïa Official Website",
            url = "https://www.gdgghardaia.com/",
            platform = LinkPlatform.WEBSITE,
            category = LinkCategory.WEBSITE,
            categoryLabel = LocalizedText(
                ar = "الموقع الرسمي الأساسي",
                fr = "Site web officiel (Principal)",
                en = "Official Website (Primary)"
            ),
            description = LocalizedText(
                ar = "البوابة الرسمية الرئيسية لمجتمع مطوري غوغل غرداية",
                fr = "Portail officiel principal de GDG Ghardaïa",
                en = "Primary official portal of GDG Ghardaïa community"
            )
        ),
        OfficialLink(
            id = "link-website-candidate2",
            name = "GDG Ghardaïa Portal (Vercel)",
            url = "https://gdgghardaia.vercel.app/",
            platform = LinkPlatform.WEBSITE,
            category = LinkCategory.WEBSITE,
            categoryLabel = LocalizedText(
                ar = "بوابة الويب البديلة",
                fr = "Portail alternatif",
                en = "Alternative Web Portal"
            ),
            description = LocalizedText(
                ar = "نطاق بديل مستضاف للاطلاع والمتابعة",
                fr = "Domaine alternatif hébergé pour consultation",
                en = "Alternative hosted domain for community updates"
            )
        ),
        OfficialLink(
            id = "link-facebook",
            name = "GDG Ghardaïa on Facebook",
            url = "https://fb.com/GDG.Ghardaia",
            platform = LinkPlatform.FACEBOOK,
            category = LinkCategory.SOCIAL_MEDIA,
            categoryLabel = LocalizedText(
                ar = "فيسبوك",
                fr = "Facebook",
                en = "Facebook"
            ),
            description = LocalizedText(
                ar = "الصفحة الرسمية على فيسبوك لمتابعة جديد الفعاليات والمستجدات",
                fr = "Page Facebook officielle pour suivre l'actualité",
                en = "Official Facebook page for announcements and news"
            )
        ),
        OfficialLink(
            id = "link-instagram",
            name = "GDG Ghardaïa on Instagram",
            url = "https://www.instagram.com/gdg.ghardaia",
            platform = LinkPlatform.INSTAGRAM,
            category = LinkCategory.SOCIAL_MEDIA,
            categoryLabel = LocalizedText(
                ar = "إنستغرام",
                fr = "Instagram",
                en = "Instagram"
            ),
            description = LocalizedText(
                ar = "تغطيات بصرية، صور الأنشطة ومقتطفات الورشات",
                fr = "Couverture visuelle, photos et coulisses des ateliers",
                en = "Visual coverage, event photos, and workshop highlights"
            )
        ),
        OfficialLink(
            id = "link-linkedin",
            name = "GDG Ghardaïa on LinkedIn",
            url = "https://dz.linkedin.com/company/gdgghardaia",
            platform = LinkPlatform.LINKEDIN,
            category = LinkCategory.SOCIAL_MEDIA,
            categoryLabel = LocalizedText(
                ar = "لينكد إن",
                fr = "LinkedIn",
                en = "LinkedIn"
            ),
            description = LocalizedText(
                ar = "الشبكة المهنية وتواصل المطورين والشركاء التقنيين",
                fr = "Réseau professionnel et collaborations techniques",
                en = "Professional networking and tech community collaborations"
            )
        ),
        OfficialLink(
            id = "link-gdg-community-devfest",
            name = "DevFest Ghardaïa 2026 (GDG Community)",
            url = "https://gdg.community.dev/events/details/google-gdg-ghardaia-presents-devfest-ghardaia-2026/",
            platform = LinkPlatform.COMMUNITY,
            category = LinkCategory.COMMUNITY_EVENT,
            categoryLabel = LocalizedText(
                ar = "صفحة الفعالية على مجتمع Google",
                fr = "Page officielle DevFest (GDG Community)",
                en = "Official Event Page (GDG Community)"
            ),
            description = LocalizedText(
                ar = "صفحة معلومات الفعالية الرسمية على منصة Google Developers",
                fr = "Page d'information officielle sur la plateforme Google Developers",
                en = "Official event information page on Google Developers platform"
            )
        ),
        OfficialLink(
            id = "link-discord",
            name = "GDG Ghardaïa Discord Server",
            url = "https://discord.com/invite/GMueprF5dq",
            platform = LinkPlatform.DISCORD,
            category = LinkCategory.COMMUNITY_EVENT,
            categoryLabel = LocalizedText(
                ar = "خادم ديسكورد للمطورين",
                fr = "Serveur Discord",
                en = "Discord Community Server"
            ),
            description = LocalizedText(
                ar = "فضاء نقاش وتبادل معرفي تقني مستمر بين أعضاء المجتمع",
                fr = "Espace d'échange et d'entraide entre développeurs",
                en = "Real-time discussions and technical collaboration for developers"
            )
        ),
        OfficialLink(
            id = "link-membership-form",
            name = "Join GDG Ghardaïa (Membership Form)",
            url = "https://docs.google.com/forms/d/e/1FAIpQLSddyGm44owNr1LO_8J5xifPQd5GpiaCOjrudpfdUO6PwtxG6A/viewform",
            platform = LinkPlatform.FORM,
            category = LinkCategory.MEMBERSHIP,
            categoryLabel = LocalizedText(
                ar = "استمارة الانضمام لعضوية النادي",
                fr = "Formulaire d'adhésion au club",
                en = "Community Membership Form"
            ),
            description = LocalizedText(
                ar = "استمارة الانضمام لعضوية مجتمع GDG غرداية (ليست استمارة تسجيل في ديف فيست)",
                fr = "Formulaire d'adhésion à la communauté (distinct de l'inscription DevFest)",
                en = "General club membership application (distinct from DevFest event registration)"
            )
        )
    )

    /**
     * 4 Core DevFest Ghardaïa 2026 Technical Tracks per Section 10
     */
    val devfestTracks = listOf(
        DevFestTrack(
            type = DevFestTrackType.AI_ML,
            title = LocalizedText("الذكاء الاصطناعي وتعلم الآلة", "Intelligence Artificielle & ML", "Artificial Intelligence & ML"),
            description = LocalizedText(
                "استكشاف نماذج الذكاء الاصطناعي التوليدي، وتقنيات التعلم الآلي، وأدوات المطورين الحديثة.",
                "Exploration des modèles d'IA générative, de l'apprentissage automatique et des outils pour développeurs.",
                "Exploring generative AI models, machine learning, and modern developer toolkits."
            ),
            iconName = "psychology"
        ),
        DevFestTrack(
            type = DevFestTrackType.ANDROID_KOTLIN,
            title = LocalizedText("تطوير أندرويد و Kotlin", "Développement Android & Kotlin", "Android & Kotlin Development"),
            description = LocalizedText(
                "هندسة تطبيقات أندرويد الحديثة باستخدام Jetpack Compose وتصميم Material 3.",
                "Conception d'applications Android modernes avec Jetpack Compose et Material 3.",
                "Modern native Android development with Jetpack Compose, Kotlin, and Material 3 design."
            ),
            iconName = "android"
        ),
        DevFestTrack(
            type = DevFestTrackType.CLOUD_DEVOPS,
            title = LocalizedText("الحوسبة السحابية و DevOps", "Cloud Computing & DevOps", "Cloud & DevOps"),
            description = LocalizedText(
                "خدمات Google Cloud Platform، البنية التحتية البرمجية، وتأمين ونشر التطبيقات السحابية.",
                "Services Google Cloud Platform, architectures conteneurisées et déploiement résilient.",
                "Google Cloud Platform services, containerization, and reliable cloud deployments."
            ),
            iconName = "cloud"
        ),
        DevFestTrack(
            type = DevFestTrackType.WEB_TECHNOLOGIES,
            title = LocalizedText("تقنيات الويب الحديثة", "Technologies Web Modernes", "Modern Web Technologies"),
            description = LocalizedText(
                "معايير الويب المعاصرة، أداء التطبيقات، والواجهات التفاعلية عالية السرعة.",
                "Standards web récents, performance et optimisation des applications web modernes.",
                "Modern web standards, responsive UI engineering, and web application performance."
            ),
            iconName = "web"
        )
    )

    /**
     * Program and Activities Framework for DevFest Ghardaïa 2026
     * Formulated without invented speaker names or unverified halls.
     */
    val devfestActivities = listOf(
        ProgramActivity(
            id = "act-1",
            timeSlot = "09:00 - 09:45",
            title = LocalizedText("الجلسة الافتتاحية والترحيب", "Accueil & Keynote d'Ouverture", "Welcome & Opening Keynote"),
            description = LocalizedText(
                "افتتاح فعاليات ديف فيست غرداية 2026، واستعراض رؤية مجتمع GDG والتطلعات التقنية.",
                "Ouverture officielle du DevFest Ghardaïa 2026 et présentation de la vision de la communauté.",
                "Official opening of DevFest Ghardaïa 2026 and community vision keynote."
            ),
            trackType = DevFestTrackType.AI_ML,
            activityTypeLabel = LocalizedText("مؤتمر رئيسي", "Keynote", "Keynote")
        ),
        ProgramActivity(
            id = "act-2",
            timeSlot = "10:00 - 11:15",
            title = LocalizedText("محاضرات تقنية: الذكاء الاصطناعي وتطبيقاته", "Conférences: IA & Technologies Google", "Tech Talks: AI & Modern Frameworks"),
            description = LocalizedText(
                "عروض تقنية تفصيلية حول أحدث تقنيات غوغل ونماذج الذكاء الاصطناعي واستخداماتها العملية.",
                "Sessions détaillées sur les dernières avancées technologiques et l'intégration de l'IA.",
                "In-depth technical sessions on Google technologies and applied artificial intelligence."
            ),
            trackType = DevFestTrackType.AI_ML,
            activityTypeLabel = LocalizedText("محاضرة تقنية", "Conférence", "Tech Talk")
        ),
        ProgramActivity(
            id = "act-3",
            timeSlot = "11:30 - 13:00",
            title = LocalizedText("ورشات عمل تطبيقية تفاعلية", "Ateliers Pratiques Hands-on", "Interactive Hands-on Workshops"),
            description = LocalizedText(
                "جلسات تطبيقية في البرمجة وتطوير البرمجيات بإشراف ممارسين في المجال.",
                "Sessions pratiques de programmation et de développement logiciel en direct.",
                "Hands-on coding and software engineering sessions with practical guidance."
            ),
            trackType = DevFestTrackType.ANDROID_KOTLIN,
            activityTypeLabel = LocalizedText("ورشة عمل", "Atelier", "Workshop")
        ),
        ProgramActivity(
            id = "act-4",
            timeSlot = "13:00 - 14:15",
            title = LocalizedText("استراحة التواصل المجتمعي", "Pause Déjeuner & Réseautage", "Community Lunch & Networking"),
            description = LocalizedText(
                "فضاء حر لتبادل المعرفة والتواصل بين المطورين، والطلبة، والمهتمين بالتقنية.",
                "Moment d'échange libre et de networking entre développeurs, étudiants et passionnés.",
                "Open networking and exchange between developers, students, and tech enthusiasts."
            ),
            trackType = DevFestTrackType.CLOUD_DEVOPS,
            activityTypeLabel = LocalizedText("تواصل مجتمعي", "Réseautage", "Networking")
        ),
        ProgramActivity(
            id = "act-5",
            timeSlot = "14:30 - 16:00",
            title = LocalizedText("جلسات متقدمة في الحوسبة السحابية والويب", "Sessions Avancées: Cloud & Web", "Advanced Sessions: Cloud & Web"),
            description = LocalizedText(
                "محاضرات متقدمة حول بنية السحابة ونشر التطبيقات وتطوير واجهات الويب الحديثة.",
                "Présentations avancées sur l'architecture cloud et le développement web moderne.",
                "Advanced presentations on cloud architecture, containerization, and modern web."
            ),
            trackType = DevFestTrackType.WEB_TECHNOLOGIES,
            activityTypeLabel = LocalizedText("محاضرة تقنية", "Conférence", "Tech Talk")
        ),
        ProgramActivity(
            id = "act-6",
            timeSlot = "16:15 - 17:30",
            title = LocalizedText("عرض المشاريع والجلسة الختامية", "Présentation de Projets & Clôture", "Project Showcases & Closing"),
            description = LocalizedText(
                "استعراض مشاريع وإسهامات أعضاء المجتمع، وخلاصة مخرجات الحدث وكلمة الختام.",
                "Mise en valeur des projets de la communauté, bilan de la journée et mot de clôture.",
                "Highlighting community projects, event wrap-up, and closing remarks."
            ),
            trackType = DevFestTrackType.AI_ML,
            activityTypeLabel = LocalizedText("جلسة ختامية", "Clôture", "Closing")
        )
    )
}
