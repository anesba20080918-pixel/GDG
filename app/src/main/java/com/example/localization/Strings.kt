package com.example.localization

import com.example.model.AppLanguage

object AppStrings {
    // App & Header titles
    fun appTitle(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "GDG Ghardaïa"
        AppLanguage.FRENCH -> "GDG Ghardaïa"
        AppLanguage.ENGLISH -> "GDG Ghardaïa"
    }

    fun devfestTitle(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "DevFest Ghardaïa 2026"
        AppLanguage.FRENCH -> "DevFest Ghardaïa 2026"
        AppLanguage.ENGLISH -> "DevFest Ghardaïa 2026"
    }

    fun devfestSubtitle(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "المهرجان التقني السنوي الرائد لمجتمع مطوري غوغل بغرداية"
        AppLanguage.FRENCH -> "Le festival technologique annuel phare de GDG Ghardaïa"
        AppLanguage.ENGLISH -> "The annual flagship tech festival by Google Developer Groups Ghardaïa"
    }

    // Developer credits (Exact strings mandated by Sections 5 and 13)
    fun designedAndDevelopedBy(lang: AppLanguage) = "Designed & Developed by Anes BA"
    fun madeWithCareBy(lang: AppLanguage) = "Made with care by Anes BA"

    // 6 Main Navigation Items per Section 6
    fun navHome(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "الرئيسية"
        AppLanguage.FRENCH -> "Accueil"
        AppLanguage.ENGLISH -> "Home"
    }

    fun navAboutGDG(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "عن GDG غرداية"
        AppLanguage.FRENCH -> "À propos de GDG"
        AppLanguage.ENGLISH -> "About GDG Ghardaïa"
    }

    fun navDevFest(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "ديف فيست 2026"
        AppLanguage.FRENCH -> "DevFest 2026"
        AppLanguage.ENGLISH -> "DevFest 2026"
    }

    fun navProgram(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "البرنامج والأنشطة"
        AppLanguage.FRENCH -> "Programme & Activités"
        AppLanguage.ENGLISH -> "Program & Activities"
    }

    fun navOfficialLinks(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "الروابط الرسمية"
        AppLanguage.FRENCH -> "Liens Officiels"
        AppLanguage.ENGLISH -> "Official Links"
    }

    fun navDeveloper(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "المطور — Anes BA"
        AppLanguage.FRENCH -> "Développeur — Anes BA"
        AppLanguage.ENGLISH -> "Developer — Anes BA"
    }

    // Countdown Labels
    fun countdownDays(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "يوم"
        AppLanguage.FRENCH -> "Jours"
        AppLanguage.ENGLISH -> "Days"
    }

    fun countdownHours(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "ساعة"
        AppLanguage.FRENCH -> "Heures"
        AppLanguage.ENGLISH -> "Hours"
    }

    fun countdownMinutes(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "دقيقة"
        AppLanguage.FRENCH -> "Minutes"
        AppLanguage.ENGLISH -> "Minutes"
    }

    fun countdownSeconds(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "ثانية"
        AppLanguage.FRENCH -> "Secondes"
        AppLanguage.ENGLISH -> "Seconds"
    }

    fun countdownHeading(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "العد التنازلي لانطلاق ديف فيست 2026"
        AppLanguage.FRENCH -> "Compte à rebours DevFest 2026"
        AppLanguage.ENGLISH -> "Countdown to DevFest 2026"
    }

    fun countdownHappeningNow(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "الفعالية جارية الآن!"
        AppLanguage.FRENCH -> "L'événement a lieu actuellement !"
        AppLanguage.ENGLISH -> "The event is happening now!"
    }

    fun countdownStarting(lang: AppLanguage) = countdownHappeningNow(lang)
    fun countdownOngoing(lang: AppLanguage) = countdownHappeningNow(lang)

    fun countdownCompleted(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "انتهت الفعالية — شكراً لمشاركتكم"
        AppLanguage.FRENCH -> "Événement terminé — Merci à tous"
        AppLanguage.ENGLISH -> "Event completed — Thank you for participating"
    }

    fun countdownUnconfirmed(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "سيتم الإعلان عن موعد وتوقيت الفعالية قريباً"
        AppLanguage.FRENCH -> "La date et l'heure de l'événement seront annoncées prochainement"
        AppLanguage.ENGLISH -> "Event date and start time will be announced"
    }

    fun provisionalDateNotice(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "التاريخ المعتمد: 25 نوفمبر 2026 (توقيت الجزائر Africa/Algiers)"
        AppLanguage.FRENCH -> "Date cible : 25 novembre 2026 (Heure d'Algérie Africa/Algiers)"
        AppLanguage.ENGLISH -> "Target date: 25 November 2026 (Africa/Algiers Time)"
    }

    // Action buttons
    fun exploreDevFest(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "استكشف ديف فيست 2026"
        AppLanguage.FRENCH -> "Découvrir DevFest 2026"
        AppLanguage.ENGLISH -> "Explore DevFest 2026"
    }

    fun exploreClub(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "عن مجتمع GDG غرداية"
        AppLanguage.FRENCH -> "À propos du club GDG"
        AppLanguage.ENGLISH -> "About GDG Club"
    }

    fun viewProgram(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "عرض البرنامج الكامل"
        AppLanguage.FRENCH -> "Voir le programme"
        AppLanguage.ENGLISH -> "View Full Program"
    }

    fun connectLinks(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "تواصل معنا"
        AppLanguage.FRENCH -> "Nos Liens Officiels"
        AppLanguage.ENGLISH -> "Connect With Us"
    }

    fun openLink(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "فتح الرابط الرسمي"
        AppLanguage.FRENCH -> "Ouvrir le lien officiel"
        AppLanguage.ENGLISH -> "Open Official Link"
    }

