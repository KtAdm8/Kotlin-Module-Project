class ArchiveMenu : Menu<Archive>(
    items = archives,
    title = Messages.ARCHIVE_LIST.text,
    itemName = { it.name },
    onSelect = { index -> NoteMenu(archives[index]).show() }
) {
    override fun onCreate() {
        val name = getInput(Messages.CREATE_ARCHIVE.text, Messages.ERROR_BLANK_NAME.text)
        archives.add(Archive(name))
        println(Messages.ARCHIVE_CREATED.text.format(name))
    }
}
