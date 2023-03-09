package main.java.task3;

public class Notebook {
    private boolean opened;
    private int currentPage;
    private int maxPage;

    public Notebook(boolean status, int currentPage, int maxPage) {
        this.opened = status;
        this.currentPage = currentPage;
        this.maxPage = maxPage;
    }

    public Notebook() {
    }

    public boolean isOpened() {
        return opened;
    }

    public void open() {
        this.opened = true;
    }
    public void close() {
        this.opened = true;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if ( opened && currentPage <= this.maxPage && currentPage > 0){
            this.currentPage = currentPage;
        }
    }

    public int getMaxPage() {
        return maxPage;
    }

    public void setMaxPage(int maxPage) {
        this.maxPage = maxPage;
    }
}
