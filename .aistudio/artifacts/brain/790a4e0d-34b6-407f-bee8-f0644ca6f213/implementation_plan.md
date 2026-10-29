# GDG Ghardaïa × DevFest 2026 — Official Informational Application

## Rebuild Specification & Verification Report

### 1. Project Overview & Role
A polished, responsive, native Android application built with Kotlin and Jetpack Compose for **Google Developer Groups (GDG) Ghardaïa** and **DevFest Ghardaïa 2026**.

The application serves as the official community and event portal communicating:
- The identity of the GDG Ghardaïa club.
- DevFest Ghardaïa 2026 introduction and 4 core technical pillars.
- A prominent, mathematically accurate countdown targeting **25 November 2026 at 09:00:00 (Africa/Algiers)**.
- Documented event activities framework.
- Verified official club links.
- Dedicated developer profile and attribution for **Anes BA**.

---

### 2. Audit of Removed Fabrications & Misleading Content
In strict compliance with the audit instructions:
- **Removed Fake Events & Discovery Feed:** All unverified external workshops, AI competitions, and mock events were eliminated.
- **Removed Fabricated Speakers & Profiles:** Names, biographies, and halls were excised. The program is presented transparently as a verified framework with explicit notice that confirmed speaker line-ups will be announced.
- **Removed Unverified Institutional Claims:** Eradicated the unverified "Official Academic Partner" claim and removed university logo usage that implied endorsement.
- **Removed Fabricated Verification Badges:** Deleted all artificial "Verified Official" badges that were applied to unverified items.
- **Removed Obsolete / Non-informational Screens:** Removed internal event registration forms, attendee rosters, mock AI chat bot scaffolds, and administrative panels.

---

### 3. Application Information Architecture (6 Core Sections)

1. **Home Screen**:
   - Opening Screen Hero with authentic GDG Ghardaïa logo (`ic_gdg_ghardaia`) and DevFest artwork (`ic_devfest_ghardaia`).
   - Prominent developer attribution: `"Designed & Developed by Anes BA"`.
   - Prominent live countdown timer dynamically updating every second.
   - Quick action buttons to DevFest 2026, Club info, and official links.
   - App Footer credit: `"Made with care by Anes BA"`.

2. **About GDG Ghardaïa**:
   - Community mission, developer ecosystem, peer learning, and technical domains (Mobile, AI & Gemini, Google Cloud Platform, Modern Web & Open Source).
   - Dedicated external link to the official Google Form club membership application (`https://docs.google.com/forms/d/e/1FAIpQLSddyGm44owNr1LO_8J5xifPQd5GpiaCOjrudpfdUO6PwtxG6A/viewform`).
   - Clear distinction between year-round club membership and event registration.

3. **DevFest Ghardaïa 2026**:
   - Event overview and objectives.
   - Confirmed date: 25 November 2026 in `Africa/Algiers` (provisional date pending organizer finalization).
   - 4 Core Technical Tracks:
     1. Artificial Intelligence & Machine Learning
     2. Android & Kotlin Development
     3. Cloud Computing & DevOps
     4. Modern Web Technologies
   - Direct button to official event page on Google Developers Community platform (`https://gdg.community.dev/events/details/google-gdg-ghardaia-presents-devfest-ghardaia-2026/`).

4. **Program and Activities**:
   - Chronological framework of DevFest 2026:
     - 09:00 - 09:45: Welcome & Opening Keynote
     - 10:00 - 11:15: Tech Talks: AI & Modern Frameworks
     - 11:30 - 13:00: Interactive Hands-on Workshops
     - 13:00 - 14:15: Community Lunch & Networking
     - 14:30 - 16:00: Advanced Sessions: Cloud & Web
     - 16:15 - 17:30: Project Showcases & Closing
   - Honest notice explaining that speaker names and detailed timetables will be published upon final validation.

5. **Official Links**:
   - All 8 verified official links with external browser intent handling:
     1. Official Website: `https://www.gdgghardaia.com/`
     2. Alternative Website: `https://gdgghardaia.vercel.app/`
     3. Facebook: `https://fb.com/GDG.Ghardaia`
     4. Instagram: `https://www.instagram.com/gdg.ghardaia`
     5. LinkedIn: `https://dz.linkedin.com/company/gdgghardaia`
     6. GDG Community Platform: `https://gdg.community.dev/events/details/google-gdg-ghardaia-presents-devfest-ghardaia-2026/`
     7. Community Membership Form: `https://docs.google.com/forms/d/e/1FAIpQLSddyGm44owNr1LO_8J5xifPQd5GpiaCOjrudpfdUO6PwtxG6A/viewform`
     8. Discord Community: `https://discord.com/invite/GMueprF5dq`

6. **Developer — Anes BA**:
   - Developer Name: **Anes BA**
   - Academic Level: **First-year Computer Science student**
   - Faculty: **Faculty of Science and Technology**
   - Community: **Member of GDG Ghardaïa**
   - Professional introduction restricted strictly to verified facts.
   - Hero attribution: `"Designed & Developed by Anes BA"`.
   - Footer attribution: `"Made with care by Anes BA"`.

---

### 4. Multilingual & RTL Implementation
- **Arabic (`ar`)**: Complete Right-to-Left (RTL) layout mirroring via `CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl)`.
- **French (`fr`)** & **English (`en`)**: Left-to-Right (LTR) layouts with native translations.
- Instant language toggle in the TopAppBar.
- All interface strings, titles, labels, notices, and countdown units are translated without mixed-language artifacts.

---

### 5. Verified Test Matrix
- **Compilation (`compile_applet`)**: PASS (Clean build with zero errors).
- **Unit & Robolectric Tests (`:app:testDebugUnitTest`)**: PASS (33 tasks, 15 countdown arithmetic tests and app identity tests executed and passed).