    fun joinCommunity(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "انضم إلى عضوية GDG غرداية"
        AppLanguage.FRENCH -> "Rejoindre la communauté GDG"
        AppLanguage.ENGLISH -> "Join GDG Ghardaïa Community"
    }

    // Section specific texts
    fun aboutGDGTitle(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "مجتمع مطوري غوغل غرداية"
        AppLanguage.FRENCH -> "Communauté Google Developer Groups Ghardaïa"
        AppLanguage.ENGLISH -> "Google Developer Groups Ghardaïa"
    }

    fun aboutGDGDescription(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "مجموعة مطوري غوغل غرداية (GDG Ghardaïa) هي تجمع تطوعي تقني يضم الطلبة، والمطورين، ورواد الأعمال، والمهتمين بالبرمجيات الحديثة وتكنولوجيا غوغل. يهدف المجتمع إلى نشر ثقافة التشارك المعرفي، وتقديم ورشات تطبيقية متقدمة، وبناء حلول تكنولوجية تخدم المنطقة والوطن."
        AppLanguage.FRENCH -> "GDG Ghardaïa est une communauté technologique à but non lucratif rassemblant étudiants, développeurs et passionnés des technologies Google et open-source. La communauté œuvre pour le partage des connaissances, la formation continue et l'émulation technique dans la vallée du M'zab."
        AppLanguage.ENGLISH -> "GDG Ghardaïa is a non-profit technology community uniting students, developers, and innovators passionate about Google technologies and open source. The community fosters peer learning, hands-on technical workshops, and local software talent empowerment in the M'zab Valley."
    }

    fun aboutGDGMission(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "أهداف ورسالة النادي"
        AppLanguage.FRENCH -> "Mission & Objectifs"
        AppLanguage.ENGLISH -> "Mission & Objectives"
    }

    fun devfestHeroDesc(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "ديف فيست (DevFest) هو أكبر مؤتمر تقني سنوي يقوده المطورون تحت مظلة مجتمعات مطوري غوغل حول العالم. يجمع المهرجان نخبة المطورين والمهتمين بالتقنية لاكتشاف أحدث التقنيات وبناء شبكات مهنية هادفة."
        AppLanguage.FRENCH -> "DevFest est la conférence annuelle phare animée par les communautés de développeurs à travers le monde. Il offre un espace privilégié d'apprentissage, de pratique et de rencontre autour des technologies émergentes."
        AppLanguage.ENGLISH -> "DevFest is the annual developer conference led by Google Developer Groups worldwide. It offers a dedicated space for hands-on learning, practical technical exploration, and community collaboration."
    }

    fun devfestDateLocation(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "التاريخ والموقع"
        AppLanguage.FRENCH -> "Date & Lieu"
        AppLanguage.ENGLISH -> "Date & Location"
    }

    fun devfestDateValue(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "25 نوفمبر 2026 • غرداية، الجزائر"
        AppLanguage.FRENCH -> "25 Novembre 2026 • Ghardaïa, Algérie"
        AppLanguage.ENGLISH -> "25 November 2026 • Ghardaïa, Algeria"
    }

    fun devfestLocationNote(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "سيتم الإعلان عن تفاصيل القاعات والمقر بالتحديد عبر المنصات الرسمية للمجتمع."
        AppLanguage.FRENCH -> "Les détails précis du lieu seront confirmés par les organisateurs sur nos canaux officiels."
        AppLanguage.ENGLISH -> "Exact venue and hall arrangements will be officially announced on verified club channels."
    }

    fun registrationNotice(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "تفاصيل الحضور والتسجيل في ديف فيست ستنشر عبر القنوات الرسمية عند اعتمادها."
        AppLanguage.FRENCH -> "Les modalités de participation et d'inscription à DevFest seront publiées sur nos canaux officiels."
        AppLanguage.ENGLISH -> "DevFest attendance details will be announced through verified club channels upon confirmation."
    }

    fun membershipDistinction(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "ملاحظة هامة: استمارة الانضمام مخصصة لعضوية النادي والمجتمع على مدار العام، وهي منفصلة عن بطاقات حضور فعالية ديف فيست."
        AppLanguage.FRENCH -> "Note importante : Le formulaire d'adhésion concerne la communauté annuelle et est distinct de l'accès à DevFest."
        AppLanguage.ENGLISH -> "Important note: The membership form is for year-round community joining, distinct from DevFest event attendance."
    }

    fun programNotice(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "الجدول الزمني المبدئي للفعالية. سيتم نشر قائمة المتحدثين والفقرات التفصيلية تباعاً بعد تأكيد المنظمين."
        AppLanguage.FRENCH -> "Programme indicatif de la journée. Les intervenants et horaires définitifs seront publiés dès validation."
        AppLanguage.ENGLISH -> "Provisional event schedule. Detailed speaker line-up and timetable will be announced as confirmed by organizers."
    }

    // Developer Section labels
    fun developerRoleTitle(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "المطور والمصمم"
        AppLanguage.FRENCH -> "Développeur & Designer"
        AppLanguage.ENGLISH -> "Developer & Designer"
    }

    fun developerAcademic(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "المستوى الدراسي"
        AppLanguage.FRENCH -> "Niveau Académique"
        AppLanguage.ENGLISH -> "Academic Level"
    }

    fun developerFaculty(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "الكلية"
        AppLanguage.FRENCH -> "Faculté"
        AppLanguage.ENGLISH -> "Faculty"
    }

    fun developerCommunity(lang: AppLanguage) = when (lang) {
        AppLanguage.ARABIC -> "المجتمع"
        AppLanguage.FRENCH -> "Communauté"
        AppLanguage.ENGLISH -> "Community"
    }
}
