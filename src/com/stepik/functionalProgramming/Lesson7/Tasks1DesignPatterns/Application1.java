package com.stepik.functionalProgramming.Lesson7.Tasks1DesignPatterns;

/*You need to implement the Command pattern using a functional
 approach to avoid creating unnecessary classes. There are three commands to be implemented: save to clipboard,
 paste, and select all.
In order to implement the pattern, create the Command interface that has the execute method and the Executor
class with the executeCommand method that accepts a command and executes it.
In the run method of the Application class, execute mentioned commands in the following order:
Select all.
Save the selection to the clipboard.
Paste value from the clipboard.
Sample Input 1:
file text
Sample Output 1:
selecting all: "file text"
saving "file text" to clipboard
replacing selection to "file text"
Sample Input 2:
Lorem ipsum dolor sit amet
Sample Output 2:
selecting all: "Lorem ipsum dolor sit amet"
saving "Lorem ipsum dolor sit amet" to clipboard
replacing selection to "Lorem ipsum dolor sit amet"*/


// create Command interface and Executor class here
interface Command{
    void execute();
}
class Executor{
    void executeCommand(Command command){
        command.execute();
    }
}

class Application1 {

    private final Executor executor;
    private final Editor editor;

    public Application1(Executor executor, Editor editor) {
        this.executor = executor;
        this.editor = editor;
    }

    void run() {
        // write your code here
        executor.executeCommand(editor::selectAll);
        executor.executeCommand(editor::getSelection);
        editor.saveToClipboard(editor.getSelection());
        executor.executeCommand(editor::getClipboard);
        editor.replaceSelection(editor.getClipboard());

        /*executor.executeCommand(editor::selectAll);
        executor.executeCommand(() -> editor.saveToClipboard(editor.getSelection()));
        executor.executeCommand(() -> editor.replaceSelection(editor.getClipboard()));*/
    }
}

interface Editor {

    /**
     * Select all text.
     */
    void selectAll();

    /**
     * Returns previously selected text.
     */
    String getSelection();

    /**
     * Replaces selected text with the specified value.
     *
     * @param value the text that replaces selected text
     */
    void replaceSelection(String value);

    /**
     * Returns text in the clipboard.
     */
    String getClipboard();

    /**
     * Saves provided value to the clipboard.
     *
     * @param value the text that will be saved to the clipboard
     */
    void saveToClipboard(String value);
}
