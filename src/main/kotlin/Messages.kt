enum class Messages(val text: String) {
    ERROR_INVALID_OPTION("Ошибка: неверный ввод. Попробуйте снова."),
    CREATE("Создать"),
    EXIT("Выход"),
    NOTE_LIST("Список заметок для архива '%s'"),
    NOTE_TITLE("Заголовок заметки: %s"),
    NOTE_CONTENT("Текст заметки: %s"),
    CREATE_NOTE("Создать новую заметку"),
    CREATE_NOTE_TITLE("Введите название заметки: "),
    CREATE_NOTE_CONTENT("Введите текст заметки: "),
    NOTE_CREATED("Заметка '%s' успешно создана."),
    ARCHIVE_LIST("Список архивов"),
    CREATE_ARCHIVE("Введите название нового архива: "),
    ARCHIVE_CREATED("Архив '%s' успешно создан."),
    ERROR_BLANK_NAME("Ошибка: название не может быть пустым. Повторите ввод."),
    ERROR_BLANK_CONTENT("Ошибка: текст заметки не может быть пустым. Повторите ввод."),
    EXIT_OPTION("0. Вернуться назад");

    fun format(vararg args: Any): String = String.format(text, *args)
}
