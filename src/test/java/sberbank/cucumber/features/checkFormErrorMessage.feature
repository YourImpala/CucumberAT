Feature: Страхование
  Scenario: Ошибка при неполном заполнении формы страхования путешественников
    Given Перейти на сайт 'http://www.sberbank.ru/ru/person_ab_elena'
    Then Нажать на пункт навигации 'Страхование'
    Then Нажать на пункт выпадающего меню 'Страхование путешественников'
    Then Проверить наличие на странице заголовка 'Страхование путешественников'
    Then Нажать на кнопку Оформить Онлайн
    Then Выбрать полис - 'Минимальная'
    Then Проверить выбор полиса - 'Минимальная'
    Then Нажать кнопку Оформить
    Then Заполнить поля формы
      |застрахованные_фамилия      |Пупкин     |
      |застрахованные_имя          |Петя       |
      |застрахованные_дата_рождения|12.12.1990 |
      |страхователь_фамилия        |Нестеров   |
      |страхователь_имя            |Эдмунд     |
      |страхователь_отчество       |Арагорнович|
      |страхователь_дата_рождения  |12.12.2000 |
      |паспорт_серия               |1234       |
      |паспорт_номер               |123456"    |
      |паспорт_дата_выдачи         |12.12.2015 |
      |паспорт_кем_выдан           |Отделом"   |
    Then Проверить заполнение полей
      |застрахованные_фамилия      |Пупкин     |
      |застрахованные_имя          |Петя       |
      |застрахованные_дата_рождения|12.12.1990 |
      |страхователь_фамилия        |Нестеров   |
      |страхователь_имя            |Эдмунд     |
      |страхователь_отчество       |Арагорнович|
      |страхователь_дата_рождения  |12.12.2000 |
      |паспорт_серия               |1234       |
      |паспорт_номер               |123456"    |
      |паспорт_дата_выдачи         |12.12.2015 |
      |паспорт_кем_выдан           |Отделом"   |
    
    Then Нажать кнопку продолжить
    Then Проверить сообщение об ошибке - 'При заполнении данных произошла ошибка'