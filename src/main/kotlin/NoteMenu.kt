class NoteMenu(private val archive: Archive) : Menu<Note>(
    items = archive.notes,
    title = Messages.NOTE_LIST.format(archive.name),
    itemName = { it.title },
    onSelect = { index -> NoteMenu(archive).showNoteContent(index) }
) {
    private fun showNoteContent(index: Int) {
        val note = archive.notes[index]
        println("\n${Messages.NOTE_TITLE.format(note.title)}")
        println("${Messages.NOTE_CONTENT.format(note.content)}")
        println(Messages.EXIT_OPTION.text)

        while (scanner.nextLine() != "0") {
            println(Messages.ERROR_INVALID_OPTION.text)
        }
    }

    override fun onCreate() {
        println(Messages.CREATE_NOTE.text)
        val title = getInput(Messages.CREATE_NOTE_TITLE.text, Messages.ERROR_BLANK_NAME.text)
        val content = getInput(Messages.CREATE_NOTE_CONTENT.text, Messages.ERROR_BLANK_CONTENT.text)

        archive.notes.add(Note(title, content))
        println(Messages.NOTE_CREATED.format(title))
    }
}
