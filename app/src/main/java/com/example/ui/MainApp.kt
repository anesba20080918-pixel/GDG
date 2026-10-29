package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.example.R
import com.example.localization.AppStrings
import com.example.model.AppLanguage
import com.example.model.NavDestination
import com.example.model.ThemeMode
import com.example.ui.components.GoogleColorsBar
import com.example.ui.screens.*
import com.example.ui.theme.GDGGhardaiaTheme
import com.example.ui.theme.GoogleBlue
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp() {
    var currentLanguage by remember { mutableStateOf(AppLanguage.ENGLISH) }
    var currentTheme by remember { mutableStateOf(ThemeMode.SYSTEM) }
    var currentScreen by remember { mutableStateOf(NavDestination.HOME) }

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    // Dynamic Layout Direction: RTL for Arabic, LTR for French & English
    val layoutDirection = if (currentLanguage.isRtl) LayoutDirection.Rtl else LayoutDirection.Ltr

    CompositionLocalProvider(LocalLayoutDirection provides layoutDirection) {
        GDGGhardaiaTheme(themeMode = currentTheme) {
            // BackHandler: Return to Home if on secondary screen or close drawer
            BackHandler(enabled = currentScreen != NavDestination.HOME || drawerState.isOpen) {
                if (drawerState.isOpen) {
                    scope.launch { drawerState.close() }
                } else {
                    currentScreen = NavDestination.HOME
                }
            }

            ModalNavigationDrawer(
                drawerState = drawerState,
                drawerContent = {
                    ModalDrawerSheet(
                        modifier = Modifier.width(310.dp)
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            // Drawer Header
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Image(
                                    painter = painterResource(id = R.drawable.ic_gdg_ghardaia),
                                    contentDescription = "GDG Ghardaïa",
                                    modifier = Modifier
                                        .size(44.dp)
                                        .clip(RoundedCornerShape(10.dp))
                                )
                                Spacer(modifier = Modifier.width(12.dp))
                                Column {
                                    Text(
                                        text = "GDG Ghardaïa",
                                        style = MaterialTheme.typography.titleMedium,
                                        fontWeight = FontWeight.Bold
                                    )
                                    Text(
                                        text = "DevFest Ghardaïa 2026",
                                        style = MaterialTheme.typography.labelSmall,
                                        color = MaterialTheme.colorScheme.primary
                                    )
                                }
                            }

                            Spacer(modifier = Modifier.height(14.dp))
                            GoogleColorsBar(modifier = Modifier.fillMaxWidth().clip(RoundedCornerShape(2.dp)))
                            Spacer(modifier = Modifier.height(14.dp))

                            // 6 Main Navigation Items per Section 6
                            NavigationDrawerItem(
                                label = { Text(AppStrings.navHome(currentLanguage)) },
                                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                                selected = currentScreen == NavDestination.HOME,
                                onClick = {
                                    currentScreen = NavDestination.HOME
                                    scope.launch { drawerState.close() }
                                },
                                modifier = Modifier.testTag("drawer_nav_home")
                            )

                            NavigationDrawerItem(
                                label = { Text(AppStrings.navAboutGDG(currentLanguage)) },
                                icon = { Icon(Icons.Default.Info, contentDescription = null) },
                                selected = currentScreen == NavDestination.ABOUT_GDG,
                                onClick = {
                                    currentScreen = NavDestination.ABOUT_GDG
                                    scope.launch { drawerState.close() }
                                },
                                modifier = Modifier.testTag("drawer_nav_about_gdg")
                            )

                            NavigationDrawerItem(
                                label = { Text(AppStrings.navDevFest(currentLanguage)) },
                                icon = { Icon(Icons.Default.Celebration, contentDescription = null) },
                                selected = currentScreen == NavDestination.DEVFEST,
                                onClick = {
                                    currentScreen = NavDestination.DEVFEST
                                    scope.launch { drawerState.close() }
                                },
                                modifier = Modifier.testTag("drawer_nav_devfest")
                            )

                            NavigationDrawerItem(
                                label = { Text(AppStrings.navProgram(currentLanguage)) },
                                icon = { Icon(Icons.Default.EventNote, contentDescription = null) },
                                selected = currentScreen == NavDestination.PROGRAM,
                                onClick = {
                                    currentScreen = NavDestination.PROGRAM
                                    scope.launch { drawerState.close() }
                                },
                                modifier = Modifier.testTag("drawer_nav_program")
                            )

                            NavigationDrawerItem(
                                label = { Text(AppStrings.navOfficialLinks(currentLanguage)) },
                                icon = { Icon(Icons.Default.Language, contentDescription = null) },
                                selected = currentScreen == NavDestination.OFFICIAL_LINKS,
                                onClick = {
                                    currentScreen = NavDestination.OFFICIAL_LINKS
                                    scope.launch { drawerState.close() }
                                },
                                modifier = Modifier.testTag("drawer_nav_links")
                            )

                            NavigationDrawerItem(
                                label = { Text(AppStrings.navDeveloper(currentLanguage)) },
                                icon = { Icon(Icons.Default.Person, contentDescription = null) },
                                selected = currentScreen == NavDestination.DEVELOPER,
                                onClick = {
                                    currentScreen = NavDestination.DEVELOPER
                                    scope.launch { drawerState.close() }
                                },
                                modifier = Modifier.testTag("drawer_nav_developer")
                            )

                            Spacer(modifier = Modifier.weight(1f))
                            HorizontalDivider()
                            Spacer(modifier = Modifier.height(10.dp))

                            Text(
                                text = AppStrings.madeWithCareBy(currentLanguage),
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            )
                        }
                    }
                }
            ) {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            navigationIcon = {
                                IconButton(
                                    onClick = {
                                        scope.launch {
                                            if (drawerState.isClosed) drawerState.open() else drawerState.close()
                                        }
                                    },
                                    modifier = Modifier.testTag("drawer_menu_btn")
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = "Open Navigation Menu"
                                    )
                                }
                            },
                            title = {
                                Text(
                                    text = when (currentScreen) {
                                        NavDestination.HOME -> "GDG Ghardaïa"
                                        NavDestination.ABOUT_GDG -> AppStrings.navAboutGDG(currentLanguage)
                                        NavDestination.DEVFEST -> "DevFest 2026"
                                        NavDestination.PROGRAM -> AppStrings.navProgram(currentLanguage)
                                        NavDestination.OFFICIAL_LINKS -> AppStrings.navOfficialLinks(currentLanguage)
                                        NavDestination.DEVELOPER -> "Anes BA"
                                    },
                                    style = MaterialTheme.typography.titleMedium,
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            actions = {
                                // Language Selector Quick Switch
                                TextButton(
                                    onClick = {
                                        currentLanguage = when (currentLanguage) {
                                            AppLanguage.ENGLISH -> AppLanguage.ARABIC
                                            AppLanguage.ARABIC -> AppLanguage.FRENCH
                                            AppLanguage.FRENCH -> AppLanguage.ENGLISH
                                        }
                                    },
                                    modifier = Modifier.testTag("language_switch_btn")
                                ) {
                                    Text(
                                        text = currentLanguage.displayName,
                                        style = MaterialTheme.typography.labelLarge,
                                        fontWeight = FontWeight.Bold,
                                        color = GoogleBlue
                                    )
                                }

                                // Theme Mode Toggle (System -> Light -> Dark)
                                IconButton(
                                    onClick = {
                                        currentTheme = when (currentTheme) {
                                            ThemeMode.SYSTEM -> ThemeMode.DARK
                                            ThemeMode.DARK -> ThemeMode.LIGHT
                                            ThemeMode.LIGHT -> ThemeMode.SYSTEM
                                        }
                                    },
                                    modifier = Modifier.testTag("theme_mode_toggle_btn")
                                ) {
                                    Icon(
                                        imageVector = when (currentTheme) {
                                            ThemeMode.DARK -> Icons.Default.DarkMode
                                            ThemeMode.LIGHT -> Icons.Default.LightMode
                                            ThemeMode.SYSTEM -> Icons.Default.BrightnessAuto
                                        },
                                        contentDescription = "Toggle Theme"
                                    )
                                }
                            },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = MaterialTheme.colorScheme.surface
                            )
                        )
                    },
                    bottomBar = {
                        NavigationBar(
                            modifier = Modifier.testTag("main_bottom_nav"),
                            containerColor = MaterialTheme.colorScheme.surface,
                            tonalElevation = 4.dp
                        ) {
                            val itemColors = NavigationBarItemDefaults.colors(
                                selectedIconColor = MaterialTheme.colorScheme.primary,
                                selectedTextColor = MaterialTheme.colorScheme.primary,
                                indicatorColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.14f),
                                unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.72f)
                            )

                            NavigationBarItem(
                                selected = currentScreen == NavDestination.HOME,
                                onClick = { currentScreen = NavDestination.HOME },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Home,
                                        contentDescription = AppStrings.navHome(currentLanguage),
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                alwaysShowLabel = false,
                                colors = itemColors,
                                modifier = Modifier.testTag("bottom_nav_home")
                            )

                            NavigationBarItem(
                                selected = currentScreen == NavDestination.ABOUT_GDG,
                                onClick = { currentScreen = NavDestination.ABOUT_GDG },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Groups,
                                        contentDescription = AppStrings.navAboutGDG(currentLanguage),
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                alwaysShowLabel = false,
                                colors = itemColors,
                                modifier = Modifier.testTag("bottom_nav_about_gdg")
                            )

                            NavigationBarItem(
                                selected = currentScreen == NavDestination.DEVFEST,
                                onClick = { currentScreen = NavDestination.DEVFEST },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Celebration,
                                        contentDescription = AppStrings.navDevFest(currentLanguage),
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                alwaysShowLabel = false,
                                colors = itemColors,
                                modifier = Modifier.testTag("bottom_nav_devfest")
                            )

                            NavigationBarItem(
                                selected = currentScreen == NavDestination.PROGRAM,
                                onClick = { currentScreen = NavDestination.PROGRAM },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.EventNote,
                                        contentDescription = AppStrings.navProgram(currentLanguage),
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                alwaysShowLabel = false,
                                colors = itemColors,
                                modifier = Modifier.testTag("bottom_nav_program")
                            )

                            NavigationBarItem(
                                selected = currentScreen == NavDestination.OFFICIAL_LINKS,
                                onClick = { currentScreen = NavDestination.OFFICIAL_LINKS },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Language,
                                        contentDescription = AppStrings.navOfficialLinks(currentLanguage),
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                alwaysShowLabel = false,
                                colors = itemColors,
                                modifier = Modifier.testTag("bottom_nav_links")
                            )

                            NavigationBarItem(
                                selected = currentScreen == NavDestination.DEVELOPER,
                                onClick = { currentScreen = NavDestination.DEVELOPER },
                                icon = {
                                    Icon(
                                        imageVector = Icons.Default.Person,
                                        contentDescription = AppStrings.navDeveloper(currentLanguage),
                                        modifier = Modifier.size(24.dp)
                                    )
                                },
                                alwaysShowLabel = false,
                                colors = itemColors,
                                modifier = Modifier.testTag("bottom_nav_developer")
                            )
                        }
                    }
                ) { innerPadding ->
                    Crossfade(
                        targetState = currentScreen,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) { targetScreen ->
                        when (targetScreen) {
                            NavDestination.HOME -> HomeScreen(
                                language = currentLanguage,
                                onNavigate = { destination -> currentScreen = destination }
                            )
                            NavDestination.ABOUT_GDG -> AboutGDGScreen(language = currentLanguage)
                            NavDestination.DEVFEST -> DevFestScreen(language = currentLanguage)
                            NavDestination.PROGRAM -> ProgramScreen(language = currentLanguage)
                            NavDestination.OFFICIAL_LINKS -> OfficialLinksScreen(language = currentLanguage)
                            NavDestination.DEVELOPER -> DeveloperScreen(language = currentLanguage)
                        }
                    }
                }
            }
        }
    }
}
