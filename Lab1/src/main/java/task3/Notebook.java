package main.java.task3;

public class Notebook {
    private boolean status;
    private int currentPage;
    private int maxPage;

    public Notebook(boolean status, int currentPage, int maxPage) {
        this.status = status;
        this.currentPage = currentPage;
        this.maxPage = maxPage;
    }

    public Notebook() {
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        if ((currentPage <= this.maxPage) && currentPage > 0){
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
