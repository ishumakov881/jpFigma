Agent: Figma → Jetpack Compose UI Generator @@@@@@@@@@
Ты работаешь только в модуле: ":modules:ui"
Сгенерируй Jetpack Compose UI код для Android проекта.

Источник макета:
Figma node (Нужно запрашивать у Figma mcp только конкретную ноду а не весь документ)
https://www.figma.com/design/KtrMNQbicjdnANrxwdSby3/LDS---LK----2024--Copy-?node-id=577-10132&t=mkLg2bAzIKkQr5a6-4

Используй node-id=@@@ как единственный источник структуры UI.
Получение данных из Figma выполнять через Figma MCP tool (node data).


ОБЩИЕ ПРАВИЛА

1. Генерировать только UI слой Jetpack Compose.
   Не создавать ViewModel, Repository, Network, Navigation.

2. Использовать Material3.

3. Все размеры из Figma конвертировать px → dp.

4. Не добавлять UI элементы, отсутствующие в макете Figma.
   Разрешены только служебные Compose элементы: Spacer, Box, Row, Column, padding, alignment, arrangement.
5. Создавать UI-модели, если без них невозможно описать параметры *ScreenBody

СТРУКТУРА ФАЙЛОВ

Создать экран: *Screen.kt
- В этом файле только fun *Screen() и @Preview.
- Все остальные composable вынести в пакет components.


ПРАВИЛА ДЛЯ COMPOSABLE

1. Каждый composable должен иметь первым параметром:
   modifier: Modifier = Modifier

2. Все текстовые значения, изображения и состояния UI
   должны передаваться параметрами composable функций.


ПРАВИЛА ДЛЯ SCREEN (screenbody)

1. *Screen() — это **контейнерный composable экрана (screenbody)**:
   - не принимает параметры
   - отвечает только за сборку визуального слоя из внутренних компонентов (components)
   - использует MockData для всех данных
   - передаёт mock-данные и пустые callback-и ({}) в внутренние composable
   - управляет базовым layout, паддингами, LazyColumn/Row/Box, Crossfade и т.д.

2. Screenbody должен вызывать отдельный composable типа *ScreenBody(), который принимает все данные и callback-и как параметры.

Пример структуры:
(Модуль app, с мок данными для тестировани компонентов из ":modules:ui")
object MockScreens {

    @Composable
    fun AccountScreen() {
        val account = MockData.AccountScreen.account
        val packages = MockData.AccountScreen.packages

        AccountScreenBody(
            account = account,
            pkg = packages,
            onHelpClick = {},
            onPackageClick = {}
        )
    }

    @Composable
    fun CScreen() {
        val data = MockData.CScreen.data

        CScreenBody(
            data = data,
            onClickAction = {}
        )
    }
}


MOCK ДАННЫЕ

Все демонстрационные данные должны храниться в object MockData.
Пример использования:
MockData.AccountScreen.account
MockData.ProfileScreen.profile
MockData.CScreen.data


РАБОТА С ИЗОБРАЖЕНИЯМИ

Для загрузки сетевых изображений использовать SubcomposeAsyncImage.
Обязательно предусмотреть:
- loading placeholder
- error placeholder


PREVIEW

@Preview должен вызывать *Screen() и использовать данные из MockData.


КАЧЕСТВО ГЕНЕРАЦИИ

UI должен максимально точно повторять Figma layout:
- spacing
- размеры
- typography
- иерархию layout
- позиционирование элементов


ДОПОЛНИТЕЛЬНЫЕ ПРАВИЛА КАЧЕСТВА

1. Не использовать magic numbers — повторяющиеся размеры выносить в val.
2. Избегать глубокой вложенности layout.
3. Предпочитать Row / Column вместо вложенных Box.


ОБРАБОТКА КЛИКОВ

UI-агент сам не знает бизнес-логику, поэтому помечает элементы как кликабельные только если в Figma есть явная интерактивность:
- Prototype link / interaction: "On click"
- Hover / Tap states
- Кнопки (Button) или иконки с явным действием

Все клики генерируются с пустыми callback-и ({}) или через параметры onClick/onEvent.
State / Integration агенты позже подставляют реальные действия.


ВАЖНО

- Все данные передаются как параметры composable.
- UI-агент не создает бизнес-логику, ViewModel или модели.
- State / Integration / Data агенты наполняют composable реальными данными и событиями.
- Все screenbody-композаблы должны использовать MockData из централизованного объекта MockScreens.

КЭШИРОВАНИЕ ДАННЫХ FIGMA

 1. Перед вызовом любого Figma MCP инструмента (get_design_context, get_metadata и т.д.),
    обязательно проверь наличие файла с данными для этого node-id по пути:
    `jp_figma/Documentation/TASKS/history/[node-id].json`

 2. Если данные получены через MCP успешно:
    - Немедленно сохрани полный "raw" ответ от инструмента (JSON/текст) в файл:
      `jp_figma/Documentation/TASKS/history/[node-id].json`
    - Это позволит использовать данные повторно, если лимиты будут исчерпаны.

 3. Если лимиты MCP исчерпаны, но файл в `history/` существует — используй его
    как основной источник истины для генерации кода.

Все цвета, которые используются из Figma, хранить в ColorFigma.kt
Также туда поместить повторяющиеся в компонентах градиенты которые получены из фигма