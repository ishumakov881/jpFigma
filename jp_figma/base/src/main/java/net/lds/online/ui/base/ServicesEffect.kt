package net.lds.online.ui.base

/**
 * Базовый интерфейс для всех Side-эффектов (навигация, тосты и т.д.)
 */
interface ServicesEffect

/**
 * Общий эффект для отображения уведомлений, используемый во всех ViewModel
 */
data class ShowToast(val message: String) : ServicesEffect

/**
 * Эффект навигации
 */
interface NavigationEffect : ServicesEffect
