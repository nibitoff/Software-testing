package main.java.task3;

public class Captain extends Human {

    public Captain(String name, String emotion, Room location){
        super(name, emotion, location);
    }

    public void openBook(Notebook notebook) {
        notebook.open();
        System.out.println("Notebook was opened by the [captain] " + this.getName() + ". " +
                " The current page is " + notebook.getCurrentPage() + ".");
    }

    public void closeBook(Notebook notebook) {
        notebook.close();
        System.out.println("Notebook was closed by the [captain] " + this.getName() + ". " +
                " The current page is " + notebook.getCurrentPage() + ".");
    }

    public void flipPages(Notebook notebook, Integer newPage) {
        notebook.setCurrentPage(newPage);
        System.out.println("The [captain] " + this.getName() +  " flipped the notebook to page " + newPage + "." +
            " The current page is " + notebook.getCurrentPage() + ".");
    }
}
