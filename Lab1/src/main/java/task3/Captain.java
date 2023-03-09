package main.java.task3;

public class Captain extends Human{

    public void openBook(Notebook notebook){
        notebook.setStatus(true);
        System.out.println("Notebook was opened by the Captain. " +
                "The current page is" + notebook.getCurrentPage());
    }

    public void closeBook(Notebook notebook){
        notebook.setStatus(false);
        System.out.println("Notebook was closed by the Captain. " +
                "The current page is" + notebook.getCurrentPage());
    }

    public void flipPages(Notebook notebook, Integer newPage){
        notebook.setCurrentPage(newPage);
        System.out.println("The Captain flipped the notebook to page №" + notebook.getCurrentPage());
    }
}
