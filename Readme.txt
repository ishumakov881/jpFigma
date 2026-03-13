{
  "mcpServers": {
    "figma": {
      "httpUrl": "https://mcp.figma.com/mcp"
    },
    "github": {
      "httpUrl": "https://api.githubcopilot.com/mcp/",
      "headers": {
        "Authorization": "Bearer <@token@>"
      }
    },
    "gitlab": {
      "httpUrl": "https://gitlab.com/api/v4/mcp"
    },
    "canva": {
      "httpUrl": "https://mcp.canva.com/mcp"
    },
    "notion": {
      "httpUrl": "https://mcp.notion.com/mcp"
    },
    "linear": {
      "httpUrl": "https://mcp.linear.app/mcp"
    }
  }
}

https://medium.com/google-cloud/gemini-cli-figma-mcp-server-turn-design-into-code-in-minutes-88ba219615c6
Figma Desktop должен быть установлен в системе


===
Посмотри что обомне известно в Figma MCP
https://www.figma.com/design/WlbRfW8lDIzFqMAxboEtjj/LDS---LK----2024?node-id=794-22346&t=n831yFhbNv7KEtyS-4
===

===
Это промпт для моего ИИ агента программиста, оцени что тут звучит неоднозначно и неверно может трактоваться ИИ
@@@@@ Agent Figma to Jetcpack Compose Code @@@@@@


С помощью Figma MCP tool / Figma API / node data, Создай Jetpack Compose код для разметки (генерировать только UI слой Jetpack Compose), в нашем проекте
Используя из макета Figma node "Услуга Уведомления": https://www.figma.com/design/WlbRfW8lDIzFqMAxboEtjj/LDS---LK----2024?node-id=577-10203&t=PW4WvZ4ZlZ2O6pHv-4
Требование к коду:
Компоненты UI не хранить в полученном *Screen.kt, а нужно положить в пакет components
Скрин содержит @Preview
Данные которые отображены в UI и по логике должны менятся - нужно передавать как параметры функции
Требования к компонентам:
Если компонент принимает modifier, он должен быть первым параметром, например modifier = Modifier
Бро, все демоданные скринов держи в классе MockData
Давай не будем передавать данные для отображения в скрин, мы позже в самом скрине будем подгружать из сети, поэтому сейчас, мы в самом скрине должны брать данные из MockData передать можно все что с данными не связано, например title скрина и прочее   
Запрещено добавлять в код то чего нет в макете, запрещено ссылаться на иные источники типа скриншотов и макетов.
Уровень детализации 10/10

@@ Для компонентов AsyncImage которые загружают из сети должен быть предусмотрен плейсхолдер на случай ошибки загрузки страницы, а лучше использовать SubcomposeAsyncImage
===
Добавь в код проекта ViewModel, при клике на Strat Test случайные данные отображаются в нашем UI SpeedTestScreen
Состояние в ViewModel для теста это sealed class


!!!!!!!!!!! Агент Шиммер
!!!! Агент + mvvw (he use shemmier + generated module)